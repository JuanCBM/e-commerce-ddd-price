package com.example.ecommercedddprice.pricing.domain.response;

import java.time.LocalDateTime;

public class FullPriceDto {

  private Long productId;

  private Long brandId;

  private Long priceList;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private Double sellingPrice;

  public FullPriceDto(Long productId, Long brandId, Long priceList,
      LocalDateTime startDate, LocalDateTime endDate, Double sellingPrice) {
    this.productId = productId;
    this.brandId = brandId;
    this.priceList = priceList;
    this.startDate = startDate;
    this.endDate = endDate;
    this.sellingPrice = sellingPrice;
  }

  public FullPriceDto() {
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

  public Long getPriceList() {
    return priceList;
  }

  public void setPriceList(Long priceList) {
    this.priceList = priceList;
  }

  public LocalDateTime getStartDate() {
    return startDate;
  }

  public void setStartDate(LocalDateTime startDate) {
    this.startDate = startDate;
  }

  public LocalDateTime getEndDate() {
    return endDate;
  }

  public void setEndDate(LocalDateTime endDate) {
    this.endDate = endDate;
  }

  public Double getSellingPrice() {
    return sellingPrice;
  }

  public void setSellingPrice(Double sellingPrice) {
    this.sellingPrice = sellingPrice;
  }
}
