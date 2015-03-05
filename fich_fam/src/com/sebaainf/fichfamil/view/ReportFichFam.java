package com.sebaainf.fichfamil.view;

import com.sebaainf.fichfamil.common.FicheFam;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

/**
 * Created by admin on 07/02/2015.
 */
public class ReportFichFam {

    public static void report(FicheFam ficheFam) {


        System.out.println("Welcome to Fiche familiale app... testing nested beans jasper report");

        // Preparing data
        Collection<FicheFam> data = new Vector<FicheFam>();
        data.add(ficheFam);


        try {
            JasperReport jasperReport1 = null;
            JasperReport jasperReport2 = null;
            JasperDesign jasperDesign1 = null;
            JasperDesign jasperDesign2 = null;
            JasperPrint jasperPrint1 = null;
            JasperPrint jasperPrint2 = null;


            JRBeanCollectionDataSource beanDs1, beanDs2;

            Map parameters = new HashMap();

            FicheFam maFiche = null;

            beanDs1 = new JRBeanCollectionDataSource(data);
            beanDs2 = new JRBeanCollectionDataSource(data.iterator().next().getEnfants());

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
            int x = JasperViewer.getFrames()[1].getLocation().x;
            int y = JasperViewer.getFrames()[1].getLocation().y;
            JasperViewer.getFrames()[1].setLocation(x + 100, y + 100);


        } catch (JRException e) {
            e.printStackTrace();
        }

        System.out.println("end test");

    }

}
