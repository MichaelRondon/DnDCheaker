package com.mfra.dnd.manager;

import java.util.HashMap;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.AttackBonus;
import com.mfra.dnd.checker.AttackBonus.AttackName;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class AttackBonusManager extends ACheckManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private HashMap<String, Object> descProperties;

	/**
	 * @param checkProperties
	 * @param descProperties
	 */
	public AttackBonusManager(HashMap<Enum<?>, ACheckeable> checkProperties, HashMap<String, Object> descProperties) {
		super(checkProperties);
		this.descProperties = descProperties;
	}

	@Override
	public void init() {
		super.setProperty(new AttackBonus(AttackName.MELEE_ATTACK, this.checkProperties, this.descProperties));
		super.setProperty(new AttackBonus(AttackName.RANGED_ATTACK, this.checkProperties, this.descProperties));
	}
}
