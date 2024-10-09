package org.iut.mastermind.domain.partie;

public class Joueur {

    private final String nom;

    // constructeur
    public Joueur(String nom) {
        this.nom = nom;
    }

    // getter nom joueur
    public String getNom() {
        return this.nom;
    }

    // equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Joueur)) return false;
        Joueur j = (Joueur) o;
        return nom.equals(j.nom);
    }

    // hashcode
    @Override
    public int hashCode() {
        return this.nom.hashCode();
    }

}
