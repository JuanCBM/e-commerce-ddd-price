package com.example.ecommercedddprice.pricing.domain;

import static com.example.ecommercedddprice.util.PriceTestConstants.BRAND_ID;
import static com.example.ecommercedddprice.util.PriceTestConstants.PRODUCT_ID;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("test")
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@AutoConfigureMockMvc
public class PriceTest {

  @Test
  public void applyDiscount() {
    Price price = new Price();

    price.setProductId(PRODUCT_ID);
    price.setBrandId(BRAND_ID);
    price.setPriceList(1L);
    price.setStartDate(LocalDateTime.parse("2020-06-14T00:00:00"));
    price.setEndDate(LocalDateTime.parse("2020-12-31T23:59:59"));
    price.setSellingPrice(35.5);

    price.applyDiscount((10D / 100));

    assertEquals(
        (Double) (35.5 - ((35.5 * 10 / 100))),
        price.getSellingPrice());
  }

}