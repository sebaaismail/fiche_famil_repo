package com.sebaainf.fichfamil.view;

/**
 * Created by ${sebaainf.com} on 28/02/2015.
 */
public interface CitoyenView {

    String getNom_ar();

    public void setNom_ar(String nom_ar);

    public String getPrenom_ar();

    public void setPrenom_ar(String prenom_ar);

    String getNom_fr();

    public void setNom_fr(String nom_fr);

    public String getPrenom_fr();

    public void setPrenom_fr(String prenom_fr);

    public String getDate_naiss();

    public void setDate_naiss(String date_naiss);

    public Object getCode_lieunaiss();

    public void setCode_lieunaiss(Object code_lieunaiss);

    public String getP_pere();

    public void setP_pere(String p_pere);

    public String getNp_mere();

    public void setNp_mere(String np_mere);

    public Boolean getEst_masculin();

    public void setEst_masculin(Boolean est_masculin);

    public int getId_deces();

    public void setId_deces(int id_deces);

    public Boolean getDate_est_presume();

    public void setDate_est_presume(Boolean date_est_presume);

    public String getSit_famil();

    public void setSit_famil(String sit_famil);

}
