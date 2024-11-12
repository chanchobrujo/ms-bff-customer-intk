package com.demo.bff_customer_intk.properties;

import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Getter
@ToString
@Configuration
public class MicroserviceProperties {
    @Value("${microservices.customer}")
    private String customer;
    @Value("${microservices.products}")
    private String products;
}