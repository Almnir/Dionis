package dionis.providers;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import dionis.beans.FiltersBean;

public class FiltersTreeContentProvider implements ITreeContentProvider {

	private static final Object[] EMPTY_ARRAY = new Object[0];

	@Override
	public void dispose() {
	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
	}

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Object[]) {
			return (Object[]) inputElement;
		} else {
			return EMPTY_ARRAY;
		}
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof FiltersBean) {
			FiltersBean filtersBean = (FiltersBean) parentElement;
			if (filtersBean.getFilter() != null
					&& filtersBean.getFilter().getItem() != null) {
				return filtersBean.getFilter().getItem().toArray();
			}
		}
		return EMPTY_ARRAY;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof FiltersBean) {
			FiltersBean filtersBean = (FiltersBean) element;
			if (filtersBean.getFilter() != null
					&& filtersBean.getFilter().getItem() != null) {
				return true;
			}
		}
		return false;
	}

}
