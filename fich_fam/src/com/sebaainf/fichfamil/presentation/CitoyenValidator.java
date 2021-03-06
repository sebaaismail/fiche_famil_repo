package com.sebaainf.fichfamil.presentation;

import com.jgoodies.binding.PresentationModel;
import com.jgoodies.validation.ValidationResult;
import com.jgoodies.validation.Validator;
import com.sebaainf.fichfamil.citoyen.Citoyen;
import com.sebaainf.fichfamil.common.IsmValidator;


/**
 * Created by ${sebaainf.com} on 04/04/2015.
 * https://bitbucket.org/sebaa_ismail
 * https://github.com/sebaaismail
 */
public class CitoyenValidator extends IsmValidator implements Validator<Object> {



    public CitoyenValidator(PresentationModel preModel) {

        this.preModel = preModel;

    }

    @Override
    public ValidationResult validate(Object citoyen) {

        //TODO complete the validations
        System.out.println("validating...");
        addBlankError(Citoyen.PROPERTY_NOM_AR, "اللقب");
        addBlankError(Citoyen.PROPERTY_PRENOM_AR, "الإسم");
        addBlankError(Citoyen.PROPERTY_NOM_FR, "Nom_FR");
        addBlankError(Citoyen.PROPERTY_PRENOM_FR, "Prenom_FR");
        /*
        if (this.preModel.getModel("nom_ar").getValue().equals("")) {
            validationResult.addError("من فضلك ، قم بإدخال بيانات اللقب");
            System.out.println("erreur 1 !!!!!!!");
        }
*/
        return validationResult;
    }
}
