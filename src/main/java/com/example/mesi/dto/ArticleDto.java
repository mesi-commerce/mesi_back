package com.example.mesi.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleDto {
    private Long id;
    private String vendeur;
    private String nom;
    private Integer note;
    private Integer stock;
    private String description;
    private BigDecimal prix;
}
