package dionis.actions.filters;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.InputDialog;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.jface.window.Window;

import dionis.beans.FilterBean;
import dionis.beans.FiltersBean;

/**
 * Класс действия создания шаблона фильтра
 * 
 * @author Ярных А.О.
 *
 */
public class MakeTemplateItemAction extends Action {

	private TreeViewer viewer;
	private IStructuredSelection selection;

	public MakeTemplateItemAction(TreeViewer viewer,
			IStructuredSelection selection) {
		this.viewer = viewer;
		this.selection = selection;
		super.setText("Создать шаблон фильтра");
	}

	@Override
	public void run() {
		// текущий выбор
		final FiltersBean fsb = (FiltersBean) selection.getFirstElement();
		FilterBean fbean = fsb.getFilter();
		// диалог ввода имени шаблона фильтра
		InputDialog dialog = new InputDialog(viewer.getControl().getShell(),
				"Создание шаблона фильтра",
				"Введите название шаблона фильтра: ",
				fsb.getFilter().getName(), null);
		if (dialog.open() == Window.OK) {
			// формирование имени файла как: "название_шаблона.flt"
			String fileName = fsb.getFilter().getName() + ".flt";
			try (OutputStream file = new FileOutputStream(fileName);
					OutputStream buffer = new BufferedOutputStream(file);
					ObjectOutput output = new ObjectOutputStream(buffer);) {
				// запись сериализованного шаблона в поток
				output.writeObject(fbean);
				output.flush();
			} catch (IOException ex) {
				MessageDialog.openError(viewer.getControl().getShell(),
						"Ошибка", "Ошибка записи шаблона в файл " + fileName);
				System.err
						.println("Ошибка записи шаблона в файл/Error writing template to file\n "
								+ ex.getMessage());
			}
		}
	}
}
