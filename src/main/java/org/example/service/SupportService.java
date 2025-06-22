package org.example.service;

import org.example.model.Ticket;
import org.example.model.TicketRequest;
import org.example.support.SupportHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.UUID;

@Service
public class SupportService {

    @Autowired
    @Qualifier("initialHandler")
    private SupportHandler<Ticket> ticketSupportHandler;


    public String process(TicketRequest ticketRequest) {
        String id= UUID.randomUUID().toString();
        Ticket ticket = new Ticket(id, ticketRequest.type(), ticketRequest.description(), Instant.now(), new ArrayList<>());
        ticket.messages().add("Registered");
        ticketSupportHandler.handle(ticket);
        for(String message : ticket.messages()){
            System.out.println(message);
        }
        return id;
    }
}
