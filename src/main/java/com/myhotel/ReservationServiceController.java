package com.myhotel;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value="/api")
public class ReservationServiceController {
	
	@Autowired 
	private RoomReservationService roomReservationService;

	@RequestMapping(method=RequestMethod.GET, value="/reservations/{date}")

	public List<RoomReservation> getAllReservationsForDate(@PathVariable(value="date")String dateString) {
		return this.roomReservationService.getRoomReservationsForDate(dateString);
	}
}
