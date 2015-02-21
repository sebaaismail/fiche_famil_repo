package com.sebaainf.fichfamil.test;

import com.sebaainf.fichfamil.citoyen.Citoyen;
import com.sebaainf.fichfamil.persistance.MyDaosCitoyen;
import org.junit.Assert;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Collection;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by admin on 25/01/2015.
 */
public class MyDaosCitoyenTest {

    /**
     * @verifies return citoyen with num_actnaiss annee_naiss lieu_naiss parameters
     * @see com.sebaainf.fichfamil.persistance.MyDaosCitoyen#getCitoyen(int, int, int)
     */
    @Test
    public void getCitoyen_shouldReturnCitoyenWithNum_actnaissAnnee_naissLieu_naissParameters() throws Exception {

        Collection lecitoyen = MyDaosCitoyen.getCitoyens();
        String lastName = MyDaosCitoyen.getCitoyen(88, 1970, 3101).getPrenom_fr();
        assertThat(lastName, equalTo("ahmed"));

    }

    /**
     * @verifies return citoyen with id_cit
     * @see MyDaosCitoyen#getCitoyen(int)
     */
    @Test
    public void getCitoyen_shouldReturnCitoyenWithId_cit() throws Exception {

        Citoyen cit = MyDaosCitoyen.getCitoyen(13);
        String nom_ar = cit.getNom_ar();
        assertThat(nom_ar, equalTo("عربي"));
        assertThat(cit.getSit_famil(), equalTo("m"));

        Citoyen miky = MyDaosCitoyen.getCitoyen(-1000);
        assertThat(miky, equalTo(null));
    }

    /**
     * @verifies return citoyen with nom prenom date et lieu de naiss unique normalement
     * @see MyDaosCitoyen#getCitoyen(String, String, java.util.Date, int)
     */
    @Test
    public void getCitoyen_shouldReturnCitoyenWithNomPrenomDateEtLieuDeNaissUniqueNormalement() throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(sdf.parse("20/08/1985").getTime());

        Citoyen moi = MyDaosCitoyen.getCitoyen("sebaa", "ismail", date, 3114);

        assertThat(moi.getNp_mere(), equalTo("فريحات حليمة"));
    }


//*/

    /**
     * @verifies insert citoyen cit into Data base
     * @see MyDaosCitoyen#insertCitoyen(com.sebaainf.fichfamil.citoyen.Citoyen)
     */
    @Test
    public void insertCitoyen_shouldInsertCitoyenCitIntoDataBase() throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(sdf.parse("01/01/1990").getTime());

        //*
        Citoyen cit = new Citoyen();
        cit.setPrenom_fr("tata");
        cit.setNom_fr("TOTO");
        cit.setDate_naiss(date);
        cit.setAnnee_actnaiss(2006);

        MyDaosCitoyen.insertCitoyen(cit);

        Citoyen cit2 = new Citoyen();
        cit2.setNum_actnaiss(33);
        cit2.setCode_lieunaiss(55);
        cit2.setPrenom_fr("titi");
        cit2.setNom_fr("KAKA");
        cit2.setDate_naiss(date);

        MyDaosCitoyen.insertCitoyen(cit2);

        //*/ cet citoyen s'ajoute pas .. il existe deja mm si le num act naiss est differe
        Citoyen cit3 = new Citoyen();
        cit3.setNum_actnaiss(331);
        cit3.setCode_lieunaiss(55);
        cit3.setPrenom_fr("titi");
        cit3.setNom_fr("KAKA");
        cit3.setDate_naiss(date);

        MyDaosCitoyen.insertCitoyen(cit3);

        //Assert.("Not yet implemented");
    }

    /**
     * @verifies update citoyen cit
     * @see MyDaosCitoyen#updateCitoyen(com.sebaainf.fichfamil.citoyen.Citoyen)
     */
    @Test
    public void updateCitoyen_shouldUpdateCitoyenCit() throws Exception {


        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(sdf.parse("01/01/1990").getTime());

        Citoyen cit = MyDaosCitoyen.getCitoyen("KAKAWITA", "titissa", date, 55);
        cit.setNom_fr("KAKA");
        cit.setPrenom_fr("titi");
        cit.setNom_ar("كاكاواتي");
        cit.setPrenom_ar("تيتي");
        MyDaosCitoyen.updateCitoyen(cit);
        String newName = MyDaosCitoyen.getCitoyen(cit.getId_cit()).getNom_fr();

        assertThat(newName, equalTo("KAKA"));
        // return old values to ensure next tests again
        cit.setNom_fr("KAKAWITA");
        cit.setPrenom_fr("titissa");
        MyDaosCitoyen.updateCitoyen(cit);
    }

    /**
     * @verifies delete citoyen cit and return true if cit is deleted from data base
     * @see MyDaosCitoyen#deleteCitoyen(com.sebaainf.fichfamil.citoyen.Citoyen)
     */
    @Test

    public void deleteCitoyen_shouldDeleteCitoyenCit() throws Exception {

        Citoyen cit1 = MyDaosCitoyen.getCitoyen(60);
        Citoyen citSaver = cit1;
        boolean flag = MyDaosCitoyen.deleteCitoyen(cit1);
        MyDaosCitoyen.insertCitoyen(citSaver);
        assertThat(flag, equalTo(true));

        flag = MyDaosCitoyen.deleteCitoyen(new Citoyen());
        assertThat(flag, equalTo(false));
    }

    /**
     * @verifies delete citoyen cit by id_cit
     * @see MyDaosCitoyen#deleteCitoyen(int)
     */
    @Test

    public void deleteCitoyen_shouldDeleteCitoyenCitById_cit() throws Exception {

        //TODO auto-generated
        Assert.fail("Not yet implemented");
    }
}
