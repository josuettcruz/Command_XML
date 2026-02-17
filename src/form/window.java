/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import static form.pg1sm.multiple;
import static form.pg1sm.single;
import model.*;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

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
    
    private final String home_file_font_into = "Aptos Black";
    private final String home_file_font = "Agency FB";
    
    private Painel_1Single pg1s;
    private Painel_1Multiple pg1m;
    private pg1sm pg1 = pg1sm.none;
    private boolean pg1_input_user = false;
    
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
    
    private void Tem(int init){
        
        boolean tem[] = new boolean[3];
        
        for(int exe = 0; exe < tem.length; exe++){
            
            if(init > 0 && init < tem.length){
                
                tem[exe] = exe == init;
                
            } else {//if(init >= 0 && init < tem.length)
                
                tem[exe] = exe == 0;
                
            }//if(init >= 0 && init < tem.length)
            
        }//for(int exe = 0; exe < tem.length; exe++)
        
        initial.setVisible(tem[0]);
        home.setVisible(tem[1]);
        contain.setVisible(tem[2]);
        
    }//Tem(int init)
    
    public boolean Page_0(String title, String text){
        
        setTitle(title);
        
        initial.setAlignmentX(AlignmentX);
        initial.setAlignmentY(AlignmentY);
        
        String[] tem_0 = new String[10];
        
        for(int s = 0; s < tem_0.length; s++) tem_0[s] = "";
        
        var ini = txt.text(text, true).split("\n");
            
        var s = 0;

        do{

            tem_0[s] = ini[s];
            s++;

        }while(s > 0 && s < ini.length && s < tem_0.length);
            
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

        this.Tem(0);
        
        return ini.length <= tem_0.length;
        
    }//Page_0(String title, String text)
    
    private void Page_1(boolean button, String action){
        
        var Page_1_String1 = "\"";
        Page_1_String1 += action;
        Page_1_String1 += "\"";
        
        var Page_1_String2 = "Impossível executar a ação do ";
        Page_1_String2 += button ? "mouse" : "teclase";
        Page_1_String2 += "!";
        
        Reg.Print(Page_1_String1, Page_1_String2);
        
        Reg.Print(
            new Hora(true).TimerGood(false),
            new Data().DataCompleta(true)
        );
        
        System.exit(0);
        
    }//Err(String msg)
    
    private void Page_1(boolean visible){
        
        home_action.setVisible(visible);
        home_exit.setVisible(visible);
        
    }//Page_1(boolean visible)
    
    private void Page_1Single(){
        
        if(this.pg1s != null){
            
            list_page1.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION
            );
            
            final var max_list = this.pg1s.ListColumn()
                && this.pg1s.List().size() > 1;
            
            final var list_empty = this.pg1s.List().isEmpty();
            
            final var repeat_char_list = " ".repeat(5);

            setTitle(this.pg1s.Title(true));

            home.setAlignmentX(AlignmentX);
            home.setAlignmentY(AlignmentY);

            home_title.setText(this.pg1s.Title(false));
            home_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            home_title.setFont(new java.awt.Font("Impact", 0, 22));

            home_action.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);        
            home_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

            home_action.setText("ABRIR");
            home_exit.setText("APAGAR");

            home_action.setFont(new java.awt.Font("Bernard MT Condensed", 0, 32));
            home_exit.setFont(new java.awt.Font("Bernard MT Condensed", 0, 32));

            home_action.setBackground(Color.decode("#008b8b"));
            home_exit.setBackground(Color.decode("#8b0000"));

            home_action.setForeground(Color.decode("#f5f5f5"));
            home_exit.setForeground(Color.decode("#f0f8ff"));

            home_file.setAutoscrolls(false);
            home_file_enter.setAutoscrolls(false);

            home_file.setFont(new java.awt.Font(this.home_file_font_into, 1, 22));
            home_file_enter.setFont(new java.awt.Font("Bernard MT Condensed", 1, 26));

            home_file.setBackground(Color.white);
            home_file_enter.setBackground(Color.decode("#008b8b"));

            home_file.setForeground(Color.black);
            home_file_enter.setForeground(Color.decode("#f0f8ff"));

            home_file.setText(this.pg1s.InputText(this.pg1_input_user));
            home_file_enter.setText("ADD");
            
            String[] data = new String[list_empty ? 2 : this.pg1s.List().size()];
            
            if(list_empty){
                
                for(int dat = 0; dat < data.length; dat++){
                    
                    data[dat] = dat == 0
                        ? repeat_char_list
                        + "A lista está vazia!"
                        : "";
                    
                }//for(int dat = 0; dat < data.length; dat++)
                
            } else {//if(list_empty)
                
                for(
                    int i = 0;
                    i < this.pg1s.List().size() && i < data.length;
                    i++
                )
                {
                    
                    data[i] = repeat_char_list;
                    
                    if(this.pg1s.List().get(i).length() > 200){
                        
                        data[i] += this.pg1s.List().get(i).substring(0,197);
                        data[i] += "...";
                        
                    } else {
                        
                        data[i] += this.pg1s.List().get(i);
                        
                    }
                    
                    if(max_list) data[i] += repeat_char_list;
                    
                }//for(int i = 0; i < this.pg1.List().size() && i < data...
                
            }//if(list_empty)
            
            list_page1.setAutoscrolls(true);
            list_page1.setLayoutOrientation(max_list ? 1 : 0);
            list_page1.setFont(this.pg1s.ListFont());
            list_page1.setListData(data);
            
            this.Page_1(false);
            
            this.Tem(1);
            
        }//if(this.pg1 != null)
        
    }//Page_1Single()
    
    private List<Domain> Page_1(List<Domain> view){
        
        List<Domain> demo = new ArrayList();
        List<Integer> test = new ArrayList();
        
        for(Domain insert : view){
            
            test.add(insert.index());
            
            Domain ad = insert;
            boolean acept = false;
            
            if(test.size() > 1){
                
                acept = true;
                Integer add = 0;
                
                do{
                    
                    if(test.get(add) == ad.index()) acept = false;
                    
                    add++;
                    
                }while(acept && add > 0 && add < test.size());
                
            }//if(test.size() > 1)
            
            if(insert.index() < 0) acept = false;
            
            if(acept){
                
                ad.Select(false);
                demo.add(ad);
                
            }//if(acept)
            
        }//for(Domain insert : view)
        
        return demo;
        
    }//Page_1(List<Domain> view)
    
    public List<Domain> Pg1m(){
        
        List<Domain> tema = new ArrayList();
        
        for(Domain insert : this.pg1m.ListMode()){
            
            Domain d = insert;
            
            int[] select = list_page1.getSelectedIndices();
            boolean selected = false;
            int for_each = 0;
            
            do{
                
                selected = d.index() == select[for_each];
                
                for_each++;
                
            }while(!selected && for_each > 0 && for_each < select.length);
            
            d.Select(selected);
            
            tema.add(d);
            
        }//for(Domain insert : this.pg1m.ListMode())
        
        return tema;
        
    }//Pg1m()
    
    private void Page_1Multiple(){
        
        if(this.pg1s != null){
            
            list_page1.setSelectionMode(
                javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
            );
            
            final var list_empty = this.pg1m.ListMode().isEmpty();
            
            final var max_list = this.pg1m.ListColumn()
                && this.pg1m.ListMode().size() > 1;
            
            final var repeat_char_list = " ".repeat(5);
            
            List<Domain> d = this.Page_1(this.pg1m.ListMode());

            setTitle(this.pg1s.Title(true));

            home.setAlignmentX(AlignmentX);
            home.setAlignmentY(AlignmentY);

            home_title.setText(this.pg1m.Title(false));
            home_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            home_title.setFont(new java.awt.Font("Impact", 0, 22));

            home_action.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);        
            home_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

            home_action.setText("ABRIR");
            home_exit.setText("APAGAR");

            home_action.setFont(new java.awt.Font("Bernard MT Condensed", 0, 32));
            home_exit.setFont(new java.awt.Font("Bernard MT Condensed", 0, 32));

            home_action.setBackground(Color.decode("#008b8b"));
            home_exit.setBackground(Color.decode("#8b0000"));

            home_action.setForeground(Color.decode("#f5f5f5"));
            home_exit.setForeground(Color.decode("#f0f8ff"));

            home_file.setAutoscrolls(false);
            home_file_enter.setAutoscrolls(false);

            home_file.setFont(new java.awt.Font(this.home_file_font_into, 1, 22));
            home_file_enter.setFont(new java.awt.Font("Bernard MT Condensed", 1, 26));

            home_file.setBackground(Color.white);
            home_file_enter.setBackground(Color.decode("#008b8b"));

            home_file.setForeground(Color.black);
            home_file_enter.setForeground(Color.decode("#f0f8ff"));

            home_file.setText(this.pg1m.InputText(this.pg1_input_user));
            home_file_enter.setText("ADD");
            
            String[] data = new String[list_empty ? 2 : this.pg1m.ListMode().size()];
            
            if(list_empty){
                
                for(int dat = 0; dat < data.length; dat++){
                    
                    data[dat] = dat == 0
                        ? repeat_char_list
                        + "A lista está vazia!"
                        : "";
                    
                }//for(int dat = 0; dat < data.length; dat++)
                
            } else {//if(list_empty)
                
                for(
                    int i = 0;
                    i < d.size() && i < data.length;
                    i++
                )
                {
                    
                    var ad = d.get(i).Text(true);
                    
                    data[i] = repeat_char_list;
                    
                    if(ad.length() > 200){
                        
                        data[i] += ad.substring(0,197);
                        data[i] += "...";
                        
                    } else {
                        
                        data[i] += ad;
                        
                    }
                    
                    if(max_list) data[i] += repeat_char_list;
                    
                }//for(int i = 0; i < this.pg1.List().size() && i < data...
                
            }//if(list_empty)
            
            list_page1.setAutoscrolls(true);
            list_page1.setLayoutOrientation(max_list ? 1 : 0);
            list_page1.setFont(this.pg1s.ListFont());
            list_page1.setListData(data);
            
            this.Page_1(false);
            
            this.Tem(1);
            
        }//if(this.pg1 != null)
        
    }//Page_1Single()
    
    public void Page_1(Painel_1Single inteface_page_1){
        
        this.pg1 = pg1sm.single;
        this.pg1s = inteface_page_1;
        this.Page_1Single();
        
    }//Page_1(Painel_1 interace_page_1)
    
    public void Page_1(Painel_1Multiple inteface_page_1){
        
        this.pg1 = pg1sm.multiple;
        this.pg1m = inteface_page_1;
        this.Page_1Multiple();
        
    }//Page_1(Painel_1 interace_page_1)
    
    public void Pg1_select(boolean no_input){
        
        if(no_input) home_file.requestFocus();
        
        if(this.pg1s.List().size() > 1){
            
            list_page1.setSelectedIndex(0);
            
        }//if(this.pg1.List().size() > 1)
        
    }//Pg1_select(boolean input)

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
        contain = new javax.swing.JPanel();
        title_pg2 = new javax.swing.JLabel();
        input_pg2 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        list_page2 = new javax.swing.JTable();
        active = new javax.swing.JButton();

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
                .addContainerGap(201, Short.MAX_VALUE))
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
        list_page1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        list_page1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                list_page1MouseReleased(evt);
            }
        });
        list_page1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                list_page1KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(list_page1);

        home_title.setText("jLabel1");

        home_action.setText("ABRIR");
        home_action.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_actionActionPerformed(evt);
            }
        });

        home_exit.setText("APAGAR");
        home_exit.setAlignmentY(0.0F);
        home_exit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_exitActionPerformed(evt);
            }
        });

        home_file.setText("jTextField1");
        home_file.setAutoscrolls(false);
        home_file.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                home_fileKeyReleased(evt);
            }
        });

        home_file_enter.setText("ADD");
        home_file_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                home_file_enterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout homeLayout = new javax.swing.GroupLayout(home);
        home.setLayout(homeLayout);
        homeLayout.setHorizontalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, homeLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, homeLayout.createSequentialGroup()
                        .addComponent(home_file)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(home_file_enter))
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, homeLayout.createSequentialGroup()
                        .addComponent(home_action, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(home_exit, javax.swing.GroupLayout.DEFAULT_SIZE, 191, Short.MAX_VALUE)))
                .addGap(17, 17, 17))
            .addGroup(homeLayout.createSequentialGroup()
                .addComponent(home_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 313, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(home_action, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                    .addComponent(home_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(116, Short.MAX_VALUE))
        );

        contain.setMaximumSize(new java.awt.Dimension(600, 600));
        contain.setMinimumSize(new java.awt.Dimension(600, 600));
        contain.setPreferredSize(new java.awt.Dimension(600, 600));

        title_pg2.setText("sub-title");

        input_pg2.setText("jTextField1");
        input_pg2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_pg2KeyReleased(evt);
            }
        });

        list_page2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        list_page2.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        list_page2.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        list_page2.setUpdateSelectionOnSort(false);
        list_page2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                list_page2MouseReleased(evt);
            }
        });
        list_page2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                list_page2KeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(list_page2);

        active.setText("ATIVAR");
        active.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout containLayout = new javax.swing.GroupLayout(contain);
        contain.setLayout(containLayout);
        containLayout.setHorizontalGroup(
            containLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title_pg2, javax.swing.GroupLayout.PREFERRED_SIZE, 573, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(containLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(input_pg2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                        .addComponent(active, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containLayout.setVerticalGroup(
            containLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title_pg2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(input_pg2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(active, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(initial, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 606, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(contain, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(initial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE)
                .addComponent(contain, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15))
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
        
        if(this.pg1s != null && this.pg1 == single){
            
            this.pg1_input_user = true;
            
            var pg_1 = this.pg1s.Apagar(
                true,
                list_page1.getSelectedIndex(),
                list_page1.getSelectedValue(),
                home_file.getText()
            );
            
            this.Page_1(pg_1);
            
        } else if(this.pg1m != null && this.pg1 == multiple){
            
            this.pg1_input_user = true;
            
            var pg_1 = this.pg1m.Action(
                pag1.remove,
                this.Pg1m(),
                home_file.getText()
            );
            
            this.Page_1(pg_1);
            
        } else {
            
            this.Page_1(true, "APAGAR");
            
        }
        
    }//GEN-LAST:event_home_exitActionPerformed

    private void home_actionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_actionActionPerformed
        
        if(this.pg1s != null && this.pg1 == single){
            
            this.pg1_input_user = true;
            
            var pg_1 = pg1s.Abrir(
                true,
                list_page1.getSelectedIndex(),
                list_page1.getSelectedValue(),
                home_file.getText()
            );
            
            this.Page_1(pg_1);
            
        } else if(this.pg1m != null && this.pg1 == multiple){
            
            this.pg1_input_user = true;
            
            var pg_1 = this.pg1m.Action(
                pag1.open,
                this.Pg1m(),
                home_file.getText()
            );
            
            this.Page_1(pg_1);
            
        } else {
            
            this.Page_1(true, "ABRIR");
            
        }
        
    }//GEN-LAST:event_home_actionActionPerformed

    private void home_fileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_home_fileKeyReleased
        
        this.Pg1_select(false);
        
        var tam = home_file.getText().length();
        
        switch(evt.getKeyCode()){

            case 10 -> {
                
                if(this.pg1s != null && this.pg1 == single){
                    
                    this.pg1_input_user = true;
                    var pg_1 = this.pg1s.Adicionar(false, home_file.getText());
                    this.Page_1(pg_1);
                    
                } else if(this.pg1m != null && this.pg1 == multiple){
                    
                    this.pg1_input_user = true;
                    
                    var pg_1 = this.pg1m.Action(
                        pag1.key,
                        this.Pg1m(),
                        home_file.getText()
                    );
                    
                    this.Page_1(pg_1);
                    
                } else {
                    
                    this.Page_1(false, "ADD");
                    
                }
                
            }//case 10

            case 40 -> list_page1.requestFocus();
            
            default -> {

                if(tam <= 10){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font_into, 1, 22)
                    );

                } else if(tam <= 20){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font_into, 0, 22)
                    );

                } else if(tam <= 40){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font, 0, 22)
                    );

                } else if(tam <= 60){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font, 0, 20)
                    );

                } else if(tam <= 80){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font, 0, 18)
                    );

                } else if(tam <= 100){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font, 0, 16)
                    );

                } else if(tam <= 140){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font, 0, 14)
                    );

                } else if(tam <= 180){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font, 0, 10)
                    );

                } else if(tam <= 195){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font, 0, 8)
                    );

                } else {

                    home_file.setText("");
                    
                    home_file.setFont(
                        new java.awt.Font(this.home_file_font_into, 1, 22)
                    );

                }

            }//default

        }//switch(evt.getKeyCode())
        
    }//GEN-LAST:event_home_fileKeyReleased

    private void home_file_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_file_enterActionPerformed
        
        if(this.pg1s != null && this.pg1 == single){
            
            this.pg1_input_user = true;
            var pg_1 = this.pg1s.Adicionar(true, home_file.getText());
            this.Page_1(pg_1);
            
        } else if(this.pg1m != null && this.pg1 == multiple){
            
            this.pg1_input_user = true;
            
            var pg_1 = this.pg1m.Action(
                pag1.remove,
                this.Pg1m(),
                home_file.getText()
            );
            
            this.Page_1(pg_1);
            
        } else {
            
            this.Page_1(true, "ADD");
            
        }
        
    }//GEN-LAST:event_home_file_enterActionPerformed

    private void list_page1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_list_page1KeyReleased
        
        this.Page_1(list_page1.getSelectedIndex() >= 0);
        
        switch(evt.getKeyCode()){
            
            case 10 -> {
                
                if(this.pg1s != null && this.pg1 == single){
                    
                    var pg_1 = pg1s.Abrir(
                        false,
                        list_page1.getSelectedIndex(),
                        list_page1.getSelectedValue(),
                        home_file.getText()
                    );
                    
                    this.Page_1(pg_1);
                    
                    this.Page_1(false, "ABRIR");
                    
                } else if(this.pg1m != null && this.pg1 == multiple){

                    this.pg1_input_user = true;

                    var pg_1 = this.pg1m.Action(
                        pag1.enter,
                        this.Pg1m(),
                        home_file.getText()
                    );

                    this.Page_1(pg_1);

                } else {
                    
                    this.pg1_input_user = true;
                    
                }
                
            }
            
            case 8, 127 ->{
                
                if(this.pg1s != null && this.pg1 == single){
                    
                    this.pg1_input_user = true;
                    
                    var pg_1 = pg1s.Apagar(
                        false,
                        list_page1.getSelectedIndex(),
                        list_page1.getSelectedValue(),
                        home_file.getText()
                    );
                    
                    this.Page_1(pg_1);
                    
                } else if(this.pg1m != null && this.pg1 == multiple){

                    this.pg1_input_user = true;

                    var pg_1 = this.pg1m.Action(
                        evt.getKeyCode() == 127 ? pag1.backspace : pag1.delet,
                        this.Pg1m(),
                        home_file.getText()
                    );

                    this.Page_1(pg_1);

                } else {
                    
                    this.Page_1(false, "APAGAR");
                    
                }
                
            }//case 8, 127
            
            case 38 ->{
                
                if(list_page1.getSelectedIndex() == 0) home_file.requestFocus();
                
            }//case 38
            
            case 32 -> this.Pg1_select(true);
            
            default ->{
                
                if(evt.getKeyChar() != '\f' && evt.getKeyChar() != '￿'){
                    
                    home_file.setText(home_file.getText() + evt.getKeyChar());
                    this.Pg1_select(true);
                    
                }//if(evt.getKeyChar() != '\f' && evt.getKeyChar() != '￿')
                
            }//default
            
        }//switch(evt.getKeyCode())
        
    }//GEN-LAST:event_list_page1KeyReleased

    private void list_page1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_page1MouseReleased
        this.Page_1(true);
    }//GEN-LAST:event_list_page1MouseReleased

    private void activeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_activeActionPerformed

    private void input_pg2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_pg2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_input_pg2KeyReleased

    private void list_page2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_list_page2KeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_list_page2KeyReleased

    private void list_page2MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_page2MouseReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_list_page2MouseReleased

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
    private javax.swing.JButton active;
    private javax.swing.JLabel categories;
    private javax.swing.JLabel choose;
    private javax.swing.JPanel contain;
    private javax.swing.JPanel home;
    private javax.swing.JButton home_action;
    private javax.swing.JButton home_exit;
    private javax.swing.JTextField home_file;
    private javax.swing.JButton home_file_enter;
    private javax.swing.JLabel home_title;
    private javax.swing.JLabel ide;
    private javax.swing.JPanel initial;
    private javax.swing.JTextField input_pg2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JList<String> list_page1;
    private javax.swing.JTable list_page2;
    private javax.swing.JLabel title_pg2;
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