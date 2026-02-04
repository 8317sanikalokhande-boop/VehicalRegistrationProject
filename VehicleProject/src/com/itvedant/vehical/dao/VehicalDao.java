package com.itvedant.vehical.dao;

import java.util.List;

import com.itvedant.vehical.model.Vehical;

public interface VehicalDao {
	boolean addVehicle (Vehical v);
	
	boolean updateVehicle(Vehical v);
	
	boolean deleteVehicle(int id);
	
	List<Vehical> getAllVehicle();
	
	Vehical getVehicleById(int id);
	
	 Vehical getVehicleByNumber(String vehicleNumber);

	 
}
