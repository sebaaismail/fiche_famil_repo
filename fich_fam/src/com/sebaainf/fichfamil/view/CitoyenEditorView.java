package com.sebaainf.fichfamil.view;

import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.layout.CellConstraints;
import com.sebaainf.fichfamil.common.MyCommonUtils;
import com.sebaainf.fichfamil.presentation.CitoyenEditorModel;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.EventObject;

/**
 * Created by ${sebaainf.com} on 14/03/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class CitoyenEditorView {

    private final CitoyenEditorModel model;
    private JTextField nom_fr;
    private JTextField prenom_fr;
    private JTextField nom_ar;
    private JTextField prenom_ar;

    private JDatePickerImpl date_naiss;
    private JComboBox code_lieunaiss;
    private JComboBox sit_famil;
    private JRadioButton masculinChoice;
    private JRadioButton femininChoice;

    private JTextField p_pere;
    private JTextField np_mere;
    private JCheckBox id_deces;
    private JCheckBox date_est_presume;
    private IsmPanelLieu panel;

    private JDatePickerImpl date_deces;
    private JTextField lieu_deces;


    private JButton okButton;
    private JButton annulerButton;


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
        sit_famil = IsmComponentFactory.createComboBox(model.getSelList_sit_famil());

        masculinChoice = IsmComponentFactory.createRadioButton(model.getEst_masculin()
                , true, "ذكر");
        femininChoice = IsmComponentFactory.createRadioButton(model.getEst_masculin()
                , false, "أنثى");
        masculinChoice.setHorizontalTextPosition(SwingConstants.LEFT);
        femininChoice.setHorizontalTextPosition(SwingConstants.LEFT);

        date_naiss = IsmComponentFactory.createDatePickerImpl(model, "yyyy/MM/dd");
        date_est_presume = IsmComponentFactory.createCheckBox(
                model.getDate_est_presume(), "* مفترض");

        // we use createBooleanNegator to return the inverse of Boolean
        //id_deces = IsmComponentFactory.createCheckBox(model.getId_deces(), "* على قيد الحياة");

        //*
        id_deces = new JCheckBox("* على قيد الحياة");
        if ((Integer)(model.getId_deces().getValue()) > 0) {
            id_deces.setSelected(false);
        } else {
            id_deces.setSelected(true);
        }
        //*/


        id_deces.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    lieu_deces.setEnabled(true);
                    date_deces.setTextEditable(true);
                    // set the button disabled
                    date_deces.getComponent(1).setEnabled(true);

                } else if (e.getStateChange() == ItemEvent.DESELECTED) {
                    lieu_deces.setEnabled(false);
                    date_deces.setTextEditable(false);
                    date_deces.getJFormattedTextField().setText("");
                    // set the button disabled
                    date_deces.getComponent(1).setEnabled(false);
                }
            }
        });

        p_pere = IsmComponentFactory.createTextField(model.getP_pere());
        np_mere = IsmComponentFactory.createTextField(model.getNp_mere());

        panel =
                IsmComponentFactory.createPanelLieu(model.getCode_lieunaiss(), model);

        // HorizontalAlignment of JTextField
        nom_ar.setHorizontalAlignment(JTextField.RIGHT);
        prenom_ar.setHorizontalAlignment(JTextField.RIGHT);
        p_pere.setHorizontalAlignment(JTextField.RIGHT);
        np_mere.setHorizontalAlignment(JTextField.RIGHT);

        // TODO
        date_deces = IsmComponentFactory.createDatePickerDecesImpl();
        lieu_deces = new JTextField(20);

        okButton = new JButton("Ok");
        annulerButton = new JButton("Annuler");



    }


    private JComponent buildContent() {

        MyCommonUtils.setListComponentsEnabled(getListComponents(),true);


/*
        FormLayout layout = new FormLayout(

                //      textField         label         textField           label     //
                "  4dlu,pref:grow,4dlu,right:pref,3dlu ,pref:grow  ,4dlu ,right:pref"//, //columns
                //      --------          ------        ---------           -------
        );
*/

        CellConstraints cc = new CellConstraints();

        return FormBuilder.create()
                .columns("40dlu,fill:default,8dlu,left:pref,100dlu ,150dlu, 8dlu, fill:default, 40dlu")
                .rows("40dlu,p,6dlu,p,6dlu,p,6dlu,p,6dlu,p,6dlu,p,6dlu,p,6dlu,p")
                .columnGroups(new int[][]{{2, 6}, {4, 8}})
                .rowGroups(new int[][]{{12, 14}})
                .add("الإســم :").xy(8, 2)
                .add(nom_ar).xy(6, 2)
                .add(": Nom").xy(4, 2)
                .add(nom_fr).xy(2, 2)
                .add("اللقــب :").xy(8, 4)
                .add(prenom_ar).xy(6, 4)
                .add(": Prenom").xy(4, 4)
                .add(prenom_fr).xy(2, 4)
                .add("تاريخ الإزدياد :").xy(8, 6)
                .add(date_naiss).xy(6, 6)
                .add(date_est_presume).at(cc.xy(6, 8, CellConstraints.RIGHT,
                        CellConstraints.CENTER))
                .add("مكان الإزدياد :").xy(4, 6)
                .add(panel.getComboBoxWilayas()).xy(2, 6)
                .add(panel.getComboBoxCommunes()).xy(2, 8)
                .add("إسم ولقب الأب :").xy(8, 10)
                .add(p_pere).xy(6,10)
                .add("إسم ولقب الأم :").xy(4, 10)
                .add(np_mere).xy(2, 10)
                .add("الجنس :").xy(4, 12)
                .add(masculinChoice).at(cc.xy(2, 12, CellConstraints.RIGHT,
                        CellConstraints.CENTER))
                .add(femininChoice).at(cc.xy(2, 14, CellConstraints.RIGHT,
                        CellConstraints.CENTER))
                .add(id_deces).xy(6, 12)
                .add("تاريخ الوفاة :").xy(8, 16)
                .add(date_deces).xy(6, 16)
                .add("مكان الوفاة :").xy(4, 16)
                .add(lieu_deces).xy(2, 16)


                // TODO buttons ok annuler ?

                .build();


    }

    public JComponent showDialog(EventObject e) {

        return buildContent();

    }

    public ArrayList<JComponent> getListComponents() {

        ArrayList<JComponent> list = new ArrayList<JComponent>();
        list.add(nom_ar);
        list.add(prenom_ar);
        list.add(nom_fr);
        list.add(prenom_fr);
        list.add(date_naiss);
        list.add(date_est_presume);
        list.add(panel.getComboBoxCommunes());
        list.add(panel.getComboBoxWilayas());
        list.add(p_pere);
        list.add(np_mere);
        list.add(masculinChoice);
        list.add(femininChoice);
        list.add(id_deces);

        return list;

    }
}
