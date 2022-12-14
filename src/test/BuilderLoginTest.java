
package test;

import view.LoginBuilder;
import view.Director;
import javax.swing.JFrame;


public class BuilderLoginTest {
    public static void main(String[] args) {
        Director director = new Director(new LoginBuilder(null));
        
        JFrame myWindow = director.createFrame();
        myWindow.setVisible(true);
        myWindow.setLocationRelativeTo(null);
    }
}
