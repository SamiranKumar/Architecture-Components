package com.skh.architecturecomponentsdemo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "note_table")
public class Note {
    @PrimaryKey(autoGenerate = true)
    private int id;
    private String tittle;
    private String description;
    private int priority;


    public Note(String tittle, String description, int priority) {
        this.tittle = tittle;
        this.description = description;
        this.priority = priority;
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

    public int getPriority() {
        return priority;
    }


    @Override
    public String toString() {
        return "Note{" +
                "id=" + id +
                ", tittle='" + tittle + '\'' +
                ", description='" + description + '\'' +
                ", priority='" + priority + '\'' +
                '}';
    }
}
