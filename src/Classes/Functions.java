package Classes;

import java.awt.Image;
import javax.swing.ImageIcon;

public class Functions {

    public static ImageIcon setIconImage(String path, int width, int height) {
        return new ImageIcon(new ImageIcon(path).getImage().getScaledInstance(width, height, Image.SCALE_SMOOTH));
    }
  
}
