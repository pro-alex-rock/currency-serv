package com.example.currencyserv.model.mapper;

import com.example.currencyserv.dto.CurrencyDto;
import com.example.currencyserv.model.Pair;

public interface Mapper {
    Pair toCurrencyPair(CurrencyDto currencyDto);
}
