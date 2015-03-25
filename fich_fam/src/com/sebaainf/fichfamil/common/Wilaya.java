package com.sebaainf.fichfamil.common;

import com.jgoodies.common.bean.Bean;

import java.util.TreeSet;

/**
 * Created by admin on 04/02/2015.
 */
public class Wilaya extends Bean implements Comparable<Wilaya> {

    private int code_wilaya;
    private String wil_fr;
    private String wil_ar;

    public static final String PROPERTY_CODE_WILAYA = "code_wilaya";
    public static final String PROPERTY_WIL_FR = "wil_fr";
    public static final String PROPERTY_WIL_AR = "wil_ar";

    public Wilaya(int code_wilaya, String wil_fr, String wil_ar) {

        this.setCode_wilaya(code_wilaya);
        this.setWil_fr(wil_fr);
        this.setWil_ar(wil_ar);
    }


    public static final TreeSet<Wilaya> getWilayas() {

        TreeSet<Wilaya> wilayas = new TreeSet<Wilaya>();
        //         id_W , Wil_fr

        wilayas.add(new Wilaya(1, "Adrar", ""));
        wilayas.add(new Wilaya(1, "Adrar", "أدرار"));
        wilayas.add(new Wilaya(2, "Chlef", "الشلف"));
        wilayas.add(new Wilaya(3, "Laghouat", "لغواط"));
        wilayas.add(new Wilaya(4, "Oum El Bouaghi", "أم البواقي"));
        wilayas.add(new Wilaya(5, "Batna", "باتنة"));
        wilayas.add(new Wilaya(6, "Bejaia", "بجاية"));
        wilayas.add(new Wilaya(7, "Biskra", "بسكرة"));
        wilayas.add(new Wilaya(8, "Bechar", "بشار"));
        wilayas.add(new Wilaya(9, "Blida", "البليدة"));
        wilayas.add(new Wilaya(10, "Bouira", "البويرة"));
        wilayas.add(new Wilaya(11, "Tamanrasset", "تمنراست"));
        wilayas.add(new Wilaya(12, "Tebessa", "تبسة"));
        wilayas.add(new Wilaya(13, "Tlemcen", "تلمسان"));
        wilayas.add(new Wilaya(14, "Tiaret", "تيارت"));
        wilayas.add(new Wilaya(15, "Tizi Ouzou", "تيزي وزو"));
        wilayas.add(new Wilaya(16, "Alger", "الجزائر"));
        wilayas.add(new Wilaya(17, "Djelfa", "الجلفة"));
        wilayas.add(new Wilaya(18, "Jijel", "جيجل"));
        wilayas.add(new Wilaya(19, "Setif", "سطيف"));
        wilayas.add(new Wilaya(20, "Saida", "سعيدة"));
        wilayas.add(new Wilaya(21, "Skikda", "سكيكدة"));
        wilayas.add(new Wilaya(22, "Sidi Belabess", "سيدي بلعباس"));
        wilayas.add(new Wilaya(23, "Annaba", "عنابة"));
        wilayas.add(new Wilaya(24, "Guelma", "قالمة"));
        wilayas.add(new Wilaya(25, "Constantine", "قسنطينة"));
        wilayas.add(new Wilaya(26, "Media", "المدية"));
        wilayas.add(new Wilaya(27, "Mostaganem", "مستغانم"));
        wilayas.add(new Wilaya(28, "Msila", "المسيلة"));
        wilayas.add(new Wilaya(29, "Mascara", "معسكر"));
        wilayas.add(new Wilaya(30, "Ouargla", "ورقلة"));
        wilayas.add(new Wilaya(31, "Oran", "وهران"));
        wilayas.add(new Wilaya(32, "El Bayadh", "البيض"));
        wilayas.add(new Wilaya(33, "Illizi", "إيليزي"));
        wilayas.add(new Wilaya(34, "Bordj Bou Arreridj", "برج بوعريريج"));
        wilayas.add(new Wilaya(35, "Boumerdes", "بومرداس"));
        wilayas.add(new Wilaya(36, "El taref", "الطارف"));
        wilayas.add(new Wilaya(37, "Tindouf", "تندوف"));
        wilayas.add(new Wilaya(38, "Tissemsilt", "تيسمسيلت"));
        wilayas.add(new Wilaya(39, "El Oued", "الوادي"));
        wilayas.add(new Wilaya(40, "Khenchela", "خنشلة"));
        wilayas.add(new Wilaya(41, "Souk Ahras", "سوق أهراس"));
        wilayas.add(new Wilaya(42, "Tipaza", "تيبازة"));
        wilayas.add(new Wilaya(43, "Mila", "ميلة"));
        wilayas.add(new Wilaya(44, "Ain Defla", "عين الدفلة"));
        wilayas.add(new Wilaya(45, "Naama", "النعامة"));
        wilayas.add(new Wilaya(46, "Temouchent", "تموشنت"));
        wilayas.add(new Wilaya(47, "Ghardaia", "غرداية"));
        wilayas.add(new Wilaya(48, "Relizane", "غيليزان"));

        return wilayas;

    }


    public String toString() {

        return this.getWil_fr().toUpperCase();
    }

    @Override
    public int compareTo(Wilaya w) {

        return new Integer(this.getCode_wilaya()).compareTo(new Integer(w.getCode_wilaya()));
        //return new Integer(new Integer(w.getCode_wilaya())).compareTo(this.getCode_wilaya());
    }


    public int getCode_wilaya() {

        return code_wilaya;
    }

    public void setCode_wilaya(int code_wilaya) {

        this.code_wilaya = code_wilaya;
    }

    public String getWil_fr() {

        return wil_fr;
    }

    public void setWil_fr(String wil_fr) {

        this.wil_fr = wil_fr;
    }

    public String getWil_ar() {

        return wil_ar;
    }

    public void setWil_ar(String wil_ar) {

        this.wil_ar = wil_ar;
    }

}
