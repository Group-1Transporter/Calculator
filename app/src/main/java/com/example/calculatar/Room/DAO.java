package com.example.calculatar.Room;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DAO {

    @Insert
    public void historyInsertion(History history);

    @Query("select*from History")
    List<History> getHistory();

    @Query("delete from History")
    void deleteAllHistory();


}
