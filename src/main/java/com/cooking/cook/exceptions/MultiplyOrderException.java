package com.cooking.cook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "You can add chosen pizza only once")
public class MultiplyOrderException extends RuntimeException {
}
