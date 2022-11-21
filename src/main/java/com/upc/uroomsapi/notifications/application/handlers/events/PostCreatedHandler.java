package com.upc.uroomsapi.notifications.application.handlers.events;

import com.upc.uroomsapi.URoomsApiApplication;
import com.upc.uroomsapi.publications.domain.events.PostCreated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PostCreatedHandler {
    //LOGGER
    private static final Logger Log = LoggerFactory.getLogger(URoomsApiApplication.class);

    public PostCreatedHandler() {}

    public void handle(PostCreated event){
        Log.info("-> REACCIONANDO A EVENTO PostCreated: {}", event);
    }
}
