package com.mfra.dnd.checker.checkerManager;

import com.mfra.dnd.checker.Ability;
import com.mfra.dnd.checker.checkerManager.model.ACheckerManager;

/**
 * @author Michael Felipe Rondón Acosta
 */
public enum Action {
    /**
 * 
 */
    INICIATIVE(Ability.AbilityName.DEXTERITY,null);

    private Enum<?>         checkeableName;
    private ACheckerManager checkerManager;

    private Action(Enum<?> checkeableName, ACheckerManager checkerManager) {
        this.checkeableName = checkeableName;
        this.checkerManager = checkerManager;
    }

    /**
     * @return checkeableName
     */
    public Enum<?> getCheckeableName() {
        return this.checkeableName;
    }

    /**
     * @return checkerManager
     */
    public ACheckerManager getCheckerManager() {
        return checkerManager;
    }

}
