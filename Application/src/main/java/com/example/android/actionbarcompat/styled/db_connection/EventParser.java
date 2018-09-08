package com.example.android.actionbarcompat.styled.db_connection;

import com.example.android.actionbarcompat.styled.Event;

import java.util.HashMap;

public class EventParser implements Parser {

    public static String EVENT_NAME = "name";

    public EventParser() {

    }

    public HashMap<String, Object> parse(Object object) {
        Event event = (Event) object;
        HashMap<String, Object> parsedEvent = new HashMap<>();
        parsedEvent.put(EVENT_NAME, event.getName());

        return parsedEvent;
    }
}
