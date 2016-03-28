package com.mfra.dnd.checker;

import java.io.Serializable;

import com.mfra.dice.Dice;
import com.mfra.dice.IDice;
import com.mfra.dnd.util.IBasicData;

/**
 * @author Michael Felipe Rondón Acosta
 */
public abstract class ACheckeable extends AbilityWorker implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int lastCheck;

	private final Enum<?> name;

	private boolean success;

	/**
	 * @param name
	 * @param iBasicData
	 * @param abilityName
	 */
	public ACheckeable(Enum<?> name, IBasicData iBasicData, Ability.AbilityName abilityName) {
		super(iBasicData, abilityName);
		this.name = name;
	}

	/**
	 * @param characterName
	 * @param difficultyClass
	 * @param aditionalModifier
	 *            // * @return isSuccess
	 */
	public void check(String characterName, Integer difficultyClass, int aditionalModifier) {
		this.stringBuilder = new StringBuilder();
		IDice rollDice = Dice.getDice(20).rollDice(null, 1, this.getModifier() + aditionalModifier);

		if (characterName != null) {
			this.stringBuilder.append(characterName);
			this.stringBuilder.append(" checks for ");
			this.stringBuilder.append(this.name);
		} else {
			this.stringBuilder.append(" (");
			this.stringBuilder.append(this.name);
			this.stringBuilder.append(") ");
		}
		this.stringBuilder.append(System.getProperty("line.separator"));
		this.stringBuilder.append('\t');
		this.stringBuilder.append(rollDice.getStringFromBuilder());
		this.stringBuilder.append(System.getProperty("line.separator"));
		this.lastCheck = rollDice.getLastValue();
		if (difficultyClass != null) {
			this.success = rollDice.getLastValue() >= difficultyClass;
			if (this.success) {
				this.stringBuilder.append("the result was success");
			} else {
				this.stringBuilder.append("the result was not success");

			}
		}
		// return this;
	}

	/**
	 * @return header
	 */
	public abstract String getHeader();

	/**
	 * @return lastCheck
	 */
	public int getLastCheck() {
		return this.lastCheck;
	}

	/**
	 * @return modifier
	 */
	public abstract int getModifier();

	/**
	 * @return name
	 */
	public Enum<?> getName() {
		return this.name;
	}

	/**
	 * @return success
	 */
	public boolean isSuccess() {
		return this.success;
	}

	/**
	 * 
	 */
	@Override
	public abstract String toString();

	/**
	 * @return format
	 */
	protected abstract String getFormat();

}
