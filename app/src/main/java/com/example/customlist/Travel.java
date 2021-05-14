package com.example.customlist;

import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity
public class Travel {
    @PrimaryKey(autoGenerate = true)
    int id;
    String travel;

    @Ignore
    public Travel(String travel) {
        this.travel = travel;
    }

    public Travel(int id, String travel) {
        this.id = id;
        this.travel = travel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTravel() {
        return travel;
    }

    public void setTravel(String travel) {
        this.travel = travel;
    }
}
