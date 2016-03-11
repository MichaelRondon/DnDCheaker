package com.mfra.dnd.difficultyclass;

import java.io.Serializable;
import java.util.HashMap;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.Ability;
import com.mfra.dnd.checker.Ability.AbilityName;
import com.mfra.dnd.checker.IAbilityWorker;
import com.mfra.dnd.race.ACharacterElement;
import com.mfra.dnd.util.DnDUtil;

/**
 * @author Michael Felipe Rondón Acosta
 */
public abstract class ADifficultyClass extends
        ACharacterElement<ADifficultyClass.DCKeyName> implements IAbilityWorker, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Ability.AbilityName abilityName;

    /**
     * @param nameElement
     * @param checkProperties
     * @param descProperties
     */
    public ADifficultyClass(DCKeyName nameElement,
            HashMap<Enum<?>, ACheckeable> checkProperties,
            HashMap<String, Object> descProperties) {
        super(nameElement, checkProperties, descProperties);
        this.abilityName = nameElement.getAbilityName();
    }

    /**
     * @return AbilityModifier
     */
    public int getAbilityModifier() {
        return ((Ability) this.checkProperties.get(this.getAbilityName())).getModifier();
    }

    /**
     * @return getAbilityName()
     */
    public Ability.AbilityName getAbilityName() {
        return this.abilityName;
    }

    /**
     * @param abilityModifier
     */
    public void setElement(int abilityModifier) {
        super.setElement();
    }

    /**
     * @return keyName
     */
    protected String getKeyName() {
        return this.getName().toString();
    }

    /**
     * 
     */
    protected void preValidation() {
        DnDUtil.getInstance().validAreAbilitiesSet(this.checkProperties);
        DnDUtil.getInstance().validIsRaceSet(this.descProperties);
        DnDUtil.getInstance().validIsClassSet(this.descProperties);
    }

    /**
     * @author Michael Felipe Rondón Acosta
     */
    public enum DCKeyName {
        /**
        * 
        */
        HIT_POINTS(Ability.AbilityName.CONSTITUTION),
        /**
         * 
         */
        ARMOR_CLASS(Ability.AbilityName.DEXTERITY);

        private Ability.AbilityName abilityName;

        private DCKeyName(AbilityName abilityName) {
            this.abilityName = abilityName;
        }

        /**
         * @return abilityName
         */
        public Ability.AbilityName getAbilityName() {
            return this.abilityName;
        }

    }
}
