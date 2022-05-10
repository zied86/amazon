package com.e2eTests.automatedTests.utilis;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GetCurrentHourAndDate {
		
		public String getActualHeure() {
			
	    	SimpleDateFormat h = new SimpleDateFormat ("hh:mm");   	 
	    	Date currentTime_1 = new Date();    	 
	    	String heureString = h.format(currentTime_1);
	    	return heureString;

		}
		
		public String getActualDate() {
			
			SimpleDateFormat d = new SimpleDateFormat ("dd/MM/yyyy" );    	 
	    	Date currentTime_1 = new Date(); 
	    	String dateString = d.format(currentTime_1);
	    	return dateString;
	    	
		}
		
		public String getActualDateHeure() {
			
			SimpleDateFormat formatter= new SimpleDateFormat("dd/MM/yyyy '-' HH:mm");
			Date date = new Date(System.currentTimeMillis());
			return formatter.format(date);
			
	    	
		}

	}


