package dionis.providers;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import dionis.beans.FiltersBean;
import dionis.models.FiltersModel;

public class FiltersTreeContentProvider implements ITreeContentProvider {

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof String[]) {
			String[] strings = (String[]) inputElement;
			return strings;
		} else if (inputElement instanceof FiltersModel) {
			FiltersModel model = (FiltersModel) inputElement;
			return model.getDataArray();
		} else
			return new Object[0];
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof FiltersBean) {
			FiltersBean filtersBean = (FiltersBean) parentElement;
			return filtersBean.getFilter().getItem().toArray();
		}
		if (parentElement instanceof String) {
			return new Object[] { parentElement };
		}
		return new Object[0];
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof FiltersModel || element instanceof FiltersBean
				|| element instanceof String[]) {
			return true;
		}
		return false;
	}

}
