package com.example.ecommercedddprice.pricing.domain.repository;

import com.example.ecommercedddprice.pricing.domain.request.PriceFilterDto;
import com.example.ecommercedddprice.pricing.domain.response.FullPriceDto;

public interface PriceRepository {

  FullPriceDto getPriceByFilter(PriceFilterDto priceFilterDto);

}
