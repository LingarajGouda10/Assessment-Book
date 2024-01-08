package com.ivoyant.AssessmentBook.Repository;

import com.ivoyant.AssessmentBook.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
}
