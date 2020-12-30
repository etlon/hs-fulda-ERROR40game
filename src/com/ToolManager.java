package com;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ToolManager {

    public static void main(String[] args) {

    }

    public static String getDocumentPath() {

        return System.getProperty("user.home");

    }

    /**
     * @param folderName
     * @return return true if folder was successfully created, false if it already exists
     */
    public static boolean createFolderIfNotExist(String folderName) {
        File f = new File(getDocumentPath() + folderName);
        if (!f.exists()) {
            f.mkdirs();
            return true;
        }
        return false;
    }

    public static int compareBigDecimal(BigDecimal bd1, BigDecimal bd2) {
        return bd1.compareTo(bd2);
    }

    public static String formatCounter(BigDecimal count) {
        DecimalFormat df = new DecimalFormat("0.000");
        char[] suffixArray = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        int counter = 0;
        //gerade keine Lust ein Index Out of Bounds zu verhindern
        if (counter == 26) System.exit(0);
        if (count.compareTo(new BigDecimal(1000)) <= 0) return String.valueOf(count);
        while (count.compareTo(new BigDecimal(1000)) >= 0) {
            count = count.divide(new BigDecimal(1000));
            counter++;
        }

        return df.format(count.doubleValue()) + suffixArray[counter];
    }


}

