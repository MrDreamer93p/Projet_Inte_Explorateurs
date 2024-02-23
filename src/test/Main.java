package test;

import data.Explorateur;
import data.Monstre;
import data.Squelette;
import data.Crab;
import data.Ghost;


public class Main {
    public static void main(String[] args) {

        Monstre monstre = new Squelette();

        // Création d'un explorateur
        Explorateur explorateur = new Explorateur(100, 20, 10.0);

        // Affichage des caractéristiques initiales
        System.out.println("Caractéristiques du monstre:");
        afficherCaracteristiques(monstre);
        System.out.println("Caractéristiques de l'explorateur:");
        afficherCaracteristiques(explorateur);

        // L'explorateur attaque le monstre
        System.out.println("L'explorateur attaque le monstre...");
        explorateur.attaquer(monstre);

        // Affichage des caractéristiques après l'attaque
        System.out.println("Caractéristiques après l'attaque du monstre:");
        afficherCaracteristiques(monstre);
        System.out.println("Caractéristiques après l'attaque de l'explorateur:");
        afficherCaracteristiques(explorateur);



        System.out.println("Le monstre attaque l'explorateur...");
        monstre.attaquer(explorateur);

        // Affichage des caractéristiques après l'attaque
        System.out.println("Caractéristiques après l'attaque du monstre:");
        afficherCaracteristiques(monstre);
        System.out.println("Caractéristiques après l'attaque de l'explorateur:");
        afficherCaracteristiques(explorateur);
    }

    public static void afficherCaracteristiques(Monstre monstre) {
        System.out.println("Points de vie: " + monstre.getPointsDeVie());
        System.out.println("Dégâts: " + monstre.getDegats());
        System.out.println("Range de détection: " + monstre.getRangeDetection());
        System.out.println();
    }

    public static void afficherCaracteristiques(Explorateur explorateur) {
        System.out.println("Points de vie: " + explorateur.getPointsDeVie());
        System.out.println("Dégâts: " + explorateur.getDegats());
        System.out.println("Range de détection: " + explorateur.getRangeDetection());
        System.out.println();
    }
}

