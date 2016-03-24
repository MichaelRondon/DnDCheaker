package com.mfra.dnd.dndclass;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import com.mfra.dice.Dice;
import com.mfra.dice.IDice;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.Ability;
import com.mfra.dnd.checker.Skill;
import com.mfra.dnd.checker.Skill.SkillName;
import com.mfra.dnd.race.ACharacterElement;
import com.mfra.dnd.race.IRacesClases;
import com.mfra.dnd.util.CoinsBuilder;
import com.mfra.dnd.util.DnDUtil;

/**
 * @author Michael Felipe Rondón Acosta
 */
public abstract class ADnDClass extends ACharacterElement<ADnDClass.DnDClassName>
		implements IRacesClases, Serializable {

	/**
	 * @author Michael Felipe Rondón Acosta
	 */
	public enum AttackBonusTypes {
		/**
		 * 
		 */
		AVERAGE,
		/**
		 * 
		 */
		GOOD,
		/**
		 * 
		 */
		POOR;
	}

	/**
	 * @author Michael Felipe Rondón Acosta
	 */
	public enum DnDClassName {
		/**
		 * 
		 */
		DRUID(4, Druid.class, 2, 8, AttackBonusTypes.AVERAGE, true),
		/**
		 * 
		 */
		MONK(4, Monk.class, -1, 8, AttackBonusTypes.AVERAGE, true);

		private AttackBonusTypes baseAttackBonusType;
		private int baseHitPoints;
		private int baseRndmStrtCoins;
		private boolean baseSaveBonusPoor;
		private int baseSkillPoints;
		private Class<?> classTo;

		private DnDClassName(int baseSkillPoints, Class<?> classTo, int baseRndmStrtCoins, int baseHitPoints,
				AttackBonusTypes baseAttackBonusType, boolean baseSaveBonusPoor) {
			this.baseSkillPoints = baseSkillPoints;
			this.classTo = classTo;
			this.baseRndmStrtCoins = baseRndmStrtCoins;
			this.baseHitPoints = baseHitPoints;
			this.baseAttackBonusType = baseAttackBonusType;
			this.baseSaveBonusPoor = baseSaveBonusPoor;
		}

		/**
		 * @return baseAttackBonus
		 */
		public AttackBonusTypes getBaseAttackBonusType() {
			return this.baseAttackBonusType;
		}

		/**
		 * @return baseHitPoints
		 */
		public int getBaseHitPoints() {
			return this.baseHitPoints;
		}

		/**
		 * @return baseRndmStrtCoins
		 */
		public int getBaseRndmStrtCoins() {
			return this.baseRndmStrtCoins;
		}

		/**
		 * @return baseSkillPoints
		 */
		public int getBaseSkillPoints() {
			return this.baseSkillPoints;
		}

		/**
		 * @return classTo
		 */
		public Class<?> getClassTo() {
			return this.classTo;
		}

		/**
		 * @return baseSaveBonusPoor
		 */
		public boolean isBaseSaveBonusPoor() {
			return baseSaveBonusPoor;
		}

	}

	/**
	 * @author Michael Felipe Rondón Acosta
	 */
	public enum Level {
		/**
		* 
		*/
		FIRST(1),
		/**
		 * 
		 */
		TWENTY(20);

		private int level;

		private Level(int level) {
			this.level = level;
		}

		/**
		 * @param array
		 * @return adjustArray
		 */
		private int[] adjustArray(int[] array) {
			int[] resp = new int[1];
			for (int i = array.length - 1; i > 0; i--) {
				if (array[i] > 0) {
					resp = new int[i + 1];
					break;
				}
			}
			for (int i = 0; i < resp.length; i++) {
				resp[i] = array[i];
			}
			return resp;
		}

		/**
		 * 
		 * @return AbilityScoreInreses
		 */
		public int getAbilityScoreIncreses(int currentAbilityScoreIncr) {
			if (this.level % 4 == 0) {
				currentAbilityScoreIncr += 1;
			}
			return currentAbilityScoreIncr;
		}

		/**
		 * @return BaseAttackBonusGood
		 */
		private int[] getBaseAttackBonusAverage() {
			int[] resp = new int[] { 0, 0, 0, 0 };
			int addPenalty = (this.getLevel() - 1) >> 2;
			resp[0] = this.getLevel() - 1 - addPenalty;
			resp[1] = resp[0] - 5;
			resp[1] = resp[1] < 0 ? 0 : resp[1];
			resp[2] = resp[1] - 5;
			resp[2] = resp[2] < 0 ? 0 : resp[2];
			return adjustArray(resp);
		}

		/**
		 * @return BaseAttackBonusGood
		 */
		private int[] getBaseAttackBonusGood() {
			int[] resp = new int[] { 0, 0, 0, 0 };
			resp[0] = this.getLevel();
			resp[1] = this.getLevel() - 5;
			resp[1] = resp[1] < 0 ? 0 : resp[1];
			resp[2] = this.getLevel() - 10;
			resp[2] = resp[2] < 0 ? 0 : resp[2];
			resp[3] = this.getLevel() - 15;
			resp[3] = resp[3] < 0 ? 0 : resp[3];
			return adjustArray(resp);
		}

		/**
		 * @return BaseAttackBonusPoor
		 */
		private int[] getBaseAttackBonusPoor() {
			int[] resp = new int[] { 0, 0, 0, 0 };
			resp[0] = this.getLevel() >> 1;
			resp[1] = resp[0] - 5;
			resp[1] = resp[1] < 0 ? 0 : resp[1];
			return adjustArray(resp);
		}

		/**
		 * @return BaseSaveBonusGood
		 */
		private int getBaseSaveBonusGood() {
			return (this.getLevel() >> 1) + 2;
		}

		/**
		 * @return BaseSaveBonusGood
		 */
		private int getBaseSaveBonusPoor() {
			return this.getLevel() / 3;
		}

		/**
		 * @return level
		 */
		public int getLevel() {
			return level;
		}

		/**
		 * @return maxClassSkillPoints
		 */
		public int getMaxClassSkillRanks() {
			return this.getLevel() + 3;
		}

		/**
		 * @return maxNOClassSkillPoints
		 */
		public BigDecimal getMaxNOClassSkillRanks() {
			return (new BigDecimal(getMaxClassSkillRanks())).divide(new BigDecimal(2));
		}

		/**
		 * @return RequiredXP
		 */
		public int getNextRequiredXP() {
			return getRequiredXP(this.level + 1);
		}

		/**
		 * @return RequiredXP
		 */
		public int getRequiredXP() {
			return getRequiredXP(this.level);
		}

		private int getRequiredXP(int level) {
			int resp;
			if (level == 0) {
				resp = 0;
			} else {
				resp = (level - 1) * 1000 + getRequiredXP(level - 1);
			}
			return resp;
		}

	}

	/**
	 * 
	 */
	public static final String KEY_NAME = "DnDClass";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Level level = Level.FIRST;

	private int xPPoints = 0;

	/**
	 * @param dnDClassName
	 * @param checkProperties
	 * @param descProperties
	 */
	public ADnDClass(DnDClassName dnDClassName, HashMap<Enum<?>, ACheckeable> checkProperties,
			HashMap<String, Object> descProperties) {
		super(dnDClassName, checkProperties, descProperties);
	}

	public void addXPPoints(int xpToAdd) {
		xPPoints += xpToAdd;
		if (xPPoints >= this.getLevel().getNextRequiredXP()) {
			// TODO
			System.out.println("New level");
		}
	}

	/**
	 * @return BaseAttackBonus
	 */
	public int[] getBaseAttackBonus() {
		int[] resp;
		if (this.getName().getBaseAttackBonusType().equals(AttackBonusTypes.POOR)) {
			resp = this.getLevel().getBaseAttackBonusPoor();
		} else if (this.getName().getBaseAttackBonusType().equals(AttackBonusTypes.AVERAGE)) {
			resp = this.getLevel().getBaseAttackBonusAverage();
		} else {
			resp = this.getLevel().getBaseAttackBonusGood();
		}
		return resp;
	}

	/**
	 * @return baseSavingThrow
	 */
	public int getBaseSavingThrow() {
		int resp;
		if (this.getName().isBaseSaveBonusPoor()) {
			resp = this.getLevel().getBaseSaveBonusPoor();
		} else {
			resp = this.getLevel().getBaseSaveBonusGood();
		}
		return resp;
	}

	/**
	 * @return List<Skill>
	 */
	protected abstract List<SkillName> getClassSkills();

	@Override
	protected String getKeyName() {
		return KEY_NAME;
	}

	/**
	 * @return level
	 */
	public Level getLevel() {
		return this.level;
	}

	/**
	 * @return CoinsBuilder
	 */
	public CoinsBuilder getRamdomCoins() {
		DnDClassName dnDClassName = this.getName();
		CoinsBuilder coinsBuilder = new CoinsBuilder();
		StringBuilder stringBuilder = new StringBuilder();
		if (!dnDClassName.equals(DnDClassName.MONK)) {
			IDice d4 = Dice.getDice(4);
			IDice rollDice = d4.rollDice(null, dnDClassName.baseRndmStrtCoins, 0);
			coinsBuilder.setGold(rollDice.getLastValue() * 10);

			stringBuilder.append("To get a Random Starting Coins: ");
			stringBuilder.append(rollDice.getStringFromBuilder());
			stringBuilder.append("\t The result was ");
			stringBuilder.append(coinsBuilder);
			stringBuilder.append("gp");

		} else {
			coinsBuilder.setGold(12);
			coinsBuilder.setSilver(5);

			stringBuilder.append("To get a Random Starting Coins: ");
			stringBuilder.append(12);
			stringBuilder.append("gp and ");
			stringBuilder.append(5);
			stringBuilder.append("sp and ");
		}
		System.out.println(stringBuilder);
		return coinsBuilder;
	}

	public int getXPPoints() {
		return xPPoints;
	}

	/**
	 * @param skillName
	 * @return this.getClassSkills().contains(skillName)
	 */
	public boolean isClassSkill(SkillName skillName) {
		return this.getClassSkills().contains(skillName);
	}

	/**
	 * 
	 */
	@Override
	protected void preValidation() {
		super.preValidation();
		// Util.getInstance().validIsClassSet(this.descProperties);

	}

	/**
	 * 
	 */
	@Override
	public void setElement() {
		super.setElement();

		this.appendAvailableFeat(1);

		this.updateSkillPoints();

	}

	/**
	 * @param level
	 */
	public void setLevel(Level level) {
		this.level = level;
	}

	/**
	 * 
	 */
	public void showClassSkill() {
		StringBuilder stringBuilder = new StringBuilder();
		List<SkillName> classSkills = this.getClassSkills();
		stringBuilder.append("ClassSkills for ");
		stringBuilder.append(this.getName());
		stringBuilder.append(":\t");
		for (SkillName skillName : classSkills) {
			stringBuilder.append(skillName);
			stringBuilder.append(',');
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		System.out.println(stringBuilder.toString());
	}

	@Override
	public String toString() {

		return DnDUtil.getInstance().simpleConcat(super.toString(), " Level:", this.getLevel().level, " (",
				this.getXPPoints(), "/", this.getLevel().getNextRequiredXP(), ")");
	}

	/**
	 * 
	 */
	protected void updateSkillPoints() {
		ACheckeable aCheckeable = this.iBasicData.getCheckProperty(Ability.AbilityName.INTELLIGENCE);
		int baseSkillPoints = this.getName().getBaseSkillPoints();
		int skillPointsToAdd = (aCheckeable.getModifier() + baseSkillPoints);

		if (this.level.equals(Level.FIRST)) {
			skillPointsToAdd = (skillPointsToAdd * 4);
		}
		Integer skillPoints = (Integer) this.iBasicData.getDescProperty(Skill.SKILL_POINTS);
		skillPoints += skillPointsToAdd;
		this.iBasicData.putDescProperty(Skill.SKILL_POINTS, skillPoints);
	}

}
