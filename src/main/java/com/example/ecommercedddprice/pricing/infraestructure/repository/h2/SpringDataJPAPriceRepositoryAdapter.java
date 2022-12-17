package com.example.ecommercedddprice.pricing.infraestructure.repository.h2;

import com.example.ecommercedddprice.pricing.domain.repository.PriceRepository;
import com.example.ecommercedddprice.pricing.domain.request.PriceFilterDto;
import com.example.ecommercedddprice.pricing.domain.response.FullPriceDto;
import com.example.ecommercedddprice.pricing.infraestructure.exception.PriceNotFoundHTTPException;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Primary
@Component
public class SpringDataJPAPriceRepositoryAdapter implements PriceRepository {

  private final SpringDataJPAPriceRepository accountRepository;

  public SpringDataJPAPriceRepositoryAdapter(SpringDataJPAPriceRepository accountRepository) {
    this.accountRepository = accountRepository;
  }

  @Override
  public FullPriceDto getPriceByFilter(PriceFilterDto priceFilterDto) {
    IFullPrice priceByFilter = this.accountRepository.getPriceByFilter(priceFilterDto).orElseThrow(
        PriceNotFoundHTTPException::new);

    FullPriceDto fullPriceDto = new FullPriceDto();
    fullPriceDto.setProductId(priceByFilter.getProductId());
    fullPriceDto.setBrandId(priceByFilter.getBrandId());
    fullPriceDto.setPriceList(priceByFilter.getPriceList());
    fullPriceDto.setStartDate(priceByFilter.getStartDate());
    fullPriceDto.setEndDate(priceByFilter.getEndDate());
    fullPriceDto.setSellingPrice(priceByFilter.getSellingPrice());

    return fullPriceDto;
  }
}
