package dionis.actions.filters;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;

import org.eclipse.jface.action.Action;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.FileDialog;

import dionis.beans.FilterBean;
import dionis.beans.FiltersBean;
import dionis.models.FiltersModel;
import dionis.views.DionisView;

/**
 * Класс действия добавляющий фильтр по шаблону
 * 
 * @author Ярных А.О.
 *
 */
public class AddTemplateItemAction extends Action {

	private TreeViewer viewer;

	private FiltersBean fsb;

	// список фильтрации расширений для диалога файлов
	private static final String[] FILTER_EXTS = { "*.flt", "*.*" };

	public AddTemplateItemAction(TreeViewer viewer) {
		this.viewer = viewer;
		super.setText("Добавить фильтр по шаблону");
	}

	@Override
	public void run() {
		// файловый диалог для выбора шаблона фильтра
		FileDialog dialog = new FileDialog(viewer.getControl().getShell(),
				SWT.OPEN);
		dialog.setFilterExtensions(FILTER_EXTS);
		// показать диалог
		String fn = dialog.open();
		// если файл был выбран
		if (fn != null) {
			// открываем потоки чтения
			try (InputStream file = new FileInputStream(fn);
					InputStream buffer = new BufferedInputStream(file);
					ObjectInput input = new ObjectInputStream(buffer);) {
				// читаем новый объект фильтра
				FilterBean fbean = new FilterBean();
				fbean = (FilterBean) input.readObject();
				// создаём родительский класс
				fsb = new FiltersBean();
				fsb.setFilter(fbean);
				// добавляем в модель фильтров
				FiltersModel.getInstance().addData(fsb);

			} catch (ClassNotFoundException ex) {
				MessageDialog.openError(viewer.getControl().getShell(),
						"Ошибка", "Файл шаблона не найден!");
				System.err
						.println("Файл шаблона не найден/Template file not found!\n "
								+ ex.getMessage());
			} catch (IOException ex) {
				MessageDialog.openError(viewer.getControl().getShell(),
						"Ошибка", "Ошибка чтения файла шаблона!");
				System.err
						.println("Ошибка чтения файла шаблона!/Template file read error!\n "
								+ ex.getMessage());
			}
			// обновление отображения дерева и подгонка столбцов
			Display.getDefault().asyncExec(new Runnable() {
				@Override
				public void run() {
					// обновить элементы
					viewer.setInput(FiltersModel.getInstance().getDataArray());
					viewer.getTree().getColumn(DionisView.TREE_COLUMN_DATA)
							.pack();
					viewer.getTree().getColumn(DionisView.TREE_COLUMN_EXTENDED)
							.pack();
				}
			});

		}
	}
}
