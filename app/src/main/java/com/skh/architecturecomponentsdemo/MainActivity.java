package com.skh.architecturecomponentsdemo;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private NoteViewModel noteViewmodel;

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


        noteViewmodel = ViewModelProviders.of(this).get(NoteViewModel.class);
        noteViewmodel.getListLiveData().observe(this, new Observer<List<Note>>() {
            @Override
            public void onChanged(@Nullable List<Note> notes) {
                noteAdapter.setNotes(notes);
            }
        });

    }
}
