/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.util.ArrayList;
import java.util.List;

import model.Reg;

/**
 *
 * @author josue
 */
public class Read {
    
    private List<String> text;
    private boolean exec;
    
    public Read(List <String> read, String arq){
        
        if(read.isEmpty()){
            
            this.text = new ArrayList();
            this.text.add(arq);
            this.exec = false;
            
        } else {//if(read.isEmpty())
            
            this.text = read;
            this.exec = true;
            
        }//if(read.isEmpty())
        
    }//Read(List <String> text)
    
    public Read(String type, String msg){
        
        this.text = new ArrayList();
        this.text.add(type);
        this.text.add(msg);
        this.exec = false;
        
    }//Read(String type, String msg)
    
    public String Read(){
        
        var txt = "";
        
        var ln = false;
        
        for(String learn : this.text){
            
            if(ln){
                
                txt += "\n";
                
            } else {
                
                ln = true;
                
            }
            
            txt += learn;
            
        }//for(String learn : this.text)
        
        return txt;
        
    }//Read()
    
    public String Read(int num){
        
        if(num < 0)
            num = num - num * 2;
        
        if(!this.text.isEmpty() && num > 0 && num <= this.text.size()){
            
            return this.text.get(num-1);
            
        } else if(!this.text.isEmpty()){
            
            return Reg.Numb(this.text.size(),num, " [") + "]";
            
        } else {
            
            return "";
            
        }
        
    }//Read(int num)
    
    public int Max(){
        
        return this.text.isEmpty() ? -1 : this.text.size();
        
    }//Max()
    
    public boolean Val(){
        
        return this.exec;
        
    }//Val()
    
}
