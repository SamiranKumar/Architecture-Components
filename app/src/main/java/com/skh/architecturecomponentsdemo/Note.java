package com.skh.architecturecomponentsdemo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String tittle;
    private String description;
    private String piority;


    public Note(String tittle, String description, String piority) {
        this.tittle = tittle;
        this.description = description;
        this.piority = piority;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getTittle() {
        return tittle;
    }

    public String getDescription() {
        return description;
    }

    public String getPiority() {
        return piority;
    }


    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", piority='" + piority + '\'' +
                '}';
    }
}
