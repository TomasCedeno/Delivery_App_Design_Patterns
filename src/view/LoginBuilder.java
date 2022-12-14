
package view;

import java.awt.event.*;
import javax.swing.*;
import logic.GUIfactory.*;
import logic.account.User;
import logic.authenticator.*;
import test.Out;

public class LoginBuilder implements GUIBuilder {
    private JFrame window;
    private JLabel[] labels;
    private JButton[] buttons;
    private JTextField[] textFields;
    private GUIFactory factory;
    private ViewMediator mediator;
    
    public LoginBuilder(ViewMediator mediator){
        this.mediator = mediator;
        factory = new LoginFactory();        
    }
    
    @Override
    public void createLabels() {
        labels = factory.createLabels();
    }

    @Override
    public void createButtons() {
        buttons = factory.createButtons();
    }
    
    @Override
    public void createComboBoxes() { }

    @Override
    public void createTextFields() {
        textFields = factory.createTextFields();
    }   
    
    @Override
    public void addEvents() {
        buttons[0].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        
        buttons[1].addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                btnSingUpActionPerformed(evt);
            }
        });
    }
    
    @Override
    public void createWindow() {
        this.window = new JFrame();
        window.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel jpLogin = new JPanel();  
        
        GroupLayout jpLoginLayout = new GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGroup(jpLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(labels[0]))
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jpLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(GroupLayout.Alignment.TRAILING, jpLoginLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labels[1], GroupLayout.Alignment.LEADING, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGroup(GroupLayout.Alignment.LEADING, jpLoginLayout.createSequentialGroup()
                                    .addGroup(jpLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(labels[2])
                                        .addComponent(labels[3]))
                                    .addPreferredGap(LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jpLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(textFields[0], GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFields[1], GroupLayout.PREFERRED_SIZE, 219, GroupLayout.PREFERRED_SIZE))))
                            .addGroup(GroupLayout.Alignment.TRAILING, jpLoginLayout.createSequentialGroup()
                                .addGroup(jpLoginLayout.createParallelGroup(GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(buttons[1], GroupLayout.Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttons[0], GroupLayout.Alignment.LEADING))
                                .addGap(80, 80, 80)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labels[0])
                .addGap(18, 18, 18)
                .addComponent(labels[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jpLoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labels[2])
                    .addComponent(textFields[0], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpLoginLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(labels[3])
                    .addComponent(textFields[1], GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttons[0])
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttons[1])
                .addContainerGap(22, Short.MAX_VALUE))
        );

        GroupLayout layout = new GroupLayout(window.getContentPane());
        window.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jpLogin, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jpLogin, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        window.pack();
    }
    
    @Override
    public JFrame getFrame() {
        return this.window;
    }
    
    private void btnLoginActionPerformed(ActionEvent evt) {   
        Authenticator logreg = new VerificationLog();
        logreg.setNext(new Login());
        
        User user = logreg.auth(this.textFields[0].getText(), this.textFields[1].getText());
        if(user == null) { 
            Out.show("Datos incorrectos o usuario inexistente."); 
        } else { 
            mediator.notify(this, "home", user.getIdentification());
        }
    }
    
    private void btnSingUpActionPerformed(ActionEvent evt) {                                          
        Authenticator logreg = new VerificationSing();
        logreg.setNext(new SingUp());
        
        User user = logreg.auth(this.textFields[0].getText(), this.textFields[1].getText());
        if(user == null) {
            Out.show("Usuario ya existente.");
        } else{ 
            mediator.notify(this, "home", user.getIdentification()); 
        }
    }
}
