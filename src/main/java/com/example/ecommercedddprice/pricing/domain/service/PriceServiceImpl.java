package com.example.ecommercedddprice.pricing.domain.service;

import com.example.ecommercedddprice.pricing.domain.repository.PriceRepository;
import com.example.ecommercedddprice.pricing.domain.request.PriceFilterDto;
import com.example.ecommercedddprice.pricing.domain.response.FullPriceDto;

public class PriceServiceImpl implements PriceService {

  private final PriceRepository priceRepository;

  public PriceServiceImpl(
      PriceRepository priceRepository) {
    this.priceRepository = priceRepository;
  }

  @Override
  public FullPriceDto getPriceByFilter(PriceFilterDto priceFilterDto) {
    return this.priceRepository.getPriceByFilter(priceFilterDto);
  }
}
