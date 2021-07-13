package com.springRest.bookommerce.model;

import lombok.*;

import javax.annotation.processing.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long bookId;
   private String bookName;
   private String authorName;
   private Double bookPrice;
}
