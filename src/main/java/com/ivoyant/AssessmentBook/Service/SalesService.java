package com.ivoyant.AssessmentBook.Service;

import com.ivoyant.AssessmentBook.Model.Sales;
import com.ivoyant.AssessmentBook.Repository.SalesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    @Autowired
    private SalesRepository salesRepository;

    public Sales upsert(Sales sales){

        return salesRepository.save(sales);
    }

    public Sales saveSales(Sales sales){
        return salesRepository.save(sales);
    }

    public List<Sales>getAllSales(){
        return salesRepository.findAll();
    }

    public Sales getSalesById(int id){
        return salesRepository.getById(id);
    }

    public String deleteSales(int id){
        salesRepository.deleteById(id);
        return "sales deleted !" + id;
    }
}
