package data;


public class Sac extends Equipement {
    // Le sac a une capacité de transport de 2 trésors en plus
    private static final int CAPACITE_SUPPLEMENTAIRE = 2;

    public Sac() {
        super("Sac", 25.0); // Prix arbitraire
    }

    public int getCapaciteSupplementaire() {
        return CAPACITE_SUPPLEMENTAIRE;
    }
}