/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
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
    
    private final float AlignmentX = 0f;
    private final float AlignmentY = 0f;
    
    private String home_file_font_into;
    private String home_file_font;
    
    private Painel_1 pg1 = null;
    
    public window() {
        
        initComponents();
        
        this.Enter(0,0,600,600);
        
    }//window()
    
    public window(int r, int t, int w, int h){
        
        initComponents();
        
        this.Enter(r,t,w,h);
        
    }//window(int r, int t, int w, int h)
    
    private void Enter(int r, int t, int w, int h){
        
        setVisible(true);
        setResizable(true);
        
        this.home_file_font_into = "";
        this.home_file_font = "";
        
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
    
    public boolean Page_0(String title, String text){
        
        setTitle(title);
        
        initial.setAlignmentX(AlignmentX);
        initial.setAlignmentY(AlignmentY);
        
        String[] tem_0 = new String[10];
        
        for(int s = 0; s < tem_0.length; s++) tem_0[s] = "";
        
        var ini = txt.text(text, true).split("\n");
        
        try{
            
            var s = 0;
            
            do{
                
                tem_0[s] = ini[s];
                s++;
                
            }while(s > 0 && s < ini.length && s < tem_0.length);
            
            Tem(0);
            
        }catch(Exception e){
            
            this.Err("Exception", e.getMessage());
            
        }
            
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
        txt_1.setVisible(!tem_0[0].isBlank());
        txt_1.setText(tem_0[0]);
        
        txt_2.setFont(t_font);
        txt_2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_2.setVisible(!tem_0[1].isBlank());
        txt_2.setText(tem_0[1]);
        
        txt_3.setFont(t_font);
        txt_3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_3.setVisible(!tem_0[2].isBlank());
        txt_3.setText(tem_0[2]);
        
        txt_4.setFont(t_font);
        txt_4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_4.setVisible(!tem_0[3].isBlank());
        txt_4.setText(tem_0[3]);
        
        txt_5.setFont(t_font);
        txt_5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_5.setVisible(!tem_0[4].isBlank());
        txt_5.setText(tem_0[4]);
        
        txt_6.setFont(t_font);
        txt_6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_6.setVisible(!tem_0[5].isBlank());
        txt_6.setText(tem_0[5]);
        
        txt_7.setFont(t_font);
        txt_7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_7.setVisible(!tem_0[6].isBlank());
        txt_7.setText(tem_0[6]);
        
        txt_8.setFont(t_font);
        txt_8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_8.setVisible(!tem_0[7].isBlank());
        txt_8.setText(tem_0[7]);
        
        txt_9.setFont(t_font);
        txt_9.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_9.setVisible(!tem_0[8].isBlank());
        txt_9.setText(tem_0[8]);
        
        txt_10.setFont(t_font);
        txt_10.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        txt_10.setVisible(!tem_0[9].isBlank());
        txt_10.setText(tem_0[9]);
        
        return ini.length <= tem_0.length;
        
    }//Page_0(String title, String text)
    
    public void Home(Painel_1 pg_1){
        
        this.pg1 = pg_1;
        this.Page_1();
        
    }//Home(Painel_1 pg_1)
    
    private void Page_1(){
        
        if(this.pg1 == null){
            
            System.exit(0);
            
        } else {
            
            this.home_file_font_into = this.pg1.Font_Init();
            this.home_file_font = this.pg1.Font_Key();

            setTitle(this.pg1.Title(true));

            initial.setAlignmentX(AlignmentX);
            initial.setAlignmentY(AlignmentY);

            home_title.setText(this.pg1.Title(false));
            home_title.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
            home_title.setFont(new java.awt.Font("Impact", 0, 22));

            home_action.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);        
            home_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

            home_action.setText("SALVAR");
            home_exit.setText("LIMPAR");

            home_action.setFont(new java.awt.Font("Bernard MT Condensed", 0, 32));
            home_exit.setFont(new java.awt.Font("Bernard MT Condensed", 0, 32));

            home_action.setBackground(Color.decode("#008b8b"));
            home_exit.setBackground(Color.decode("#8b0000"));

            home_action.setForeground(Color.decode("#f5f5f5"));
            home_exit.setForeground(Color.decode("#f0f8ff"));

            home_file.setFont(new java.awt.Font(this.pg1.Font_Init(), 1, 22));
            home_file_enter.setFont(new java.awt.Font("Bernard MT Condensed", 1, 26));

            home_file.setBackground(Color.white);
            home_file_enter.setBackground(Color.decode("#008b8b"));

            home_file.setForeground(Color.black);
            home_file_enter.setForeground(Color.decode("#f0f8ff"));

            home_file.setText("");
            home_file_enter.setText("ADD");
            
            list_page1.setModel(new javax.swing.AbstractListModel<String>() {
                String[] strings = pg1.List();
                public int getSize() { return strings.length; }
                public String getElementAt(int i) { return strings[i]; }
            });
            
            Tem(1);
            
        }
        
    }
    
    public void Page_1(String title_1, String title_2, String FontInit, String FontKey){
        
        this.home_file_font_into = FontInit;
        this.home_file_font = FontKey;
        
        setTitle(title_1);
        
        initial.setAlignmentX(AlignmentX);
        initial.setAlignmentY(AlignmentY);
        
        home_title.setText(title_2);
        home_title.setHorizontalAlignment(javax.swing.SwingConstants.LEADING);
        home_title.setFont(new java.awt.Font("Impact", 0, 22));
        
        home_action.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);        
        home_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        
        home_action.setText("SALVAR");
        home_exit.setText("LIMPAR");
        
        home_action.setFont(new java.awt.Font("Bernard MT Condensed", 0, 32));
        home_exit.setFont(new java.awt.Font("Bernard MT Condensed", 0, 32));
        
        home_action.setBackground(Color.decode("#008b8b"));
        home_exit.setBackground(Color.decode("#8b0000"));
        
        home_action.setForeground(Color.decode("#f5f5f5"));
        home_exit.setForeground(Color.decode("#f0f8ff"));
        
        home_file.setFont(new java.awt.Font(FontInit, 1, 22));
        home_file_enter.setFont(new java.awt.Font("Bernard MT Condensed", 1, 26));
        
        home_file.setBackground(Color.white);
        home_file_enter.setBackground(Color.decode("#008b8b"));
        
        home_file.setForeground(Color.black);
        home_file_enter.setForeground(Color.decode("#f0f8ff"));
        
        home_file.setText("");
        home_file_enter.setText("ADD");
        
        Tem(1);
        
    }//Page_1(String title_1, String title_2)
    
    public void Tem(int init){
        
        boolean tem[] = new boolean[2];
        
        for(int exe = 0; exe < tem.length; exe++){
            
            if(init >= 0 && init < tem.length){
                
                tem[exe] = exe == init;
                
            } else {//if(init >= 0 && init < tem.length)
                
                tem[exe] = exe == 0;
                
            }//if(init >= 0 && init < tem.length)
            
        }//for(int exe = 0; exe < tem.length; exe++)
        
        initial.setVisible(tem[0]);
        home.setVisible(tem[1]);
        
    }//Tem(int init)

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
        jScrollPane1 = new javax.swing.JScrollPane();
        list_page1 = new javax.swing.JList<>();
        home_title = new javax.swing.JLabel();
        home_action = new javax.swing.JButton();
        home_exit = new javax.swing.JButton();
        home_file = new javax.swing.JTextField();
        home_file_enter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(300, 0));

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
                        .addGap(0, 6, Short.MAX_VALUE)))
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
                .addContainerGap(225, Short.MAX_VALUE))
        );

        home.setAlignmentX(0.0F);
        home.setAlignmentY(0.0F);
        home.setMaximumSize(new java.awt.Dimension(600, 32767));
        home.setMinimumSize(new java.awt.Dimension(300, 300));
        home.setPreferredSize(new java.awt.Dimension(600, 600));

        list_page1.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(list_page1);

        home_title.setText("jLabel1");

        home_action.setText("jButton1");
        home_action.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_actionActionPerformed(evt);
            }
        });

        home_exit.setText("jButton2");
        home_exit.setAlignmentY(0.0F);
        home_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_exitActionPerformed(evt);
            }
        });

        home_file.setText("jTextField1");
        home_file.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                home_fileKeyReleased(evt);
            }
        });

        home_file_enter.setText("jButton1");
        home_file_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_file_enterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(home_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(homeLayout.createSequentialGroup()
                        .addComponent(home_action, javax.swing.GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(home_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(homeLayout.createSequentialGroup()
                        .addComponent(home_file)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(home_file_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(home_title, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(home_file)
                    .addComponent(home_file_enter, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(home_action, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(home_exit, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(165, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(initial, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(initial, javax.swing.GroupLayout.DEFAULT_SIZE, 624, Short.MAX_VALUE)
                .addGap(29, 29, 29)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 52, Short.MAX_VALUE))
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

    private void home_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_exitActionPerformed
        
        if(this.pg1 == null){
            
            controller.HomeClear();
            
        } else {
            
            this.pg1.Limpar();
            
        }
        
    }//GEN-LAST:event_home_exitActionPerformed

    private void home_actionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_actionActionPerformed
        
        if(this.pg1 == null){
            
            controller.HomeEnter();
            
        } else {//if(this.pg1 == null)
            
            pg1.Salvar();
            
        }//if(this.pg1 == null)
        
    }//GEN-LAST:event_home_actionActionPerformed

    private void home_fileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_home_fileKeyReleased
        
        var tam = home_file.getText().length();
        
        if(this.pg1 == null){
        
            switch(evt.getKeyCode()){

                case 10 -> controller.HomeFile(home_file.getText());

                default -> {

                    if(tam <= 10){

                        home_file.setFont(new java.awt.Font(this.home_file_font_into, 1, 22));

                    } else if(tam <= 20){

                        home_file.setFont(new java.awt.Font(this.home_file_font_into, 0, 22));

                    } else if(tam <= 40){

                        home_file.setFont(new java.awt.Font(this.home_file_font, 0, 22));

                    } else if(tam <= 60){

                        home_file.setFont(new java.awt.Font(this.home_file_font, 0, 20));

                    } else if(tam <= 80){

                        home_file.setFont(new java.awt.Font(this.home_file_font, 0, 18));

                    } else if(tam <= 100){

                        home_file.setFont(new java.awt.Font(this.home_file_font, 0, 16));

                    } else if(tam <= 150){

                        home_file.setFont(new java.awt.Font(this.home_file_font, 0, 14));

                    } else if(tam <= 200){

                        home_file.setFont(new java.awt.Font(this.home_file_font, 0, 12));

                    } else {

                        home_file.setFont(new java.awt.Font(this.home_file_font, 0, 10));

                    }

                }//default

            }//switch(evt.getKeyCode())
        
        } else {
            
            switch(evt.getKeyCode()){

                case 10 -> this.pg1.Adicionar(false);

                default -> {

                    if(tam <= 10){

                        home_file.setFont(new java.awt.Font(this.pg1.Font_Init(), 1, 22));

                    } else if(tam <= 20){

                        home_file.setFont(new java.awt.Font(this.pg1.Font_Init(), 0, 22));

                    } else if(tam <= 40){

                        home_file.setFont(new java.awt.Font(this.pg1.Font_Key(), 0, 22));

                    } else if(tam <= 60){

                        home_file.setFont(new java.awt.Font(this.pg1.Font_Key(), 0, 20));

                    } else if(tam <= 80){

                        home_file.setFont(new java.awt.Font(this.pg1.Font_Key(), 0, 18));

                    } else if(tam <= 100){

                        home_file.setFont(new java.awt.Font(this.pg1.Font_Key(), 0, 16));

                    } else if(tam <= 150){

                        home_file.setFont(new java.awt.Font(this.pg1.Font_Key(), 0, 14));

                    } else if(tam <= 200){

                        home_file.setFont(new java.awt.Font(this.pg1.Font_Key(), 0, 12));

                    } else {

                        home_file.setFont(new java.awt.Font(this.pg1.Font_Key(), 0, 10));

                    }

                }//default

            }//switch(evt.getKeyCode())
            
        }
        
    }//GEN-LAST:event_home_fileKeyReleased

    private void home_file_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_file_enterActionPerformed
        
        if(this.pg1 == null){
            
            controller.HomeFile(home_file.getText());
            
        } else {
            
            this.pg1.Adicionar(true);
            
        }
        
    }//GEN-LAST:event_home_file_enterActionPerformed

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
    private javax.swing.JButton home_action;
    private javax.swing.JButton home_exit;
    private javax.swing.JTextField home_file;
    private javax.swing.JButton home_file_enter;
    private javax.swing.JLabel home_title;
    private javax.swing.JLabel ide;
    private javax.swing.JPanel initial;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> list_page1;
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
