/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

import file.*;
import execute.*;
import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class Characters {
    
    private List<Characters_one> list;
    
    private boolean valid;
    
    public Characters(Read r){
        
        this.list = new ArrayList();
        
        if(Reg.xml(r)){
            
            this.Event(r);
            
            this.valid = !this.list.isEmpty();
            
        } else {//if(Reg.xml(r))
            
            this.valid = false;
            
        }//if(Reg.xml(r))
        
    }//Characters(Read r)
    
    private void Event(Read reading){
        
        var o = new Order<Characters_one>();
        
        for(Tag t : new xml(reading.Read()).Tag()){
            
            //code
            
        }//for(Tag t : new xml(reading.Read()).Tag())
        
        this.list.addAll(o.Return());
        
    }//Event(Read reading)
    
    public String Tab(int tab, String tema){
        
        var value = "";
        
        if(tab > 1){
            
            var repeat = tab-1;
            
            value += " ".repeat(repeat*Order.tab_space);
            
        }//if(tab > 1)
        
        value += tema;
        
        return value;
    
    }//Tab(int tab, String tema)
    
    public Exec Save(Arq save){
        
        List<String> ad = new ArrayList();
        
        var node = save.Save(ad);
        
        return node;
        
    }//Save(Arq save)
    
    public boolean Valid(){return this.valid;}
    
}
