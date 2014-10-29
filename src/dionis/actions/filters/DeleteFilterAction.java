package dionis.actions.filters;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Display;

import dionis.beans.FiltersBean;
import dionis.models.FiltersModel;

/**
 * Класс действия удаления фильтра целиком
 * 
 * @author Ярных А.О.
 *
 */
public class DeleteFilterAction extends Action {

	private TreeViewer viewer;
	private IStructuredSelection selection;

	public DeleteFilterAction(TreeViewer viewer, IStructuredSelection selection) {
		this.viewer = viewer;
		this.selection = selection;
		super.setText("Удалить весь фильтр");
	}

	@Override
	public void run() {
		// берём текущий выбор и приводим к бину фильтра
		final FiltersBean fsb = (FiltersBean) selection.getFirstElement();
		// открываем диалог подтверждения операции удаления
		boolean dialog = MessageDialog.openConfirm(viewer.getControl()
				.getShell(), "Подтверждение", "Удалить фильтр "
				+ fsb.getFilter().getName() + " ?");
		// если подтверждено
		if (dialog == true) {
			// удаляем из модели дерева текущий выбранный фильтра
			FiltersModel.getInstance().getData().remove(fsb);
			// обновляем дерево
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					viewer.setInput(FiltersModel.getInstance().getDataArray());
				}
			});
		}
	}
}
