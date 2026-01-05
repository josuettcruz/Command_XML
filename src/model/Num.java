/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author josue
 */
public class Num {
    
    private int number;
    private boolean valid;
    
    public Num(String t){
        
        int num = 0;
        this.valid = true;
        
        if(Acept(t,5)){
            
            for(int i = 0; i < t.length(); i++){
                
                switch(t.charAt(i)){
                    
                    case '1' -> num = num*10 + 1;
                    case '2' -> num = num*10 + 2;
                    case '3' -> num = num*10 + 3;
                    case '4' -> num = num*10 + 4;
                    case '5' -> num = num*10 + 5;
                    case '6' -> num = num*10 + 6;
                    case '7' -> num = num*10 + 7;
                    case '8' -> num = num*10 + 8;
                    case '9' -> num = num*10 + 9;
                    case '0' -> num = num*10;
                    default -> this.valid = false;
                    
                }//switch(t.charAt(i))
                
                this.number = num;
                
            }//for(int i = 0; i < t.length(); i++)
            
        } else {//if(Acept(t,5))
            
            this.valid = false;
            this.number = 0;
            
        }//if(Acept(t,5))
        
    }//Num(String t)
    
    private boolean Acept(String txt, int max){
        
        int sum = 0;
        
        for(int g = 0; g < txt.length(); g++){
            
            switch(txt.charAt(g)){
                
                case '1', 
                     '2', 
                     '3', 
                     '4', 
                     '5', 
                     '6', 
                     '7', 
                     '8', 
                     '9' -> sum++;
                
                case '0' -> {
                    
                    if(sum > 0){
                        
                        sum++;
                        
                    }//if(sum > 0)
                    
                }//case '0'
                
            }//switch(txt.charAt(g))
            
        }//for(int g = 0; g < txt.length(); g++)
        
        return sum <= max;
        
    }//Acept(String txt, int max)
    
    public int Num(){return this.number;}
    
    public boolean Val(){return this.valid;}
    
}