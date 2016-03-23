package com.mfra.dnd.checker;

import java.util.HashMap;
import com.mfra.dnd.checker.Ability.AbilityName;
import com.mfra.dnd.dndclass.ADnDClass;
import com.mfra.dnd.util.DnDUtil;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class AttackBonus extends ACheckeable {

	/**
	 * 
	 */
	public enum AttackName {
		/**
		 * 
		 */
		MELEE_ATTACK(Ability.AbilityName.STRENGTH),
		/**
		 * 
		 */
		RANGED_ATTACK(Ability.AbilityName.DEXTERITY);

		private Ability.AbilityName abilityName;

		private AttackName(AbilityName abilityName) {
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
	private static final long serialVersionUID = 3L;

	private HashMap<String, Object> descProperties;

	private int[] lastChecks;

	/**
	 * @param name
	 * @param checkProperties
	 * @param descProperties
	 */
	public AttackBonus(AttackBonus.AttackName name, HashMap<Enum<?>, ACheckeable> checkProperties,
			HashMap<String, Object> descProperties) {
		super(name, checkProperties, name.getAbilityName());
		this.descProperties = descProperties;
	}

	/**
	 * 
	 */
	@Override
	public void check(String characterName, Integer difficultyClass, int aditionalModifier) {
		int counter = 0;
		lastChecks = new int[getAttModifier().length];
		StringBuilder stringBuilder = new StringBuilder();
		for (Integer modifier : getAttModifier()) {
			super.check(characterName, difficultyClass, modifier);
			lastChecks[counter] = getLastCheck();
			stringBuilder.append(super.stringBuilder.toString());
		}
		super.stringBuilder = stringBuilder;
	}

	/**
	 * 
	 * @return AttModifier
	 */
	public int[] getAttModifier() {
		int[] resp = new int[getBaseAttack().length];
		int counter = 0;
		for (Integer baseAttack : getBaseAttack()) {
			resp[counter] = this.getAbilityModifier() + baseAttack;
			counter++;
		}
		return resp;
	}

	/**
	 * @return getBaseAttack
	 */
	private int[] getBaseAttack() {
		return ((ADnDClass) this.descProperties.get(ADnDClass.KEY_NAME)).getBaseAttackBonus();
	}

	@Override
	protected String getFormat() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("%-13s\t%-6s\t\t%-2d\t\t%-6s");
		stringBuilder.append(System.getProperty("line.separator"));
		return stringBuilder.toString();
	}

	@Override
	public String getHeader() {
		return "Name\t\tBaseAttack\tAbilityModifier\tTotalModifier";
	}

	@Override
	public int getModifier() {
		return 0;
	}

	@Override
	public String toString() {
		String line = String.format(this.getFormat(), this.getName(),

				DnDUtil.getInstance().intArrayToString(this.getBaseAttack()), this.getAbilityModifier(),
				DnDUtil.getInstance().intArrayToString(this.getAttModifier()));
		return line;
	}
}
