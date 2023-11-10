package com.yarisalsi.exercise.library;

import java.time.LocalDate;
import java.util.ArrayList;

public class TestApp {
    /*A library needs a software system for managing subscribers, rents of books and dvds, and be notified about late returns.

     Books can be modelled with a title (String), a publication year (int), and a number of pages (int).
     Dvds can be modelled with a title (String), a publication year (int), and a length in minutes (int).
     People can be modelled with an id (String), a name (String), and a lastname (String).
     Rents can be modelled with an item (a book or a dvd), a person, and two dates representing the beginning and the end of the rent.
     The library itself can be modelled as a List<Rent> and provides methods for adding/removing rents a method getExpired() returning all the late rents.
     Provide and implementation of all the needed classes.

     Refer to the UML diagram, JavaDoc documentation, and unit tests for further inspiration.*/
    public static void main(String[] args){

        Book b1=new Book("promessi sposi",1821,500);
        Book b2=new Book("Pinocchio",1881,500);
        Book b3= new Book("La Divina Commedia",1307,1000);
        Dvd d1=new Dvd("Asterix and Obelix",2010,120);
        Person p1=new Person("19b","Pirelli","Matteo");
        Person p2=new Person("19c","Bianchi","Lia");
        Rent r1=new Rent(b1,p1,LocalDate.of(2020,10,10),LocalDate.of(2020,11,12));
        Rent r2=new Rent(b2,p2,LocalDate.of(2022,1,1),LocalDate.of(2023,11,12));
        Rent r3=new Rent(b3,p1,LocalDate.of(2021,10,10),LocalDate.of(2023,11,12));
        Rent r4=new Rent(d1,p1,LocalDate.of(2020,10,10),LocalDate.of(2020,11,12));
        Library lb=new Library();
        lb.addRent(r1);
        lb.addRent(r2);
        lb.addRent(r4);
        Library lb2=new Library();
        lb2.addRent(r3);
        lb2.addRent(r2);

        System.out.println("the first library has Expired?");
        ArrayList<Rent> exp= lb.getExpired(LocalDate.now());
        for(Rent rent: exp){
            System.out.println("\n->book expired ->"+rent);
        }
    }
}
