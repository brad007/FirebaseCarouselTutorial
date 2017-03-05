package com.fire.fire.firebasecarouseltutorial.models;

import java.util.ArrayList;

/**
 * Created by brad on 2017/03/05.
 */

public class Item {
    String title;
    ArrayList<String> items;

    public Item() {
    }

    public Item(String title, ArrayList<String> items) {

        this.title = title;
        this.items = items;
    }

    public String getTitle() {

        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getItems() {
        return items;
    }

    public void setItems(ArrayList<String> items) {
        this.items = items;
    }
}
