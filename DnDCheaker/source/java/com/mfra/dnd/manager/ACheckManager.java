package com.mfra.dnd.manager;

import java.io.Serializable;
import java.util.HashMap;
import com.mfra.dnd.checker.ACheckeable;

/**
 * @author Michael Felipe Rondón Acosta
 */
public abstract class ACheckManager implements Serializable{

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 
     */
    protected HashMap<Enum<?>, ACheckeable> checkProperties;

    /**
     * @param checkProperties
     */
    protected ACheckManager(HashMap<Enum<?>, ACheckeable> checkProperties) {
        this.checkProperties = checkProperties;
    }

    /**
     */
    public abstract void init();

    /**
     * @param enumValues
     * @return StringBuilder
     */
    public StringBuilder showProperties(Object[] enumValues) {
        StringBuilder stringBuilder = new StringBuilder();

        boolean first = true;

        for (Object object : enumValues) {
            ACheckeable checkeable = this.checkProperties.get(object);
            if (checkeable == null) {
                continue;
            }
            if (first) {
                stringBuilder.append(checkeable.getHeader());
                stringBuilder.append(System.getProperty("line.separator"));
                first = false;
            }
            stringBuilder.append(checkeable);
        }

        return stringBuilder;

    }

    /**
     * @param name
     * @return this.checkProperties.get(name)
     */
    protected ACheckeable getProperty(Enum<?> name) {
        return this.checkProperties.get(name);
    }

    /**
     * @param property
     */
    protected void setProperty(ACheckeable property) {
        this.checkProperties.put(property.getName(), property);
    }

}
