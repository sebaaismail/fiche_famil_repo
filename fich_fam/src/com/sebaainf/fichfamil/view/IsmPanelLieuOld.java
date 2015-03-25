package com.sebaainf.fichfamil.view;

import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.adapter.ComboBoxAdapter;
import com.jgoodies.binding.beans.BeanAdapter;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.sebaainf.fichfamil.common.Commune;
import com.sebaainf.fichfamil.common.ListCommunes;
import com.sebaainf.fichfamil.common.MyApp;
import com.sebaainf.fichfamil.common.Wilaya;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 06/02/2015.
 * JPanel encapsulate two JCombobox Wilaya and commune and the default commune
 */
public class IsmPanelLieuOld extends JComponent {

    public JLabel labelCommune2;

    private JComboBox comboBoxWilayas;
    private JComboBox comboBoxCommunes;
    private ValueModel code_com_model;


    public IsmPanelLieuOld(int selectedCommune) {
        // par defaut set MyApp.default_id_c in place of selectedCommune

        //this.default_id_c = default_id_c;

        /**
         * preparing combobox Wilayas
         */
        //java.util.List<String> list = MyFunctions.getListWilaya();

        ListModel wilayas = new ArrayListModel(Wilaya.getWilayas());


        final int numW = selectedCommune / 100;
        Wilaya defaultwilaya = null;

//*
        for (int i = 0; i < wilayas.getSize(); i++) {
            if (((Wilaya) wilayas.getElementAt(i)).getCode_wilaya() == numW) {
                defaultwilaya = (Wilaya) wilayas.getElementAt(i);
                break;
            }
            System.out.println(((Wilaya) wilayas.getElementAt(i)).getWil_fr());
        }
//*/

        SelectionInList selectionInListWil = new SelectionInList(wilayas);
        BeanAdapter beanAdapterWil = new BeanAdapter(selectionInListWil);

        final ValueModel code_w_Model
                = beanAdapterWil.getValueModel(Wilaya.PROPERTY_CODE_WILAYA);

        ComboBoxAdapter comboBoxAdapterWil = new ComboBoxAdapter(selectionInListWil);


        this.setComboBoxWilayas(new JComboBox(comboBoxAdapterWil));
        this.getComboBoxWilayas().setSelectedItem(defaultwilaya);

        /**
         * preparing Communes
         *
         */
        ListModel communes = new ArrayListModel(ListCommunes.getCollectionCommunes(numW));
        Commune defaultCommune = null;

        for (int i = 0; i < communes.getSize(); i++) {
            if (((Commune) communes.getElementAt(i)).getCode_commune() == selectedCommune) {
                defaultCommune = (Commune) communes.getElementAt(i);
                break;
            }
            System.out.println(((Commune) communes.getElementAt(i)).getCom_fr());
        }

        final SelectionInList selectionInListCom = new SelectionInList(communes);//TODO initialise communes
        BeanAdapter beanAdapterCom = new BeanAdapter(selectionInListCom);

        setCode_com_model(beanAdapterCom.getValueModel(Commune.PROPERTY_CODE_COMMUNE));
        ValueModel com_fr_Model
                = beanAdapterCom.getValueModel(Commune.PROPERTY_COM_FR);

        labelCommune2 = BasicComponentFactory.createLabel(com_fr_Model);


        labelCommune2.setPreferredSize(new Dimension(140, 20));

        final ComboBoxAdapter comboBoxAdapterCom = new ComboBoxAdapter(selectionInListCom);

        this.setComboBoxCommunes(new JComboBox(comboBoxAdapterCom));
        this.getComboBoxCommunes().setSelectedItem(defaultCommune);


        //*

        comboBoxWilayas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO need optimisation of memory garbage and performance,
                // TODO shoul variable static ?? intelij performance view
                //TODO delete this after inserting all communes in data base
                int wil = (Integer) code_w_Model.getValue();
                ListModel newCommune = new ArrayListModel(ListCommunes.getCollectionCommunes(wil));

                //ListModel newCommune = new ArrayListModel(Commune.getCollectionCommunes((Integer) id_w_Model.getValue()));
                selectionInListCom.setListModel(newCommune);
                selectionInListCom.setSelection(newCommune.getElementAt(0));

            }
        });
        //*/



        FormLayout layout = new FormLayout("right:pref, $lcgap, right:pref");
        this.setLayout(layout);
        DefaultFormBuilder builder = new DefaultFormBuilder(layout);

        builder.appendSeparator("Lieu : ");
        builder.append("Wilaya : ", this.getComboBoxWilayas());
        builder.append("Commune : ", this.getComboBoxCommunes());

        builder.append(labelCommune2, labelCommune2);

    }


    public JComboBox getComboBoxWilayas() {

        return comboBoxWilayas;
    }

    public void setComboBoxWilayas(JComboBox comboBoxWilayas) {

        this.comboBoxWilayas = comboBoxWilayas;
    }

    public JComboBox getComboBoxCommunes() {

        return comboBoxCommunes;
    }

    public void setComboBoxCommunes(JComboBox comboBoxCommunes) {

        this.comboBoxCommunes = comboBoxCommunes;
    }

    public ValueModel getCode_com_model() {

        return code_com_model;
    }

    public void setCode_com_model(ValueModel code_com_model) {

        this.code_com_model = code_com_model;
    }
}
