package com.sebaainf.fichfamil.citoyen;

import com.sebaainf.fichfamil.common.Mariage;

import java.util.Date;
import java.util.TreeSet;

/**
 * Created by admin on 20/01/2015.
 */
public interface IMarried {


    TreeSet<Mariage> getFamilies();

    void setFamilies(TreeSet<Mariage> families);

    Mariage getFamily(Date date_mar);
}
