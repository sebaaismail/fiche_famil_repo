package com.sebaainf.fichfamil.test;

import com.sebaainf.fichfamil.common.Commune;
import com.sebaainf.fichfamil.common.ListCommunes;

import java.util.List;

/**
 * Created by ${sebaainf.com} on 22/03/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class TestXmlCommunes {

    public static void main(String[] args) {


        List<Commune> list = ListCommunes.getCollectionCommunes(0);
        for (Commune com : list) {
            System.out.println(com.getCode_commune() + " # "
            + com.getCom_fr() + " # " + com.getCom_fr());
        }

    }
}
