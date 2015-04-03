package com.sebaainf.fichfamil.test;

import com.jenkov.db.itf.PersistenceException;
import com.jgoodies.looks.plastic.Plastic3DLookAndFeel;
import com.sebaainf.fichfamil.common.Enfant;
import com.sebaainf.fichfamil.common.FicheFam;
import com.sebaainf.fichfamil.common.Mariage;
import com.sebaainf.fichfamil.persistance.MyDaosCitoyen;
import com.sebaainf.fichfamil.view.SearchJFrame;

import javax.swing.*;
import java.awt.*;

/**
 * Created by admin on 24/01/2015.
 */
public class TestApp {


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

        JFrame frame = new SearchJFrame();

        frame.setVisible(true);

    }

}
