package com.dealersocket.idsm.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.NaturalId;
import javax.persistence.Table;
import org.hibernate.annotations.NaturalId;
import javax.persistence.*;

@Entity(name="com.dealersocket.idsm.VehicleDetailsModel")
@Table(name="vehicledetails")
public class VehicleDetailsModel {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private String id;
	
	//acctID
	@Column(name="acctID")
	private String acctID;
	//acctType
	@Column(name="acctType")
	private String acctType;
	//borrower1FirstName
	@Column(name="borrower1FirstName")
	private String borrower1FirstName;
	//borrower1LastName
	@Column(name="borrower1LastName")
	private String borrower1LastName;
	//salesGroupPerson1ID
	@Column(name="salesGroupPerson1ID")
	private String salesGroupPerson1ID;
	//collateralStockNumber
	@Column(name="collateralStockNumber")
	private String collateralStockNumber;
	//collateralYearModel
	@Column(name="collateralYearModel")
	private int collateralYearModel;
	//collateralMake
	@Column(name="collateralMake")
	private String collateralMake;
	//collateralModel
	@Column(name="collateralModel")
	private String collateralModel;
	//
	@Column(name="contractDate")
	private Date contractDate;
	//contractSalesPrice
	@Column(name="contractSalesPrice")
	private String contractSalesPrice;

	@Column(name = "inserted_timestamp", insertable = false, updatable = false)
	private Date createdTimestamp;
	
	@Column(name = "updated_timestamp", insertable = false, updatable = false)
	private Date updatedTimestamp;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAcctType() {
		return acctType;
	}

	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}

	public String getContractSalesPrice() {
		return contractSalesPrice;
	}

	public void setContractSalesPrice(String contractSalesPrice) {
		this.contractSalesPrice = contractSalesPrice;
	}

	public String getSalesGroupPerson1ID() {
		return salesGroupPerson1ID;
	}

	public void setSalesGroupPerson1ID(String salesGroupPerson1ID) {
		this.salesGroupPerson1ID = salesGroupPerson1ID;
	}

	public Date getContractDate() {
		return contractDate;
	}

	public void setContractDate(Date contractDate) {
		this.contractDate = contractDate;
	}

	public String getCollateralStockNumber() {
		return collateralStockNumber;
	}

	public void setCollateralStockNumber(String collateralStockNumber) {
		this.collateralStockNumber = collateralStockNumber;
	}

	public int getCollateralYearModel() {
		return collateralYearModel;
	}

	public void setCollateralYearModel(int collateralYearModel) {
		this.collateralYearModel = collateralYearModel;
	}

	public String getCollateralMake() {
		return collateralMake;
	}

	public void setCollateralMake(String collateralMake) {
		this.collateralMake = collateralMake;
	}

	public String getCollateralModel() {
		return collateralModel;
	}

	public void setCollateralModel(String collateralModel) {
		this.collateralModel = collateralModel;
	}

	public String getBorrower1FirstName() {
		return borrower1FirstName;
	}

	public void setBorrower1FirstName(String borrower1FirstName) {
		this.borrower1FirstName = borrower1FirstName;
	}

	public String getBorrower1LastName() {
		return borrower1LastName;
	}

	public void setBorrower1LastName(String borrower1LastName) {
		this.borrower1LastName = borrower1LastName;
	}
	public String getAcctID() {
		return acctID;
	}

	public void setAcctID(String acctID) {
		this.acctID = acctID;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}
	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}


}
