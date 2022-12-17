package com.example.ecommercedddprice.pricing.domain;

import java.time.LocalDateTime;
import java.util.Currency;

public class Price {
  private Long id;

  private Long brandId;

  private LocalDateTime startDate;

  private LocalDateTime endDate;

  private Long priceList;

  private Long productId;

  private Long priority;

  private Double sellingPrice;

  private Currency curr;

  public Price(Long id, Long brandId, LocalDateTime startDate, LocalDateTime endDate,
      Long priceList, Long productId, Long priority, Double sellingPrice, Currency curr) {
    this.id = id;
    this.brandId = brandId;
    this.startDate = startDate;
    this.endDate = endDate;
    this.priceList = priceList;
    this.productId = productId;
    this.priority = priority;
    this.sellingPrice = sellingPrice;
    this.curr = curr;
  }

  public Price() {
  }

  public void applyDiscount(Double percentage) {
    this.setSellingPrice(this.sellingPrice - (this.sellingPrice * percentage));
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getBrandId() {
    return brandId;
  }

  public void setBrandId(Long brandId) {
    this.brandId = brandId;
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

  public Long getPriceList() {
    return priceList;
  }

  public void setPriceList(Long priceList) {
    this.priceList = priceList;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Long getPriority() {
    return priority;
  }

  public void setPriority(Long priority) {
    this.priority = priority;
  }

  public Double getSellingPrice() {
    return this.sellingPrice;
  }

  public void setSellingPrice(Double sellingPrice) {
    this.sellingPrice = sellingPrice;
  }

  public Currency getCurr() {
    return curr;
  }

  public void setCurr(Currency curr) {
    this.curr = curr;
  }
}
