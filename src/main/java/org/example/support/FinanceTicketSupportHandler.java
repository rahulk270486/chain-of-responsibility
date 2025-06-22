package org.example.support;

import org.example.model.Ticket;
import org.example.model.TicketType;
import org.springframework.stereotype.Component;

@Component
public class FinanceTicketSupportHandler implements SupportHandler<Ticket>{

    private SupportHandler<Ticket> nextHandler;

    @Override
    public int getPriority() {
        return 300;
    }

    @Override
    public void handle(Ticket ticket) {
        if(TicketType.REFUND.equals(ticket.type())){
            //register the refund and send to admin for approval
            ticket.messages().add("Refund prepared by "+this.getClass().getSimpleName());
        }
        nextHandler.handle(ticket);
    }

    @Override
    public void setNextHandler(SupportHandler<Ticket> nextSupportHandler) {
        this.nextHandler=nextSupportHandler;
    }
}
