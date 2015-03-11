package com.sebaainf.fichfamil.citoyen;

import com.jenkov.db.itf.mapping.AGetterMapping;
import com.jgoodies.binding.beans.Model;

import java.sql.Date;

/**
 * Created by admin on 10/01/2015.
 */
public class Citoyen extends Model {


    private String sit_famil = "c";
    private int id_cit;
    private int num_actnaiss;
    private int annee_actnaiss;
    private int code_lieunaiss;
    private String nom_fr = "";
    private String prenom_fr = "";
    private String nom_ar = "";
    private String prenom_ar = "";
    private Date date_naiss;
    private String p_pere = "";
    private String np_mere = "";
    private Boolean est_masculin = true;
    private int id_deces;
    private Boolean date_est_presume = false;

    public static final String PROPERTY_SIT_FAMIL = "sit_famil";
    public static final String PROPERTY_ID_CIT = "id_cit";
    public static final String PROPERTY_NUM_ACTNAISS = "num_actnaiss";
    public static final String PROPERTY_ANNEE_ACTNAISS = "annee_actnaiss";
    public static final String PROPERTY_CODE_LIEUNAISS = "code_lieunaiss";
    public static final String PROPERTY_NOM_FR = "nom_fr";
    public static final String PROPERTY_PRENOM_FR = "prenom_fr";
    public static final String PROPERTY_NOM_AR = "nom_ar";
    public static final String PROPERTY_PRENOM_AR = "prenom_ar";
    public static final String PROPERTY_DATE_NAISS = "date_naiss";
    public static final String PROPERTY_P_PERE = "p_pere";
    public static final String PROPERTY_NP_MERE = "np_mere";
    public static final String PROPERTY_EST_MASCULIN = "est_masculin";
    public static final String PROPERTY_ID_DECES = "id_deces";
    public static final String PROPERTY_DATE_EST_PRESUME = "date_est_presume";



    @AGetterMapping(databaseGenerated = true)

    public int getId_cit() {

        return id_cit;
    }

    public void setId_cit(int id_cit) {

        int oldValue = this.id_cit;
        this.id_cit = id_cit;
        if (oldValue != id_cit) {
            firePropertyChange("id_cit", oldValue, id_cit);
        }

    }

    public int getNum_actnaiss() {

        return num_actnaiss;
    }

    public void setNum_actnaiss(int num_actnaiss) {

        int oldValue = this.num_actnaiss;
        this.num_actnaiss = num_actnaiss;
        if (oldValue != num_actnaiss) {
            firePropertyChange("num_actnaiss", oldValue, num_actnaiss);

        }
    }

    public int getAnnee_actnaiss() {

        return annee_actnaiss;
    }

    public void setAnnee_actnaiss(int annee_actnaiss) {

        int oldValue = this.annee_actnaiss;
        this.annee_actnaiss = annee_actnaiss;
        if (oldValue != annee_actnaiss) {
            firePropertyChange("annee_actnaiss", oldValue, annee_actnaiss);
        }

    }

    public int getCode_lieunaiss() {

        return code_lieunaiss;
    }

    public void setCode_lieunaiss(int code_lieunaiss) {

        int oldValue = this.code_lieunaiss;
        this.code_lieunaiss = code_lieunaiss;
        if (oldValue != code_lieunaiss) {
            firePropertyChange("code_lieunaiss", oldValue, code_lieunaiss);
        }

    }

    public String getNom_fr() {

        return nom_fr;
    }

    public void setNom_fr(String nom_fr) {

        String oldValue = this.nom_fr;
        this.nom_fr = nom_fr;
        if (oldValue != nom_fr) {
            firePropertyChange("nom_fr", oldValue, nom_fr);
        }

    }

    public String getPrenom_fr() {

        return prenom_fr;
    }

    public void setPrenom_fr(String prenom_fr) {

        String oldValue = this.prenom_fr;
        this.prenom_fr = prenom_fr;
        if (oldValue != prenom_fr) {
            firePropertyChange("prenom_fr", oldValue, prenom_fr);
        }

    }

    public String getNom_ar() {

        return nom_ar;
    }

    public void setNom_ar(String nom_ar) {

        String oldValue = this.nom_ar;
        this.nom_ar = nom_ar;
        if (oldValue != nom_ar) {
            firePropertyChange("nom_ar", oldValue, nom_ar);
        }

    }

    public String getPrenom_ar() {

        return prenom_ar;
    }

    public void setPrenom_ar(String prenom_ar) {

        String oldValue = this.prenom_ar;
        this.prenom_ar = prenom_ar;
        if (oldValue != prenom_ar) {
            firePropertyChange("prenom_ar", oldValue, prenom_ar);
        }

    }

    public Date getDate_naiss() {

        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {

        Date oldValue = this.date_naiss;
        this.date_naiss = date_naiss;
        if (oldValue != date_naiss) {
            firePropertyChange("date_naiss", oldValue, date_naiss);
        }

    }

    public String getP_pere() {

        return p_pere;
    }

    public void setP_pere(String p_pere) {

        String oldValue = this.p_pere;
        this.p_pere = p_pere;
        if (oldValue != p_pere) {
            firePropertyChange("p_pere", oldValue, p_pere);
        }

    }

    public String getNp_mere() {

        return np_mere;
    }

    public void setNp_mere(String np_mere) {

        String oldValue = this.np_mere;
        this.np_mere = np_mere;
        if (oldValue != np_mere) {
            firePropertyChange("np_mere", oldValue, np_mere);
        }

    }

    public Boolean getEst_masculin() {

        return est_masculin;
    }

    public void setEst_masculin(Boolean est_masculin) {

        Boolean oldValue = this.est_masculin;
        this.est_masculin = est_masculin;
        if (oldValue != est_masculin) {
            firePropertyChange("est_masculin", oldValue, est_masculin);
        }

    }

    public int getId_deces() {

        return id_deces;
    }

    public void setId_deces(int id_deces) {

        int oldValue = this.id_deces;
        this.id_deces = id_deces;
        if (oldValue != id_deces) {
            firePropertyChange("id_deces", oldValue, id_deces);
        }

    }

    public Boolean getDate_est_presume() {

        return date_est_presume;
    }

    public void setDate_est_presume(Boolean date_est_presume) {

        Boolean oldValue = this.date_est_presume;
        this.date_est_presume = date_est_presume;
        if (oldValue != date_est_presume) {
            firePropertyChange("date_est_presume", oldValue, date_est_presume);
        }
    }

    public String getSit_famil() {

        return sit_famil;
    }

    public void setSit_famil(String sit_famil) {

        String oldValue = this.sit_famil;
        this.sit_famil = sit_famil;
        if (oldValue != sit_famil) {
            firePropertyChange("sit_famil", oldValue, sit_famil);
        }
    }

}