package com.engeto.ProjektDPH;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class VATList {
    public static final String DELIMITER = "\t";
    public static final String INPUT_FILE_NAME = "DPH_seznam.txt";
    public static final int SPLIT_BASE_VAT_RATE = 20;
    public static final String OUTPUT_FILE_NAME = "vat-over-20.txt";
    List<VAT> vatList = new ArrayList <> ();
    List<VAT> above20List = new ArrayList<>();
    List<VAT> below20List = new ArrayList<>();
    List<VAT> aboveSelectedRateList = new ArrayList<>();

    public void importVATs () {
        vatList.clear();

        try (Scanner scanner = new Scanner(new File(INPUT_FILE_NAME))) {
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                String editedLine = nextLine.replaceAll(",", ".");
                String [] items = editedLine.split(DELIMITER);
                String stateCode = items [0].trim();
                String stateName = items [1].trim();
                double doubleBaseRate = Double.parseDouble(items[2].trim());
                BigDecimal baseRate = BigDecimal.valueOf(doubleBaseRate);
                double doubleLowerRate = Double.parseDouble(items[3].trim());
                BigDecimal lowerRate = BigDecimal.valueOf(doubleLowerRate);
                boolean hasSpecialRate = Boolean.parseBoolean(items[4].trim());
                VAT vat = new VAT(stateCode, stateName, baseRate, lowerRate, hasSpecialRate);
                vatList.add(vat);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public void printVATList() {
        System.out.println("Seznam všech zemí");
        for (VAT vat: vatList) {
            System.out.println(vat.getVATInfo());
        }
    }

    public void printVATOver20() {
        System.out.println("Seznam zemí se sazbou nad 20% a bez speciální sazby");
        for (VAT vat: vatList) {
            if (vat.baseRate.doubleValue() > SPLIT_BASE_VAT_RATE && vat.hasSpecialRate == false) {
                System.out.println(vat.getVATInfo());
            }
        }
    }
    public void getSortedList(){

        Collections.sort(vatList, new VATBaseRateComparator().reversed());
    }
    public void getSortAbove20List() {
        for (VAT vat: vatList) {
            if (vat.baseRate.doubleValue() >SPLIT_BASE_VAT_RATE && vat.hasSpecialRate == false) {
                above20List.add(vat);
            }else {
                below20List.add(vat);
            }
        }
    }
    public void printSortedVATOver20() {
        getSortedList();
        getSortAbove20List();
        System.out.println("Země s DPH sazbou nad 20% a zároveň bez speciální sazby");
        for (VAT vat: above20List) {
            System.out.println(vat.getVATInfo1());
        }
        System.out.println("\n====================\nSazba VAT 20 % nebo nižší nebo používají speciální sazbu:");
        for (int x = 0; x<below20List.size(); x++) {
            if (x == below20List.size() - 1) {
                System.out.print(below20List.get(x).getStateCode());
            } else {
                System.out.print(below20List.get(x).getStateCode().concat(", "));
            }
        }
    }

    public void exportVATs() {
        try (PrintWriter writer = new PrintWriter(new File(OUTPUT_FILE_NAME))) {
            writer.println("Země s DPH sazbou nad 20% a zároveň bez speciální sazby");
            for (VAT vat: above20List) {
                writer.println(vat.getVATInfo1());
            }
            writer.println("\n====================\nSazba VAT 20 % nebo nižší nebo používají speciální sazbu:");
            for (int x = 0; x<below20List.size(); x++) {
                if (x == below20List.size() - 1) {
                    writer.print(below20List.get(x).getStateCode());
                } else {
                    writer.print(below20List.get(x).getStateCode().concat(", "));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void exportSelectedSortedVATs(){
        getSortedList();
        int input = InputFromKeyboard.safeReadInt();
        File file = new File("vat-over-"+input+"%.txt");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (VAT vat: vatList) {
            if (vat.baseRate.doubleValue() >input && vat.hasSpecialRate == false) {
                aboveSelectedRateList.add(vat);
            }
        }
        try (PrintWriter writer = new PrintWriter(file)) {
            writer.println("Země s DPH sazbou nad "+input+"% a zároveň bez speciální sazby");
            for (VAT vat: aboveSelectedRateList){
                writer.println(vat.getVATInfo1());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}
