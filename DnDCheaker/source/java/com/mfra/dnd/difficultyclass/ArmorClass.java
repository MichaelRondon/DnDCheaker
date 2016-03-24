package com.mfra.dnd.difficultyclass;

import java.util.HashMap;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.race.ARace;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class ArmorClass extends ADifficultyClass {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int armorBonus;
	private int shieldBonus;

	/**
	 * @param nameElement
	 * @param checkProperties
	 * @param descProperties
	 */
	public ArmorClass(DCKeyName nameElement, HashMap<Enum<?>, ACheckeable> checkProperties,
			HashMap<String, Object> descProperties) {
		super(ADifficultyClass.DCKeyName.ARMOR_CLASS, checkProperties, descProperties);
	}

	/**
	 * @return armorBonus
	 */
	public int getArmorBonus() {
		return this.armorBonus;
	}

	/**
	 * @return DC
	 */
	public int getDifficultyClass() {
		return 10 + this.getArmorBonus() + this.getShieldBonus() + this.getSizeModifier() + this.getAbilityModifier();
	}

	/**
	 * @return shieldBonus
	 */
	public int getShieldBonus() {
		return this.shieldBonus;
	}

	/**
	 * @return SizeModifier
	 */
	public int getSizeModifier() {
		return ((ARace) this.iBasicData.getDescProperty(ARace.KEY_NAME)).getName().getSizeModifier();
	}

	/**
	 * @param armorBonus
	 */
	public void setArmorBonus(int armorBonus) {
		this.armorBonus = armorBonus;
	}

	/**
	 * @param shieldBonus
	 */
	public void setShieldBonus(int shieldBonus) {
		this.shieldBonus = shieldBonus;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("DifficultyClass:");
		stringBuilder.append(this.getDifficultyClass());
		stringBuilder.append("\tArmorBonus:");
		stringBuilder.append(this.getArmorBonus());
		stringBuilder.append("\tShieldBonus:");
		stringBuilder.append(this.getShieldBonus());
		stringBuilder.append("\tSizeModifier:");
		stringBuilder.append(this.getSizeModifier());
		stringBuilder.append("\tAbilityModifier:");
		stringBuilder.append(this.getAbilityModifier());
		return stringBuilder.toString();
	}

}
