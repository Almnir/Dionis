package dionis.actions.filter;

import java.util.LinkedList;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

import dionis.beans.FilterBean;
import dionis.beans.FiltersBean;
import dionis.beans.IFilterItem;
import dionis.dialogs.FilterRuleDialog;
import dionis.models.FiltersModel;
import dionis.utils.Constants;
import dionis.views.DionisView;

/**
 * Класс действия добавления нового расширенного правила
 * 
 * @author Ярных А.О.
 *
 */
public class AddExtendedItemAction extends Action {

	private TreeViewer viewer;
	private IStructuredSelection selection;
	private FiltersBean fsb;

	public AddExtendedItemAction(TreeViewer viewer,
			IStructuredSelection selection) {
		this.viewer = viewer;
		this.selection = selection;
		super.setText("Добавить расширенное правило");
	}

	@Override
	public void run() {
		fsb = null;
		// текущий выбор
		if (selection.getFirstElement() instanceof IFilterItem) {
			IFilterItem item = (IFilterItem) selection.getFirstElement();
			fsb = item.getParent();

		} else if (selection.getFirstElement() instanceof FiltersBean) {
			fsb = (FiltersBean) selection.getFirstElement();
		}
		// диалог расширенного правила
		FilterRuleDialog dialog = new FilterRuleDialog(viewer.getControl()
				.getShell(), null, Constants.DLG_EXTENDED);
		if (dialog.open() == Window.OK) {
			// данные модели
			java.util.List<FiltersBean> filtersList = FiltersModel
					.getInstance().getData();
			// индекс текущего бина фильтра
			int index = filtersList.indexOf(fsb);
			// извлекаем бин правила из диалога
			IFilterItem rule = dialog.getData();
			// устанавливаем родительский бин фильтра
			rule.setParent(fsb);
			// если бин фильтра уже был инициализирован
			if (fsb.getFilter() != null && fsb.getFilter().getItem() != null) {
				// просто добавляем правило
				fsb.getFilter().getItem().add(rule);
			} else {
				// создаём новый бин фильтра
				FilterBean filterBean = new FilterBean();
				// устанавливаем имя текущего выбранного элемента
				filterBean.setName(fsb.getFilter().getName());
				// список правил фильтрации
				LinkedList<IFilterItem> lfi = new LinkedList<>();
				lfi.add(rule);
				filterBean.setItem(lfi);
				fsb.setFilter(filterBean);
			}
			// замещение бина в модели по сохранённому индексу
			FiltersModel.getInstance().getData().set(index, fsb);
			// обновление отображения дерева и подгонка столбцов
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					// обновить элементы выбранного фильтра
					viewer.refresh(fsb);
					viewer.setExpandedState(fsb, true);
					viewer.getTree().getColumn(DionisView.TREE_COLUMN_DATA)
							.pack();
					viewer.getTree().getColumn(DionisView.TREE_COLUMN_EXTENDED)
							.pack();
				}
			});
		}

	}
}