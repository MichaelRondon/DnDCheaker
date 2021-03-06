package com.mfra.dnd.weapon;

import java.util.HashMap;

import com.mfra.dice.IDice;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.Ability.AbilityName;
import com.mfra.dnd.checker.AbilityWorker;
import com.mfra.dnd.util.IBasicData;

/**
 * @author Michael Felipe Rond�n Acosta
 */
public class Damage extends AbilityWorker {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IDice dice;

	/**
	 * @param checkProperties
	 * @param abilityName
	 * @param iBasicData
	 */
	public Damage(HashMap<Enum<?>, ACheckeable> checkProperties, AbilityName abilityName, IBasicData iBasicData) {
		super(iBasicData, abilityName);

	}

	/**
	 */
	public void makeDamage() {
		this.stringBuilder = new StringBuilder();
		this.stringBuilder.append("To makes damage ");
		// int resp = 0;
		if (this.dice != null) {
			IDice rollDice = this.dice.rollDice();
			this.stringBuilder.append(rollDice.getStringFromBuilder());
			// resp += rollDice.getLastValue();
		}

	}

	/**
	 * @param diceModifier
	 */
	public void setDiceModifier(IDice diceModifier) {
		this.dice = diceModifier;
	}
}
