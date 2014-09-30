package dionis.utils;

import org.eclipse.core.databinding.conversion.Converter;

import dionis.xml.BooleanType;

/**
 * Класс конверсии значений из типа boolean в тип BooleanType
 * 
 * @author Ярных А.О.
 *
 */
public class BooleanType2BooleanConverter extends Converter {

	public BooleanType2BooleanConverter() {
		this(BooleanType.class, boolean.class);
	}

	public BooleanType2BooleanConverter(Object fromType, Object toType) {
		super(fromType, toType);
	}

	@Override
	public Object convert(Object fromObject) {
		if ((BooleanType) fromObject == BooleanType.YES)
			return true;
		else
			return false;
	}

}