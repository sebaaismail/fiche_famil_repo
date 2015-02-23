package com.sebaainf.fichfamil.common;

import com.jenkov.db.itf.PersistenceException;
import com.sebaainf.fichfamil.citoyen.Citoyen;
import com.sebaainf.fichfamil.persistance.MyDaos;
import com.sebaainf.fichfamil.persistance.MyDaosCitoyen;

import java.sql.Date;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.TreeSet;

/**
 * Created by admin on 10/01/2015.
 */
public class FicheFam {

    private String marge1 = "غير متوفي";
    private String marge2 = "غير متوفي";
    private SimpleDateFormat simpleDateFormat;
    //private String textDateNaiss;
    //private String textDateMar;
    private Citoyen citoyen;
    private Mariage selectedFamily;
    //this parameters need fonctions to get formated arabic string
    private String dateNaissFormated;
    private String lieuNaissFormated;
    private String dateMariageFormated;
    //private Citoyen selectedConjoint;
    private TreeSet<Enfant> enfants = new TreeSet<Enfant>(); // enfants de selectedFamily
    private TreeSet<Mariage> families = new TreeSet<Mariage>();

    /**
     * Constructeur
     *
     * @param citoyen
     * @should return ficheFam for the citoyen citoyen with the last mariage as selectedFamily
     */
    public FicheFam(Citoyen citoyen) {

        try {
            if (citoyen != null) {

                // maybe is not need for that sentence ???? if we have a full citoyen
                this.citoyen = MyDaosCitoyen.getCitoyen(citoyen.getId_cit());

                TreeSet<Mariage> mariages = MyDaos.getFamilies(this.citoyen);


                for (Mariage mariage : mariages) {
                    mariage.setEpoux(this.getCitoyen());
                }
                this.setFamilies(mariages);

                this.setSelectedFamily(mariages.first());

                TreeSet<Enfant> enfants = MyDaos.getEnfants(this.getSelectedFamily().getId_mar());
                this.setEnfants(enfants);

                this.prepareTexts();
            } else {
                //message d'erreur TODO
            }

        } catch (PersistenceException e) {
            e.printStackTrace();
        }

    }

    /**
     * Constructeur
     *
     * @param numact_mar
     * @param stringDate_mar
     * @param lieu_mar
     * @should return ficheFam for current mariage to the appropriete citoyen
     */
/*    public FicheFam(int numact_mar, String stringDate_mar, int lieu_mar) {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        try {
            Date date_mar = new Date(dateFormat.parse(stringDate_mar).getTime());


            Mariage mar = MyDaos.getMariage(numact_mar, date_mar, lieu_mar);

            if (mar != null) {
                Citoyen cit = mar.getEpoux();

                String sitfamil = cit.getSit_famil();
                if (cit.getSit_famil().equals("m")) {

                    this.setCitoyen(cit);

                    TreeSet<Mariage> mariages = MyDaos.getFamilies(this.citoyen);

                    for (Mariage mariage : mariages) {
                        mariage.setEpoux(this.getCitoyen());
                    }
                    this.setFamilies(mariages);

                    this.setSelectedFamily(mar);
                    this.prepareTexts();
*//*
                    if (conjoint.getSit_famil().equals("m")) {

                        /*//************************************
     this.setSelectedConjoint(conjoint);

     } else {
     //erreur conjoint nest pas marquée comme mariée ???
     }
     *//*
                } else {
                    //erreur citoyen nest pas marqué comme marié ???
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * Constructeur
     *
     * @param numact_mar
     * @param date_mar
     * @param lieu_mar
     * @should return ficheFam for current mariage to the appropriete citoyen
     */
    public FicheFam(int numact_mar, Date date_mar, int lieu_mar) {


        Mariage mar = MyDaos.getMariage(numact_mar, date_mar, lieu_mar);

        if (mar != null) {
            Citoyen cit = mar.getEpoux();

            String sitfamil = cit.getSit_famil();
            if (cit.getSit_famil().equals("m")) {

                this.setCitoyen(cit);

                TreeSet<Mariage> mariages = MyDaos.getFamilies(this.citoyen);

                for (Mariage mariage : mariages) {
                    mariage.setEpoux(this.getCitoyen());
                }
                this.setFamilies(mariages);

                this.setSelectedFamily(mar);

                TreeSet<Enfant> enfants = MyDaos.getEnfants(this.getSelectedFamily().getId_mar());
                this.setEnfants(enfants);

                this.prepareTexts();
/*
                    if (conjoint.getSit_famil().equals("m")) {

                        //************************************
                        this.setSelectedConjoint(conjoint);

                    } else {
                        //erreur conjoint nest pas marquée comme mariée ???
                    }
*/
            } else {
                //erreur citoyen nest pas marqué comme marié ???
            }
        }

    }

    public String getMarge1() {

        return marge1;
    }

    public void setMarge1(String marge1) {

        this.marge1 = marge1;
    }

    public String getMarge2() {

        return marge2;
    }

    public void setMarge2(String marge2) {

        this.marge2 = marge2;
    }

    public SimpleDateFormat getSimpleDateFormat() {

        return simpleDateFormat;
    }

    public void setSimpleDateFormat(SimpleDateFormat simpleDateFormat) {

        this.simpleDateFormat = simpleDateFormat;
    }

    public Citoyen getCitoyen() {

        return citoyen;
    }

    public void setCitoyen(Citoyen citoyen) {

        this.citoyen = citoyen;
    }

    public Mariage getSelectedFamily() {

        return selectedFamily;
    }

    public void setSelectedFamily(Mariage selectedFamily) {

        this.selectedFamily = selectedFamily;
    }

    public TreeSet<Enfant> getEnfants() {

        return enfants;
    }

    public void setEnfants(TreeSet<Enfant> enfants) {

        this.enfants = enfants;
    }

    public TreeSet<Mariage> getFamilies() {

        return families;
    }

    public void setFamilies(TreeSet<Mariage> families) {

        this.families = families;
    }

    private void prepareTexts() {

        if (this.getCitoyen().getId_deces() == 0) {
            if (!this.getCitoyen().getEst_masculin()) {
                this.setMarge1(this.getMarge1() + "ة");
            }
        } else {
            //TODO citoyen est decede
        }

        if (this.getSelectedFamily().getEpouse().getId_deces() == 0) {
            if (!this.getSelectedFamily().getEpouse().getEst_masculin()) {
                this.setMarge2(this.getMarge2() + "ة");
            }
        } else {
            //TODO epouse est decedee
        }

        DateFormatSymbols dfs = new DateFormatSymbols(new Locale("ar"));
        dfs.setMonths(new String[]{
                "جانفي",
                "فيفري",
                "مارس",
                "أفريل",
                "مــاي",
                "جــوان",
                "جــويلية",
                "أوت",
                "سبتمبـر",
                "أكتوبـر",
                "نوفمبـر",
                "ديسمبر",

        });
        this.setSimpleDateFormat(new SimpleDateFormat("dd MMMM yyyy", dfs));

        for (Enfant enf : this.getEnfants()) {
            if (!enf.getEst_masculin()) enf.setSex("أ");
        }

    }

}
