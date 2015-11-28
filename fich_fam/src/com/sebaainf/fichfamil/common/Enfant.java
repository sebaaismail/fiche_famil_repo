package com.sebaainf.fichfamil.common;

import java.sql.Date;

/**
 * Created by admin on 10/01/2015.
 */
public class Enfant implements Comparable<Enfant> {

    private int id_enf;
    private int id_mar;
    private String prenom_enf;
    private Date date_naiss;
    private int lieu_naiss;
    private boolean est_masculin = true;
    private String sex = "ذ";
    private int id_deces;
    private boolean date_est_presume = false;

    public String getSex() {

        return sex;
    }

    public void setSex(String sex) {

        this.sex = sex;
    }

    public int getId_enf() {

        return id_enf;
    }

    public void setId_enf(int id_enf) {

        this.id_enf = id_enf;
    }

    public int getId_mar() {

        return id_mar;
    }

    public void setId_mar(int id_mar) {

        this.id_mar = id_mar;
    }

    public String getPrenom_enf() {

        return prenom_enf;
    }

    public void setPrenom_enf(String prenom_enf) {

        this.prenom_enf = prenom_enf;
    }

    public Date getDate_naiss() {

        return date_naiss;
    }

    public void setDate_naiss(Date date_naiss) {

        this.date_naiss = date_naiss;
    }

    public int getLieu_naiss() {

        return lieu_naiss;
    }

    public void setLieu_naiss(int lieu_naiss) {

        this.lieu_naiss = lieu_naiss;
    }

    public boolean getEst_masculin() {

        return est_masculin;
    }

    public void setEst_masculin(boolean est_masculin) {

        this.est_masculin = est_masculin;
    }

    public int getId_deces() {

        return id_deces;
    }

    public void setId_deces(int id_deces) {

        this.id_deces = id_deces;
    }

    public boolean getDate_est_presume() {

        return date_est_presume;
    }

    public void setDate_est_presume(boolean date_est_presume) {

        this.date_est_presume = date_est_presume;
    }


    @Override
    public int compareTo(Enfant enf) {

        return this.getDate_naiss().compareTo(enf.getDate_naiss());
    }

    @Override
    public int hashCode() {

        return new Integer(id_enf).hashCode();
    }

    @Override
    public boolean equals(Object oenf) {

        Enfant enf = (Enfant) oenf;
        boolean flag1 = this.getPrenom_enf().equals(enf.getPrenom_enf());
        boolean flag2 = this.getDate_naiss().equals(enf.getDate_naiss());

        return (flag1 && flag2);
    }
}
