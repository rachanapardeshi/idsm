package com.dealersocket.idsm.controller;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Schema;
///api/authenticate/GetUserAuthorizationToken
@RestController
@RequestMapping("/api/authenticate")
@Tag(name = "Authentication Services", description = "Authentication operations")
public class AuthController {
	
	/*
	 * //
	 * {{base_url}}/api/authenticate/GetUserAuthorizationToken?username={{Username}}
	 * &password={{PW}}&InstitutionID={{ID}}
	 * 
	 * @Operation(summary = "listSalesLocations", description = "Accounts info.")
	 * 
	 * @RequestMapping(value = "GetSalesLocationList", method = RequestMethod.GET)
	 * public ResponseEntity<String> getToken() {
	 * 
	 * return null;
	 * 
	 * }
	 */
	
	//api/authenticate/GetUserAuthorizationToken
	String user ="testerAPI@drivesoft.tech";
	String password ="THis!1sAT3mp0?r@ryAC>CT";
	
	  @Operation(summary = "GetUserAuthorizationToken", description =
	  "Token Auth.")  
	  @RequestMapping(value = "/GetUserAuthorizationToken", method =
	  RequestMethod.GET)	  
	  @Parameters({  
	  @Parameter(name = "Username", description = "Username", in =
	  ParameterIn.QUERY, schema = @Schema(implementation = String.class), required
	  = true),	  
	  @Parameter(name = "password", description = "password", in =
	  ParameterIn.QUERY, schema = @Schema(implementation = String.class), required
	  = true),	  
	  @Parameter(name = "InstitutionID", description = "InstitutionID", in =
	  ParameterIn.QUERY, schema = @Schema(implementation = String.class), required
	  = true)})
	public  ResponseEntity<String>  getToken() 
	{
	    String url = "https://idms.dealersocket.com/api/authenticate/GetUserAuthorizationToken";
	    LinkedHashMap<String, String> parameters = new LinkedHashMap<String,String>();
	    parameters.put("username","testerAPI@drivesoft.tech");
	    parameters.put("password",password);
	    parameters.put("InstitutionID","107007");
	 
	    RestTemplate restTemplate = new RestTemplate();
	    try {
	    	System.out.println("URL before : "+url);
	       
	        HttpHeaders headers = createHttpHeaders(user,password);
	        HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	        //url= test(url,parameters);
	         url= appendToUrl(url,parameters);
	        //url=execute(url,parameters);
	        System.out.println("URL formed : "+url);
	  
	        ResponseEntity<String> response = restTemplate.exchange( url, HttpMethod.GET, entity, String.class);
	       
	        //responseVar  = restTemplate.exchange(url, HttpMethod.GET, entity, String.class).getBody();
	        
	        System.out.println("URL : "+url);
	                
	        System.out.println("Resoponse  - body"+ response.getBody().toString() ); 
	        
	        //System.out.println("responseVar : "+responseVar);
	        
	        System.out.println("Result - status ("+ response.getStatusCode() + ") has body: " + response.hasBody());
	      
	        //ResponseJson resp= getResponse(responseVar);
	        return response;
	    }
	    catch (Exception eek) {
	        eek.printStackTrace();
	    }
		return null;
	}
	  
	/*
	 * private String execute(String url, Map<String, String> params) { String
	 * rr=null; UriComponentsBuilder uriBuilder =
	 * UriComponentsBuilder.fromUriString(url) // predefined params
	 * .queryParam("username", "userValue") .queryParam("password",
	 * "passwordValue"); params.forEach(uriBuilder::queryParam);
	 * rr=uriBuilder.toString(); System.out.println("URL formed : "+rr); return rr;
	 * }
	 */
	
	private HttpHeaders createHttpHeaders(String user, String password)
	{
	    String notEncoded = user + ":" + password;
	    String encodedAuth = "Basic " + Base64.getEncoder().encodeToString(notEncoded.getBytes());
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.add("Authorization", encodedAuth);
	    //headers.add("InstitutionID", "107007");
	    return headers;
	}
	
	
	
	public static String appendToUrl(String url, LinkedHashMap<String, String> parameters) throws URISyntaxException, UnsupportedEncodingException
	{
	    URI uri = new URI(url);
	    String query = uri.getQuery();
        System.out.println("queryyyyyyyyyyy"+query);
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
	    System.out.println("new URL "+newUri.toString());
	    return decoded ;
	}
	
	
	public static String test(String url, LinkedHashMap<String, String> parameters) throws URISyntaxException, UnsupportedEncodingException
	{  

        // Example parameters
        String param1 = URLEncoder.encode("testerAPI@drivesoft.tech", StandardCharsets.UTF_8);
        String param2 = URLEncoder.encode("THis!1sAT3mp0?r@ryAC>CT", StandardCharsets.UTF_8);
        String param3 = URLEncoder.encode("107007", StandardCharsets.UTF_8);
        String decoded = URLDecoder.decode(param2, "UTF-8");

	    System.out.println("AAAAAAAAAAAAAAAAAAAAA::::::::::::::"+decoded);
        // Construct the URL with query parameters
        URI uri = new URI(url + "?username=" + param1 + "&password=" + decoded+ "&InstitutionID=" + param2);
        System.out.println(uri.toString());
		return uri.toString();
	}
	
	/*
	 * public ResponseJson getResponse(String json) { ObjectMapper objectMapper =
	 * new ObjectMapper(); try { return objectMapper.readValue(json,
	 * ResponseJson.class); } catch (JsonMappingException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); } catch
	 * (JsonProcessingException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return null; }
	 */

}
