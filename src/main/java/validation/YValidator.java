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
public class YValidator implements Validator {
    @Override
    public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        double yVal = (double) value;

        if (yVal > 5 || yVal < -3) {
            throw new ValidatorException(new FacesMessage("Y не попадает в ОДЗ!"));
        }
    }
}
