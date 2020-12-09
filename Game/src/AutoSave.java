public class AutoSave extends Thread{

    private FileManager fm;

    public AutoSave(FileManager fm){
        this.fm = fm;
    }

    public void run(){
        try {

            while (true) {
                Thread.sleep(600000);  //10 minutes
                setValues();
                fm.save();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    /**
     *  writes all important stats into the FileManager hashmap
     */

    public void setValues(){
        fm.addValueByKey("money", Main.amountTotalClicks.getCount());

    }
}
