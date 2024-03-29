package com.stackroute.springRestfulWithMongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT, reason = "customer already exists")
public class CustomerAlreadyExistsException extends Exception {
}
