package com.ivoyant.AssessmentBook;

import com.ivoyant.AssessmentBook.Controller.InventoryController;
import com.ivoyant.AssessmentBook.Model.Inventory;
import com.ivoyant.AssessmentBook.Model.Sales;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class InventoryControllerTest {

    @Autowired
    private InventoryController inventoryController;

    @Test
    public void testInventoryController(){
        Inventory inventory=new Inventory();
        inventory.setBookId(2);
        inventory.setPublisher("qwerty");
        inventory.setQuantity(5);
        inventory.setBookName("abcde");

        String result= inventoryController.addInventory(inventory.getBookId(),inventory.getBookName(),inventory,
                new Inventory());

        assertEquals(null,result);
        assertEquals(2,inventory.getBookId());
        assertEquals("abcde",inventory.getBookName());
    }
}
