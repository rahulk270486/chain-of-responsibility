package org.example.support;

import org.example.model.Ticket;

public interface SupportHandler<T> {

    default int  getPriority(){
        return 0;
    }

    void handle(T t);

    void setNextHandler(SupportHandler<T> nextSupportHandler);
}
