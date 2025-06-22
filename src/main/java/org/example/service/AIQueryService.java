package org.example.service;

import org.example.model.AIServerResponse;
import org.example.model.Ticket;
import org.springframework.stereotype.Service;

@Service
public class AIQueryService {

    public AIServerResponse queryTicketToAIModel(Ticket ticket){
        // mock the AI call with ticket details
        //returning dummy response
        return new AIServerResponse("Lorem Ipsum",Math.random()>0.4?97.846:60.234);
    }
}
