package com.example.mesi.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Builder
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "vendeur_id")
    private User vendeur;

    @Column(name = "nom")
    private String nom;

    @Column(name = "note")
    private Integer note;

    @Column(name = "stock")
    private Integer stock;

    @Column(name = "description")
    private String description;

    @Column(name = "prix", precision = 15, scale = 2)
    private BigDecimal prix;

    @Column(name = "photo")
    private String photo;
}