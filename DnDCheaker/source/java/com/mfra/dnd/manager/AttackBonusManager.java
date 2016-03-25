package com.mfra.dnd.manager;

import com.mfra.dnd.checker.AttackBonus;
import com.mfra.dnd.checker.AttackBonus.AttackName;
import com.mfra.dnd.util.IBasicData;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class AttackBonusManager extends ACheckManager {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    /**
     * @param checkProperties
     * @param descProperties
     */
    public AttackBonusManager(IBasicData iBasicData) {
        super(iBasicData);
    }

    @Override
    public void init() {
        super.setProperty(new AttackBonus(AttackName.MELEE_ATTACK,
                this.iBasicData));
        super.setProperty(new AttackBonus(AttackName.RANGED_ATTACK,
                this.iBasicData));
    }
}
