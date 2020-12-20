package com;

import java.io.File;

public class ToolManager {

    public static void main(String[] args) {

    }

    public static String getDocumentPath() {

        return System.getProperty("user.home");

    }

    /**
     *
     * @param folderName
     * @return return true if folder was successfully created, false if it already exists
     */
    public static boolean createFolderIfNotExist(String folderName) {
        File f = new File(getDocumentPath() + folderName);
        if (!f.exists()){
            f.mkdirs();
            return true;
        }
        return false;
    }


}

