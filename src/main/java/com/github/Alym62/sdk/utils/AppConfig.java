package com.github.Alym62.sdk.utils;

import java.util.ResourceBundle;

/**
 * @author Alyasaf Meireles
 * Class to search configs of file properties SDK
 */
public class AppConfig {
    private AppConfig() {}

    public static ResourceBundle getProperties(final String name) {
        return ResourceBundle.getBundle(name);
    }

    public static String getUrlAbacatePay() {
        final ResourceBundle properties = getProperties("application");
        return properties.getString("url.abacate-pay");
    }
}
