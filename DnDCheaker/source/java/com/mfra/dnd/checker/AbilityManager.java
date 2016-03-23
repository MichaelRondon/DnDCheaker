package com.mfra.dnd.checker;

import com.mfra.dnd.manager.ACheckManager;
import com.mfra.dnd.util.DescProperty;
import com.mfra.dnd.util.IBasicData;
import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class AbilityManager extends ACheckManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param checkProperties
	 */
	public AbilityManager(IBasicData iBasicData) {
		super(iBasicData);
	}

	/**
	 * @param name
	 * @param valueToAdd
	 * @throws GeneralException
	 */
	public void addToAbility(Ability.AbilityName name, int valueToAdd) throws GeneralException {
		if (iBasicData.wasCreated()) {
			Object object = iBasicData.getDescProperty(DescProperty.AVAILABLE_ABILITY_POINTS.toString());
			if (!(object instanceof Integer) || ((Integer) object) < valueToAdd) {
				throw new GeneralException("You don't have enought available ability points!");
			}
			int availablePoints = ((Integer) object) - valueToAdd;
			iBasicData.putDescProperty(DescProperty.AVAILABLE_ABILITY_POINTS.toString(), availablePoints);
		}
		ACheckeable property = super.getProperty(name);
		if (property instanceof Ability) {
			((Ability) property).addValue(valueToAdd);
		} else {
			throw new GeneralException("Cast error");
		}
	}

	/**
	 * 
	 */
	public void adjustMinIntelligence() {
		Ability intelligence = (Ability) super.getProperty(Ability.AbilityName.INTELLIGENCE);
		int intelligenceScore = (intelligence).getValue();
		if (intelligenceScore < 3) {
			intelligence.addValue(3 - intelligenceScore);
		}
	}

	/**
	 * @param name
	 * @return modifier
	 */
	public int getAbilityModifier(Ability.AbilityName name) {
		ACheckeable property = super.getProperty(name);
		return ((Ability) property).getModifier();
	}

	@Override
	public void init() {
		super.setProperty(new Ability(Ability.AbilityName.CHARISMA, 0, this.iBasicData));
		super.setProperty(new Ability(Ability.AbilityName.CONSTITUTION, 0, this.iBasicData));
		super.setProperty(new Ability(Ability.AbilityName.DEXTERITY, 0, this.iBasicData));
		super.setProperty(new Ability(Ability.AbilityName.INTELLIGENCE, 0, this.iBasicData));
		super.setProperty(new Ability(Ability.AbilityName.STRENGTH, 0, this.iBasicData));
		super.setProperty(new Ability(Ability.AbilityName.WISDOM, 0, this.iBasicData));

	}

	/**
	 * @param name
	 * @param value
	 */
	public void setAbility(Ability.AbilityName name, int value) {
		if (!iBasicData.wasCreated()) {
			super.setProperty(new Ability(name, value, iBasicData));
		}
	}
}
