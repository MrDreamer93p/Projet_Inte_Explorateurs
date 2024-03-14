package data;

import Explorateur.Explorateur;
import Monstre.Monstre; 
public class ReglesDuJeu {

    // Constructeur
    public ReglesDuJeu() {
    }
    // Règle 07: Un explorateur engage systématiquement le combat face à un ennemi qu'il a croisé
    public void regle7(Explorateur explorateur, Monstre monstre) {
        explorateur.attaquer(monstre);
    }
    // Règle 08: Si l’explorateur a moins de 30% de santé, il n’engage pas le combat seul.
    public void regle8(Explorateur explorateur, Monstre monstre) {
        if (explorateur.getPointsDeVie() > 0.3 * explorateur.getPointsDeVie()) {
            explorateur.attaquer(monstre);
        } else {
            System.out.println("L'explorateur n'engage pas le combat seul en raison de sa faible santé.");
        }
    }
    // Règle 09: L’explorateur n’engage pas le combat seul s’il y a plus d’un ennemi sur zone.
     public void regle9(Explorateur explorateur, Monstre[] ennemis) {
        if (ennemis.length == 1) {
            explorateur.attaquer(ennemis[0]);
        } else if (ennemis.length > 1) {
            System.out.println("L'explorateur ne peut pas engager le combat seul, il y a plus d'un ennemi sur la zone.");
            // Autres actions à effectuer si l'explorateur ne peut pas engager le combat seul
        }
    }
}
public class Main {
    public static void main(String[] args) {
        Explorateur explorateur = new Explorateur(/* Initialisez les attributs de l'explorateur */);
        Monstre monstre = new Monstre(/* Initialisez les attributs du monstre */);
        Monstre[] ennemis = { /* Initialisez les ennemis supplémentaires si nécessaire */ };

        ReglesDuJeu regles = new ReglesDuJeu();

        // Test des règles
        regles.regle7(explorateur, monstre);
        regles.regle8(explorateur, monstre);
        regles.regle9(explorateur, ennemis);
    }
}
