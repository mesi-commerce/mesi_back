package com.example.mesi.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nom;
    private String prenom;
    @Column(name = "mot_de_passe")
    private String password;
    private String email;
    private String role;
    @Column(name = "nom_utilisateur")
    private String username;
}
