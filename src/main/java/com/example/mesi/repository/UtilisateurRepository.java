package com.example.mesi.repository;

import com.example.mesi.entity.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {

    Utilisateur findUtilisateurByUsername(String username);
}
