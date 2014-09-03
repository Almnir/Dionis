package dionis.handlers;

import static org.eclipse.ui.PlatformUI.getWorkbench;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.IWorkbenchWindow;

/**
 * Базовый абстрактный класс для всех обработчиков.
 * 
 * @author ars (Ибрагимов А.М.)
 */
public abstract class AbstractBaseHandler extends AbstractHandler {

	/**
	 * Возвращает shell.
	 * 
	 * @return shell или <code>null</code> в случае ошибки
	 */
	public static Shell getShell() {
		IWorkbenchWindow window = getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			return window.getShell();
		}
		return null;
	}

	/**
	 * Возвращает объект {@link IStructuredSelection}.
	 * 
	 * @return объект {@link IStructuredSelection} или <code>null</code> в
	 *         случае ошибки
	 */
	public static IStructuredSelection getStructuredSelection() {
		IWorkbenchWindow window = getWorkbench().getActiveWorkbenchWindow();
		if (window != null) {
			ISelection selection = window.getSelectionService().getSelection();

			if (selection instanceof IStructuredSelection) {
				return ((IStructuredSelection) selection);
			}
		}
		return null;
	}

	/**
	 * Возвращает первый выделенный объект.
	 * 
	 * @return первый выделенный объект или <code>null</code>, если ни один
	 *         объект не выделен
	 */
	public static Object getSelectionObject() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection != null) {
			return selection.getFirstElement();
		}
		return null;
	}

	/**
	 * Возвращает массив выделенных объектов.
	 * 
	 * @return массив выделенных объектов (не может быть <code>null</code>)
	 */
	public static Object[] getSelectionObjects() {
		IStructuredSelection selection = getStructuredSelection();
		if (selection != null) {
			return selection.toArray();
		}
		return new Object[0];
	}

	/**
	 * @param id
	 * @return
	 */
	public static IViewPart getView(final String id) {
		return getWorkbench().getActiveWorkbenchWindow().getActivePage()
				.findView(id);
	}
}
