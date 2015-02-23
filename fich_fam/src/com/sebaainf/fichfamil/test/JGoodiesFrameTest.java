/*
 * Created by JFormDesigner on Wed Feb 04 16:06:42 CET 2015
 */

package com.sebaainf.fichfamil.test;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.forms.builder.DefaultFormBuilder;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.ValidationResultModel;
import com.jgoodies.validation.util.DefaultValidationResultModel;
import com.jgoodies.validation.view.ValidationResultViewFactory;
import com.sebaainf.fichfamil.common.FicheFam;
import com.sebaainf.fichfamil.common.Mariage;
import com.sebaainf.fichfamil.presentation.MariageValidator;
import com.sebaainf.fichfamil.view.DateLabelFormatter;
import com.sebaainf.fichfamil.view.JPanelLieu;
import com.sebaainf.fichfamil.view.ReportFichFam;
import org.jdatepicker.AbstractDateModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Date;
import java.util.Properties;

/**
 * @author sebaa ismail
 */
public class JGoodiesFrameTest extends JFrame {

    private ValidationResultModel validationResultModel = new DefaultValidationResultModel();
    private PresentationModel<Mariage> adapter = new PresentationModel<Mariage>(new Mariage());
    private JLabel messageLabel = ValidationResultViewFactory.createReportIconAndTextLabel(validationResultModel);

    private JDatePickerImpl datePicker;
    private JPanelLieu pan = new JPanelLieu(3101);

    public JGoodiesFrameTest() {

        //this.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.createPanel());
        this.pack();
        this.setLocationRelativeTo(null); //to center the frame in the middle of screen
        this.setSize(500, 500);

    }

    public JComponent createPanel() {

        JPanel panel;

        //final JTextField numActMarField = new JTextField(10);
        //final JTextField numActMarField;


        //final JTextField numActMarField = BasicComponentFactory.createTextField(adapter.getModel("numact_mar"));
        // ZERO "0" here is empty number for the JFormattedTextField
        final JTextField numActMarField = BasicComponentFactory.createIntegerField(adapter.getModel("numact_mar"), 0);

        //final JFormattedTextField numActMarField = BasicComponentFactory.createIntegerField(adapter.getModel("numact_mar"), 0);

        //numActMarField.setText("");
                //final JTextField numActMarField = BasicComponentFactory.createTextField(adapter.getModel("numact_mar"));

        numActMarField.setPreferredSize(new Dimension(140, 20));
        /**
         * preparing the datePicker
         */

        JFormattedTextField textField = BasicComponentFactory.createDateField(adapter.getModel("date_mar"));

        final UtilDateModel dateModel = new UtilDateModel();
        dateModel.setDate(2000, 01, 01);
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, new Properties());
        //JDatePanelImpl datePanel = new JDatePanelImpl(adapter.getModel("date_mar"), new Properties());
        //JDateComponentFactory fact = new JDateComponentFactory();
        //datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

        org.jdatepicker.impl.UtilDateModel dateModel1 = new UtilDateModel();

        //datePicker = BasicComponentFactory.createDateField(new JDatePickerImpl(datePanel, new DateLabelFormatter()));


        datePicker.getJFormattedTextField().setPreferredSize(new Dimension(numActMarField.getPreferredSize().width, datePicker.getPreferredSize().height));
        datePicker.setPreferredSize(datePicker.getJFormattedTextField().getPreferredSize());


        JButton buttonChercher = new JButton(new ValidationAction());


       /**
         * preparing the panelBuilder
         */
        FormLayout layout = new FormLayout("right:pref, $lcgap, left:pref");
        //FormLayout layout = new FormLayout("right:pref, $lcgap, left:max(pref;80dlu)");
        //CellConstraints cc = new CellConstraints();

        //this.validationResultModel.addPropertyChangeListener(new ValidationListener());


        final JComboBox myCommunesComboBox = pan.getComboBoxCommunes();

        DefaultFormBuilder builder = new DefaultFormBuilder(layout);


        builder.append("N° act mariage : ", numActMarField);
        //append("N° act mariage : ",new JTextField());
        builder.append("Date : ", datePicker);

        //builder.appendSeparator("Lieu : ");


        builder.append("Wilaya : ", pan.getComboBoxWilayas());
        builder.append("Commune : ", myCommunesComboBox);
        builder.append(pan.ismTextField, buttonChercher);
        builder.append(pan.ismTextField2);
        builder.append(pan.labelCommune1, pan.labelCommune2);

        builder.append("", buttonChercher);
        builder.append(messageLabel);


        panel = builder.getPanel();
        //panel.setVisible(false);

        //Bindings.bind(numActMarField, preModel.getBufferedModel("numact_mar"));

        return panel;
    }

    private void initComponents() {


    }

    private class HandlerClass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    private class ValidationAction extends AbstractAction {

        public ValidationAction(){
            super("chercher");
        }
        /**
         * Invoked when an action occurs.
         *
         * @param e
         */
        @Override
        public void actionPerformed(ActionEvent e) {

            //to reinitialiser validationResultModel
            //todo when do that ? maybe if components has been edited
            validationResultModel.setResult(ValidationResult.EMPTY);

            java.util.Date selectedDate = (java.util.Date) datePicker.getModel().getValue();
            Date dateMar = new Date(selectedDate.getTime());
            int lieu = (Integer) pan.getId_c_Model().getValue();

            //preModel.getBean().setDate_mar(dateMar);
            //preModel.getBean().setLieu_mar(lieu);

            //preModel.triggerCommit();

            MariageValidator validator = new MariageValidator(adapter);

            ValidationResult result = validator.validate(adapter.getBean());
            validationResultModel.setResult(result);
            if (!result.hasErrors()) {

                FicheFam ficheFam = new FicheFam(adapter.getBean().getNumact_mar(),dateMar ,lieu);
                if (ficheFam.getSelectedFamily() != null) {
                    ReportFichFam.reportFicheFam(ficheFam);
                } else {
                    JOptionPane.showMessageDialog(null, "Mariage introuvable !");
                }
            }


        }
    }

    private class ValidationListener implements PropertyChangeListener {

        /**
         * This method gets called when a bound property is changed.
         *
         * @param evt A PropertyChangeEvent object describing the event source
         *            and the property that has changed.
         */
        @Override
        public void propertyChange(PropertyChangeEvent evt) {


            if (evt.getPropertyName() == ValidationResultModel.PROPERTY_RESULT) {
                JOptionPane.showMessageDialog(null, "Validation has been performed");
            } else if (evt.getPropertyName() == ValidationResultModel.PROPERTY_MESSAGES) {

            }

        }
    }
}