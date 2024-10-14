package com.dealersocket.idsm.model;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="RootModel", description="RootModel")
public class RootModel {
    @JsonProperty("Status") 
    public String status;
    @JsonProperty("Message") 
    public String message;
    @JsonProperty("TotalRecords") 
    public String totalRecords;
    @JsonProperty("TotalPages") 
    public String totalPages;
    @JsonProperty("PageNumber") 
    public String pageNumber;
    @JsonProperty("BeginningPage") 
    public String beginningPage;
    @JsonProperty("EndingPage") 
    public String endingPage;
    @JsonProperty("Data") 
    public ArrayList<Data> data;
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getTotalRecords() {
		return totalRecords;
	}
	public void setTotalRecords(String totalRecords) {
		this.totalRecords = totalRecords;
	}
	public String getTotalPages() {
		return totalPages;
	}
	public void setTotalPages(String totalPages) {
		this.totalPages = totalPages;
	}
	public String getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(String pageNumber) {
		this.pageNumber = pageNumber;
	}
	public String getBeginningPage() {
		return beginningPage;
	}
	public void setBeginningPage(String beginningPage) {
		this.beginningPage = beginningPage;
	}
	public String getEndingPage() {
		return endingPage;
	}
	public void setEndingPage(String endingPage) {
		this.endingPage = endingPage;
	}
	public ArrayList<Data> getData() {
		return data;
	}
	public void setData(ArrayList<Data> data) {
		this.data = data;
	}
    
    
    
    
}