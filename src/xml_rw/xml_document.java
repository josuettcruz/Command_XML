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
public class xml_document {
    
    private List<xml_document_one> list;
    private String title;
    private Data create_d;
    private Hora create_h;
    private Data modify_d;
    private Hora modify_h;
    
    public xml_document(String title, Read r, Data d, Hora h){
        
        this.list = new ArrayList();
        this.title = title;
        
        this.create_d = d;
        this.modify_d = d;
        
        this.create_h = h;
        this.modify_h = h;
        
        if(Reg.xml(r)) this.Event(r);
        
    }//xml_document(String title, Read document)
    
    public void Event(Read r){
        
        var o = new Order<xml_document_one>();
        
        for(Tag t : new xml(r.Read()).Tag()){
            
            //continue this
            
        }//for(Tag t : new xml(r.Read()).Tag())
        
        this.list.addAll(o.Return());
            
    }//Event(Read r)
    
    public int Add(xml_document_one demo){
        
        Order o = new Order<xml_document_one>();
        
        for(xml_document_one d : this.list)
        {o.Add(d, d.getTitle());}
        
        var valid = o.Add(demo, demo.getTitle());
        
        if(valid){
            
            this.list.clear();
            this.list.addAll(o.Return());
            
        }//if(valid)
        
        return o.Position();
        
    }//Add(xml_document_one demo)
    
    public boolean Update(Data d, Hora h){
        
        var valid = d.CompareTo(this.create_d, true) &&
                    h.Compare(this.create_h);
        
        if(valid){
            
            this.modify_d = d;
            this.modify_h = h;
            
        }//if(valid)
        
        return valid;
        
    }//Update(Data d, Hora h)
    
    private void Update(){
        
        Data d = new Data();
        Hora h = new Hora(true);
        
        if(d.CompareTo(this.create_d, true) && h.Compare(this.create_h)){
            
            this.modify_d = d;
            this.modify_h = h;
            
        }//if(d.CompareTo(this.create_d, true) && h.Compare(this.create_h))
        
    }//Update()
    
    public int Proc(String title){
        
        List<String> tem = new ArrayList();
        
        for(xml_document_one x : this.list)
        {tem.add(x.getTitle());}
        
        return Order.Proc(tem, title);
        
    }//Proc(String title)
    
    public int Edit(int position, xml_document_one value){
        
        var valid = -2;
        
        if(
            position >= 0 &&
            position < this.list.size() &&
            !this.list.isEmpty()
        )
        {
            
            Order<xml_document_one> o = new Order();
            
            for(int add = 0; add < this.list.size(); add++){
                
                if(add != position)
                {o.Add(this.list.get(add), this.list.get(add).getTitle());}
                
            }//for(int add = 0; add < this.list.size(); add++)
            
            var acept = o.Add(value, value.getTitle());
            
            if(acept){
                
                this.list.clear();
                this.list.addAll(o.Return());
                valid = o.Position();
                this.Update();
                
            }//if(acept)
            
        }//if - position
        
        return valid;
        
    }//Edit(int position, xml_document_one value)

    public String Title(boolean txt_title) {return this.title;}

    public List<xml_document_one> List() {return list;}
    
}
