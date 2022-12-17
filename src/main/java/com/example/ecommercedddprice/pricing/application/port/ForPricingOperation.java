package com.example.ecommercedddprice.pricing.application.port;

import com.example.ecommercedddprice.pricing.application.dto.request.PriceRequestDto;
import com.example.ecommercedddprice.pricing.application.dto.response.PriceResponseDto;

public interface ForPricingOperation {

  PriceResponseDto getPriceByFilter(PriceRequestDto priceRequestDto);

}
