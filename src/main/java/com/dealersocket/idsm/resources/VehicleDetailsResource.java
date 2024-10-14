package com.dealersocket.idsm.resources;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;
import org.springframework.hateoas.Links;
import org.springframework.hateoas.RepresentationModel;


import com.dealersocket.idsm.model.Row;
import com.dealersocket.idsm.model.VehicleDetailsModel;
import com.fasterxml.jackson.annotation.JsonIgnore;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name="VehicleDetailsResource", description="VehicleDetailsResource ")
public class VehicleDetailsResource extends  RepresentationModel<VehicleDetailsResource> {
	private String id;
	private String acctID;
	private String acctType;
	private String borrower1FirstName;
	private String borrower1LastName;
	private String salesGroupPerson1ID;
	private String collateralStockNumber;
	private int collateralYearModel;
	private String collateralMake;
	private String collateralModel;
	private Date contractDate;
	private String contractSalesPrice;
	private Date createdTimestamp;
	private Date updatedTimestamp;

	public VehicleDetailsResource() {};
	public VehicleDetailsResource(String id2, String acctType2, String borrower1FirstName2, String borrower1LastName2,
			String collateralMake2, String collateralModel2, String collateralStockNumber2, int collateralYearModel2,
			Date contractDate2, String contractSalesPrice2, String salesGroupPerson1ID2) {
		// TODO Auto-generated constructor stub
	}

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

	public String getAcctID() {
		return acctID;
	}

	public void setAcctID(String acctID) {
		this.acctID = acctID;
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

   public VehicleDetailsModel toEntityData(Row model ) throws ParseException {
	   
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
		//vm.setContractDate(d);
		vm.setContractSalesPrice(model.getAcctCurTotalBalance());
		vm.setSalesGroupPerson1ID("1111");
		
		//System.out.println("row : "+record.toString());
		String dateStr="";
		//try {
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss a");
		Date d = null;
		//record.getBorrowerName((paymentInfo == null ? null : paymentInfo.getShipToBpn());
		if(model.getContractDate().equals("")|| model.getContractDate()=="" ||StringUtils.isNotBlank(model.getContractDate())) {
			 d = (Date)formatter.parse(model.getContractDate());
			 dateStr="10/3/2024 11:05:05 AM";
		}
		else if(model.getContractDate()!=null  ) {	
			dateStr = model.getContractDate().toString();
			System.out.println("Dtae "+d);
			vm.setContractDate(d);
		}else {
			dateStr="10/3/2024 11:05:05 AM";
		}
	
		
		return vm;
		
	   
   }

	

	@Override
	public String toString() {
		return "VehicleDetailsResource [id=" + id + ", acctType=" + acctType + ", contractSalesPrice="
				+ contractSalesPrice + ", salesGroupPerson1ID=" + salesGroupPerson1ID + ", contractDate=" + contractDate
				+ ", collateralStockNumber=" + collateralStockNumber + ", collateralYearModel=" + collateralYearModel
				+ ", collateralMake=" + collateralMake + ", collateralModel=" + collateralModel
				+ ", borrower1FirstName=" + borrower1FirstName + ", borrower1LastName=" + borrower1LastName
				+ ", acctID=" + acctID + "]";
	}
	
	   @Override
	    @JsonIgnore
	    public Links getLinks() {
	        return null;
	    }
}