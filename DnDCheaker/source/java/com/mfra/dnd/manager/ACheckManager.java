package com.mfra.dnd.manager;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.List;

import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.util.IBasicData;

/**
 * @author Michael Felipe Rondón Acosta
 */
public abstract class ACheckManager implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    /**
	 * 
	 */
    protected final IBasicData iBasicData;

    /**
     * @param checkProperties
     */
    protected ACheckManager(IBasicData iBasicData) {
        this.iBasicData = iBasicData;
    }

    public <L> List<L> getProperties(Object[] enumValues, Class<L> classname) {
        List<L> checkeables = new LinkedList<L>();
        for (Object object : enumValues) {
            ACheckeable checkeable = this.iBasicData
                    .getCheckProperty((Enum<?>) object);
            checkeables.add((L) checkeable);
        }
        return checkeables;
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
            ACheckeable checkeable = this.iBasicData
                    .getCheckProperty((Enum<?>) object);
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
        return this.iBasicData.getCheckProperty(name);
    }

    /**
     * @param property
     */
    protected void setProperty(ACheckeable property) {
        this.iBasicData.putCheckProperty(property.getName(), property);
    }

}
