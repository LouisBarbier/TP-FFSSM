/**
 * @(#) Moniteur.java
 */
package FFSSM;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.TreeSet;

public class Moniteur extends Plongeur {

    public int numeroDiplome;

    public ArrayList<Embauche> embauches = new ArrayList<Embauche>();

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance,int niveau, int numeroDiplome) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance,niveau);
        this.numeroDiplome = numeroDiplome;
    }

    public Moniteur(String numeroINSEE, String nom, String prenom, String adresse, String telephone, LocalDate naissance,int niveau, int numeroDiplome, Licence licence) {
        super(numeroINSEE, nom, prenom, adresse, telephone, naissance,niveau,licence);
        this.numeroDiplome = numeroDiplome;
    }

    /**
     * Si ce moniteur n'a pas d'embauche, ou si sa dernière embauche est terminée,
     * ce moniteur n'a pas d'employeur.
     * @return l'employeur actuel de ce moniteur sous la forme d'un Optional
     */
    public Optional<Club> employeurActuel() {
        for (Embauche e : embauches){
            if (e.estTerminee()==false){
                return Optional.of(e.getEmployeur());
            }
        }
        return Optional.empty();
    }
    
    /**
     * Enregistrer une nouvelle embauche pour cet employeur
     * @param employeur le club employeur
     * @param debutNouvelle la date de début de l'embauche
     */
    public void nouvelleEmbauche(Club employeur, LocalDate debutNouvelle) {   
         embauches.add(new Embauche(debutNouvelle,this,employeur));
    }

    public ArrayList<Embauche> emplois() {
         return embauches;
    }

}
