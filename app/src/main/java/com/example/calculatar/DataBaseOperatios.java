package com.example.calculatar;

import android.content.Context;

import androidx.room.Room;

import com.example.calculatar.Room.MyDatabase;

public class DataBaseOperatios {
    MyDatabase myDatabase;
    Context context;

    public DataBaseOperatios(Context context) {
        this.context = context;
    }

    public void roomDbSetUp() {
        myDatabase = Room.databaseBuilder(context, MyDatabase.class, "Historydb").allowMainThreadQueries().build();
    }
}
