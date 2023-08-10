package com.graphqlwithspringboot.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookInput {
    private String title;
    private String description;
    private String author;
    private Double price;
    private Integer pages;
}
