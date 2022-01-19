package com.example.currencyserv.dao;

import com.example.currencyserv.dto.CurrencyDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class ParserCurrencyTest {

    @Autowired
    private Parser parser;

    @Test
    public void shouldGetDataFromResourceAndParseSuccess() {
        List<CurrencyDto> currenciesExpected = parser.getCurrency();
        assertTrue(currenciesExpected.size() > 0);
        assertEquals(currenciesExpected.get(0).getCurrencyCodeB(), 980);
        assertEquals(currenciesExpected.get(5).getCurrencyCodeB(), 980);
    }
}