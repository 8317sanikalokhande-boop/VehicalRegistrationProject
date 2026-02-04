package com.itvedant.vehical.model;

import java.time.LocalDate;

public class Vehical {
	 public int id;
	    public String ownerName;
	    public String vehicleNumber;
	    public String vehicleType;
	    public LocalDate registrationDate;
	    
	    
	    public Vehical(){	

	    }
	    
		public Vehical(int id, String ownerName, String vehicleNumber, String vehicleType, LocalDate registrationDate) {
			super();
			this.id = id;
			this.ownerName = ownerName;
			this.vehicleNumber = vehicleNumber;
			this.vehicleType = vehicleType;
			this.registrationDate = registrationDate;
		}

		@Override
		public String toString() {
			return "Vehicle [id=" + id + ", ownerName=" + ownerName + ", vehicleNumber=" + vehicleNumber
					+ ", vehicleType=" + vehicleType + ", registrationDate=" + registrationDate + "]";
		}


}
