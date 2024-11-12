package com.demo.bff_customer_intk.model.response.ms;

import com.demo.bff_customer_intk.model._CustomerModel;
import com.demo.bff_customer_intk.model.response.api.CustomerResponse;
import com.stater.intk.util.MapperUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
public class MsCustomerResponse extends _CustomerModel {
    private List<MsAffiliationResponse> affiliations = new ArrayList<>();

    public CustomerResponse toResponse() {
        return MapperUtils.objectToObject(this, CustomerResponse.class);
    }
}
