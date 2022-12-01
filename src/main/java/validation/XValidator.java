package validation;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@ApplicationScoped
@ManagedBean
@FacesValidator
public class XValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        double xVal = (double) value;

        if (xVal > 5 || xVal < -5) {
            throw new ValidatorException(new FacesMessage("X не попадает в ОДЗ!"));
        }
    }
}
