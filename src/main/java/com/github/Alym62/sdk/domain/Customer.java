package com.github.Alym62.sdk.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.Alym62.sdk.annotations.CPF;
import com.github.Alym62.sdk.annotations.Email;
import com.github.Alym62.sdk.annotations.Required;
import com.github.Alym62.sdk.processors.CPFProcessor;
import com.github.Alym62.sdk.processors.EmailProcessor;
import com.github.Alym62.sdk.processors.RequiredProcessor;
import lombok.*;

/**
 * @author Alyasaf Meireles
 * Class of domain with informations in documentation AbacatePay
 */
@Getter
@ToString
@NoArgsConstructor
public class Customer {
    @Required(field = "name")
    @JsonProperty("name")
    private String name;

    @Required(field = "cellPhone")
    @JsonProperty("cellphone")
    private String cellPhone;

    @Required(field = "email")
    @Email
    @JsonProperty("email")
    private String email;

    @Required(field = "taxId")
    @CPF
    @JsonProperty("taxId")
    private String taxId;

    @Builder
    public Customer(String name, String cellPhone, String email, String taxId) {
        this.name = name;
        this.cellPhone = cellPhone;
        this.email = email;
        this.taxId = taxId;

        /**
         * @author Alyasaf Meireles
         * Processors for annotations
         */
        RequiredProcessor.process(this);
        EmailProcessor.process(this);
        CPFProcessor.process(this);
    }

    /**
     * @author Alyasaf Meireles
     * Inner Class of response API AbacatePay
     */
    @Data
    @ToString
    public static class CustomerResponse {
        private String id;
        private Customer metadata;
    }
}
