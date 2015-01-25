package dionis.utils;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.WidgetProperties;
import org.eclipse.swt.widgets.Button;

/**
 * Хелпер класс для датабиндинга
 * 
 * @author Ярных А.О.
 *
 */
public class BindHelper {

	/**
	 * Метод для биндинга чекбокса
	 * 
	 * @param ctx
	 *            , DataBindingContext, контекст биндинга
	 * @param button
	 *            Button , Объект чекбокса
	 * @param modelValue
	 *            IObservableValue , Модель для чекбокса
	 */
	public static void bindCheckButton(DataBindingContext ctx, Button button,
			IObservableValue modelValue) {
		// стратегия для конверсии boolean -> BooleanType
		UpdateValueStrategy updateValueStrategy = new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_CONVERT);
		updateValueStrategy.setConverter(new Boolean2BooleanTypeConverter());
		// стратегия для обратной конверсии BooleanType -> boolean
		UpdateValueStrategy updateFromValueStrategy = new UpdateValueStrategy(
				UpdateValueStrategy.POLICY_ON_REQUEST)
				.setConverter(new BooleanType2BooleanConverter());
		IObservableValue widgetValue = WidgetProperties.selection().observe(
				button);
		ctx.bindValue(widgetValue, modelValue, updateValueStrategy,
				updateFromValueStrategy);
	}

}
