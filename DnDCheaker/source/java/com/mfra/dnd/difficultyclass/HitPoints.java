package com.mfra.dnd.difficultyclass;

import com.mfra.dnd.dndclass.ADnDClass;
import com.mfra.dnd.util.IBasicData;

/**
 * @author Michael Felipe Rond�n Acosta
 */
public class HitPoints extends ADifficultyClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int currentHitPoints;

	/**
	 * @param nameElement
	 * @param iBasicData
	 */
	public HitPoints(DCKeyName nameElement, IBasicData iBasicData) {
		super(ADifficultyClass.DCKeyName.HIT_POINTS, iBasicData);
		this.restore();
	}

	/**
	 * @return currentHitPoints
	 */
	public int getCurrentHitPoints() {
		return this.currentHitPoints;
	}

	/**
	 * @return maxHitPoints
	 */
	public int getMaxHitPoints() {
		return this.getAbilityModifier() + this.getClassModifier();
	}

	/**
	 * @param valueToHeal
	 */
	public void heal(int valueToHeal) {
		this.currentHitPoints += valueToHeal;
		if (this.currentHitPoints > this.getMaxHitPoints()) {
			this.currentHitPoints = this.getMaxHitPoints();
		}
	}

	/**
	 * 
	 */
	public void restore() {
		this.currentHitPoints = this.getMaxHitPoints();
	}

	/**
	 * @param valueToSubstract
	 */
	public void substractToHitPoints(int valueToSubstract) {
		if (valueToSubstract < 0) {
			this.currentHitPoints += valueToSubstract;
		} else {
			this.currentHitPoints -= valueToSubstract;
		}
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append(this.getCurrentHitPoints());
		stringBuilder.append("/");
		stringBuilder.append(this.getMaxHitPoints());
		stringBuilder.append("\tAbilityModifier:");
		stringBuilder.append(this.getAbilityModifier());
		return stringBuilder.toString();
	}

	/**
	 * @return BaseHitPoints
	 */
	private int getClassModifier() {
		return ((ADnDClass) this.iBasicData.getDescProperty(ADnDClass.KEY_NAME)).getName().getBaseHitPoints();
	}

}
