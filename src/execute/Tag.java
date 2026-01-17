/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package execute;

/**
 *
 * @author josue
 */
public class Tag {
    
    private boolean valid;
    private String txt;
    private tg tag;
    
    public Tag(){
        
        this.valid = false;
        this.txt = "";
        this.tag = tg.txt;
        
    }//Tag()
    
    public Tag(String txt, tg tag){
        
        this.valid = true;
        this.txt = txt;
        this.tag = tag;
        
    }//Tag(String txt, tg tag)
    
    public boolean OpenTag(){
        
        boolean close = false;
        
        if(this.txt.length() > 1){
            
            close = this.tag == tag && this.txt.charAt(0) != '/';
            
        }//if(this.txt.length() > 1)
        
        return close;
        
    }//OpenTag()
    
    public boolean CloseTag(){
        
        boolean close = false;
        
        if(this.txt.length() > 1){
            
            close = this.tag == tag && this.txt.charAt(0) == '/';
            
        }//if(this.txt.length() > 1)
        
        return close;
        
    }//CloseTag()
    
    public String txt(){
        
        return this.CloseTag() ? this.txt.substring(1) : this.txt;
        
    }//txt()
    
    public String Value(){
        
        return this.tag.Val(false);
        
    }//Val()
    
    public String Detals(){
        
        return this.tag.Val(true);
        
    }//Detals()
    
    public boolean Val(){
        
        return this.valid;
        
    }//Val()
    
}