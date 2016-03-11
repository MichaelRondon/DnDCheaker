package com.mfra.dnd.feat;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import com.mfra.dnd.checker.ACheckeable;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class Acrobatic extends AFeat<Object> {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param nameElement
     * @param checkProperties
     * @param descProperties
     */
    public Acrobatic(FeatName nameElement,
            HashMap<Enum<?>, ACheckeable> checkProperties,
            HashMap<String, Object> descProperties) {
        super(nameElement, checkProperties, descProperties);
    }

    @Override
    public Set<Object> getElements() {
        return new HashSet<Object>();
    }

    @Override
    protected void addElement(Object element) {
    }

    @Override
    protected void setBenefits() {
    }

    @Override
    protected void validPrerequisites() {
    }

}
