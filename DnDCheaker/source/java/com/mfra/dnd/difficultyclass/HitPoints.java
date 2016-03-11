package com.mfra.dnd.difficultyclass;

import java.util.HashMap;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.dndclass.ADnDClass;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class HitPoints extends ADifficultyClass {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int currentHitPoints;

    /**
     * @param nameElement
     * @param checkProperties
     * @param descProperties
     */
    public HitPoints(DCKeyName nameElement,
            HashMap<Enum<?>, ACheckeable> checkProperties,
            HashMap<String, Object> descProperties) {
        super(ADifficultyClass.DCKeyName.HIT_POINTS, checkProperties,
                descProperties);
        this.restore();
    }

    /**
     * @return currentHitPoints
     */
    public int getCurrentHitPoints() {
        return this.currentHitPoints;
    }

    /**
     * @return maxHitPoints
     */
    public int getMaxHitPoints() {
        return this.getAbilityModifier() + this.getClassModifier();
    }

    /**
     * @param valueToHeal
     */
    public void heal(int valueToHeal) {
        this.currentHitPoints += valueToHeal;
        if (this.currentHitPoints > this.getMaxHitPoints()) {
            this.currentHitPoints = this.getMaxHitPoints();
        }
    }

    /**
     * 
     */
    public void restore() {
        this.currentHitPoints = this.getMaxHitPoints();
    }

    /**
     * @param valueToSubstract
     */
    public void substractToHitPoints(int valueToSubstract) {
        if (valueToSubstract < 0) {
            this.currentHitPoints += valueToSubstract;
        }
        else {
            this.currentHitPoints -= valueToSubstract;
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getCurrentHitPoints());
        stringBuilder.append("/");
        stringBuilder.append(this.getMaxHitPoints());
        stringBuilder.append("\tAbilityModifier:");
        stringBuilder.append(this.getAbilityModifier());
        return stringBuilder.toString();
    }

    /**
     * @return BaseHitPoints
     */
    private int getClassModifier() {
        return ((ADnDClass) this.descProperties.get(ADnDClass.KEY_NAME)).getName().getBaseHitPoints();
    }

}
