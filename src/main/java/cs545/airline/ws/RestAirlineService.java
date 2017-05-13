
package cs545.airline.ws;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs545.airline.dao.AirlineDao;
import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

@Path("/airline")
public class RestAirlineService {
	
	// Not the best way of doing it, but it works for this project
	private AirlineService airlineService = new AirlineService(new AirlineDao());
	
	@GET
	public String helloWorld(@DefaultValue("Gorgeous") @QueryParam("name") String name) {
		return "Hello "+name+"!";
	}
	
	
	@Path("name")
	@GET
	public String getAirlineTest() {
		String result = "Nil!";
		List<Airline> airlines = airlineService.findAll();
		
		for(Airline airline : airlines) {
			result = "This is an airline: "+airline.getName();
		}
		return result;
	}
	
	
	
	@Path("list")
	@GET
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	//public List<Airline> getAirlinelist() {
	public Airline getAirlinelist() {
		String result = "Nil!";
		List<Airline> airlines = airlineService.findAll();
		
		
		return airlines.get(0);
	}

	
}


/*
package edu.mum.cs545.ws;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import cs545.airline.dao.AirlineDao;
import cs545.airline.model.Airline;
import cs545.airline.service.AirlineService;

@Path("/airline")
public class HelloRest {
	
	// Not the best way of doing it, but it works for this project
	private AirlineService airlineService = new AirlineService(new AirlineDao());
	
	@GET
	public String helloWorld(@DefaultValue("Gorgeous") @QueryParam("name") String name) {
		return "Hello "+name+"!";
	}
	
	
	@Path("test")
	@GET
	public String getAirlineTest() {
		String result = "Nil!";
		List<Airline> airlines = airlineService.findAll();
		
		for(Airline airline : airlines) {
			result = "This is an airline: "+airline.getName();
		}
		return result;
	}
	
	@Path("vvvv")
	@GET
	public String getAirvvv() {
		String result = "Nil!";
		List<Airline> airlines = airlineService.findAll();
		
		for(Airline airline : airlines) {
			result = "This is an airline: "+airline.getName();
		}
		return "vvvv";
	}
	
	/*
	@Path("all")
	@GET
	//@Produces({ MediaType.APPLICATION_XML,MediaType.TEXT_HTML , MediaType.APPLICATION_JSON })
	public List<Airline> getAllAirline() {
		List<Airline> airlines = airlineService.findAll();	
		return airlines;
	}

	
}
*/
