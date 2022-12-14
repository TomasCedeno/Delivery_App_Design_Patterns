package view;

import java.util.stream.DoubleStream;
import javax.swing.JFrame;

public class ViewMediator {
    
    private Director director;
    private LoginBuilder loginBuilder;
    private HomeBuilder homeBuilder;
    private CartBuilder cartBuilder;
    private AccountBuilder accountBuilder;
    private JFrame window;
    
    public ViewMediator() {
        loginBuilder = new LoginBuilder(this);
        homeBuilder = new HomeBuilder(this);
        cartBuilder = new CartBuilder(this);
        accountBuilder = new AccountBuilder(this);
    }
    
    private void updateWindow() {
        window = director.createFrame();
        window.setVisible(true);
        window.setLocationRelativeTo(null);
    }
    
    public void start(){
        director = new Director(loginBuilder);
        updateWindow();
    }
    
    public void notify(GUIBuilder sender, String event, String userId){
        if (event.equals("home")){
            sender.getFrame().dispose();
            homeBuilder.setUserId(userId);
            director.changeGUIBuilder(homeBuilder);
            updateWindow();     
            
        } else if (event.equals("cart")) {
            sender.getFrame().dispose();
            cartBuilder.setUserId(userId);
            director.changeGUIBuilder(cartBuilder);
            updateWindow();
            
        } else if (event.equals("account")) {
            sender.getFrame().dispose();
            accountBuilder.setUserId(userId);
            director.changeGUIBuilder(accountBuilder);
            updateWindow();
        }
    }
    
}
