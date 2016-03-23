package com.mfra.dnd.equipment;

import java.util.HashMap;
import com.mfra.dnd.checker.ACheckeable;
import com.mfra.dnd.race.ACharacterElement;
import com.mfra.dnd.util.CoinsBuilder;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class Coins extends ACharacterElement<Equipment> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * @param coinsToAdd
	 * @return coinsToAdd.getCopper() + coinsToAdd.getSilver() * 10 +
	 *         coinsToAdd.getGold() * 100 + coinsToAdd.getPlatinum() * 1000;
	 */
	public static int getAllInCopper(CoinsBuilder coinsToAdd) {
		return coinsToAdd.getCopper() + coinsToAdd.getSilver() * 10 + coinsToAdd.getGold() * 100
				+ coinsToAdd.getPlatinum() * 1000;
	}

	private CoinsBuilder myCoinsBuilder = new CoinsBuilder();

	/**
	 * @param nameElement
	 * @param checkProperties
	 * @param descProperties
	 */
	public Coins(Equipment nameElement, HashMap<Enum<?>, ACheckeable> checkProperties,
			HashMap<String, Object> descProperties) {
		super(nameElement, checkProperties, descProperties);
	}

	/**
	 * @param coinsToAdd
	 */
	public void addCoins(CoinsBuilder coinsToAdd) {
		int currentCopperMoney = getAllInCopper(this.myCoinsBuilder);
		int copperMoneyToAdd = getAllInCopper(coinsToAdd);
		currentCopperMoney += copperMoneyToAdd;
		int[] organize = this.organize(currentCopperMoney);
		this.myCoinsBuilder.setCopper(organize[0]);
		int currentSilver = organize[1];
		organize = this.organize(currentSilver);
		this.myCoinsBuilder.setSilver(organize[0]);
		int currentGold = organize[1];
		organize = this.organize(currentGold);
		this.myCoinsBuilder.setGold(organize[0]);
		this.myCoinsBuilder.setPlatinum(organize[1]);

	}

	@Override
	protected String getKeyName() {
		return Equipment.COINS.toString();
	}

	private int[] organize(int minusValue) {
		int mayorValue = 0;
		if ((minusValue / 10) > 0) {
			mayorValue = (minusValue / 10);
			minusValue -= mayorValue * 10;
		}
		return new int[] { minusValue, mayorValue };
	}

	@Override
	public String toString() {
		return this.myCoinsBuilder.toString();
	}

}
