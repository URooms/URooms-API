package com.upc.uroomsapi.notifications.application.handlers.events;

import com.upc.uroomsapi.URoomsApiApplication;
import com.upc.uroomsapi.users.domain.events.OwnerRegistered;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OwnerRegisteredHandler {
    //LOGGER
    private static final Logger Log = LoggerFactory.getLogger(URoomsApiApplication.class);

    public OwnerRegisteredHandler() {}

    public void handle(OwnerRegistered event){
        Log.info("-> REACCIONANDO A EVENTO OwnerRegistered: {}", event);
    }
}
