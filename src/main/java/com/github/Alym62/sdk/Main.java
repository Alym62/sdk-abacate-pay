package com.github.Alym62.sdk;

import com.github.Alym62.sdk.domain.Client;

public class Main {
    public static void main(String[] args) {
        Client client = Client.builder()
                .name("Aly")
                .cellPhone("61993021918")
                .email("al@email.com")
                .taxId("921.871.461-97")
                .build();

        System.out.println(client);
    }
}
