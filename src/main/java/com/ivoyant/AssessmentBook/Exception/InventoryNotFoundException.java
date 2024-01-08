package com.ivoyant.AssessmentBook.Exception;

public class InventoryNotFoundException extends RuntimeException{

   public InventoryNotFoundException(String message){
       super(message);
   }

    public InventoryNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }
}
