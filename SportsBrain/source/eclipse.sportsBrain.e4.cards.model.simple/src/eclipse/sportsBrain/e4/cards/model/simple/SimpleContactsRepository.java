package eclipse.sportsBrain.e4.cards.model.simple;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.databinding.observable.list.IObservableList;
import org.eclipse.core.databinding.observable.list.WritableList;
import eclipse.sportsBrain.e4.cards.model.ICard;
import eclipse.sportsBrain.e4.cards.model.ContactsRepository;

public class SimpleContactsRepository implements ContactsRepository {
	
	private final IObservableList cards;
	
	public SimpleContactsRepository() {
		List<ICard> cardList = new ArrayList<ICard>();
		cardList.add(new SportCard("Walking on Plank", "Ohne Gewichte", "25 Wiederholungen"));
		cardList.add(new SportCard("Bergsteiger", "Ohne Gewichte", "30 Wiederholungen"));
		cards = new WritableList(cardList, null);
	}

	@Override
	public void addCard(final ICard card) {
		cards.add(card);
	}

	@Override
	public void removeCard(final ICard card) {
		cards.remove(card);
	}

	@Override
	public IObservableList getAllCards() {
		return cards;
	}
}
