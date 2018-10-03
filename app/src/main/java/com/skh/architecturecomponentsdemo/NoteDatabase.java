package com.skh.architecturecomponentsdemo;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;

import static com.skh.architecturecomponentsdemo.NoteDatabase.DB_VERSION;

@Database(entities = Note.class, version = DB_VERSION)
public abstract class NoteDatabase extends RoomDatabase {

    public static final int DB_VERSION = 1;


    private static NoteDatabase instancesDb;

    public abstract INoteDao iNoteDao();

    public static synchronized NoteDatabase getDatabase() {


        if (instancesDb == null) {
            instancesDb = Room.databaseBuilder(App.getContext(), NoteDatabase.class, "note_db")
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return instancesDb;
    }


}
