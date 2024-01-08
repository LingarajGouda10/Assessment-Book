package com.ivoyant.AssessmentBook;

import com.ivoyant.AssessmentBook.Controller.BookController;
import com.ivoyant.AssessmentBook.Model.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BookControllerTest {

    @Autowired
    private BookController bookController;

    @Test
    public void testBookController(){
        Book book=new Book();
        book.setId(77);
        book.setTitle("ivoyant");
        book.setPrice(999);
        book.setAuthor("Human");

        Book result=bookController.addBook(book.getId(),book.getTitle(),book.getPrice(),book,new Book());

        assertEquals(null,result);
        assertEquals(77,book.getId());
        assertEquals(999,book.getPrice());
        assertEquals("Human",book.getAuthor());
    }
}
