package com.mfra.dnd.checker;

/**
 * @author Michael Felipe Rondón Acosta
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
