/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import model.Texto;

/**
 *
 * @author josue
 */
public class Action_session_open {
    
    private String text;
    private Integer cont;
    
    public Action_session_open(String line){
        
        this.text = "";
        this.cont = 0;
        
        if(line.length() > 1){
            
            for(var at = 0; at < line.length(); at++){
                
                switch(line.charAt(at)){
                    
                    case '#' -> {
                        
                        if(this.text.isBlank()){
                            
                            this.cont++;
                            
                        } else {//if(this.text.isBlank())
                            
                            this.text += "#";
                            
                        }//if(this.text.isBlank())
                        
                    }//case '#'
                    
                    case ' ' ->{
                        
                        if(!this.text.isBlank())
                        {this.text += " ";}
                        
                    }//case ' '
                    
                    default -> this.text += line.charAt(at);
                    
                }//switch(line.charAt(at))
                
            }//for(var at = 0; at < line.length(); at++)
            
        }//if(line.length() > 1)
        
    }//Action_session_open(String line)
    
    public Integer Cont(){return this.cont;};
    
    public String Text(){return this.text;}
    
    public boolean Title(){
        
        return this.cont > 0 && Texto.text(
            this.text, new char[]{
                '"','\'','<','>','|','!','?','.',';',':','[',']','{','}'
            }
        ).length() > 5;
        
    }//Title()
    
}//Action_session_open