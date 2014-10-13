package dionis.providers;

import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.viewers.StyledCellLabelProvider;
import org.eclipse.jface.viewers.ViewerCell;
import org.eclipse.swt.graphics.Image;
import org.osgi.framework.Bundle;
import org.osgi.framework.FrameworkUtil;

import dionis.beans.ExtendedFilterItemBean;
import dionis.beans.FilterBean;
import dionis.beans.FilterItemBean;
import dionis.beans.FiltersBean;
import dionis.beans.IFilterItem;
import dionis.beans.SheduleFilterItemBean;
import dionis.beans.StandardFilterItemBean;
import dionis.models.FiltersModel;
import dionis.utils.ImageConstants;
import dionis.views.DionisView;

import org.eclipse.core.runtime.Path;

/**
 * Класс-провайдер отображения строк табличного дерева
 * 
 * @author Ярных А.О.
 *
 */
public class FiltersTreeLabelProvider extends StyledCellLabelProvider {
	@Override
	public void update(ViewerCell cell) {
		Object object = cell.getElement();
		if (object instanceof String) {
			if (cell.getColumnIndex() == 0) {
				cell.setText(object.toString());
			}
		} else if (object instanceof FiltersBean) {
			updateFiltersBean(cell, (FiltersBean) object);
		} else if (object instanceof StandardFilterItemBean) {
			updateStandardFilterItemBean(cell, (StandardFilterItemBean) object);
		} else if (object instanceof ExtendedFilterItemBean) {
			updateExtendedFilterItemBean(cell, (ExtendedFilterItemBean) object);
		} else if (object instanceof SheduleFilterItemBean) {
			updateSheduleFilterItemBean(cell, (SheduleFilterItemBean) object);
		}
	}

	public void updateFiltersBean(ViewerCell cell, FiltersBean filter) {
		// Имя
		if (cell.getColumnIndex() == 0) {
			cell.setText(filter.getFilter().getName());
			cell.setImage(getImage(ImageConstants.ICON_FILTER));
		}
		// Количество правил в фильтре
		if (cell.getColumnIndex() == 1) {
			// сколько правил
			cell.setText(String.valueOf(filter.getFilter().getItem().size()));
		}
	}

	private void updateStandardFilterItemBean(ViewerCell cell, StandardFilterItemBean item) {
		// № п/п
		if (cell.getColumnIndex() == 1) {
			int itemIndex = findItemIndex(item);
			cell.setText(String.valueOf(itemIndex));
		}
		// Значение
		if (cell.getColumnIndex() == 2) {
			cell.setImage(getImage(ImageConstants.ICON_ITEM));
			cell.setText(item.toString());
		}
	}
	private void updateExtendedFilterItemBean(ViewerCell cell, ExtendedFilterItemBean item) {
		// № п/п
		if (cell.getColumnIndex() == 1) {
			int itemIndex = findItemIndex(item);
			cell.setText(String.valueOf(itemIndex));
		}
		// Значение
		if (cell.getColumnIndex() == 2) {
			cell.setImage(getImage(ImageConstants.ICON_ITEM));
			cell.setText(item.toString());
		}
		// Расширенное значение
		if (cell.getColumnIndex() == 3) {
			cell.setText(item.getExtendedDataField());
		}
	}
	// TODO: рефакторить повторяющийся код
	private void updateSheduleFilterItemBean(ViewerCell cell, SheduleFilterItemBean item) {
		// № п/п
		if (cell.getColumnIndex() == 1) {
			int itemIndex = findItemIndex(item);
			cell.setText(String.valueOf(itemIndex));
		}
		// Значение
		if (cell.getColumnIndex() == 2) {
			cell.setImage(getImage(ImageConstants.ICON_SHEDULE));
			cell.setText(item.toString());
		}
	}
	
	/**
	 * Метод поиска индекса элемента фильтра в модели
	 * 
	 * @param item
	 * @return
	 */
	private int findItemIndex(IFilterItem item) {
		int index = 0;
		List<FiltersBean> data = FiltersModel.getInstance().getData();
		boolean exitFlag = false;
		Iterator<FiltersBean> it = data.iterator();
		while (it.hasNext() && exitFlag == false) {
			FiltersBean fsb = it.next();
			FilterBean fb = fsb.getFilter();
			List<? extends FilterItemBean> fib = fb.getItem();
			// TODO: корявый код, нужно переписать
			for (Object fitem : fib) {
				if (fitem.equals(item)) {
					exitFlag = true;
					break;
				}
				index++;
			}
		}
		return index;
	}

	/**
	 * Метод, возвращающий объект изображения по заданному параметру строки пути к изображению
	 * 
	 * @param img
	 * @return
	 */
	private static Image getImage(String img) {
		Bundle bundle = FrameworkUtil.getBundle(DionisView.class);
		URL url = FileLocator.find(bundle, new Path(img), null);
		ImageDescriptor image = ImageDescriptor.createFromURL(url);
		return image.createImage();
	}
}
