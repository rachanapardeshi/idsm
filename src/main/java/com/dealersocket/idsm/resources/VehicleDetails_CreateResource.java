package com.dealersocket.idsm.resources;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.RepresentationModel;

import com.dealersocket.idsm.model.Row;
import com.dealersocket.idsm.model.VehicleDetailsModel;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "VehicleDetails_CreateResource", description = "")
public class VehicleDetails_CreateResource extends RepresentationModel<VehicleDetails_CreateResource> {
	private String id;
	@NotNull
	private String acctType;
	@NotNull
	private String contractSalesPrice;
	@NotNull
	private String salesGroupPerson1ID;
	@NotNull
	private Date contractDate;
	@NotNull
	private int collateralStockNumber;
	@NotNull
	private int collateralYearModel;
	@NotNull
	private String collateralMake;
	@NotNull
	private String collateralModel;
	@NotNull
	private String borrower1FirstName;
	@NotNull
	private String borrower1LastName;
	@NotNull
	private String acctID;

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

	public int getCollateralStockNumber() {
		return collateralStockNumber;
	}

	public void setCollateralStockNumber(int collateralStockNumber) {
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

	  public VehicleDetailsModel toEntityData(Row model ) throws ParseException  {
		   
		    VehicleDetailsModel vm = new VehicleDetailsModel();	
		    vm.setContractSalesPrice(model.getContractSalesPrice());
		    vm.setAcctID(model.getAcctID());
			vm.setAcctType(model.getAcctStatus());
			vm.setBorrower1FirstName(model.getBorrower1FirstName());
			vm.setBorrower1LastName(model.getBorrower1LastName());
			vm.setCollateralMake(model.getCollateralMake());
			vm.setCollateralModel(model.getCollateralModel());
			vm.setCollateralStockNumber(model.getCollateralStockNumber());
			vm.setCollateralYearModel(getCollateralYearModel());
			
			vm.setContractSalesPrice(model.getAcctCurTotalBalance());
			vm.setSalesGroupPerson1ID(model.getSalesGroupPerson1ID());
			
			//System.out.println("row : "+record.toString());
			String dateStr="";
			//try {
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
			Date d = null;
			//record.getBorrowerName((paymentInfo == null ? null : paymentInfo.getShipToBpn());
			if(model.getContractDate().toString().equals("") || model.getContractDate().toString()=="" || (!StringUtils.isNotBlank(model.getContractDate().toString()))) {
				 dateStr="10/3/2024 11:05:05 AM";
				 d = (Date)formatter.parse(dateStr);
				 vm.setContractDate(d);
			}
			else if(model.getContractDate()!=null  ) {	
				d = (Date)formatter.parse(model.getContractDate().toString());
				vm.setContractDate(d);
			}	
			return vm;
			   
	   }

}