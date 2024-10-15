package com.dealersocket.idsm.controller;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.util.Base64;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dealersocket.idsm.model.ResponseJson;
import com.dealersocket.idsm.utility.CustomProperties;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Component
public class TokenGenerator {
    public CustomProperties custProps = new CustomProperties();	
	
    private static final Logger logger = LoggerFactory.getLogger(TokenGenerator.class);
	
	public TokenGenerator(CustomProperties custProps) {
		this.custProps = custProps;
	}
	
	public  String  getToken() 
	{		
		String tokenURL = custProps.getBaseurl()+"/authenticate/GetUserAuthorizationToken"; 	   
	    LinkedHashMap<String, String> parameters = new LinkedHashMap<String,String>();
	    parameters.put("username",custProps.getUname());
	    parameters.put("password",custProps.getPwd());
	    parameters.put("InstitutionID",custProps.getInstitutionID());
	   
	    String responseVar = null;
	    RestTemplate restTemplate = new RestTemplate();
	    try {
	    	
	        HttpHeaders headers = createHttpHeaders(custProps.getUname(),custProps.getPwd());
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	  
	        tokenURL = appendToUrl(tokenURL,parameters);
         
	        //ResponseEntity<String> response = restTemplate.exchange( url, HttpMethod.GET, entity, String.class);
	       
	        responseVar  = restTemplate.exchange(tokenURL, HttpMethod.GET, entity, String.class).getBody();
	        
	        ResponseJson rs = getResponse(responseVar);
	        return rs.getToken();
	    }
	    catch (Exception exp) {
	        logger.info(exp.getMessage());
	    }
		return null;
	}	
	
	
	public ResponseJson getResponse(String json)  {
		
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(json, ResponseJson.class);
		} catch (JsonMappingException e) {
			
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		return null;
	}


	public HttpHeaders createHttpHeaders(String user, String password)
	{
	    String notEncoded = user + ":" + password;
	    String encodedAuth = "Basic " + Base64.getEncoder().encodeToString(notEncoded.getBytes());
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.add("Authorization", encodedAuth);
	
	    return headers;
	}
	
	public static String appendToUrl(String url, LinkedHashMap<String, String> parameters) throws URISyntaxException, UnsupportedEncodingException
	{
	    URI uri = new URI(url);
	    String query = uri.getQuery();     
	    StringBuilder builder = new StringBuilder();

	    if (query != null)
	        builder.append(query);

	    for (Map.Entry<String, String> entry: parameters.entrySet())
	    {
	        String keyValueParam = entry.getKey() + "=" + entry.getValue();
	        if (!builder.toString().isEmpty())
	            builder.append("&");

	        builder.append(keyValueParam);
	    }

	    URI newUri = new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), builder.toString(), uri.getFragment());
	    String decoded = URLDecoder.decode(newUri.toString(), "UTF-8");
	    return decoded ;
	}
	

	
	
	
	
	
	
}
