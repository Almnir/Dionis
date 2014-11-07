package dionis.validators;

import org.eclipse.core.databinding.validation.IValidator;
import org.eclipse.core.databinding.validation.ValidationStatus;
import org.eclipse.core.runtime.IStatus;

/**
 * Валидатор IP адреса
 * 
 * @author Ярных А.О.
 *
 */
public class IPAddressValidator implements IValidator {

	/** Паттерн для валидации IP адреса **/
	String IPADDRESS_PATTERN = "^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\."
			+ "([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

	@Override
	public IStatus validate(Object value) {
		if (value instanceof String) {
			String s = String.valueOf(value);
			if (s.matches(IPADDRESS_PATTERN)) {
				return ValidationStatus.ok();
			}
		}
		return ValidationStatus.error("Не является корректным IP адресом");
	}

}
