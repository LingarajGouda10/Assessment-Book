package com.ivoyant.AssessmentBook.Controller;

import com.ivoyant.AssessmentBook.Model.Inventory;
import com.ivoyant.AssessmentBook.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController {

    @Autowired
    private InventoryService service;

    @PostMapping("/addInventory")
    public Inventory addInventory( @RequestBody Inventory inventory){
        return service.saveInventory(inventory);
    }

    @PutMapping("/inventory")
    public Inventory updateInventory(@RequestBody Inventory inventory) {
        return service.upsert(inventory);
    }

    @GetMapping("/inventories")
    public List<Inventory> getAllInventories() {
        return service.getAllInventories();
    }

    @GetMapping("/inventory/{id}")
    public Inventory getInventoryById(@PathVariable int id) {
        return service.getInventoryById(id);
    }

    @DeleteMapping("/inventory/{id}")
    public String deleteInventory(@PathVariable int id) {
        return service.deleteInventory(id);
    }

    @GetMapping("/reports/inventory")
    public void getAllInventoryDetails(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"inventory.csv\"");
        service.writeInventorytocsv(servletResponse.getWriter());
    }

}
