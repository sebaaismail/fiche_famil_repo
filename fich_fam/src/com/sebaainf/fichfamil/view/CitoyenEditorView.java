package com.sebaainf.fichfamil.view;

import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.factories.ComponentFactory;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.sebaainf.fichfamil.citoyen.Citoyen;
import com.sebaainf.fichfamil.presentation.CitoyenEditorModel;
import javafx.scene.layout.Pane;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.plaf.PanelUI;
import java.text.ParseException;
import java.util.Calendar;
import java.sql.Date;
import java.util.EventObject;
import java.util.GregorianCalendar;
import java.util.Properties;

/**
 * Created by ${sebaainf.com} on 14/03/2015.
 */
public class CitoyenEditorView {

    private final CitoyenEditorModel model;
    private JTextField nom_fr ;
    private JTextField prenom_fr;
    private JTextField nom_ar;
    private JTextField prenom_ar;
    private JDatePickerImpl date_naiss;
    private JComboBox code_lieunaiss;
    private JComboBox sit_famil;
    private JRadioButton masculin;
    private JRadioButton feminin;

    private JTextField p_pere;
    private JTextField np_mere;
    private JTextField id_deces;
    private JCheckBox date_est_presume;

    CitoyenEditorView(CitoyenEditorModel model) {
        this.model = model;
        initComponents();

    }

    private void initComponents() {


        nom_fr = BasicComponentFactory.createTextField(model.getNom_fr());
        prenom_fr = BasicComponentFactory.createTextField(model.getPrenom_fr());
        nom_ar = BasicComponentFactory.createTextField(model.getNom_ar());
        prenom_ar = BasicComponentFactory.createTextField(model.getPrenom_ar());

        //code_lieunaiss = BasicComponentFactory.createComboBox(model.getCode_lieunaiss());
        sit_famil = BasicComponentFactory.createComboBox(model.getSelList_sit_famil());

        masculin = BasicComponentFactory.createRadioButton(model.getEst_masculin()
                , true, "masculin");
        feminin = BasicComponentFactory.createRadioButton(model.getEst_masculin()
                ,false,"feminin");
        nom_ar.setHorizontalAlignment(JTextField.RIGHT);
        prenom_ar.setHorizontalAlignment(JTextField.RIGHT);
        date_naiss = MyComonentFactory.createDatePickerImpl(model);


        // preparing date_naiss --- > JDatePicker
/*
        final UtilDateModel dateModel = new UtilDateModel();
        dateModel.setDate(2000, 01, 01);

        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, new Properties());
        //JDatePanelImpl datePanel = new JDatePanelImpl(adapter.getModel("date_mar"), new Properties());
        //JDateComponentFactory fact = new JDateComponentFactory();

        MyDateFormatter formatter = new MyDateFormatter();
        date_naiss = new JDatePickerImpl(datePanel, formatter);
        //datePicker = new JDatePickerImpl(datePanel, new MyDateFormatter());
        date_naiss.setShowYearButtons(true);
        date_naiss.setButtonFocusable(true);
        date_naiss.setTextEditable(true);
        date_naiss.getJFormattedTextField().setHorizontalAlignment(JTextField.RIGHT);

        Date date = (Date) model.getDate_naiss().getValue();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        date_naiss.getModel().setDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        date_naiss.getJDateInstantPanel().getModel().setSelected(true);

        try {
            date_naiss.getJFormattedTextField().setText(formatter.valueToString(calendar));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        */


    }


    private JComponent buildContent(){

        FormLayout layout = new FormLayout(

                //      textField         label         textField           label     //
                "  4dlu,pref:grow,4dlu,right:pref,3dlu ,pref:grow  ,4dlu ,right:pref"//, //columns
                //      --------          ------        ---------           -------
        );

        return FormBuilder.create()
                .columns("40dlu,150dlu,8dlu,right:pref,100dlu ,150dlu, 8dlu, right:pref, 40dlu")
                .rows("40dlu,p,6dlu,p,6dlu,p,6dlu,p,6dlu,p,6dlu,p,6dlu,p,6dlu,p")
                .add("الإسم :")         .xy(8, 2)
                .add(nom_ar)            .xy(6, 2)
                .add(": Nom")           .xy(4, 2)
                .add(nom_fr)            .xy(2, 2)
                .add("اللقب :")         .xy(8, 4)
                .add(prenom_ar)         .xy(6, 4)
                .add(": Prenom")        .xy(4, 4)
                .add(prenom_fr)         .xy(2, 4)
                .add("تاريخ الإزدياد :").xy(8, 6)
                .add(date_naiss)        .xy(6, 6)
                .build();

    }

    public JComponent showDialog(EventObject e) {
        return buildContent();

    }

}
