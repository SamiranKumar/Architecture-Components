package com.skh.architecturecomponentsdemo;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

public class NoteViewmodel extends AndroidViewModel {

    private NoteRepository noteRepository;
    private LiveData<List<Note>> listLiveData;

    public NoteViewmodel(@NonNull Application application) {
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
