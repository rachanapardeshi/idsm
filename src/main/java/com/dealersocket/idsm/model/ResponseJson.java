package com.dealersocket.idsm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ResponseJson {
	
    @JsonProperty("Status") 
    public int status;
    @JsonProperty("Token") 
    public String token;
    @JsonProperty("Message") 
    public String message;
    
    public ResponseJson()
    {
    	
    }
    
    
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
    
    
    
}
