/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;
import java.awt.Toolkit;
import model.*;

/**
 *
 * @author josue
 */
public class window extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(window.class.getName());
    /**
     * Creates new form window
     */
    
    private String[] tem_0 = new String[10];
    
    public window() {
        
        initComponents();
        
        this.Enter(0,0,600,600);
        
    }//window()
    
    public window(int r, int t, int w, int h){
        
        initComponents();
        
        this.Enter(r,t,w,h);
        
    }//window(int r, int t, int w, int h)
    
    public void Title(String title){setTitle(title);}
    
    private void Enter(int r, int t, int w, int h){
        
        setVisible(true);
        setResizable(true);
        
        for(int s = 0; s < tem_0.length; s++) tem_0[s] = "";
        
        var tool = Toolkit.getDefaultToolkit().getScreenSize();
        
        var rw = tool.width - w - 10;
        var th = tool.height - h - 50;
        
        if(rw < 0) rw = 0;
        if(th < 0) th = 0;
        
        if(r < 0) r = 0;
        if(t < 0) t = 0;
        
        if(r > rw) r = rw;
        if(t > th) t = th;
        
        var width = tool.width - r;
        var height = tool.height - t;
        
        if(w > width) w = width;
        if(h > height) h = height;
        
        setBounds(r, t, w, h);
        
    }//Enter(String title, int r, int l, int w, int h)
    
    private void Err(String type, String msg){
        
        Reg.Print(new Data().DataAbreviada(true), "\"" + type + "\"");
        Reg.Print(new Hora(true).TimerGood(false), msg);
        
        System.exit(0);
        
    }//Err(String msg)
    
    public boolean Command(String text){
        
        var ini = txt.text(text, true).split("\n");
        
        try{
            
            var s = 0;
            
            do{
                
                this.tem_0[s] = ini[s];
                s++;
                
            }while(s > 0 && s < ini.length && s < this.tem_0.length);
            
            Tem(0);
            
        }catch(Exception e){
            
            this.Err("Exception", e.getMessage());
            
        }
        
        return ini.length <= this.tem_0.length;
        
    }//Command(String text)
    
    public boolean Home(){
        
        Tem(1);
        
        return false;
        
    }//Home()
    
    public void Tem(int init){
        
        boolean tem[] = new boolean[2];
        
        for(int exe = 0; exe < tem.length; exe++){
            
            if(init >= 0 && init < tem.length){
                
                tem[exe] = exe == init;
                
            } else {//if(init >= 0 && init < tem.length)
                
                tem[exe] = exe == 0;
                
            }//if(init >= 0 && init < tem.length)
            
        }//for(int exe = 0; exe < tem.length; exe++)
        
        Tem_0(tem[0]);
        Tem_1(tem[1]);
        
    }//Tem(int init)
    
    private void Tem_0(boolean execute){
        
        initial.setVisible(execute);
        
        if(execute){
            
            ide.setFont(new java.awt.Font("Segoe UI Black", 0, 36));
            ide.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            ide.setText(Reg.ide);
            
            categories.setFont(new java.awt.Font("Tahoma", 0, 32));
            categories.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            categories.setText(Reg.categories);
            
            choose.setFont(new java.awt.Font("Tahoma", 0, 32));
            choose.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
            choose.setText(Reg.choose + " ".repeat(2));
            
            java.awt.Font t_font = new java.awt.Font("Times New Roman", 2, 18);
            
            txt_1.setFont(t_font);
            txt_1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            txt_1.setVisible(!this.tem_0[0].isBlank());
            txt_1.setText(this.tem_0[0]);
            
            txt_2.setFont(t_font);
            txt_2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            txt_2.setVisible(!this.tem_0[1].isBlank());
            txt_2.setText(this.tem_0[1]);
            
            txt_3.setFont(t_font);
            txt_3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            txt_3.setVisible(!this.tem_0[2].isBlank());
            txt_3.setText(this.tem_0[2]);
            
            txt_4.setFont(t_font);
            txt_4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            txt_4.setVisible(!this.tem_0[3].isBlank());
            txt_4.setText(this.tem_0[3]);
            
            txt_5.setFont(t_font);
            txt_5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            txt_5.setVisible(!this.tem_0[4].isBlank());
            txt_5.setText(this.tem_0[4]);
            
            txt_6.setFont(t_font);
            txt_6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            txt_6.setVisible(!this.tem_0[5].isBlank());
            txt_6.setText(this.tem_0[5]);
            
            txt_7.setFont(t_font);
            txt_7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            txt_7.setVisible(!this.tem_0[6].isBlank());
            txt_7.setText(this.tem_0[6]);
            
            txt_8.setFont(t_font);
            txt_8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            txt_8.setVisible(!this.tem_0[7].isBlank());
            txt_8.setText(this.tem_0[7]);
            
            txt_9.setFont(t_font);
            txt_9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            txt_9.setVisible(!this.tem_0[8].isBlank());
            txt_9.setText(this.tem_0[8]);
            
            txt_10.setFont(t_font);
            txt_10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
            txt_10.setVisible(!this.tem_0[9].isBlank());
            txt_10.setText(this.tem_0[9]);
            
        }//if(execute)
        
    }//Tem_0(boolean execute)
    
    private void Tem_1(boolean execute){
        
        home.setVisible(execute);
        
    }//Tem_1(boolean execute)

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        initial = new javax.swing.JPanel();
        ide = new javax.swing.JLabel();
        categories = new javax.swing.JLabel();
        choose = new javax.swing.JLabel();
        txt_1 = new javax.swing.JLabel();
        txt_2 = new javax.swing.JLabel();
        txt_3 = new javax.swing.JLabel();
        txt_4 = new javax.swing.JLabel();
        txt_5 = new javax.swing.JLabel();
        txt_6 = new javax.swing.JLabel();
        txt_7 = new javax.swing.JLabel();
        txt_8 = new javax.swing.JLabel();
        txt_9 = new javax.swing.JLabel();
        txt_10 = new javax.swing.JLabel();
        home = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        initial.setAlignmentX(0.0F);
        initial.setAlignmentY(0.0F);
        initial.setDoubleBuffered(false);
        initial.setEnabled(false);
        initial.setMaximumSize(new java.awt.Dimension(600, 600));
        initial.setMinimumSize(new java.awt.Dimension(600, 600));
        initial.setPreferredSize(new java.awt.Dimension(600, 600));
        initial.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                initialMouseReleased(evt);
            }
        });
        initial.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                initialKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                initialKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                initialKeyTyped(evt);
            }
        });

        ide.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ide.setText("Java NetBeans IDE 27");
        ide.setPreferredSize(new java.awt.Dimension(186, 500));

        categories.setText("Java width Ant");
        categories.setPreferredSize(new java.awt.Dimension(90, 200));

        choose.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        choose.setText("Java Application");
        choose.setPreferredSize(new java.awt.Dimension(90, 200));

        txt_1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_1.setText("1");
        txt_1.setAutoscrolls(true);
        txt_1.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txt_2.setText("2");

        txt_3.setText("3");

        txt_4.setText("4");

        txt_5.setText("5");

        txt_6.setText("6");

        txt_7.setText("7");

        txt_8.setText("8");

        txt_9.setText("9");

        txt_10.setText("10");

        javax.swing.GroupLayout initialLayout = new javax.swing.GroupLayout(initial);
        initial.setLayout(initialLayout);
        initialLayout.setHorizontalGroup(
            initialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(initialLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(initialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ide, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(initialLayout.createSequentialGroup()
                        .addComponent(categories, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(choose, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, initialLayout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(initialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_2, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_3, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_4, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_5, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_6, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_7, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_8, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_9, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_10, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addGap(8, 8, 8))
        );
        initialLayout.setVerticalGroup(
            initialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(initialLayout.createSequentialGroup()
                .addComponent(ide, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(initialLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categories, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choose, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(txt_1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_6, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_8, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_9, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txt_10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 214, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(initial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(initial, javax.swing.GroupLayout.PREFERRED_SIZE, 413, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void initialKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_initialKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_initialKeyReleased

    private void initialKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_initialKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_initialKeyPressed

    private void initialKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_initialKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_initialKeyTyped

    private void initialMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_initialMouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_initialMouseReleased

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new window().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel categories;
    private javax.swing.JLabel choose;
    private javax.swing.JPanel home;
    private javax.swing.JLabel ide;
    private javax.swing.JPanel initial;
    private javax.swing.JLabel txt_1;
    private javax.swing.JLabel txt_10;
    private javax.swing.JLabel txt_2;
    private javax.swing.JLabel txt_3;
    private javax.swing.JLabel txt_4;
    private javax.swing.JLabel txt_5;
    private javax.swing.JLabel txt_6;
    private javax.swing.JLabel txt_7;
    private javax.swing.JLabel txt_8;
    private javax.swing.JLabel txt_9;
    // End of variables declaration//GEN-END:variables
}
