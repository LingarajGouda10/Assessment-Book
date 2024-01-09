package com.ivoyant.AssessmentBook.Service;

import com.ivoyant.AssessmentBook.Model.Book;
import com.ivoyant.AssessmentBook.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private  BookRepository bookRepository;

    public  Book upsert(Book book){
        return bookRepository.save(book);
    }

    public  Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public  List<Book>getAllBooks(){
        return bookRepository.findAll();
    }

    public  Book getBookById(int id){
        return bookRepository.getById(id);
    }

    public  String deleteBook(int id){
        bookRepository.deleteById(id);
        return "product removed !" + id;
    }

    public void writeBooktocsv(PrintWriter writer) {
        List<Book> books = bookRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("ID", "Title", "Author", "Genre", "Date", "Price");
            for (Book book : books) {
                csvPrinter.printRecord(book.getId(), book.getTitle(), book.getAuthor(), book.getGenre(), book.getDate()
                        , book.getPrice());
            }
        } catch (IOException e) {
            System.out.println("Error While Writing csv" + e);
        }


}
