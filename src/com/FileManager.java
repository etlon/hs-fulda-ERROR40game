package com;

import com.buyables.ShopItem;

import java.io.*;
import java.util.HashMap;

public class FileManager {

    /**
     * this class is used for reading in a specified file and getting the value to a corresponding key
     * with syntax key=value where key and value are both Strings.
     */


    private final String PATH;
    private final File FILE;
    private HashMap<String, String> map = new HashMap<>();

    /**
     * Constructor method of this class. Stores the parameter (path of a file) in a final variable.
     *
     * @param path the path of the file to be read in
     */

    public FileManager(String path) {

        this.PATH = path;
        FILE = new File(PATH);

        try {
            if (!FILE.exists()) FILE.createNewFile();
            else this.load();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * reads in a specified file and splits each line into 2 substrings using regex.
     * Saves read-in key and value in a hashmap.
     */

    public void load() {

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(FILE));
            String newLine;
            while ((newLine = br.readLine()) != null) {

                //Escape character (#) for comments
                if (newLine.charAt(0) == '#') continue;
                //Skips the current line if no equals (=) is found
                if (!newLine.contains("=")) continue;

                String key = newLine.split("=")[0];
                String value = newLine.split("=")[1];
                map.put(key, value);
            }
            br.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        Main.amountTotalClicks.increaseCounter(getValueByKey("money"));
        this.loadItems();
    }

    public void loadItems() {
        ShopItem[] items = Main.shop.getItemList();
        for (ShopItem item : items) {
            int amount = Integer.parseInt(this.getValueByKey(item.getName()));
            item.setAmount(amount);
        }
    }

    /**
     * returns the value of a given key from the hashmap.
     *
     * @param key the key is a property with a corresponding value
     * @return value
     */

    public String getValueByKey(String key) {
        return map.get(key);
    }

    /**
     * adds value
     *
     * @param key   the key is a property with a corresponding value
     * @param value the value to be put into hashmap
     */

    public void addValueByKey(String key, String value) {
        map.put(key, value);
    }


    /**
     * overwrites all values
     */

    public void save() {

        this.setValues();

        BufferedWriter bw;
        try {
            bw = new BufferedWriter(new FileWriter(FILE));

            bw.write("#syntax: key=value");
            bw.newLine();

            for (String i : map.keySet()) {
                bw.write(i + "=" + map.get(i));
                bw.newLine();
            }
            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * writes all important stats into hashmap
     */

    public void setValues() {
        this.addValueByKey("money", Main.amountTotalClicks.getCount());
        Main.shop.saveItems();
    }
}