package com.dealersocket.idsm.test;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.dealersocket.idsm.controller.TaskController;
import com.dealersocket.idsm.dao.VehicleDetailsDao;

import errorHandlers.ErrorCode;
import junit.framework.Assert;

import static org.mockito.Mockito.mock;

public class TaskControllerTest {

	
	
	@Test
	public void listSubscriptionsSourceOrderLineRequiresSourceOrderRef() {
		
		VehicleDetailsDao vhDao = mock(VehicleDetailsDao.class);

		TaskController controller = new TaskController( vhDao);

		try {	
			controller.getVehicleDetails(null);
		
		} catch (Exception e) {
			
		}
	}
}
