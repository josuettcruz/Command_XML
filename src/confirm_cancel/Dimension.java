/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import file.*;

import model.Reg;

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
    
    private void Reset(){
        
        this.left = 0;
        this.top = 0;
        
        new Arq(this.List(0)).Save(this.Save());
        
    }//Reset()
    
    public Dimension(){
        
        this.local = 0;
        
        this.left = 0;
        this.top = 0;
        
        var proc = 0;
        var loop = true;
        
        do{
            
            var name_file = this.List(proc);
            
            if(Arq.Dir(name_file, true)){
                
                Read r = new Arq(name_file).Read();

                if(r.Read().length() >= this.Save().length()){

                    List<DimensionOne> demo = new ArrayList();

                    var txt = "";

                    for(var x = 0; x < r.Read().length(); x++){

                        switch(r.Read().charAt(x)){

                            case ';' -> {

                                if(DimensionOne.Valid(txt))
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

                                    if(newl && d.Int().Val()){

                                        this.left = d.Int().Num();

                                        newl = false;

                                    }//if(newl && d.Value().Val())

                                }//case "left"

                                case "top" -> {

                                    if(newt && d.Int().Val()){

                                        this.top = d.Int().Num();

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

                this.local = proc;
                loop = false;
                
            }//if(t, true))
            
            proc++;
            
        }while(loop && proc > 0 && proc < this.name.length);
        
        if(loop) this.Reset();
        
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
    
    public int Left(){return this.left;}
    
    public int Top(){return this.top;}
    
    public Exec Save(int new_left, int new_top)
    {return new Arq(this.List(this.local)).Save(this.Save());}
    
}//Dimension