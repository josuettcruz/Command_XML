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
    
    public xml_document(String title, Read document){
        
        this.list = new ArrayList();
        this.title = title;
        
        Reg.Print(
            "ÚLTIMA MODIFICAÇÃO:",
            new Data().CompareTo(Reg.modify)
                ? "HOJE"
                : Reg.modify.DataCompleta(true)
        );
        
        for(Tag t : new xml(document.Read()).Tag())
        {Reg.Print(t.Detals(), t.txt());}
        
        Reg.Print("XML DOCUMENT", "O documento ainda não está pronto");
        
    }//xml_document(String title, Read document)
    
    public boolean Add(xml_document_one demo){
        
        Order o = new Order<xml_document_one>();
        
        for(xml_document_one d : this.list)
        {o.Add(d, d.title());}
        
        var valid = o.Add(demo, demo.title());
        
        if(valid){
            
            this.list.clear();
            this.list.addAll(o.Return());
            
            return true;
            
        }//if(valid)
        
        return valid;
        
    }//Add(xml_document_one demo)

    public String Title(boolean txt_title) {return this.title;}

    public List<xml_document_one> List() {return list;}
    
}
