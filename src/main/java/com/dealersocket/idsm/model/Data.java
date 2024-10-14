package com.dealersocket.idsm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Data {
	@JsonProperty("Row") 
	public Row row;

	public Row getRow() {
		return row;
	}

	public void setRow(Row row) {
		this.row = row;
	}

	@Override
	public String toString() {
		return "Data [row=" + row + "]";
	}

}