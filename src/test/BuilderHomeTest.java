
package test;

import javax.swing.JFrame;
import view.Director;
import view.HomeBuilder;

public class BuilderHomeTest {
    public static void main(String[] args) {
        Director director = new Director(new HomeBuilder(null));
        
        JFrame myWindow = director.createFrame();
        myWindow.setVisible(true);
        myWindow.setLocationRelativeTo(null);
    }
}
