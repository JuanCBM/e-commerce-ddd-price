package com.example.ecommercedddprice.pricing.infraestructure.configuration;

import com.example.ecommercedddprice.pricing.domain.repository.PriceRepository;
import com.example.ecommercedddprice.pricing.domain.service.PriceService;
import com.example.ecommercedddprice.pricing.domain.service.PriceServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PricingBeanConfiguration {

  @Bean
  public PriceService accountService(PriceRepository priceRepository) {
    return new PriceServiceImpl(priceRepository);
  }

}