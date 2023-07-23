package co.edureka.boot.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Ticket {
	@Value("AAF984J")
	private String pnr;
	
	@Value("${ticket.passenger.name}")
	private String passengerName;
	
	public Ticket() {
		System.out.println("Ticket :: Constructor");
	}

	@Override
	public String toString() {
		return "Ticket [PNR= " + pnr + " | PASSENGER NAME= " + passengerName + "]";
	}
	
	
}
