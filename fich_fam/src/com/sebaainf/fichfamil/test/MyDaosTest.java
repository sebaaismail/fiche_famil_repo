package com.sebaainf.fichfamil.test;

import com.sebaainf.fichfamil.common.Enfant;
import com.sebaainf.fichfamil.common.Mariage;
import com.sebaainf.fichfamil.persistance.MyDaos;
import com.sebaainf.fichfamil.persistance.MyDaosCitoyen;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.TreeSet;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by admin on 17/01/2015.
 */
public class MyDaosTest {

    /**
     * @verifies return family that match the parameters
     * @see com.sebaainf.fichfamil.persistance.MyDaos#getMariage(int, java.sql.Date, int)
     */
    @Test
    public void getFamily_shouldReturnFamilyThatMatchTheParameters() throws Exception {

        MyDaos daos = new MyDaos();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        java.sql.Date date = new Date(dateFormat.parse("10/02/2000").getTime());
        Mariage mar = MyDaos.getMariage(22, date, 31001);
        int i = mar.getId_epouse();
        assertThat(i, equalTo(14));
    }

    /**
     * @verifies return families of the citoyen cit
     * @see MyDaos#getFamilies(com.sebaainf.fichfamil.citoyen.Citoyen)
     */
    @Test
    public void getFamilies_shouldReturnFamiliesOfTheCitoyenCit() throws Exception {

        TreeSet<Mariage> mariages = MyDaos.getFamilies(MyDaosCitoyen.getCitoyen(13));
        int numact = mariages.first().getNumact_mar();

        assertThat(numact, equalTo(1033));
    }

    /**
     * @verifies return family that match the parameters
     * @see MyDaos#getMariage(int, java.sql.Date, int)
     */
    @Test
    public void getMariage_shouldReturnFamilyThatMatchTheParameters() throws Exception {

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date_mar = new Date(dateFormat.parse("10/02/2000").getTime());

        Mariage mar = MyDaos.getMariage(22, date_mar, 31001);
        assertThat(mar.getEpouse().getPrenom_ar(), equalTo("أسماء"));
        assertThat(mar.getEpoux().getPrenom_ar(), equalTo("أحمد"));
    }

    /**
     * @verifies return enfants de mariage avec id_mar
     * @see MyDaos#getEnfants(int)
     */
    @Test
    public void getEnfants_shouldReturnEnfantsDeMariageAvecId_mar() throws Exception {

        //TODO auto-generated
        TreeSet<Enfant> enfants = MyDaos.getEnfants(1);
        for (Enfant enf : enfants) {
            System.out.println(enf.getLieu_naiss() + " " + enf.getDate_naiss()
                    + " " + enf.getEst_masculin() + " " + enf.getPrenom_enf());
        }

        assertThat(enfants.last().getPrenom_enf(), equalTo("جمال الدين"));
    }
}
