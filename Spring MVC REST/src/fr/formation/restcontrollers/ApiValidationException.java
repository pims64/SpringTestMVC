package fr.formation.restcontrollers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "API contract violated, check validation rules")
public class ApiValidationException extends RuntimeException {

    private static final long serialVersionUID = -7750753461301140834L;
}
