/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PBL;
import java.sql.*;
import javax.swing.JOptionPane;

/**
 *
 * @author MANIAC
 */
public class TEMPLATE extends javax.swing.JFrame {
Connection c = null;
Statement stmt = null;
ResultSet rs =null;
PreparedStatement pst=null;
int n=1 ,f,i,j;
String r ,rc;
    /**
     * Crates new form TEMPLATE
     */
    public TEMPLATE() {
        initComponents();
      rc=creation();
      truncate();
        f=loopdb();
        i=loop();
        
    }
    public String creation()
    {
        
        c=Pconnect.ConnectDB();
        try
        {
            stmt= c.createStatement();
            rs = stmt.executeQuery("Select roll from s_info");
            while (rs.next()){
           r = rs.getString("roll");
           
           
           String sql1= "create table " +"A"+ r +
                   "( cans varchar(100))";
           stmt.executeUpdate(sql1);
           
           
        }
        } catch (Exception e)
                {
                    
                }
        
        return r;
        }
    public int loopdb()
    {
    c=Pconnect.ConnectDB();
   
        try
        {
            System.out.println(r);
            stmt = c.createStatement();
            rs = stmt.executeQuery("Select id from q_table");
            while (rs.next()){
            j = rs.getInt("id");
            
            }
            rs.close();
            stmt.close();
            c.close();
            
            
            
            
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);               
        }
        System.out.println(j);
        return j;
    }
    public void truncate()
    {
        c=Pconnect.ConnectDB();
        try{
           
         stmt = c.createStatement();
        String sql2 ="Truncate table "+"A"+ r ;
           
            stmt.executeUpdate(sql2);
    }
        catch (Exception e)
        {
         
        }
    }
public int loop(){
   
  System.out.println(n);
   c=Pconnect.ConnectDB();
        try
        {
            
            stmt = c.createStatement();
            rs = stmt.executeQuery("Select * from q_table where id ="+ n);
            while (rs.next()){
            String q = rs.getString("question");
            String o1x = rs.getString("option1");
            String o2x = rs.getString("option2");
            String o3x = rs.getString("option3");
            String o4x = rs.getString("option4");
           
            
            Q.setText(q);
            o1.setText(o1x);
            o2.setText(o2x);
            o3.setText(o3x);
            o4.setText(o4x);
            
            
            }
            rs.close();
            stmt.close();
            c.close();
            
            
            
            
        }
        catch (Exception e)
        {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);               
        }
        n++;
   buttonGroup1.clearSelection();
   return n;
}
 
public void select(){
    c=Pconnect.ConnectDB();
            try
            {
                System.out.println("ddddd");
                
                String sql ="insert into "+"A"+ r +"(cans) values (?)";
            pst=c.prepareStatement(sql);
            if (o1.isSelected())
            {
                 pst.setString(1,o1.getText());
            }
            else if (o2.isSelected())
            {
                 pst.setString(1,o2.getText());
            }
            else if (o3.isSelected())
            {
                 pst.setString(1,o3.getText());
             
            }
            else if (o4.isSelected())
            {
                 pst.setString(1,o4.getText());
            }
            
            pst.execute();
            c.close();
            
            }
            catch (Exception e)
            {
                
            }


            
}



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        o1 = new javax.swing.JRadioButton();
        o2 = new javax.swing.JRadioButton();
        o3 = new javax.swing.JRadioButton();
        o4 = new javax.swing.JRadioButton();
        Q = new javax.swing.JTextField();
        SUBMIT = new javax.swing.JButton();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(o1);

        buttonGroup1.add(o2);

        buttonGroup1.add(o3);

        buttonGroup1.add(o4);

        SUBMIT.setText("Submit");
        SUBMIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SUBMITActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Q)
                    .addComponent(o1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(o2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(o3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(o4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 315, Short.MAX_VALUE)
                        .addComponent(SUBMIT)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Q, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(o1)
                .addGap(17, 17, 17)
                .addComponent(o2)
                .addGap(18, 18, 18)
                .addComponent(o3)
                .addGap(18, 18, 18)
                .addComponent(o4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
                .addComponent(SUBMIT)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SUBMITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SUBMITActionPerformed
if(n<=j)
{
    if(buttonGroup1.getSelection()==null)
            {
                JOptionPane.showMessageDialog(null,"NO OPTION SELECTED ");
            }else
    {
    select();
f=loopdb();
    i=loop();
    }
}
else
{
    if(buttonGroup1.getSelection()==null)
            {
                JOptionPane.showMessageDialog(null,"NO OPTION SELECTED ");
            }
    
    else
    {
     FINAL_RESULT K=new FINAL_RESULT();
    K.setVisible(true);
    setVisible(false);
    }
    
}

        
// TODO add your handling code here:
    }//GEN-LAST:event_SUBMITActionPerformed

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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TEMPLATE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TEMPLATE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TEMPLATE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TEMPLATE.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TEMPLATE().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Q;
    private javax.swing.JButton SUBMIT;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JRadioButton o1;
    private javax.swing.JRadioButton o2;
    private javax.swing.JRadioButton o3;
    private javax.swing.JRadioButton o4;
    // End of variables declaration//GEN-END:variables
}
