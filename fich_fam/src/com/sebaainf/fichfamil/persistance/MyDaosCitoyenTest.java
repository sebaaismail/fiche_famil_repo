package com.sebaainf.fichfamil.persistance;

import com.sebaainf.fichfamil.citoyen.Citoyen;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by admin on 07/02/2015.
 */
public class MyDaosCitoyenTest {

    /**
     * @verifies verifies if cit existe in the data base
     * @see MyDaosCitoyen#isInDBCitoyen(com.sebaainf.fichfamil.citoyen.Citoyen)
     */
    @Test
    public void isInDBCitoyen_shouldVerifiesIfCitExisteInTheDataBase() throws Exception {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date(sdf.parse("20/08/1985").getTime());

        Citoyen moi = new Citoyen();
        moi.setNom_fr("sebaa");
        moi.setPrenom_fr("ismail");
        moi.setDate_naiss(date);
        moi.setCode_lieunaiss(31014);

        Citoyen her = new Citoyen();
        her.setNum_actnaiss(58);
        her.setAnnee_actnaiss(1988);
        her.setCode_lieunaiss(16002);

        Citoyen him = new Citoyen();
        him.setNum_actnaiss(14);
        him.setAnnee_actnaiss(2000);
        him.setCode_lieunaiss(16001);

        Citoyen fake = new Citoyen();

        assertThat(MyDaosCitoyen.isInDBCitoyen(moi), equalTo(true));
        assertThat(MyDaosCitoyen.isInDBCitoyen(her), equalTo(true));
        assertThat(MyDaosCitoyen.isInDBCitoyen(him), equalTo(false));
        assertThat(MyDaosCitoyen.isInDBCitoyen(fake), equalTo(false));
    }
}
