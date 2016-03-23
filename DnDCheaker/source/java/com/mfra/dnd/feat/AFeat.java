package com.mfra.dnd.feat;

import java.io.Serializable;
import java.util.Set;
import com.mfra.dnd.race.ACharacterElement;
import com.mfra.dnd.util.IBasicData;
import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 * @param <I>
 */
public abstract class AFeat<I> extends ACharacterElement<AFeat.FeatName> implements Serializable {

	/**
	 * @author Michael Felipe Rondón Acosta
	 */
	public enum FeatName {
		/**
		 * 
		 */
		ACROBATIC("", "+2 bonus on Jump and Tumble checks", Acrobatic.class),
		/**
		 * 
		 */
		MARTIAL_WEAPON_PROFICIENCY("", "Attack rolls with the selected weapon normally.", MartialWeaponProficiency.class);

		private String benefit;
		private Class<?> classTo;
		private String prerequisites;

		private FeatName(String prerequisites, String benefit, Class<?> classTo) {
			this.prerequisites = prerequisites;
			this.benefit = benefit;
			this.classTo = classTo;
		}

		/**
		 * @return benefit
		 */
		public String getBenefit() {
			return this.benefit;
		}

		/**
		 * @return class_
		 */
		public Class<?> getClassTo() {
			return this.classTo;
		}

		/**
		 * @return prerequisites
		 */
		public String getPrerequisites() {
			return this.prerequisites;
		}
	}

	/**
	 * 
	 */
	public static final String AVAILABLE_FEATS_KEY_NAME = "AvailableFeats";
	/**
	 * 
	 */
	public static final String KEY_NAME = "Feats";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param nameElement
	 * @param checkProperties
	 * @param descProperties
	 */
	public AFeat(FeatName nameElement, IBasicData iBasicData) {
		super(nameElement, iBasicData);
	}

	/**
	 * @param element
	 */
	protected abstract void addElement(I element);

	@Override
	public boolean equals(Object arg0) {
		boolean resp = false;
		if (arg0 instanceof AFeat) {
			resp = ((AFeat<?>) arg0).getName().equals(this.getName());
		}
		return resp;
	}

	/**
	 * @return KeyWords
	 */
	public abstract Set<I> getElements();

	@Override
	protected String getKeyName() {
		return KEY_NAME;
	}

	private Feats getMapOfFeats() {
		Feats feats = new Feats();
		if (!this.iBasicData.containsDescProperty(this.getKeyName())) {
			this.iBasicData.putDescProperty(this.getKeyName(), feats);
		} else {
			feats = (Feats) this.iBasicData.getDescProperty(this.getKeyName());
		}
		return feats;
	}

	/**
	 * @param element
	 */
	protected void preValidation(I element) {
		Integer availableFeats = (Integer) this.iBasicData.getDescProperty(AVAILABLE_FEATS_KEY_NAME);
		if (availableFeats < 1) {
			throw new GeneralException("You don't have enought Feat availables to learn.");
		}
		Feats feats = this.getMapOfFeats();
		if ((element == null) && feats.containsKey(this.getName())) {
			throw new GeneralException("You has a " + this.getKeyName() + " Yet");
		}
		iBasicData.validAreAbilitiesSet();
		iBasicData.validIsRaceSet();
		iBasicData.validIsClassSet();
		this.validPrerequisites();
	}

	/**
	 * 
	 */
	protected abstract void setBenefits();

	/**
	 * 
	 */
	@Override
	public void setElement() {
		this.setElement(null, false);
	}

	/**
	 * @param element
	 * @param internal
	 */
	public void setElement(I element, boolean internal) {
		if (!internal) {
			this.preValidation(element);
		}
		Feats feats = this.getMapOfFeats();
		if (!feats.containsKey(this.getName())) {
			this.addElement(element);
			feats.put(this.getName(), this);
		} else {
			@SuppressWarnings("unchecked")
			AFeat<Object> aFeat = feats.get(this.getName());
			if (aFeat.getElements().contains(element)) {
				throw new GeneralException("You has a " + element + " Yet");
			}
			aFeat.addElement(element);
		}
		this.iBasicData.putDescProperty(this.getKeyName(), feats);

		if (!internal) {
			Integer availableFeats = (Integer) this.iBasicData.getDescProperty(AVAILABLE_FEATS_KEY_NAME);
			--availableFeats;
			this.iBasicData.putDescProperty(AVAILABLE_FEATS_KEY_NAME, availableFeats);
		}
	}

	@Override
	public String toString() {
		return this.getElements().toString();
	}

	/**
	 * 
	 */
	protected abstract void validPrerequisites();
}
