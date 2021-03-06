package com.sebaainf.fichfamil.presentation;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.Validator;
import com.sebaainf.fichfamil.common.IsmValidator;
import com.sebaainf.fichfamil.common.Mariage;

/**
 * Created by ${sebaainf.com} on 22/02/2015.
 */
public class MariageValidator extends IsmValidator implements Validator<Object> {


    public MariageValidator(PresentationModel preModel) {

        this.preModel = preModel;

    }

    @Override
    public ValidationResult validate(Object mariage) {


        //String date_mar = this.preModel.getModel("date_mar").getValue().toString();
        //String lieu_mar = this.preModel.getModel("lieu_mar").getValue().toString();

        addBlankError(Mariage.PROPERTY_NUMACT_MAR, "N Act mariage");
        addBlankError(Mariage.PROPERTY_DATE_MAR, "date mariage");
        /*if (this.preModel.getModel(Mariage.PROPERTY_NUMACT_MAR).intValue() == 0) {
            validationResult.addError("Veuillez Entrer le numero d'act de mariage SVP!");
        }*/
        //int numact_mar =this.preModel.getModel("numact_mar").intValue();

        return validationResult;
    }
}
