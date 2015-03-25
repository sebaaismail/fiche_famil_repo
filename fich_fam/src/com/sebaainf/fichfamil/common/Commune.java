package com.sebaainf.fichfamil.common;

import com.jgoodies.common.bean.Bean;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by ${sebaainf.com} on 24/03/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */

@XStreamAlias("Commune") // maps Commune element in XML to this class
public class Commune extends Bean implements Comparable<Commune> {

    private int code_wilaya;
    private int code_commune;
    private String com_fr;
    private String com_ar;
    private Boolean selection_daira;

    public static final String PROPERTY_CODE_WILAYA = "code_wilaya";
    public static final String PROPERTY_CODE_COMMUNE = "code_commune";
    public static final String PROPERTY_COM_FR = "com_fr";
    public static final String PROPERTY_COM_AR = "com_ar";
    public static final String PROPERTY_SELECTION_DAIRA = "selection_daira";



    @Override
    public int compareTo(Commune commune) {

        return new Integer(this.getCode_commune()).compareTo(new Integer(commune.getCode_commune()));
    }

    public String toString() {

        return this.getCom_fr().toUpperCase();
    }

    public int getCode_commune() {

        return code_commune;
    }

    public void setCode_commune(int code_commune) {

        this.code_commune = code_commune;
    }

    public String getCom_fr() {

        return com_fr;
    }

    public int getCode_wilaya() {

        return code_wilaya;
    }

    public void setCode_wilaya(int code_wilaya) {

        this.code_wilaya = code_wilaya;
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

    public Boolean getSelection_daira() {

        return selection_daira;
    }

    public void setSelection_daira(Boolean selection_daira) {

        this.selection_daira = selection_daira;
    }



}