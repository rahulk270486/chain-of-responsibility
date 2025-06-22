package org.example.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

public record Ticket(String id, TicketType type, String description, Instant instant, List<String> messages) implements Serializable {
}
