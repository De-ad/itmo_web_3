package web3.web3.util;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("XValidator")
public class ValidatorForY implements Validator<Object> {
    private Double yValue;

    public Double getyValue() {
        return yValue;
    }

    public void setyValue(Double yValue) {
        this.yValue = yValue;
    }


    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        double MIN = -5;
        double MAX = 3;
        try {
            Double value = (Double) o;
            if (value > MAX || value < MIN) {
                FacesMessage msg = new FacesMessage("Y should be between -5 and 3");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
        catch (NumberFormatException e){
            FacesMessage msg = new FacesMessage("Y should be number");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}

