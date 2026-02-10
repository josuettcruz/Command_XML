/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package execute;

import static execute.tg.txt;
import static execute.tg.tag;
import static execute.tg.attr;
import static execute.tg.val;
import java.util.ArrayList;
import java.util.List;
import model.Reg;

/**
 *
 * @author josue
 */
public class xml{
    
    private List<Tag> com = new ArrayList();
    private tg el = tg.txt;
    private String text = "";
    private boolean space = false;
    private int no_char = 0;
    
    public xml(String t){
        
        boolean expace = false;
        boolean tag_val = false;
        
        for(int i = 0; i < t.length(); i++){
            
            switch(t.charAt(i)){
                
                case '<' -> {
                    
                    switch(this.el){
                        
                        case val -> this.ad('<');
                        
                        case txt  -> this.Exec(tg.tag);
                        
                        case tag, attr  -> this.ad();
                        
                    }//switch(this.el)
                    
                    expace = false;
                    tag_val = false;
                    
                }//case '<'
                
                case '>' -> {
                    
                    switch(this.el){
                        
                        case val -> this.ad('>');
                        
                        case txt -> ad();
                        
                        case tag, attr -> Exec(tg.txt);
                        
                    }//switch(this.el)
                    
                    expace = false;
                    tag_val = false;
                    
                }//case '>'
                
                case '=' -> {
                    
                    switch(this.el){
                        
                        case txt, val -> this.ad('=');
                        
                        case tag, attr  -> {
                            
                            this.Exec(tg.attr);
                            tag_val = true;
                            
                        }
                        
                    }//switch(this.el)
                    
                    expace = false;
                    
                }//case '='
                
                case '\"' -> {
                    
                    switch(this.el){
                        
                        case txt, tag -> this.ad('\"');
                        
                        case attr -> {
                            
                            if(tag_val){
                                
                                this.Exec(tg.val);
                                tag_val = false;
                                
                            }//if(tag_val)
                            
                        }//case attr
                        
                        case val -> {
                            
                            if(expace){
                                
                                this.ad('\"');
                                expace = false;
                                
                            } else {//if(str_esp)
                                
                                this.Exec(tg.attr);
                                
                            }//if(str_esp)
                            
                        }//case val
                        
                    }//switch(this.el)
                    
                }//case '\"'
                
                case '\\' ->{
                    
                    switch(this.el){
                        
                        case txt -> this.ad('\\');
                        
                        case tag, attr -> this.ad();
                        
                        case val -> {
                            
                            if(expace){
                                
                                this.ad('\\');
                                expace = false;
                                
                            } else {//if(expace)
                                
                                expace = true;
                                
                            }//if(expace)
                            
                        }//case val
                        
                    }//switch(this.el)
                    
                    tag_val = false;
                    
                }//case '\\'
                
                case ' ' ->{
                    
                    switch(this.el){
                        
                        case txt, val -> this.space = true;
                        
                        case tag, attr -> this.Exec(tg.attr);
                        
                    }//switch(this.el)
                    
                    expace = false;
                    
                }//case ' '
                
                case '\n', '\t', '\r', '\f' ->{
                    
                    if(this.el == txt){
                        
                        this.space = true;
                        
                    }//if(this.el == txt)
                    
                    expace = false;
                    
                }//case '\n', '\t', '\r', '\f'
                
                default -> {
                    
                    this.ad(t.charAt(i));
                    expace = false;
                    
                }//default
                
            }//switch(t.charAt(i))
            
        }//for(int i = 0; i < t.length(); i++)
        
    }//xml(String text)
    
    private void ad(char txt){
        
        var insert_space = this.space && !this.text.isBlank();
        
        if(this.no_char > 0){
            
            this.no_char = 0;
            
            if(insert_space){
                
                this.text += " ";
                
            }//if(insert_space)
            
            this.text += "{";
            
            this.text += Reg.Numb(this.no_char, 1000);
            
            this.text += "}";
            
        }//if(this.no_char > 0)
        
        if(insert_space){
            
            this.text += " ";
            
        }//if(this.space && !this.text.isBlank())
        
        this.space = false;
        
        this.text += txt;
        
    }//ad(char txt)
    
    private void ad(){
        
        this.no_char++;
        
    }//ad()
    
    private void Exec(tg t){
        
        this.space = false;
        
        if(!this.text.isBlank()){
            
            this.com.add(new Tag(this.text,this.el));
            this.text = "";
            
        }//if(!txt.isBlank())
        
        this.el = t;
        
    }//Exec(tg tag)
    
    public int Max(){
        
        return this.com.isEmpty() ? 0 : this.com.size();
        
    }//Max()
    
    public Tag Tag(int val){
        
        if(val > 0 && val <= this.com.size() && !this.com.isEmpty()){
            
            return com.get(val-1);
            
        } else {
            
            return new Tag();
            
        }
        
    }//Tag(int val)
    
    public List<Tag> Tag(){
        
        return this.com;
        
    }//Tag()
    
}//xml