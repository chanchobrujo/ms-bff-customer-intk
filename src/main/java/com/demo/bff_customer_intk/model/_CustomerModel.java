package com.demo.bff_customer_intk.model;

import lombok.Data;

@Data
public abstract class _CustomerModel {
    private String fullName;
    private String documentTye;
    private String documentNumber;
}
