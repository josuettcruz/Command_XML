/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package form;

import model.*;
import static form.pg1sm.*;
import static form.key.*;

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
    
    private boolean key_code_char;
    private int key_code_count;
    
    private final float AlignmentX = 0f;
    private final float AlignmentY = 0f;
    
    private final String home_file_font_into = "Consolas";
    private final String home_file_font = "Tahoma";
    
    private boolean page1Exit;
    
    private Painel_1Single pg1s;
    private Painel_1Multiple pg1m;
    private pg1sm pg1sm;
    
    private List<Domain> domo;
    
    private Painel_2 pg2;
    
    private Painel_3 pg3;
    private key text_area;
    
    public window() {
        
        initComponents();
        
        this.Enter(0,0,600,600);
        
    }//window()
    
    public window(int r, int t, int w, int h){
        
        initComponents();
        
        this.Enter(r,t,w,h);
        
    }//window(int r, int t, int w, int h)
    
    private void Enter(int r, int t, int w, int h){
        
        this.key_code_char = false;
        
        this.domo = new ArrayList();
        
        this.pg1sm = none;
        
        this.page1Exit = false;
        
        this.key_code_count = 1;
        
        this.text_area = user;
        
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
    
    public void PrintKey(){
        this.key_code_char = true;
    }
    
    private void Println(int key_code, char key_char, int extendedkeycode){
        
        final int max = 10;
        
        if(
            this.key_code_char             // A impressão deve ser ativada!
            && this.key_code_count <= max  // Só imprimir 10 vezes!
            && key_code != 10              // A tecla digitada não dever ser "Enter"
        )
        {
            
            var println = "Impressão ";
            println += Reg.Numb(this.key_code_count, max, " de ");
            println += ": \"";
            println += Reg.Numb(key_code, 100);
            println += "\"";
            
            if(key_char != '￿' && key_char != ''){
                
                println += "\" -- '";
                println += key_char;
                println += "'";
                
            }//if(evt.getKeyChar() != '￿' && key_char != '')
            
            if(key_code != extendedkeycode){
                
                println += " -- [";
                println += Reg.Numb(extendedkeycode, 1000);
                println += "]";
                
            }//if(evt.getKeyCode() != evt.getExtendedKeyCode())
            
            System.out.println(println);
            
            this.key_code_count++;
            
        }//if(Reg.java && this.key_code_char && this.key_code_count <= max &&...
        
    }//Println(int key_code, char key_char, int extendedkeycode)
    
    public int Left(){
        
        return this.getBounds().x;
        
    }//Left()
    
    public int Top(){
        
        return this.getBounds().y;
        
    }//Top()
    
    public int Width(){
        
        return this.getBounds().width;
        
    }//Width()
    
    public int Height(){
        
        return this.getBounds().height;
        
    }//Height()
    
    private void Tem(int init){
        
        boolean tem[] = new boolean[4];
        
        for(int exe = 0; exe < tem.length; exe++){
            
            if(init > 0 && init < tem.length){
                
                tem[exe] = exe == init;
                
            } else {//if(init >= 0 && init < tem.length)
                
                tem[exe] = exe == 0;
                
            }//if(init >= 0 && init < tem.length)
            
        }//for(int exe = 0; exe < tem.length; exe++)
        
        initial.setVisible(tem[0]);
        home.setVisible(tem[1]);
        front.setVisible(tem[2]);
        form.setVisible(tem[3]);
        
    }//Tem(int init)
    
    public void Page_0(String title, List<String> text, boolean exit){
        
        this.page1Exit = exit;
        
        setTitle(title);
        
        initial.setAlignmentX(AlignmentX);
        initial.setAlignmentY(AlignmentY);
        
        String[] tem_0 = new String[10];
        
        for(int s = 0; s < tem_0.length; s++) tem_0[s] = "";
            
        var s = 0;

        do{

            tem_0[s] = text.get(s);
            s++;

        }while(s > 0 && s < text.size() && s < tem_0.length);
            
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
        
    }//Page_0(String title, String text)
    
    private void Page_1(boolean button, String action){
        
        var Page_1_String1 = "\"";
        Page_1_String1 += action;
        Page_1_String1 += "\"";
        
        var Page_1_String2 = "Impossível executar a ação do ";
        Page_1_String2 += button ? "mouse" : "teclado";
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
    
    private List<Domain> Domo(List<Domain> view){
        
        List<Domain> demo = new ArrayList();
        List<Integer> test = new ArrayList();
        
        for(Domain ad : view){
            
            boolean acept = true;
            
            if(test.size() > 1){
                
                Integer add = 0;
                
                do{
                    
                    if(test.get(add) == ad.index()) acept = false;
                    
                    add++;
                    
                }while(acept && add > 0 && add < test.size());
                
            }//if(test.size() > 1)
            
            if(ad.index() < 0) acept = false;
            
            if(acept){
                
                demo.add(new Domain(ad.index(), ad.Text(false)));
                test.add(ad.index());
                
            }//if(acept)
            
        }//for(Domain insert : view)
        
        return demo;
        
    }//Page_1(List<Domain> view)
    
    public List<Domain> Pg1s(){
        
        int select = list_page1.getSelectedIndex();
        
        List<Domain> doc = this.domo;
        
        List<Domain> tema = new ArrayList();
        
        for(int i = 0; i < doc.size(); i++){
            
            Domain demo = new Domain(
                doc.get(i).index(),
                doc.get(i).Text(false)
            );
            
            demo.Select(i == select);
            
            tema.add(demo);
            
        }//for(int i = 0; i < doc.size(); i++)
        
        return tema;
        
    }//Pg1s()
    
    public List<Domain> Pg1m(){
        
        int[] select = list_page1.getSelectedIndices();
        
        List<Domain> doc = this.domo;
        
        List<Domain> tema = new ArrayList();
        
        if(select.length > 0){
            
            for(int add = 0; add < doc.size(); add++){
                
                Domain ad = new Domain(
                    doc.get(add).index(),
                    doc.get(add).Text(false)
                );
                
                var selected = false;
                var row = 0;
                
                do{
                    
                    selected = add == select[row];
                    row++;
                    
                }while(!selected && row > 0 && row < select.length);
                
                ad.Select(selected);
                
                tema.add(ad);
                
            }//for(Domain d : this.pg1m.ListMode())
            
        } else {//if(list_page1.getSelectedIndices().length > 1)
            
            tema.addAll(this.domo);
            
        }//if(list_page1.getSelectedIndices().length > 1)
        
        return tema;
        
    }//Pg1m()
    
    private void Page_1Single(){
        
        if(this.pg1s != null && this.pg1sm == single){
            
            list_page1.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION
            );
            
            final var max_list = this.pg1s.ListColumn()
                && this.pg1s.ListMode().size() > 1;
            
            final var list_empty = this.pg1s.ListMode().isEmpty();
            
            final var repeat_char_list = " ".repeat(5);
            
            this.domo.clear();
            
            this.domo.addAll(this.Domo(this.pg1s.ListMode()));

            setTitle(this.pg1s.Title(true));

            home.setAlignmentX(AlignmentX);
            home.setAlignmentY(AlignmentY);

            home_title.setText(this.pg1s.Title(false));
            home_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            home_title.setFont(new java.awt.Font("Impact", 0, 22));

            home_action.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);        
            home_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

            home_action.setText("CONFIRMAR");
            home_exit.setText("CANCELAR");

            home_action.setFont(new java.awt.Font("Bernard MT Condensed", 0, 32));
            home_exit.setFont(new java.awt.Font("Bernard MT Condensed", 0, 32));

            home_action.setBackground(Color.decode("#008b8b"));
            home_exit.setBackground(Color.decode("#8b0000"));

            home_action.setForeground(Color.decode("#f5f5f5"));
            home_exit.setForeground(Color.decode("#f0f8ff"));

            home_file.setAutoscrolls(false);
            home_file_enter.setAutoscrolls(false);

            home_file.setFont(new java.awt.Font(this.home_file_font_into, 1, 26));
            home_file_enter.setFont(new java.awt.Font("Bernard MT Condensed", 1, 26));

            home_file.setBackground(Color.white);
            home_file_enter.setBackground(Color.decode("#008b8b"));

            home_file.setForeground(Color.black);
            home_file_enter.setForeground(Color.decode("#f0f8ff"));

            home_file.setText(this.pg1s.InputText());
            home_file_enter.setText("ADD");
            
            String[] data = new String[list_empty ? 2 : this.domo.size()];
            
            if(list_empty){
                
                for(int dat = 0; dat < data.length; dat++){
                    
                    data[dat] = dat == 0
                        ? repeat_char_list
                        + "A lista está vazia!"
                        : "";
                    
                }//for(int dat = 0; dat < data.length; dat++)
                
            } else {//if(list_empty)
                
                var reg = 0;
                
                for(Domain t : this.pg1s.ListMode()){
                    
                    var out = t.Text(false).length();
                    
                    if(out > reg) reg = out;
                    
                }//for(String t : this.pg1s.List())
                
                reg++;
                
                if(reg > 101) reg = 101;
                
                for(
                    int i = 0;
                    i < this.pg1s.ListMode().size() && i < data.length;
                    i++
                )
                {
                    
                    var t = this.pg1s.ListMode().get(i).Text(false);
                    
                    data[i] = repeat_char_list;
                    
                    if(t.length() > 100){
                        
                        data[i] += t.substring(0,97);
                        data[i] += "...";
                        
                    } else {
                        
                        data[i] += t;
                        
                    }
                    
                    if(max_list) data[i] += Reg.Tab(t,reg);
                    
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
    
    private void Page_1Multiple(){
        
        if(this.pg1m != null && this.pg1sm == multiple){
            
            list_page1.setSelectionMode(
                javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION
            );
            
            final var max_list = this.pg1m.ListColumn()
                && this.pg1m.ListMode().size() > 1;
            
            final var repeat_char_list = " ".repeat(5);
            
            this.domo.clear();
            
            this.domo.addAll(this.Domo(this.pg1m.ListMode()));

            setTitle(this.pg1m.Title(true));

            home.setAlignmentX(AlignmentX);
            home.setAlignmentY(AlignmentY);

            home_title.setText(this.pg1m.Title(false));
            home_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            home_title.setFont(new java.awt.Font("Impact", 0, 22));

            home_action.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);        
            home_exit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

            home_action.setText("CONFIRMAR");
            home_exit.setText("CANCELAR");

            home_action.setFont(new java.awt.Font("Bernard MT Condensed", 0, 32));
            home_exit.setFont(new java.awt.Font("Bernard MT Condensed", 0, 32));

            home_action.setBackground(Color.decode("#008b8b"));
            home_exit.setBackground(Color.decode("#8b0000"));

            home_action.setForeground(Color.decode("#f5f5f5"));
            home_exit.setForeground(Color.decode("#f0f8ff"));

            home_file.setAutoscrolls(false);
            home_file_enter.setAutoscrolls(false);

            home_file.setFont(new java.awt.Font(this.home_file_font_into, 1, 26));
            home_file_enter.setFont(new java.awt.Font("Bernard MT Condensed", 1, 26));

            home_file.setBackground(Color.white);
            home_file_enter.setBackground(Color.decode("#008b8b"));

            home_file.setForeground(Color.black);
            home_file_enter.setForeground(Color.decode("#f0f8ff"));

            home_file.setText(this.pg1m.InputText());
            home_file_enter.setText("ADD");
            
            String[] data = new String[
                this.domo.isEmpty()
                ? 2
                : this.domo.size()
            ];
            
            if(this.domo.isEmpty()){
                
                for(int dat = 0; dat < data.length; dat++){
                    
                    data[dat] = dat == 0
                        ? repeat_char_list
                        + "A lista está vazia!"
                        : "";
                    
                }//for(int dat = 0; dat < data.length; dat++)
                
            } else {//if(list_empty)
                
                var reg = 0;
                
                for(Domain d : this.domo){
                    
                    var a = d.Text(false).length();
                    
                    if(a > reg) reg = a;
                    
                }//for(Domain d : this.domo)
                
                reg++;
                
                if(reg > 100) reg = 101;
                
                for(
                    int i = 0;
                    i < this.domo.size() && i < data.length;
                    i++
                )
                {
                    
                    var ad = this.domo.get(i).Text(false);
                    
                    data[i] = repeat_char_list;
                    
                    if(ad.length() > 100){
                        
                        data[i] += ad.substring(0,97);
                        data[i] += "...";
                        
                    } else {
                        
                        data[i] += ad;
                        
                    }
                    
                    if(max_list) data[i] += Reg.Tab(ad, reg);
                    
                }//for(int i = 0; i < this.pg1.List().size() && i < data...
                
            }//if(list_empty)
            
            list_page1.setAutoscrolls(true);
            list_page1.setLayoutOrientation(max_list ? 1 : 0);
            
            list_page1.setFont(this.pg1m.ListFont());
            list_page1.setListData(data);
            
            this.Page_1(false);
            
            this.Tem(1);
            
        }//if(this.pg1 != null)
        
    }//Page_1Multiple()
    
    public void Page_1Single(Painel_1Single inteface_page_1){
        
        this.pg1sm = single;
        this.pg1s = inteface_page_1;
        this.Page_1Single();
        
    }//Page_1(Painel_1 interace_page_1)
    
    public void Page_1Multiple(Painel_1Multiple inteface_page_1){
        
        this.pg1sm = multiple;
        this.pg1m = inteface_page_1;
        this.Page_1Multiple();
        
    }//Page_1(Painel_1 interace_page_1)
    
    public void Pg1_select(boolean no_input){
        
        if(no_input) home_file.requestFocus();
        
        var com = false;
        
        switch(pg1sm){
            
            case single -> {
                
                //if(this.pg1s != null) com = this.pg1s.List().size() > 1;
                if(this.pg1s != null) com = this.pg1s.ListMode().size() > 1;
                
            }//case single
            
            case multiple -> {
                
                if(this.pg1m != null) com = this.pg1m.ListMode().size() > 1;
                
            }//case multiple
            
        }//switch(pg1sm)
        
        if(com) list_page1.setSelectedIndex(0);
        
    }//Pg1_select(boolean input)
    
    private void Painel_2(){
        
        if(this.pg2 != null){
            
            this.domo.clear();
            this.domo.addAll(this.Domo(this.pg2.ListMode()));
            
            front_list.setSelectionMode(
                javax.swing.ListSelectionModel.SINGLE_SELECTION
            );
            
            this.setTitle(pg2.Title(true));
            
            front_title.setText(pg2.Title(false));
            
            front_list.setFont(pg2.ListFont());
            
            if(this.domo.isEmpty()){
                
                String[] data = {"Lista Vazia!",""};
                
                front_list.setListData(data);
            
            } else {
                
                final var m = this.domo.size();
                
                String[] data = new String[m];
                
                for(int i = 0; i < m; i++) data[i] = domo.get(i).Text(false);
                
                front_list.setListData(data);
                
            }
            
            front_list.setSelectedIndex(0);
            
            Tem(2);
            
            front_list.requestFocus();
            
        }//if(this.pg2 != null)
        
    }//Painel_2()
    
    public void Painel_2(Painel_2 pg2){
        
        this.pg2 = pg2;
        Painel_2();
        
    }//Painel_2(Painel_2 pg2)
    
    private void p2act(pag2 pg){
        
        var num = this.front_list.getSelectedIndex();
        
        if(num >= 0 && num < this.domo.size() && !this.domo.isEmpty()){
            
            Domain d = domo.get(num);
            d.Select(true);
            
            this.pg2.Command(pg, d);
            
        } else if(!this.domo.isEmpty() && num >= 0){//if(num >= 0...
            
            System.err.println(Reg.Tab("Valor inserido:", Reg.Numb(num+1), 16));
            System.err.println(Reg.Tab("Valor máximo:", Reg.Numb(num+1), 16));
            
            System.exit(0);
            
        } else {//if(num >= 0 && num < this.domo.size() && !this.domo...
            
            System.err.println("Erro inesperado!");
            System.exit(0);
            
        }//if(num >= 0 && num < this.domo.size() && !this.domo.isEmpty())
        
    }//p2act(pag2 pg)
    
    private List<Domain> Pg3(){
        
        List<Domain> demo = new ArrayList();
        
        if(this.pg3.Mode().length > 1){
            
            Domain[] dom = this.pg3.Mode();
            
            List<Integer> note = new ArrayList();
            
            for(Domain d : dom){
                
                Domain k = new Domain(d.index(0),d.Text(false));
                
                if(note.isEmpty()){
                    
                    demo.add(k);
                    note.add(k.index());
                    
                } else if(note.size() == 1){//if(note.isEmpty())
                    
                    if(d.index() != note.get(0)) demo.add(k);
                    
                } else {//if(note.isEmpty())
                    
                    var proc = 0;
                    var loop = true;
                    
                    do{
                        
                        loop = d.index() != note.get(proc);
                        
                        proc++;
                        
                    }while(loop && proc > 0 && proc < note.size());
                    
                    if(loop) demo.add(k);
                    
                }//if(note.isEmpty())
                
            }//for(Domain d : dom)
            
        }//if(this.Domain_pg3())
        
        return demo;
        
    }//Pg3()
    
    public void Painel_3(){
        
        if(this.pg3 != null){
            
            var combo = this.Pg3().size() > 2 && this.Pg3().size() <= 10;
            
            setTitle(this.pg3.Title(true));
            
            p3_title.setText(this.pg3.Title(false));
            p3_title.setFont(this.pg3.FontTitle());
            
            input_date.setFont(this.pg3.TextAreaFont());
            
            if(!this.pg3.TextArea().isEmpty()){
                
                var input_text_area = "";
                
                var line = false;
                
                for(String txt_area : this.pg3.TextArea()){
                    
                    if(line){
                        
                        input_text_area += "\n";
                        
                    } else {//if(line)
                        
                        line = true;
                        
                    }//if(line)
                    
                    input_text_area += txt_area;
                    
                }//for(String t : this.pg3.TextArea())
                
                input_date.setText(input_text_area);
                
            }//if(!this.pg3.TextArea().isEmpty())
            
            if(
                this.pg3.TexAreaCursor().getUser()
                && !this.pg3.TextArea().isEmpty()
            )
            {
                
                TextCursor d = this.pg3.TexAreaCursor();
                List<String> t = this.pg3.TextArea();
                
                var tot = 0;
                
                for(String tem : t){
                    
                    tot += tem.length();
                    tot++;
                
                }//for(String tem : t)
                
                var pos = 0;
                
                var err = false;
                var r = 0;
                
                do{
                    
                    if(r < t.size()){
                        
                        pos += t.get(r).length();
                        pos++;
                    
                    } else {//if(r < t.size())
                        
                        err = true;
                    
                    }//if(r < t.size())
                    
                    r++;
                    
                }while(!err && r > 0 && r < d.row_col(true));
                
                pos += d.row_col(false);
                
                if(err) pos = 0;
                
                input_date.setCaretPosition(pos < tot ? pos : tot);
                
            }//if(this.pg3.TexAreaCursor().getUser() && !this.pg3.TextArea()...
            
            pag3_menu_enter.setVisible(combo);
            pag3_menu.setVisible(combo);
            
            if(combo){
                
                var sf = "Arial Narrow";
                
                final var max = 20;
                
                String[] date = new String[this.Pg3().size()];
                
                for(int ad = 0; ad < this.Pg3().size(); ad++){
                    
                    var t = this.Pg3().get(ad).Text(true);
                    
                    date[ad] = " ".repeat(5);
                    
                    if(t.isBlank()){
                        
                        sf = "Consolas";
                        
                        date[ad] += "-- ";
                        date[ad] += Reg.Numb(ad+1, this.Pg3().size(), " -- ");
                        date[ad] += " --";
                        
                    } else if(t.length() > max){//if(t.isBlank())
                        
                        date[ad] += t.substring(0, max-3);
                        date[ad] += "...";
                        
                    } else {//if(t.isBlank())
                        
                        date[ad] += t;
                        
                    }//if(t.isBlank())
                    
                }//for(int ad = 0; ad < this.Pg3().size(); ad++)
                
                pag3_menu.setFont(new java.awt.Font(sf,0,18));
                
                pag3_menu.setMaximumRowCount(this.Pg3().size());
                
                pag3_menu.setModel(
                    new javax.swing.DefaultComboBoxModel<>(date)
                );
                
            }//if(combo)
            
            this.Tem(3);
            
        }//if(this.pg3 != null)
        
    }//Painel_3()
    
    public void Painel_3(Painel_3 pg3){
        
        this.pg3 = pg3;
        this.Painel_3();
        
    }//Painel_3(Painel_3 pg3)
    
    private Domain[] P3Action(){
        
        var dom = this.Pg3().size() > 2;
        
        Domain[] my_list = new Domain[dom ? this.Pg3().size() : 2];
        
        if(dom){
            
            List<Domain> dem = this.Pg3();
            
            for(int c = 0; c < dem.size(); c++){
                
                my_list[c] = new Domain(
                    dem.get(c).index(0),
                    dem.get(c).Text(false)
                );
                
                my_list[c].Select(c == pag3_menu.getSelectedIndex());
                
            }//for(int c = 0; c < this.Pg3().size(); c++)
            
        } else {//if(dom)
            
            for(int c = 0; c < my_list.length; c++)
            {my_list[c] = new Domain(c+1,"Item " + Reg.Numb(c));}
            
        }//if(dom)
        
        return my_list;
        
    }//P3Action()
    
    private List<String> P3(){
        
        List<String> code = new ArrayList();
        
        for(String tem : input_date.getText().split("\n")){
            
            var insert = "";
            
            for(int p = 0; p < tem.length(); p++){
                
                switch(tem.charAt(p)){
                    
                    case '\t', '\f' -> {
                        
                        code.add(insert);
                        insert = "";
                        
                    }//case '\t', '\f'
                    
                    case '￿' -> {
                        
                        if(!insert.isBlank()) insert += " ";
                        
                    }//case '￿'
                    
                    default -> {
                        
                        insert += tem.charAt(p);
                    
                    }//default
                    
                }//switch(tem.charAt(p))
                
            }//for(int p = 0; p < tem.length(); p++)
            
            code.add(insert);
            
        }//for(String tem : input_date.getText().split("\n"))
        
        return code;
        
    }//P3()
    
    private int P3(boolean row_col){
        
        int pos = input_date.getCaretPosition();
        
        int[] com = new int[this.P3().size()];
        
        for(int c = 0; c < com.length; c++) com[c] = this.P3().get(c).length();
        
        int row = 0;
        int col = 0;
        
        if(pos > 0){
            
            var sum = 0;
            var out = false;
            
            do{
                
                if(row < com.length){
                    
                    if(col < com[row]){
                        
                        col++;
                        
                    } else {//if(col < com[row])
                        
                        col = 1;
                        row++;
                        
                    }//if(col < com[row])
                    
                } else {//if(row < com.length)
                    
                    out = true;
                    
                }//if(row < com.length)
                
                sum++;
                
            }while(!out && sum > 0 && sum < pos);
            
            if(out){
                
                row = -1;
                col = -1;
                
            }//if(out)
            
        }//if(pos > 0)
        
        return row_col ? row : col;
        
    }//P3(boolean row_col)

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
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
        front = new javax.swing.JPanel();
        front_title = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        front_list = new javax.swing.JList<>();
        confirm = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        form = new javax.swing.JPanel();
        p3_title = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        input_date = new javax.swing.JTextArea();
        pag3_menu = new javax.swing.JComboBox<>();
        pg3_confirm = new javax.swing.JButton();
        pg3_cancel = new javax.swing.JButton();
        pag3_menu_enter = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMinimumSize(new java.awt.Dimension(300, 0));

        initial.setAlignmentX(0.0F);
        initial.setAlignmentY(0.0F);
        initial.setCursor(new java.awt.Cursor(java.awt.Cursor.S_RESIZE_CURSOR));
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
                .addGroup(homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(home_title, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(homeLayout.createSequentialGroup()
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
                                .addComponent(home_exit, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(17, 17, 17))
        );
        homeLayout.setVerticalGroup(
            homeLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(homeLayout.createSequentialGroup()
                .addComponent(home_title, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
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

        front_title.setFont(new java.awt.Font("Arial Rounded MT Bold", 0, 18)); // NOI18N
        front_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        front_title.setText("Front Title");
        front_title.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        front_title.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        front_list.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        front_list.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        front_list.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                front_listMousePressed(evt);
            }
        });
        front_list.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                front_listKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(front_list);

        confirm.setBackground(new java.awt.Color(0, 102, 102));
        confirm.setFont(new java.awt.Font("Arial Black", 0, 36)); // NOI18N
        confirm.setForeground(new java.awt.Color(255, 255, 255));
        confirm.setText("Confirmar");
        confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                confirmActionPerformed(evt);
            }
        });

        cancel.setBackground(new java.awt.Color(102, 0, 0));
        cancel.setFont(new java.awt.Font("Arial", 1, 36)); // NOI18N
        cancel.setForeground(new java.awt.Color(255, 255, 255));
        cancel.setText("Cancelar");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout frontLayout = new javax.swing.GroupLayout(front);
        front.setLayout(frontLayout);
        frontLayout.setHorizontalGroup(
            frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, frontLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(front_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(frontLayout.createSequentialGroup()
                        .addComponent(confirm, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(24, 24, 24)
                        .addComponent(cancel, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(50, 50, 50))
        );
        frontLayout.setVerticalGroup(
            frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(frontLayout.createSequentialGroup()
                .addComponent(front_title, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 264, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(frontLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(30, 30, 30))
        );

        form.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        form.setMaximumSize(new java.awt.Dimension(600, 600));
        form.setMinimumSize(new java.awt.Dimension(600, 600));

        p3_title.setFont(new java.awt.Font("Impact", 0, 18)); // NOI18N
        p3_title.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        p3_title.setText("Title(false)");

        input_date.setColumns(20);
        input_date.setRows(5);
        input_date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                input_dateKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                input_dateKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(input_date);

        pag3_menu.setFont(new java.awt.Font("Arial Narrow", 0, 18)); // NOI18N
        pag3_menu.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" }));
        pag3_menu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag3_menuActionPerformed(evt);
            }
        });

        pg3_confirm.setText("CONFIRMAR");
        pg3_confirm.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pg3_confirmActionPerformed(evt);
            }
        });

        pg3_cancel.setText("CANCELAR");
        pg3_cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pg3_cancelActionPerformed(evt);
            }
        });

        pag3_menu_enter.setText("List Action");
        pag3_menu_enter.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pag3_menu_enterActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout formLayout = new javax.swing.GroupLayout(form);
        form.setLayout(formLayout);
        formLayout.setHorizontalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, formLayout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(p3_title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                            .addGroup(formLayout.createSequentialGroup()
                                .addComponent(pg3_confirm, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(pg3_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                    .addGroup(formLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pag3_menu, 0, 565, Short.MAX_VALUE)
                            .addComponent(pag3_menu_enter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        formLayout.setVerticalGroup(
            formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(formLayout.createSequentialGroup()
                .addComponent(p3_title, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(formLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(pg3_confirm, javax.swing.GroupLayout.DEFAULT_SIZE, 53, Short.MAX_VALUE)
                    .addComponent(pg3_cancel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(pag3_menu, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pag3_menu_enter, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 101, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(initial, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
            .addComponent(home, javax.swing.GroupLayout.DEFAULT_SIZE, 612, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(front, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(initial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(home, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(front, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(form, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
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
        if(this.page1Exit) System.exit(0);
    }//GEN-LAST:event_initialMouseReleased

    private void home_exitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_exitActionPerformed
        
        if(this.pg1s != null && this.pg1sm == single){
            
            this.pg1s.Action(
                pag1.remove,
                this.Pg1s(),
                home_file.getText()
            );
            
        } else if(this.pg1m != null && this.pg1sm == multiple){
            
            this.pg1m.Action(
                pag1.remove,
                this.Pg1m(),
                home_file.getText()
            );
            
        } else {
            
            this.Page_1(true, "APAGAR");
            
        }
        
    }//GEN-LAST:event_home_exitActionPerformed

    private void home_actionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_home_actionActionPerformed
        
        if(this.pg1s != null && this.pg1sm == single){
            
            this.pg1s.Action(
                pag1.open,
                this.Pg1s(),
                home_file.getText()
            );
            
        } else if(this.pg1m != null && this.pg1sm == multiple){
            
            this.pg1m.Action(
                pag1.open,
                this.Pg1m(),
                home_file.getText()
            );
            
        } else {
            
            this.Page_1(true, "ABRIR");
            
        }
        
    }//GEN-LAST:event_home_actionActionPerformed

    private void home_fileKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_home_fileKeyReleased
        
        this.Pg1_select(false);
        
        var tam = home_file.getText().length();
        
        switch(evt.getKeyCode()){

            case 10 -> {
                
                if(this.pg1s != null && this.pg1sm == single){
                    
                    this.pg1s.Action(
                        pag1.key,
                        this.Pg1s(),
                        home_file.getText()
                    );
                    
                } else if(this.pg1m != null && this.pg1sm == multiple){
                    
                    this.pg1m.Action(
                        pag1.key,
                        this.Pg1m(),
                        home_file.getText()
                    );
                    
                } else {
                    
                    this.Page_1(false, "ADD");
                    
                }
                
            }//case 10

            case 40 -> list_page1.requestFocus();
            
            default -> {

                if(tam <= 10){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font_into, 1, 26)
                    );

                } else if(tam <= 20){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font_into, 0, 26)
                    );

                } else if(tam <= 40){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font, 0, 26)
                    );

                } else if(tam <= 60){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font, 0, 24)
                    );

                } else if(tam <= 80){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font, 0, 22)
                    );

                } else if(tam <= 90){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font, 0, 20)
                    );

                } else if(tam <= 95){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font, 2, 20)
                    );

                } else if(tam <= 98){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font, 3, 20)
                    );

                } else if(tam <= 100){

                    home_file.setFont(
                        new java.awt.Font(this.home_file_font_into, 1, 26)
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
        
        if(this.pg1s != null && this.pg1sm == single){
            
            this.pg1s.Action(
                pag1.add,
                this.Pg1s(),
                home_file.getText()
            );
            
        } else if(this.pg1m != null && this.pg1sm == multiple){
            
            this.pg1m.Action(
                pag1.add,
                this.Pg1m(),
                home_file.getText()
            );
            
        } else {
            
            this.Page_1(true, "ADD");
            
        }
        
    }//GEN-LAST:event_home_file_enterActionPerformed

    private void list_page1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_list_page1KeyReleased
        
        this.Println(
            evt.getKeyCode(),
            evt.getKeyChar(),
            evt.getExtendedKeyCode()
        );
        
        this.Page_1(list_page1.getSelectedIndex() >= 0);
        
        switch(evt.getKeyCode()){
            
            case 10 -> {
                
                if(this.pg1s != null && this.pg1sm == single){

                    this.pg1s.Action(
                        pag1.enter,
                        this.Pg1s(),
                        home_file.getText()
                    );
                    
                } else if(this.pg1m != null && this.pg1sm == multiple){

                    this.pg1m.Action(
                        pag1.enter,
                        this.Pg1m(),
                        home_file.getText()
                    );

                } else {

                    this.Page_1(false, "ABRIR");

                }
                
            }
            
            case 8 ->{
                
                if(this.pg1s != null && this.pg1sm == single){
                    
                    this.pg1s.Action(
                        pag1.delet,
                        this.Pg1s(),
                        home_file.getText()
                    );
                    
                } else if(this.pg1m != null && this.pg1sm == multiple){

                    this.pg1m.Action(
                        pag1.delet,
                        this.Pg1m(),
                        home_file.getText()
                    );

                } else {
                    
                    this.Page_1(false, "APAGAR");
                    
                }
                
            }//case 8
            
            case 127 ->{
                
                if(this.pg1s != null && this.pg1sm == single){
                    
                    this.pg1s.Action(
                        pag1.backspace,
                        this.Pg1s(),
                        home_file.getText()
                    );
                    
                } else if(this.pg1m != null && this.pg1sm == multiple){

                    this.pg1m.Action(
                        pag1.backspace,
                        this.Pg1m(),
                        home_file.getText()
                    );

                } else {
                    
                    this.Page_1(false, "APAGAR");
                    
                }
                
            }//127
            
            case 38 ->{
                
                if(list_page1.getSelectedIndex() == 0) home_file.requestFocus();
                
            }//case 38
            
            case 32 -> {this.Pg1_select(true);}
            
            default ->{
                
                if(
                    evt.getKeyChar() != '\f'
                    && evt.getKeyChar() != '￿'
                    && evt.getKeyChar() != ''
                )
                {
                    
                    home_file.setText(home_file.getText() + evt.getKeyChar());
                    this.Pg1_select(true);
                    
                }//if(evt.getKeyChar() != '\f' && evt.getKeyChar() != '￿' &&...
                
            }//default
            
        }//switch(evt.getKeyCode())
        
    }//GEN-LAST:event_list_page1KeyReleased

    private void list_page1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_list_page1MouseReleased
        this.Page_1(true);
    }//GEN-LAST:event_list_page1MouseReleased

    private void confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_confirmActionPerformed
        
        this.p2act(pag2.confirm);
        
    }//GEN-LAST:event_confirmActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        
        this.p2act(pag2.cancel);
        
    }//GEN-LAST:event_cancelActionPerformed

    private void front_listKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_front_listKeyReleased
        
        this.Println(
            evt.getKeyCode(),
            evt.getKeyChar(),
            evt.getExtendedKeyCode()
        );
        
        switch(evt.getKeyCode()){
            
            case 8 -> this.p2act(pag2.del);
            
            case 10 -> this.p2act(pag2.enter);
            
            case 127 -> this.p2act(pag2.backspace);
            
        }//switch(evt.getKeyCode())
        
    }//GEN-LAST:event_front_listKeyReleased

    private void front_listMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_front_listMousePressed
        // TODO add your handling code here:
        //Painel 2
    }//GEN-LAST:event_front_listMousePressed

    private void pg3_confirmActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pg3_confirmActionPerformed
        
        this.pg3.Painel3(
            pag3.confirm,    // return enum
            this.P3Action(), // return Domain[]     -- "Lista de OPÇÕES"
            this.P3(),       // return List<String> -- "Texto do TEXT ÁREA"
            this.P3(true),   // return int          -- "Posição do cursor - ROW"
            this.P3(false)   // return int          -- "Posição do cursor - COL"
        );
        
    }//GEN-LAST:event_pg3_confirmActionPerformed

    private void pg3_cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pg3_cancelActionPerformed
        
        this.pg3.Painel3(
            pag3.cancel,     // return enum
            this.P3Action(), // return Domain[]     -- "Lista de OPÇÕES"
            this.P3(),       // return List<String> -- "Texto do TEXT ÁREA"
            this.P3(true),   // return int          -- "Posição do cursor - ROW"
            this.P3(false)   // return int          -- "Posição do cursor - COL"
        );
        
    }//GEN-LAST:event_pg3_cancelActionPerformed

    private void pag3_menu_enterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag3_menu_enterActionPerformed
        //this.P3Action(pag3.button_list);
        
        this.pg3.Painel3(
            pag3.button_list, // return enum
            this.P3Action(),  // return Domain[]     -- "Lista de OPÇÕES"
            this.P3(),        // return List<String> -- "Texto do TEXT ÁREA"
            this.P3(true),    // return int          -- "Posição do cursor - ROW"
            this.P3(false)    // return int          -- "Posição do cursor - COL"
        );
        
    }//GEN-LAST:event_pag3_menu_enterActionPerformed

    private void pag3_menuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pag3_menuActionPerformed
        
        this.pg3.Painel3(
            pag3.list_closer, // return enum
            this.P3Action(),  // return Somain[]     -- "Lista de OPÇÕES"
            this.P3(),        // return List<String> -- "Texto do TEXT ÁREA"
            this.P3(true),    // return int          -- "Posição do cursor - ROW"
            this.P3(false)    // return int          -- "Posição do cursor - COL"
        );
        
    }//GEN-LAST:event_pag3_menuActionPerformed

    private void input_dateKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_dateKeyPressed
        
        switch(evt.getKeyCode()){
            
            case 17 -> {if(this.text_area == user) this.text_area = ctrl;}
            
            case 18 -> {if(this.text_area == user) this.text_area = alt;}
            
            default -> this.text_area = other;
            
        }//switch(evt.getKeyCode())
        
    }//GEN-LAST:event_input_dateKeyPressed

    private void input_dateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_input_dateKeyReleased
        
        if(this.text_area == alt){
            
            this.pg3.Painel3(
                evt.getKeyCode(), // return char
                evt.getKeyChar(), // return int
                this.P3Action(),  // return Domain[]     -- "Lista de OPÇÕES"
                this.P3(),        // return List<String> -- "Texto do TEXT ÁREA"
                this.P3(true),    // return int          -- "Posição do cursor - ROW"
                this.P3(false)    // return int          -- "Posição do cursor - COL"
            );
            
        } else if(this.text_area == ctrl && evt.getKeyCode() == 10){//if(this...
            
            this.pg3.Painel3(
                pag3.ctrl_enter, // return enum
                this.P3Action(), // return Domain[]     -- "Lista de OPÇÕES"
                this.P3(),       // return List<String> -- "Texto do TEXT ÁREA"
                this.P3(true),   // return int          -- "Posição do cursor - ROW"
                this.P3(false)   // return int          -- "Posição do cursor - COL"
            );
            
        }//if(this.text_area == alt)
        
        this.text_area = user;
        
    }//GEN-LAST:event_input_dateKeyReleased

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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JButton cancel;
    private javax.swing.JLabel categories;
    private javax.swing.JLabel choose;
    private javax.swing.JButton confirm;
    private javax.swing.JPanel form;
    private javax.swing.JPanel front;
    private javax.swing.JList<String> front_list;
    private javax.swing.JLabel front_title;
    private javax.swing.JPanel home;
    private javax.swing.JButton home_action;
    private javax.swing.JButton home_exit;
    private javax.swing.JTextField home_file;
    private javax.swing.JButton home_file_enter;
    private javax.swing.JLabel home_title;
    private javax.swing.JLabel ide;
    private javax.swing.JPanel initial;
    private javax.swing.JTextArea input_date;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JList<String> list_page1;
    private javax.swing.JLabel p3_title;
    private javax.swing.JComboBox<String> pag3_menu;
    private javax.swing.JButton pag3_menu_enter;
    private javax.swing.JButton pg3_cancel;
    private javax.swing.JButton pg3_confirm;
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