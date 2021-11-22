package com.engeto.ProjektDPH;

import java.util.Comparator;

public class VATBaseRateComparator implements Comparator <VAT> {

    @Override
    public int compare(VAT first, VAT second) {
        return first.getBaseRate().compareTo(second.getBaseRate());
    }
}
