package com.example.ecommercedddprice.pricing.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.ecommercedddprice.pricing.domain.repository.PriceRepository;
import com.example.ecommercedddprice.pricing.domain.request.PriceFilterDto;
import com.example.ecommercedddprice.pricing.domain.response.FullPriceDto;
import com.example.ecommercedddprice.pricing.infraestructure.exception.PriceNotFoundHTTPException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class PriceServiceTest {

  private final long BRAND_ID = 1;
  private final long PRODUCT_ID = 35455;

  @MockBean
  private PriceRepository priceRepository;

  private PriceService priceService;

  @BeforeEach
  void before() {
    this.priceService = new PriceServiceImpl(this.priceRepository);
  }

  @Test
  void getPriceByFilterTest() {
    FullPriceDto fullPriceDto = new FullPriceDto();
    fullPriceDto.setProductId(PRODUCT_ID);
    fullPriceDto.setBrandId(BRAND_ID);
    fullPriceDto.setPriceList(3L);
    fullPriceDto.setStartDate(LocalDateTime.parse("2020-06-15T00:00:00"));
    fullPriceDto.setEndDate(LocalDateTime.parse("2020-06-15T11:00:00"));
    fullPriceDto.setSellingPrice(30.5);

    PriceFilterDto priceFilterDto = new PriceFilterDto();
    priceFilterDto.setBrandId(BRAND_ID);
    priceFilterDto.setProductId(PRODUCT_ID);
    priceFilterDto.setLocalDateTime(LocalDateTime.parse("2020-06-14T10:00:00"));

    Mockito.when(priceRepository.getPriceByFilter(Mockito.any())).thenReturn(fullPriceDto);

    FullPriceDto fullPriceRetourned = priceService.getPriceByFilter(priceFilterDto);

    assertNotNull(fullPriceRetourned);
    assertEquals(30.5, fullPriceRetourned.getSellingPrice());

  }

  @Test
  void getPriceByFilterErrorTest() {
    FullPriceDto fullPriceDto = new FullPriceDto();
    fullPriceDto.setProductId(PRODUCT_ID);
    fullPriceDto.setBrandId(BRAND_ID);
    fullPriceDto.setPriceList(3L);
    fullPriceDto.setStartDate(LocalDateTime.parse("2020-06-15T00:00:00"));
    fullPriceDto.setEndDate(LocalDateTime.parse("2020-06-15T11:00:00"));
    fullPriceDto.setSellingPrice(30.5);

    PriceFilterDto priceFilterDto = new PriceFilterDto();
    priceFilterDto.setBrandId(BRAND_ID);
    priceFilterDto.setProductId(PRODUCT_ID);
    priceFilterDto.setLocalDateTime(LocalDateTime.parse("2020-06-14T10:00:00"));

    Mockito.when(priceRepository.getPriceByFilter(Mockito.any())).thenThrow(
        new PriceNotFoundHTTPException());

    PriceNotFoundHTTPException priceNotFoundHTTPException = assertThrows(
        PriceNotFoundHTTPException.class,
        () -> priceService.getPriceByFilter(priceFilterDto));

    assertEquals(PriceNotFoundHTTPException.ACCOUNT_NOT_FOUND,
        priceNotFoundHTTPException.getMessage());
  }
}
