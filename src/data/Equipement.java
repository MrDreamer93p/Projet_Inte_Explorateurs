package data;


public abstract class Equipement {
    // Attributs
    protected String nom;
    protected double prix;

    // Constructeur
    public Equipement(String nom, double prix) {
        this.nom = nom;
        this.prix = prix;
    }

    // Getters et setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }
}