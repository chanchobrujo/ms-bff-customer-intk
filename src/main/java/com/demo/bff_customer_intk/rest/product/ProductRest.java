package com.demo.bff_customer_intk.rest.product;

import com.demo.bff_customer_intk.model.response.ms.MsProductResponse;
import com.demo.bff_customer_intk.properties.MicroserviceProperties;
import com.stater.intk.rest._WebClientRest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ProductRest extends _WebClientRest implements IProductRest {
    private final MicroserviceProperties properties;

    @Override
    public Mono<MsProductResponse> findProductById(String id) {
        this.setWebClient(WebClient.builder().build());
        var uri = this.properties.getProducts().concat(id);
        return this.defaultGenericWebClient("GET", uri, null)
                .bodyToMono(MsProductResponse.class);
    }
}
