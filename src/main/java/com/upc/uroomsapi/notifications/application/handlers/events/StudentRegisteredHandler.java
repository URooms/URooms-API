package com.upc.uroomsapi.notifications.application.handlers.events;

import com.upc.uroomsapi.URoomsApiApplication;
import com.upc.uroomsapi.users.domain.events.StudentRegistered;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StudentRegisteredHandler {
    private static final Logger Log = LoggerFactory.getLogger(URoomsApiApplication.class);

    public StudentRegisteredHandler() {}

    public void handle(StudentRegistered event){
        Log.info("-> REACCIONANDO A EVENTO StudentRegistered: {}", event);
    }
}
