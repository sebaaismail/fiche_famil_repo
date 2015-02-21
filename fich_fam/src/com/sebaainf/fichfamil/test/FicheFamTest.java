package com.sebaainf.fichfamil.test;


import com.sebaainf.fichfamil.citoyen.Citoyen;
import com.sebaainf.fichfamil.common.FicheFam;
import com.sebaainf.fichfamil.persistance.MyDaosCitoyen;
import org.junit.Test;

import java.sql.Date;
import java.text.SimpleDateFormat;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by admin on 24/01/2015.
 */
public class FicheFamTest {

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
