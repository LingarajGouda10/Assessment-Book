package com.ivoyant.AssessmentBook.Repository;

import com.ivoyant.AssessmentBook.Model.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalesRepository extends JpaRepository<Sales,Integer> {
}
