/*
 * Created by JFormDesigner on Wed Feb 04 16:06:42 CET 2015
 */

package com.sebaainf.fichfamil.view;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.ValidationResultModel;
import com.jgoodies.validation.util.DefaultValidationResultModel;
import com.jgoodies.validation.view.ValidationResultViewFactory;
import com.sebaainf.fichfamil.common.FicheFam;
import com.sebaainf.fichfamil.common.Mariage;
import com.sebaainf.fichfamil.common.MyApp;
import com.sebaainf.fichfamil.presentation.MariageValidator;
import com.sebaainf.fichfamil.test.FicheFamTest;
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
public class SearchJFrame extends JFrame {


    private ValidationResultModel validationResultModel = new DefaultValidationResultModel();
    private PresentationModel<Mariage> adapter = new PresentationModel<Mariage>(new Mariage());
    //private JLabel messageLabel = ValidationResultViewFactory.createReportIconAndTextLabel(validationResultModel);
    private JComponent messageLabel = ValidationResultViewFactory.createReportList(validationResultModel);

    private JDatePickerImpl datePicker;
    private IsmPanelLieuOld pan = new IsmPanelLieuOld(MyApp.default_id_c);

    public SearchJFrame() {

        this.setTitle("Recherche");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.add(this.createPanel());
        this.pack();
        this.setLocationRelativeTo(null); //to center the frame in the middle of screen
        //this.setSize(500, 500);

    }

    public JComponent createPanel() {


        // i create tabbedPanel with MyFormBuilder
        // to centralize attributes like font size etc ...
        JComponent tabbedPanel = new JTabbedPane();
        FormLayout layoutPanel = new FormLayout("right:pref");

        IsmFormBuilder fb = new IsmFormBuilder(layoutPanel);

        fb.append(tabbedPanel);

        tabbedPanel.add(buildChercherMariagePanel(), "Par Mariage");
        tabbedPanel.add(buildChercherCitoyenPanel(), "Par Citoyen");


        //return tabbedPanel;
        return fb.getPanel();
    }

    private JComponent buildChercherCitoyenPanel() {


        /**
         * preparing the panelBuilder
         */
        FormLayout layout = new FormLayout("right:pref, $lcgap, left:pref", "");

        IsmFormBuilder builder = new IsmFormBuilder(layout);

        return builder.getPanel();

    }

    private JComponent buildChercherMariagePanel() {


        /**
         * preparing the panelBuilder
         */

        FormLayout layout = new FormLayout("right:pref, $lcgap, left:pref");

        IsmFormBuilder builder = new IsmFormBuilder(layout);

        final JTextField numActMarField = BasicComponentFactory.createIntegerField(adapter.getModel("numact_mar"), 0);

        /**
         * preparing the datePicker
         */

        JFormattedTextField textField = BasicComponentFactory.createDateField(adapter.getModel("date_mar"));

        final UtilDateModel dateModel = new UtilDateModel();
        dateModel.setDate(2000, 01, 01);
        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, new Properties());
        //JDatePanelImpl datePanel = new JDatePanelImpl(adapter.getModel("date_mar"), new Properties());
        //JDateComponentFactory fact = new JDateComponentFactory();

        datePicker = new JDatePickerImpl(datePanel, new IsmDateFormatter());
        datePicker.setShowYearButtons(true);
        datePicker.setButtonFocusable(true);
        datePicker.setTextEditable(true);
        //datePicker.getJFormattedTextField().setFocusLostBehavior(JFormattedTextField.COMMIT_OR_REVERT);


        org.jdatepicker.impl.UtilDateModel dateModel1 = new UtilDateModel();

        //datePicker = BasicComponentFactory.createDateField(new JDatePickerImpl(datePanel, new DateLabelFormatter()));


        JButton buttonChercher = new JButton(new ValidationAction());


        final JComboBox myCommunesComboBox = pan.getComboBoxCommunes();

        /*
        JLabel label = BasicComponentFactory.createLabel(new ValueHolder());
        label.setText(" ");
        builder.append("", label);
        //*/
        //builder.rowGroupingEnabled(true);
        builder.appendGlueRow();
        builder.appendRow(RowSpec.decode("top:31dlu")); // Assumes line is 14, gap is 3
        builder.nextLine(2);
        builder.append("N° act mariage : ", numActMarField);
        //append("N° act mariage : ",new JTextField());
        builder.append("Date : ", datePicker);

        //builder.appendSeparator("Lieu : ");


        builder.append("Wilaya : ", pan.getComboBoxWilayas());
        builder.append("Commune : ", myCommunesComboBox);
        /* todo delete this
        builder.append(pan.ismTextField, buttonChercher);
        builder.append(pan.ismTextField2);
        builder.append(pan.labelCommune1, pan.labelCommune2);
        //*/

        builder.append("", buttonChercher);
        builder.appendRow(RowSpec.decode("fill:31dlu")); // Assumes line is 14, gap is 3
        builder.append("", messageLabel);

        builder.rowGroupingEnabled(false);
        builder.appendGlueRow();
        builder.appendRow(RowSpec.decode("top:31dlu")); // Assumes line is 14, gap is 3
        builder.nextLine(2);

        int bestWidth = pan.getComboBoxCommunes().getPreferredSize().width*13/10;
        int bestHeight = pan.getComboBoxCommunes().getPreferredSize().height;


        //********** setting the width size
        pan.getComboBoxCommunes().setPreferredSize(new Dimension(bestWidth, bestHeight));
        pan.getComboBoxWilayas().setPreferredSize(new Dimension(bestWidth, bestHeight));

        if (bestHeight < pan.getComboBoxCommunes().getPreferredSize().height) {
            bestHeight = pan.getComboBoxCommunes().getPreferredSize().height;
        }


        numActMarField.setPreferredSize(new Dimension(bestWidth, bestHeight));
        datePicker.getJFormattedTextField().setPreferredSize(new Dimension(bestWidth, bestHeight));

        //datePicker.getJFormattedTextField().setPreferredSize(new Dimension(bestWidth, bestHeight));
        //datePicker.getJDateInstantPanel().ge

        datePicker.getJFormattedTextField().setFont(MyApp.theme.font);
        datePicker.setPreferredSize(datePicker.getJFormattedTextField().getPreferredSize());

        // to add some space to width of panel for the validation message
        int ww = builder.getPanel().getPreferredSize().width;
        int hh = builder.getPanel().getPreferredSize().height;


        //int widthMessVal = messageLabel.getPreferredSize().width;
        //JFormattedTextField forrr = new JFormattedTextField();


        builder.getPanel().setPreferredSize(new Dimension(ww + ww / 2, hh));

        return builder.getPanel();

    }


    private void initComponents() {


    }

    private class HandlerClass implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }
    }


    private class ValidationAction extends AbstractAction {

        public ValidationAction() {

            super("Chercher");
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
            int lieu = (Integer) pan.getCode_com_model().getValue();

            //preModel.getBean().setDate_mar(dateMar);
            //preModel.getBean().setLieu_mar(lieu);

            //preModel.triggerCommit();

            MariageValidator validator = new MariageValidator(adapter);

            ValidationResult result = validator.validate(adapter.getBean());
            validationResultModel.setResult(result);
            if (!result.hasErrors()) {

                //FicheFam ficheFam = new FicheFam(adapter.getBean().getNumact_mar(), dateMar, lieu);
                FicheFam ficheFam = FicheFamTest.getTestingFiche();
                if (ficheFam.getSelectedFamily() != null) {

                    JFrame ficheFrame = new FicheFamJFrame(ficheFam);
                    ficheFrame.setVisible(true);


                    // todo this line is good when reporting
                    //ReportFichFam.report(ficheFam);
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