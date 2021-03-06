package com.mfra.dnd.checker;

import com.mfra.dnd.util.IBasicData;

/**
 * @author Michael Felipe Rond�n Acosta
 */
public class Ability extends ACheckeable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int temporalScoreModifier;

	private int value;

	/**
	 * @param name
	 * @param value
	 * @param iBasicData
	 */
	public Ability(AbilityName name, int value, IBasicData iBasicData) {
		super(name, iBasicData, name);
		this.addValue(value);
	}

	/**
	 * @param valueToAdd
	 */
	public void addTemporalScoreModifier(int valueToAdd) {
		this.temporalScoreModifier += valueToAdd;
	}

	@Override
	public int getAbilityModifier() {
		return getAbilityModifier(this.getEfectyValue());
	}

	/**
	 * @param spellLevel
	 * @return BonusSpellBySpellLevel
	 */
	public int getBonusSpellBySpellLevel(int spellLevel) {
		int base = this.getEfectyValue() - spellLevel;
		int resp = base - 3 >> 3;
		resp = resp < 0 ? 0 : resp;
		return resp;
	}

	/**
	 * @return value
	 */
	public int getEfectyValue() {
		return this.value + this.temporalScoreModifier;
	}

	/**
	 * @return header
	 */
	@Override
	public String getHeader() {
		return "Name\tScore\tModifier";
	}

	@Override
	public int getModifier() {
		return this.getAbilityModifier();
	}

	/**
	 * @return value
	 */
	public int getValue() {
		return this.value;
	}

	/**
	 * 
	 */
	@Override
	public String toString() {
		String line = String.format(this.getFormat(), this.getName(), this.getValue(), this.getModifier());
		return line;
	}

	/**
	 * @param valueToAdd
	 */
	protected void addValue(int valueToAdd) {
		this.value += valueToAdd;
	}

	/**
	 * @return format
	 */
	@Override
	protected String getFormat() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("%s\t%d\t%d");
		stringBuilder.append(System.getProperty("line.separator"));
		return stringBuilder.toString();
	}

	/**
	 * @param value
	 * @return (value - 10) >> 1
	 */
	public static int getAbilityModifier(int value) {
		return value - 10 >> 1;
	}

	/**
	 * 
	 */
	public enum AbilityName {
		/**
		 * 
		 */
		CHARISMA,
		/**
		 * 
		 */
		CONSTITUTION,
		/**
		 * 
		 */
		DEXTERITY,
		/**
		 * 
		 */
		INTELLIGENCE,
		/**
		 * 
		 */
		STRENGTH,
		/**
		 * 
		 */
		WISDOM;
	}
}
