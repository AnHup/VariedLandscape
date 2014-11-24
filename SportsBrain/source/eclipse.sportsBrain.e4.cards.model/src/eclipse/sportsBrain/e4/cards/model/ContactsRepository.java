package eclipse.sportsBrain.e4.cards.model;

import org.eclipse.core.databinding.observable.list.IObservableList;

public interface ContactsRepository {
	
	IObservableList getAllCards();

	void addCard(ICard card);

	void removeCard(ICard card);
}
