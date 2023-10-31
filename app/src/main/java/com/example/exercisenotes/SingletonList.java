package com.example.exercisenotes;

import java.util.ArrayList;
import java.util.List;

public class SingletonList {
    private static SingletonList instance;
    private List<String[]> listNote;

    private SingletonList() {
        listNote = new ArrayList<>();
    }

    public static SingletonList getInstance() {
        if (instance == null) {
            instance = new SingletonList();
        }
        return instance;
    }

    public String[] getItemListNote(int position) {
        return listNote.get(position);
    }

    public void setItemListNote(int position, String[] item) {
        listNote.set(position, item);
    }

    public String[] getItemListTheme() {
        String[] theme = new String[listNote.toArray().length];
        for (int i = 0; i < listNote.toArray().length; i++){
            theme[i] = listNote.get(i)[0];
        }
        return theme;

    }


    public void addItem(String[] item) {
        listNote.add(item);
    }

    public void removeItem(String[] item) {
        listNote.remove(item);
    }
}
