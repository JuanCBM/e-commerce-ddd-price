package com.example.ecommercedddprice.pricing.application.rest.e2e;

import static com.example.ecommercedddprice.util.PriceTestConstants.BRAND_ID;
import static com.example.ecommercedddprice.util.PriceTestConstants.PRODUCT_ID;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.ecommercedddprice._shared.Constants;
import com.example.ecommercedddprice.pricing.application.dto.request.PriceRequestDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

@ActiveProfiles("test")
@SpringBootTest
@AutoConfigureMockMvc
@DisplayName("e2e PriceControllerTest")
class PriceControllerTest {

  private final ObjectMapper objectMapper;

  @Autowired
  private MockMvc mockMvc;

  PriceControllerTest() {
    this.objectMapper = new ObjectMapper();
    this.objectMapper.findAndRegisterModules();
  }

  @Test
  @DisplayName("Get price test 1")
  void getPriceTest1() throws Exception {
    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .brandId(BRAND_ID)
        .productId(PRODUCT_ID)
        .localDateTime(LocalDateTime.parse("2020-06-14T10:00:00"))
        .build();

    ResultActions resultActions = runTestGetPrice(priceRequestDto);
    resultActions
        .andExpect(jsonPath("$.brandId", equalTo((int) BRAND_ID)))
        .andExpect(jsonPath("$.productId", equalTo((int) PRODUCT_ID)))
        .andExpect(jsonPath("$.priceList", equalTo(1)))
        .andExpect(jsonPath("$.sellingPrice", equalTo(35.5)));
  }

  @Test
  @DisplayName("Get price test 2")
  void getPriceTest2() throws Exception {
    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .brandId(BRAND_ID)
        .productId(PRODUCT_ID)
        .localDateTime(LocalDateTime.parse("2020-06-14T16:00:00"))
        .build();

    ResultActions resultActions = runTestGetPrice(priceRequestDto);
    resultActions
        .andExpect(jsonPath("$.brandId", equalTo((int) BRAND_ID)))
        .andExpect(jsonPath("$.productId", equalTo((int) PRODUCT_ID)))
        .andExpect(jsonPath("$.priceList", equalTo(2)))
        .andExpect(jsonPath("$.sellingPrice", equalTo(25.45)));
  }

  @Test
  @DisplayName("Get price test 3")
  void getPriceTest3() throws Exception {
    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .brandId(BRAND_ID)
        .productId(PRODUCT_ID)
        .localDateTime(LocalDateTime.parse("2020-06-14T21:00:00"))
        .build();

    ResultActions resultActions = runTestGetPrice(priceRequestDto);
    resultActions
        .andExpect(jsonPath("$.brandId", equalTo((int) BRAND_ID)))
        .andExpect(jsonPath("$.productId", equalTo((int) PRODUCT_ID)))
        .andExpect(jsonPath("$.priceList", equalTo(1)))
        .andExpect(jsonPath("$.sellingPrice", equalTo(35.5)));
  }

  @Test
  @DisplayName("Get price test 4")
  void getPriceTest4() throws Exception {
    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .brandId(BRAND_ID)
        .productId(PRODUCT_ID)
        .localDateTime(LocalDateTime.parse("2020-06-15T10:00:00"))
        .build();

    ResultActions resultActions = runTestGetPrice(priceRequestDto);
    resultActions
        .andExpect(jsonPath("$.brandId", equalTo((int) BRAND_ID)))
        .andExpect(jsonPath("$.productId", equalTo((int) PRODUCT_ID)))
        .andExpect(jsonPath("$.priceList", equalTo(3)))
        .andExpect(jsonPath("$.sellingPrice", equalTo(30.5)));
  }

  @Test
  @DisplayName("Get price test 5")
  void getPriceTest5() throws Exception {
    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .brandId(BRAND_ID)
        .productId(PRODUCT_ID)
        .localDateTime(LocalDateTime.parse("2020-06-16T21:00:00"))
        .build();

    ResultActions resultActions = runTestGetPrice(priceRequestDto);
    resultActions
        .andExpect(jsonPath("$.brandId", equalTo((int) BRAND_ID)))
        .andExpect(jsonPath("$.productId", equalTo((int) PRODUCT_ID)))
        .andExpect(jsonPath("$.priceList", equalTo(4)))
        .andExpect(jsonPath("$.sellingPrice", equalTo(38.95)));

  }

  @Test
  @DisplayName("Get price test 6, required parameter brandId not found")
  void getPriceTest6() throws Exception {
    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .productId(PRODUCT_ID)
        .localDateTime(LocalDateTime.parse("2020-06-14T10:00:00"))
        .build();

    this.mockMvc.perform(post("/api/prices/filter")
            .content(objectMapper.writeValueAsString(priceRequestDto))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
        .andDo(MockMvcResultHandlers.print());

  }

  @Test
  @DisplayName("Get price test 7, productId invalid value")
  void getPriceTest7() throws Exception {
    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .brandId(BRAND_ID)
        .productId(-1L)
        .localDateTime(LocalDateTime.parse("2020-06-14T10:00:00"))
        .build();

    this.mockMvc.perform(post("/api/prices/filter")
            .content(objectMapper.writeValueAsString(priceRequestDto))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
        .andDo(MockMvcResultHandlers.print());

  }

  @Test
  @DisplayName("Get price test 8, localDateTime invalid format")
  void getPriceTest8() throws Exception {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern(Constants.INITIAL_DATA_DATE_FORMAT);

    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .brandId(BRAND_ID)
        .productId(-1L)
        .localDateTime(LocalDateTime.parse("2020-06-14-18.30.00", formatter))
        .build();

    this.mockMvc.perform(post("/api/prices/filter")
            .content(objectMapper.writeValueAsString(priceRequestDto))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is(HttpStatus.BAD_REQUEST.value()))
        .andDo(MockMvcResultHandlers.print());

  }

  @Test
  @DisplayName("Get price test 9, price not found")
  void getPriceTest9() throws Exception {
    PriceRequestDto priceRequestDto = PriceRequestDto.builder()
        .brandId(BRAND_ID)
        .productId(PRODUCT_ID)
        .localDateTime(LocalDateTime.parse("2020-06-13T10:00:00"))
        .build();

    this.mockMvc.perform(post("/api/prices/filter")
            .content(objectMapper.writeValueAsString(priceRequestDto))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is(HttpStatus.NOT_FOUND.value()))
        .andDo(MockMvcResultHandlers.print());
  }


  private ResultActions runTestGetPrice(PriceRequestDto priceRequestDto) throws Exception {
    return this.mockMvc.perform(post("/api/prices/filter")
            .content(objectMapper.writeValueAsString(priceRequestDto))
            .contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
  }

}
