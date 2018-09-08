package com.example.android.actionbarcompat.styled.db_connection;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.actionbarcompat.styled.Event;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static com.google.android.gms.common.util.WorkSourceUtil.TAG;

public class DatabaseComponent {

    private static String FIRST_NAME_KEY = "first";
    private static String LAST_NAME_KEY = "last";
    private static String BIRTH_YEAR_KEY = "born";

    private static String USERS_COLLECTION_NAME = "users";

    private static FirebaseFirestore db;

    public DatabaseComponent() {
        db = FirebaseFirestore.getInstance();
    }

    public void connect() {
    }

    public void addEvent(Event event) {
        CollectionReference events = db.collection("events");
        HashMap<String, Object> parsedEvent = new EventParser().parse(event);
        events.document(String.format("%s:%s",
                parsedEvent.get(EventParser.NAME_KEY),
                parsedEvent.get(EventParser.PLACE_KEY)
        )).set(parsedEvent);

    }

    public ArrayList<Event> getEvents() {
        final ArrayList<Event> events = new ArrayList<>();

        CollectionReference eventsReference = db.collection("events");
        eventsReference.get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()) {
                    for (QueryDocumentSnapshot document : task.getResult()) {
                        Log.d(TAG, document.getId() + " => " + document.getData());
                        HashMap<String, Object> parsedEvent = (HashMap)document.getData();
                        Event event = (Event) (new EventParser().decode(parsedEvent));
                        events.add(event);
                        System.out.println(event.getName());
                    }
                } else {
                    Log.d(TAG, "Error getting documents: ", task.getException());
                }
            }
        });

        return events;
    }

/*    public List<Event> getFilteredList() {

    }*/
    public void test_addDummyEventData() {
        Event data1 = new Event(
                "Facebook Hackathon",
                "09/09/2018",
                "0000",
                "1200",
                "9 Straits View"
                );
        addEvent(data1);

        Event data2 = new Event(
                "Not Facebook Hackathon",
                "09/09/2018",
                "0000",
                "1700",
                "Marina Bay"
        );
        addEvent(data2);

        Event data3 = new Event(
                "Really not Facebook Hackathon",
                "09/09/2018",
                "0000",
                "1200",
                "Botanic Gardens"
        );
        addEvent(data3);
    }

    public void addUser(String firstName, String lastName, int birthYear) {
        Map<String, Object> user = new HashMap<>();
        user.put(FIRST_NAME_KEY, firstName);
        user.put(LAST_NAME_KEY, lastName);
        user.put(BIRTH_YEAR_KEY, birthYear);

        db.collection(USERS_COLLECTION_NAME).add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DcoumentSnpshot added with ID: " + documentReference);
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.w(TAG, "Error adding document", e);
            }
        });
    }
}