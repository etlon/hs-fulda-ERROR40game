package com;

public class AutoSave extends Thread{

    private FileManager fm;

    public AutoSave(FileManager fm){
        this.fm = fm;
    }

    public void run(){
        try {

            while (true) {
                Thread.sleep(600000);  //10 minutes
                fm.save();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
