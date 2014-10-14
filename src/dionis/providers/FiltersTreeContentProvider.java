package dionis.providers;

import java.util.List;

import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import dionis.beans.FiltersBean;
import dionis.beans.IFilterItem;
import dionis.models.FiltersModel;

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
		if (inputElement instanceof FiltersModel) {
			System.out.println((FiltersModel) inputElement);
			return ((FiltersModel) inputElement).getDataArray();
		} else
			return EMPTY_ARRAY;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof FiltersBean) {
			FiltersBean filtersBean = (FiltersBean) parentElement;
			return filtersBean.getFilter().getItem().toArray();
		} else
			return EMPTY_ARRAY;
	}

	@Override
	public Object getParent(Object element) {
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof FiltersBean || element instanceof FiltersModel) {
			return true;
		}
		return false;
	}

}
