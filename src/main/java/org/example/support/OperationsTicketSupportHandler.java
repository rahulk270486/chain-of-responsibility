package org.example.support;

import org.example.model.Ticket;
import org.example.model.TicketType;
import org.springframework.stereotype.Component;

@Component
public class OperationsTicketSupportHandler implements SupportHandler<Ticket>{

    private SupportHandler<Ticket> nextHandler;

    @Override
    public int getPriority() {
        return 200;
    }

    @Override
    public void handle(Ticket ticket) {
        if(TicketType.ACTION.equals(ticket.type())){
            //register and start processing the action
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
