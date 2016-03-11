package com.mfra.dnd.manager;

import java.util.HashMap;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.checker.SavingThrows;
import com.mfra.dnd.checker.SavingThrows.SavingThrowName;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class SavingThrowsManager extends ACheckManager {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private HashMap<String, Object> descProperties;

    /**
     * @param checkProperties
     * @param descProperties
     */
    public SavingThrowsManager(HashMap<Enum<?>, ACheckeable> checkProperties,
            HashMap<String, Object> descProperties) {
        super(checkProperties);
        this.descProperties = descProperties;
    }

    @Override
    public void init() {
        super.setProperty(new SavingThrows(SavingThrowName.FORTITUDE,
                this.checkProperties, this.descProperties));
        super.setProperty(new SavingThrows(SavingThrowName.REFLEX,
                this.checkProperties, this.descProperties));
        super.setProperty(new SavingThrows(SavingThrowName.WILL,
                this.checkProperties, this.descProperties));
    }
}
