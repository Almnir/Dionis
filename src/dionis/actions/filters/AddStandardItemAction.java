package dionis.actions.filters;

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
 * Класс действия добавления нового стандартного правила
 * 
 * @author Ярных А.О.
 *
 */
public class AddStandardItemAction extends Action {

	private TreeViewer viewer;
	private IStructuredSelection selection;
	private FiltersBean fsb;

	public AddStandardItemAction(TreeViewer viewer,
			IStructuredSelection selection) {
		this.viewer = viewer;
		this.selection = selection;
		super.setText("Добавить правило");
	}

	@Override
	public void run() {
		// текущий выбор
		if (selection.getFirstElement() instanceof IFilterItem) {
			IFilterItem item = (IFilterItem) selection.getFirstElement();
			fsb = item.getParent();

		} else if (selection.getFirstElement() instanceof FiltersBean) {
			fsb = (FiltersBean) selection.getFirstElement();
		}
		// диалог стандартного правила
		FilterRuleDialog dialog = new FilterRuleDialog(viewer.getControl()
				.getShell(), null, Constants.DLG_STANDARD);
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
			// обновление отображения дерева и подгонка столбца
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					// обновить элементы выбранного фильтра
					viewer.refresh(fsb);
					viewer.setExpandedState(fsb, true);
					viewer.getTree().getColumn(DionisView.TREE_COLUMN_DATA)
							.pack();
				}
			});
		}

	}
}
