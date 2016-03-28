package com.mfra.dnd.manager;

import java.math.BigDecimal;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.Skill;
import com.mfra.dnd.dndclass.ADnDClass;
import com.mfra.dnd.dndclass.ADnDClass.Level;
import com.mfra.dnd.language.Language;
import com.mfra.dnd.language.LanguagesManager;
import com.mfra.dnd.util.IBasicData;
import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class SkillManager extends ACheckManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param iBasicData
	 */
	public SkillManager(IBasicData iBasicData) {
		super(iBasicData);
		this.init();
	}

	@Override
	public void init() {
		this.insertEmptySkill(Skill.SkillName.LITERATE);
		ACheckeable property = this.getProperty(Skill.SkillName.LITERATE);
		((Skill) property).addSkillRanks(new BigDecimal(1));
	}

	/**
	 * 
	 * @param skillName
	 * @param racialModifier
	 */
	public void setRacialModifier(Skill.SkillName skillName, int racialModifier) {
		if (this.isNotSetSkill(skillName)) {
			this.insertEmptySkill(skillName);
		}
		Skill skill = (Skill) this.getProperty(skillName);
		skill.setRacialModifier(racialModifier);
	}

	/**
	 * @param points
	 * @param skillName
	 * @param iBasicData
	 */
	public void usePoints(int points, Skill.SkillName skillName, IBasicData iBasicData) {
		this.prevalidation();
		this.validHasEnoughtSkillPoints(points);
		if (this.isNotSetSkill(skillName)) {
			this.insertEmptySkill(skillName);
		}
		this.validLimitOfSkillForLevel(points, skillName);
		this.addToSkill(points, skillName);// reduce Skill
											// Points
	}

	/**
	 * @param language
	 */
	public void usePoints(Language language) {
		this.prevalidation();
		this.validHasEnoughtSkillPoints(1);
		LanguagesManager languagesManager = (LanguagesManager) iBasicData
				.getDescProperty(LanguagesManager.LanguagesManagerName.LANGUAGES.toString());
		languagesManager.addLanguage(language);
	}

	private void addToSkill(int points, Skill.SkillName skillName) {
		BigDecimal skillRanksToAdd;
		if (this.isClassSkill(skillName)) {
			skillRanksToAdd = new BigDecimal(points);
		} else {
			skillRanksToAdd = new BigDecimal(points).divide(new BigDecimal(2));
		}
		ACheckeable property = this.getProperty(skillName);
		((Skill) property).addSkillRanks(skillRanksToAdd);

		Integer skillPoints = (Integer) iBasicData.getDescProperty(Skill.SKILL_POINTS);
		skillPoints -= points;
		iBasicData.putDescProperty(Skill.SKILL_POINTS, skillPoints);
	}

	private void insertEmptySkill(Skill.SkillName skillName) {
		Skill skill = new Skill(skillName, this.iBasicData);
		this.setProperty(skill);
	}

	private boolean isClassSkill(Skill.SkillName skillName) {
		Object object = iBasicData.getDescProperty(ADnDClass.KEY_NAME);
		return ((ADnDClass) object).isClassSkill(skillName);
	}

	private boolean isNotSetSkill(Skill.SkillName skillName) {
		return !this.iBasicData.containsCheckProperty(skillName);
	}

	/**
	 * @param descProperties
	 */
	private void prevalidation() {
		this.iBasicData.validAreAbilitiesSet();
		this.iBasicData.validIsRaceSet();
		this.iBasicData.validIsClassSet();
	}

	/**
	 * @param points
	 * @param descProperties
	 */
	private void validHasEnoughtSkillPoints(int points) {
		Integer skillPoints = (Integer) iBasicData.getDescProperty(Skill.SKILL_POINTS);
		if (points > skillPoints || points < 0) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("You don't have enought Skill Points.");
			stringBuilder.append("Your current Skill Points are ");
			stringBuilder.append(skillPoints);
			throw new GeneralException(stringBuilder.toString());
		}
	}

	private void validLimitOfSkillForLevel(int skillPoints, Skill.SkillName skillName) {
		ACheckeable property = this.getProperty(skillName);
		BigDecimal currentSkillRanks = ((Skill) property).getSkillRanks();
		Object object = iBasicData.getDescProperty(ADnDClass.KEY_NAME);
		Level level = ((ADnDClass) object).getLevel();
		BigDecimal testSkillranks;
		BigDecimal maxSkillRanks;

		if (this.isClassSkill(skillName)) {
			testSkillranks = currentSkillRanks.add(new BigDecimal(skillPoints));
			maxSkillRanks = new BigDecimal(level.getMaxClassSkillRanks());
		} else {
			testSkillranks = currentSkillRanks.add(new BigDecimal(skillPoints).divide(new BigDecimal(2)));
			maxSkillRanks = level.getMaxNOClassSkillRanks();
		}

		if (testSkillranks.compareTo(maxSkillRanks) == 1) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("You can't add this ");
			stringBuilder.append(skillPoints);
			stringBuilder.append(" skillPoints to the skill");
			stringBuilder.append(skillName);
			stringBuilder.append(". Your current SkillRanks are");
			stringBuilder.append(currentSkillRanks);
			stringBuilder.append(". Your max SkillRanks are");
			stringBuilder.append(maxSkillRanks);
			throw new GeneralException(stringBuilder.toString());
		}
	}

}
