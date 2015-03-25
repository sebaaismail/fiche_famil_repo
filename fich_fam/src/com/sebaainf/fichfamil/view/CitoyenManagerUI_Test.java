package com.sebaainf.fichfamil.view;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.adapter.ComboBoxAdapter;
import com.jgoodies.binding.beans.Model;
import com.jgoodies.binding.beans.PropertyAdapter;
import com.jgoodies.binding.beans.PropertyConnector;
import com.jgoodies.binding.list.SelectionInList;
import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.common.collect.ArrayListModel;
import com.jgoodies.forms.layout.FormLayout;
import com.sebaainf.fichfamil.citoyen.Citoyen;
import com.sebaainf.fichfamil.presentation.CitoyenPresentation;

import javax.swing.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * Created by ${sebaainf.com} on 03/03/2015.
 */
public class CitoyenManagerUI_Test {

    private final JTextField nom_fr;
    private final JTextField prenom_fr;
    private final JTextField nom_ar;
    private final JTextField prenom_ar;
    private final JTextField date_naiss;
    private final JComboBox code_lieunaiss;
    private final JComboBox sit_famil;
    private final JRadioButton masculin;
    private final JRadioButton feminin;

    private final JTextField p_pere;
    private final JTextField np_mere;
    private final JTextField id_deces;
    private final JCheckBox date_est_presume;

    private JPanel panel;
    private IsmPanelLieuOld pan;


    public CitoyenManagerUI_Test(final CitoyenPresentation presenter) {

        nom_fr = BasicComponentFactory.createTextField(presenter.getNom_fr(), false);
        prenom_fr = BasicComponentFactory.createTextField(presenter.getPrenom_fr(), false);
        nom_ar = BasicComponentFactory.createTextField(presenter.getNom_ar(), false);
        prenom_ar = BasicComponentFactory.createTextField(presenter.getPrenom_ar(), false);
        date_naiss = BasicComponentFactory.createDateField(presenter.getDate_naiss());

        masculin = BasicComponentFactory.createRadioButton(presenter.getEst_masculin()
                , true, "masculin");
        feminin = BasicComponentFactory.createRadioButton(presenter.getEst_masculin()
                , false, "feminin");


        //************************************************
        // 2 look page 255 selectionInList as bean channel
        final ArrayListModel<SituationFam> situations_fam = new ArrayListModel();
        situations_fam.add(new SituationFam("c", "Celibataire"));
        situations_fam.add(new SituationFam("m", "Marié"));
        situations_fam.add(new SituationFam("d", "Divorcé"));
        situations_fam.add(new SituationFam("v", "Veuf"));



       /*
        SelectionInList selectionInList = new SelectionInList((ListModel) situations_fam);

        BeanAdapter adapter = new BeanAdapter(selectionInList.getSelectionHolder());
        ValueModel sitFam = adapter.getValueModel("sitFam");
        ValueModel text = adapter.getValueModel("text");
        selectionInList.setSelectionHolder(text);

        sit_famil = BasicComponentFactory.createComboBox(selectionInList);
        //*/

        //*********************** /best
        /*
        ArrayList selection = new ArrayList();
        selection.add("c");
        selection.add("m");
        selection.add("v");
        selection.add("d");

        ValueModel selectionHolderSitFam = presenter.getSit_famil();
        ComboBoxAdapter comboBoxAdapter = new ComboBoxAdapter(selection, selectionHolderSitFam);
        sit_famil = new JComboBox();
        sit_famil.setModel(comboBoxAdapter);

        // * *********************** /best
        //*/

        //*

        // set the presentation model up to the first bean.
        SituationFam theSitFam = null;
        for (SituationFam obj : situations_fam) {
            if (obj.sitFam.equals(presenter.getSit_famil().getValue())) {
                theSitFam = obj;
                break;
            }
        }
        final PresentationModel beanPresentationModel = new PresentationModel(theSitFam);

        // create a property adapter for the presentation model 'bean' property.
        ValueModel beanProperty = new PropertyAdapter(beanPresentationModel, "bean");
        SelectionInList selectionInList
                = new SelectionInList((ListModel) situations_fam, beanProperty);

/*        beanPresentationModel.getModel("sitFam").addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                presenter.getSit_famil().setValue(beanPresentationModel.getValue("sitFam"));
            }
        });*/
        //*
        // TODO when set mairié after changing selected comboBox client dont update ???
        //* good
        PropertyConnector.connectAndUpdate(beanPresentationModel.getModel("sitFam"),
                presenter.citoyen, Citoyen.PROPERTY_SIT_FAMIL);
        // TODO but button modifier citoyen causes problem ???
        //must delete this because it commit a bug in firing change events
        //PropertyConnector.connectAndUpdate(presenter.getSit_famil(),
        //    beanPresentationModel.getBean(), "sitFam");
        //*/

        // wire our new combobox up to that property adapter.
        //sit_famil = new JComboBox(new ComboBoxAdapter((List) situations_fam,beanProperty));
        //ComboBoxAdapter adapter = new ComboBoxAdapter(selectionInList);
        sit_famil = new JComboBox();
        Bindings.bind(sit_famil, selectionInList);


        // testing
        PropertyChangeListener propChangelistner = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

                JOptionPane.showMessageDialog(null,
                        "<html> property <b>" + evt.getPropertyName()
                                + "</b> changed old Value = " + evt.getOldValue()
                                + " new Value = " + evt.getNewValue() + "</html>");
            }
        };

        //selectionInList.addPropertyChangeListener(propChangelistner);
        //presenter.getSit_famil().addValueChangeListener(propChangelistner);
        //selectionInList.addPropertyChangeListener("selection", propChangelistner);

/*        presenter.getSit_famil().addValueChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                sit_famil.update(sit_famil.getGraphics());
               sit_famil.updateUI();

            }
        });*/

        //*/
       /*
        ComboBoxAdapter adapter = new ComboBoxAdapter((List) situations_fam,beanProperty);
        sit_famil = new JComboBox(adapter);
        PropertyConnector connector = PropertyConnector.connect(beanPresentationModel.getValue("bean"), "sitFam",
                presenter.citoyen, "sit_famil");
        connector.updateProperty1();
        connector.updateProperty2();
        //*/
        //ValueModel selectionHolderSitFam = presenter.getSit_famil();

        //*ComboBoxAdapter comboBoxAdapter = new ComboBoxAdapter(selectionInList, selectionHolderSitFam);
        //*sit_famil = new JComboBox();
        //*sit_famil.setModel(comboBoxAdapter);
        //*/
        // Lieu de naissance
        ValueModel selectionHolderLieuNaiss = presenter.getCode_lieunaiss();
        ValueModel beanLieuNaiss = new ValueHolder();
        pan = new IsmPanelLieuOld(new Integer((Integer) selectionHolderLieuNaiss.getValue()));
        //BeanAdapter beanAdapter = new BeanAdapter(beanLieuNaiss);

        ComboBoxAdapter comboBoxAdapterCommune = new ComboBoxAdapter(pan.getComboBoxCommunes().getModel(), beanLieuNaiss);
        code_lieunaiss = new JComboBox();
        code_lieunaiss.setModel(comboBoxAdapterCommune);


        //************************************************

        p_pere = BasicComponentFactory.createTextField(presenter.getP_pere(), false);
        np_mere = BasicComponentFactory.createTextField(presenter.getNp_mere(), false);

        id_deces = BasicComponentFactory.createIntegerField(presenter.getId_deces(), 0);
        date_est_presume = BasicComponentFactory.createCheckBox(presenter.getDate_est_presume(), "date presumé");

        buildPanel();

    }

    private void buildPanel() {

        FormLayout layout = new FormLayout("right:pref, $lcgap, left:pref");

        IsmFormBuilder builder = new IsmFormBuilder(layout);


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

    public class SituationFam extends Model {


        private String sitFam = "";
        private String text = "";

        public SituationFam(String sitFam, String text) {

            this.sitFam = sitFam;
            this.text = text;
        }

        public String getSitFam() {

            return sitFam;
        }

        public void setSitFam(String sitFam) {

            String oldValue = this.sitFam;
            this.sitFam = sitFam;
            //if (oldValue != sitFam) {
            this.firePropertyChange("sitFam", oldValue, sitFam);
            System.out.println("oldValue = " + oldValue + " new = " + sitFam);
            //}
        }

        public String getText() {

            return text;
        }

        public void setText(String text) {

            String oldValue = this.text;
            this.text = text;
            //if (oldValue != text) {
            this.firePropertyChange("text", oldValue, text);
            //}

        }

        public String toString() {

            return this.text;
        }

    }
}
