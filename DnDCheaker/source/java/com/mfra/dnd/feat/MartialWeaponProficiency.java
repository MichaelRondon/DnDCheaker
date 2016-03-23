package com.mfra.dnd.feat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.weapon.WeaponName;
import com.mfra.dnd.weapon.WeaponType3;
import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class MartialWeaponProficiency extends AFeat<WeaponName> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Set<WeaponName> weapons = new HashSet<WeaponName>();

	/**
	 * @param nameElement
	 * @param checkProperties
	 * @param descProperties
	 */
	public MartialWeaponProficiency(com.mfra.dnd.feat.AFeat.FeatName nameElement,
			HashMap<Enum<?>, ACheckeable> checkProperties, HashMap<String, Object> descProperties) {
		super(nameElement, checkProperties, descProperties);
	}

	@Override
	protected void addElement(WeaponName element) {
		if (element.getWeaponType3().equals(WeaponType3.MARTIAL_WEAPONS)) {
			this.weapons.add(element);
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("This element: ");
			stringBuilder.append(element);
			stringBuilder.append(" is not allowed for this feat: ");
			stringBuilder.append(this.toString());
			throw new GeneralException(stringBuilder.toString());
		}
	}

	@Override
	public Set<WeaponName> getElements() {
		return this.weapons;
	}

	@Override
	protected void setBenefits() {
	}

	@Override
	protected void validPrerequisites() {
	}

}
