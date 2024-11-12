package com.demo.bff_customer_intk.model.response.ms;

import com.demo.bff_customer_intk.model._AffiliationModel;
import com.demo.bff_customer_intk.model.response.api.AffiliationResponse;
import com.stater.intk.common.utils.MapperUtils;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MsAffiliationResponse extends _AffiliationModel {
    public AffiliationResponse toResponse() {
        return MapperUtils.objectToObject(this, AffiliationResponse.class);
    }
}
