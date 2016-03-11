package com.mfra.dnd.manager;

import java.util.HashMap;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.Ability;
import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class AbilityManager extends ACheckManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param checkProperties
     */
    public AbilityManager(HashMap<Enum<?>, ACheckeable> checkProperties) {
        super(checkProperties);
    }

    /**
     * @param name
     * @param valueToAdd
     * @throws GeneralException
     */
    public void addToAbility(Ability.AbilityName name, int valueToAdd)
            throws GeneralException {
        ACheckeable property = super.getProperty(name);
        if (property instanceof Ability) {
            ((Ability) property).addValue(valueToAdd);
        }
        else {
            throw new GeneralException("Cast error");
        }
    }

    /**
     * 
     */
    public void adjustMinIntelligence() {
        Ability intelligence = (Ability) super.getProperty(Ability.AbilityName.INTELLIGENCE);
        int intelligenceScore = (intelligence).getValue();
        if (intelligenceScore < 3) {
            intelligence.addValue(3 - intelligenceScore);
        }
    }

    /**
     * @param name
     * @return modifier
     */
    public int getAbilityModifier(Ability.AbilityName name) {
        ACheckeable property = super.getProperty(name);
        return ((Ability) property).getModifier();
    }

    @Override
    public void init() {
        super.setProperty(new Ability(Ability.AbilityName.CHARISMA, 0,
                this.checkProperties));
        super.setProperty(new Ability(Ability.AbilityName.CONSTITUTION, 0,
                this.checkProperties));
        super.setProperty(new Ability(Ability.AbilityName.DEXTERITY, 0,
                this.checkProperties));
        super.setProperty(new Ability(Ability.AbilityName.INTELLIGENCE, 0,
                this.checkProperties));
        super.setProperty(new Ability(Ability.AbilityName.STRENGTH, 0,
                this.checkProperties));
        super.setProperty(new Ability(Ability.AbilityName.WISDOM, 0,
                this.checkProperties));

    }

    /**
     * @param name
     * @param value
     */
    public void setAbility(Ability.AbilityName name, int value) {
        super.setProperty(new Ability(name, value, this.checkProperties));
    }
}
