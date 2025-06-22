package org.example.support;

import org.example.model.Ticket;
import org.springframework.stereotype.Component;

@Component
public class AdminTicketSupportHandler implements SupportHandler<Ticket> {

    private SupportHandler<Ticket> nextHandler;

    @Override
    public int getPriority() {
        return 500;
    }

    @Override
    public void handle(Ticket ticket) {
        //handle all kind of tickets
        ticket.messages().add("Handled by "+this.getClass().getSimpleName());
    }

    @Override
    public void setNextHandler(SupportHandler<Ticket> nextSupportHandler) {
        this.nextHandler=nextSupportHandler;
    }
}
