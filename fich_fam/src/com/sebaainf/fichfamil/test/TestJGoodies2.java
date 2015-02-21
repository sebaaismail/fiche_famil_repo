package com.sebaainf.fichfamil.test;

import com.jenkov.db.itf.PersistenceException;
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.sebaainf.fichfamil.common.Enfant;
import com.sebaainf.fichfamil.common.FicheFam;
import com.sebaainf.fichfamil.common.Mariage;
import com.sebaainf.fichfamil.persistance.MyDaosCitoyen;
import com.sebaainf.fichfamil.view.JFrameSearchCitoyen;

import javax.swing.*;
import java.awt.*;

/**
 * Created by admin on 24/01/2015.
 */
public class TestJGoodies2 {


    public static void main(String[] args) {

        /**
         * set jgoodies Look And Feel
         */

        EventQueue.invokeLater(new Runnable() {
            public void run() {

                try {
                    UIManager.setLookAndFeel(new Plastic3DLookAndFeel());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        //*****************************************************

        System.out.println("Welcome to Fiche familiale app");

        int num_actnaiss = 88;

        int year = 1970;

        int lieu_naiss = 31001;

        FicheFam maFiche = null;
        try {
            maFiche = new FicheFam(MyDaosCitoyen.getCitoyen(num_actnaiss, year, lieu_naiss));
        } catch (PersistenceException e) {
            e.printStackTrace();
        }

        /*
        System.out.println("enter the num act mariage ... 22 for exple :)");
        int num_actmar;
        //BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        num_actmar = sc.nextInt();

        System.out.println("enter the date of mariage ... 10/03/2010 for exple :)");
        String stringDate;
        sc = new Scanner(System.in);

        stringDate = sc.nextLine();
        System.out.println("enter the lieu of mariage ... 31001 for exple :)");

        sc = new Scanner(System.in);
        int lieu_mar = sc.nextInt();


        Fiche maFiche = new Fiche(num_actmar, stringDate, lieu_mar);
        //2/*/
        //FicheFam maFiche = new FicheFam(22, "10/03/2010", 31001);

        System.out.println("le citoyen " + maFiche.getCitoyen().getNom_fr() + " " + maFiche.getCitoyen().getPrenom_fr());
        System.out.println("fils de " + maFiche.getCitoyen().getP_pere() + " et " + maFiche.getCitoyen().getNp_mere());

        System.out.println("marriage selected : ");

        System.out.println("LIEU : " + maFiche.getSelectedFamily().getLieu_mar());
        System.out.println("DATE mariage : " + maFiche.getSelectedFamily().getDate_mar());
        System.out.println("conjoint selected : " + maFiche.getSelectedFamily().getEpouse().getNom_fr() + " " + maFiche.getSelectedFamily().getEpouse().getPrenom_fr());
        //System.out.println("conjoint selected : " + maFiche.getSelectedConjoint().getNom_fr() + " " + maFiche.getSelectedConjoint().getPrenom_fr());
        System.out.println("OBS : " + maFiche.getSelectedFamily().getObs());

        System.out.println("List de marriages  : ");

        for (Mariage mar : maFiche.getFamilies()) {

            System.out.println("*******************************");
            System.out.println("LIEU : " + mar.getLieu_mar());
            System.out.println("DATE mariage : " + mar.getDate_mar());
            System.out.println("conjoint : " + mar.getEpouse().getNom_fr() + " " + mar.getEpouse().getPrenom_fr());
            System.out.println("OBS : " + mar.getObs());

        }

        System.out.println("List des enfants  : ");
        System.out.println("*******************************");
        for (Enfant enf : maFiche.getEnfants()) {
            System.out.println(enf.getLieu_naiss() + " " + enf.getDate_naiss()
                    + " " + enf.getEst_masculin() + " " + enf.getPrenom_enf());
        }
        System.out.println("*******************************");

        JFrame frame = new JGoodiesFrameTest();

        /*
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //frame.add(new JFormSearchCitoyen());

        frame.add(MyGui.createApanel());
        frame.pack();
        frame.setLocationRelativeTo(null); //to center the frame in the middle of screen
        */
        frame.setVisible(true);


        System.out.println("end app");


    }

}
