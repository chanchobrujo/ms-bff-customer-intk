package com.demo.bff_customer_intk.model.response.api;

import com.demo.bff_customer_intk.model._AffiliationModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class AffiliationResponse extends _AffiliationModel {
    private String productType;
}
