package com.mfra.dnd.checker;

import java.math.BigDecimal;
import com.mfra.dnd.util.IBasicData;
import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class Skill extends ACheckeable {

	/**
	 * 
	 */
	public enum SkillName {
		/**
		 * 
		 */
		APPRAISE(Ability.AbilityName.INTELLIGENCE, true),
		/**
		 * 
		 */
		CONCENTRATION(Ability.AbilityName.CONSTITUTION, true),
		/**
		 * 
		 */
		CRAFT(Ability.AbilityName.INTELLIGENCE, true),
		/**
		 * 
		 */
		DIPLOMACY(Ability.AbilityName.CHARISMA, true),
		/**
		 * 
		 */
		HANDLE_ANIMAL(Ability.AbilityName.CHARISMA, false),
		/**
		 * 
		 */
		HEAL(Ability.AbilityName.WISDOM, true),
		/**
		 * 
		 */
		KNOWLEDGE_NATURE(Ability.AbilityName.INTELLIGENCE, false),
		/**
		 * 
		 */
		LISTEN(Ability.AbilityName.WISDOM, true),
		/**
		 * 
		 */
		LITERATE(Ability.AbilityName.INTELLIGENCE, false),
		/**
		 * 
		 */
		PROFESSION(Ability.AbilityName.WISDOM, false),
		/**
		 * 
		 */
		RIDE(Ability.AbilityName.DEXTERITY, true),
		/**
		 * 
		 */
		SEARCH(Ability.AbilityName.INTELLIGENCE, true),
		/**
		 * 
		 */
		SPELLCRAFT(Ability.AbilityName.INTELLIGENCE, false),
		/**
		 * 
		 */
		SPOT(Ability.AbilityName.WISDOM, true),
		/**
		 * 
		 */
		SURVIVAL(Ability.AbilityName.WISDOM, true),
		/**
		 * 
		 */
		SWIM(Ability.AbilityName.STRENGTH, true);

		private Ability.AbilityName abilityName;
		private boolean untrained;

		private SkillName(Ability.AbilityName abilityName, boolean untrained) {
			this.abilityName = abilityName;
			this.untrained = untrained;
		}

		/**
		 * @return abilityName
		 */
		public Ability.AbilityName getAbilityName() {
			return this.abilityName;
		}

		/**
		 * @return untrained
		 */
		public boolean isUntrained() {
			return this.untrained;
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	public static final String SKILL_POINTS = "SKILL_POINTS";

	private int racialModifier;

	private BigDecimal skillRanks = new BigDecimal(0);

	/**
	 * @param name
	 * @param checkProperties
	 */
	public Skill(SkillName name, IBasicData iBasicData) {
		super(name, iBasicData, name.getAbilityName());
	}

	/**
	 * @param skillPointsToAdd
	 */
	public void addSkillRanks(BigDecimal skillPointsToAdd) {
		this.skillRanks = this.skillRanks.add(skillPointsToAdd);
	}

	/**
	 * 
	 */
	@Override
	public void check(String characterName, Integer difficultyClass, int aditionalModifier) {
		if (!((Skill.SkillName) this.getName()).untrained && (this.skillRanks.intValue() <= 0)) {
			throw new GeneralException("This Skill isn't untrained");
		}
		// return super.check(characterName, difficultyClass,
		// aditionalModifier);
	}

	@Override
	protected String getFormat() {
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("%-16s\t%2.1f\t\t%d\t\t%d\t\t%d\t\t%-12s\t%-4s");
		stringBuilder.append(System.getProperty("line.separator"));
		return stringBuilder.toString();
	}

	@Override
	public String getHeader() {
		return "Name\t\t\tSkillRanks\tAbilityModifier\tRacialModifier\tTotalModifier\tAbilityName\tUntrained";
	}

	@Override
	public int getModifier() {
		return this.getAbilityModifier() + this.skillRanks.intValue() + this.getRacialModifier();
	}

	private int getRacialModifier() {
		return racialModifier;
	}

	/**
	 * @return skillPoints
	 */
	public BigDecimal getSkillRanks() {
		return this.skillRanks;
	}

	/**
	 * 
	 * @param racialModifier
	 */
	public void setRacialModifier(int racialModifier) {
		this.racialModifier = racialModifier;
	}

	@Override
	public String toString() {
		String line = String.format(this.getFormat(), this.getName(), this.getSkillRanks().doubleValue(),
				this.getAbilityModifier(), this.getRacialModifier(), this.getModifier(),
				((SkillName) this.getName()).abilityName, ((SkillName) this.getName()).untrained);
		return line;
	}

}
