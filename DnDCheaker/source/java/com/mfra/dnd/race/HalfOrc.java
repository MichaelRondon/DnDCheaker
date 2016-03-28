package com.mfra.dnd.race;

import java.util.HashSet;
import java.util.Set;

import com.mfra.dnd.checker.Ability;
import com.mfra.dnd.checker.AbilityManager;
import com.mfra.dnd.checker.Skill;
import com.mfra.dnd.language.Language;
import com.mfra.dnd.util.IBasicData;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class HalfOrc extends ARace {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param raceName
	 * @param iBasicData
	 */
	public HalfOrc(RaceName raceName, IBasicData iBasicData) {
		super(raceName, iBasicData);
	}

	@Override
	public Set<Language> getSetOfAutoLenguages() {
		Set<Language> hashSet = new HashSet<Language>();
		hashSet.add(Language.COMMON);
		return hashSet;
	}

	@Override
	public Set<Language> getSetOfBonusLenguages() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void updateAbilities() {
		AbilityManager abilityManager = new AbilityManager(this.iBasicData);
		abilityManager.addToAbility(Ability.AbilityName.STRENGTH, 2);
		abilityManager.addToAbility(Ability.AbilityName.CHARISMA, -2);
		abilityManager.addToAbility(Ability.AbilityName.INTELLIGENCE, -2);
		abilityManager.adjustMinIntelligence();
	}

	@Override
	protected void updateFeats() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void updateSkillPoints() {
		if (this.iBasicData.containsCheckProperty(Skill.SkillName.LITERATE)) {
			this.iBasicData.removeCheckProperty(Skill.SkillName.LITERATE);
		}
		// TODO Auto-generated method stub

	}

}
