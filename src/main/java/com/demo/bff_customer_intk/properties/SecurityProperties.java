package com.demo.bff_customer_intk.properties;

import com.stater.intk.common.utils.SecurityUtils;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;

@Getter
@ToString
@Configuration
public class SecurityProperties {
    @Value("${security.salt}")
    private String salt;
    @Value("${security.password}")
    private String password;

    public SecretKey generateKey() {
        return SecurityUtils.getSecretKey(this.getPassword(), this.getSalt());
    }
}
