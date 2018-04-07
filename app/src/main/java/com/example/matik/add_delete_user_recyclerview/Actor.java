package com.example.matik.add_delete_user_recyclerview;

/**
 * Created by matik on 03.04.2018.
 */

enum Actor {
    PORTMANN("Natalie", "Portman"),
    LEIGH("Jeniffer", "Leigh"),
    THOMPSON("Tessa", "Thompson"),
    RODRIGUEZ("Gina", "Rodriguez"),
    NOVOTNY("Tuva", "Novotny"),
    ISAAC("Oscar", "Isaac"),

    CLARK("Jason", "Clarke"),
    BROLIN("Josh", "Brolin"),
    GYLLENHAAL("Jake", "Gyllenhaal"),
    HAWKES("John", "Hawkes"),
    WRIGHT("Robin", "Wright"),
    WATSON("Emily", "Watson"),
    KELLY("Michael", "Kelly"),
    KNIGHTLEY("Keira", "Knightley"),

    SHERIDAN("Tye", "Sheridan"),
    COOKE("Olivia", "Cooke"),
    MENDELSOHN("Ben", "Mendelsohn"),
    WAITHE("Lena", "Waithe"),
    MILLER("T.J.", "Miller"),
    PEGG("Simon", "Pegg"),

    HAWKINS("Sally", "Hawkins"),
    SHANNON("Michael", "Shannon"),
    JENKINS("Richard", "Jenkins"),
    SPENCER("Octavia", "Spencer"),
    STUHLBARG("Michael", "Stuhlbarg"),
    JONES("Doug", "Jones"),

    VIKANDER("Alicia", "Vikander"),
    WEST("Dominic", "West"),
    GOGGINS("Walton", "Goggins"),
    WU("Daniel", "Wu"),
    THOMAS("Kristin", "Thomas"),
    JACOBI("Derek", "Jacobi");

    private String name, lastName;
    Actor(String name, String lastName){
        this.name=name;
        this.lastName=lastName;
    }

    @Override
    public String toString(){
        return name+" "+lastName;
    }

}
