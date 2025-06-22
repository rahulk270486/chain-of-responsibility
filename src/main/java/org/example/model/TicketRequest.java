package org.example.model;

import java.io.Serializable;

public record TicketRequest(TicketType type, String description) implements Serializable {
}
