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

    public void writeSalestocsv(PrintWriter writer) {
        List<Sales> sales = salesRepository.findAll();
        try (CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT)) {
            csvPrinter.printRecord("Id", "Amount", "NoOfTransaction", "PaymentType");
            for (Sales sales1 : sales) {
                csvPrinter.printRecord(sales1.getId(), sales1.getAmount(), sales1.getNoOfTransaction(),
                        sales1.getPaymentType());
            }
        } catch (IOException e) {
            System.out.println("Error While Writing csv" + e);
        }
}
