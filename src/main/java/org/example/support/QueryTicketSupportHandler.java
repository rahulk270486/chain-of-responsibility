package org.example.support;

import org.example.model.Ticket;
import org.example.model.TicketType;
import org.springframework.stereotype.Component;

@Component
public class QueryTicketSupportHandler implements SupportHandler<Ticket>{

    private SupportHandler<Ticket> nextHandler;

    @Override
    public int getPriority() {
        return 100;
    }

    @Override
    public void handle(Ticket ticket) {
        if(TicketType.QUERY.equals(ticket.type())){
            //process the query, refer the faq
            ticket.messages().add("Handled by "+this.getClass().getSimpleName());
        }else {
            nextHandler.handle(ticket);
        }
    }

    @Override
    public void setNextHandler(SupportHandler<Ticket> nextSupportHandler) {
        this.nextHandler=nextSupportHandler;
    }
}
