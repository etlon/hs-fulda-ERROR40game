public class AutoSave extends Thread{

    private String key = "money";
    private String value = "";
    private FileManager fm;
    private AmountTotalClicksLabel aTCL;

    public AutoSave(FileManager fm, AmountTotalClicksLabel aTCL){
        this.fm = fm;
        this.aTCL = aTCL;
    }

    public void run(){
        try {

            while (true) {
                Thread.sleep(600000);  //10 minutes
                value = aTCL.getCount();
                fm.addValueByKey(key, value);
                fm.save();
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
