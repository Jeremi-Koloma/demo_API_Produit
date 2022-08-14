package com.autourducode.demo.controller;

import com.autourducode.demo.modele.Produit;
import com.autourducode.demo.service.ProduitService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Identifier cette classe comme étant un Controller;
@RequestMapping("/produit") // Le path, ou le lien pour le Navigateur
@AllArgsConstructor
public class ProduitController {
    // Injectons notre ServiceProduit;
    private final ProduitService produitService; // ici c'est inversion de contrôle, parcek on passe par l'Interface pour implemter les méthode de ServiceImpl

    @PostMapping("/create") // Dit au contrôller qu'il sagit d'une Requête (POST) pour le Mapper;
    // la méthode qui va creer le produit;
    public Produit create(@RequestBody Produit produit){ // Envoyer les donnée body de la requête;
        return produitService.creer(produit); //Ça va appéler la méthode créer et Envoyé produit;
    }


    // La méthode qui va lire nos produits;
    @GetMapping("/read") // la requête (GET) pour READ;
    public List<Produit> read() {
        return produitService.lire(); // qui retourne le Serive Lire;
    }

    @PutMapping("/update/{id}") // La requête (PUT) avec param(id)
    public Produit update(@PathVariable Long id, @RequestBody Produit produit) {
        return produitService.modifier(id, produit); // Qui va retourné le service modifier;
    }

    @DeleteMapping("/delete/{id}") // La requête (DELETE) id;
    public String delete(@PathVariable Long id){
        return produitService.supprimer(id); // Qui va retourné le service supprimer;
    }
}
