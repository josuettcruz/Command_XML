/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

//import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class Characters_one {
    
    private final char err = '\b';
    private String characters;
    private List<String> charset;
    
    public Characters_one(char characters, List<String> charset){
        
        this.characters = "" + characters;
        this.charset = charset;
        
    }//Characters_one(char characters, List<String> charset)
    
    public Characters_one(String characters, List<String> charset){
        
        this.characters = characters.trim();
        this.charset = charset;
        
    }//Characters_one(String characters, List<String> charset)
    
    public String Code(boolean character, int position){
        
        var val = "";
        
        if(this.charset.isEmpty() && position >= 0 && position < this.charset.size()){
            
            if(character) val += "&";
            val += this.charset.get(position);
            if(character) val += ";";
            
        }//if(this.charset.isEmpty() && position >= 0 && position < this.char...
        
        return val;
        
    }//Code(boolean character)
    
    public String Value(){return this.characters;}
    
    public char Val(){
        
        var value = this.err;
        
        var i = 0;
        var loop = true;
        
        do{
            
            value = this.characters.charAt(i);
            
            loop = this.characters.charAt(i) == ' ';
            
            i++;
            
        }while(loop && i > 0 && i < this.characters.length());
        
        return value;
        
    }//Val()
    
    public String Code(boolean character){return this.Code(character, 0);}
    
    public boolean Valid(){return this.Val() != this.err;}
    
    public int Max(){return this.charset.size();}
    
}
