package com.mfra.dnd.language;

import java.util.HashSet;
import java.util.Set;

import com.mfra.dnd.checker.Ability;
import com.mfra.dnd.checker.Skill;
import com.mfra.dnd.dndclass.ADnDClass;
import com.mfra.dnd.race.ACharacterElement;
import com.mfra.dnd.race.ARace;
import com.mfra.dnd.util.IBasicData;
import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class LanguagesManager extends ACharacterElement<LanguagesManager.LanguagesManagerName> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int bonusLanguagesPoints = -1;
	private final Set<Language> languages = new HashSet<Language>();

	/**
	 * @param nameElement
	 * @param iBasicData
	 */
	public LanguagesManager(LanguagesManagerName nameElement, IBasicData iBasicData) {
		super(nameElement, iBasicData);
	}

	/**
	 * @param language
	 */
	public void addBonusLanguage(Language language) {
		if (language != null && this.bonusLanguagesPoints > 0
				&& (((ADnDClass) this.iBasicData.getDescProperty(ADnDClass.KEY_NAME)).getSetOfBonusLenguages()
						.contains(language)
						|| ((ARace) this.iBasicData.getDescProperty(ARace.KEY_NAME)).getSetOfBonusLenguages()
								.contains(language))) {
			this.languages.add(language);
			--this.bonusLanguagesPoints;
		} else {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("You can't learn this Language: ");
			stringBuilder.append(language);
			throw new GeneralException(stringBuilder.toString());
		}

	}

	/**
	 * @param language
	 */
	public void addLanguage(Language language) {
		this.iBasicData.validIsClassSet();
		if (language.equals(Language.DRUIDIC) && !((ADnDClass) this.iBasicData.getDescProperty(ADnDClass.KEY_NAME))
				.getName().equals(ADnDClass.DnDClassName.DRUID)) {
			throw new GeneralException("This Language is restricted");
		}

		this.languages.add(language);
		Integer skillPoints = (Integer) this.iBasicData.getDescProperty(Skill.SKILL_POINTS);
		skillPoints -= 1;
		this.iBasicData.putDescProperty(Skill.SKILL_POINTS, skillPoints);

	}

	@Override
	public void setElement() {
		super.setElement();
		this.addAutoLanguages();
		this.bonusLanguagesPoints = ((Ability) this.iBasicData.getCheckProperty(Ability.AbilityName.INTELLIGENCE))
				.getAbilityModifier();
	}

	@Override
	public String toString() {
		return this.languages.toString();
	}

	private void addAutoLanguages() {
		Set<Language> setOfAutoLenguages = ((ARace) this.iBasicData.getDescProperty(ARace.KEY_NAME))
				.getSetOfAutoLenguages();
		this.languages.addAll(setOfAutoLenguages);
	}

	@Override
	protected String getKeyName() {
		return LanguagesManagerName.LANGUAGES.toString();
	}

	/**
	 * 
	 */
	@Override
	protected void preValidation() {
		super.preValidation();
		this.iBasicData.validIsClassSet();
		this.iBasicData.validIsRaceSet();
	}

	/**
	 * @author Michael Felipe Rondón Acosta
	 */
	public enum LanguagesManagerName {
		/**
		* 
		*/
		LANGUAGES
	}
}
