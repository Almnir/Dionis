package dionis.actions.filter;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

import dionis.beans.ExtendedFilterItemBean;
import dionis.beans.FiltersBean;
import dionis.beans.SheduleFilterItemBean;
import dionis.beans.StandardFilterItemBean;
import dionis.dialogs.FilterRuleDialog;
import dionis.dialogs.SheduleRuleDialog;
import dionis.models.FiltersModel;
import dionis.utils.Constants;
import dionis.views.DionisView;

/**
 * Класс действия изменения правил
 * 
 * @author Ярных А.О.
 *
 */
public class ChangeFilterItemAction extends Action {

	private TreeViewer viewer;
	private IStructuredSelection selection;
	private FiltersBean fsb;

	public ChangeFilterItemAction(TreeViewer viewer,
			IStructuredSelection selection) {
		this.viewer = viewer;
		this.selection = selection;
		super.setText("Изменить");
	}

	@Override
	public void run() {
		// если выбрано стандартное правило
		if (selection.getFirstElement() instanceof StandardFilterItemBean) {
			StandardFilterItemBean item = (StandardFilterItemBean) selection
					.getFirstElement();
			// извлекаем родительский фильтр правила
			fsb = item.getParent();
			// индекс правила в фильтре
			int ruleIndex = fsb.getFilter().getItem().indexOf(item);
			// данные модели
			java.util.List<FiltersBean> filtersList = FiltersModel
					.getInstance().getData();
			// индекс текущего бина фильтра
			int filterIndex = filtersList.indexOf(fsb);
			// диалог стандартного правила
			FilterRuleDialog dialog = new FilterRuleDialog(viewer.getControl()
					.getShell(), item, Constants.DLG_STANDARD);
			if (dialog.open() == Window.OK) {
				// замещение правила в бине по сохранённому индексу
				fsb.getFilter().getItem().set(ruleIndex, dialog.getData());
				// замещение бина в модели по сохранённому индексу
				FiltersModel.getInstance().getData().set(filterIndex, fsb);
			}
		}

		// если выбрано расширенное правило
		if (selection.getFirstElement() instanceof ExtendedFilterItemBean) {
			ExtendedFilterItemBean item = (ExtendedFilterItemBean) selection
					.getFirstElement();
			// извлекаем родительский фильтр правила
			fsb = item.getParent();
			// индекс правила в фильтре
			int ruleIndex = fsb.getFilter().getItem().indexOf(item);
			// данные модели
			java.util.List<FiltersBean> filtersList = FiltersModel
					.getInstance().getData();
			// индекс текущего бина фильтра
			int filterIndex = filtersList.indexOf(fsb);
			// диалог стандартного правила
			FilterRuleDialog dialog = new FilterRuleDialog(viewer.getControl()
					.getShell(), item, Constants.DLG_EXTENDED);
			if (dialog.open() == Window.OK) {
				// замещение правила в бине по сохранённому индексу
				fsb.getFilter().getItem().set(ruleIndex, dialog.getData());
				// замещение бина в модели по сохранённому индексу
				FiltersModel.getInstance().getData().set(filterIndex, fsb);
			}
		}
		// если выбрано правило расписания
		if (selection.getFirstElement() instanceof SheduleFilterItemBean) {
			SheduleFilterItemBean item = (SheduleFilterItemBean) selection
					.getFirstElement();
			// извлекаем родительский фильтр правила
			fsb = item.getParent();
			// индекс правила в фильтре
			int ruleIndex = fsb.getFilter().getItem().indexOf(item);
			// данные модели
			java.util.List<FiltersBean> filtersList = FiltersModel
					.getInstance().getData();
			// индекс текущего бина фильтра
			int filterIndex = filtersList.indexOf(fsb);
			// диалог стандартного правила
			SheduleRuleDialog dialog = new SheduleRuleDialog(viewer
					.getControl().getShell(), item);
			if (dialog.open() == Window.OK) {
				// замещение правила в бине по сохранённому индексу
				fsb.getFilter().getItem().set(ruleIndex, dialog.getData());
				// замещение бина в модели по сохранённому индексу
				FiltersModel.getInstance().getData().set(filterIndex, fsb);
			}
		}

		// обновление отображения дерева и подгонка столбцов
		Display.getDefault().asyncExec(new Runnable() {
			@Override
			public void run() {
				// обновить элементы выбранного фильтра
				viewer.refresh(fsb);
				viewer.getTree().getColumn(DionisView.TREE_COLUMN_DATA).pack();
				viewer.getTree().getColumn(DionisView.TREE_COLUMN_EXTENDED)
						.pack();
			}
		});

	}
}
