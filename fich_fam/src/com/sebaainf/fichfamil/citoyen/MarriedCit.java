package com.sebaainf.fichfamil.citoyen;

import com.sebaainf.fichfamil.common.Mariage;

import java.util.Date;
import java.util.TreeSet;

/**
 * Created by admin on 10/01/2015.
 */
public class MarriedCit extends Citoyen implements IMarried {

    private TreeSet<Mariage> families = new TreeSet<Mariage>();


    @Override
    public void setFamilies(TreeSet<Mariage> families) {

        this.families = families;

    }

    @Override
    public TreeSet<Mariage> getFamilies() {

        return this.families;
    }

    @Override
    public Mariage getFamily(Date date_mar) {

        TreeSet<Mariage> fams = this.getFamilies();
        Mariage fam = null;
        for (Mariage f : fams) {
            if (f.getDate_mar() == date_mar) {
                fam = f;
                break;
            }
        }
        return fam;

        //Family fm = fms.iterator().i;

    }

    public MarriedCit (){
        this.setSit_famil("m");
    }
}
