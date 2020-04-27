package com.kiwi.restcountries.entity;

import lombok.Data;

/**
 * Pojo describing the currency of a {@link Country}.
 */
@Data
public class Currency {
    private String code;
    private String name;
    private String symbol;
}
