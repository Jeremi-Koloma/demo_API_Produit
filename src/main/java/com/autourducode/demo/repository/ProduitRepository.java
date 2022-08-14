package com.autourducode.demo.repository;

import com.autourducode.demo.modele.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

// Cette interface va etendre l'Interface JpaRepository; avec param Entity(Produit, et Id)
public interface ProduitRepository  extends JpaRepository<Produit, Long>{
}
