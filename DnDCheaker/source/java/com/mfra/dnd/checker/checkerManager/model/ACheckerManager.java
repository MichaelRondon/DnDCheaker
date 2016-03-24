package com.mfra.dnd.checker.checkerManager.model;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.checkerManager.Action;
import com.mfra.dnd.race.ACharacterElement;

/**
 * @author Michael Felipe Rondón Acosta
 */
public abstract class ACheckerManager extends ACharacterElement<Action> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Set<RangeMessageBase> ranges = new HashSet<RangeMessageBase>();

	/**
	 * @param nameElement
	 * @param checkProperties
	 * @param descProperties
	 */
	public ACheckerManager(Action nameElement, HashMap<Enum<?>, ACheckeable> checkProperties,
			HashMap<String, Object> descProperties) {
		super(nameElement, checkProperties, descProperties);
	}

	/**
	 * @param minValue
	 * @param maxValue
	 * @param message
	 */
	protected void addRange(Integer minValue, Integer maxValue, String message) {
		ranges.add(new RangeMessageBase(minValue, maxValue, message));
	}

	/**
	 * @return check
	 */
	public StringBuilder check() {
		this.getChecker().check(null, null, 0);
		int lastCheck = this.getChecker().getLastCheck();

		StringBuilder results = new StringBuilder();
		results.append(getChecker().getStringFromBuilder());
		results.append("\n\t");
		results.append(checkRangesForMessage(lastCheck));
		return results;
	}

	/**
	 * @param value
	 * @return String
	 */
	protected String checkRangesForMessage(int value) {
		String resp = null;
		for (RangeMessageBase rangeMessageBase : ranges) {
			String checkForMessage = rangeMessageBase.checkForMessage(value);
			if (checkForMessage != null) {
				resp = checkForMessage;
				break;
			}
		}
		return resp;
	}

	/**
	 * @return ACheckeable
	 */
	protected abstract ACheckeable getChecker();

	/**
	 * 
	 */
	@Override
	public final void setElement() {
	}

}
