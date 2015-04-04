package com.sebaainf.fichfamil.common;

import com.jenkov.db.itf.mapping.AGetterMapping;
import com.jgoodies.common.bean.Bean;
import com.sebaainf.fichfamil.citoyen.Citoyen;

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

    public static final String PROPERTY_ID_DEC = "id_dec";
    public static final String PROPERTY_DATE_DEC = "date_dec";
    public static final String PROPERTY_LIEU_DEC = "lieu_dec";
    public static final String PROPERTY_OBS = "obs";


    @AGetterMapping(databaseGenerated = true)

    public int getId_dec() {

        return id_dec;
    }

    public void setId_dec(int new_id_dec) {

        int old_id_dec = this.id_dec;
        this.id_dec = new_id_dec;
        if (old_id_dec != new_id_dec) {
            firePropertyChange(Deces.PROPERTY_ID_DEC, old_id_dec, new_id_dec);
        }
    }

    public Date getDate_dec() {

        return date_dec;
    }

    public void setDate_dec(Date new_date_dec) {

        Date old_date_dec = this.date_dec;
        this.date_dec = new_date_dec;
        if (old_date_dec != new_date_dec) {
            firePropertyChange(Deces.PROPERTY_DATE_DEC, old_date_dec, new_date_dec);
        }
    }

    public String getLieu_dec() {

        return lieu_dec;
    }

    public void setLieu_dec(String new_lieu_dec) {

        String old_lieu_dec = this.lieu_dec;
        this.lieu_dec = new_lieu_dec;
        if (old_lieu_dec != new_lieu_dec) {
            firePropertyChange(Deces.PROPERTY_LIEU_DEC, old_lieu_dec, new_lieu_dec);
        }
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
