package com.example.ecommercedddprice.pricing.infraestructure.repository.h2;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDateTime;

public interface IFullPrice {

  Long getProductId();

  Long getBrandId();

  Long getPriceList();

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  LocalDateTime getStartDate();

  @JsonFormat(shape = JsonFormat.Shape.STRING)
  LocalDateTime getEndDate();

  Double getSellingPrice();

}
