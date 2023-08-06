package co.edureka.irctc.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.UUID;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edureka.irctc.entity.Ticket;
import co.edureka.irctc.models.Passenger;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@RestController
@RequestMapping("/irctc")
@OpenAPIDefinition(info = @Info(title = "IRCTC API Definition", version = "2.0", description = "Train Ticket Booking Application"))
public class TicketRestController {
	@PostMapping(path = "/ticket/new",
				 consumes = {"application/json", "application/xml"},
				 produces = {"application/json", "application/xml"})
	public ResponseEntity<?> newTicketBooking(@RequestBody Passenger psgr){
		Ticket ticket = new Ticket();
		
		ticket.setPassengerName(psgr.getPassengerName());
		ticket.setFromStation(psgr.getFromStation());
		ticket.setToStation(psgr.getToStation());
		ticket.setDateOfJourney(psgr.getDateOfJourney());
		ticket.setTrainNo(psgr.getTrainNo());
		
		String status = new Random().nextBoolean()?"CONFIRMED":"WAITING";
		ticket.setTicketStatus(status);
		
		LocalDateTime dateTimeObj = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
		String dateTime = formatter.format(dateTimeObj);
		ticket.setDateOfBooking(dateTime);
		
		ticket.setTicketFare(1850.50f);
		
		UUID uuid = UUID.randomUUID();
		String randomText = uuid.toString();
		randomText = randomText.replace("-", "");
		String pnr = randomText.substring(0,7).toUpperCase();
		ticket.setPNR(pnr);
		
		return new ResponseEntity<Ticket>(ticket, HttpStatus.CREATED);
	}
}
