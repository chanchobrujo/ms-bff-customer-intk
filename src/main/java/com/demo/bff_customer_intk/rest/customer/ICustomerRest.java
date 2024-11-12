package com.demo.bff_customer_intk.rest.customer;

import com.demo.bff_customer_intk.model.response.ms.MsCustomerResponse;
import reactor.core.publisher.Mono;

public interface ICustomerRest {
    Mono<MsCustomerResponse> findCustomerById(String id, String token);
}
