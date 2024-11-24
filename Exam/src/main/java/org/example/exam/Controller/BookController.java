package org.example.exam.Controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.exam.ApiResponse.ApiResponse;
import org.example.exam.Model.Book;
import org.example.exam.Service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/LMS/book")
@RequiredArgsConstructor

public class BookController {

    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity getBook(){
        ArrayList<Book> books = bookService.getBooks();
        return ResponseEntity.status(200).body(books);

    }
    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody @Valid Book book, Errors errors){

        if(errors.hasErrors())
            return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());


        bookService.addBook(book);

        return ResponseEntity.status(200).body(new ApiResponse("Book added!"));

    }

    @PutMapping("/update/{ID}")
    public ResponseEntity updateBook(@PathVariable String ID, @RequestBody @Valid Book book, Errors errors){

        if(errors.hasErrors())
           return ResponseEntity.status(400).body(errors.getFieldError().getDefaultMessage());


        boolean isUpdated = bookService.updateBook(ID, book);

        if(isUpdated)
            return ResponseEntity.status(200).body(new ApiResponse("Book updated!"));

        return ResponseEntity.status(400).body(new ApiResponse("ID of this book not found!"));


    }


    @DeleteMapping("/delete/{ID}")
    public ResponseEntity deleteBook (@PathVariable String ID){


        boolean isDeleted = bookService.deleteBook(ID);

        if(isDeleted)
            return ResponseEntity.status(200).body(new ApiResponse("Book deleted!"));

        return ResponseEntity.status(400).body(new ApiResponse("This ID not found!"));

    }
    @GetMapping("/book-name/{bookName}")
    public ResponseEntity bookName(@PathVariable String bookName){

     Book b = bookService.bookName(bookName);

      return ResponseEntity.status(200).body(b);


    }

    @GetMapping("/sameCat/{category}")
    public ResponseEntity sameCategory(@PathVariable String category){

        ArrayList<Book> books= bookService.sameCategory(category);

        return ResponseEntity.status(200).body(books);

    }
    @GetMapping("/same-pages/{numOfPages}")
    public ResponseEntity samePages(@PathVariable int numOfPages){

        ArrayList<Book> books = bookService.samePages(numOfPages);

        return ResponseEntity.status(200).body(books);


    }
     @PutMapping("/change/{ID}/{role}")
    public ResponseEntity changeStatus(@PathVariable String ID, @PathVariable String role){

        boolean isChanged = bookService.changeStatus(ID, role);

        if(isChanged)
            return ResponseEntity.status(200).body(new ApiResponse("Status of this book changed!"));

        if(!(role.equalsIgnoreCase("librarian")))
            return ResponseEntity.status(400).body(new ApiResponse("Only the librarian can change the status of the book!"));

        return ResponseEntity.status(400).body(new ApiResponse("Book with this ID not found!"));




    }


}
