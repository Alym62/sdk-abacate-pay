package com.github.Alym62.sdk.domain;

import com.github.Alym62.sdk.annotations.CPF;
import com.github.Alym62.sdk.annotations.Email;
import com.github.Alym62.sdk.annotations.Required;
import com.github.Alym62.sdk.processors.CPFProcessor;
import com.github.Alym62.sdk.processors.EmailProcessor;
import com.github.Alym62.sdk.processors.RequiredProcessor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Alyasaf Meireles
 * Class will serve as a proxy to implement extra behaviors following the pattern - Proxy
 */

@Getter
public class Client {
    @Required(field = "name")
    private String name;

    @Required(field = "cellPhone")
    private String cellPhone;

    @Required(field = "email")
    @Email
    private String email;

    @Required(field = "taxId")
    @CPF
    private String taxId;

    @Builder
    public Client(String name, String cellPhone, String email, String taxId) {
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
}
