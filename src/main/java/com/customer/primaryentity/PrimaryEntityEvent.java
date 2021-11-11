package com.customer.primaryentity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.net.URI;
import java.time.Instant;

public class PrimaryEntityEvent {

    private Instant eventCreatedInstant;

    private URI uri;

    @JsonCreator
    public PrimaryEntityEvent(@JsonProperty(value = "eventCreatedInstant") Instant eventCreatedInstant, @JsonProperty(value = "uri") URI uri) {
        this.eventCreatedInstant = eventCreatedInstant;
        this.uri = uri;
    }

    public URI getUri() {
        return uri;
    }

    public Instant getEventCreatedInstant() {
        return eventCreatedInstant;
    }
}
