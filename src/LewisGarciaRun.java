import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class LewisGarciaRun {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                JFrameDemo fd = new JFrameDemo();
            } catch (IOException ex) {
                Logger.getLogger(LewisGarciaRun.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
    }
}