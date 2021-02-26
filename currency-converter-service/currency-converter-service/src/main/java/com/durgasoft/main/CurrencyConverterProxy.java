package com.durgasoft.main;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

//@FeignClient(name = "currency-exchange-service",url = "localhost:8000")  # without Ribbon , we can communicate only with one instance
//@FeignClient(name = "currency-exchange-service")   - #commented to use zuul API gateway, making call to exchange service via API gateway
@FeignClient(name = "netflix-zuul-api-gateway")
@RibbonClient(name = "currency-exchange-service")
public interface CurrencyConverterProxy {

	//@GetMapping("/currency-exchange/from/{from}/to/{to}")   #commented to use zuul ,for zuul API call, appl name should be appended
	@GetMapping("currency-exchange-service/currency-exchange/from/{from}/to/{to}")
	public ConvertedCurrencyBean retrieveExchangeValue(@PathVariable(value = "from") String from,@PathVariable(value = "to") String to);
}
