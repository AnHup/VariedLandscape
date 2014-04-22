package eclipse.sportsBrain.e4.cards.model;

import java.beans.PropertyChangeListener;

public interface ICard {
	String getExerciseName();

	void setExerciseName(String exerciseName);

	String getExerciseDetails();

	void setExerciseDetails(String exerciseDetails);

	String getBestPerformance();

	void setBestPerformance(String bestPerformance);

	void addPropertyChangeListener(PropertyChangeListener listener);

	void removePropertyChangeListener(PropertyChangeListener listener);
}
