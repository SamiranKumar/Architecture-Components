package com.skh.architecturecomponentsdemo;

import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import android.os.AsyncTask;
import androidx.annotation.NonNull;

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
                    .addCallback(callback)
                    .build();
        }

        return instancesDb;
    }


    private static RoomDatabase.Callback callback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instancesDb).execute();
        }

        /*@Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }*/
    };


    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {

        private INoteDao iNoteDao;

        public PopulateDbAsyncTask(NoteDatabase noteDatabase) {
            iNoteDao = noteDatabase.iNoteDao();

        }

        @Override
        protected Void doInBackground(Void... voids) {
            iNoteDao.insert(new Note("Tittle 1", "note description.... 1", 4));
            iNoteDao.insert(new Note("Tittle 2", "note description.... 2", 1));
            iNoteDao.insert(new Note("Tittle 3", "note description.... 3", 4));
            iNoteDao.insert(new Note("Tittle 4", "note description.... 4", 9));
            iNoteDao.insert(new Note("Tittle 5", "note description.... 5", 6));
            return null;
        }
    }

}
