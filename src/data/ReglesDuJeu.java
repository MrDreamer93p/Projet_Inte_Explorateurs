package data;
import java.util.ArrayList;
import java.util.List;
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

    // règle 03: Un explorateur n’engage jamais un combat seul contre un ennemi.

    public static void regle3(Explorateur explorateur, Monstre monstre, List<Explorateur> explorateurs) {
        // Vérifier si d'autres explorateurs sont à proximité
        boolean autreExplorateurPresent = false;
        for (Explorateur autreExplorateur : explorateurs) {
            if (autreExplorateur != explorateur && calculerDistance(explorateur, autreExplorateur) <= explorateur.getRangeDetection()) {
                autreExplorateurPresent = true;
                break;
            }
        }

        // Si un autre explorateur est présent à proximité, alors on peut attaquer le monstre
        if (autreExplorateurPresent) {
            explorateur.attaquer(monstre);
        } else {
            System.out.println("Un explorateur ne peut pas engager un combat seul contre un ennemi.");
        }
    }
    // Méthode pour calculer la distance entre deux explorateurs
    private static double calculerDistance(Explorateur explorateur1, Explorateur explorateur2) {
        // Calcul de la distance euclidienne entre deux explorateurs
        return Math.sqrt(Math.pow(explorateur1.getRangeDetection() - explorateur2.getRangeDetection(), 2));
    }

    // règle 04: Les explorateurs combattent toujours seuls.

    public static void regleExplorateurCombatSeul(Explorateur explorateur, Monstre monstre, List<Explorateur> explorateurs) {
        // Vérifie si d'autres explorateurs sont à proximité
        boolean autreExplorateurPresent = false;
        for (Explorateur autreExplorateur : explorateurs) {
            if (autreExplorateur != explorateur && calculerDistance(explorateur, autreExplorateur) <= explorateur.getRangeDetection()) {
                autreExplorateurPresent = true;
                break;
            }
        }
    
        // Si aucun autre explorateur n'est à proximité, l'explorateur combat seul
        if (!autreExplorateurPresent) {
            explorateur.attaquer(monstre);
        } else {
            System.out.println("L'explorateur ne peut pas engager un combat en présence d'autres explorateurs.");
        }
    }
    // règle 05: En cas de danger, les explorateurs se réunissent en groupes de défense pour faire face aux ennemis.

    public class GestionExplorateurs {
    // Méthode pour vérifier si un autre explorateur est présent à proximité
    public boolean estAutreExplorateurPresent(Explorateur explorateur, List<Explorateur> explorateurs) {
        for (Explorateur autreExplorateur : explorateurs) {
            if (autreExplorateur != explorateur && calculerDistance(explorateur, autreExplorateur) <= explorateur.getRangeDetection()) {
                return true; 
            }
        }
        return false; 
    }

    // Méthode pour gérer la réunion des explorateurs en cas de danger
    public void reunirExplorateursEnGroupe(Explorateur explorateur, List<Explorateur> explorateurs, Monstre monstre) {
        boolean autresExplorateursProches = estAutreExplorateurPresent(explorateur, explorateurs);

        // Si d'autres explorateurs sont à proximité, les regrouper en un groupe de défense
        if (autresExplorateursProches) {
            List<Explorateur> groupeDefense = new ArrayList<>();
            groupeDefense.add(explorateur); // Ajouter l'explorateur actuel au groupe de défense
            for (Explorateur autreExplorateur : explorateurs) {
                if (autreExplorateur != explorateur && calculerDistance(explorateur, autreExplorateur) <= explorateur.getRangeDetection()) {
                    groupeDefense.add(autreExplorateur);
                }
            }

            // Afficher un message indiquant que les explorateurs se sont regroupés
            System.out.println("Les explorateurs se sont regroupés en groupe de défense pour faire face à l'ennemi.");

            // Faire agir le groupe de défense contre le monstre
            for (Explorateur membre : groupeDefense) {
                membre.attaquer(monstre);
            }
        } else {
            // Si aucun autre explorateur n'est à proximité, l'explorateur agit seul
            System.out.println("Aucun autre explorateur n'est à proximité. L'explorateur agit seul.");
            explorateur.attaquer(monstre);
        }
    }
}
}
