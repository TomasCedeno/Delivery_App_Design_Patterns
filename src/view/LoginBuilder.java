
package view;

import javax.swing.*;
import logic.account.User;
import logic.authenticator.*;
import test.Out;

public class LoginBuilder implements GUIBuilder {
    private JFrame window;
    private JLabel[] labels;
    private JButton[] buttons;
    private JTextField[] textFields;
    
    public LoginBuilder(){
        this.window = new JFrame();
        this.labels = new JLabel[4];
        this.buttons = new JButton[2];
        this.textFields = new JTextField[2];
        
    }
    
    @Override
    public void createLabels() {
        labels[0] = new javax.swing.JLabel();
        labels[1] = new javax.swing.JLabel();
        labels[2] = new javax.swing.JLabel();
        labels[3] = new javax.swing.JLabel();
        
        labels[0].setFont(new java.awt.Font("Lucida Fax", 1, 48));
        labels[0].setText("HAWK SHIPPING");
        
        labels[1].setFont(new java.awt.Font("Lucida Fax", 0, 14));
        labels[1].setText("<html> <p text-aling: center>Bienvenido a nuestra app de envíos,<br>inicia sesión con tu cuenta o crea una nueva<br>para disfrutar de nuestros servicios.</p> </html>");
        
        labels[2].setFont(new java.awt.Font("Lucida Fax", 0, 14));
        labels[2].setText("E-mail:");
        
        labels[3].setFont(new java.awt.Font("Lucida Fax", 0, 14));
        labels[3].setText("Contraseña:");
    }

    @Override
    public void createButtons() {
        buttons[0] = new javax.swing.JButton();
        buttons[1] = new javax.swing.JButton();
        
        buttons[0].setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        buttons[0].setText("Iniciar sesión");
        
        buttons[1].setFont(new java.awt.Font("Lucida Fax", 0, 14)); // NOI18N
        buttons[1].setText("Registrarse");
    }

    @Override
    public void createTextFields() {
        textFields[0] = new javax.swing.JTextField();
        textFields[1] = new javax.swing.JTextField();
    }   
    
    @Override
    public void addEvents() {
        buttons[0].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        
        buttons[1].addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSingUpActionPerformed(evt);
            }
        });
    }
    
    @Override
    public void createWindow() {
        window.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        JPanel jpLogin = new javax.swing.JPanel();  
        
        javax.swing.GroupLayout jpLoginLayout = new javax.swing.GroupLayout(jpLogin);
        jpLogin.setLayout(jpLoginLayout);
        jpLoginLayout.setHorizontalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(labels[0]))
                    .addGroup(jpLoginLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(labels[1], javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jpLoginLayout.createSequentialGroup()
                                    .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(labels[2])
                                        .addComponent(labels[3]))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(textFields[0], javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textFields[1], javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpLoginLayout.createSequentialGroup()
                                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(buttons[1], javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(buttons[0], javax.swing.GroupLayout.Alignment.LEADING))
                                .addGap(80, 80, 80)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        jpLoginLayout.setVerticalGroup(
            jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpLoginLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(labels[0])
                .addGap(18, 18, 18)
                .addComponent(labels[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labels[2])
                    .addComponent(textFields[0], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jpLoginLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labels[3])
                    .addComponent(textFields[1], javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(buttons[0])
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttons[1])
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(window.getContentPane());
        window.getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        window.pack();
    }
    
    @Override
    public JFrame getFrame() {
        return this.window;
    }
    
    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {                                         
        Authenticator logreg = new VerificationLog();
        logreg.setNext(new Login());
        User user = logreg.auth(this.textFields[0].getText(), this.textFields[1].getText());
        if(user == null) { Out.show("Datos incorrectos o usuario inexistente."); }
        else{ window.dispose(); }
    }
    
    private void btnSingUpActionPerformed(java.awt.event.ActionEvent evt) {                                          
        Authenticator logreg = new VerificationSing();
        logreg.setNext(new SingUp());
        User user = logreg.auth(this.textFields[0].getText(), this.textFields[1].getText());
        if(user == null) { Out.show("Usuario ya existente."); }
        else{ window.dispose(); }
    }
}
