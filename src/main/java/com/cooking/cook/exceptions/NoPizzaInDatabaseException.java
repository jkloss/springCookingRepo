package com.cooking.cook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_GATEWAY, reason = "There is no existing pizza")
public class NoPizzaInDatabaseException extends RuntimeException {
}
