package assembler;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.dealersocket.idsm.model.VehicleDetailsModel;
import com.dealersocket.idsm.resources.VehicleDetailsResource;

public class VehicleResourceAssembler {

	public VehicleDetailsResource toModel(VehicleDetailsModel entity) {
		// TODO Auto-generated method stub

		//System.out.println("entity ::::::::::::"+entity.getData().get(0).toString());
		VehicleDetailsResource resource = new VehicleDetailsResource();
        resource.setAcctID(entity.getAcctID());
        resource.setAcctType(entity.getAcctType());
        resource.setBorrower1FirstName(entity.getBorrower1FirstName());
        resource.setBorrower1LastName(entity.getBorrower1LastName());
        resource.setCollateralMake(entity.getCollateralMake());
        resource.setCollateralModel(entity.getCollateralModel());
        resource.setCollateralStockNumber(entity.getCollateralStockNumber());
        resource.setCollateralYearModel(entity.getCollateralYearModel());
        resource.setContractDate(entity.getContractDate());
        resource.setContractSalesPrice(entity.getContractSalesPrice());
        resource.setSalesGroupPerson1ID(entity.getSalesGroupPerson1ID());
        
		return resource;

	}
	public List<VehicleDetailsResource> toCollectionModel(List<VehicleDetailsModel> vhList)
	{
		List<VehicleDetailsResource> vhResourceList = new ArrayList<>();
		for( VehicleDetailsModel r : vhList)
		{   
			vhResourceList.add(toModel(r));
		}
		return vhResourceList ;
	}

	public List<VehicleDetailsResource> toCollectionModel1(List<VehicleDetailsModel> audits) {
		return audits.stream().map(this::toModel).collect(Collectors.toList());
	}
}
