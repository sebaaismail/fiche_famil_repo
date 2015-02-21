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
import com.sebaainf.fichfamil.common.Wilaya;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 06/02/2015.
 * JPanel encapsulate two JCombobox Wilaya and commune and the default commune
 */
public class JPanelLieu extends JPanel {

    private int default_id_c; //get from general variable or file config
    private JComboBox comboBoxWilayas;
    private JComboBox comboBoxCommunes;

    private ValueModel id_c_Model;

    //for test TODO delete this in production

    public JTextField ismTextField;
    public JTextField ismTextField2;
    public JTextField labelCommune1;
    public JLabel labelCommune2;


    public JPanelLieu(int default_id_c) {

        this.default_id_c = default_id_c;

        /**
         * preparing combobox Wilayas
         */
        //java.util.List<String> list = MyFunctions.getListWilaya();

        ListModel wilayas = new ArrayListModel(Wilaya.getWilayas());

        final int numW = default_id_c/100; //TODO clear this and implement default commune
        Wilaya defaultwilaya = null;

//*
        for (int i = 0; i < wilayas.getSize(); i++) {
            if (((Wilaya) wilayas.getElementAt(i)).getId_w() == numW) {
                defaultwilaya = (Wilaya) wilayas.getElementAt(i);
                break;
            }
            System.out.println(((Wilaya) wilayas.getElementAt(i)).getWil_fr());
        }
//*/

        SelectionInList selectionInList = new SelectionInList(wilayas);
        BeanAdapter beanAdapter = new BeanAdapter(selectionInList);

        final ValueModel id_w_Model = beanAdapter.getValueModel("id_w");
        ValueModel wil_fr_Model = beanAdapter.getValueModel("wil_fr");

        ismTextField = BasicComponentFactory.createTextField(wil_fr_Model);
        ismTextField2 = BasicComponentFactory.createIntegerField(id_w_Model);


        //ValueHolder idd_elected_wil =

        ismTextField.setPreferredSize(new Dimension(140, 20));
        ismTextField2.setPreferredSize(new Dimension(140, 20));


        ComboBoxAdapter comboBoxAdapter = new ComboBoxAdapter(selectionInList);



        this.setComboBoxWilayas(new JComboBox(comboBoxAdapter));
        this.getComboBoxWilayas().setSelectedItem(defaultwilaya);

        /**
         * preparing Communes
         *
         */
        ListModel communes = new ArrayListModel(Commune.getCollectionCommunes(numW));
        Commune defaultCommune = null;

        for (int i = 0; i < communes.getSize(); i++) {
            if (((Commune) communes.getElementAt(i)).getId_c() == default_id_c) {
                defaultCommune = (Commune) communes.getElementAt(i);
                break;
            }
            System.out.println(((Commune) communes.getElementAt(i)).getCom_fr());
        }

        final SelectionInList selectionInList2 = new SelectionInList(communes);//TODO initialise communes
        BeanAdapter beanAdapter2 = new BeanAdapter(selectionInList2);

        setId_c_Model(beanAdapter2.getValueModel("id_c"));
        ValueModel com_fr_Model = beanAdapter2.getValueModel("com_fr");

        labelCommune1 = BasicComponentFactory.createIntegerField(getId_c_Model());
        labelCommune2 = BasicComponentFactory.createLabel(com_fr_Model);

        labelCommune1.setPreferredSize(new Dimension(140, 20));
        labelCommune2.setPreferredSize(new Dimension(140, 20));

        final ComboBoxAdapter comboBoxAdapter2 = new ComboBoxAdapter(selectionInList2);

        this.setComboBoxCommunes(new JComboBox(comboBoxAdapter2));
        this.getComboBoxCommunes().setSelectedItem(defaultCommune);

//        communes = new ArrayListModel(Commune.getCollectionCommunes(1));


        //*

        comboBoxWilayas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO need optimisation of memory garbage and performance,
                // TODO shoul variable static ?? intelij performance view
                //TODO delete this after inserting all communes in data base
                int wil = (Integer) id_w_Model.getValue();
                wil = (wil < 31) ? 1 : 31;
                ListModel newListcommunes = new ArrayListModel(Commune.getCollectionCommunes(wil));

                //ListModel newListcommunes = new ArrayListModel(Commune.getCollectionCommunes((Integer) id_w_Model.getValue()));

                selectionInList2.setListModel(newListcommunes);
                selectionInList2.setSelection(newListcommunes.getElementAt(0));

            }
        });
        //*/
        FormLayout layout = new FormLayout("right:pref, $lcgap, left:pref");
        this.setLayout(layout);
        DefaultFormBuilder builder = new DefaultFormBuilder(layout);

        builder.appendSeparator("Lieu : ");
        builder.append("Wilaya : ", this.getComboBoxWilayas());
        builder.append("Commune : ", this.getComboBoxCommunes());
        builder.append(ismTextField, ismTextField2);
        builder.append(labelCommune2, labelCommune2);

    }

    public int getDefault_id_c() {

        return default_id_c;
    }

    public void setDefault_id_c(int default_id_c) {

        this.default_id_c = default_id_c;
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

    public ValueModel getId_c_Model() {

        return id_c_Model;
    }

    public void setId_c_Model(ValueModel id_c_Model) {

        this.id_c_Model = id_c_Model;
    }
}
