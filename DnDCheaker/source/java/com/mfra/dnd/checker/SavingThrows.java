package com.mfra.dnd.checker;

import java.io.Serializable;
import java.util.HashMap;
import com.mfra.dnd.checker.Ability.AbilityName;
import com.mfra.dnd.dndclass.ADnDClass;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class SavingThrows extends ACheckeable implements Serializable {

	/**
	 * 
	 */
	public enum SavingThrowName {
		/**
		 * 
		 */
		FORTITUDE(Ability.AbilityName.CONSTITUTION),
		/**
		 * 
		 */
		REFLEX(Ability.AbilityName.DEXTERITY),
		/**
		 * 
		 */
		WILL(Ability.AbilityName.WISDOM);

		private Ability.AbilityName abilityName;

		private SavingThrowName(AbilityName abilityName) {
			this.abilityName = abilityName;
		}

		/**
		 * @return abilityName
		 */
		public Ability.AbilityName getAbilityName() {
			return this.abilityName;
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	private HashMap<String, Object> descProperties;

	/**
	 * @param name
	 * @param checkProperties
	 * @param descProperties
	 */
	public SavingThrows(SavingThrows.SavingThrowName name, HashMap<Enum<?>, ACheckeable> checkProperties,
			HashMap<String, Object> descProperties) {
		super(name, checkProperties, name.getAbilityName());
		this.descProperties = descProperties;
	}

	/**
	 * @return getBaseAttack
	 */
	private int getBaseSavingThrow() {
		return ((ADnDClass) this.descProperties.get(ADnDClass.KEY_NAME)).getBaseSavingThrow();
	}

	@Override
	protected String getFormat() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("%s\t%d\t%d\t%d");
		stringBuilder.append(System.getProperty("line.separator"));
		return stringBuilder.toString();
	}

	@Override
	public String getHeader() {
		return "Name\tBaseSavingThrow\tAbilityModifier\tTotalModifier";
	}

	@Override
	public int getModifier() {
		return this.getAbilityModifier() + this.getBaseSavingThrow();
	}

	@Override
	public String toString() {
		String line = String.format(this.getFormat(), this.getName(),

				this.getBaseSavingThrow(), this.getAbilityModifier(), this.getModifier());
		return line;
	}
}
