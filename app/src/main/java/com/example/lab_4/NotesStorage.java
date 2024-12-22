package com.example.lab_4;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NotesStorage {
    private static final String PREFS_NAME = "NotesStorage";
    private static final String NOTES_KEY = "notes";

    // Retrieve all notes
    public static ArrayList<String> getNotes(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Set<String> notesSet = prefs.getStringSet(NOTES_KEY, new HashSet<>());
        return new ArrayList<>(notesSet);
    }

    // Save a new note
    public static void saveNote(Context context, String title, String content) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Set<String> notesSet = prefs.getStringSet(NOTES_KEY, new HashSet<>());
        notesSet.add(title + ": " + content);
        prefs.edit().putStringSet(NOTES_KEY, notesSet).apply();
    }

    // Delete a note
    public static void deleteNote(Context context, String note) {
        SharedPreferences prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        Set<String> notesSet = prefs.getStringSet(NOTES_KEY, new HashSet<>());
        notesSet.remove(note);
        prefs.edit().putStringSet(NOTES_KEY, notesSet).apply();
    }
}
