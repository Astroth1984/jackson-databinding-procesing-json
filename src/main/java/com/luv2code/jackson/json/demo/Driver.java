package com.luv2code.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		
		try {
			// create object mapper
			ObjectMapper mapper = new ObjectMapper();
			
			// read JSON  file and map/convert to Java POJO: 
			// data/sample-lite.json
			
			Student theStudent = mapper.readValue(
						new File("data/sample-lite.json"), Student.class);
			
			// print first name and last name
			System.out.println("First name = " + theStudent.getFirstName());
			System.out.println("Last name = " + theStudent.getLastName());
			
			
			System.out.println("\n ====>>>>>> new Student POJOS <<<<<=======");
			
			// Read Data from sample-full json file
			Student fullStudent = mapper.readValue(new File("data/sample-full.json"), Student.class);
			System.out.println("First name = " + fullStudent.getFirstName());
			System.out.println("Last name = " + fullStudent.getLastName());
			
			// Print the Street Adress and City
			Address tempAddress = fullStudent.getAddress();
			System.out.println("the Street: " + tempAddress.getStreet());
			System.out.println("City: " + tempAddress.getCity());
			
			// Print out the languages
			int i =1;
			for(String lang: fullStudent.getLanguages()) {
				System.out.println(i +"- "+ lang);
				i++;	
			}
			
			

		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}




