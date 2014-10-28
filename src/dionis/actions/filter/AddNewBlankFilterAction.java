package dionis.actions.filter;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

import dionis.beans.FilterBean;
import dionis.beans.FiltersBean;
import dionis.dialogs.FilterDialog;
import dionis.models.FiltersModel;
import dionis.views.DionisView;

/**
 * Класс-делегат действия меню выбора добавления нового пустого фильтра
 * 
 * @author Ярных А.О.
 *
 */
public class AddNewBlankFilterAction extends Action {

	private TreeViewer viewer;
	private FiltersBean fsbean;

	public AddNewBlankFilterAction(TreeViewer viewer) {
		this.viewer = viewer;
		super.setText("Добавить новый пустой фильтр");
	}

	@Override
	public void run() {
		setText("Добавить новый пустой фильтр");
		FilterDialog dialog = new FilterDialog(viewer.getControl().getShell());
		if (dialog.open() == Window.OK) {
			// создаём новый бин фильтра и добавляем в модель
			FilterBean filterBean = new FilterBean();
			filterBean.setName(dialog.getName());
			fsbean = new FiltersBean();
			fsbean.setFilter(filterBean);
			FiltersModel.getInstance().getData().add(fsbean);
			// обновляем структуру дерева новыми данными
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					// обновить элементы выбранного фильтра
					viewer.setInput(FiltersModel.getInstance().getDataArray());
					viewer.getTree().getColumn(DionisView.TREE_COLUMN_NAME)
							.pack();
				}
			});
		}

	}
}
