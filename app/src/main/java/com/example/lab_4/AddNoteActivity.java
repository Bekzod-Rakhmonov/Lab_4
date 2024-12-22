package com.example.lab_4;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {
    private EditText noteTitleEditText, noteContentEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        noteTitleEditText = findViewById(R.id.noteTitleEditText);
        noteContentEditText = findViewById(R.id.noteContentEditText);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = noteTitleEditText.getText().toString().trim();
                String content = noteContentEditText.getText().toString().trim();

                if (title.isEmpty() || content.isEmpty()) {
                    Toast.makeText(AddNoteActivity.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                } else {
                    NotesStorage.saveNote(AddNoteActivity.this, title, content);
                    Toast.makeText(AddNoteActivity.this, "Note saved", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        });
    }
}