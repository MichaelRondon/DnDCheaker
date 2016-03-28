package com.mfra.dnd.checker.checkerManager.model;

import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class RangeMessageBase {

	private final Integer maxValue;
	private final String message;
	private final Integer minValue;

	/**
	 * @param minValue
	 * @param maxValue
	 * @param message
	 */
	public RangeMessageBase(Integer minValue, Integer maxValue, String message) {
		super();
		this.minValue = minValue;
		this.maxValue = maxValue;
		this.message = message;
		if (minValue == null && maxValue == null || minValue.equals(maxValue)) {
			StringBuilder stringBuilder = new StringBuilder();
			stringBuilder.append("Invalid Range. Min. Value= ");
			stringBuilder.append(minValue);
			stringBuilder.append(" Max. Value= ");
			stringBuilder.append(maxValue);
			throw new GeneralException("Invalid Range");
		}
	}

	/**
	 * @param value
	 * @return String
	 */
	public String checkForMessage(int value) {
		String resp = (this.minValue == null || value > this.minValue)
				&& (this.maxValue == null || this.maxValue > value) ? this.message : null;
		return resp;
	}

}
