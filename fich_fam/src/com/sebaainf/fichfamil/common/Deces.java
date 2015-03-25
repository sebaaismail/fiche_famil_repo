package com.sebaainf.fichfamil.common;

import com.jenkov.db.itf.mapping.AGetterMapping;
import com.jgoodies.common.bean.Bean;

import java.sql.Date;

/**
 * Created by ${sebaainf.com} on 20/03/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class Deces extends Bean {

    // TODO
    private int id_dec;
    private Date date_dec;
    private String lieu_dec;
    private String obs = "";


    @AGetterMapping(databaseGenerated = true)

    public int getId_dec() {

        return id_dec;
    }

    public void setId_dec(int id_dec) {

        this.id_dec = id_dec;
    }

    public Date getDate_dec() {

        return date_dec;
    }

    public void setDate_dec(Date date_dec) {

        this.date_dec = date_dec;
    }

    public String getLieu_dec() {

        return lieu_dec;
    }

    public void setLieu_dec(String lieu_dec) {

        this.lieu_dec = lieu_dec;
    }

    public String getObs() {

        return obs;
    }

    public void setObs(String obs) {

        this.obs = obs;
    }

    public Deces(int id, Date dateDeces, String lieuDeces) {

        this.id_dec = id;
        this.date_dec = dateDeces;
        this.lieu_dec = lieuDeces;

    }

    public Deces(Date dateDeces, String lieuDeces) {


        this.date_dec = dateDeces;
        this.lieu_dec = lieuDeces;

    }
    public Deces() {

    }


}
