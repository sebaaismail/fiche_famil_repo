package com.sebaainf.fichfamil.view;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.adapter.ComboBoxAdapter;
import com.jgoodies.binding.beans.BeanAdapter;
import com.jgoodies.binding.beans.Model;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ComponentValueModel;
import com.jgoodies.binding.value.ConverterFactory;
import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.forms.layout.FormLayout;
import com.sebaainf.fichfamil.presentation.CitoyenPresentation;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by ${sebaainf.com} on 03/03/2015.
 */
public class CitoyenManagerUI {

    private final JTextField nom_fr ;
    private final JTextField prenom_fr;
    private final JTextField nom_ar;
    private final JTextField prenom_ar;
    private final JTextField date_naiss;
    private final JTextField code_lieunaiss;
    private final JComboBox sit_famil;
    private final JRadioButton masculin;
    private final JRadioButton feminin;

    private final JTextField p_pere;
    private final JTextField np_mere;
    private final JTextField id_deces;
    private final JCheckBox date_est_presume;

    private JPanel panel;



    public CitoyenManagerUI(CitoyenPresentation presenter) {

        nom_fr = BasicComponentFactory.createTextField(presenter.getNom_fr(), false);
        prenom_fr = BasicComponentFactory.createTextField(presenter.getPrenom_fr(), false);
        nom_ar = BasicComponentFactory.createTextField(presenter.getNom_ar(), false);
        prenom_ar = BasicComponentFactory.createTextField(presenter.getPrenom_ar(), false);
        date_naiss = BasicComponentFactory.createDateField(presenter.getDate_naiss());
        code_lieunaiss = BasicComponentFactory.createIntegerField(presenter.getCode_lieunaiss(), 0);
        masculin = BasicComponentFactory.createRadioButton(presenter.getEst_masculin()
                , true, "masculin");
        feminin = BasicComponentFactory.createRadioButton(presenter.getEst_masculin()
                ,false,"feminin");

        //************************************************
        ListModel<SituationFam> situations_fam = new ArrayListModel<SituationFam>();
        ((ArrayListModel)situations_fam).add(new SituationFam("c", "Celibataire"));
        ((ArrayListModel)situations_fam).add(new SituationFam("m", "Marié"));
        ((ArrayListModel)situations_fam).add(new SituationFam("d", "Divorcé"));
        ((ArrayListModel)situations_fam).add(new SituationFam("v", "Veuf"));

        SelectionInList selection = new SelectionInList(situations_fam);


        //String str = valueModel.getValue().toString();

        //selection.setSelectionHolder((new PresentationModel(sitFamChannel)).getModel("sitFam")); //todo todo

        ComboBoxAdapter comboBoxAdapter = new ComboBoxAdapter(selection, presenter.getSit_famil());






        sit_famil = BasicComponentFactory.createComboBox(selection);
        sit_famil.setModel(comboBoxAdapter);


        //************************************************

        p_pere = BasicComponentFactory.createTextField(presenter.getP_pere(), false);
        np_mere = BasicComponentFactory.createTextField(presenter.getNp_mere(), false);

        id_deces = BasicComponentFactory.createIntegerField(presenter.getId_deces(), 0);
        date_est_presume = BasicComponentFactory.createCheckBox(presenter.getDate_est_presume(), "date presumé");
        
        buildPanel();
        
    }

    private void buildPanel() {

        FormLayout layout = new FormLayout("right:pref, $lcgap, left:pref");

        MyFormBuilder builder = new MyFormBuilder(layout);

        JPanelLieu pan = new JPanelLieu();

        builder.append("nom :", nom_fr);
        builder.append("Prenom :", prenom_fr);
        builder.append("اللقب :", nom_ar);
        builder.append("الإسم :", prenom_ar);
        builder.append("Date naiss :", date_naiss);
        builder.append("Date présumé", date_est_presume);
        builder.append("Wilaya naiss :", pan.getComboBoxWilayas());
        builder.append("Lieu naiss :", code_lieunaiss);
        builder.append("Sit Fam :", sit_famil);
        builder.append(masculin, feminin);
        builder.append("Fils de :", p_pere);
        builder.append("Et de :", np_mere);
        builder.append("Id_deces :", id_deces);

        panel = builder.getPanel();

    }


    public JPanel getPanel() {
        return panel;
    }

    class SituationFam extends Model {
        private String sitFam = "";
        private String text = "";

        SituationFam(String sitFam, String text) {
            this.sitFam = sitFam;
            this.text = text;
        }

        public String toString() {

            return this.sitFam;
        }

    }
}
