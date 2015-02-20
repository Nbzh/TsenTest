package com.example.esir.nsoc2014.regulator.regulation;

public class Regulator implements Runnable{

    private double Kp; // coefficient proportionnel
    private double Ki; // coefficient integrateur
    private double Kd; // coefficient dérivateur
    private boolean activated;
    // recuperer valeur capteur sur contexte
    double temp_int = 20; // temperature interieur, fixée pour test
    // récuperer valeur consigne sur contexte ou optimisateur directement
    double temp_cons = 21; // temperature de consigne, fixée pour test

    public Regulator() {
        this.Kp = 1;
        this.Ki = 1;
        this.Kd = 1;

    }

    public Regulator(double m_Kp) {
        this.Kp = m_Kp;
        this.Ki = 0;
        this.Kd = 0;
    }

    public Regulator(double m_Kp, double m_Ki) {
        this.Kp = m_Kp;
        this.Ki = m_Ki;
        this.Kd = 0;
    }

    public Regulator(double m_Kp, double m_Ki, double m_Kd) {
        this.Kp = m_Kp;
        this.Ki = m_Ki;
        this.Kd = m_Kd;
    }

    public void run() {
        // variable pour régulation
        double diff_temp = 0; // erreur : différence entre temperature désirée
        // et température mesurée
        double valeur_sortie = 0; // valeur de sortie
        double somme_erreurs = 0; // somme des erreurs (répéter à chaque
        // itération)
        double variation_erreur = 0; // différence entre erreur actuelle et
        // erreur précédente
        // activer la régulation
        this.activated = true;
        // régulation dans qu'elle est activée
        while (this.activated) {
            somme_erreurs = somme_erreurs + diff_temp; // calcule la nouvelle somme des erreurs
            variation_erreur = temp_cons - temp_int - diff_temp; // calcule la différence entre la nouvelle erreur et la précédente
            diff_temp = temp_cons - temp_int; // calcul la nouvelle erreur
            // calcule de la nouvelle valeur de sortie ::: régulation PID,dépend du constructeur utilisé
            valeur_sortie = diff_temp * this.Kp + somme_erreurs * this.Ki
                    + variation_erreur * Kd;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            // envoyer valeur de sortie vers KNX
        }
    }
    public void stop(){
        this.activated= false;
    }
    public void setConsigne(double consigne){
        this.temp_cons = consigne;
    }
    public void setTempInterieur(double tempInt){
        this.temp_int = tempInt;
    }

}
