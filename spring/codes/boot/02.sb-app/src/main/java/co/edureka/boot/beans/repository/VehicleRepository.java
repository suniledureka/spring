package co.edureka.boot.beans.repository;

import org.springframework.stereotype.Repository;

@Repository
public class VehicleRepository {

	public VehicleRepository() {
		System.out.println("VehicleRepository :: Constructor");
	}
	
}
