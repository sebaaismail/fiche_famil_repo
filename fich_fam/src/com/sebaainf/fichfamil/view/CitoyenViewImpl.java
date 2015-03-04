package com.sebaainf.fichfamil.view;

import com.jgoodies.forms.layout.FormLayout;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Date;

/**
 * Created by ${sebaainf.com} on 28/02/2015.
 */
public class CitoyenViewImpl implements CitoyenView {

    private JTextField nom_arField;
    private JTextField prenom_arField;
    private JTextField nom_frField;
    private JTextField prenom_frField;


    private JTextField date_naissField;
    private JCheckBox date_est_presumeCheck;

    private JComboBox wilayaNaiss;
    private JComboBox code_lieunaissField;

    private JTextField p_pereField;
    private JTextField np_mereField;

    private JOptionPane sexOption;
    private JComboBox sit_familField;

    private JOptionPane decesOption;

    private JPanel panel;


    public CitoyenViewImpl() {
        initComponents();
        layoutPanel();
    }

    public JPanel getPanel() {
        return this.panel;
    }

    private void initComponents() {

        this.nom_arField = new JTextField(20);
        this.prenom_arField = new JTextField(20);
        this.nom_frField = new JTextField(20);
        this.prenom_frField = new JTextField(20);

        this.p_pereField = new JTextField(20);
        this.np_mereField = new JTextField(40);

        this.date_naissField = new JTextField(15);
        this.code_lieunaissField = new JComboBox();
        this.date_est_presumeCheck = new JCheckBox();
        this.date_est_presumeCheck.addItemListener(new date_est_presumeCheckListener());

        this.wilayaNaiss = new JComboBox();
        this.sit_familField = new JComboBox();
        this.sexOption = new JOptionPane();
        this.decesOption = new JOptionPane();

        sexOption.setInputValue("Masculin");
        sexOption.setInputValue("Feminin");

        decesOption.setInputValue("En vie");
        decesOption.setInputValue("Deces");

    }

    private void layoutPanel() {

        FormLayout layout = new FormLayout("r:p, p, l:p");
        MyFormBuilder builder = new MyFormBuilder(layout);

        builder.setDefaultDialogBorder();
        builder.append(":اللقب", nom_arField);
        builder.append(":الإسم", prenom_arField);

        builder.append("Nom :", nom_frField);
        builder.append("Prenom :", prenom_frField);

        builder.append("Date naiss :", date_naissField);
        builder.append("Wilaya naiss :", wilayaNaiss);
        builder.append("Commune naiss :", code_lieunaissField);

        builder.append("Date presumé :", date_est_presumeCheck);

        builder.append("fils de :", p_pereField);
        builder.append("et :", np_mereField);

        builder.append("SituationFamiliale:", sit_familField);
        builder.append("Sex :", sexOption);
        builder.append("Deces :", decesOption);



    }



    @Override
    public String getNom_ar() {

        return this.nom_arField.getText();
    }

    @Override
    public void setNom_ar(String nom_ar) {
        this.nom_arField.setText(nom_ar);
        this.nom_arField.setCaretPosition(0);//TODO  ??

    }

    @Override
    public String getPrenom_ar() {

        return this.prenom_arField.getText();
    }

    @Override
    public void setPrenom_ar(String prenom_ar) {
        this.prenom_arField.setText(prenom_ar);
        this.prenom_arField.setCaretPosition(0);

    }

    @Override
    public String getNom_fr() {

        return this.nom_frField.getText();
    }

    @Override
    public void setNom_fr(String nom_fr) {
        this.nom_frField.setText(nom_fr);
        this.nom_frField.setCaretPosition(0);

    }

    @Override
    public String getPrenom_fr() {

        return this.prenom_frField.getText();
    }

    @Override
    public void setPrenom_fr(String prenom_fr) {
        this.prenom_frField.setText(prenom_fr);
        this.prenom_frField.setCaretPosition(0);

    }

    @Override
    public String getDate_naiss() {

        return date_naissField.getText();
    }

    @Override
    public void setDate_naiss(String date_naiss) {
        this.date_naissField.setText(date_naiss);
        this.date_naissField.setCaretPosition(0);

    }

    @Override
    public Object getCode_lieunaiss() {

        return this.code_lieunaissField.getSelectedItem();
    }

    @Override
    public void setCode_lieunaiss(Object code_lieunaiss) {
        this.code_lieunaissField.setSelectedItem(code_lieunaiss);

    }

    @Override
    public String getP_pere() {

        return this.p_pereField.getText();
    }

    @Override
    public void setP_pere(String p_pere) {
        this.p_pereField.setText(p_pere);
        this.p_pereField.setCaretPosition(0);

    }

    @Override
    public String getNp_mere() {

        return this.np_mereField.getText();
    }

    @Override
    public void setNp_mere(String np_mere) {
        this.np_mereField.setText(np_mere);
        this.np_mereField.setCaretPosition(0);

    }

    @Override
    public Boolean getEst_masculin() {

        return (sexOption.getInputValue().equals("Masculin"));
    }

    @Override
    public void setEst_masculin(Boolean est_masculin) {
        //todo

    }

    @Override
    public int getId_deces() {

        return (Integer) decesOption.getInputValue();//todo
    }

    @Override
    public void setId_deces(int id_deces) {
        //todo

    }

    @Override
    public Boolean getDate_est_presume() {

        return date_est_presumeCheck.isSelected();
    }

    @Override
    public void setDate_est_presume(Boolean date_est_presume) {
        this.date_est_presumeCheck.setSelected(date_est_presume);

    }

    @Override
    public String getSit_famil() {

        return sit_familField.getSelectedItem().toString();
    }

    @Override
    public void setSit_famil(String sit_famil) {
        this.sit_familField.setSelectedItem(sit_famil);

    }

    private class date_est_presumeCheckListener implements ItemListener {

        /**
         * Invoked when an item has been selected or deselected by the user.
         * The code written for this method performs the operations
         * that need to occur when an item is selected (or deselected).
         *
         * @param e
         */
        @Override
        public void itemStateChanged(ItemEvent e) {
            //TODO
        }
    }
}
