package com.yarisalsi.exercise.library;

import java.sql.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;

public class Library {
    ArrayList<Rent> rents;
    public Library(){
        rents=new ArrayList<Rent>();
    }
    public boolean addRent(Rent r){
        if(rents.contains(r) == false)
        {
            rents.add(r);
            return true;
        }
        return false;
    }
    public boolean removeRent(Rent r){
        return rents.remove(r);
    }

    public ArrayList<Rent> getExpired(LocalDate time){

        ArrayList<Rent> tmp=new ArrayList<Rent>();

        for(Rent rent: rents){
            if(rent.isExpired(LocalDate.now())){
                tmp.add(rent);
            }
        }
        return tmp;
    }
}
