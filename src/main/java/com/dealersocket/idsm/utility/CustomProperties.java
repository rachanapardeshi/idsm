package com.dealersocket.idsm.utility;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties()
public class CustomProperties {

	public CustomProperties() {
	}

	@Value("${InstitutionID}")
	private String institutionID;

	@Value("${baseurl}")
	private String baseurl;

	@Value("${uname}")
	private String uname;

	@Value("${pwd}")
	private String pwd;


	public String getUname() {
		return uname;
	}


	public void setUname(String uname) {
		this.uname = uname;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
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



