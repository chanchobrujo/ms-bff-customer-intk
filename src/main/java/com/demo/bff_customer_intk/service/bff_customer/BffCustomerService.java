package com.demo.bff_customer_intk.service.bff_customer;

import com.demo.bff_customer_intk.model.response.api.AffiliationResponse;
import com.demo.bff_customer_intk.model.response.api.CustomerResponse;
import com.demo.bff_customer_intk.model.response.ms.MsAffiliationResponse;
import com.demo.bff_customer_intk.rest.customer.ICustomerRest;
import com.demo.bff_customer_intk.rest.product.IProductRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

import static reactor.core.publisher.Flux.fromIterable;

@Service
@RequiredArgsConstructor
public class BffCustomerService implements IBffCustomerService {
    private final IProductRest productRest;
    private final ICustomerRest customerRest;

    @Override
    public Mono<CustomerResponse> findByCode(String code) {
        return this.customerRest
                .findCustomerById(code)
                .flatMap(customer -> {
                    var affiliations = customer
                            .getAffiliations()
                            .stream()
                            .map(MsAffiliationResponse::toResponse)
                            .toList();
                    return this.findProducts(customer.toResponse(), affiliations);
                });
    }

    private Mono<CustomerResponse> findProducts(CustomerResponse customer, List<AffiliationResponse> affiliations) {
        return fromIterable(affiliations)
                .flatMap(this::findProduct)
                .collectList()
                .doOnNext(customer::setAffiliationsByCustomer)
                .thenReturn(customer);
    }

    private Mono<AffiliationResponse> findProduct(AffiliationResponse affiliation) {
        return this.productRest
                .findProductById(affiliation.getProductId())
                .doOnNext(product -> affiliation.setProductType(product.getType()))
                .thenReturn(affiliation);
    }
}
