package com.ivoyant.AssessmentBook.Service;

import com.ivoyant.AssessmentBook.Model.Inventory;
import com.ivoyant.AssessmentBook.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {

    @Autowired
    private  InventoryRepository inventoryRepository;

    public  Inventory upsert(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    public  Inventory saveInventory(Inventory inventory){
        return inventoryRepository.save(inventory);
    }

    public  List<Inventory>getAllInventories(){
        return inventoryRepository.findAll();
    }

    public  Inventory getInventoryById(int id){
        return inventoryRepository.getById(id);
    }

    public  String deleteInventory(int id){
        inventoryRepository.deleteById(id);
        return "inventory deleted !" + id;
    }

    public void writeInventorytocsv(PrintWriter writer) {
        List<Inventory> inventories = inventoryRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("bookId", "quantity", "bookName", "publisher");
            for (Inventory inventory : inventories) {
                csvPrinter.printRecord(inventory.getBookId(), inventory.getQuantity(), inventory.getBookName(),
                        inventory.getPublisher());
            }
        } catch (IOException e) {
            System.out.println("Error While Writing csv" + e);
        }


}
