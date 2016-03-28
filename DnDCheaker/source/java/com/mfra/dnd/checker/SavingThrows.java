package com.mfra.dnd.checker;

import java.io.Serializable;

import com.mfra.dnd.checker.Ability.AbilityName;
import com.mfra.dnd.dndclass.ADnDClass;
import com.mfra.dnd.util.IBasicData;

/**
 * @author Michael Felipe Rond�n Acosta
 */
public class SavingThrows extends ACheckeable implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2L;

	/**
	 * @param name
	 * @param iBasicData
	 */
	public SavingThrows(SavingThrows.SavingThrowName name, IBasicData iBasicData) {
		super(name, iBasicData, name.getAbilityName());
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

	/**
	 * @return getBaseAttack
	 */
	private int getBaseSavingThrow() {
		return ((ADnDClass) this.iBasicData.getDescProperty(ADnDClass.KEY_NAME)).getBaseSavingThrow();
	}

	@Override
	protected String getFormat() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("%s\t%d\t%d\t%d");
		stringBuilder.append(System.getProperty("line.separator"));
		return stringBuilder.toString();
	}

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
}
