package com.example.ecommercedddprice.pricing.domain.service;

import com.example.ecommercedddprice.pricing.domain.request.PriceFilterDto;
import com.example.ecommercedddprice.pricing.domain.response.FullPriceDto;

public interface PriceService {

  FullPriceDto getPriceByFilter(PriceFilterDto priceFilterDto);
}
