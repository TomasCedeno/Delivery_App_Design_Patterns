
package test;

import javax.swing.JFrame;
import view.Director;
import view.CartBuilder;

public class BuilderCartTest {
    public static void main(String[] args) {
        Director director = new Director(new CartBuilder());
        
        JFrame myWindow = director.createFrame();
        myWindow.setVisible(true);
        myWindow.setLocationRelativeTo(null);
    }
}
