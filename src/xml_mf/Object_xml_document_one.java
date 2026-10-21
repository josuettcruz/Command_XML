/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import xml_rw.xml_document_one;
import model.txt;

import java.util.List;
import java.util.ArrayList;
import xml_rw.xml_document_link;

/**
 *
 * @author josue
 */
public class Object_xml_document_one {
    
    private xml_document_one doc;
    
    public Object_xml_document_one(xml_document_one doc){
        
        this.doc = doc;
        
    }//Object_xml_document_one(xml_document_one doc)
    
    public Object_xml_document_one(List<String> val){
        
        //21/10/2026
        
    }//Object_xml_document_one(xml_document_one doc)
    
    /* public static xml_document_one session_textArea **
    ** classe Action                                   **
    ** Linhas 1082-1285                                **
    
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
    ** classe Action                                   **
    ** Linhas 1082-1285                                */
    
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
    
}//Object_xml_document_one