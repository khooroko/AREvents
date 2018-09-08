package com.example.android.actionbarcompat.styled.db_connection;

import com.google.firebase.database.*;

public class DatabaseComponent {
    public DatabaseComponent() {
        // Write a message to the database
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("message");
        myRef.setValue("Hello, World!");


//// Write a message to the database
    }
}
