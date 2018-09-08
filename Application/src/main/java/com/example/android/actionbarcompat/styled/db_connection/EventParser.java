package com.example.android.actionbarcompat.styled.db_connection;

import com.example.android.actionbarcompat.styled.Event;

import java.util.HashMap;

import static android.provider.Contacts.SettingsColumns.KEY;

public class EventParser implements Parser {

    public static String NAME_KEY = "name";
    public static String DATE_KEY = "date";
    public static String START_TIME_KEY = "startTime";
    public static String END_TIME_KEY = "endTime";
    public static String PLACE_KEY = "place";

    public EventParser() {

    }

    public HashMap<String, Object> parse(Object object) {
        Event event = (Event) object;
        HashMap<String, Object> parsedEvent = new HashMap<>();
        parsedEvent.put(NAME_KEY, event.getName());
        parsedEvent.put(DATE_KEY, event.getDate());
        parsedEvent.put(START_TIME_KEY, event.getStartTime());
        parsedEvent.put(END_TIME_KEY, event.getEndTime());
        parsedEvent.put(PLACE_KEY, event.getPlace());

        return parsedEvent;
    }

    public Object decode(HashMap<String, Object> parsedObject) {
        Event event = new Event(
                (String) parsedObject.get(NAME_KEY),
                (String) parsedObject.get(DATE_KEY),
                (String) parsedObject.get(START_TIME_KEY),
                (String) parsedObject.get(END_TIME_KEY),
                (String) parsedObject.get(PLACE_KEY)
        );

        return event;
    }
}
