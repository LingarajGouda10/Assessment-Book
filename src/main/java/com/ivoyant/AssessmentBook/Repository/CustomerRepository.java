package com.ivoyant.AssessmentBook.Repository;

import com.ivoyant.AssessmentBook.Model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
}
