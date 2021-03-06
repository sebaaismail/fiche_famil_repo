package com.sebaainf.fichfamil.common;

import com.jgoodies.validation.ValidationMessage;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.Validator;
import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * Class contain common functions
 * Created by admin on 04/02/2015.
 */
public class MyCommonUtils {


    public static void setListComponentsEnabled(ArrayList<JComponent> listComponents, boolean b) {

        for (JComponent comp : listComponents) {

            if (comp.getClass().getSimpleName().equals("JTextField"))
                ((JTextField) comp).setEditable(b);
            else if(comp.getClass().getSimpleName().equals("JCheckBox"))
                ((JCheckBox) comp).setEnabled(b);
            else if(comp.getClass().getSimpleName().equals("JComboBox"))
                ((JComboBox) comp).setEnabled(b);
            else if(comp.getClass().getSimpleName().equals("JRadioButton"))
                ((JRadioButton) comp).setEnabled(b);
            else if(comp.getClass().getSimpleName().equals("JDatePickerImpl")) {
                ((JDatePickerImpl) comp).setTextEditable(b);
                // set the button disabled
                ((JDatePickerImpl) comp).getComponent(1).setEnabled(b);
            }

        }



    }

    public ActionListener actionDeces = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {


        }
    };

}

