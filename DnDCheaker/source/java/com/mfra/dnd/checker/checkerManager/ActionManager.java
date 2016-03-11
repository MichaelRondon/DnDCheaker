package com.mfra.dnd.checker.checkerManager;

import java.io.Serializable;
import java.util.HashMap;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.checkerManager.model.ACheckerManager;
import com.mfra.dnd.misc.Misc;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class ActionManager implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    protected final HashMap<Enum<?>, ACheckeable> checkProperties;
    /**
     * 
     */
    protected final HashMap<String, Object>       descProperties;

    /**
     * @param checkProperties
     * @param descProperties
     */
    public ActionManager(HashMap<Enum<?>, ACheckeable> checkProperties,
            HashMap<String, Object> descProperties) {
        this.checkProperties = checkProperties;
        this.descProperties = descProperties;
    }

    /**
     * @param action
     */
    public void checkAction(Action action) {
        if (action.getCheckeableName() != null) {
            Enum<?> checkeableName = action.getCheckeableName();
            checkAction(checkeableName,null);
        }
        else if (action.getCheckerManager() != null) {
            String characterName = (String) this.descProperties.get(Misc.CHARACTER_NAME.name());
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
        String characterName = (String) this.descProperties.get(Misc.CHARACTER_NAME.name());
        StringBuilder results = new StringBuilder();
        ACheckeable aCheckeable = this.checkProperties.get(checkeableName);
        aCheckeable.check(characterName, difficultyClass, 0);
        results.append(aCheckeable.getStringFromBuilder());
        System.out.println(results);
    }
    
}
