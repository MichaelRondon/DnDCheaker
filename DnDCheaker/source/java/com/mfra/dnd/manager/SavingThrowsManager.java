package com.mfra.dnd.manager;

import com.mfra.dnd.checker.SavingThrows;
import com.mfra.dnd.checker.SavingThrows.SavingThrowName;
import com.mfra.dnd.util.IBasicData;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class SavingThrowsManager extends ACheckManager {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param checkProperties
	 * @param descProperties
	 */
	public SavingThrowsManager(IBasicData iBasicData) {
		super(iBasicData);
	}

	@Override
	public void init() {
		super.setProperty(new SavingThrows(SavingThrowName.FORTITUDE, iBasicData));
		super.setProperty(new SavingThrows(SavingThrowName.REFLEX, iBasicData));
		super.setProperty(new SavingThrows(SavingThrowName.WILL, iBasicData));
	}
}
