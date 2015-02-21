package com.sebaainf.fichfamil.test;

import com.jenkov.db.itf.PersistenceException;
import com.sebaainf.fichfamil.persistance.MyDaosCitoyen;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 24/01/2015.
 */
public class TestReport {


    public static void main(String[] args) {

        System.out.println("Welcome to Fiche familiale app... testing jasper report");

        try {
            JasperReport jasperReport = null;
            JasperDesign jasperDesign = null;
            JasperPrint jasperPrint = null;

            JRBeanCollectionDataSource beanDs = new JRBeanCollectionDataSource(MyDaosCitoyen.getCitoyens());

            Map parameters = new HashMap();

            jasperDesign = JRXmlLoader.load("reports/fichefamilReport1.jrxml");
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, beanDs);

            JasperViewer.viewReport(jasperPrint);


        } catch (JRException e) {
            e.printStackTrace();
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        System.out.println("end test");

    }

}
