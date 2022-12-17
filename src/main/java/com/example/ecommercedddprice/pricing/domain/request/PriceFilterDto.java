package com.example.ecommercedddprice.pricing.domain.request;

import java.time.LocalDateTime;

public class PriceFilterDto {

  private LocalDateTime localDateTime;

  private Long productId;

  private Long brandId;

  public PriceFilterDto(LocalDateTime localDateTime, Long productId, Long brandId) {
    this.localDateTime = localDateTime;
    this.productId = productId;
    this.brandId = brandId;
  }

  public PriceFilterDto() {
  }

  public LocalDateTime getLocalDateTime() {
    return localDateTime;
  }

  public void setLocalDateTime(LocalDateTime localDateTime) {
    this.localDateTime = localDateTime;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Long getBrandId() {
    return brandId;
  }

  public void setBrandId(Long brandId) {
    this.brandId = brandId;
  }
}
