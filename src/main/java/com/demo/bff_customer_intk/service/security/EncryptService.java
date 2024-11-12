package com.demo.bff_customer_intk.service.security;

import com.demo.bff_customer_intk.properties.SecurityProperties;
import com.stater.intk.model.exception.BusinessException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.stater.intk.util.SecurityUtil.decryptString;

@Slf4j
@Service
@RequiredArgsConstructor
public class EncryptService implements IEncryptService {
    private final SecurityProperties properties;

    public String decrypt(String header) {
        try {
            return decryptString(header, this.properties.generateKey());
        } catch (Exception e) {
            log.error(e.getMessage());
            throw new BusinessException("Error en el servicio.");
        }
    }
}
