package com.autourducode.demo.service;

import com.autourducode.demo.modele.Produit;

import java.util.List;

public interface ProduitService {
    // Une méthode va retourné produits (Modele); // methode CREATE
    Produit creer(Produit produit);

    // Une méthode va retourné une liste de produits (Modele); // methode READ
    List<Produit> lire();

    // Une méthode va retourné produits (Modele), qui va prendre parm (Id-produit, et le Produit); // methode UPDATE
    Produit modifier(Long id, Produit produit);

    // Une méthode va retourné String qui va prendre en param (Id-produit) à supprimer; // methode DELECTE
    String supprimer(Long id);

}
