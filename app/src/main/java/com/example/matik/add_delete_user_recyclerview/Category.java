package com.example.matik.add_delete_user_recyclerview;

/**
 * Created by matik on 03.04.2018.
 */

public enum Category {
    THRILLER("Thriller"),
    ADVENTURE("Adventure"),
    FANTASY("Fantasy");

    private String categoryName;
    Category(String categoryName){
        this.categoryName=categoryName;
    }

    @Override
    public String toString(){
        return categoryName;
    }
}
