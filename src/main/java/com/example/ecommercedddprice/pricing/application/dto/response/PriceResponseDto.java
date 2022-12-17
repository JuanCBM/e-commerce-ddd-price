package com.example.ecommercedddprice.pricing.application.dto.response;

import com.example.ecommercedddprice.pricing.domain.response.FullPriceDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceResponseDto {

  @Schema(description = "Product id", type = "number", example = "35455")
  private Long productId;

  @Schema(description = "Brand id", type = "number", example = "1")
  private Long brandId;

  @Schema(description = "Price list", type = "number", example = "1")
  private Long priceList;

  @Schema(description = "Start date", type = "string", format = "date-time", example = "2020-06-14T00:00:00Z")
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private LocalDateTime startDate;

  @Schema(description = "End date", type = "string", format = "date-time", example = "2020-12-31T23:59:59Z")
  @JsonFormat(shape = JsonFormat.Shape.STRING)
  private LocalDateTime endDate;

  @Schema(description = "Selling price", type = "number", example = "35.5")
  private Double sellingPrice;

  public static PriceResponseDto of(FullPriceDto priceByFilter) {

    return PriceResponseDto.builder()
        .productId(priceByFilter.getProductId())
        .brandId(priceByFilter.getBrandId())
        .priceList(priceByFilter.getPriceList())
        .startDate(priceByFilter.getStartDate())
        .endDate(priceByFilter.getEndDate())
        .sellingPrice(priceByFilter.getSellingPrice())
        .build();

  }
}
