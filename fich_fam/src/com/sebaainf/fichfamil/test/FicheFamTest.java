package com.sebaainf.fichfamil.test;


import com.sebaainf.fichfamil.citoyen.Citoyen;
import com.sebaainf.fichfamil.common.Enfant;
import com.sebaainf.fichfamil.common.FicheFam;
import com.sebaainf.fichfamil.common.Mariage;
import com.sebaainf.fichfamil.persistance.MyDaosCitoyen;
import org.junit.Test;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by admin on 24/01/2015.
 */
public class FicheFamTest {

    // for test
    public static FicheFam getTestingFiche() {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date_naiss1 = null;
        Date date_naiss2 = null;
        Date date_mar1 = null;
        Date date_mar2 = null;
        Date date_naissENf1 = null;
        Date date_naissENf2 = null;
        Date date_naissENf3 = null;

        TreeSet<Mariage> families = null;
        try {
            date_naiss1 = new Date(dateFormat.parse("21/08/1981").getTime());
            date_naiss2 = new Date(dateFormat.parse("11/03/1986").getTime());
            date_mar1 = new Date(dateFormat.parse("10/03/2010").getTime());
            date_mar2 = new Date(dateFormat.parse("14/07/2014").getTime());
            date_naissENf1 = new Date(dateFormat.parse("22/03/2013").getTime());
            date_naissENf2 = new Date(dateFormat.parse("15/11/2014").getTime());
            date_naissENf3 = new Date(dateFormat.parse("01/09/2015").getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Citoyen epoux = new Citoyen();
        epoux.setNom_ar("حمراني");
        epoux.setPrenom_ar("أحمد");
        epoux.setNom_fr("SAAD");
        epoux.setPrenom_fr("ali");
        epoux.setDate_naiss(date_naiss1);
        epoux.setSit_famil("v");
        epoux.setId_cit(111);
        epoux.setId_deces(0);
        epoux.setCode_lieunaiss(3114);
        epoux.setDate_est_presume(false);
        epoux.setEst_masculin(true);
        epoux.setP_pere("حمراني عبد الكريم");
        epoux.setNp_mere("فاطمة بلهاشمي");

        Citoyen epouse1 = new Citoyen();
        epouse1.setNom_ar("بن سالم");
        epouse1.setPrenom_ar("عائشة");

        epouse1.setDate_naiss(date_naiss2);
        epouse1.setSit_famil("m");
        epouse1.setId_cit(112);
        epouse1.setId_deces(0);
        epouse1.setCode_lieunaiss(3108);
        epouse1.setDate_est_presume(false);
        epouse1.setEst_masculin(false);

        Citoyen epouse2 = epouse1;
        epouse2.setNom_ar("عدادي");
        epouse2.setNom_ar("فاطمة الزهراء");
        epouse2.setId_cit(113);



        FicheFam fiche = new FicheFam(null);
        fiche.setCitoyen(epoux);
        Mariage mar1 = new Mariage();
        Mariage mar2 = new Mariage();

        mar1.setEpoux(epoux);
        mar2.setEpoux(epoux);
        mar1.setEpouse(epouse1);
        mar2.setEpouse(epouse2);
        mar1.setLieu_mar(3102);
        mar2.setLieu_mar(3122);
        mar1.setDate_mar(date_mar1);
        mar2.setDate_mar(date_mar2);
        mar1.setId_mar(100);
        mar2.setId_mar(101);
        mar1.setNumact_mar(1000);
        mar2.setNumact_mar(2000);
        mar1.setId_epoux(111);
        mar2.setId_epoux(111);
        mar1.setId_epouse(112);
        mar2.setId_epouse(113);

        Enfant enf1 = new Enfant();
        Enfant enf2 = new Enfant();
        Enfant enf3 = new Enfant();
        enf1.setId_mar(100);
        enf2.setId_mar(100);
        enf2.setId_mar(100);
        enf1.setPrenom_enf("محمد عبد الهادي");
        enf2.setPrenom_enf("منصور");
        enf3.setPrenom_enf("نور الهدى ليلى");
        enf1.setDate_naiss(date_naissENf1);
        enf1.setDate_est_presume(true);
        enf2.setDate_naiss(date_naissENf2);
        enf3.setDate_naiss(date_naissENf3);
        enf3.setEst_masculin(false);
        enf1.setId_enf(1);
        enf2.setId_enf(2);
        enf3.setId_enf(3);
        enf1.setLieu_naiss(3116);
        enf2.setLieu_naiss(3117);
        enf3.setLieu_naiss(119);
        TreeSet<Enfant> enfants = new TreeSet<Enfant>();
        enfants.add(enf1);        enfants.add(enf2);        enfants.add(enf3);

        families = new TreeSet<Mariage>();
        families.add(mar1);
        families.add(mar2);


        fiche.setFamilies(families);
        fiche.setSelectedFamily(mar1);
        fiche.setEnfants(enfants);

        return fiche;
    }

    /**
     * @verifies return ficheFam for current mariage to the appropriete citoyen
     * @see com.sebaainf.fichfamil.common.FicheFam#FicheFam(int, Date, int)
     */
    @Test
    public void FicheFam_shouldReturnFicheFamForCurrentMariageToTheApproprieteCitoyen() throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date_mar = new Date(dateFormat.parse("10/03/2010").getTime());

        FicheFam mafiche = new FicheFam(22, date_mar, 3101);
        //FicheFam mafiche2 = new FicheFam(22, date_mar, 22001);

        assertThat(mafiche.getCitoyen().getNom_ar(), equalTo("عربي"));
        assertThat(mafiche.getCitoyen().getPrenom_ar(), equalTo("أحمد"));
        assertThat(mafiche.getSelectedFamily().getNumact_mar(), equalTo(22));
        assertThat(mafiche.getSelectedFamily().getEpouse().getPrenom_ar(), equalTo("أسماء"));
        assertThat(mafiche.getFamilies().first().getNumact_mar(), equalTo(1033));
        //assertThat(mafiche2, equalTo(null));

    }

    /**
     * @verifies return ficheFam for the citoyen citoyen with the last mariage as selectedFamily
     * @see FicheFam#FicheFam(com.sebaainf.fichfamil.citoyen.Citoyen)
     */
    @Test
    public void FicheFam_shouldReturnFicheFamForTheCitoyenCitoyenWithTheLastMariageAsSelectedFamily() throws Exception {

        Citoyen cit = MyDaosCitoyen.getCitoyen(88, 1970, 3101);
        FicheFam mafiche = new FicheFam(cit);

        assertThat(mafiche.getCitoyen().getNom_ar(), equalTo("عربي"));
        assertThat(mafiche.getCitoyen().getPrenom_ar(), equalTo("أحمد"));
        assertThat(mafiche.getSelectedFamily().getNumact_mar(), equalTo(1033));
        assertThat(mafiche.getSelectedFamily().getEpouse().getPrenom_ar(), equalTo("حنان"));
        //assertThat(mafiche.getSelectedConjoint().getPrenom_ar(), equalTo("حنان"));
    }
}
