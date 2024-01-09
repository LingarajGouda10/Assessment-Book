package com.ivoyant.AssessmentBook.Controller;

import com.ivoyant.AssessmentBook.Model.Sales;
import com.ivoyant.AssessmentBook.Service.SalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SalesController {

    @Autowired
    private SalesService service;

    @PostMapping("/addSale")
    public Sales addSales(@RequestBody Sales sales){
        return service.saveSales(sales);
    }

    @PutMapping("/sale")
    public Sales updateSales(@RequestBody Sales sales) {
        return service.upsert(sales);
    }

    @GetMapping("/sales")
    public List<Sales> getAllSales() {
        return service.getAllSales();
    }

    @GetMapping("/sales/{id}")
    public Sales getSalesById(@PathVariable int id) {
        return service.getSalesById(id);
    }

    @DeleteMapping("/sales/{id}")
    public String deleteSale(@PathVariable int id) {
        return service.deleteSales(id);
    }

    @GetMapping("/reports/sales")
    public void getAllSalesDetails(HttpServletResponse servletResponse) throws IOException {
        servletResponse.setContentType("text/csv");
        servletResponse.addHeader("Content-Disposition", "attachment; filename=\"sales.csv\"");
        service.writeSalestocsv(servletResponse.getWriter());
    }



}
