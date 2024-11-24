package org.example.exam.Service;

import com.sun.jdi.ArrayReference;
import org.example.exam.Model.Book;
import org.example.exam.Model.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BookService {



    ArrayList<Book> books = new ArrayList<Book>();



    public ArrayList<Book> getBooks(){
        return books;
    }

    public void  addBook(Book book){

        books.add(book);
    }

    public boolean updateBook(String ID, Book book){

        for (int i = 0; i < books.size(); i++) {

            if(books.get(i).getID().equals(ID)){

                books.set(i, book);
                return true;
            }

        }
        return false;
    }



    public boolean deleteBook(String ID){

        for(Book b : books){
            if(b.getID().equals(ID)){

                books.remove(b);
                return true;
            }


        }
        return false;
    }


    public Book bookName(String bookName){

        for(Book b : books){
            if(b.getName().equalsIgnoreCase(bookName))
                return b;

        }
        return null;

    }

    public ArrayList<Book> sameCategory(String category){
        ArrayList<Book> sameCategory = new ArrayList<>();

        for(Book b : books){
            if(b.getCategory().equalsIgnoreCase(category))
                sameCategory.add(b);
        }

        return sameCategory;
    }


    public ArrayList<Book> samePages(int numOfPages){

       ArrayList<Book> samePages = new ArrayList<>()  ;

       for(Book b : books){
           if(b.getNumber_of_pages() == numOfPages || b.getNumber_of_pages() >= numOfPages)
               samePages.add(b);
       }

        return samePages;

    }


    public boolean changeStatus(String ID, String role){

        if(!(role.equalsIgnoreCase("librarian"))) {
             return false;
        }
            for(Book b  : books){
                if(b.getID().equals(ID) && b.isAvailable() && role.equalsIgnoreCase("librarian")){
                    b.setAvailable(false);
                    return true;
                }
            }

             return false;
    }





}
