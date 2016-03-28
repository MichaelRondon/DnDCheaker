package com.mfra.dnd.util;

import java.util.HashMap;
import java.util.Set;
import java.util.Map.Entry;

import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.Ability;
import com.mfra.dnd.checker.Ability.AbilityName;
import com.mfra.dnd.dndclass.ADnDClass;
import com.mfra.dnd.race.ARace;
import com.mfra.exceptions.GeneralException;

/**
 * 
 * @author Michael Felipe Rondón Acosta
 *
 */
public class BasicData implements IBasicData {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HashMap<Enum<?>, ACheckeable> checkProperties = new HashMap<Enum<?>, ACheckeable>();

	private HashMap<String, Object> descProperties = new HashMap<String, Object>();

	/**
	 * 
	 */
	public BasicData() {
	}

	/**
	 * 
	 * @param checkProperties
	 * @param descProperties
	 */
	public BasicData(HashMap<Enum<?>, ACheckeable> checkProperties, HashMap<String, Object> descProperties) {
		this.checkProperties = checkProperties;
		this.descProperties = descProperties;
	}

	@Override
	public boolean containsCheckProperty(Enum<?> checkProperty) {
		return this.checkProperties.containsKey(checkProperty);
	}

	@Override
	public boolean containsDescProperty(String descProperty) {
		return this.descProperties.containsKey(descProperty);
	}

	@Override
	public ACheckeable getCheckProperty(Enum<?> checkProperty) {
		return this.checkProperties.get(checkProperty);
	}

	@Override
	public Object getDescProperty(String descProperty) {
		return this.descProperties.get(descProperty);
	}

	@Override
	public void putCheckProperty(Enum<?> enumeration, ACheckeable aCheckeable) {
		this.checkProperties.put(enumeration, aCheckeable);
	}

	@Override
	public void putDescProperty(String descProperty, Object object) {
		this.descProperties.put(descProperty, object);
	}

	@Override
	public void removeCheckProperty(Enum<?> checkProperty) {
		this.checkProperties.remove(checkProperty);

	}

	@Override
	public String showDescProperties() {
		Set<Entry<String, Object>> entrySet = this.descProperties.entrySet();
		StringBuilder stringBuilder = new StringBuilder();
		for (Entry<String, Object> entry : entrySet) {
			stringBuilder.append(String.format("%-15s:\t%s", entry.getKey(), entry.getValue()));
			stringBuilder.append(System.getProperty("line.separator"));
		}
		return stringBuilder.toString();
	}

	/**
	 */
	@Override
	public void validAreAbilitiesSet() {

		AbilityName[] values = AbilityName.values();
		for (AbilityName abilityName : values) {
			ACheckeable aCheckeable = this.checkProperties.get(abilityName);
			if (((Ability) aCheckeable).getValue() == 0) {
				throw new GeneralException("You must set the abilities first");
			}
		}
	}

	/**
	 */
	@Override
	public void validIsClassSet() {
		if (!this.descProperties.containsKey(ADnDClass.KEY_NAME)) {
			throw new GeneralException("You must set the class first");
		}
	}

	/**
	 */
	@Override
	public void validIsRaceSet() {
		if (!this.descProperties.containsKey(ARace.KEY_NAME)) {
			throw new GeneralException("You must set the race first");
		}
	}

	@Override
	public boolean wasCreated() {
		boolean resp = false;
		if (this.descProperties != null && this.descProperties.containsKey(DescProperty.CREATED.toString())) {
			Object object = this.descProperties.get(DescProperty.CREATED.toString());
			if (object instanceof Boolean) {
				resp = (Boolean) object;
			}
		}
		return resp;
	}

}
