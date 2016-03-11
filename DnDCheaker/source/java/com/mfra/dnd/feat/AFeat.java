package com.mfra.dnd.feat;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Set;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.race.ACharacterElement;
import com.mfra.dnd.util.DnDUtil;
import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 * @param <I>
 */
public abstract class AFeat<I> extends ACharacterElement<AFeat.FeatName> implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 
     */
    public static final String AVAILABLE_FEATS_KEY_NAME = "AvailableFeats";
    /**
     * 
     */
    public static final String KEY_NAME                 = "Feats";

    /**
     * @param nameElement
     * @param checkProperties
     * @param descProperties
     */
    public AFeat(FeatName nameElement,
            HashMap<Enum<?>, ACheckeable> checkProperties,
            HashMap<String, Object> descProperties) {
        super(nameElement, checkProperties, descProperties);
    }

    @Override
    public boolean equals(Object arg0) {
        boolean resp = false;
        if (arg0 instanceof AFeat) {
            resp = ((AFeat<?>) arg0).getName().equals(this.getName());
        }
        return resp;
    }

    /**
     * @return KeyWords
     */
    public abstract Set<I> getElements();

    /**
     * 
     */
    public void setElement() {
        this.setElement(null, false);
    }

    /**
     * @param element
     * @param internal
     */
    public void setElement(I element, boolean internal) {
        if (!internal) {
            this.preValidation(element);
        }
        Feats feats = this.getMapOfFeats();
        if (!feats.containsKey(this.getName())) {
            this.addElement(element);
            feats.put(this.getName(), this);
        }
        else {
            @SuppressWarnings("unchecked")
            AFeat<Object> aFeat = feats.get(this.getName());
            if (aFeat.getElements().contains(element)) {
                throw new GeneralException("You has a " + element + " Yet");
            }
            aFeat.addElement(element);
        }
        this.descProperties.put(this.getKeyName(), feats);

        if (!internal) {
            Integer availableFeats = (Integer) this.descProperties.get(AVAILABLE_FEATS_KEY_NAME);
            --availableFeats;
            this.descProperties.put(AVAILABLE_FEATS_KEY_NAME, availableFeats);
        }
    }

    public String toString() {
        return this.getElements().toString();
    }

    private Feats getMapOfFeats() {
        Feats feats = new Feats();
        if (!this.descProperties.containsKey(this.getKeyName())) {
            this.descProperties.put(this.getKeyName(), feats);
        }
        else {
            feats = (Feats) this.descProperties.get(this.getKeyName());
        }
        return feats;
    }

    /**
     * @param element
     */
    protected abstract void addElement(I element);

    @Override
    protected String getKeyName() {
        return KEY_NAME;
    }

    /**
     * @param element
     */
    protected void preValidation(I element) {
        Integer availableFeats = (Integer) this.descProperties.get(AVAILABLE_FEATS_KEY_NAME);
        if (availableFeats < 1) {
            throw new GeneralException(
                    "You don't have enought Feat availables to learn.");
        }
        Feats feats = this.getMapOfFeats();
        if ((element == null) && feats.containsKey(this.getName())) {
            throw new GeneralException("You has a " + this.getKeyName()
                    + " Yet");
        }
        DnDUtil.getInstance().validAreAbilitiesSet(this.checkProperties);
        DnDUtil.getInstance().validIsRaceSet(this.descProperties);
        DnDUtil.getInstance().validIsClassSet(this.descProperties);
        this.validPrerequisites();
    }

    /**
     * 
     */
    protected abstract void setBenefits();

    /**
     * 
     */
    protected abstract void validPrerequisites();

    /**
     * @author Michael Felipe Rondón Acosta
     */
    public enum FeatName {
        /**
         * 
         */
        ACROBATIC("", "+2 bonus on Jump and Tumble checks", Acrobatic.class),
        /**
         * 
         */
        MARTIAL_WEAPON_PROFICIENCY("",
                "Attack rolls with the selected weapon normally.",
                MartialWeaponProficiency.class);

        private String   prerequisites;
        private String   benefit;
        private Class<?> classTo;

        private FeatName(String prerequisites, String benefit, Class<?> classTo) {
            this.prerequisites = prerequisites;
            this.benefit = benefit;
            this.classTo = classTo;
        }

        /**
         * @return benefit
         */
        public String getBenefit() {
            return this.benefit;
        }

        /**
         * @return class_
         */
        public Class<?> getClassTo() {
            return this.classTo;
        }

        /**
         * @return prerequisites
         */
        public String getPrerequisites() {
            return this.prerequisites;
        }
    }
}
