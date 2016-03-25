package com.mfra.dnd.feat;

import java.util.HashSet;
import java.util.Set;

import com.mfra.dnd.util.IBasicData;

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
    public Acrobatic(FeatName nameElement, IBasicData iBasicData) {
        super(nameElement, iBasicData);
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
