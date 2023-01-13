package web3.web3.util;


import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator("XValidator")
public class ValidatorForX implements Validator<Object> {
    private Double xValue;

    public Double getxValue() {
        return xValue;
    }

    public void setxValue(Double xValue) {
        this.xValue = xValue;
    }


    @Override
    public void validate(FacesContext facesContext, UIComponent uiComponent, Object o) throws ValidatorException {
        double MIN = -4;
        double MAX = 4;
        try {
            Double value = (Double) o;
            if (value > MAX || value < MIN) {
                FacesMessage msg = new FacesMessage("X should be between -4 and 4");
                msg.setSeverity(FacesMessage.SEVERITY_ERROR);
                throw new ValidatorException(msg);
            }
        }
        catch (NumberFormatException e){
            FacesMessage msg = new FacesMessage("X should be number");
            msg.setSeverity(FacesMessage.SEVERITY_ERROR);
            throw new ValidatorException(msg);
        }

    }
}
