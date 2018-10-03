package com.skh.architecturecomponentsdemo;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private NoteViewmodel noteViewmodel;

    @BindView(R.id.rv_note_list)
    RecyclerView rv_note_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        rv_note_list.setLayoutManager(new LinearLayoutManager(this));
        rv_note_list.setHasFixedSize(true);

        final NoteAdapter noteAdapter = new NoteAdapter();
        rv_note_list.setAdapter(noteAdapter);


        noteViewmodel = ViewModelProviders.of(this).get(NoteViewmodel.class);
        noteViewmodel.getListLiveData().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                noteAdapter.setNotes(notes);
            }
        });

    }
}
