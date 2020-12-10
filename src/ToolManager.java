import java.io.InputStream;

public class ToolManager {

    public static void main(String[] args) {

    }

    public static String getDocumentPath() {
        //Stolen from https://stackoverflow.com/questions/9677692/getting-my-documents-path-in-java
        String myDocuments = null;

        try {
            Process p =  Runtime.getRuntime().exec("reg query \"HKCU\\Software\\Microsoft\\Windows\\CurrentVersion\\Explorer\\Shell Folders\" /v personal");
            p.waitFor();

            InputStream in = p.getInputStream();
            byte[] b = new byte[in.available()];
            in.read(b);
            in.close();

            myDocuments = new String(b);
            myDocuments = myDocuments.split("\\s\\s+")[4];



        } catch(Throwable t) {
            t.printStackTrace();
        }

        return myDocuments;

    }

    public static Enum getOperatingSystem() {

        //Implementation coming soon
        System.out.println(System.getProperty("os.name"));

        return null;
    }


}

