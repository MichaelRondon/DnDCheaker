package com.mfra.dnd.util;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

import com.mfra.exceptions.GeneralException;

/**
 * @author Michael Felipe Rondón Acosta
 */
public class CoinsBuilder implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;
    private int copper;
    private int gold;
    private int platinum;
    private int silver;

    /**
	 * 
	 */
    public CoinsBuilder() {

    }

    /**
     * @param expression
     */
    public CoinsBuilder(String expression) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("The expression is incorrect: ");
        stringBuilder.append(expression);
        if (expression == null) {
            throw new GeneralException(stringBuilder.toString());
        }
        try {
            this.readExpression(expression);
        } catch (NumberFormatException e) {
            throw new GeneralException(stringBuilder.toString());
        } catch (NoSuchElementException e) {
            throw new GeneralException(stringBuilder.toString());
        }

    }

    /**
     * @return copper
     */
    public int getCopper() {
        return this.copper;
    }

    /**
     * @return gold
     */
    public int getGold() {
        return this.gold;
    }

    /**
     * @return platinum
     */
    public int getPlatinum() {
        return this.platinum;
    }

    /**
     * @return silver
     */
    public int getSilver() {
        return this.silver;
    }

    /**
     * @param copper
     */
    public void setCopper(int copper) {
        this.copper = copper;
    }

    /**
     * @param gold
     */
    public void setGold(int gold) {
        this.gold = gold;
    }

    /**
     * @param platinum
     */
    public void setPlatinum(int platinum) {
        this.platinum = platinum;
    }

    /**
     * @param silver
     */
    public void setSilver(int silver) {
        this.silver = silver;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.getPlatinum());
        stringBuilder.append("pp ");
        stringBuilder.append(this.getGold());
        stringBuilder.append("gp ");
        stringBuilder.append(this.getSilver());
        stringBuilder.append("sp ");
        stringBuilder.append(this.getCopper());
        stringBuilder.append("cp ");
        return stringBuilder.toString();
    }

    private void readExpression(String expression) {
        StringTokenizer stringTokenizer;
        expression = expression.toLowerCase();
        expression = expression.trim().replace("pp", "p");
        expression = expression.replace("gp", "g");
        expression = expression.replace("sp", "s");
        expression = expression.replace("cp", "c");
        if (expression.contains("p")) {
            stringTokenizer = new StringTokenizer(expression, "p");
            this.platinum = new BigDecimal(stringTokenizer.nextToken().trim())
                    .intValue();
            if (stringTokenizer.hasMoreTokens()) {
                expression = stringTokenizer.nextToken();
            }
        }
        if (expression.contains("g")) {
            stringTokenizer = new StringTokenizer(expression, "g");
            this.gold = new BigDecimal(stringTokenizer.nextToken().trim())
                    .intValue();
            if (stringTokenizer.hasMoreTokens()) {
                expression = stringTokenizer.nextToken();
            }
        }
        if (expression.contains("s")) {
            stringTokenizer = new StringTokenizer(expression, "s");
            this.silver = new BigDecimal(stringTokenizer.nextToken().trim())
                    .intValue();
            if (stringTokenizer.hasMoreTokens()) {
                expression = stringTokenizer.nextToken();
            }
        }
        if (expression.contains("c")) {
            stringTokenizer = new StringTokenizer(expression, "c");
            this.copper = new BigDecimal(stringTokenizer.nextToken().trim())
                    .intValue();
        }
    }

}