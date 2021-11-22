package com.engeto.ProjektDPH;

import java.math.BigDecimal;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {
        VATList list = new VATList();
        list.importVATs();
        list.printVATList();
        list.printVATOver20();
        list.printSortedVATOver20();
        list.exportVATs();
        list.exportSelectedSortedVATs();




    }
}
