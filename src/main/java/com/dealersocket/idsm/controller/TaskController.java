package com.dealersocket.idsm.controller;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

import com.dealersocket.idsm.dao.VehicleDetailsDao;
import com.dealersocket.idsm.model.Data;
import com.dealersocket.idsm.model.PageMetadata;
import com.dealersocket.idsm.model.RootModel;
import com.dealersocket.idsm.model.VehicleDetailsModel;
import com.dealersocket.idsm.resources.VehicleDetailsResource;
import com.dealersocket.idsm.resources.VehicleDetails_CreateResource;
import com.dealersocket.idsm.resources.VehiclePageResource;
import com.dealersocket.idsm.utility.ControllerConstants;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import assembler.VehicleResourceAssembler;
import errorHandlers.ErrorListResource;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

@RestController
@RequestMapping(value=ControllerConstants.API_BASE_PATH + "/account",produces= MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Task Services", description = "Task operations")
public class TaskController {

	VehicleDetailsDao vehicleDao;

	@Autowired
	TokenGenerator tokenService;

	@Autowired
	public TaskController(VehicleDetailsDao vehicleDao) {
		this.vehicleDao = vehicleDao;
	}

	//Fetch all the accounts from IDMS Server a
	// and store it into database
	@Operation(summary = "getAccountList", description = "Fetch all the accounts from IDMS Server")  
	@RequestMapping(value = "/getAccountList", method = RequestMethod.GET)	 
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = ControllerConstants.BAD_REQUEST, content = @Content(schema = @Schema(implementation = ErrorListResource.class))),
		@ApiResponse(responseCode = "401", description = ControllerConstants.UNAUTHORIZED, content = @Content(schema = @Schema(implementation = ErrorListResource.class))),
		@ApiResponse(responseCode = "200", description = ControllerConstants.OK, content = @Content(schema = @Schema(implementation = ErrorListResource.class)))	
	})
	public Data getAccountTypeList(
	@Parameter(description = "InstitutionID", required = false) @RequestParam(name = "InstitutionID", required = true) String instId,
	@Parameter(description = "LayoutId", required = false) @RequestParam(name = "LayoutID", required = true) String layoutId, 
	@Parameter(description = "PageNumber", required = false) @RequestParam(name = "pageNumber", required = true) String pageNumber
	) throws Exception {
		VehicleDetails_CreateResource body = new VehicleDetails_CreateResource();
		RootModel rm = getAccountListResponse(instId, layoutId,  pageNumber);
		Data d = new Data();
		ArrayList<Data> dataList = rm.getData();
		for(Data rec : dataList )
		{     
			VehicleDetailsModel vh = body.toEntityData(rec.getRow());
			System.out.println("VH "+vh.toString());
			vehicleDao.insertVehicleDetails(vh);
		}
		return d;	
	}
	
	//get Vehicle details from DB 
	@Operation(summary = "getVehicleDetails", description = "Vehicle Details")
	@RequestMapping(value = "getVehicleDetails", method = RequestMethod.GET)
	@ApiResponses({
		@ApiResponse(responseCode = "400", description = ControllerConstants.BAD_REQUEST, content = @Content(schema = @Schema(implementation = ErrorListResource.class))),
		})

	public ResponseEntity<VehiclePageResource<VehicleDetailsResource>> getVehicleDetails( Pageable pageable) {
		List<VehicleDetailsModel> vehicles = vehicleDao.listVehicles(); 
		List<VehicleDetailsResource> vhResources = new VehicleResourceAssembler().toCollectionModel(vehicles);
		VehiclePageResource<VehicleDetailsResource> pageResponse = new VehiclePageResource<>();
		pageResponse.setItems(vhResources);
		pageResponse.setPage(new PageMetadata(vhResources.size(), vhResources.size(), 1, 0));
		return ResponseEntity.ok(pageResponse);
			
	}

	
	public RootModel getAccountListResponse(String instId,String layoutId, String pageNumber )
	{
		LinkedHashMap<String, String> parameters = new LinkedHashMap<String,String>();
		RestTemplate restTemplate = new RestTemplate();
		RootModel responseModel = new RootModel();
		String responseVar= null;
		HttpEntity<RootModel> entity1 = null ;
		try {
			parameters.put("Token",tokenService.getToken());
			parameters.put("InstitutionID",instId);
			parameters.put("LayoutID",layoutId);
			parameters.put("PageNumber",pageNumber);

			String localUrl=tokenService.properties.getBaseurl()+"/Account/GetAccountList";
			localUrl = tokenService.appendToUrl(localUrl, parameters);	
			HttpHeaders headers =  tokenService.createHttpHeaders("abc","test"); 
			HttpEntity<RootModel> entity = new HttpEntity<>(responseModel,headers);
			responseVar = restTemplate.exchange(  localUrl, HttpMethod.GET,entity, String.class).getBody(); 
			responseModel = getResponse( responseVar);
		}
		catch (HttpStatusCodeException ex) {
			entity1 = new ResponseEntity<RootModel>(responseModel, ex.getStatusCode());
		}
		catch (Exception e) {			
			entity1 = new ResponseEntity<RootModel>(responseModel, HttpStatus.SERVICE_UNAVAILABLE);
		}
		return  responseModel;
	}

	public RootModel getResponse(String json)  {
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.readValue(json, RootModel.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}

}