package service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dealersocket.idsm.model.VehicleDetailsModel;

public interface AccountRepository extends JpaRepository<VehicleDetailsModel, String> {
}