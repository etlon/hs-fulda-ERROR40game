import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class FileLoader {

    private final String PATH;
    private File file;
    private HashMap<String, String> map = new HashMap<String, String>();

    /**
     * Constructor method of this class. Stores the parameter (path of a file) in a final variable.
     * @param path
     */

    public FileLoader(String path) {

        this.PATH = path;
        file = new File(PATH);

    }

    /**
     * reads in a specified file and splits each line into 2 substrings using regex.
     * Saves read-in key and value in a hashmap.
     */

    public void load() {

        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(file));
            String newLine;
            while((newLine = br.readLine()) != null) {
                String key = newLine.split("=")[0];
                String value= newLine.split("=")[1];
                map.put(key, value);
            }

        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * returns the value of a given key from the hashmap.
     * @param key
     * @return value
     */

    public String getValueByKey(String key) {
        return map.get(key);
    }



}
