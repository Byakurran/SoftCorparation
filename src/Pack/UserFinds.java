package Pack;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

public class UserFinds extends javax.swing.JFrame {

Connection_DB Con_DB = new Connection_DB();

String SQL = "SELECT * FROM \"PUBLIC\".SOFTCORPARATION";


    public UserFinds() {
        initComponents();                
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        TableData = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Список проектов (Администратор)");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                FormStart(evt);
            }
        });

        TableData.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "1", "2", "3", "4", "5", "6", "7", "8"
            }
        ));
        jScrollPane1.setViewportView(TableData);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1045, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void FormStart(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_FormStart
        CleanTable();
        Show_User();         
    }//GEN-LAST:event_FormStart
    public ArrayList<User> UserList(){
        ArrayList<User> userList = new ArrayList<>();                       
        User user;
    try {            
        while (Con_DB.RS.next()) {
            user = new User(Con_DB.RS.getString("NAME"),Con_DB.RS.getString("STATUS"),Con_DB.RS.getString("PROJECT"),Con_DB.RS.getString("PROJECT_TEMA"),Con_DB.RS.getString("PROJECT_TIP"),Con_DB.RS.getString("PROJECT_PRIORY"),Con_DB.RS.getString("PROJECTSTATUS"),Con_DB.RS.getString("OPISANIE"));
            userList.add(user);
        }
    } catch (SQLException ex) {
        Logger.getLogger(UserFinds.class.getName()).log(Level.SEVERE, null, ex);
    }
    return userList;
    }
    
    public void Show_User() {
        Con_DB.SQL = SQL;
        Con_DB.Connect();
        ArrayList<User> List =  UserList();
        DefaultTableModel Model = (DefaultTableModel) TableData.getModel();
        Object ROW [] = new Object[8];
        for (int i = 0; i < List.size(); i++) {
                ROW [0] = List.get(i).getNAME();
                ROW [1] = List.get(i).getSTATUS();
                ROW [2] = List.get(i).getPROJECT();
                ROW [3] = List.get(i).getTEMA_Project();
                ROW [4] = List.get(i).getTip_Project();
                ROW [5] = List.get(i).getProject_Priory();
                ROW [6] = List.get(i).getS_PROJECT();
                ROW [7] = List.get(i).getOpisanie();
                Model.addRow(ROW);
        }
    }
    
    
    public void CleanTable() {
          TableData.setModel(new DefaultTableModel(null,new String[]{"Имя сотрудника","Должность","Проект","Тема проекта","Тип проекта","Приоритет проекта","Статус проекта","Описание проекта"}));          
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserFinds.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    //</editor-fold>
    
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserFinds().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TableData;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
  

}
