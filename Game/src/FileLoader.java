import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class FileLoader {

    /**
     * this class is used for reading in a specified file and getting the value to a corresponding key
     * with syntax key=value where key and value are both Strings.
     */



    private final String PATH;
    private File file;
    private HashMap<String, String> map = new HashMap<>();

    /**
     * Constructor method of this class. Stores the parameter (path of a file) in a final variable.
     * @param path the path of the file to be read in
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

                //Escape character (#) for comments
                if(newLine.charAt(0) == '#') continue;
                //Skips the current line if no equals (=) is found
                if(!newLine.contains("=")) continue;

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
     * @param key the key is a property with a corresponding value
     * @return value
     */

    public String getValueByKey(String key) {
        return map.get(key);
    }


    /**
     * @param key the key is a property with a corresponding value
     * @param value the value of the corresponding key
     */

    public void write(String key, String value){

    }



}
