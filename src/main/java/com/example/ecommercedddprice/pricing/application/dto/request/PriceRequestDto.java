package com.example.ecommercedddprice.pricing.application.dto.request;

import com.example.ecommercedddprice._shared.Constants;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PriceRequestDto {

  @Schema(description = "LocalDateTime to filter", type = "string",
      example = "2020-06-14T10:00:00Z", required = true, format = "date-time")
  @NotNull(message = "localDateTime is mandatory")
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = Constants.STANDARD_DATE_FORMAT)
  @JsonProperty("localDateTime")
  private LocalDateTime localDateTime;

  @Schema(description = "Product id to filter", type = "number",
      example = "35455", required = true)
  @Min(1)
  @NotNull(message = "productId is mandatory")
  @JsonProperty("productId")
  private Long productId;

  @Schema(description = "Brand id to filter", type = "number",
      example = "1", required = true)
  @Min(1)
  @NotNull(message = "brandId is mandatory")
  @JsonProperty("brandId")
  private Long brandId;
}
