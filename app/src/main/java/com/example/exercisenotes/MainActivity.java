package com.example.exercisenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listViewTheme = findViewById(R.id.listTheme);

        SingletonList listNote = SingletonList.getInstance();

        ArrayAdapter adapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1, listNote.getItemListTheme());

        listViewTheme.setAdapter(adapter);
        listViewTheme.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                intent.putExtra("position", i);
                startActivity(intent);
                finish();
            }
        }
        );

        Button buttonAdd = findViewById(R.id.buttonAddNote);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listNote.addItem(new String[]{"", ""});
                finish();
                startActivity(getIntent());
            }
        });
    }
}