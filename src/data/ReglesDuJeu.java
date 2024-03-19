package data;
import java.util.List;
import java.util.ArrayList;

public class ReglesDuJeu {
    
    // Constructeur
    public ReglesDuJeu() {
    }

    // Règle 03: Un explorateur n’engage jamais un combat seul contre un ennemi.
    public static void regle3(Explorateur explorateur, Monstre monstre, List<Explorateur> explorateurs) {
        if (autreExplorateurPresent(explorateur, explorateurs)) {
            explorateur.attaquer(monstre);
        } else {
            System.out.println("Un explorateur ne peut pas engager un combat seul contre un ennemi.");
        }
    }

    // Règle 04: Les explorateurs combattent toujours seuls.
    public static void regle4(Explorateur explorateur, Monstre monstre, List<Explorateur> explorateurs) {
        if (!autreExplorateurPresent(explorateur, explorateurs)) {
            explorateur.attaquer(monstre);
        } else {
            System.out.println("L'explorateur ne peut pas engager un combat en présence d'autres explorateurs.");
        }
    }

    // Règle 05: En cas de danger, les explorateurs se réunissent en groupes de défense pour faire face aux ennemis.
    public static void regle5(Explorateur explorateur, List<Explorateur> explorateurs, Monstre monstre) {
        if (autreExplorateurPresent(explorateur, explorateurs)) {
            reunirExplorateursEnGroupe(explorateur, explorateurs, monstre);
        } else {
            System.out.println("Aucun autre explorateur n'est à proximité. L'explorateur agit seul.");
            explorateur.attaquer(monstre);
        }
    }

    // Règle 06: Si un explorateur a un niveau de santé trop bas, il alerte ses coéquipiers.
    public static void regle6(Explorateur explorateur, List<Explorateur> explorateurs) {
        int seuilAlerte = 20; // Seuil de santé en dessous duquel l'alerte est déclenchée
        if (explorateur.getPointsDeVie() < seuilAlerte) {
            System.out.println("Alerte ! L'explorateur " + explorateur + " a un niveau de santé trop bas !");
            alerteCoequipiers(explorateur, explorateurs);
        } else {
            System.out.println("Le niveau de santé de l'explorateur " + explorateur + " est acceptable.");
        }
    }

    // Règle 07: Un explorateur engage systématiquement le combat face à un ennemi qu'il a croisé
    public static void regle7(Explorateur explorateur, Monstre monstre) {
        explorateur.attaquer(monstre);
    }

    // Règle 08: Si l’explorateur a moins de 30% de santé, il n’engage pas le combat seul.
    public static void regle8(Explorateur explorateur, Monstre monstre) {
        if (explorateur.getPointsDeVie() > 0.3 * explorateur.getPointsDeVie()) {
            explorateur.attaquer(monstre);
        } else {
            System.out.println("L'explorateur n'engage pas le combat seul en raison de sa faible santé.");
        }
    }
    // Règle 09: L’explorateur n’engage pas le combat seul s’il y a plus d’un ennemi sur zone.
    public static void regle9(Explorateur explorateur, Monstre[] ennemis) {
        if (ennemis.length == 1) {
            explorateur.attaquer(ennemis[0]);
        } else if (ennemis.length > 1) {
            System.out.println("L'explorateur ne peut pas engager le combat seul, il y a plus d'un ennemi sur la zone.");
            // Autres actions à effectuer si l'explorateur ne peut pas engager le combat seul
        }
    }

    // Règle 10: Si un explorateur trouve un trésor, il doit le signaler aux autres membres de l’équipe.
    public static void regle10(Explorateur explorateur, Tresor tresor, List<Explorateur> coequipiers) {
        System.out.println("Trésor découvert par l'explorateur " + explorateur + " : " + tresor);
        signalerTresorAuxCoequipiers(explorateur, coequipiers);
    }

    // Méthode pour vérifier si un autre explorateur est présent à proximité
    private static boolean autreExplorateurPresent(Explorateur explorateur, List<Explorateur> explorateurs) {
        for (Explorateur autreExplorateur : explorateurs) {
            if (autreExplorateur != explorateur && calculerDistance(explorateur, autreExplorateur) <= explorateur.getRangeDetection()) {
                return true;
            }
        }
        return false;
    }

    // Méthode pour calculer la distance entre deux explorateurs
    private static double calculerDistance(Explorateur explorateur1, Explorateur explorateur2) {
        return Math.sqrt(Math.pow(explorateur1.getRangeDetection() - explorateur2.getRangeDetection(), 2));
    }

    // Méthode pour regrouper les explorateurs en cas de danger
    private static void reunirExplorateursEnGroupe(Explorateur explorateur, List<Explorateur> explorateurs, Monstre monstre) {
        List<Explorateur> groupeDefense = new ArrayList<>();
        groupeDefense.add(explorateur); // Ajouter l'explorateur actuel au groupe de défense
        for (Explorateur autreExplorateur : explorateurs) {
            if (autreExplorateur != explorateur && calculerDistance(explorateur, autreExplorateur) <= explorateur.getRangeDetection()) {
                groupeDefense.add(autreExplorateur);
            }
        }
    }
    // Méthode pour signaler le trésor aux coéquipiers
private static void signalerTresorAuxCoequipiers(Explorateur explorateur, List<Explorateur> coequipiers) {
    for (Explorateur coequipier : coequipiers) {
        if (!coequipier.equals(explorateur)) {
            coequipier.recevoirSignalTresor();
        }
    }
}
 // Méthode pour alerter les coéquipiers en cas de niveau de santé bas d'un explorateur
 public static void alerteCoequipiers(Explorateur explorateur, List<Explorateur> explorateurs) {
    for (Explorateur coequipier : explorateurs) {
        if (!coequipier.equals(explorateur)) {
            coequipier.recevoirAlerteNiveauSante();
        }
    }
}

}           
