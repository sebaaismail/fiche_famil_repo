package com.sebaainf.fichfamil.view;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.adapter.BasicComponentFactory;
import com.jgoodies.binding.adapter.Bindings;
import com.jgoodies.binding.beans.PropertyConnector;
import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.binding.value.ValueModel;
import com.jgoodies.common.format.EmptyDateFormat;
import com.sebaainf.fichfamil.citoyen.Citoyen;
import com.sebaainf.fichfamil.presentation.CitoyenEditorModel;
import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import javax.swing.*;
import javax.swing.text.DateFormatter;
import javax.swing.text.DefaultFormatterFactory;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.lang.reflect.Method;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Properties;

/**
 * Created by ${sebaainf.com} on 14/03/2015.
 */
public class MyComonentFactory extends BasicComponentFactory {
    //public static String nameofClasse;

    public static JDatePickerImpl createDatePickerImpl(final PresentationModel model) {

        //MyComonentFactory.nameofClasse = nameofClasse;
        // preparing date_naiss --- > JDatePicker

        final UtilDateModel dateModel = new UtilDateModel();
        dateModel.setDate(2000, 01, 01);

        JDatePanelImpl datePanel = new JDatePanelImpl(dateModel, new Properties());
        //JDatePanelImpl datePanel = new JDatePanelImpl(adapter.getModel("date_mar"), new Properties());
        //JDateComponentFactory fact = new JDateComponentFactory();

        MyDateFormatter formatter = new MyDateFormatter();

        final JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, formatter);

        datePicker.setShowYearButtons(true);
        datePicker.setButtonFocusable(true);
        datePicker.setTextEditable(true);
        datePicker.getJFormattedTextField().setHorizontalAlignment(JTextField.RIGHT);

        //initialize datePicker

        Date date = ((Citoyen)model.getBean()).getDate_naiss();
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        datePicker.getModel().setDate(calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH));
        datePicker.getJDateInstantPanel().getModel().setSelected(true);

        try {
            datePicker.getJFormattedTextField().setText(formatter.valueToString(calendar));
        } catch (ParseException e) {
            e.printStackTrace();
        }


         //Bindings.bind(datePicker.getJFormattedTextField(), valueModel);

       datePicker.getModel().addPropertyChangeListener(new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {
                JOptionPane.showMessageDialog(null,evt.getPropertyName() + " --> : "
                        + evt.getNewValue());
                ((Citoyen)model.getBean()).setDate_naiss(new Date(((java.util.Date) datePicker.getModel().getValue()).getTime()));
            }
        });
        //********

/*

        DateFormat shortFormat = DateFormat.getDateInstance(3);
        shortFormat.setLenient(false);
        DateFormatter defaultFormatter = new DateFormatter(new EmptyDateFormat(shortFormat));
        DateFormatter displayFormatter = new DateFormatter(new EmptyDateFormat(DateFormat.getDateInstance()));
        DefaultFormatterFactory formatterFactory = new DefaultFormatterFactory(defaultFormatter, displayFormatter);
        return createFormattedTextField(valueModel, (JFormattedTextField.AbstractFormatterFactory)formatterFactory);
*/


        return datePicker;
    }

   /* public void parseSetDate() throws Exception {
        Class<?> cls = Class.forName(MyComonentFactory.nameofClasse);
        Method[] methods = cls.getMethods();

        for (Method method : methods) {
            if (method.getReturnType().getName().equals("java.sql.Date")
                    && (method.getName().contains("setDate"))) {
                method.invoke(cls.newInstance(), "Test");
                break;
            }
        }

    }

    public Date parseGetDate() throws Exception {
        Class<?> cls = Class.forName(MyComonentFactory.nameofClasse);
        Method[] methods = cls.getMethods();

        for (Method method : methods) {
            if (method.getReturnType().getName().equals("java.sql.Date")
                    && (method.getName().contains("getDate"))) {

                return (Date) method.invoke(cls.newInstance(), "Test");
            }
        }
        return null;

    }*/

}
