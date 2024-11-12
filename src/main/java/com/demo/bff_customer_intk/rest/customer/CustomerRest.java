package com.demo.bff_customer_intk.rest.customer;

import com.demo.bff_customer_intk.model.response.ms.MsCustomerResponse;
import com.demo.bff_customer_intk.properties.MicroserviceProperties;
import com.stater.intk.rest._WebClientRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerRest extends _WebClientRest implements ICustomerRest {
    private final MicroserviceProperties properties;

    @Override
    public Mono<MsCustomerResponse> findCustomerById(String id) {
        this.setWebClient(WebClient.builder().build());
        var uri = this.properties.getCustomer().concat(id);
        return this.defaultGenericWebClient("GET", uri, null)
                .bodyToMono(MsCustomerResponse.class);
    }
}
