package com.example.matik.add_delete_user_recyclerview;

import java.util.Calendar;

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

    public Integer [] getActorsAges(){
        Integer [] actorsAges = new Integer[actors.length];
        for(int i=0; i<actors.length; i++)
            actorsAges[i] = getActorAge(actors[i].getDay(), actors[i].getMonth(),
                                        actors[i].getYear());
        return actorsAges;
    }

    private Integer getActorAge(Integer dayOfBirth, Integer monthOfBirth,
                                 Integer yearOfBirth) {

        Calendar now = Calendar.getInstance();
        int nowMonth = now.get(Calendar.MONTH)+1; //numeration starts from 0, increase to 1
        int nowDayOfMonth = now.get(Calendar.DAY_OF_MONTH);
        int nowYear = now.get(Calendar.YEAR);

        int result = nowYear - yearOfBirth;

        if (monthOfBirth > nowMonth)
            result--;
        else if (monthOfBirth == nowMonth) {
            if (dayOfBirth > nowDayOfMonth)
                result--;
        }

        return result;
    }

}
