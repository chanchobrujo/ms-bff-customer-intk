package com.demo.bff_customer_intk.properties;

import com.stater.intk.util.SecurityUtil;
import lombok.Getter;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import javax.crypto.SecretKey;
import java.security.spec.InvalidKeySpecException;

@Getter
@ToString
@Configuration
public class SecurityProperties {
    @Value("${security.salt}")
    private String salt;
    @Value("${security.password}")
    private String password;

    public SecretKey generateKey() throws InvalidKeySpecException {
        return SecurityUtil.getSecretKeyFromPassword(this.getPassword(), this.getSalt());
    }
}
