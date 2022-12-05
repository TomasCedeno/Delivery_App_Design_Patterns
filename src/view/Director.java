
package view;

import javax.swing.JFrame;

public class Director {
    private GUIBuilder builder;
    
    public Director(GUIBuilder builder){
        this.builder = builder;
    }
    
    public void changeGUIBuilder(GUIBuilder builder){
        this.builder = builder;
    }
    
    public JFrame createFrame(){
        this.builder.createLabels();
        this.builder.createButtons();
        this.builder.createTextFields();
        this.builder.addEvents();
        this.builder.createWindow();
        
        return this.builder.getFrame();
    }
}
