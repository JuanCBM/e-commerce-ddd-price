package com.example.ecommercedddprice.pricing.infraestructure.exception;

import static com.example.ecommercedddprice._shared.Constants.PRICE_NOT_FOUND;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = PRICE_NOT_FOUND)
public class PriceNotFoundHTTPException extends RuntimeException {

  public static final String ACCOUNT_NOT_FOUND = "Price not found";
  private static final long serialVersionUID = -5596141541624573125L;

  public PriceNotFoundHTTPException(String message) {
    super(message);
  }

  public PriceNotFoundHTTPException() {
    super(ACCOUNT_NOT_FOUND);
  }
}
