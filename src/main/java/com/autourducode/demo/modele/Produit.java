package com.autourducode.demo.modele;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity // Pour que la classe puisse être mapper avec une table au niveau de la base de donnée;
@Table(name = "PRODUIT") // on donne le nom de la table;
@Getter // Générer les getters;
@Setter // Générer les setters;
@NoArgsConstructor // Générer un constructeur sans Arguments;
public class Produit {
    @Id // Pour mapper l'identifiant;
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Générer comme une clé primaire and Auto-Incrimente;
    private Long id; // Pour l'identifiant de la Table;
    @Column(length = 50) // nombre de caractère au niveau de la base de donnée (VARCHAR);
    private String nom;
    @Column(length = 150)
    private String description;
    private Integer prix;
}
