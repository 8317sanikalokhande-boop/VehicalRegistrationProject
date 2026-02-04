package com.itvedant.vehical.test;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import com.itvedant.vehical.dao.VehicalDao;
import com.itvedant.vehical.daoimpl.VehicalDaoImpl;
import com.itvedant.vehical.model.Vehical;

public class VehicalTest {
	public static void main(String [] args) {
		VehicalDao dao = new VehicalDaoImpl();
		Scanner sc = new Scanner(System.in);
		
		while(true) {
			 System.out.println("\n--- Vehicle Registration Menu ---");
	            System.out.println("1. Add Vehicle");
	            System.out.println("2. Update Vehicle");
	            System.out.println("3. Delete Vehicle");
	            System.out.println("4. View All Vehicles");
	            System.out.println("5. Get Vehicle By ID");
	            System.out.println("6. Get Vehicle By Number");
	            System.out.println("7. Exit");
	            
	            int choice= sc.nextInt();
	            String owner,number,type,datestr;
	            int id;
	             Vehical v;
	             boolean response;
	             
	             switch (choice) {
	             
	             case 1: System.out.println("enter ownwername,vehicleNumber, vehicleType, registrationDate(yyyy-MM-dd )");
	             owner = sc.next();
	             number= sc.next();
	             type=sc.next();
	             datestr= sc.next();
	             LocalDate rd =null;
	            
	             try {
	            if(!"null".equalsIgnoreCase(datestr))
	            	rd= LocalDate.parse(datestr);
	             }
	             catch(Exception e) {
	            	 
	             }
	             
	             v= new Vehical(0,owner,number,type,rd);
	             response=dao.addVehicle(v);
	             
	             if(response) {
	            	 System.out.println("vehical added..!!");
	            	 
	             }
	             else {
	            	 System.out.println("sorry..!! could not added the record");
	             }
	             break;
	             
	             case 2:
	            	 System.out.println("Enter the vehical id");
	            	 id = sc.nextInt();
	            	 v=dao.getVehicleById(id);
	            	 if(v==null) {
	            		 System.out.println("vehical not found");
	            	 break;
	            	 }
	            	 System.out.println("Enter the Ownername,VehicalNumber,VehicalType,RegisterDate");
	            	 owner=sc.next();
	            	 number=sc.next();
	            	 type=sc.next();
	            	 datestr=sc.next();
	            	 LocalDate update=null;
	            	 
	            	 try {
	            	        if (!"null".equalsIgnoreCase(datestr))
	            	            update = LocalDate.parse(datestr);
	            	    } catch (Exception e) {
	            	    }
	            	 
	            	 
	            	 v= new Vehical(id,owner,number,type,update);
	            	 response=dao.updateVehicle(v);
	            	 
	            	 if(response) {
	            		 System.out.println("Vehical updated..!!");
	            	 }
	            		 else {
	            			 System.out.println("Sorry...could not updated!!");
	            		 }
	            		 break;
	          
	             case 3:
	            	 
	            	 System.out.println("Enter the id ");
	            	 id=sc.nextInt();
	            	 response =dao.deleteVehicle(id);
	            	 if(response) {
	            		 System.out.println(" vehical deleted...!! ");
	            	 }
	            		 else {
	            			 System.out.println("sorry.. could not be delete");
	            		 }
	            	 
	            	 break;
	            	 
	             case 4:
	             
	            	  System.out.println("enter the vehicle id");
	                  id = sc.nextInt();
	                  v = dao.getVehicleById(id);
	                  if (v != null)
                      System.out.println(v);
                  else
                      System.out.println("plz enter valid vehicle id");
	                  break;
	            	 
	             case 5:
	            	 
	            	 System.out.println("Enter vehical Id to search: ");
	            	 id=sc.nextInt();
	            	 Vehical found =dao.getVehicleById(id);
	            	 if(found !=null)
	            		 System.out.println(found);
	            	 else
	            		 System.out.println("Vehical not found !");
	            	  break;
	            	  
	            	
	             case 6:
	            	 System.out.println("Enter the vehicle number:");
	            	    String num = sc.next();
	            	    
	            	    Vehical veh = dao.getVehicleByNumber(num);
	            	    if (veh != null)
	            	        System.out.println(veh);
	            	    else
	            	        System.out.println("Vehicle not found");
	            	    
	            	    break;
	            	    
	             case 7:
	            	 System.out.println("thank you for visting our application..!!");
	     			System.exit(0);
	     			break;
	            	 
	            
	            	 
	            	 }
	            
	            	 
	            	 }
	          
	             }
	           	
		}
	
	

