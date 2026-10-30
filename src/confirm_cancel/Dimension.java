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
        
        return Reg.java ? "..\\" : ""
            + this.name[num >= 0 && num < this.name.length ? num : 0]
            + ".csv";
        
    }//List(int num)
    
    private String Save(){
        
        return "left="
            + Reg.Numb(this.left, 1000)
            + ";top="
            + Reg.Numb(this.top, 1000);
    
    }//Save()
    
    private void Reset(){
        
        this.left = 0;
        this.top = 0;
        
        Arq a = new Arq(this.List(0));
        
        if(a.Val()){
            
            Exec s = a.Save(this.Save());
            
            if(!s.Val()) Action.Err(s.Type(), s.Message());
            
        } else {//if(a.Val())
            
            Action.Err(a.Type(), a.Message());
            
        }//if(a.Val())
        
    }//Reset()
    
    private void Fill(Read r){
        
        if(r.Read().length() >= this.Save().length()){
            
            List<DimensionOne> demo = new ArrayList();
            
            var txt = "";
            
            for(var x = 0; x < r.Read().length(); x++){
                
                switch(r.Read().charAt(x)){
                    
                    case ';' -> {
                        
                        if(txt.length() > DimensionOne.vetor)
                        {demo.add(new DimensionOne(txt));}
                        
                        txt = "";
                        
                    }//case ';'
                    
                    default -> txt += r.Read().charAt(x);
                    
                }//switch(r.Read().charAt(x))
                
            }//for(var x = 0; x < r.Read().length(); x++)
            
            if(demo.size() >= 2){
                
                var newl = true;
                var newt = true;
                
                for(DimensionOne d : demo){
                    
                    switch(d.Type()){
                        
                        case "left" -> {
                            
                            if(newl && d.Val().Val()){
                                
                                this.left = d.Val().Num();
                                
                                newl = false;
                                
                            }//if(newl && d.Value().Val())
                            
                        }//case "left"
                        
                        case "top" -> {
                            
                            if(newt && d.Val().Val()){
                                
                                this.top = d.Val().Num();
                                
                                newt = false;
                                
                            }//if(newl && d.Value().Val())
                            
                        }//case "top"
                        
                    }//switch(d.Type())
                    
                }//for(DimensionOne d : demo)
                
                if(newl || newt) this.Reset();
                
            } else {//if(demo.size() >= 2)
                
                this.Reset();
                
            }//if(demo.size() >= 2)
            
        } else {//if(r.Read().length() >= tema.length())
            
            this.Reset();
            
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
        
        if(loop) this.Reset();
        
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