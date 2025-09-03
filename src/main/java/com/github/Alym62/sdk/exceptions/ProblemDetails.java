package com.github.Alym62.sdk.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Alyasaf Meireles
 * Class that will be used to follow the RFC error standard in an API
 */

@Getter
@Setter
@NoArgsConstructor
public class ProblemDetails {
    private String instance;
    private String title;
    private int status;
    private String message;
}
