package com.sebaainf.fichfamil.common;

import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.sebaainf.fichfamil.view.SearchJFrame;
import com.sebaainf.fichfamil.view.themes.DefaultTheme;
import com.sebaainf.fichfamil.view.themes.MyTheme;

import javax.swing.*;
import java.awt.*;

/**
 * Created by admin on 24/01/2015.
 */
public class MyApp {

    public static int default_id_c = 3101; //todo get from general variable or file config
    public static MyTheme theme = new DefaultTheme(); //todo put in config

    //public static MyTheme theme = new GreyTheme(); //todo put in config
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

        JFrame frame = new SearchJFrame();

        frame.setVisible(true);


        System.out.println("end app");


    }

}
