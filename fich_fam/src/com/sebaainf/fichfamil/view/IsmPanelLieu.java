package com.sebaainf.fichfamil.view;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.adapter.ComboBoxAdapter;
import com.jgoodies.binding.beans.BeanAdapter;
import com.jgoodies.binding.beans.PropertyAdapter;
import com.jgoodies.binding.beans.PropertyConnector;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.sebaainf.fichfamil.citoyen.Citoyen;
import com.sebaainf.fichfamil.common.Commune;
import com.sebaainf.fichfamil.common.MyApp;
import com.sebaainf.fichfamil.common.Wilaya;
import com.sebaainf.fichfamil.presentation.CitoyenEditorModel;
import com.sebaainf.fichfamil.presentation.CitoyenPresentation;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by admin on 06/02/2015.
 * JPanel encapsulate two JCombobox Wilaya and commune and the default commune
 */
public class IsmPanelLieu extends JComponent {

    //for test TODO delete this in production
   /*
    public JTextField ismTextField;
    public JTextField ismTextField2;
    public JTextField labelCommune1;
  //*/

    private JComboBox comboBoxWilayas;
    private JComboBox comboBoxCommunes;
    private ValueModel id_c_Model;


    public IsmPanelLieu(ValueModel id_c_Model, CitoyenEditorModel model) {
        // par defaut set MyApp.default_id_c in place of selectedCommune

        //this.default_id_c = default_id_c;

        /**
         * preparing combobox Wilayas
         */

        ListModel wilayas = new ArrayListModel(Wilaya.getWilayas());


        final int numW;
        if ((Integer) id_c_Model.getValue() < 101) {
            // TODO test this case
            numW = MyApp.default_id_c / 100;
        } else {
            numW = (Integer) (id_c_Model.getValue()) / 100;
        }

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

        SelectionInList selectionInListWil = new SelectionInList(wilayas);
        BeanAdapter beanAdapter = new BeanAdapter(selectionInListWil);

        final ValueModel id_w_Model = beanAdapter.getValueModel("id_w");

        ComboBoxAdapter comboBoxAdapter = new ComboBoxAdapter(selectionInListWil);


        this.setComboBoxWilayas(new JComboBox(comboBoxAdapter));
        this.getComboBoxWilayas().setSelectedItem(defaultwilaya);

        /**
         * preparing Communes
         *
         */
        ArrayListModel<Commune> communes
                = new ArrayListModel(Commune.getCollectionCommunes(numW));
        Commune laCommune = null;

        for (Commune obj : communes) {
            if (obj.getId_c() == (Integer)(id_c_Model.getValue())) {
                laCommune = obj;
                break;
            }
        }

        final PresentationModel beanPresentationModel = new PresentationModel(laCommune);

        // create a property adapter for the presentation model 'bean' property.
        final ValueModel beanProperty = new PropertyAdapter(beanPresentationModel, "bean");
        final SelectionInList[] selectionInListCommune = {new SelectionInList((ListModel) communes, beanProperty)};
        // TODO when set mairié after changing selected comboBox client dont update ???
        //* good
        PropertyConnector.connectAndUpdate
                (beanPresentationModel.getModel(Commune.PROPERTY_ID_C),
                model.getBean(), Citoyen.PROPERTY_CODE_LIEUNAISS);


        // wire our new combobox up to that property adapter.
        //sit_famil = new JComboBox(new ComboBoxAdapter((List) situations_fam,beanProperty));
        //ComboBoxAdapter adapter = new ComboBoxAdapter(selectionInList);
        comboBoxCommunes = new JComboBox();
        Bindings.bind(comboBoxCommunes, selectionInListCommune[0]);

        comboBoxWilayas.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //TODO need optimisation of memory garbage and performance,
                // TODO shoul variable static ?? intelij performance view
                //TODO delete this after inserting all communes in data base
                int wil = (Integer) id_w_Model.getValue();
                wil = (wil < 31) ? 1 : 31;
                ListModel newListcommunes = new ArrayListModel(Commune.getCollectionCommunes(wil));

                selectionInListCommune[0].release();
                selectionInListCommune[0] = new SelectionInList(
                        newListcommunes, beanProperty);
                selectionInListCommune[0].setSelectionIndex(0);
                Bindings.bind(comboBoxCommunes, selectionInListCommune[0]);
            }
        });

        FormLayout layout = new FormLayout("right:pref, $lcgap, max(50dlu;pref)");
        this.setLayout(layout);
        DefaultFormBuilder builder = new DefaultFormBuilder(layout);

        builder.appendSeparator("Lieu : ");
        builder.append("Wilaya : ", this.getComboBoxWilayas());
        builder.append("Commune : ", this.getComboBoxCommunes());

        //todo delete that line
        //builder.append(ismTextField, ismTextField2);

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
