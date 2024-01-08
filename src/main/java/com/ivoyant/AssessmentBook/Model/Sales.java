package com.ivoyant.AssessmentBook.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Indexed;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity
public class Sales {

    @Id
    @GeneratedValue
    private int id ;
    private int amount;
    private int noOfTransaction;
    private PaymentType paymentType;
}
