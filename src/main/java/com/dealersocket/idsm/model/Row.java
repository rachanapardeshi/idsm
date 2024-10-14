package com.dealersocket.idsm.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Row {
	 @JsonProperty("ContractSalesPrice") 
	    public String contractSalesPrice;
	    @JsonProperty("AcctType") 
	    public String acctType;
	    @JsonProperty("SalesGroupPerson1ID") 
	    public String salesGroupPerson1ID;
	    @JsonProperty("SalesGroupPerson1Commission") 
	    public String salesGroupPerson1Commission;
	    @JsonProperty("SalesGroupPerson2ID") 
	    public String salesGroupPerson2ID;
	    @JsonProperty("SalesGroupPerson2Commission") 
	    public String salesGroupPerson2Commission;
	    @JsonProperty("SalesManagerID") 
	    public String salesManagerID;
	    @JsonProperty("FIUserID") 
	    public String fIUserID;
	    @JsonProperty("ContractCashDown") 
	    public String contractCashDown;
	    @JsonProperty("ContractTotalDeferredDown") 
	    public String contractTotalDeferredDown;
	    @JsonProperty("CurDownPayBal") 
	    public String curDownPayBal;
	    @JsonProperty("AcctCurEstimatedPayoff") 
	    public String acctCurEstimatedPayoff;
	    @JsonProperty("ContractTotalFees") 
	    public String contractTotalFees;
	    @JsonProperty("ContractTotalTaxes") 
	    public String contractTotalTaxes;
	    @JsonProperty("ContractTotalTradeIn") 
	    public String contractTotalTradeIn;
	    @JsonProperty("ContractTotalTradeInPayoff") 
	    public String contractTotalTradeInPayoff;
	    @JsonProperty("LenderName") 
	    public String lenderName;
	    @JsonProperty("Borrower1State") 
	    public String borrower1State;
	    @JsonProperty("ContractTotalProductCost") 
	    public String contractTotalProductCost;
	    @JsonProperty("ContractTotalProductSalesPrice") 
	    public String contractTotalProductSalesPrice;
	    @JsonProperty("ContractAmountFinanced") 
	    public String contractAmountFinanced;
	    @JsonProperty("WarrantyPrice") 
	    public String warrantyPrice;
	    @JsonProperty("WarrantyContractCost") 
	    public String warrantyContractCost;
	    @JsonProperty("OptionalVSIPrice") 
	    public String optionalVSIPrice;
	    @JsonProperty("OptionalVSICost") 
	    public String optionalVSICost;
	    @JsonProperty("DealID") 
	    public String dealID;
	    @JsonProperty("TotalAcctCollected") 
	    public String totalAcctCollected;
	    @JsonProperty("PrimaryLoanTotalMiscFeeAdjusted") 
	    public String primaryLoanTotalMiscFeeAdjusted;
	    @JsonProperty("ContractDate") 
	    public String contractDate;
	    @JsonProperty("CollateralStockNumber") 
	    public String collateralStockNumber;
	    @JsonProperty("AcctCurTotalBalance") 
	    public String acctCurTotalBalance;
	    @JsonProperty("Borrower1FullName") 
	    public String borrower1FullName;
	    @JsonProperty("LenderDesc") 
	    public String lenderDesc;
	    @JsonProperty("CollateralBuyerID") 
	    public String collateralBuyerID;
	    @JsonProperty("CollateralDaysOnLot") 
	    public String collateralDaysOnLot;
	    @JsonProperty("CollateralAcquiredDate") 
	    public String collateralAcquiredDate;
	    @JsonProperty("AcctStatus") 
	    public String acctStatus;
	    @JsonProperty("CollateralVIN") 
	    public String collateralVIN;
	    @JsonProperty("Borrower1SSN") 
	    public String borrower1SSN;
	    @JsonProperty("Borrower2SSN") 
	    public String borrower2SSN;
	    @JsonProperty("Borrower1Address1") 
	    public String borrower1Address1;
	    @JsonProperty("Borrower2FullName") 
	    public String borrower2FullName;
	    @JsonProperty("BookedDate") 
	    public String bookedDate;
	    @JsonProperty("DealWorksheetID") 
	    public String dealWorksheetID;
	    @JsonProperty("Borrower1City") 
	    public String borrower1City;
	    @JsonProperty("Borrower1Zipcode") 
	    public String borrower1Zipcode;
	    @JsonProperty("Borrower2City") 
	    public String borrower2City;
	    @JsonProperty("Borrower2AddressZipcode") 
	    public String borrower2AddressZipcode;
	    @JsonProperty("AcctID") 
	    public String acctID;
	    @JsonProperty("CurDueAmt") 
	    public String curDueAmt;
	    @JsonProperty("NumDaysSinceContractDate") 
	    public String numDaysSinceContractDate;
	    @JsonProperty("ContractLoanRate") 
	    public String contractLoanRate;
	    @JsonProperty("PrimaryLoanOrigTermInMonths") 
	    public String primaryLoanOrigTermInMonths;
	    @JsonProperty("PrimaryLoanCSRegPaymentAmt") 
	    public String primaryLoanCSRegPaymentAmt;
	    @JsonProperty("CollateralYearModel") 
	    public String collateralYearModel;
	    @JsonProperty("CollateralMake") 
	    public String collateralMake;
	    @JsonProperty("CollateralModel") 
	    public String collateralModel;
	    @JsonProperty("PrimaryLoanCSPaymentFrequency") 
	    public String primaryLoanCSPaymentFrequency;
	    @JsonProperty("Borrower1FirstName") 
	    public String borrower1FirstName;
	    @JsonProperty("Borrower1LastName") 
	    public String borrower1LastName;
	    @JsonProperty("Borrower2FirstName") 
	    public String borrower2FirstName;
	    @JsonProperty("Borrower2LastName") 
	    public String borrower2LastName;
	    @JsonProperty("AcctLastPaidDate") 
	    public String acctLastPaidDate;
	    @JsonProperty("CollateralAcquiredFromTypeID") 
	    public String collateralAcquiredFromTypeID;
	    @JsonProperty("CollateralTotalCost") 
	    public String collateralTotalCost;
	    @JsonProperty("DebtCancellationCost") 
	    public String debtCancellationCost;
	    @JsonProperty("DebtCancellation") 
	    public String debtCancellation;
	    @JsonProperty("SalesLocationName") 
	    public String salesLocationName;
	    @JsonProperty("SalesLocationDesc") 
	    public String salesLocationDesc;
	    @JsonProperty("PrimaryLoanCSPaymentsRemaininginMonths") 
	    public String primaryLoanCSPaymentsRemaininginMonths;
	    @JsonProperty("ServiceContractCompanyName") 
	    public String serviceContractCompanyName;
	    @JsonProperty("GAPCompanyName") 
	    public String gAPCompanyName;
	    @JsonProperty("DebtCancellationCompanyName") 
	    public String debtCancellationCompanyName;
	    @JsonProperty("Borrower1CellPhone") 
	    public String borrower1CellPhone;
		public String getContractSalesPrice() {
			return contractSalesPrice;
		}
		public void setContractSalesPrice(String contractSalesPrice) {
			this.contractSalesPrice = contractSalesPrice;
		}
		public String getAcctType() {
			return acctType;
		}
		public void setAcctType(String acctType) {
			this.acctType = acctType;
		}
		public String getSalesGroupPerson1ID() {
			return salesGroupPerson1ID;
		}
		public void setSalesGroupPerson1ID(String salesGroupPerson1ID) {
			this.salesGroupPerson1ID = salesGroupPerson1ID;
		}
		public String getSalesGroupPerson1Commission() {
			return salesGroupPerson1Commission;
		}
		public void setSalesGroupPerson1Commission(String salesGroupPerson1Commission) {
			this.salesGroupPerson1Commission = salesGroupPerson1Commission;
		}
		public String getSalesGroupPerson2ID() {
			return salesGroupPerson2ID;
		}
		public void setSalesGroupPerson2ID(String salesGroupPerson2ID) {
			this.salesGroupPerson2ID = salesGroupPerson2ID;
		}
		public String getSalesGroupPerson2Commission() {
			return salesGroupPerson2Commission;
		}
		public void setSalesGroupPerson2Commission(String salesGroupPerson2Commission) {
			this.salesGroupPerson2Commission = salesGroupPerson2Commission;
		}
		public String getSalesManagerID() {
			return salesManagerID;
		}
		public void setSalesManagerID(String salesManagerID) {
			this.salesManagerID = salesManagerID;
		}
		public String getfIUserID() {
			return fIUserID;
		}
		public void setfIUserID(String fIUserID) {
			this.fIUserID = fIUserID;
		}
		public String getContractCashDown() {
			return contractCashDown;
		}
		public void setContractCashDown(String contractCashDown) {
			this.contractCashDown = contractCashDown;
		}
		public String getContractTotalDeferredDown() {
			return contractTotalDeferredDown;
		}
		public void setContractTotalDeferredDown(String contractTotalDeferredDown) {
			this.contractTotalDeferredDown = contractTotalDeferredDown;
		}
		public String getCurDownPayBal() {
			return curDownPayBal;
		}
		public void setCurDownPayBal(String curDownPayBal) {
			this.curDownPayBal = curDownPayBal;
		}
		public String getAcctCurEstimatedPayoff() {
			return acctCurEstimatedPayoff;
		}
		public void setAcctCurEstimatedPayoff(String acctCurEstimatedPayoff) {
			this.acctCurEstimatedPayoff = acctCurEstimatedPayoff;
		}
		public String getContractTotalFees() {
			return contractTotalFees;
		}
		public void setContractTotalFees(String contractTotalFees) {
			this.contractTotalFees = contractTotalFees;
		}
		public String getContractTotalTaxes() {
			return contractTotalTaxes;
		}
		public void setContractTotalTaxes(String contractTotalTaxes) {
			this.contractTotalTaxes = contractTotalTaxes;
		}
		public String getContractTotalTradeIn() {
			return contractTotalTradeIn;
		}
		public void setContractTotalTradeIn(String contractTotalTradeIn) {
			this.contractTotalTradeIn = contractTotalTradeIn;
		}
		public String getContractTotalTradeInPayoff() {
			return contractTotalTradeInPayoff;
		}
		public void setContractTotalTradeInPayoff(String contractTotalTradeInPayoff) {
			this.contractTotalTradeInPayoff = contractTotalTradeInPayoff;
		}
		public String getLenderName() {
			return lenderName;
		}
		public void setLenderName(String lenderName) {
			this.lenderName = lenderName;
		}
		public String getBorrower1State() {
			return borrower1State;
		}
		public void setBorrower1State(String borrower1State) {
			this.borrower1State = borrower1State;
		}
		public String getContractTotalProductCost() {
			return contractTotalProductCost;
		}
		public void setContractTotalProductCost(String contractTotalProductCost) {
			this.contractTotalProductCost = contractTotalProductCost;
		}
		public String getContractTotalProductSalesPrice() {
			return contractTotalProductSalesPrice;
		}
		public void setContractTotalProductSalesPrice(String contractTotalProductSalesPrice) {
			this.contractTotalProductSalesPrice = contractTotalProductSalesPrice;
		}
		public String getContractAmountFinanced() {
			return contractAmountFinanced;
		}
		public void setContractAmountFinanced(String contractAmountFinanced) {
			this.contractAmountFinanced = contractAmountFinanced;
		}
		public String getWarrantyPrice() {
			return warrantyPrice;
		}
		public void setWarrantyPrice(String warrantyPrice) {
			this.warrantyPrice = warrantyPrice;
		}
		public String getWarrantyContractCost() {
			return warrantyContractCost;
		}
		public void setWarrantyContractCost(String warrantyContractCost) {
			this.warrantyContractCost = warrantyContractCost;
		}
		public String getOptionalVSIPrice() {
			return optionalVSIPrice;
		}
		public void setOptionalVSIPrice(String optionalVSIPrice) {
			this.optionalVSIPrice = optionalVSIPrice;
		}
		public String getOptionalVSICost() {
			return optionalVSICost;
		}
		public void setOptionalVSICost(String optionalVSICost) {
			this.optionalVSICost = optionalVSICost;
		}
		public String getDealID() {
			return dealID;
		}
		public void setDealID(String dealID) {
			this.dealID = dealID;
		}
		public String getTotalAcctCollected() {
			return totalAcctCollected;
		}
		public void setTotalAcctCollected(String totalAcctCollected) {
			this.totalAcctCollected = totalAcctCollected;
		}
		public String getPrimaryLoanTotalMiscFeeAdjusted() {
			return primaryLoanTotalMiscFeeAdjusted;
		}
		public void setPrimaryLoanTotalMiscFeeAdjusted(String primaryLoanTotalMiscFeeAdjusted) {
			this.primaryLoanTotalMiscFeeAdjusted = primaryLoanTotalMiscFeeAdjusted;
		}
		public String getContractDate() {
			return contractDate;
		}
		public void setContractDate(String contractDate) {
			this.contractDate = contractDate;
		}
		public String getCollateralStockNumber() {
			return collateralStockNumber;
		}
		public void setCollateralStockNumber(String collateralStockNumber) {
			this.collateralStockNumber = collateralStockNumber;
		}
		public String getAcctCurTotalBalance() {
			return acctCurTotalBalance;
		}
		public void setAcctCurTotalBalance(String acctCurTotalBalance) {
			this.acctCurTotalBalance = acctCurTotalBalance;
		}
		public String getBorrower1FullName() {
			return borrower1FullName;
		}
		public void setBorrower1FullName(String borrower1FullName) {
			this.borrower1FullName = borrower1FullName;
		}
		public String getLenderDesc() {
			return lenderDesc;
		}
		public void setLenderDesc(String lenderDesc) {
			this.lenderDesc = lenderDesc;
		}
		public String getCollateralBuyerID() {
			return collateralBuyerID;
		}
		public void setCollateralBuyerID(String collateralBuyerID) {
			this.collateralBuyerID = collateralBuyerID;
		}
		public String getCollateralDaysOnLot() {
			return collateralDaysOnLot;
		}
		public void setCollateralDaysOnLot(String collateralDaysOnLot) {
			this.collateralDaysOnLot = collateralDaysOnLot;
		}
		public String getCollateralAcquiredDate() {
			return collateralAcquiredDate;
		}
		public void setCollateralAcquiredDate(String collateralAcquiredDate) {
			this.collateralAcquiredDate = collateralAcquiredDate;
		}
		public String getAcctStatus() {
			return acctStatus;
		}
		public void setAcctStatus(String acctStatus) {
			this.acctStatus = acctStatus;
		}
		public String getCollateralVIN() {
			return collateralVIN;
		}
		public void setCollateralVIN(String collateralVIN) {
			this.collateralVIN = collateralVIN;
		}
		public String getBorrower1SSN() {
			return borrower1SSN;
		}
		public void setBorrower1SSN(String borrower1ssn) {
			borrower1SSN = borrower1ssn;
		}
		public String getBorrower2SSN() {
			return borrower2SSN;
		}
		public void setBorrower2SSN(String borrower2ssn) {
			borrower2SSN = borrower2ssn;
		}
		public String getBorrower1Address1() {
			return borrower1Address1;
		}
		public void setBorrower1Address1(String borrower1Address1) {
			this.borrower1Address1 = borrower1Address1;
		}
		public String getBorrower2FullName() {
			return borrower2FullName;
		}
		public void setBorrower2FullName(String borrower2FullName) {
			this.borrower2FullName = borrower2FullName;
		}
		public String getBookedDate() {
			return bookedDate;
		}
		public void setBookedDate(String bookedDate) {
			this.bookedDate = bookedDate;
		}
		public String getDealWorksheetID() {
			return dealWorksheetID;
		}
		public void setDealWorksheetID(String dealWorksheetID) {
			this.dealWorksheetID = dealWorksheetID;
		}
		public String getBorrower1City() {
			return borrower1City;
		}
		public void setBorrower1City(String borrower1City) {
			this.borrower1City = borrower1City;
		}
		public String getBorrower1Zipcode() {
			return borrower1Zipcode;
		}
		public void setBorrower1Zipcode(String borrower1Zipcode) {
			this.borrower1Zipcode = borrower1Zipcode;
		}
		public String getBorrower2City() {
			return borrower2City;
		}
		public void setBorrower2City(String borrower2City) {
			this.borrower2City = borrower2City;
		}
		public String getBorrower2AddressZipcode() {
			return borrower2AddressZipcode;
		}
		public void setBorrower2AddressZipcode(String borrower2AddressZipcode) {
			this.borrower2AddressZipcode = borrower2AddressZipcode;
		}
		public String getAcctID() {
			return acctID;
		}
		public void setAcctID(String acctID) {
			this.acctID = acctID;
		}
		public String getCurDueAmt() {
			return curDueAmt;
		}
		public void setCurDueAmt(String curDueAmt) {
			this.curDueAmt = curDueAmt;
		}
		public String getNumDaysSinceContractDate() {
			return numDaysSinceContractDate;
		}
		public void setNumDaysSinceContractDate(String numDaysSinceContractDate) {
			this.numDaysSinceContractDate = numDaysSinceContractDate;
		}
		public String getContractLoanRate() {
			return contractLoanRate;
		}
		public void setContractLoanRate(String contractLoanRate) {
			this.contractLoanRate = contractLoanRate;
		}
		public String getPrimaryLoanOrigTermInMonths() {
			return primaryLoanOrigTermInMonths;
		}
		public void setPrimaryLoanOrigTermInMonths(String primaryLoanOrigTermInMonths) {
			this.primaryLoanOrigTermInMonths = primaryLoanOrigTermInMonths;
		}
		public String getPrimaryLoanCSRegPaymentAmt() {
			return primaryLoanCSRegPaymentAmt;
		}
		public void setPrimaryLoanCSRegPaymentAmt(String primaryLoanCSRegPaymentAmt) {
			this.primaryLoanCSRegPaymentAmt = primaryLoanCSRegPaymentAmt;
		}
		public String getCollateralYearModel() {
			return collateralYearModel;
		}
		public void setCollateralYearModel(String collateralYearModel) {
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
		public String getPrimaryLoanCSPaymentFrequency() {
			return primaryLoanCSPaymentFrequency;
		}
		public void setPrimaryLoanCSPaymentFrequency(String primaryLoanCSPaymentFrequency) {
			this.primaryLoanCSPaymentFrequency = primaryLoanCSPaymentFrequency;
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
		public String getBorrower2FirstName() {
			return borrower2FirstName;
		}
		public void setBorrower2FirstName(String borrower2FirstName) {
			this.borrower2FirstName = borrower2FirstName;
		}
		public String getBorrower2LastName() {
			return borrower2LastName;
		}
		public void setBorrower2LastName(String borrower2LastName) {
			this.borrower2LastName = borrower2LastName;
		}
		public String getAcctLastPaidDate() {
			return acctLastPaidDate;
		}
		public void setAcctLastPaidDate(String acctLastPaidDate) {
			this.acctLastPaidDate = acctLastPaidDate;
		}
		public String getCollateralAcquiredFromTypeID() {
			return collateralAcquiredFromTypeID;
		}
		public void setCollateralAcquiredFromTypeID(String collateralAcquiredFromTypeID) {
			this.collateralAcquiredFromTypeID = collateralAcquiredFromTypeID;
		}
		public String getCollateralTotalCost() {
			return collateralTotalCost;
		}
		public void setCollateralTotalCost(String collateralTotalCost) {
			this.collateralTotalCost = collateralTotalCost;
		}
		public String getDebtCancellationCost() {
			return debtCancellationCost;
		}
		public void setDebtCancellationCost(String debtCancellationCost) {
			this.debtCancellationCost = debtCancellationCost;
		}
		public String getDebtCancellation() {
			return debtCancellation;
		}
		public void setDebtCancellation(String debtCancellation) {
			this.debtCancellation = debtCancellation;
		}
		public String getSalesLocationName() {
			return salesLocationName;
		}
		public void setSalesLocationName(String salesLocationName) {
			this.salesLocationName = salesLocationName;
		}
		public String getSalesLocationDesc() {
			return salesLocationDesc;
		}
		public void setSalesLocationDesc(String salesLocationDesc) {
			this.salesLocationDesc = salesLocationDesc;
		}
		public String getPrimaryLoanCSPaymentsRemaininginMonths() {
			return primaryLoanCSPaymentsRemaininginMonths;
		}
		public void setPrimaryLoanCSPaymentsRemaininginMonths(String primaryLoanCSPaymentsRemaininginMonths) {
			this.primaryLoanCSPaymentsRemaininginMonths = primaryLoanCSPaymentsRemaininginMonths;
		}
		public String getServiceContractCompanyName() {
			return serviceContractCompanyName;
		}
		public void setServiceContractCompanyName(String serviceContractCompanyName) {
			this.serviceContractCompanyName = serviceContractCompanyName;
		}
		public String getgAPCompanyName() {
			return gAPCompanyName;
		}
		public void setgAPCompanyName(String gAPCompanyName) {
			this.gAPCompanyName = gAPCompanyName;
		}
		public String getDebtCancellationCompanyName() {
			return debtCancellationCompanyName;
		}
		public void setDebtCancellationCompanyName(String debtCancellationCompanyName) {
			this.debtCancellationCompanyName = debtCancellationCompanyName;
		}
		public String getBorrower1CellPhone() {
			return borrower1CellPhone;
		}
		public void setBorrower1CellPhone(String borrower1CellPhone) {
			this.borrower1CellPhone = borrower1CellPhone;
		}
		@Override
		public String toString() {
			return "AccountListRespModel [contractSalesPrice=" + contractSalesPrice + ", acctType=" + acctType
					+ ", salesGroupPerson1ID=" + salesGroupPerson1ID + ", salesGroupPerson1Commission="
					+ salesGroupPerson1Commission + ", salesGroupPerson2ID=" + salesGroupPerson2ID
					+ ", salesGroupPerson2Commission=" + salesGroupPerson2Commission + ", salesManagerID="
					+ salesManagerID + ", fIUserID=" + fIUserID + ", contractCashDown=" + contractCashDown
					+ ", contractTotalDeferredDown=" + contractTotalDeferredDown + ", curDownPayBal=" + curDownPayBal
					+ ", acctCurEstimatedPayoff=" + acctCurEstimatedPayoff + ", contractTotalFees=" + contractTotalFees
					+ ", contractTotalTaxes=" + contractTotalTaxes + ", contractTotalTradeIn=" + contractTotalTradeIn
					+ ", contractTotalTradeInPayoff=" + contractTotalTradeInPayoff + ", lenderName=" + lenderName
					+ ", borrower1State=" + borrower1State + ", contractTotalProductCost=" + contractTotalProductCost
					+ ", contractTotalProductSalesPrice=" + contractTotalProductSalesPrice + ", contractAmountFinanced="
					+ contractAmountFinanced + ", warrantyPrice=" + warrantyPrice + ", warrantyContractCost="
					+ warrantyContractCost + ", optionalVSIPrice=" + optionalVSIPrice + ", optionalVSICost="
					+ optionalVSICost + ", dealID=" + dealID + ", totalAcctCollected=" + totalAcctCollected
					+ ", primaryLoanTotalMiscFeeAdjusted=" + primaryLoanTotalMiscFeeAdjusted + ", contractDate="
					+ contractDate + ", collateralStockNumber=" + collateralStockNumber + ", acctCurTotalBalance="
					+ acctCurTotalBalance + ", borrower1FullName=" + borrower1FullName + ", lenderDesc=" + lenderDesc
					+ ", collateralBuyerID=" + collateralBuyerID + ", collateralDaysOnLot=" + collateralDaysOnLot
					+ ", collateralAcquiredDate=" + collateralAcquiredDate + ", acctStatus=" + acctStatus
					+ ", collateralVIN=" + collateralVIN + ", borrower1SSN=" + borrower1SSN + ", borrower2SSN="
					+ borrower2SSN + ", borrower1Address1=" + borrower1Address1 + ", borrower2FullName="
					+ borrower2FullName + ", bookedDate=" + bookedDate + ", dealWorksheetID=" + dealWorksheetID
					+ ", borrower1City=" + borrower1City + ", borrower1Zipcode=" + borrower1Zipcode + ", borrower2City="
					+ borrower2City + ", borrower2AddressZipcode=" + borrower2AddressZipcode + ", acctID=" + acctID
					+ ", curDueAmt=" + curDueAmt + ", numDaysSinceContractDate=" + numDaysSinceContractDate
					+ ", contractLoanRate=" + contractLoanRate + ", primaryLoanOrigTermInMonths="
					+ primaryLoanOrigTermInMonths + ", primaryLoanCSRegPaymentAmt=" + primaryLoanCSRegPaymentAmt
					+ ", collateralYearModel=" + collateralYearModel + ", collateralMake=" + collateralMake
					+ ", collateralModel=" + collateralModel + ", primaryLoanCSPaymentFrequency="
					+ primaryLoanCSPaymentFrequency + ", borrower1FirstName=" + borrower1FirstName
					+ ", borrower1LastName=" + borrower1LastName + ", borrower2FirstName=" + borrower2FirstName
					+ ", borrower2LastName=" + borrower2LastName + ", acctLastPaidDate=" + acctLastPaidDate
					+ ", collateralAcquiredFromTypeID=" + collateralAcquiredFromTypeID + ", collateralTotalCost="
					+ collateralTotalCost + ", debtCancellationCost=" + debtCancellationCost + ", debtCancellation="
					+ debtCancellation + ", salesLocationName=" + salesLocationName + ", salesLocationDesc="
					+ salesLocationDesc + ", primaryLoanCSPaymentsRemaininginMonths="
					+ primaryLoanCSPaymentsRemaininginMonths + ", serviceContractCompanyName="
					+ serviceContractCompanyName + ", gAPCompanyName=" + gAPCompanyName
					+ ", debtCancellationCompanyName=" + debtCancellationCompanyName + ", borrower1CellPhone="
					+ borrower1CellPhone + "]";
		}
	    
	    
}
