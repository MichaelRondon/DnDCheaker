package com.mfra.dnd.race;

import java.io.Serializable;
import java.util.HashMap;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.feat.AFeat;
import com.mfra.dnd.util.BasicData;
import com.mfra.dnd.util.IBasicData;
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
	protected final IBasicData iBasicData;
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
		this.iBasicData = new BasicData(checkProperties, descProperties);
	}

	/**
	 * @param nameElement
	 * @param checkProperties
	 * @param descProperties
	 */
	public ACharacterElement(K nameElement, IBasicData iBasicData) {
		this.nameElement = nameElement;
		this.iBasicData = iBasicData;
	}

	/**
	 * @param availableFeat
	 */
	protected void appendAvailableFeat(int availableFeat) {
		Integer availableFeats = 0;
		if (this.iBasicData.getDescProperty(AFeat.AVAILABLE_FEATS_KEY_NAME) != null) {
			availableFeats = (Integer) this.iBasicData.getDescProperty(AFeat.AVAILABLE_FEATS_KEY_NAME);
		}
		this.iBasicData.putDescProperty(AFeat.AVAILABLE_FEATS_KEY_NAME, availableFeats + availableFeat);
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
		if (this.iBasicData.containsDescProperty(this.getKeyName())) {
			throw new GeneralException("You has a " + this.getKeyName() + " Yet");
		}
		iBasicData.validAreAbilitiesSet();
	}

	/**
	 * 
	 */
	public void setElement() {
		this.preValidation();
		this.iBasicData.putDescProperty(this.getKeyName(), this);
	}

	@Override
	public String toString() {
		return this.getName().toString();
	}
}
