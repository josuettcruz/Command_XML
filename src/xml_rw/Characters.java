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
    
    private List<String> ad;
    
    private boolean valid;
    
    public Characters(Read r){
        
        this.list = new ArrayList();
        this.ad = new ArrayList();
        
        if(Reg.xml(r)){
            
            this.Event(r);
            
            this.valid = !this.list.isEmpty();
            
        } else {//if(Reg.xml(r))
            
            this.valid = false;
            
        }//if(Reg.xml(r))
        
    }//Characters(Read r)
    
    private void Event(Read reading){
        
        for(Tag t : new xml(reading.Read()).Tag()){
            
            //code
            
        }//for(Tag t : new xml(reading.Read()).Tag())
        
    }//Event(Read reading)
    
    private void Tab(int tab, String tema){
        
        var value = "";
        
        if(tab > 1){
            
            var repeat = tab-1;
            
            value += " ".repeat(repeat*Order.tab_space);
            
        }//if(tab > 1)
        
        value += tema;
        
        this.ad.add(value);
    
    }//Tab(int tab, String tema)
    
    private void Tab(int tab, String tema, String tag){
        
        var value = "";
        
        if(tab > 1){
            
            var repeat = tab-1;
            
            value += " ".repeat(repeat*Order.tab_space);
            
        }//if(tab > 1)
        
        value += "<";
        value += tag;
        value += ">";
        value += tema;
        value += "</";
        value += tag;
        value += ">";
        
        this.ad.add(value);
    
    }//Tab(int tab, String tema, String tag)
    
    private void Tab(int tab, String tema, boolean open_tag){
        
        var value = "";
        
        if(tab > 1){
            
            var repeat = tab-1;
            
            value += " ".repeat(repeat*Order.tab_space);
            
        }//if(tab > 1)
        
        value += open_tag ? "<" : "</";
        value += tema;
        value += ">";
        
        this.ad.add(value);
    
    }//Tab(int tab, String tema, boolean open_tag)
    
    public Exec Save(Arq save){
        
        this.ad.clear();
        
        this.Tab(1, Reg.xmls);
        
        this.Tab(1, "root", true);
        this.Tab(2, "characters", true);
        
        if(this.list.isEmpty()){
            
            this.Tab(3, "<character></character>");
            
        } else {//if(this.list.isEmpty())
            
            for(Characters_one a : this.list){
                
                this.Tab(3, "character", true);
                
                this.Tab(4, a.Value(), "caracter");
                
                if(a.Max() >= 1){
                    
                    this.Tab(4, "codes", true);
                    
                    for(int i = 0; i < a.Max(); i++){
                        
                        this.Tab(5, a.Value(), "code");
                        
                    }//for(int i = 0; i < a.Max(); i++)
                    
                    this.Tab(4, "codes", false);
                    
                }//if(a.Max() >= 1)
                
                this.Tab(3, "character", false);
                
            }//for(Characters_one a : this.list)
            
        }//if(this.list.isEmpty())
        
        this.Tab(2, "characters", false);
        this.Tab(1, "root", false);
        
        var node = save.Save(this.ad);
        
        this.ad.clear();
        
        return node;
        
    }//Save(Arq save)
    
    public boolean Valid(){return this.valid;}
    
}
