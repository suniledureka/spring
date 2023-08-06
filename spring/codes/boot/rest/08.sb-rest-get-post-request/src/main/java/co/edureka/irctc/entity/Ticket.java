package co.edureka.irctc.entity;

import jakarta.xml.bind.annotation.XmlRootElement;
import lombok.Data;

@Data
@XmlRootElement
public class Ticket {
	private String PNR;
	private String passengerName;
	private String fromStation;
	private String toStation;
	private String dateOfJourney;
	private Integer trainNo;	
	private String ticketStatus;
	private String dateOfBooking;
	private Float ticketFare;
}
