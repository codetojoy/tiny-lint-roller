package app.tasks;

import models.Book;

import io.ebean.DB;
import java.util.List;

public class SimpleEbeanTask implements Task {
    public SimpleEbeanTask() {
    }
    
    @Override
    public boolean run() {
        for (Book book : getBooks()) {
            System.out.println("TRACER book: " + book.toString());
        }

        return true;
    }
    
    private List<Book> getBooks() {
        List<Book> books = DB.find(Book.class)
                                     .select("id, title, author")
                                     .findList();
        return books;
    }

    private int getNumBooks() {
        return DB.find(Book.class).findList().size();
    }
}
