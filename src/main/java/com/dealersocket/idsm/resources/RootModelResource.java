package com.dealersocket.idsm.resources;


import java.util.ArrayList;

import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;

import com.dealersocket.idsm.model.Data;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="RootModelResource", description="RootModelResource")
public class RootModelResource extends  RepresentationModel<RootModelResource> {
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

	public RootModelResource(String status, String message, String totalPages, String beginningPage,
			String endingPage, String totalRecords, ArrayList<Data> data) {
	}
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

	@Override
	public String toString() {
		return "RootModelResource [status=" + status + ", message=" + message + ", totalRecords=" + totalRecords
				+ ", totalPages=" + totalPages + ", pageNumber=" + pageNumber + ", beginningPage=" + beginningPage
				+ ", endingPage=" + endingPage + ", data=" + data + "]";
	}
	@Override
	@JsonIgnore
	public Links getLinks() {
		return null;
	}


}