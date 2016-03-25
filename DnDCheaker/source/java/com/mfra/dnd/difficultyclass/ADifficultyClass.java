package com.mfra.dnd.difficultyclass;

import java.io.Serializable;
import java.util.HashMap;

import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.Ability;
import com.mfra.dnd.checker.Ability.AbilityName;
import com.mfra.dnd.checker.IAbilityWorker;
import com.mfra.dnd.race.ACharacterElement;

/**
 * @author Michael Felipe Rondón Acosta
 */
public abstract class ADifficultyClass extends
        ACharacterElement<ADifficultyClass.DCKeyName> implements
        IAbilityWorker, Serializable {

    /**
     * @author Michael Felipe Rondón Acosta
     */
    public enum DCKeyName {
        /**
		 * 
		 */
        ARMOR_CLASS(Ability.AbilityName.DEXTERITY),
        /**
		* 
		*/
        HIT_POINTS(Ability.AbilityName.CONSTITUTION);

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

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    private final Ability.AbilityName abilityName;

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
    @Override
    public int getAbilityModifier() {
        return ((Ability) this.iBasicData.getCheckProperty(this
                .getAbilityName())).getModifier();
    }

    /**
     * @return getAbilityName()
     */
    @Override
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
    @Override
    protected String getKeyName() {
        return this.getName().toString();
    }

    /**
	 * 
	 */
    @Override
    protected void preValidation() {
        this.iBasicData.validAreAbilitiesSet();
        this.iBasicData.validIsRaceSet();
        this.iBasicData.validIsClassSet();
    }
}
