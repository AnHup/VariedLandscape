package eclipse.sportsBrain.e4.cards.views.details;

import static org.junit.Assert.assertEquals;

import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

import eclipse.sportsBrain.e4.cards.model.ICard;
import eclipse.sportsBrain.e4.cards.model.simple.SportCard;
import eclipse.sportsBrain.e4.cards.views.details.DetailsView;

public class DetailsViewTest {
	
	@Test
	public void shouldSetContactSelection() {
		Composite parent = new Shell();
		DetailsView detailsView = new DetailsView(parent);

		ICard card = new SportCard("Walking on Plank", "Ohne Gewichte", "25 Wiederholungen");
		((DetailsView)detailsView).setSelection(card);

		assertEquals("Walking on Plank", detailsView.getFirstNameText().getText());
		assertEquals("Ohne Gewichte", detailsView.getLastNameText().getText());
		assertEquals("25 Wiederholungen", detailsView.getEmailText().getText());
	}
}
