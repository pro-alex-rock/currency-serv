package com.example.currencyserv.endpoint;

import com.example.currencyserv.model.Pair;
import com.example.currencyserv.service.CurrencyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.util.List;
import java.util.Optional;

@WebService
public class CurrencyEndpoint {

    private static final Logger logger = LoggerFactory.getLogger(CurrencyEndpoint.class);

    private CurrencyService currencyService;

    public CurrencyEndpoint() {
    }

    public CurrencyEndpoint(CurrencyService currencyService) {
        this.currencyService = currencyService;
        logger.info("The CurrencyEndpoint initialized.");
    }

    @WebMethod
    public List<Pair> getCurrencyRate(@WebParam(name = "code") String code) {
        List<Pair> currencyRate = currencyService.getCurrencyRate(Optional.of(code));
        logger.info("Came request to get status for all pairs. The data for response: {}", currencyRate);
        return currencyRate;
    }
}
