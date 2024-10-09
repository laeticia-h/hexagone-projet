package org.iut.mastermind.domain.proposition;

import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.unmodifiableList;

public class Reponse {
    private final String motSecret;
    private final List<Lettre> resultat = new ArrayList<>();
    private int position;

    public Reponse(String mot) {
        this.motSecret = mot;
    }

    // on récupère la lettre à la position dans le résultat
    public Lettre lettre(int position) {
        return resultat.get(position);
    }

    // on construit le résultat en analysant chaque lettre
    // du mot proposé
    public void compare(String essai) {
        for (int i = 0; i < essai.length(); i++) {
            resultat.add(evaluationCaractere(essai.charAt(i)));
        }
    }

    // si toutes les lettres sont placées
    public boolean lettresToutesPlacees() {
        for(Lettre lettre : resultat) {
            if(lettre != Lettre.PLACEE) {
                return false;
            }
        }
        return true;
    }

    public List<Lettre> lettresResultat() {
        return unmodifiableList(resultat);
    }

    // renvoie le statut du caractère
    private Lettre evaluationCaractere(char carCourant) {
        if (estPlace(carCourant)) {
            position++;
            return Lettre.PLACEE;
        }
        if (estPresent(carCourant)) {
            position++;
            return Lettre.NON_PLACEE;
        }
        position++;
        return Lettre.INCORRECTE;
    }


    // le caractère est présent dans le mot secret
    private boolean estPresent(char carCourant) {
        if(motSecret.indexOf(carCourant) == -1) {
            return false;
        }
        return true;
    }

    // le caractère est placé dans le mot secret
    private boolean estPlace(char carCourant) {
        return motSecret.charAt(position) == carCourant;
    }
}
