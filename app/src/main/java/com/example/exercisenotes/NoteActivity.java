package com.example.exercisenotes;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class NoteActivity extends AppCompatActivity {

    private SingletonList listNote;
    private int input;
    private EditText themeText;
    private EditText themeName;
    private Intent intent;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.note_activity);

        listNote = SingletonList.getInstance();
        // Получение позиции нажатого элемента из MainActivity
        intent = getIntent();
        input = intent.getIntExtra("position", 0);

        String[] Note = listNote.getItemListNote(input);
        // Устнавливается тема заметки
        themeName = findViewById(R.id.themeName);
        themeName.setText(Note[0]);
        // Устнавливается текст заметки
        themeText = findViewById(R.id.themeText);
        themeText.setText(Note[1]);

        Button buttonBack = findViewById(R.id.buttonBack);
        // Обработчик нажатия на кнопку "Назад"
        // При нажатии изменяется открытый элемент listNote
        buttonBack.setOnClickListener(view -> {
            listNote.setItemListNote(input, new String[]{String.valueOf(themeName.getText()), String.valueOf(themeText.getText())});
            setResult(RESULT_OK, intent);
            finish();
        });
    }
    //Метод обрабатывает нажатие на "Back", а именно передает информацию о удачном закрытии активити для обновления listView в MainActivity
    @Override
    public void onBackPressed() {
        listNote.setItemListNote(input, new String[]{String.valueOf(themeName.getText()), String.valueOf(themeText.getText())});
        setResult(RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }
}
