package com.example.exercisenotes;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {
    private SingletonList singletonList;

    private static class ViewHolder {
        TextView textView;
    }

    /** Конструктор адаптера **/

    public CustomAdapter() {
        this.singletonList = SingletonList.getInstance();
    }

    /** Метод возвращает длинну списка**/

    @Override
    public int getCount() {
        return singletonList.getListNote().toArray().length;
    }

    /** Метод возвращает содержание заметки **/

    @Override
    public String[] getItem(int position) {
        return singletonList.getItemListNote(position);
    }

    /** Метод возвращает элемент **/

    @Override
    public long getItemId(int position) {
        return position;
    }

    /** Метод задает внешний вид listView **/

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_layout, parent, false);
            holder = new ViewHolder();
            holder.textView = convertView.findViewById(R.id.textView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        String item = (String) getItem(position)[0];

        holder.textView.setText(item);

        return convertView;
    }

    /** Метод для добавления нового элемента **/

    public void addItem(String[] item) {
        singletonList.addItem(item);
        notifyDataSetChanged();
    }

    /** Метод для обновления элемента **/

    public void updateItem(int position, String[] newItem) {
        singletonList.setItemListNote(position, newItem);
        notifyDataSetChanged();
    }
}