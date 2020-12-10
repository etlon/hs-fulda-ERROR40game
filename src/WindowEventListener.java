import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowEventListener extends WindowAdapter {

    FileManager fm;

    public WindowEventListener(FileManager fm) {
        this.fm = fm;
    }

    public void windowClosing(WindowEvent evt) {
        fm.save();
    }

}
