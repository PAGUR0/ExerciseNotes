package com.example.exercisenotes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private CustomAdapter adapter;
    private ListView listViewTheme;
    private final int REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listViewTheme = findViewById(R.id.listTheme);
        adapter = new CustomAdapter();
        listViewTheme.setAdapter(adapter);

        Button buttonAdd = findViewById(R.id.buttonAddNote);

        /** Обработчик нажатия на элемент listView. При нажатии открывается NoteActivity и в него передается позиции элемент который был нажат **/

        listViewTheme.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(MainActivity.this, NoteActivity.class);
                intent.putExtra("position", i);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });

        /** Обработчик нажатия на кнопку "Добавить заметку". При нажатии добавляется новый элемент в listNote и обновляется содержимое listView **/

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter.addItem(new String[]{"", ""});
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                int position = data.getIntExtra("position", 0);
                String[] stringNote = data.getStringArrayExtra("note");
                adapter.updateItem(position, stringNote);
            }
        }
    }
}