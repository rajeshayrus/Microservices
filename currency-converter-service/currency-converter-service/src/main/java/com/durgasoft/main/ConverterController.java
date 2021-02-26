package com.durgasoft.main;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConverterController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CurrencyConverterProxy proxy;
	@GetMapping("/currency-conversion/from/{from}/to/{to}/{value}")
	public ConvertedCurrencyBean converter(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal value) {
		Map<String, String> uriVariables = new HashMap<String, String>();
		uriVariables.put("from", from);
		uriVariables.put("to",to);
		ResponseEntity<ConvertedCurrencyBean> response = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", ConvertedCurrencyBean.class, uriVariables);
		ConvertedCurrencyBean finalValue = response.getBody();
		return new ConvertedCurrencyBean((long) 101,from,to,finalValue.getConversionMultiple(),value,finalValue.getConversionMultiple().multiply(value),finalValue.getPort());
	}
	
	@GetMapping("/currency-conversion-feign/from/{from}/to/{to}/{value}")
	public ConvertedCurrencyBean converterFeign(@PathVariable String from, @PathVariable String to,
			@PathVariable BigDecimal value) {
		ConvertedCurrencyBean retrieveExchangeValue = proxy.retrieveExchangeValue(from, to);
		log.info("{}",retrieveExchangeValue);
		return new ConvertedCurrencyBean((long) 101,from,to,retrieveExchangeValue.getConversionMultiple(),value,retrieveExchangeValue.getConversionMultiple().multiply(value),retrieveExchangeValue.getPort());
	}
	
	
}
