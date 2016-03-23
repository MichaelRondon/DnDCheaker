package com.mfra.dnd.checker;

import java.io.Serializable;
import java.util.HashMap;
import com.mfra.dice.StringBuilderWriter;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class AbilityWorker extends StringBuilderWriter implements IAbilityWorker, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Ability.AbilityName abilityName;

	/**
	 * 
	 */
	protected HashMap<Enum<?>, ACheckeable> checkProperties = new HashMap<Enum<?>, ACheckeable>();

	/**
	 * @param checkProperties
	 * @param abilityName
	 */
	public AbilityWorker(HashMap<Enum<?>, ACheckeable> checkProperties, Ability.AbilityName abilityName) {
		this.checkProperties = checkProperties;
		this.abilityName = abilityName;
	}

	/**
	 * @return AbilityModifier
	 */
	@Override
	public int getAbilityModifier() {
		return ((Ability) this.checkProperties.get(this.getAbilityName())).getModifier();
	}

	/**
	 * @return getAbilityName()
	 */
	@Override
	public Ability.AbilityName getAbilityName() {
		return this.abilityName;
	}
}
