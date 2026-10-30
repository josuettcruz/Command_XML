/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import file.*;

import model.Reg;
import model.Num;

import xml_mf.Action;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class Dimension {
    
    private final String[] name = {
        "command_xml-Dimension",
        "command-xml-dimension",
        "java-command_xml-Dimension",
        "java-command-xml-dimension",
        "Dimension",
        "dimension",
        "java-Dimension",
        "java-dimension"
    };
    
    private int local;
    
    private int left;
    private int top;
    
    public Dimension(){
        
        this.local = 0;
        
        this.left = 0;
        this.top = 0;
        
        this.Exec();
        
    }//Dimension()
    
    private String List(int num){
        
        String str = "";
        
        if(num >= 0 && num < this.name.length){
            
            if(Reg.java) str += "\\..";
            
            str += this.name[num];
            
            str += ".csv";
            
        }//for(var i = 0; i < str.length; i++)
        
        return str;
        
    }//List()
    
    private String Save(){
        
        return "left="
            + Reg.Numb(this.left, 1000)
            + ";top="
            + Reg.Numb(this.top, 1000);
    
    }
        
    
    private void New(){
        
        Arq a = new Arq(this.List(0));
        
        if(a.Val()){
            
            Exec s = a.Save(this.Save());
            
            if(!s.Val()) Action.Err(s.Type(), s.Message());
            
        } else {//if(a.Val())
            
            Action.Err(a.Type(), a.Message());
            
        }//if(a.Val())
        
    }//New()
    
    private void Fill(Read r){
        
        if(r.Read().length() >= this.Save().length()){
            
            var value = false;
            var type = "";
            var val = "";
            
            List<String> type_mode = new ArrayList();
            List<String> val_mode = new ArrayList();
            
            var txt = r.Read();
            
            for(var x = 0; x < txt.length(); x++){
                
                switch(txt.charAt(x)){
                    
                    case '=' -> {
                        
                        type_mode.add(type);
                        type = "";
                        
                        value = true;
                    
                    }//case '='
                    
                    case ';' -> {
                        
                        val_mode.add(val);
                        val = "";
                        
                        value = false;
                    
                    }//case ';'
                    
                    default ->{
                        
                        if(value){
                            
                            type += txt.charAt(x);
                            
                        } else {//if(value)
                            
                            val += txt.charAt(x);
                            
                        }//if(value)
                        
                    }//default
                    
                }//switch(txt.charAt(x))
                
            }//for(var x = 0; x < txt.length(); x++)
            
            var cond1 = type_mode.size() == val_mode.size();
            var cond2 = type_mode.size() >= 2;
            var cond3 = val_mode.size() >= 2;
            
            if(cond1 && cond2 && cond3){
                
                var newl = true;
                var newt = true;
                
                if(type_mode.get(0).equalsIgnoreCase("left")){
                    
                    this.left = new Num(val_mode.get(0)).Num();
                    newl = false;
                    
                }//if(type_mode.get(0).equalsIgnoreCase("left"))
                
                if(type_mode.get(1).equalsIgnoreCase("top")){
                    
                    this.top = new Num(val_mode.get(1)).Num();
                    newt = false;
                    
                }//if(type_mode.get(1).equalsIgnoreCase("top"))
                
                if(type_mode.get(1).equalsIgnoreCase("left") && newl){
                    
                    this.left = new Num(val_mode.get(1)).Num();
                    newl = false;
                    
                }//if(type_mode.get(1).equalsIgnoreCase("left") && newl)
                
                if(type_mode.get(0).equalsIgnoreCase("top") && newt){
                    
                    this.top = new Num(val_mode.get(0)).Num();
                    newt = false;
                    
                }//if(type_mode.get(0).equalsIgnoreCase("top") && newt)
                
                if(newl || newt) this.New();
                
            }//if(cond1 && cond2 && cond3)
            
        } else {//if(r.Read().length() >= tema.length())
            
            //var tema = "regth=0;";
            
        }//if(r.Read().length() >= tema.length())
        
    }//Fill(String text)
    
    private void Exec(){
        
        var proc = 0;
        var loop = true;
        
        do{
            
            var t = this.List(proc);
            
            if(Arq.Dir(t, true)){
                
                this.Fill(new Arq(t).Read());
                this.local = proc;
                loop = false;
                
            }//if(t, true))
            
            proc++;
            
        }while(loop && proc > 0 && proc < this.name.length);
        
        if(loop) this.New();
        
    }//Exec()
    
    public void Save(int new_left, int new_top){
        
        Arq a = new Arq(this.List(this.local));
        
        if(a.Val()){
            
            Exec e = a.Save(this.Save());
            
            if(!e.Val()) Action.Err(e.Type(), e.Message());
            
        } else {//if(a.Val())
            
            Action.Err(a.Type(), a.Message());
            
        }//if(a.Val())
        
    }//Save(int left, int top)
    
}//Dimension