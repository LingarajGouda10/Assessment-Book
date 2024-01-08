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


}
