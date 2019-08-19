package Pack;

import java.awt.HeadlessException;
import java.io.File;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Main extends javax.swing.JFrame { 

Connection_DB Con_DB = new Connection_DB();
    
    public Main() {
        DeleteTrashFile();
        initComponents();        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        NameLabel = new javax.swing.JLabel();
        On = new javax.swing.JButton();
        Quit = new javax.swing.JButton();
        PassLabel = new javax.swing.JLabel();
        UserList = new javax.swing.JComboBox<>();
        Pass = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Авторизация");
        setResizable(false);
        setSize(new java.awt.Dimension(200, 100));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                FormStart(evt);
            }
        });

        NameLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        NameLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NameLabel.setText("Имя пользователя");

        On.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        On.setText("Войти");
        On.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OnActionPerformed(evt);
            }
        });

        Quit.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        Quit.setText("Выйти");
        Quit.setFocusable(false);
        Quit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuitActionPerformed(evt);
            }
        });

        PassLabel.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        PassLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        PassLabel.setText("Пароль");

        UserList.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        UserList.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        UserList.setFocusable(false);

        Pass.setFont(new java.awt.Font("Times New Roman", 0, 14)); // NOI18N
        Pass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        Pass.setText("0000");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NameLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(PassLabel, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(UserList, 0, 386, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Pass, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(On, javax.swing.GroupLayout.DEFAULT_SIZE, 386, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Quit, javax.swing.GroupLayout.DEFAULT_SIZE, 388, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NameLabel)
                    .addComponent(PassLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UserList, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(On)
                    .addComponent(Quit))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void OnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OnActionPerformed
        Con_DB.SQL = "SELECT * FROM \"PUBLIC\".AUNT where name like ('%"+UserList.getSelectedItem().toString()+"%')";        
    try {
        Con_DB.RS = Con_DB.CON.createStatement().executeQuery(Con_DB.SQL);
        Con_DB.RS.next();
        String ColumnString = Con_DB.RS.getString("DOSTUP");
        String ColumnPASS = Con_DB.RS.getString("PASS");
        String PaSSS = new String(Pass.getPassword());          
        if (ColumnString.equals("admin") ) {          
            if (PaSSS.equals(ColumnPASS)) {                
                dispose();
                Main main = new Main();
                main.setVisible(false);
                AdminPanel AdPanel = new AdminPanel();
                AdPanel.setVisible(true);               
            } else {
                System.out.println("Пароль не верен!");
                Pass.setText("");
                JOptionPane.showMessageDialog(null, "Пароль не верен!");
            }            
        } else {
            if (PaSSS.equals(ColumnPASS)) {                               
                dispose();
                Main main = new Main();
                main.setVisible(false);
                UserPanel UsPanel = new UserPanel();
                UsPanel.setVisible(true);                
            } else {
                System.out.println("Пароль не верен!");
                JOptionPane.showMessageDialog(null, "Пароль не верен!");
            } 
        }
    } catch (HeadlessException | SQLException e) {        
    }
    }//GEN-LAST:event_OnActionPerformed

    private void FormStart(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_FormStart
        Pass.setText("");
        UserList.setSelectedItem(" ");
        Con_DB.SQL = "SELECT * FROM \"PUBLIC\".AUNT"; 
        Con_DB.Connect();        
        try {
            while (Con_DB.RS.next()) {                
                UserList.addItem(Con_DB.RS.getString("name"));
            }
        } catch (SQLException e) {
            System.out.println("Ошибка чтения базы данных!");
            JOptionPane.showMessageDialog(null, "Ошибка чтения базы данных!");
        }        
    }//GEN-LAST:event_FormStart

    private void QuitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuitActionPerformed
    dispose();    
    }//GEN-LAST:event_QuitActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NameLabel;
    private javax.swing.JButton On;
    private javax.swing.JPasswordField Pass;
    private javax.swing.JLabel PassLabel;
    private javax.swing.JButton Quit;
    private javax.swing.JComboBox<String> UserList;
    // End of variables declaration//GEN-END:variables

    private void DeleteTrashFile() {
        File F = new File("C:\\Program Files\\SoftCorparation\\","DB.trace.db");
        if (F.exists()) {
            F.delete();
        } 
    }
}
