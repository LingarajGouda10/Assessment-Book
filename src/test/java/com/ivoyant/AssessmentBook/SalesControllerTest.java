package com.ivoyant.AssessmentBook;

import com.ivoyant.AssessmentBook.Controller.SalesController;
import com.ivoyant.AssessmentBook.Model.PaymentType;
import com.ivoyant.AssessmentBook.Model.Sales;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class SalesControllerTest {

    @Autowired
    private SalesController salesController;

    @Test
    public void testSalesController(){
        Sales sales=new Sales();
        sales.setId(1);
        sales.setAmount(77777);
        sales.setNoOfTransaction(4);
        sales.setPaymentType(PaymentType.UPI);

        String result= salesController.addSales(sales.getId(),sales.getAmount(),sales,new Sales());

        assertEquals(null,result);
        assertEquals(77777,sales.getAmount());
        assertEquals(4,sales.getNoOfTransaction());
    }
}
