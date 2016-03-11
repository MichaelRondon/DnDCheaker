package com.mfra.dnd.weapon;

import java.util.HashMap;
import com.mfra.dice.Dice;
import com.mfra.dice.IDice;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.Ability.AbilityName;
import com.mfra.dnd.checker.AbilityWorker;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class Damage extends AbilityWorker {

    private IDice    dice;

    /**
     * @param checkProperties
     * @param abilityName
     * @param descProperties
     */
    public Damage(HashMap<Enum<?>, ACheckeable> checkProperties,
            AbilityName abilityName, HashMap<String, Object> descProperties) {
        super(checkProperties, abilityName);

    }

    /**
     */
    public void makeDamage() {
        stringBuilder = new StringBuilder();
        stringBuilder.append("To makes damage ");
        int resp = 0;
        if (this.dice != null) {
            IDice rollDice = this.dice.rollDice();
            stringBuilder.append(rollDice.getStringFromBuilder());
            resp += rollDice.getLastValue();
        }

    }

    /**
     * @param diceModifier
     */
    public void setDiceModifier(IDice diceModifier) {
        this.dice = diceModifier;
    }
}
