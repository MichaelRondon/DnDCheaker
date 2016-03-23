package com.mfra.dnd.util;

import java.io.Serializable;
import com.mfra.dnd.checker.ACheckeable;

public interface IBasicData extends Serializable {
	public boolean containsCheckProperty(Enum<?> checkProperty);

	public boolean containsDescProperty(String descProperty);

	// public HashMap<Enum<?>, ACheckeable> getCheckProperties();

	public ACheckeable getCheckProperty(Enum<?> checkProperty);

	// public HashMap<String, Object> getDescProperties();

	public Object getDescProperty(String descProperty);

	public void putCheckProperty(Enum<?> enumeration, ACheckeable aCheckeable);

	public void putDescProperty(String descProperty, Object object);

	public void removeCheckProperty(Enum<?> checkProperty);

	/**
	 * @param checkProperties
	 */
	public void validAreAbilitiesSet();

	/**
	 * @param descProperties
	 */
	public void validIsClassSet();

	/**
	 * @param descProperties
	 */
	public void validIsRaceSet();

	public boolean wasCreated();
}
