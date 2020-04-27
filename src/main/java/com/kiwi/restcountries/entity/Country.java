package com.kiwi.restcountries.entity;

import lombok.Data;

import java.util.List;

/**
 * Pojo describing a country.
 */
@Data
public class Country {
    private String name;
    private String alpha2Code;
    private String capital;
    private List<Currency> currencies;
}
