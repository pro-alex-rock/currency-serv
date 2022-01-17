package com.example.currencyserv.dao;

import com.example.currencyserv.dto.CurrencyDto;

import java.util.List;

public interface Parser {
    List<CurrencyDto> getCurrency();
}
