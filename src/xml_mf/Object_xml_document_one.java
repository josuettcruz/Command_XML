/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import xml_rw.xml_document_one;
import model.Link;
import model.txt;
import xml_rw.xml_document_link;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;

import static xml_mf.md_href.before; // 1 de 5
import static xml_mf.md_href.name;   // 2 de 5
import static xml_mf.md_href.middle; // 3 de 5
import static xml_mf.md_href.href;   // 4 de 5
import static xml_mf.md_href.after;  // 5 de 5

/**
 *
 * @author josue
 */
public class Object_xml_document_one {
    
    private xml_document_one doc;
    
    private String one_line_text;
    private String one_line_link_name;
    
    //Java LinkedList - -- Consulta na WEB
    private LinkedList<Link> one_line_link_href;
    //https://www.w3schools.com/java/java_linkedlist.asp
    
    private void initComponent(){
        
        this.one_line_text = "";
        this.one_line_link_name = "";
        this.one_line_link_href = new LinkedList<>();
        
    }//initComponent()
    
    public Object_xml_document_one(xml_document_one doc){
        
        this.initComponent();
        
        this.doc = doc;
        
    }//Object_xml_document_one(xml_document_one doc)
    
    public Object_xml_document_one(List<String> val, String title){
        
        this.initComponent();
        
        if(!val.isEmpty()){
            
            var tl = txt.title(title, true);
            
            var max = val.size();
            
            String[] text_line = new String[max];
            
            boolean[] next_link = new boolean[max];
            
            var before_link = false;
            
            for(var proc_list = max-1; proc_list >= 0; proc_list--){
                
                text_line[proc_list] = val.get(proc_list);
                next_link[proc_list] = before_link;
                
                before_link = new Link(val.get(proc_list)).Val();
                
            }//for(var proc_list = max-1; proc_list >= 0; proc_list--)
            
            List<String> text_area = new ArrayList();
            List<xml_document_link> link = new ArrayList();
            
            var tema = "";
            
            for(var x = 0; x < max; x++){
                
                var md = this.MakeDown(text_line[x]);
                
                if(md){
                    
                    text_area.add(this.one_line_text);
                    
                    link.add(
                        new xml_document_link(
                            this.one_line_link_name,
                            this.one_line_link_href.getLast()
                        )
                    );
                    
                    this.one_line_text = "";
                    this.one_line_link_name = "";
                    
                    tema = "";
                    
                } else if(next_link[x]){//if(md)
                    
                    tema = text_line[x];
                    
                } else if(tema.isBlank()){//if(md)
                    
                    text_area.add(text_line[x]);
                    
                } else {//if(md)
                    
                    var lnk = new Link(text_line[x]);
                    
                    String tx;
                    
                    var true1 = tema.trim().isBlank();
                    var true2 = new Link(tema).Val();
                    
                    var clear = true1 || true2;
                    
                    if(clear && lnk.dat(false).length() >= 5){//if(clear...
                        
                        tx = lnk.dat(false);
                        
                    } else if(
                        clear &&
                        lnk.page(false).length() > 5 &&
                        lnk.page(false).length() < 10
                    )
                    {//if(clear...
                        
                        tx = lnk.page(false);
                        
                    } else if(clear){//if(clear...
                        
                        tx = lnk.page(true);
                        
                    } else {//if(clear...
                        
                        tx = tema;
                        
                    }//if(clear...
                    
                    link.add(new xml_document_link(tx,lnk));
                    
                    tema = "";
                    
                }//if(md)
                
            }//for(var x = 0; x < max; x++)
            
            this.doc = new xml_document_one(tl,link,text_area);
            
        }//if(!val.isEmpty())
        
    }//Object_xml_document_one(List<String> val, String title)
    
    private boolean MakeDown(String line){
        
        var valid = true;
        
        var text = "";
        var name = "";
        var link = "";
        
        var x = 0;
        
        do{
            
            md_href cod = md_href.before;
            
            char ds = line.charAt(x);
            
            switch(ds){
                
                case '[' ->{
                    
                    switch(cod){
                        
                        case before -> cod = md_href.name;
                        
                        default -> valid = false;
                        
                    }//switch(cod)
                    
                }//case '['
                
                case ']' ->{
                    
                    switch(cod){
                        
                        case name -> cod = md_href.middle;
                        
                        default -> valid = false;
                        
                    }//switch(cod)
                    
                }//case ']'
                
                case '(' ->{
                    
                    switch(cod){
                        
                        case middle -> cod = md_href.href;
                        
                        case name -> name += " (";
                        
                        case before, after -> text += " (";
                        
                        case href -> valid = false;
                        
                    }//switch(cod)
                    
                }//case '('
                
                case ')' ->{
                    
                    switch(cod){
                        
                        case href -> cod = md_href.after;
                        
                        case name -> name += ") ";
                        
                        case before, after -> text += ") ";
                        
                        case middle -> valid = false;
                        
                    }//switch(cod)
                    
                }//case ')'
                
                case ' ' ->{
                    
                    switch(cod){
                        
                        case before, after, middle -> text += " ";
                        
                        case name -> name += " ";
                        
                        case href -> link += " ";
                        
                    }//switch(cod)
                    
                }//case ' '
                
                default ->{
                    
                    switch(cod){
                        
                        case before, after -> text += ds;
                        
                        case href -> link += ds;
                        
                        case name -> name += ds;
                        
                        case middle -> valid = false;
                        
                    }//switch(cod)
                    
                }//default
                
            }//switch(ds)
            
            x++;
            
        }while(valid && x > 0 && x < line.length());
        
        if(valid){
            
            var acept = false;
            
            Link lnk = new Link(link.trim());
            
            if(lnk.Val()){
                
                final char[] no_char = {'\\','\'','"',
                    '<','>','{','}','[',']','(',')','|','/','_'};
                
                var cond1 = txt.text(text, no_char).length() >= 5;
                var cond2 = txt.text(name, no_char).length() >= 5;
                
                acept = cond1 && cond2;
                
                if(acept){
                    
                    this.one_line_text = txt.text(text, true);
                    this.one_line_link_name = txt.text(name,no_char);
                    
                    this.one_line_link_href.add(lnk);
                    
                }//if(acept)
                
            }//if(lnk.Val())
            
            return acept;
            
        } else {//if(valid)
            
            return false;
            
        }//if(valid)
        
    }//MakeDown(String line)
    
    /* public static xml_document_one session_textArea **
    ** classe Action                                   **
    
    public static xml_document_one session_textArea(
        String title,
        List<String> text_area
    )
    {
        
        List<String> val_text_area = new ArrayList();
        val_text_area.addAll(text_area);
        val_text_area.add("");
        
        xml_document_one val = new xml_document_one();
        
        val.setTitle(Document(title));
        
        List<xml_document_link> dat = new ArrayList();
        
        List<String> tem = new ArrayList();
        
        String tema = "";
        boolean next_line = false;
        
        for(String t : val_text_area){
            
            if(next_line){
                
                Link lnk = new Link(tema);
                
                if(lnk.Val()){
                    
                    String text_link;
                    
                    if(txt.text(tema, exclude_document_function).isBlank()){
                        
                        if(lnk.dat(false).length() >= 5){
                            
                            text_link = lnk.dat(false);
                            
                        } else {//if(lnk.dat(false).length() >= 5)
                            
                            text_link = lnk.page(true);
                            
                        }//if(lnk.dat(false).length() >= 5)
                        
                    } else {//if(txt.text(tema, exclude_document_function).is...
                        
                        text_link = txt.text(t);
                        
                    }//if(txt.text(tema, exclude_document_function).isBlank()...
                    
                    dat.add(new xml_document_link(text_link,lnk));
                    
                } else {//if(next_line)
                    
                    var c = md_href.before;
                    
                    var validate = true;
                    var tt = "";
                    var tl = "";
                    var tx = "";
                    
                    var x = 0;
                    
                    do{
                        
                        var ds = tema.charAt(x);
                        
                        switch(ds){
                            
                            case '[' -> {
                                
                                if(c == md_href.before){
                                    
                                    c = md_href.name;
                                    
                                } else {//if(co == 0)
                                    
                                    validate = false;
                                    
                                }//if(co == 0)
                                
                            }//case '['
                            
                            case ']' -> {
                                
                                if(c == md_href.name){
                                    
                                    c = md_href.middle;
                                    
                                } else {//if(co == 1)
                                    
                                    validate = false;
                                    
                                }//if(co == 1)
                            
                            }//case ']'
                            
                            case '(' -> {
                                
                                switch(c){
                                    
                                    case middle  -> c = md_href.href;
                                    case name  -> tt += " (";
                                    default -> validate = false;
                                    
                                }//switch(co)
                            
                            }//case '('
                            
                            case ')' -> {
                                
                                switch(c){
                                    
                                    case href  -> c = md_href.after;
                                    case name  -> tt += ") ";
                                    default -> validate = false;
                                    
                                }//switch(co)
                            
                            }//case ')'
                            
                            default -> {
                                
                                switch(c){
                                    
                                    case name -> tt += ds;
                                    
                                    case middle -> {
                                        
                                        if(ds == ' '){
                                            
                                            tx += " ";
                                            
                                        } else {//if(ds == ' ')
                                            
                                            validate = false;
                                            
                                        }//if(ds == ' ')
                                        
                                    }//case 2
                                    
                                    case href -> tl += ds;
                                    
                                    case before, after -> tx += ds;
                                    
                                }//switch(co)
                                
                            }//default
                            
                        }//switch(ds)
                        
                        x++;
                        
                    }while(validate && x < tema.length());
                        
                    Link dom = new Link(tl);
                    
                    if(
                        validate &&
                        dom.Val() &&
                        !txt.text(
                            tt,
                            exclude_document_function
                        ).isBlank()
                    )
                    {//if(validate...
                        
                        dat.add(
                            new xml_document_link(
                                txt.text(tt, true),
                                dom
                            )
                        );
                        
                        if(
                            !txt.text(
                                tx,
                                exclude_document_function
                            ).isBlank()
                        ) {tem.add(txt.text(tx, true));}
                        
                    } else {//if(validate...
                        
                        tem.add(tema);
                        
                    }//if(validate...
                    
                }//if(next_line)
                
            } else {//if(next_line)
                
                next_line = true;
                
            }//if(next_line)
            
            tema = t;
            
        }//for(String line_text : val_text_area)
        
        val.setText(tem);
        val.setUrl(dat);
        
        return val;
        
    }//session_textArea
    
    ** public static xml_document_one session_textArea **
    ** classe Action                                   */
    
    public List<String> textArea(){
        
        List<String> text_area = new ArrayList();
        
        if(!this.doc.getUrl().isEmpty()){
            
            for(xml_document_link l : this.doc.getUrl()){
                
                text_area.add(l.name());
                text_area.add(l.lnk().getLink(true));
                
            }//for(xml_document_link l : this.doc.getUrl())
            
        }//if(!this.doc.getUrl().isEmpty())
        
        if(!this.doc.getText().isEmpty()) text_area.addAll(this.doc.getText());
        
        return text_area;
        
    }//session_Document
    
    public xml_document_one Doc(){return this.doc;}
    
}//Object_xml_document_one