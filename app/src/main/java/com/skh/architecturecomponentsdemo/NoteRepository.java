package com.skh.architecturecomponentsdemo;

import android.app.Application;
import androidx.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

public class NoteRepository {

    private INoteDao iNoteDao;
    private LiveData<List<Note>> listLiveData;

    public NoteRepository(Application application) {
        NoteDatabase noteDatabase = NoteDatabase.getDatabase();

        iNoteDao = noteDatabase.iNoteDao();
        listLiveData = iNoteDao.getAllNotes();
    }


    public void insert(Note note) {
        new InsertNoteAsyncTask(iNoteDao).execute(note);
    }


    public void update(Note note) {
        new UpdateNoteAsyncTask(iNoteDao).execute(note);
    }


    public void delete(Note note) {
        new DeleteNoteAsyncTask(iNoteDao).execute(note);
    }


    public void deleteAllNote() {
        new DeleteAllNoteAsyncTask(iNoteDao).execute();
    }


    public LiveData<List<Note>> getListLiveData() {
        return listLiveData;
    }


    private static class InsertNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private INoteDao iNoteDao;

        public InsertNoteAsyncTask(INoteDao iNoteDao) {
            this.iNoteDao = iNoteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            iNoteDao.insert(notes[0]);
            return null;
        }
    }



    private static class UpdateNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private INoteDao iNoteDao;

        public UpdateNoteAsyncTask(INoteDao iNoteDao) {
            this.iNoteDao = iNoteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            iNoteDao.update(notes[0]);
            return null;
        }
    }




    private static class DeleteNoteAsyncTask extends AsyncTask<Note, Void, Void> {
        private INoteDao iNoteDao;

        public DeleteNoteAsyncTask(INoteDao iNoteDao) {
            this.iNoteDao = iNoteDao;
        }

        @Override
        protected Void doInBackground(Note... notes) {

            iNoteDao.delete(notes[0]);
            return null;
        }
    }



    private static class DeleteAllNoteAsyncTask extends AsyncTask<Void, Void, Void> {
        private INoteDao iNoteDao;

        public DeleteAllNoteAsyncTask(INoteDao iNoteDao) {
            this.iNoteDao = iNoteDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {

            iNoteDao.deleteAllNotes();
            return null;
        }
    }


}
