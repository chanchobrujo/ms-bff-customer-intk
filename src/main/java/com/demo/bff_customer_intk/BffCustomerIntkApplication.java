package com.demo.bff_customer_intk;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
        info = @Info(
                title = "API Bff Customer",
                version = "1.0",
                description = "API que consume a los agentes customer y productos, para entregar una respuesta enriquecida con la data de ambos recursos.",
                contact = @Contact(
                        name = "Kevin Anderson Palma Lluen",
                        url = "https://github.com/chanchobrujo",
                        email = "umb.kevsidorov@gmail.com"
                )
        ))
@SpringBootApplication
public class BffCustomerIntkApplication {

    public static void main(String[] args) {
        SpringApplication.run(BffCustomerIntkApplication.class, args);
    }

}
