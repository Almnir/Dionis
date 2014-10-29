package dionis.actions.filters;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;

import dionis.beans.ExtendedFilterItemBean;
import dionis.beans.FiltersBean;
import dionis.beans.IFilterItem;
import dionis.beans.SheduleFilterItemBean;
import dionis.beans.StandardFilterItemBean;
import dionis.models.FiltersModel;

/**
 * 
 * 
 * @author Ярных А.О.
 *
 */
public class RemoveFilterItemAction extends Action {

	private TreeViewer viewer;
	private IStructuredSelection selection;

	public RemoveFilterItemAction(TreeViewer viewer,
			IStructuredSelection selection) {
		this.viewer = viewer;
		this.selection = selection;
		super.setText("Удалить");
	}

	@Override
	public void run() {
		IFilterItem item = null;
		// если выбрано стандартное правило
		if (selection.getFirstElement() instanceof StandardFilterItemBean) {
			item = (StandardFilterItemBean) selection.getFirstElement();
		}
		// если выбрано расширенное правило
		if (selection.getFirstElement() instanceof ExtendedFilterItemBean) {
			item = (ExtendedFilterItemBean) selection.getFirstElement();
		}
		// если выбрано правило расписания
		if (selection.getFirstElement() instanceof SheduleFilterItemBean) {
			item = (SheduleFilterItemBean) selection.getFirstElement();
		}
		// извлекаем родительский фильтр правила
		FiltersBean fsb = item.getParent();
		// данные модели
		java.util.List<FiltersBean> filtersList = FiltersModel.getInstance()
				.getData();
		// индекс текущего бина фильтра
		int filterIndex = filtersList.indexOf(fsb);
		// удаляем из фильтра
		fsb.getFilter().getItem().remove(item);
		// замещение бина в модели по сохранённому индексу
		FiltersModel.getInstance().getData().set(filterIndex, fsb);
		// обновляем дерево
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				viewer.setInput(FiltersModel.getInstance().getDataArray());
			}
		});
	}
}
