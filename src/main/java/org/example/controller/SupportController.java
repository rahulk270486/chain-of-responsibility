package org.example.controller;

import org.example.model.Ticket;
import org.example.model.TicketRequest;
import org.example.service.SupportService;
import org.example.support.SupportHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class SupportController {

    @Autowired
    private SupportService supportService;

    @PostMapping("/ticket")
    public ResponseEntity<String> raiseTicket(@RequestBody TicketRequest ticket){
        return ResponseEntity.ok(supportService.process(ticket));
    }
}
