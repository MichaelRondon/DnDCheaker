package com.mfra.dnd.race;

import java.io.Serializable;

import com.mfra.dnd.feat.AFeat;
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
	private final K nameElement;
	/**
	 * 
	 */
	protected final IBasicData iBasicData;

	/**
	 * @param nameElement
	 * @param iBasicData
	 */
	public ACharacterElement(K nameElement, IBasicData iBasicData) {
		this.nameElement = nameElement;
		this.iBasicData = iBasicData;
	}

	/**
	 * @return nameElement
	 */
	public K getName() {
		return this.nameElement;
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
	 * 
	 */
	protected void preValidation() {
		if (this.iBasicData.containsDescProperty(this.getKeyName())) {
			throw new GeneralException("You has a " + this.getKeyName() + " Yet");
		}
		this.iBasicData.validAreAbilitiesSet();
	}
}
