/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import model.Num;

/**
 *
 * @author josue
 */
public class DimensionOne {
    
    public final static int vetor = 2;
    
    private String type;
    private String value;
    
    public DimensionOne(String cell){
        
        this.type = "";
        this.value = "";
        
        if(cell.length() > vetor){
            
            var divide = false;
            
            for(var x = 0; x < cell.length(); x++){
                
                var charAt = cell.charAt(x);
                
                switch(charAt){
                    
                    case '=' -> divide = true;
                    
                    default ->{
                        
                        if(divide){
                            
                            this.value += charAt;
                            
                        } else {//if(divide)
                            
                            this.type += charAt;
                            
                        }//if(divide)
                        
                    }//default
                    
                }//switch(charAt)
                
            }//for(var x = 0; x < cell.length(); x++)
            
        }//if(cell.length() > 2)
        
    }//DimensionOne(String cell)
    
    public String Type(){return this.type;}
    
    public Num Val(){return new Num(this.value);}
    
}//DimensionOne 