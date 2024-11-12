package com.demo.bff_customer_intk.rest.product;

import com.demo.bff_customer_intk.model.response.ms.MsProductResponse;
import reactor.core.publisher.Mono;

public interface IProductRest {
    Mono<MsProductResponse> findProductById(String id, String token);
}
