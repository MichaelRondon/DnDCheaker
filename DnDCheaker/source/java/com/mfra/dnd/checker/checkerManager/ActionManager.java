package com.mfra.dnd.checker.checkerManager;

import java.io.Serializable;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.checkerManager.model.ACheckerManager;
import com.mfra.dnd.util.DescProperty;
import com.mfra.dnd.util.IBasicData;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class ActionManager implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	protected final IBasicData iBasicData;

	/**
	 * @param iBasicData
	 */
	public ActionManager(IBasicData iBasicData) {
		this.iBasicData = iBasicData;
	}

	/**
	 * @param action
	 */
	public void checkAction(Action action) {
		if (action.getCheckeableName() != null) {
			Enum<?> checkeableName = action.getCheckeableName();
			this.checkAction(checkeableName, null);
		} else if (action.getCheckerManager() != null) {
			String characterName = (String) this.iBasicData.getDescProperty(DescProperty.CHARACTER_NAME.name());
			StringBuilder results = new StringBuilder();
			results.append(characterName);
			results.append(" checks for ");
			results.append(action.name());
			ACheckerManager checkerManager = action.getCheckerManager();
			results.append(checkerManager.check());
			System.out.println(results);
		}
	}

	/**
	 * @param checkeableName
	 * @param difficultyClass
	 */
	public void checkAction(Enum<?> checkeableName, Integer difficultyClass) {
		String characterName = (String) this.iBasicData.getDescProperty(DescProperty.CHARACTER_NAME.name());
		StringBuilder results = new StringBuilder();
		ACheckeable aCheckeable = this.iBasicData.getCheckProperty(checkeableName);
		aCheckeable.check(characterName, difficultyClass, 0);
		results.append(aCheckeable.getStringFromBuilder());
		System.out.println(results);
	}

}
