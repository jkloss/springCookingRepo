package com.cooking.cook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.CREATED, reason = "You can't add pizza with existing name")
public class MoreThanOnePizzaException extends RuntimeException {

}
