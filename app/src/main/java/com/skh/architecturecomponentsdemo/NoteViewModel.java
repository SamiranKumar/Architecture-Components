package com.skh.architecturecomponentsdemo;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<Note>> listLiveData;

    public NoteViewModel(@NonNull Application application) {
        super(application);

        noteRepository = new NoteRepository(application);
        listLiveData = noteRepository.getListLiveData();

    }


    public void insert(Note note) {
        noteRepository.insert(note);
    }


    public void update(Note note) {
        noteRepository.update(note);
    }


    public void delete(Note note) {
        noteRepository.delete(note);
    }


    public void deleteAllNote() {
        noteRepository.deleteAllNote();
    }


    public LiveData<List<Note>> getListLiveData() {
        return listLiveData;
    }



}
