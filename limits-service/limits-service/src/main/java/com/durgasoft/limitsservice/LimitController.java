package com.durgasoft.limitsservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LimitController {

	@Autowired
	private LimitsConfiguration config;
	
	@GetMapping("/limits-service/range")
	public Range range() {
		Range range = new Range();
		range.setMax(config.getMax());
		range.setMin(config.getMin());
		return range;
	}
}
