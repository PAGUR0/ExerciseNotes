package com.example.exercisenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter<String> adapter;
    private ListView listViewTheme;
    private SingletonList listNote;
    private final int REQUEST_CODE = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listNote = SingletonList.getInstance();

        listViewTheme = findViewById(R.id.listTheme);
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listNote.getItemListTheme());
        listViewTheme.setAdapter(adapter);

        Button buttonAdd = findViewById(R.id.buttonAddNote);

        // Обработчик нажатия на элемент listView
        // При нажатии открывается NoteActivity и в него передается позиции элемент который был нажат
        listViewTheme.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                intent.putExtra("position", i);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        // Обработчик нажатия на кнопку "Добавить заметку"
        // При нажатии добавляется новый элемент в listNote и обновляется содержимое listView
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listNote.addItem(new String[]{"", ""});
                adapter = new ArrayAdapter<>(view.getContext(), android.R.layout.simple_list_item_1, listNote.getItemListTheme());
                listViewTheme.setAdapter(adapter);
            }
        });
    }
    // Метод обрабатывает результаты завершенной дочерней активити
    // Обновляет содержимое listView
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, listNote.getItemListTheme());
                listViewTheme.setAdapter(adapter);
            }
        }
    }
}