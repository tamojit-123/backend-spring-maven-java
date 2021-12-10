package com.stackroute.springRestfulWithMongo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "customer with the specified id not found")
public class CustomerNotFoundException extends Exception {
}
