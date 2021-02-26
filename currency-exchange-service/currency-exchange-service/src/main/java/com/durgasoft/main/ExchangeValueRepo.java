package com.durgasoft.main;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ExchangeValueRepo extends JpaRepository<ExchangeValue, Integer> {

	ExchangeValue findByFromAndTo(String from, String to);
}