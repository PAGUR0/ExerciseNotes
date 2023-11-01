package com.example.exercisenotes;

import java.util.ArrayList;
import java.util.List;

public class SingletonList {
    private static SingletonList instance;
    private final List<String[]> listNote;

    /** Приватный конструктор**/

    private SingletonList() {
        listNote = new ArrayList<>();
    }

    /** Метод выполняющий роль конструктора **/

    public static SingletonList getInstance() {
        if (instance == null) {
            instance = new SingletonList();
        }
        return instance;
    }

    /** Метод возвращает элемент списка по позиции **/

    public String[] getItemListNote(int position) {
        return listNote.get(position);
    }

    /** Метод устанавливает значение элементу списка по позиции **/

    public void setItemListNote(int position, String[] item) {
        listNote.set(position, item);
    }

    /** Метод возвращает весь список заметок **/

    public List<String[]> getListNote(){
        return listNote;
    }

    /** Метод добавляет элемент списка **/

    public void addItem(String[] item) {
        listNote.add(item);
    }
}
