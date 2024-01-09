package com.ivoyant.AssessmentBook.Controller;

import com.ivoyant.AssessmentBook.Model.Book;
import com.ivoyant.AssessmentBook.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService service;

    @PostMapping("/addBook")
    public Book addBook( @RequestBody Book book) {
        return service.saveBook(book);
    }

    @PutMapping("/book")
    public Book updateBook(@RequestBody Book book){
        return service.upsert(book);
    }

    @GetMapping("/books")
    public List<Book> getAllBooks(){
        return service.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable int id){
        return  service.getBookById(id);
    }

    @DeleteMapping("/book/{id}")
    public String deleteBook(@PathVariable int id){
        return service.deleteBook(id);
    }

    @GetMapping("/reports/books")
    public void getAllBookDetails(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"book.csv\"");
        service.writeBooktocsv(servletResponse.getWriter());
    }

}
