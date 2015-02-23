package com.sebaainf.fichfamil.presentation;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.Validator;
import com.sebaainf.fichfamil.common.Mariage;

/**
 * Created by ${sebaainf.com} on 22/02/2015.
 */
public class MariageValidator implements Validator<Mariage> {

    PresentationModel<Mariage> preModel;

    public MariageValidator(PresentationModel<Mariage> preModel) {

        this.preModel = preModel;

    }

    @Override
    public ValidationResult validate(Mariage mariage) {

        ValidationResult validationResult = new ValidationResult();

        //String date_mar = this.preModel.getModel("date_mar").getValue().toString();
        //String lieu_mar = this.preModel.getModel("lieu_mar").getValue().toString();

        if (this.preModel.getModel("numact_mar").intValue() == 0) {
            validationResult.addError("Entrer le numero d'act de mariage !");
        }
        //int numact_mar =this.preModel.getModel("numact_mar").intValue();

        return validationResult;
    }
}
