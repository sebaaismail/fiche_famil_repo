package com.sebaainf.fichfamil.common;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import com.thoughtworks.xstream.io.xml.Xpp3Driver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 06/02/2015.
 */
@XStreamAlias("ListCommunes") // maps ListCommunes element in XML to this class
public class ListCommunes {

    @XStreamImplicit(itemFieldName = "Commune")
    private List communes = new ArrayList();

    public List getCommunes() {

        return communes;
    }

    public void setCommunes(List communes) {

        this.communes = communes;
    }



    public static List<Commune> getCollectionCommunes(int code_wilaya) {

        //XStream
        XStream xstream = new XStream(new Xpp3Driver());
        xstream.alias("ListCommunes", ListCommunes.class);


        //return MyDaos.getCollectionCommunes(id_wil);
        //List<Commune> listCommunes;
        //http://www.javacodegeeks.com/2013/04/xstream-xstreamely-easy-way-to-work-with-xml-data-in-java.html
        FileReader reader = null;  // load file
        try {
            reader = new FileReader("data/communes.xml");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        xstream.processAnnotations(ListCommunes.class);  // inform XStream to parse annotations in ListCommunes class
        xstream.processAnnotations(Commune.class);      // and in two other classes...
        //xstream.processAnnotations(Person.class);   // we use for mappings
        ListCommunes listCommunes = (ListCommunes) xstream.fromXML(reader); // parse

        List<Commune> resultList = new ArrayList();
        int i = 1;

        for (Object com : listCommunes.getCommunes()) {

            if (((Commune)com).getCode_wilaya() == code_wilaya) {
                resultList.add((Commune) com);
            } else if(resultList.size()>0) {
                // for exit early :optimization
                break;

            }

            System.out.println("iteration n° " + i);
            i++;
        }
        // Print some data to console to see if results are correct

        Commune firstCommune = resultList.get(0);

        System.out.println("First commune = " + firstCommune.toString());

        /*
        try {
            String sql = "select * from commune where ROUND(id_c/100)=?";
            IDaos daos = MyDaos.persistenceManager.createDaos();
            listCommunes = daos.getObjectDao().readList(Commune.class, sql, id_wil);

            communes = new TreeSet<Commune>(listCommunes);

        } catch (PersistenceException e) {
            e.printStackTrace();
        }
        */


        return resultList;
    }

}


