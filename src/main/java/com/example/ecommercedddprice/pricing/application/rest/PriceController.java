package com.example.ecommercedddprice.pricing.application.rest;

import com.example.ecommercedddprice.pricing.application.dto.request.PriceRequestDto;
import com.example.ecommercedddprice.pricing.application.dto.response.PriceResponseDto;
import com.example.ecommercedddprice.pricing.application.port.ForPricingOperation;
import com.example.ecommercedddprice.pricing.domain.request.PriceFilterDto;
import com.example.ecommercedddprice.pricing.domain.service.PriceService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/prices")
public class PriceController implements ForPricingOperation {

  private final PriceService priceService;

  public PriceController(PriceService priceService) {
    this.priceService = priceService;
  }

  @Operation(summary = "Get price by filters")
  @ApiResponses(
      {
        @ApiResponse(
          responseCode = "200",
          description = "Price found with filter parameters",
          content = {
            @Content(
              mediaType = "application/json",
              schema = @Schema(
                  implementation = PriceResponseDto.class)
            )
          }
        ),
        @ApiResponse(
          responseCode = "400",
          description = "Invalid price attributes supplied",
          content = @Content
        ),
        @ApiResponse(
          responseCode = "404",
          description = "Price not found",
          content = @Content
        )
      }
  )
  @io.swagger.v3.oas.annotations.parameters.RequestBody(
      description = "Price filter",
      required = true,
      content = @Content(
          mediaType = "application/json",
          schema = @Schema(
              implementation = PriceRequestDto.class
          )
      )
  )
  @Override
  @PostMapping("/filter")
  public PriceResponseDto getPriceByFilter(
      @Valid @RequestBody PriceRequestDto priceRequestDto) {
    PriceFilterDto priceFilterDto = new PriceFilterDto(priceRequestDto.getLocalDateTime(),
        priceRequestDto.getProductId(), priceRequestDto.getBrandId());

    return PriceResponseDto.of(this.priceService.getPriceByFilter(priceFilterDto));
  }

}
