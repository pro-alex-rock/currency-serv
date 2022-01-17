package com.example.currencyserv.config;

import com.example.currencyserv.endpoint.CurrencyEndpoint;
import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.apache.cxf.ws.policy.PolicyInInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class WebServiceConfig {

    private final Bus bus;

    public WebServiceConfig(Bus bus) {
        this.bus = bus;
    }

    @Bean
    public Endpoint endpoint() {
        EndpointImpl endpoint = new EndpointImpl(bus, new CurrencyEndpoint());
        endpoint.publish("/currency");
        Map<String, Object> map = new HashMap<>();
        map.put(ConfigurationConstants.ACTION, ConfigurationConstants.USERNAME_TOKEN);
        map.put(ConfigurationConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);
        map.put(ConfigurationConstants.PW_CALLBACK_CLASS, UTPasswordCallback.class.getName());
        PolicyInInterceptor wssIn = new PolicyInInterceptor(map);
        endpoint.getInInterceptors().add(wssIn);
        return endpoint;
    }
}
