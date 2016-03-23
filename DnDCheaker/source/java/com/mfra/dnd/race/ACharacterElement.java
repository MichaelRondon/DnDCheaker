package com.mfra.dnd.race;

import java.io.Serializable;
import java.util.HashMap;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.feat.AFeat;
import com.mfra.dnd.util.DnDUtil;
import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 * @param <K>
 */
public abstract class ACharacterElement<K extends Enum<?>> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	protected final HashMap<Enum<?>, ACheckeable> checkProperties;
	/**
	 * 
	 */
	protected final HashMap<String, Object> descProperties;
	/**
	 * 
	 */
	private K nameElement;

	/**
	 * @param nameElement
	 * @param checkProperties
	 * @param descProperties
	 */
	public ACharacterElement(K nameElement, HashMap<Enum<?>, ACheckeable> checkProperties,
			HashMap<String, Object> descProperties) {
		this.nameElement = nameElement;
		this.checkProperties = checkProperties;
		this.descProperties = descProperties;
	}

	/**
	 * @param availableFeat
	 */
	protected void appendAvailableFeat(int availableFeat) {
		Integer availableFeats = 0;
		if (this.descProperties.get(AFeat.AVAILABLE_FEATS_KEY_NAME) != null) {
			availableFeats = (Integer) this.descProperties.get(AFeat.AVAILABLE_FEATS_KEY_NAME);
		}
		this.descProperties.put(AFeat.AVAILABLE_FEATS_KEY_NAME, availableFeats + availableFeat);
	}

	/**
	 * @return keyName
	 */
	protected abstract String getKeyName();

	/**
	 * @return nameElement
	 */
	public K getName() {
		return this.nameElement;
	}

	/**
	 * 
	 */
	protected void preValidation() {
		if (this.descProperties.containsKey(this.getKeyName())) {
			throw new GeneralException("You has a " + this.getKeyName() + " Yet");
		}
		DnDUtil.getInstance().validAreAbilitiesSet(this.checkProperties);
	}

	/**
	 * 
	 */
	public void setElement() {
		this.preValidation();
		this.descProperties.put(this.getKeyName(), this);
	}

	@Override
	public String toString() {
		return this.getName().toString();
	}
}
