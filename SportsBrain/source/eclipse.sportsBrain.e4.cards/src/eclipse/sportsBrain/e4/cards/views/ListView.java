package eclipse.sportsBrain.e4.cards.views;

import javax.inject.Inject;

import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.map.IObservableMap;
import org.eclipse.e4.core.di.annotations.Optional;
import eclipse.sportsBrain.e4.cards.model.ICard;
import eclipse.sportsBrain.e4.cards.model.ContactsRepository;
import org.eclipse.e4.ui.workbench.modeling.ESelectionService;
import org.eclipse.jface.databinding.viewers.ObservableListContentProvider;
import org.eclipse.jface.databinding.viewers.ObservableMapLabelProvider;
import org.eclipse.jface.layout.GridLayoutFactory;
import org.eclipse.jface.layout.TableColumnLayout;
import org.eclipse.jface.viewers.ColumnWeightData;
import org.eclipse.jface.viewers.ISelectionChangedListener;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.SelectionChangedEvent;
import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.jface.viewers.TableViewerColumn;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;

public class ListView {

	private TableViewer tableViewer;

	@Inject
	private ESelectionService selectionService;

	@Inject
	public ListView(Composite parent, ContactsRepository cardsRepository) {
		// Table composite (because of TableColumnLayout)
		final Composite tableComposite = new Composite(parent, SWT.NONE);
		tableComposite.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true,
				true));
		final TableColumnLayout tableColumnLayout = new TableColumnLayout();
		tableComposite.setLayout(tableColumnLayout);

		// Table viewer
		tableViewer = new TableViewer(tableComposite, SWT.FULL_SELECTION);
		tableViewer.getTable().setHeaderVisible(true);

		// first name column
		final TableViewerColumn firstNameColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		firstNameColumn.getColumn().setText("Exercise Name");
		tableColumnLayout.setColumnData(firstNameColumn.getColumn(),
				new ColumnWeightData(40));

		// last name column
		final TableViewerColumn lastNameColumn = new TableViewerColumn(
				tableViewer, SWT.NONE);
		lastNameColumn.getColumn().setText("Exercise Details");
		tableColumnLayout.setColumnData(lastNameColumn.getColumn(),
				new ColumnWeightData(40));

		ObservableListContentProvider contentProvider = new ObservableListContentProvider();

		tableViewer.setContentProvider(contentProvider);

		IObservableMap[] attributes = BeansObservables.observeMaps(
				contentProvider.getKnownElements(), ICard.class,
				new String[] { "exerciseName", "exerciseDetails" });
		tableViewer
				.setLabelProvider(new ObservableMapLabelProvider(attributes));

		tableViewer.setInput(cardsRepository.getAllCards());

		GridLayoutFactory.fillDefaults().generateLayout(parent);

		tableViewer
				.addSelectionChangedListener(new ISelectionChangedListener() {
					@Override
					public void selectionChanged(SelectionChangedEvent event) {
						IStructuredSelection selection = (IStructuredSelection) event
								.getSelection();
						selectionService.setSelection(selection
								.getFirstElement());
					}
				});
	}
}
