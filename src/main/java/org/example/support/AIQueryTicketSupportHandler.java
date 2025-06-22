package org.example.support;

import org.example.model.AIServerResponse;
import org.example.model.Ticket;
import org.example.model.TicketType;
import org.example.service.AIQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AIQueryTicketSupportHandler implements SupportHandler<Ticket>{

    private SupportHandler<Ticket> nextHandler;

    @Autowired
    private AIQueryService aiQueryService;

    @Override
    public int getPriority() {
        return 95;
    }

    @Override
    public void handle(Ticket ticket) {
        if(TicketType.QUERY.equals(ticket.type())){
            //process the query, refer the AI
            AIServerResponse aiResponse = aiQueryService.queryTicketToAIModel(ticket);
            if(aiResponse.confidenceScore()>90.0){
                ticket.messages().add("Handled by "+this.getClass().getSimpleName());
            }else{
                nextHandler.handle(ticket);
            }
        }else {
            nextHandler.handle(ticket);
        }
    }

    @Override
    public void setNextHandler(SupportHandler<Ticket> nextSupportHandler) {
        this.nextHandler=nextSupportHandler;
    }
}
