package com.sebaainf.fichfamil.common;

import com.jgoodies.binding.beans.Model;
import com.jgoodies.common.bean.Bean;
import com.sebaainf.fichfamil.persistance.MyDaos;

import java.util.TreeSet;

/**
 * Created by admin on 06/02/2015.
 */
public class Commune extends Bean implements Comparable<Commune> {

    private int id_c;
    private String com_fr;
    private String com_ar;

    public static TreeSet<Commune> getCollectionCommunes(int id_wil) {

        return MyDaos.getCollectionCommunes(id_wil);
    }

    @Override
    public int compareTo(Commune commune) {

        return new Integer(this.getId_c()).compareTo(new Integer(commune.getId_c()));
    }

    public String toString() {

        return this.getCom_fr().toUpperCase();
    }

    public int getId_c() {

        return id_c;
    }

    public void setId_c(int id_c) {

        this.id_c = id_c;
    }

    public String getCom_fr() {

        return com_fr;
    }

    public void setCom_fr(String com_fr) {

        this.com_fr = com_fr;
    }

    public String getCom_ar() {

        return com_ar;
    }

    public void setCom_ar(String com_ar) {

        this.com_ar = com_ar;
    }
}
