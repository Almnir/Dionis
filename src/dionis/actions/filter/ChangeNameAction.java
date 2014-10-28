package dionis.actions.filter;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.widgets.Display;

import dionis.beans.FilterBean;
import dionis.beans.FiltersBean;
import dionis.models.FiltersModel;
import dionis.views.DionisView;

/**
 * Класс действия изменения названия фильтра
 * 
 * @author Ярных А.О.
 *
 */
public class ChangeNameAction extends Action {

	private TreeViewer viewer;
	private IStructuredSelection selection;

	public ChangeNameAction(TreeViewer viewer, IStructuredSelection selection) {
		this.viewer = viewer;
		this.selection = selection;
		super.setText("Изменить имя фильтра");
	}

	@Override
	public void run() {
		// текущий выбор
		final FiltersBean fsb = (FiltersBean) selection.getFirstElement();
		// индекс бина фильтра в модели
		int index = FiltersModel.getInstance().getData().indexOf(fsb);
		// диалог ввода имени фильтра
		InputDialog dialog = new InputDialog(viewer.getControl().getShell(),
				"Ввод имени", "Новое название фильтра: ", fsb.getFilter()
						.getName(), null);
		if (dialog.open() == Window.OK) {
			// добавление названия фильтра в бин
			if (fsb.getFilter() == null) {
				FilterBean fbean = new FilterBean();
				fbean.setName(dialog.getValue());
			} else {
				fsb.getFilter().setName(dialog.getValue());
			}
			// замещение бина в модели по сохранённому индексу
			FiltersModel.getInstance().getData().set(index, fsb);
			// обновление отображения дерева и подгонка столбца
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					viewer.refresh(fsb);
					viewer.getTree().getColumn(DionisView.TREE_COLUMN_NAME)
							.pack();
				}
			});
		}
	}
}
