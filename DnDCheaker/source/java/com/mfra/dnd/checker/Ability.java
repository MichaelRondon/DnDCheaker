package com.mfra.dnd.checker;

import java.util.HashMap;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class Ability extends ACheckeable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int value;
    private int temporalScoreModifier;

    /**
     * @param name
     * @param value
     * @param checkProperties
     */
    public Ability(AbilityName name, int value,
            HashMap<Enum<?>, ACheckeable> checkProperties) {
        super(name, checkProperties, name);
        this.addValue(value);
    }

    /**
     * @param valueToAdd
     */
    public void addTemporalScoreModifier(int valueToAdd) {
        this.temporalScoreModifier += valueToAdd;
    }

    /**
     * @param valueToAdd
     */
    public void addValue(int valueToAdd) {
        this.value += valueToAdd;
    }

    public int getAbilityModifier() {
        return getAbilityModifier(this.getEfectyValue());
    }

    /**
     * @param spellLevel
     * @return BonusSpellBySpellLevel
     */
    public int getBonusSpellBySpellLevel(int spellLevel) {
        int base = this.getEfectyValue() - spellLevel;
        int resp = (base - 3) >> 3;
        resp = (resp < 0) ? 0 : resp;
        return resp;
    }

    /**
     * @return value
     */
    public int getEfectyValue() {
        return this.value + this.temporalScoreModifier;
    }

    /**
     * @return header
     */
    public String getHeader() {
        return "Name\tScore\tModifier";
    }

    @Override
    public int getModifier() {
        return this.getAbilityModifier();
    }

    /**
     * @return value
     */
    public int getValue() {
        return this.value;
    }

    /**
     * 
     */
    public String toString() {
        String line = String.format(this.getFormat(), this.getName(),
                this.getValue(), this.getModifier());
        return line;
    }

    /**
     * @return format
     */
    protected String getFormat() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("%s\t%d\t%d");
        stringBuilder.append(System.getProperty("line.separator"));
        return stringBuilder.toString();
    }

    /**
     * @param value
     * @return (value - 10) >> 1
     */
    public static int getAbilityModifier(int value) {
        return (value - 10) >> 1;
    }

    /**
     * 
     */
    public enum AbilityName {
        /**
         * 
         */
        STRENGTH,
        /**
         * 
         */
        CONSTITUTION,
        /**
         * 
         */
        DEXTERITY,
        /**
         * 
         */
        INTELLIGENCE,
        /**
         * 
         */
        WISDOM,
        /**
         * 
         */
        CHARISMA;
    }
}
