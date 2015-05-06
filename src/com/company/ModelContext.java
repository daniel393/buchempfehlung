package com.company;

/**
 * Created by auler on 06.05.2015.
 */
public class ModelContext {

    private static String books;
    private final static ModelContext instance = new ModelContext(books);

    public ModelContext(String books) {
        this.books = books;
    }

    public static ModelContext getInstance() {
            return instance;
        }

    public static void setBooks(String books) {
        ModelContext.books = books;
    }

    public String getCurrentBooks() {
            return books;
        }
    }
