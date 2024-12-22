package com.example.lab_4;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class DeleteNoteActivity extends AppCompatActivity {
    private ListView deleteNotesListView;
    private Button deleteButton;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> notesList;
    private int selectedNotePosition = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_note);

        deleteNotesListView = findViewById(R.id.deleteNotesListView);
        deleteButton = findViewById(R.id.deleteButton);

        notesList = NotesStorage.getNotes(this);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_single_choice, notesList);
        deleteNotesListView.setAdapter(adapter);
        deleteNotesListView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        deleteNotesListView.setOnItemClickListener((parent, view, position, id) -> selectedNotePosition = position);

        deleteButton.setOnClickListener(v -> {
            if (selectedNotePosition != -1) {
                String removedNote = notesList.get(selectedNotePosition);
                NotesStorage.deleteNote(DeleteNoteActivity.this, removedNote);
                Toast.makeText(DeleteNoteActivity.this, "Note deleted", Toast.LENGTH_SHORT).show();
                notesList.remove(selectedNotePosition);
                adapter.notifyDataSetChanged();
                selectedNotePosition = -1;
            } else {
                Toast.makeText(DeleteNoteActivity.this, "Please select a note to delete", Toast.LENGTH_SHORT).show();
            }
        });
    }
}