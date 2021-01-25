package com;

import java.io.File;
import java.math.BigDecimal;
import java.text.DecimalFormat;

public class ToolManager {


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

        int counter = 0;
        //gerade keine Lust ein Index Out of Bounds zu verhindern

        if (count.compareTo(new BigDecimal(1000)) <= 0) return String.valueOf(count);
        while (count.compareTo(new BigDecimal(1000)) >= 0) {
            count = count.divide(new BigDecimal(1000));
            counter++;
        }
        if (counter >= 30) {
            return "INFINITY²";
        } else if (counter >= 27) {
            return "INFINITY";
        }

        DecimalFormat df = new DecimalFormat("0.000");
        char[] suffixArray = {' ', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L',
            'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        return df.format(count.doubleValue()) + suffixArray[counter];
    }

    public static void idleFarm(long closeTime, double percentage, Shop shop, AmountTotalClicksLabel label) {
        long currentTime = System.currentTimeMillis();

        int diff = (int) (currentTime - closeTime);
        if (diff > 24 * 60 * 60 * 1000) diff = 24 * 60 * 60 * 1000;
        diff /= 1000; //time in seconds

        BigDecimal score = shop.getIncome();
        score = score.multiply(new BigDecimal(percentage / 100));
        score = score.multiply(BigDecimal.valueOf(diff));

        DecimalFormat df = new DecimalFormat("0");
        score = new BigDecimal(df.format(score));
        label.increaseCounter(score);
    }

}

