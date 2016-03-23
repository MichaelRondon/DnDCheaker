package com.mfra.dnd.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.mfra.dice.Dice;
import com.mfra.dice.IDice;
import com.mfra.dice.StringBuilderWriter;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.Ability;
import com.mfra.dnd.checker.Ability.AbilityName;
import com.mfra.dnd.dndclass.ADnDClass;
import com.mfra.dnd.race.ARace;
import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class DnDUtil extends StringBuilderWriter {

	private static class LazyHolder { // $codepro.audit.disable

		// missingStaticMethod

		private static final DnDUtil INSTANCE = new DnDUtil();
	}

	private static final BigDecimal FEET_TO_METER_CONSTANT = new BigDecimal("0.3048");

	private static final BigDecimal POUNDS_TO_KG = new BigDecimal("0.453592");

	/**
	 * @return Util
	 */
	public static DnDUtil getInstance() {
		return LazyHolder.INSTANCE;
	}

	private DnDUtil() {

	}

	/**
	 * @param feets
	 * @return bigDecimal.multiply(FEET_TO_METER_CONSTANT);
	 */
	public BigDecimal feetToMeters(int feets) {
		BigDecimal bigDecimal = new BigDecimal(feets);
		return bigDecimal.multiply(FEET_TO_METER_CONSTANT);

	}

	/**
	 * @param hero
	 */
	public void generateAbilityRamdomScores(boolean hero) {

		int result;
		int highest = -1;
		int sumModifier = -1;

		while ((highest <= 13) && (sumModifier <= 0)) {
			this.stringBuilder = new StringBuilder();
			this.stringBuilder.append("Checks for ramdom ability scores. The results were:");
			for (int i = 0; i < 6; i++) {
				if (i != 0) {
					this.stringBuilder.append('-');
				}
				result = this.getAbilityRamdomScore(hero);
				this.stringBuilder.append(result);
				sumModifier += Ability.getAbilityModifier(result);
				highest = (result >= highest) ? result : highest;
			}
			if (!hero) {
				break;
			}

		}

		System.out.println(this.stringBuilder.toString());
	}

	private Integer getAbilityRamdomScore(boolean hero) {
		int sum = 0;
		List<Integer> results = new ArrayList<Integer>();
		IDice dice = Dice.getDice(6);
		Integer lower = 19;
		int roll;
		this.stringBuilder.append('(');
		int dices = (hero) ? 4 : 3;
		for (int i = 0; i < dices; i++) {
			roll = dice.rollDice(null, 1, 0).getLastValue();
			if (i != 0) {
				this.stringBuilder.append(',');
			}
			lower = (roll < lower) ? roll : lower;
			this.stringBuilder.append(roll);
			results.add(roll);
		}
		this.stringBuilder.append(')');
		if (hero) {
			results.remove(results.indexOf(lower));
		}
		for (Integer integer : results) {
			sum += integer;
		}

		return sum;
	}

	/**
	 * @return DecimalFormat("#########.#")
	 */
	public DecimalFormat getDecimalFormat() {
		return new DecimalFormat("#########.#");
	}

	/**
	 * 
	 * @param array
	 * @return intArrayToString
	 */
	public String intArrayToString(int[] array) {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i : array) {
			stringBuilder.append(i);
			stringBuilder.append('/');
		}
		stringBuilder.deleteCharAt(stringBuilder.length() - 1);
		return stringBuilder.toString();
	}

	/**
	 * @param pounds
	 * @return bigDecimal.multiply(POUNDS_TO_KG);
	 */
	public BigDecimal pundsToKilograms(BigDecimal pounds) {
		BigDecimal bigDecimal = pounds;
		return bigDecimal.multiply(POUNDS_TO_KG);

	}

	/**
	 * @param pounds
	 * @return bigDecimal.multiply(POUNDS_TO_KG);
	 */
	public BigDecimal pundsToKilograms(int pounds) {
		BigDecimal bigDecimal = new BigDecimal(pounds);
		return bigDecimal.multiply(POUNDS_TO_KG);

	}

	/**
	 * @param args
	 *            Texto a concatenar.
	 * @return Concatena dos textos.
	 */
	@Deprecated
	public String simpleConcat(Object... args) {
		StringBuilder stringBuilder = new StringBuilder();
		for (Object object : args) {
			if (object != null) {
				stringBuilder.append(object);
			}
		}
		return stringBuilder.toString();

	}

	/**
	 * @param checkProperties
	 */
	@Deprecated
	public void validAreAbilitiesSet(HashMap<Enum<?>, ACheckeable> checkProperties) {

		AbilityName[] values = AbilityName.values();
		for (AbilityName abilityName : values) {
			ACheckeable aCheckeable = checkProperties.get(abilityName);
			if (((Ability) aCheckeable).getValue() == 0) {
				throw new GeneralException("You must set the abilities first");
			}
		}
	}

	/**
	 * @param descProperties
	 */
	@Deprecated
	public void validIsClassSet(HashMap<String, Object> descProperties) {
		if (!descProperties.containsKey(ADnDClass.KEY_NAME)) {
			throw new GeneralException("You must set the class first");
		}
	}

	/**
	 * @param descProperties
	 */
	@Deprecated
	public void validIsRaceSet(HashMap<String, Object> descProperties) {
		if (!descProperties.containsKey(ARace.KEY_NAME)) {
			throw new GeneralException("You must set the race first");
		}
	}

	@Deprecated
	public boolean wasCreated(HashMap<String, Object> descProperties) {
		boolean resp = false;
		if ((descProperties != null) && (descProperties.containsKey(DescProperty.CREATED.toString()))) {
			Object object = descProperties.get(DescProperty.CREATED.toString());
			if (object instanceof Boolean) {
				resp = (Boolean) object;
			}
		}
		return resp;
	}

}
