package eclipse.sportsBrain.e4.cards.model.simple;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

import eclipse.sportsBrain.e4.cards.model.ICard;

public class SportCard implements ICard {
	private String exerciseName;
	private String exerciseDetails;
	private String bestPerformance;

	private final PropertyChangeSupport propertyChangeSupport;

	public SportCard(String exerciseName, String exerciseDetails, String bestPerformance) {
		super();
		this.exerciseName = exerciseName;
		this.exerciseDetails = exerciseDetails;
		this.bestPerformance = bestPerformance;
		propertyChangeSupport = new PropertyChangeSupport(this);
	}

	@Override
	public String getExerciseName() {
		return exerciseName;
	}

	@Override
	public void setExerciseName(String firstName) {
		this.exerciseName = firstName;
	}

	@Override
	public String getExerciseDetails() {
		return exerciseDetails;
	}

	@Override
	public void setExerciseDetails(String lastName) {
		this.exerciseDetails = lastName;
	}

	@Override
	public String getBestPerformance() {
		return bestPerformance;
	}

	@Override
	public void setBestPerformance(String email) {
		this.bestPerformance = email;
	}

	@Override
	public void addPropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.addPropertyChangeListener(listener);
	}

	@Override
	public void removePropertyChangeListener(PropertyChangeListener listener) {
		propertyChangeSupport.removePropertyChangeListener(listener);
	}

	@Override
	public String toString() {
		return "SimpleCard [exerciseName=" + exerciseName + ", exerciseDetails="
				+ exerciseDetails + ", bestPerformance=" + bestPerformance + "]";
	}
}
