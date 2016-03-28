package com.mfra.dnd.util;

import java.io.Serializable;

import com.mfra.dnd.checker.ACheckeable;

/**
 * 
 * @author Michael Felipe Rondón Acosta
 *
 */
public interface IBasicData extends Serializable {

	/**
	 * 
	 * @param checkProperty
	 * @return if the list of the checker elements contains this key
	 */
	public boolean containsCheckProperty(Enum<?> checkProperty);

	/**
	 * 
	 * @param descProperty
	 * @return if the list of the description elements contains this key
	 */
	public boolean containsDescProperty(String descProperty);

	// public HashMap<Enum<?>, ACheckeable> getCheckProperties();

	/**
	 * 
	 * @param checkProperty
	 * @return get the value of this key from the checker elements
	 */
	public ACheckeable getCheckProperty(Enum<?> checkProperty);

	// public HashMap<String, Object> getDescProperties();

	/**
	 * 
	 * @param descProperty
	 * @return get the value of this key from the description elements
	 */
	public Object getDescProperty(String descProperty);

	/**
	 * 
	 * @param enumeration
	 * @param aCheckeable
	 */
	public void putCheckProperty(Enum<?> enumeration, ACheckeable aCheckeable);

	/**
	 * 
	 * @param descProperty
	 * @param object
	 */
	public void putDescProperty(String descProperty, Object object);

	/**
	 * 
	 * @param checkProperty
	 */
	public void removeCheckProperty(Enum<?> checkProperty);

	/**
	 * @return Returns the description contain in a string.
	 * 
	 */
	public String showDescProperties();

	/**
	 */
	public void validAreAbilitiesSet();

	/**
	 */
	public void validIsClassSet();

	/**
	 */
	public void validIsRaceSet();

	/**
	 * 
	 * @return If the character has the atrribute "Created"
	 */
	public boolean wasCreated();
}
