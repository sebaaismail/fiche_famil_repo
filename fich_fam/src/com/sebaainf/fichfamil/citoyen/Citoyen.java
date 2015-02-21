package com.sebaainf.fichfamil.citoyen;

import com.jenkov.db.itf.mapping.AGetterMapping;
import com.jgoodies.binding.beans.Model;
import com.jgoodies.common.bean.Bean;

import java.sql.Date;

/**
 * Created by admin on 10/01/2015.
 */
public class Citoyen  extends Model{


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


    @AGetterMapping(databaseGenerated = true)

    public int getId_cit() {

        return id_cit;
    }

    public void setId_cit(int id_cit) {

        int oldValue = this.id_cit;
        this.id_cit = id_cit;
        firePropertyChange("id_cit", oldValue, this.id_cit);

    }

    public int getNum_actnaiss() {

        return num_actnaiss;
    }

    public void setNum_actnaiss(int num_actnaiss) {

        int oldValue = this.num_actnaiss;
        this.num_actnaiss = num_actnaiss;
        firePropertyChange("num_actnaiss", oldValue, this.num_actnaiss);
    }

    public int getAnnee_actnaiss() {

        return annee_actnaiss;
    }

    public void setAnnee_actnaiss(int annee_actnaiss) {

        int oldValue = this.annee_actnaiss;
        this.annee_actnaiss = annee_actnaiss;
        firePropertyChange("annee_actnaiss", oldValue, this.annee_actnaiss);
    }

    public int getCode_lieunaiss() {

        return code_lieunaiss;
    }

    public void setCode_lieunaiss(int code_lieunaiss) {

        int oldValue = this.code_lieunaiss;
        this.code_lieunaiss = code_lieunaiss;
        firePropertyChange("code_lieunaiss", oldValue, this.code_lieunaiss);
    }

    public String getNom_fr() {

        return nom_fr;
    }

    public void setNom_fr(String nom_fr) {

        String oldValue = this.nom_fr;
        this.nom_fr = nom_fr;
        firePropertyChange("nom_fr", oldValue, this.nom_fr);
    }

    public String getPrenom_fr() {

        return prenom_fr;
    }

    public void setPrenom_fr(String prenom_fr) {

        String oldValue = this.prenom_fr;
        this.prenom_fr = prenom_fr;
        firePropertyChange("prenom_fr", oldValue, this.prenom_fr);
    }

    public String getNom_ar() {

        return nom_ar;
    }

    public void setNom_ar(String nom_ar) {

        String oldValue = this.nom_ar;
        this.nom_ar = nom_ar;
        firePropertyChange("nom_ar", oldValue, this.nom_ar);
    }

    public String getPrenom_ar() {

        return prenom_ar;
    }

    public void setPrenom_ar(String prenom_ar) {

        String oldValue = this.prenom_ar;
        this.prenom_ar = prenom_ar;
        firePropertyChange("prenom_ar", oldValue, this.prenom_ar);
    }

    public Date getDate_naiss() {

        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {

        Date oldValue = this.date_naiss;
        this.date_naiss = date_naiss;
        firePropertyChange("date_naiss", oldValue, this.date_naiss);
    }

    public String getP_pere() {

        return p_pere;
    }

    public void setP_pere(String p_pere) {

        String oldValue = this.p_pere;
        this.p_pere = p_pere;
        firePropertyChange("p_pere", oldValue, this.p_pere);
    }

    public String getNp_mere() {

        return np_mere;
    }

    public void setNp_mere(String np_mere) {

        String oldValue = this.np_mere;
        this.np_mere = np_mere;
        firePropertyChange("np_mere", oldValue, this.np_mere);
    }

    public Boolean getEst_masculin() {

        return est_masculin;
    }

    public void setEst_masculin(Boolean est_masculin) {

        Boolean oldValue = this.est_masculin;
        this.est_masculin = est_masculin;
        firePropertyChange("est_masculin", oldValue, this.est_masculin);
    }

    public int getId_deces() {

        return id_deces;
    }

    public void setId_deces(int id_deces) {

        int oldValue = this.id_deces;
        this.id_deces = id_deces;
        firePropertyChange("id_deces", oldValue, this.id_deces);
    }

    public Boolean getDate_est_presume() {

        return date_est_presume;
    }

    public void setDate_est_presume(Boolean date_est_presume) {

        Boolean oldValue = this.date_est_presume;
        this.date_est_presume = date_est_presume;
        firePropertyChange("date_est_presume", oldValue, this.date_est_presume);
    }

    public String getSit_famil() {

        return sit_famil;
    }

    public void setSit_famil(String sit_famil) {

        String oldValue = this.sit_famil;
        this.sit_famil = sit_famil;
        firePropertyChange("sit_famil", oldValue, this.sit_famil);
    }

}
