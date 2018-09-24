package com.cooking.cook.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED,
        reason = "Only admin has permission to add new pizza")
public class IsNotAdminException extends RuntimeException {
}
