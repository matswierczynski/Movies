package com.example.matik.add_delete_user_recyclerview;

import static com.example.matik.add_delete_user_recyclerview.Category.ADVENTURE;
import static com.example.matik.add_delete_user_recyclerview.Category.FANTASY;
import static com.example.matik.add_delete_user_recyclerview.Category.THRILLER;

/**
 * Created by matik on 03.04.2018.
 */

class Movie {
    private String title;
    private Category category;
    private Actor [] actors;

    public Movie(String title,Category category, Actor[] actors){
        this.title = title;
        this.category = category;
        this.actors = actors;
    }

    public String getTitle(){
        return title;
    }

    public String getCategoryName() {
        return category.toString();
    }

    public String [] getActorsNames() {
        String [] actorsNames = new String [actors.length];
        for(int i=0; i<actors.length; i++)
            actorsNames[i] = actors[i].toString();
        return actorsNames;
    }

}
