/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

import file.*;
import execute.*;
import model.Reg;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class xml_document {
    
    private List<xml_document_one> list;
    private String title;
    
    public xml_document(String title, Read r){
        
        this.list = new ArrayList();
        this.title = title;
        
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
        {o.Add(d, d.title());}
        
        var valid = o.Add(demo, demo.title());
        
        if(valid){
            
            this.list.clear();
            this.list.addAll(o.Return());
            
        }//if(valid)
        
        return o.Position();
        
    }//Add(xml_document_one demo)

    public String Title(boolean txt_title) {return this.title;}

    public List<xml_document_one> List() {return list;}
    
}
