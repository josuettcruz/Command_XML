/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

import file.*;
import execute.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class xml_config {
    
    private List<xml_config_one> list;
    
    public xml_config(){
        
        this.list = new ArrayList();
        
    }//xml_config()
    
    public void xml(Read arq){
        
        for(Tag t : new xml(arq.Read()).Tag()){
            
            switch(t.Value()){
                
                case "txt" ->{
                    
                    // no acion
                
                }//case "txt"
                
                case "tag" ->{
                    
                    // no acion
                
                }//case "tag"
                
                case "attr" ->{
                    
                    // no acion
                
                }//case "attr"
                
                case "val" ->{
                    
                    // no acion
                
                }//case "val"
                
            }//switch(t.Value())
            
        }//for(Tag t : new xml(arq.Read()).Tag())
        
    }//xml_config()
    
    public Exec Save(Arq save){
        
        List<String> arq = new ArrayList();
        
        arq.add("O arquivo ainda não está pronto!");
        arq.add("Ainda falta muita coisa.");
        
        return save.Save(arq);
        
    }//Save(Arq save)
    
    public void Insert(xml_config_one insert){
        
        this.list.add(insert);
        
    }//Insert(xml_config_one insert)
    
    public void Insert(xml_config_one insert, int position){
        
        if(position >= 0 && position < this.list.size()){
            
            List<xml_config_one> done = new ArrayList();
            
            done.addAll(this.list);
            
            this.list.clear();
            
            for(int i = 0; i < position; i++){this.list.add(done.get(i));}
            
            this.list.add(insert);
            
            for(int i = position; i < done.size(); i++)
            {this.list.add(done.get(i));}
            
        }//if(position >= 0 && position < this.list.size())
        
    }//Insert(xml_config_one insert, int position)
    
    public void Insert(List<xml_config_one> insert, int position){
        
        if(position >= 0 && position < this.list.size()){
            
            List<xml_config_one> done = new ArrayList();
            
            done.addAll(this.list);
            
            this.list.clear();
            
            for(int i = 0; i < position; i++){this.list.add(done.get(i));}
            
            this.list.addAll(insert);
            
            for(int i = position; i < done.size(); i++)
            {this.list.add(done.get(i));}
            
        }//if(position >= 0 && position < this.list.size())
        
    }//Insert(List<xml_config_one> insert, int position)
    
    public void remove(int position){
        
        if(position >= 0 && position < this.list.size()){
            
            List<xml_config_one> done = new ArrayList();
            
            done.addAll(this.list);
            
            this.list.clear();
            
            for(int i = 0; i < done.size(); i++){
                
                if(i != position){this.list.add(done.get(i));}
                
            }//for(int i = 0; i < done.size(); i++)
            
        }//if(position >= 0 && position < this.list.size())
        
    }//remove(int position)
    
    public void remove(int min, int max){
        
        if(
            min >= 0 &&
            max >= 0 &&
            min < this.list.size() &&
            max < this.list.size() &&
            min < max
        )
        {
            
            List<xml_config_one> done = new ArrayList();
            
            done.addAll(this.list);
            
            this.list.clear();
            
            for(int i = 0; i < done.size(); i++){
                
                if(i < min && i > max){this.list.add(done.get(i));}
                
            }//for(int i = 0; i < done.size(); i++)
            
        }//if(min >= 0 && max >= 0 && min < this.list.size() && max < this...
        
    }//remove(int min, int max)
    
    public List<xml_config_one> learn(){
        
        return this.list;
        
    }//learn()
    
}//xml_config