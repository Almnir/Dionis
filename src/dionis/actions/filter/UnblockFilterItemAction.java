package dionis.actions.filter;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;

import dionis.beans.FiltersBean;
import dionis.beans.IFilterItem;
import dionis.models.FiltersModel;
import dionis.views.DionisView;
import dionis.xml.BooleanType;

/**
 * Класс действия разблокировки правила
 * 
 * @author Ярных А.О.
 *
 */
public class UnblockFilterItemAction extends Action {

	private TreeViewer viewer;
	private IStructuredSelection selection;

	public UnblockFilterItemAction(TreeViewer viewer,
			IStructuredSelection selection) {
		this.viewer = viewer;
		this.selection = selection;
		super.setText("Разблокировать элемент");
	}

	@Override
	public void run() {
		// приводим к обобщённому правилу
		IFilterItem item = (IFilterItem) selection.getFirstElement();
		// снимаем признак блокировки
		item.setBlock(BooleanType.NO);
		// извлекаем родительский фильтр правила
		final FiltersBean fsb = item.getParent();
		// индекс правила в фильтре
		int ruleIndex = fsb.getFilter().getItem().indexOf(item);
		// данные модели
		java.util.List<FiltersBean> filtersList = FiltersModel.getInstance()
				.getData();
		// индекс текущего бина фильтра
		int filterIndex = filtersList.indexOf(fsb);
		// замещение правила в бине по сохранённому индексу
		fsb.getFilter().getItem().set(ruleIndex, item);
		// замещение бина в модели по сохранённому индексу
		FiltersModel.getInstance().getData().set(filterIndex, fsb);
		// обновление отображения дерева и подгонка столбцов
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				// обновить элементы выбранного фильтра
				viewer.refresh(fsb);
				viewer.getTree().getColumn(DionisView.TREE_COLUMN_DATA).pack();
			}
		});
	};
}
