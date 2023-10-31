package com.example.exercisenotes;

import java.util.ArrayList;
import java.util.List;

public class SingletonList {
    private static SingletonList instance;
    private final List<String[]> listNote;

    private SingletonList() {
        listNote = new ArrayList<>();
    }
    // конструктор
    public static SingletonList getInstance() {
        if (instance == null) {
            instance = new SingletonList();
        }
        return instance;
    }
    // метод возвращает элемент списка по позиции
    public String[] getItemListNote(int position) {
        return listNote.get(position);
    }
    // метод устанавливает значение элементу списка по позиции
    public void setItemListNote(int position, String[] item) {
        listNote.set(position, item);
    }
    // метод формирует список тем и возвращает его
    public String[] getItemListTheme() {
        String[] theme = new String[listNote.toArray().length];
        for (int i = 0; i < listNote.toArray().length; i++){
            theme[i] = listNote.get(i)[0];
        }
        return theme;

    }

    // метод добавляет элемент списка
    public void addItem(String[] item) {
        listNote.add(item);
    }
}
