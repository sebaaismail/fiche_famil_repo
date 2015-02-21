package com.sebaainf.fichfamil.test;

import com.jenkov.db.itf.PersistenceException;
import com.sebaainf.fichfamil.common.Enfant;
import com.sebaainf.fichfamil.common.FicheFam;
import com.sebaainf.fichfamil.persistance.MyDaosCitoyen;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.*;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by ${sebaainf.com} on 24/01/2015.
 */
public class TestNestedReport {



    public static void main(String[] args) {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();

        int width = (int)screenSize.getWidth();
        int height = (int)screenSize.getHeight();


        System.out.println("Welcome to Fiche familiale app... testing nested beans jasper report");

        try {
            JasperReport jasperReport1;
            JasperReport jasperReport2;
            JasperDesign jasperDesign1;
            JasperDesign jasperDesign2;
            JasperPrint jasperPrint1;
            JasperPrint jasperPrint2;


            JRBeanCollectionDataSource beanDs1, beanDs2;

            Map parameters = new HashMap();

            FicheFam maFiche = null;

            beanDs1 = new JRBeanCollectionDataSource(getFicheFamil());
            beanDs2 = new JRBeanCollectionDataSource(getFicheFamil().iterator().next().getEnfants());

            parameters.put("COUNT_ROWS", beanDs2.getData().size());
            parameters.put("myText", "سنــة  ");

            jasperDesign1 = JRXmlLoader.load("reports/tryNestedReport1.jrxml");
            jasperDesign2 = JRXmlLoader.load("reports/tryNestedReport2.jrxml");


            jasperReport1 = JasperCompileManager.compileReport(jasperDesign1);
            jasperReport2 = JasperCompileManager.compileReport(jasperDesign2);


            jasperPrint1 = JasperFillManager.fillReport(jasperReport1, parameters, beanDs1);
            jasperPrint2 = JasperFillManager.fillReport(jasperReport2, parameters, beanDs2);



            /* if we went to merge the two pages in one

            jasperPrint1.addPage(jasperPrint2.getPages().get(0));
            //*/

            JasperViewer.viewReport(jasperPrint2);
            JasperViewer.viewReport(jasperPrint1);

            int x = JasperViewer.getFrames()[0].getX() ;
            int y = JasperViewer.getFrames()[0].getY();
            JasperViewer.getFrames()[0].setLocation(x + 100, y + 100);

        } catch (JRException e) {
            e.printStackTrace();
        }

        System.out.println("end test");

    }

    public static Collection<FicheFam> getFicheFamil() {

        FicheFam maFiche = null;
        Vector data = new Vector<FicheFam>();

        try {
            maFiche = new FicheFam(MyDaosCitoyen.getCitoyen(88, 1970, 3101));
            //maFiche = new FicheFam();

            data.add(maFiche);
        } catch (PersistenceException e) {
            e.printStackTrace();
        } finally {
            return data;
        }

    }

    public static Collection<Enfant> getEnfants() {

        Enfant enfant = null;
        Vector data = new Vector<Enfant>();

        try {
            enfant = new Enfant();
            //maFiche = new FicheFam();

            data.add(enfant);
        } finally {
            return data;
        }

    }
}
