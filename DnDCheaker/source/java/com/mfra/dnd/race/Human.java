package com.mfra.dnd.race;

import java.util.HashSet;
import java.util.Set;

import com.mfra.dnd.checker.Skill;
import com.mfra.dnd.dndclass.ADnDClass;
import com.mfra.dnd.dndclass.ADnDClass.Level;
import com.mfra.dnd.language.Language;
import com.mfra.dnd.util.IBasicData;

/**
 * @author Michael Felipe Rond�n Acosta
 */
public class Human extends ARace {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param raceName
	 * @param iBasicData
	 */
	public Human(RaceName raceName, IBasicData iBasicData) {
		super(raceName, iBasicData);
		this.appendAvailableFeat(1);
	}

	@Override
	public Set<Language> getSetOfAutoLenguages() {
		Set<Language> hashSet = new HashSet<Language>();
		hashSet.add(Language.COMMON);
		return hashSet;
	}

	@Override
	public Set<Language> getSetOfBonusLenguages() {
		Set<Language> bonusLenguages = new HashSet<Language>();
		bonusLenguages.add(Language.ABYSSAL);
		bonusLenguages.add(Language.AQUAN);
		bonusLenguages.add(Language.AURAN);
		bonusLenguages.add(Language.CELESTIAL);
		bonusLenguages.add(Language.COMMON);
		bonusLenguages.add(Language.DRACONIC);
		bonusLenguages.add(Language.DRAGONS);
		bonusLenguages.add(Language.DWARVEN);
		bonusLenguages.add(Language.ELVEN);
		bonusLenguages.add(Language.GIANT);
		bonusLenguages.add(Language.GNOME);
		bonusLenguages.add(Language.GOBLIN);
		bonusLenguages.add(Language.GNOLL);
		bonusLenguages.add(Language.HALFLING);
		bonusLenguages.add(Language.IGNAN);
		bonusLenguages.add(Language.INFERNAL);
		bonusLenguages.add(Language.ORC);
		bonusLenguages.add(Language.SYLVAN);
		bonusLenguages.add(Language.TERRAN);
		bonusLenguages.add(Language.CREATURES);
		bonusLenguages.add(Language.UNDERCOMMON);

		return bonusLenguages;
	}

	@Override
	protected void updateAbilities() {
	}

	@Override
	protected void updateFeats() {
	}

	@Override
	protected void updateSkillPoints() {

		int skillPointsToAdd = 4;
		if (this.iBasicData.containsDescProperty(ADnDClass.KEY_NAME)) {
			ADnDClass dndClass = (ADnDClass) this.iBasicData.getDescProperty(ADnDClass.KEY_NAME);
			if (!dndClass.getLevel().equals(Level.FIRST)) {
				skillPointsToAdd = 1;
			}
		}

		Integer skillRanks = (Integer) this.iBasicData.getDescProperty(Skill.SKILL_POINTS);
		skillRanks += skillPointsToAdd;
		this.iBasicData.putDescProperty(Skill.SKILL_POINTS, skillRanks);
	}

}
