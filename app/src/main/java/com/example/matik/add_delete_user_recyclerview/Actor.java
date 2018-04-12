package com.example.matik.add_delete_user_recyclerview;

enum Actor{
    PORTMANN("Natalie", "Portman",6 ,4,1971),
    LEIGH("Jeniffer", "Leigh",8,7,1971),
    THOMPSON("Tessa", "Thompson", 14, 1, 1972),
    RODRIGUEZ("Gina", "Rodriguez", 20, 4, 1972),
    NOVOTNY("Tuva", "Novotny", 29, 12, 1999),
    ISAAC("Oscar", "Isaac", 5, 6, 1996),

    CLARK("Jason", "Clarke", 7, 4, 1993),
    BROLIN("Josh", "Brolin", 7, 9, 1987),
    GYLLENHAAL("Jake", "Gyllenhaal", 13, 11, 1985),
    HAWKES("John", "Hawkes", 6, 2, 1984),
    WRIGHT("Robin", "Wright", 11, 12, 1981),
    WATSON("Emily", "Watson", 31, 7, 1979),
    KELLY("Michael", "Kelly", 8, 3, 1995),
    KNIGHTLEY("Keira", "Knightley", 2, 2, 1976),

    SHERIDAN("Tye", "Sheridan", 29, 12, 1999),
    COOKE("Olivia", "Cooke", 13, 11, 1985),
    MENDELSOHN("Ben", "Mendelsohn", 10, 10, 1983),
    WAITHE("Lena", "Waithe", 13, 11, 1985),
    MILLER("T", "Miller", 11, 12, 1981),
    PEGG("Simon", "Pegg", 29, 12, 1999),

    HAWKINS("Sally", "Hawkins", 31, 7, 1979),
    SHANNON("Michael", "Shannon", 22, 12, 1972),
    JENKINS("Richard", "Jenkins", 28, 6, 1977),
    SPENCER("Octavia", "Spencer", 11, 12, 1981),
    STUHLBARG("Michael", "Stuhlbarg", 18,3 ,1993),
    JONES("Doug", "Jones", 7, 4, 1993),

    VIKANDER("Alicia", "Vikander", 22, 12, 1972),
    WEST("Dominic", "West", 9, 8, 1976),
    GOGGINS("Walton", "Goggins", 24, 1, 1979),
    WU("Daniel", "Wu", 2, 2, 1976),
    THOMAS("Kristin", "Thomas", 5, 6, 1996),
    JACOBI("Derek", "Jacobi", 11, 12, 1981);

    private String name, lastName;
    private int day, month, year;
    Actor(String name, String lastName, int day, int month, int year){
        this.name=name;
        this.lastName=lastName;
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString(){
        return name+" "+lastName;
    }

}
