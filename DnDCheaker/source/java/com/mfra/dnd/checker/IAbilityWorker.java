package com.mfra.dnd.checker;

/**
 * @author Michael Felipe Rond�n Acosta
 */
public interface IAbilityWorker {

    /**
     * @return AbilityModifier
     */
    public int getAbilityModifier();

    /**
     * @return getAbilityName()
     */
    public Ability.AbilityName getAbilityName();

}
