package fr.formation.restcontrollers;

import java.util.List;

import org.springframework.validation.ObjectError;

public class ErrorDetails {

    private String message = "Validation failed";

    private List<ObjectError> details;

    public ErrorDetails(List<ObjectError> details) {
	super();
	this.details = details;
    }

    public String getMessage() {
	return message;
    }

    public void setMessage(String message) {
	this.message = message;
    }

    public List<ObjectError> getDetails() {
	return details;
    }

    public void setDetails(List<ObjectError> details) {
	this.details = details;
    }
}
