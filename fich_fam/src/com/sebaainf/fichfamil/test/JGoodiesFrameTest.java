/*
 * Created by JFormDesigner on Wed Feb 04 16:06:42 CET 2015
 */

package com.sebaainf.fichfamil.test;

import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.sebaainf.fichfamil.common.MyApp;
import com.sebaainf.fichfamil.view.JPanelLieu;
import com.sebaainf.fichfamil.view.MyDateFormatter;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Properties;

/**
 * @author sebaa ismail
 */
public class JGoodiesFrameTest extends JFrame {


    public JGoodiesFrameTest() {

        // TODO move that code to initComponents(); hint :look at jasperView frame definition
        //this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.createPanel());
        this.pack();
        this.setLocationRelativeTo(null); //to center the frame in the middle of screen
        this.setSize(500, 500);

    }

    public JComponent createPanel() {

        JPanel panel;

        JTextField numActMarField = new JTextField(10);

        /**
         * preparing the datePicker
         */

        JDatePickerImpl datePicker;

        UtilDateModel dateModel = new UtilDateModel();
        dateModel.setDate(2000, 01, 01);
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, new Properties());

        datePicker = new JDatePickerImpl(datePanel, new MyDateFormatter());

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

        JPanelLieu pan = new JPanelLieu(MyApp.default_id_c);

        DefaultFormBuilder builder = new DefaultFormBuilder(layout);


        builder.append("N° act mariage : ", numActMarField);
        //append("N° act mariage : ",new JTextField());
        builder.append("Date : ", datePicker);

        //builder.appendSeparator("Lieu : ");


        builder.append("Wilaya : ", pan.getComboBoxWilayas());
        builder.append("Commune : ", pan.getComboBoxCommunes());

        /* todo delete this
        builder.append(pan.ismTextField, buttonChercher);
        builder.append(pan.ismTextField2);
        //*/

        builder.append("", buttonChercher);


        panel = builder.getPanel();
        //panel.setVisible(false);

        return panel;
    }

    /*public JComponent createPanel2() {

        JPanel panel = new JPanel();

        *//**
     * preparing combobox Wilayas
     *//*
        //java.util.List<String> list = MyFunctions.getListWilaya();

        ListModel wilayas = new ArrayListModel(Wilaya.getWilayas());

        int numW = 31; //TODO clear this and implement default commune
        Wilaya defaultwilaya = null;


        for(int i=0; i< wilayas.getSize();i++) {
            if (((Wilaya)wilayas.getElementAt(i)).getId_w() == numW) {
                defaultwilaya = (Wilaya)wilayas.getElementAt(i);
                break;

            }
            System.out.println(((Wilaya) wilayas.getElementAt(i)).getWil_fr());
        }


        SelectionInList selectionInList = new SelectionInList(wilayas);
        BeanAdapter beanAdapter = new BeanAdapter(selectionInList);

        ValueModel id_w_Model = beanAdapter.getValueModel("id_w");
        ValueModel wil_fr_Model = beanAdapter.getValueModel("wil_fr");


        JTextField ismTextField = BasicComponentFactory.createTextField(wil_fr_Model);
        JTextField ismTextField2 = BasicComponentFactory.createIntegerField(id_w_Model);




        ismTextField.setPreferredSize(new Dimension(140,20));
        ismTextField2.setPreferredSize(new Dimension(140,20));

        ComboBoxAdapter comboBoxAdapter = new ComboBoxAdapter(selectionInList);

        JComboBox comboBoxWilayas = new JComboBox();
        comboBoxWilayas.setModel(comboBoxAdapter);



        comboBoxWilayas.setSelectedItem(defaultwilaya);

        */

    /**
     * preparing Communes
     * TODO
     *//*
        JComboBox comboBoxCommunes = new JComboBox();

        FormLayout layout = new FormLayout("right:pref, $lcgap, left:pref");
        DefaultFormBuilder builder = new DefaultFormBuilder(layout);

        builder.appendSeparator("Lieu : ");
        builder.append("Wilaya : ", comboBoxWilayas);
        builder.append("Commune : ", comboBoxCommunes);
        builder.append(ismTextField, ismTextField2);

        panel = builder.getPanel();

        return panel;
    }*/
    private void initComponents() {

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolkit.getScreenSize();


    }

    private class HandlerClass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


}