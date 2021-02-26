package com.durgasoft.main;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExchangeController {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private Environment env;
	@Autowired
	private ExchangeValueRepo ex;
	@GetMapping("/currency-exchange/from/{from}/to/{to}")
	public ExchangeValue retrieveExchangeValue(@PathVariable String from,@PathVariable String to) {
		ExchangeValue exchange =ex.findByFromAndTo(from, to);
		System.out.println(env.getProperty("local.server.port"));
		exchange.setPort(env.getProperty("local.server.port"));
		log.info("{loging}");
		return exchange;
	}
	public ExchangeValueRepo getEx() {
		return ex;
	}
	public void setEx(ExchangeValueRepo ex) {
		this.ex = ex;
	}
}
