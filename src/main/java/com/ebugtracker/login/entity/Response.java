package com.ebugtracker.login.entity;

import javax.persistence.Entity;


public class Response {
   private String message;

   
public Response() {
	super();
}

public Response(String message) {
	super();
	this.message = message;
}

public String getMessage() {
	return message;
}

public void setMessage(String message) {
	this.message = message;
}
   
}
