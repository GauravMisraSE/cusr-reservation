package com.cmpe275.cusr.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cmpe275.cusr.model.Ticket;
import com.cmpe275.cusr.repositories.TicketRepository;



@Service("ticketService")
@Transactional
public class TicketServiceImpl implements TicketService{

	@Autowired
	private TicketRepository ticketRepository;
	
	@Override
	public Long bookTicket(Ticket ticket) {
		System.out.println("Service method call");
		ticketRepository.save(ticket);
		return  ticket.getId();
	}


}
