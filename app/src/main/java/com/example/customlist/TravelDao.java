package com.example.customlist;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface TravelDao {
    @Query("SELECT * FROM travel")
    List<Travel> getAll();

    @Query("SELECT * FROM travel WHERE id IN (:travelIds)")
    List<Travel> loadAllByIds(int[] travelIds);

    @Query("SELECT * FROM Travel WHERE travel LIKE :travelName LIMIT 1")
    Travel findByName(String travelName);

    @Insert
    void addTravel(Travel travel);

    @Delete
    void delete(Travel travel);

   @Update
    void update(Travel travel);
}
