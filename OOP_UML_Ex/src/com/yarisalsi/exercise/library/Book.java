package com.yarisalsi.exercise.library;

public class Book extends Item{
    private int pages;
    public Book(String title, int year, int pages) {
        super(title, year);
        this.pages=pages;
    }
    public int getPages(){
        return this.pages;
    }
    public void setPages(int number){
        this.pages=pages;
    }

    @Override
    public String toString() {
        return "Book{" +
                "pages=" + pages +
                '}';
    }
}
