package com.example.android.actionbarcompat.styled.db_connection;

import java.util.HashMap;

public interface Parser {
    public HashMap<String, Object> parse(Object object);

    public Object decode(HashMap<String, Object> object);
}
