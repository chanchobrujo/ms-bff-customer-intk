package com.demo.bff_customer_intk.service.bff_customer;

import com.demo.bff_customer_intk.model.response.api.CustomerResponse;
import reactor.core.publisher.Mono;

public interface IBffCustomerService {
    Mono<CustomerResponse> findByCode(String code, String token);
}
