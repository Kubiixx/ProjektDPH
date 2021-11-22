package com.engeto.ProjektDPH;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class VAT {
    public static final String FORMAT_PATTERN = "0.#";
    public static final String PERCENT_SYMBOL = "%";
    String stateCode;
    String stateName;
    BigDecimal baseRate;
    BigDecimal lowerRate;
    boolean hasSpecialRate;

    public VAT(String stateCode, String stateName, BigDecimal baseRate, BigDecimal lowerRate, boolean hasSpecialRate) {
        this.stateCode = stateCode;
        this.stateName = stateName;
        this.baseRate = baseRate;
        this.lowerRate = lowerRate;
        this.hasSpecialRate = hasSpecialRate;


    }

    public String getStateCode() {
        return stateCode;
    }

    public void setStateCode(String stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public BigDecimal getBaseRate() {return baseRate;}

    public void setBaseRate(BigDecimal baseRate) {
        this.baseRate = baseRate;
    }

    public BigDecimal getLowerRate() {
        return lowerRate;
    }

    public void setLowerRate(BigDecimal lowerRate) {
        this.lowerRate = lowerRate;
    }

    public boolean isHasSpecialRate() {
        return hasSpecialRate;
    }

    public void setHasSpecialRate(boolean hasSpecialRate) {
        this.hasSpecialRate = hasSpecialRate;
    }

    public String getVATInfo() {
        DecimalFormat format = new DecimalFormat(FORMAT_PATTERN);
        return (stateName+ " (" +stateCode+ "): " +format.format(baseRate)+PERCENT_SYMBOL);
    }
    public String getVATInfo1() {
        DecimalFormat format = new DecimalFormat(FORMAT_PATTERN);
        return (stateName+ " (" +stateCode+ "):\t" +format.format(baseRate)+PERCENT_SYMBOL+"\t("+format.format(lowerRate)+PERCENT_SYMBOL+")");
    }

}
