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
public class RValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        double rVal = (double) value;

        if (rVal > 5 || rVal < 1) {
            throw new ValidatorException(new FacesMessage("R не попадает в ОДЗ!"));
        }
    }
}
