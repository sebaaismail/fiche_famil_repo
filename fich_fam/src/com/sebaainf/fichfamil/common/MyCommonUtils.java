package com.sebaainf.fichfamil.common;

import org.jdatepicker.impl.JDatePickerImpl;

import javax.swing.*;
import java.util.ArrayList;

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
}

