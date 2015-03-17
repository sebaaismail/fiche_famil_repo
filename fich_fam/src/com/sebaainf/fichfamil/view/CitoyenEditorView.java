package com.sebaainf.fichfamil.view;

import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.forms.builder.FormBuilder;
import com.jgoodies.forms.debug.FormDebugPanel;
import com.jgoodies.forms.layout.CellConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.sebaainf.fichfamil.presentation.CitoyenEditorModel;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
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
    private JTextField id_deces;
    private JCheckBox date_est_presume;
    private IsmPanelLieu panel;


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
        date_est_presume = IsmComponentFactory.createCheckBox(model.getDate_est_presume(), "* مفترض");
        p_pere = IsmComponentFactory.createTextField(model.getP_pere());
        np_mere = IsmComponentFactory.createTextField(model.getNp_mere());

        panel =
                IsmComponentFactory.createPanelLieu(model.getCode_lieunaiss(), model);

        // HorizontalAlignment of JTextField
        nom_ar.setHorizontalAlignment(JTextField.RIGHT);
        prenom_ar.setHorizontalAlignment(JTextField.RIGHT);
        p_pere.setHorizontalAlignment(JTextField.RIGHT);
        np_mere.setHorizontalAlignment(JTextField.RIGHT);



    }


    private JComponent buildContent() {

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

                .build();

    }

    public JComponent showDialog(EventObject e) {

        return buildContent();

    }

}
