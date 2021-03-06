package com.mfra.dnd.feat;

import java.util.HashSet;
import java.util.Set;

import com.mfra.dnd.util.IBasicData;
import com.mfra.dnd.weapon.WeaponName;
import com.mfra.dnd.weapon.WeaponType3;
import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rond�n Acosta
 */
public class MartialWeaponProficiency extends AFeat<WeaponName> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private final Set<WeaponName> weapons = new HashSet<WeaponName>();

	/**
	 * @param nameElement
	 * @param iBasicData
	 */
	public MartialWeaponProficiency(com.mfra.dnd.feat.AFeat.FeatName nameElement, IBasicData iBasicData) {
		super(nameElement, iBasicData);
	}

	@Override
	public Set<WeaponName> getElements() {
		return this.weapons;
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
	protected void setBenefits() {
	}

	@Override
	protected void validPrerequisites() {
	}

}
