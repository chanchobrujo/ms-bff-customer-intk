package com.demo.bff_customer_intk.model;

import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public abstract class _AffiliationModel {
    private String id;
    private String productId;
    private BigDecimal amount;
    private String productName;
    private Instant createdDate;
}
