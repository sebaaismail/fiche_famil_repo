package com.sebaainf.fichfamil.view;

import javax.swing.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by admin on 04/02/2015.
 */
public class MyDateFormatter extends JFormattedTextField.AbstractFormatter {

    private String datePattern = "dd/MM/yyyy";
    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);


    @Override
    public Object stringToValue(String text) throws ParseException {

        text = text.replace("-", "/");
        text = text.replace(".", "/");
        text = text.replace(" ", "/");

        Date date = new Date(dateFormatter.parse(text).getTime());
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal;
    }

    @Override
    public String valueToString(Object value) throws ParseException {

        if (value != null) {

            Calendar cal = (Calendar) value;
            return dateFormatter.format(cal.getTime());

        }

        return "";
    }
}
