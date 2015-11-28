package com.sebaainf.fichfamil.common;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.binding.value.AbstractValueModel;
import com.jgoodies.binding.value.ValueHolder;
import com.jgoodies.common.bean.Bean;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.Validator;
import com.sebaainf.fichfamil.citoyen.Citoyen;
import com.sebaainf.fichfamil.citoyen.IPerson;

/**
 * Created by ${sebaainf.com} on 04/04/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public abstract class IsmValidator implements Validator<Object> {

    protected ValidationResult validationResult = new ValidationResult();
    protected PresentationModel preModel;

    /**
     * method to add blank error , property can be String or int
     * @param propertyName
     * @param propertyText text shown in the error message
     */
    protected void addBlankError(String propertyName, String propertyText){

        String blankErrorMessage = " قم بملاء خانة";
        boolean flag = false;
        AbstractValueModel value = this.preModel.getModel(propertyName);
        if (value == null) value = new ValueHolder();

        Object val = value.getValue();
        if (val != null) {
            if(val.getClass().getSimpleName().equals("String")) {
                if (value.getValue().equals("")) flag = true;

            } else if(value.intValue() == 0) {
                flag = true;
            }
        }


        if (flag){
            validationResult.addError(blankErrorMessage + " " + propertyText);
        }

    }

    @Override
    public abstract ValidationResult validate(Object o);

}
