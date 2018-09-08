package com.example.android.actionbarcompat.styled.db_connection;

import android.support.annotation.NonNull;
import android.util.Log;

import com.example.android.actionbarcompat.styled.Event;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import org.w3c.dom.Document;

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
        HashMap<String, Object> parsedEvent = new EventParser().parse(event);

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