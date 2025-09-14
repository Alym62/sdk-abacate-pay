package com.github.Alym62.sdk.utils;

import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Setter
@ToString
public class AbacatePayResponse<T> {
    private T data;
}
