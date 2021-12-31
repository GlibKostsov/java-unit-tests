package LeGrandRestaurant;

import LeGrandRestaurant.IPeutServir;

public class Serveur implements IPeutServir {

   private String nom;
    public double ChiffreAffaires;
    public Serveur() {
        this.nom = "LeGrandRestaurant.Serveur par Default";
    }
    public Serveur(String nom) {
        this.nom = nom;
    }

    public double getChiffreAffaires() {
        return ChiffreAffaires;
    }

    private void setChiffreAffaires(double chiffreAffaires) {
        ChiffreAffaires = chiffreAffaires;
    }

    public void PrendreCommande(double montantCommande){
        this.ChiffreAffaires += montantCommande;
    }
}
