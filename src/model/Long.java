/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author josue
 */
public class Long {
    
    private long number;
    private boolean valid;
    
    public Long(String t){
        
        long num = 0L;
        this.valid = true;
        
        for(int i = 0; i < t.length(); i++){
            
            switch(t.charAt(i)){
                
                case '1' -> num = num*10L + 1L;
                case '2' -> num = num*10L + 2L;
                case '3' -> num = num*10L + 3L;
                case '4' -> num = num*10L + 4L;
                case '5' -> num = num*10L + 5L;
                case '6' -> num = num*10L + 6L;
                case '7' -> num = num*10L + 7L;
                case '8' -> num = num*10L + 8L;
                case '9' -> num = num*10L + 9L;
                case '0' -> num = num*10L;
                default -> this.valid = false;
                
            }//switch(t.charAt(i))
            
            this.number = num;
            
        }//for(int i = 0; i < t.length(); i++)
        
    }//Num(String t)
    
    public long Num(){
        return this.number;
    }
    
    public boolean Val(){
        return this.valid;
    }
    
}
