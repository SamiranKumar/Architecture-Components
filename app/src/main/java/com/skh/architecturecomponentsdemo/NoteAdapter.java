package com.skh.architecturecomponentsdemo;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes;


    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_note_item, viewGroup, false);
        return new NoteHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder noteHolder, int i) {

        Note note = notes.get(i);
        noteHolder.bind(note);
    }


    @Override
    public int getItemCount() {
        return notes != null ? notes.size() : 0;
    }


    public void setNotes(List<Note> notes) {
        this.notes = notes;
        notifyDataSetChanged();
    }

    class NoteHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.tv_tittle)
        TextView tv_tittle;

        @BindView(R.id.tv_description)
        TextView tv_description;

        @BindView(R.id.tv_priority)
        TextView tv_priority;

        @BindView(R.id.tv_id)
        TextView tv_id;

        public NoteHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }


        public void bind(Note note) {
            tv_tittle.setText(note.getTittle());
            tv_priority.setText(note.getPriority()+"");
            tv_description.setText(note.getDescription());
            tv_id.setText(note.getId()+"");
        }
    }
}
