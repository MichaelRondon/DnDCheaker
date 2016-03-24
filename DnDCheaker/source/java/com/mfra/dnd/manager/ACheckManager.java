package com.mfra.dnd.manager;

import java.io.Serializable;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.util.IBasicData;

/**
 * @author Michael Felipe Rondón Acosta
 */
public abstract class ACheckManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	protected final IBasicData iBasicData;

	/**
	 * @param checkProperties
	 */
	protected ACheckManager(IBasicData iBasicData) {
		this.iBasicData = iBasicData;
	}

	/**
	 * @param name
	 * @return this.checkProperties.get(name)
	 */
	protected ACheckeable getProperty(Enum<?> name) {
		return this.iBasicData.getCheckProperty(name);
	}

	/**
	 */
	public abstract void init();

	/**
	 * @param property
	 */
	protected void setProperty(ACheckeable property) {
		this.iBasicData.putCheckProperty(property.getName(), property);
	}

	/**
	 * @param enumValues
	 * @return StringBuilder
	 */
	public StringBuilder showProperties(Object[] enumValues) {
		StringBuilder stringBuilder = new StringBuilder();

		boolean first = true;

		for (Object object : enumValues) {
			ACheckeable checkeable = this.iBasicData.getCheckProperty((Enum<?>) object);
			if (checkeable == null) {
				continue;
			}
			if (first) {
				stringBuilder.append(checkeable.getHeader());
				stringBuilder.append(System.getProperty("line.separator"));
				first = false;
			}
			stringBuilder.append(checkeable);
		}

		return stringBuilder;

	}

}
