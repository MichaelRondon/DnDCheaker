package com.mfra.dnd.race;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.Ability;
import com.mfra.dnd.checker.AbilityManager;
import com.mfra.dnd.checker.Skill;
import com.mfra.dnd.language.Language;

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
	 * @param checkProperties
	 * @param descProperties
	 */
	public HalfOrc(RaceName raceName, HashMap<Enum<?>, ACheckeable> checkProperties,
			HashMap<String, Object> descProperties) {
		super(raceName, checkProperties, descProperties);
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
		AbilityManager abilityManager = new AbilityManager(iBasicData);
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
			iBasicData.removeCheckProperty(Skill.SkillName.LITERATE);
		}
		// TODO Auto-generated method stub

	}

}
