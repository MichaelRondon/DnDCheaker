package com.mfra.dnd.factory;

import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import com.mfra.dnd.race.ACharacterElement;
import com.mfra.dnd.util.IBasicData;
import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class DnDFactory implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	protected final IBasicData iBasicData;

	/**
	 * @param iBasicData
	 */
	public DnDFactory(IBasicData iBasicData) {
		this.iBasicData = iBasicData;
	}

	/**
	 * @param classTo
	 * @param name
	 * @return ACharacterElement
	 */
	public ACharacterElement<?> getCharacterElementInstance(Class<?> classTo, Enum<?> name) {
		ACharacterElement<?> resp = null;
		// try {
		// Constructor<?> declaredConstructor =
		// classTo.getDeclaredConstructor(name.getClass(),
		// this.checkProperties.getClass(), this.descProperties.getClass());
		// Object newInstance = declaredConstructor.newInstance(name,
		// this.checkProperties, this.descProperties);
		// if (newInstance instanceof ACharacterElement) {
		// resp = (ACharacterElement<?>) newInstance;
		// } else {
		// throw new GeneralException("The instace is not an
		// ACharacterElement");
		// }
		// } catch (NoSuchMethodException e) {
		try {
			Constructor<?> declaredConstructor = classTo.getDeclaredConstructor(name.getClass(), IBasicData.class);
			Object newInstance = declaredConstructor.newInstance(name, iBasicData);
			if (newInstance instanceof ACharacterElement) {
				resp = (ACharacterElement<?>) newInstance;
			} else {
				throw new GeneralException("The instace is not an ACharacterElement");
			}
		} catch (java.lang.NoSuchMethodException e2) {
			throw new GeneralException(e2);
		} catch (InstantiationException e1) {

			throw new GeneralException(e1);
		} catch (IllegalAccessException e1) {
			throw new GeneralException(e1);
		} catch (IllegalArgumentException e1) {
			throw new GeneralException(e1);
		} catch (InvocationTargetException e1) {
			throw new GeneralException(e1);
		}
		// } catch (SecurityException e) {
		// throw new GeneralException(e);
		// } catch (InstantiationException e) {
		// throw new GeneralException(e);
		// } catch (IllegalAccessException e) {
		// throw new GeneralException(e);
		// } catch (IllegalArgumentException e) {
		// throw new GeneralException(e);
		// } catch (InvocationTargetException e) {
		// throw new GeneralException(e);
		// }
		return resp;
	}

}
