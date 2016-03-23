package com.mfra.dnd.checker;

import java.io.Serializable;
import com.mfra.dice.StringBuilderWriter;
import com.mfra.dnd.util.IBasicData;

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
	protected IBasicData iBasicData;

	/**
	 * @param checkProperties
	 * @param abilityName
	 */
	public AbilityWorker(IBasicData iBasicData, Ability.AbilityName abilityName) {
		this.iBasicData = iBasicData;
		this.abilityName = abilityName;
	}

	/**
	 * @return AbilityModifier
	 */
	@Override
	public int getAbilityModifier() {
		return ((Ability) this.iBasicData.getCheckProperty(this.getAbilityName())).getModifier();
	}

	/**
	 * @return getAbilityName()
	 */
	@Override
	public Ability.AbilityName getAbilityName() {
		return this.abilityName;
	}
}
