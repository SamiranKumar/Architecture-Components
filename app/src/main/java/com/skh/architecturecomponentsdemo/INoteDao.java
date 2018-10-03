package com.skh.architecturecomponentsdemo;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;


@Dao
public interface INoteDao {

    @Insert
    void insert(Note note);

    @Update
    void update(Note note);

    @Delete
    void delete(Note note);

    @Query("DELETE FROM  note_table")
    void deleteAllNotes(Note note);

    @Query("SELECT * FROM  note_table ORDER BY piority DESC")
    LiveData<List<Note>> getAllNotes();
}