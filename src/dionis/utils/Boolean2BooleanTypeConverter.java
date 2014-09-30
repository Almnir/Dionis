package dionis.utils;

import org.eclipse.core.databinding.conversion.Converter;

import dionis.xml.BooleanType;

/**
 * Класс конверсии значений из типа boolean в тип BooleanType
 * 
 * @author Ярных А.О.
 *
 */
public class Boolean2BooleanTypeConverter extends Converter {

	public Boolean2BooleanTypeConverter() {
		this(boolean.class, BooleanType.class);
	}

	public Boolean2BooleanTypeConverter(Object fromType, Object toType) {
		super(fromType, toType);
	}

	@Override
	public Object convert(Object fromObject) {
		if ((boolean) fromObject == true)
			return BooleanType.YES;
		else
			return BooleanType.NO;
	}

}