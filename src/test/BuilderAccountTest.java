package test;

import javax.swing.JFrame;
import view.Director;
import view.AccountBuilder;

public class BuilderAccountTest {
    public static void main(String[] args) {
        Director director = new Director(new AccountBuilder());
        
        JFrame myWindow = director.createFrame();
        myWindow.setVisible(true);
        myWindow.setLocationRelativeTo(null);
    }
}
