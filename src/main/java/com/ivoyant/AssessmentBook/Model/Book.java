package com.ivoyant.AssessmentBook.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table
@Entity

public class Book {

    @Id
    @GeneratedValue
    private int id;
    private String title;
    private String author;
    private String Genre;
    private Date date;
    private int price;
}










