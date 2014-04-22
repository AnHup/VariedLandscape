package eclipse.sportsBrain.e4.cards.views.details;

import javax.inject.Inject;
import javax.inject.Named;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.PojoObservables;
import org.eclipse.core.databinding.observable.Realm;
import org.eclipse.core.databinding.observable.value.WritableValue;
import org.eclipse.e4.core.di.annotations.Optional;
import org.eclipse.e4.ui.services.IServiceConstants;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import eclipse.sportsBrain.e4.cards.model.ICard;

public class DetailsView {
	
	private DataBindingContext dataBindingContext;
	private WritableValue cardValue;
	private Text exerciseName;
	private Text exerciseDetails;
	private Text bestPerformance;
	private static Logger logger = LoggerFactory.getLogger(DetailsView.class);

	@Inject
	public DetailsView(Composite parent) {
		final Composite composite = new Composite(parent, SWT.NONE);
		composite
				.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));
		composite.setLayout(new GridLayout(2, false));
		Realm.runWithDefault(SWTObservables.getRealm(Display.getDefault()),
				new Runnable() {

					@Override
					public void run() {
						dataBindingContext = new DataBindingContext();
						cardValue = new WritableValue();
						exerciseName = createText(composite, "Exercise Name:",
								"exerciseName");
						exerciseDetails = createText(composite, "Exercise Details:",
								"exerciseDetails");
						bestPerformance = createText(composite, "Best Performance:", "bestPerformance");
					}
				});
	}

	private Text createText(final Composite parent, final String labelText,
			final String property) {
		
		final Label label = new Label(parent, SWT.NONE);
		label.setText(labelText);
		GridData gridData = new GridData(GridData.HORIZONTAL_ALIGN_FILL);
		label.setLayoutData(gridData);

		final Text text = new Text(parent, SWT.NONE);
		GridData gridData2 = new GridData(GridData.FILL_HORIZONTAL);
		gridData2.horizontalIndent = 0;
		gridData2.horizontalSpan = 1;
		text.setLayoutData(gridData2);

		if (property != null) {
			dataBindingContext.bindValue(SWTObservables.observeText(text, SWT.Modify),
					PojoObservables.observeDetailValue(cardValue, property,
							String.class));
		}

		return text;
	}

	@Inject
	public void setSelection(
			@Optional @Named(IServiceConstants.ACTIVE_SELECTION) ICard card) {
		logger.debug("setSelection with: " + card);
		if (card != null) {
			cardValue.setValue(card);
		}
	}

	public Text getFirstNameText() {
		return exerciseName;
	}

	public Text getLastNameText() {
		return exerciseDetails;
	}

	public Text getEmailText() {
		return bestPerformance;
	}
}
