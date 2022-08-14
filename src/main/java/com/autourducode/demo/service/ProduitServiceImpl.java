package com.autourducode.demo.service;

import com.autourducode.demo.modele.Produit;
import com.autourducode.demo.repository.ProduitRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // Identifier cette classe comme étant du code métier (Services);
@AllArgsConstructor // Créons un constructeur avec tous les champs;

// Cette classe va implementer nos Produitsevice;
public class ProduitServiceImpl implements ProduitService{
    // Faire une injection par constructeur, Injectons notre ProduitRepository;
    private final ProduitRepository produitRepository;
    // On implemente les méthodes;
    @Override
    public Produit creer(Produit produit) {
        return produitRepository.save(produit); // Appélons la méthode Save pour la persitence des donnés, l'Enregistrement dans la base de donnée
    }

    @Override
    public List<Produit> lire() {
        return produitRepository.findAll(); // findAll pour lire;
    }

    @Override
    public Produit modifier(Long id, Produit produit) {
        return produitRepository.findById(id) // S'il trouve l'ID
                .map(p->{
                    p.setPrix(produit.getPrix()); // Modifier le prix;
                    p.setNom(produit.getNom()); // Modifier le Nom
                    p.setDescription(produit.getDescription());
                    return produitRepository.save(p); // Retourner le resultat sauvergarder;
                }).orElseThrow(() -> new RuntimeException("Produits non trouvé !")); // message d'Error;
    }

    @Override
    public String supprimer(Long id) {
        produitRepository.deleteById(id); // Supprimer par l'ID
        return "Produit Supprimé !";
    }
}
