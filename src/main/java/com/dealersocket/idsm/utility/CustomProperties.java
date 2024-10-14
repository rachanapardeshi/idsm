package com.dealersocket.idsm.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties()
public class CustomProperties {

	public CustomProperties() {
	}

	@Value("${username}")
	private String username;

	@Value("${password}")
	private String password;
	
	@Value("${InstitutionID}")
	private String institutionID;

	@Value("${baseurl}")
	private String baseurl;

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}



	public String getBaseurl() {
		return baseurl;
	}


	public void setBaseurl(String baseurl) {
		this.baseurl = baseurl;
	}


	public String getInstitutionID() {
		return institutionID;
	}


	public void setInstitutionID(String institutionID) {
		this.institutionID = institutionID;
	}

	
}



