package com.example.Cassandra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestWebService {
	
	EventRepository eventRepository;
	
	@Autowired
	public RestWebService(EventRepository eventRepository) {
		this.eventRepository = eventRepository;

		Event event = new Event();
		event.setId(1L);
		event.setName("event1");

		eventRepository.save(event);

	}
	
	@RequestMapping(value = "/", method=RequestMethod.GET)
	@ResponseBody
	@ResponseStatus(HttpStatus.OK) 
	public Event getPerson() {
		Event event = eventRepository.findById(1L).get();
		return event;
	}

}
