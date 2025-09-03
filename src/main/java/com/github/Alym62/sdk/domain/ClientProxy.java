package com.github.Alym62.sdk.domain;

import com.github.Alym62.sdk.annotations.CPF;
import com.github.Alym62.sdk.annotations.Required;
import com.github.Alym62.sdk.processors.CPFProcessor;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alyasaf Meireles
 * Class will serve as a proxy to implement extra behaviors following the pattern - Proxy
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ClientProxy {
    @Required(name = "name")
    private String name;

    @Required(name = "cellPhone")
    private String cellPhone;

    @Required(name = "email")
    private String email;

    @Required(name = "taxId")
    @CPF
    private String taxId;

    public void setTaxId(String taxId) {
        this.taxId = taxId;
        CPFProcessor.process(this);
    }
}
