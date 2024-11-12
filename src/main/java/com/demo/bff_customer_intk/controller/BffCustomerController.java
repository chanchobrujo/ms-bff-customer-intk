package com.demo.bff_customer_intk.controller;

import com.demo.bff_customer_intk.model.response.api.CustomerResponse;
import com.demo.bff_customer_intk.service.bff_customer.IBffCustomerService;
import com.demo.bff_customer_intk.service.security.IEncryptService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bff-customer")
public class BffCustomerController {
    private final IEncryptService encryptService;
    private final IBffCustomerService bffCustomerService;

    @GetMapping
    public ResponseEntity<Mono<CustomerResponse>> findByCode(@RequestHeader(value = "codeEncrypt") String  header) {
        var code = this.encryptService.decrypt(header);
        return ok(this.bffCustomerService.findByCode(code));
    }
}
