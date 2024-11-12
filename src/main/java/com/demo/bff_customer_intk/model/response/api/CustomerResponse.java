package com.demo.bff_customer_intk.model.response.api;

import com.demo.bff_customer_intk.model._CustomerModel;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class CustomerResponse extends _CustomerModel {
    private List<AffiliationResponse> affiliationsByCustomer = new ArrayList<>();
}
