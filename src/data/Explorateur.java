package data;

public class Explorateur {
    // Attributs
    private int pointsDeVie;
    private int degats;
    private double rangeDetection;

    // Constructeur
    public Explorateur(int pointsDeVie, int degats, double rangeDetection) {
        this.pointsDeVie = pointsDeVie;
        this.degats = degats;
        this.rangeDetection = rangeDetection;
    }

    // Méthode pour attaquer un monstre
    public void attaquer(Monstre monstre) {
        monstre.recevoirDegats(this.degats);
    }

    // Méthode pour recevoir des dégâts
    public void recevoirDegats(int degats) {
        this.pointsDeVie -= degats;
        if (this.pointsDeVie <= 0) {
            System.out.println("L'explorateur a été vaincu!");
            // Modif l'addon si mort
        }
    }

    // Getters et setters
    public int getPointsDeVie() {
        return pointsDeVie;
    }

    public void setPointsDeVie(int pointsDeVie) {
        this.pointsDeVie = pointsDeVie;
    }

    public int getDegats() {
        return degats;
    }

    public void setDegats(int degats) {
        this.degats = degats;
    }

    public double getRangeDetection() {
        return rangeDetection;
    }

    public void setRangeDetection(double rangeDetection) {
        this.rangeDetection = rangeDetection;
    }
    public void recevoirAlerteNiveauSante() {
        System.out.println("Alerte : Niveau de santé trop bas !");
        // Ajoutez ici d'autres actions à entreprendre en réponse à l'alerte
    }
    // Méthode pour recevoir un signal de trésor de la part d'un coéquipier
public void recevoirSignalTresor() {
    System.out.println("Signal reçu : Un trésor a été découvert !");
    // Autres actions à effectuer lors de la réception du signal de trésor
}

}
