

-- -----------------------------------------------------------------------------------------
-- accountTypes---
-- -----------------------------------------------------------------------------------------
CREATE TABLE IF NOT EXISTS accountTypes (
  id BIGINT NOT NULL AUTO_INCREMENT,
  name VARCHAR(60) NOT NULL,
  description VARCHAR(256) NOT NULL,
  inserted_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS salesLocations (
 id BIGINT NOT NULL AUTO_INCREMENT,
  description VARCHAR(256) NOT NULL,
  inserted_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);



CREATE TABLE IF NOT EXISTS accountStatus (
  id BIGINT NOT NULL AUTO_INCREMENT,
  description VARCHAR(256) NOT NULL,
  inserted_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id)
);


CREATE TABLE IF NOT EXISTS vehicleDetails (
 
  id BIGINT NOT NULL AUTO_INCREMENT,
  acctID VARCHAR(60) NOT NULL,
  acctType VARCHAR(60),  
  borrower1FirstName VARCHAR(128) ,
  borrower1LastName VARCHAR(128),
  salesGroupPerson1ID VARCHAR(256) ,     
  collateralStockNumber VARCHAR(60), 
  collateralYearModel YEAR,
  collateralMake VARCHAR(256) ,
  collateralModel VARCHAR(256),
  contractDate  DATETIME NULL,
  contractSalesPrice BIGINT , 
  inserted_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL,
  updated_timestamp TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP NOT NULL,
  PRIMARY KEY (id),
    UNIQUE INDEX vehicle_acctID (acctID));
  
  
  
  
  
  
  

