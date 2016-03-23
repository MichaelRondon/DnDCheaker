package com.mfra.dnd.race;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Set;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.language.Language;
import com.mfra.dnd.manager.SkillManager;
import com.mfra.dnd.util.DnDUtil;

/**
 * @author Michael Felipe Rondón Acosta
 */
public abstract class ARace extends ACharacterElement<ARace.RaceName> implements IRacesClases {

	/**
	 * @author Michael Felipe Rondón Acosta
	 */
	public enum RaceName {
		/**
		* 
		*/
		ELF(Elf.class, 0, DnDUtil.getInstance().feetToMeters(30)),
		/**
		 * 
		 */
		HALF_ORC(HalfOrc.class, 0, DnDUtil.getInstance().feetToMeters(30)),
		/**
		 * 
		 */
		HUMAN(Human.class, 0, DnDUtil.getInstance().feetToMeters(30));

		private BigDecimal baseLandSpeed;
		private Class<?> classTo;
		private int sizeModifier;

		/**
		 * @param classTo
		 */
		private RaceName(Class<?> classTo, int sizeModifier, BigDecimal baseLandSpeed) {
			this.classTo = classTo;
			this.baseLandSpeed = baseLandSpeed;
		}

		/**
		 * @return baseLandSpeed
		 */
		public BigDecimal getBaseLandSpeed() {
			return this.baseLandSpeed;
		}

		/**
		 * @return class_
		 */
		public Class<?> getClassTo() {
			return this.classTo;
		}

		/**
		 * @return sizeModifier
		 */
		public int getSizeModifier() {
			return this.sizeModifier;
		}

	}

	/**
	 * 
	 */
	public static final String KEY_NAME = "RACE";

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	public static final String SPECIALS_RACE_KEY = "SPECCIALS_RACE";

	/**
	 * 
	 */
	protected final SkillManager skillManager;

	/**
	 * @param raceName
	 * @param checkProperties
	 * @param descProperties
	 */
	public ARace(RaceName raceName, HashMap<Enum<?>, ACheckeable> checkProperties,
			HashMap<String, Object> descProperties) {
		super(raceName, checkProperties, descProperties);
		skillManager = new SkillManager(checkProperties);
	}

	@Override
	public String getKeyName() {
		return KEY_NAME;
	}

	/**
	 * @return SetOfLenguages
	 */
	public abstract Set<Language> getSetOfAutoLenguages();

	/**
	 * 
	 */
	@Override
	public void setElement() {
		super.setElement();
		this.updateAbilities();
		this.updateSkillPoints();
		this.updateFeats();
	}

	/**
	 * @param specialsSet
	 */
	protected void setSpecials(Set<String> specialsSet) {
		this.descProperties.put(SPECIALS_RACE_KEY, specialsSet);
	}

	/**
	 * 
	 */
	protected abstract void updateAbilities();

	/**
	 * 
	 */
	protected abstract void updateFeats();

	/**
	 * 
	 */
	protected abstract void updateSkillPoints();
}
