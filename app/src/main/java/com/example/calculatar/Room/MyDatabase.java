package com.example.calculatar.Room;

import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.calculatar.MainActivity;
import com.example.calculatar.Models.History;

@Database(entities = {History.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase {

    public abstract DAO dao();

}
