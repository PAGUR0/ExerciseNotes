package com.example.exercisenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;

public class NoteActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_activity);

        Intent intent = getIntent();

        SingletonList listNote = SingletonList.getInstance();

        int input = intent.getIntExtra("position", 0);

        String[] Note = listNote.getItemListNote(input);

        EditText themeName = findViewById(R.id.themeName);
        themeName.setText(Note[0]);

        EditText themeText = findViewById(R.id.themeText);
        themeText.setText(Note[1]);

        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listNote.setItemListNote(input, new String[]{String.valueOf(themeName.getText()), String.valueOf(themeText.getText())});
                Intent mainintent = new Intent(NoteActivity.this, MainActivity.class);

                startActivity(mainintent);
                finish();
            }
        });
    }
}
