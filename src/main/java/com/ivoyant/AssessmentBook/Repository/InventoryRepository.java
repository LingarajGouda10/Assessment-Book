package com.ivoyant.AssessmentBook.Repository;

import com.ivoyant.AssessmentBook.Model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Integer> {
}
