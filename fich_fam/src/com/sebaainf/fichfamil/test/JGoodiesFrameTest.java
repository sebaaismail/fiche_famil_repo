/*
 * Created by JFormDesigner on Wed Feb 04 16:06:42 CET 2015
 */

package com.sebaainf.fichfamil.test;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.sebaainf.fichfamil.common.FicheFam;
import com.sebaainf.fichfamil.persistance.MyDaos;
import com.sebaainf.fichfamil.view.DateLabelFormatter;
import com.sebaainf.fichfamil.view.JPanelLieu;
import com.sebaainf.fichfamil.view.ReportFichFam;
import javafx.scene.control.ComboBox;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.util.Properties;

/**
 * @author sebaa ismail
 */
public class JGoodiesFrameTest extends JFrame {


    public JGoodiesFrameTest() {

        //this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.createPanel());
        this.pack();
        this.setLocationRelativeTo(null); //to center the frame in the middle of screen
        this.setSize(500, 500);

    }

    public JComponent createPanel() {

        JPanel panel;

        final JTextField numActMarField = new JTextField(10);

        /**
         * preparing the datePicker
         */

        final JDatePickerImpl datePicker;

        final UtilDateModel dateModel = new UtilDateModel();
        dateModel.setDate(2000, 01, 01);
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, new Properties());

        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());


        datePicker.getJFormattedTextField().setPreferredSize(new Dimension(numActMarField.getPreferredSize().width, datePicker.getPreferredSize().height));
        datePicker.setPreferredSize(datePicker.getJFormattedTextField().getPreferredSize());


        JButton buttonChercher = new JButton();
        buttonChercher.setText("Chercher");

       /**
         * preparing the panelBuilder
         */
        FormLayout layout = new FormLayout("right:pref, $lcgap, left:pref");
        //FormLayout layout = new FormLayout("right:pref, $lcgap, left:max(pref;80dlu)");
        //CellConstraints cc = new CellConstraints();

        final JPanelLieu pan = new JPanelLieu(3120);
        final JComboBox myCommunesComboBox = pan.getComboBoxCommunes();

        buttonChercher.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
                Date dateMar = new Date(selectedDate.getTime());
                int lieu = (Integer) pan.getId_c_Model().getValue();

                FicheFam ficheFam = new FicheFam(new Integer(numActMarField.getText()),dateMar ,lieu);
                ReportFichFam.reportFicheFam(ficheFam);

            }
        });

        DefaultFormBuilder builder = new DefaultFormBuilder(layout);


        builder.append("N° act mariage : ", numActMarField);
        //append("N° act mariage : ",new JTextField());
        builder.append("Date : ", datePicker);

        //builder.appendSeparator("Lieu : ");


        builder.append("Wilaya : ", pan.getComboBoxWilayas());
        builder.append("Commune : ", myCommunesComboBox);
        builder.append(pan.ismTextField, buttonChercher);
        builder.append(pan.ismTextField2);
        builder.append(pan.labelCommune1, pan.labelCommune2);

        builder.append("", buttonChercher);


        panel = builder.getPanel();
        //panel.setVisible(false);

        return panel;
    }

    private void initComponents() {


    }

    private class HandlerClass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


}