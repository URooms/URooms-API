package com.upc.uroomsapi.notifications.application.handlers.events;

import com.upc.uroomsapi.URoomsApiApplication;
import com.upc.uroomsapi.publications.domain.events.ReviewCreated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ReviewCreatedHandler {
    private static final Logger Log = LoggerFactory.getLogger(URoomsApiApplication.class);

    public ReviewCreatedHandler() {}

    public void handle(ReviewCreated event){
        Log.info("-> REACCIONANDO A EVENTO ReviewCreated: {}", event.toString());
    }
}
