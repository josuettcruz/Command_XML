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
    
    private void Order(){
        
        var tot = this.list.size();
        
        xml_document_one document[] = new xml_document_one[tot];
        String doc[] = new String[tot];
        boolean cod[] = new boolean[tot];
        
        for(int i = 0; i < tot; i++){
            
            document[i] = this.list.get(i);
            doc[i] = txt.text(this.list.get(i).title().toLowerCase());
            cod[i] = true;
            
        }//for(int i = 0; i < tot; i++)
        
        this.list.clear();
        
        var compare = doc[0];
        
        for(int repeat = 0; repeat < tot; repeat++){
            
            var i = 0;
            var loop = true;
            
            do{
                
                if(cod[i]){
                    
                    if(txt.min(doc[i], compare)){
                        
                        this.list.add(document[i]);
                        
                        compare = doc[i];
                        
                        cod[i] = false;
                        
                        loop = false;
                        
                    }//if(txt.min(doc[i], compare))
                    
                }//if(cod[y])
                
                i++;
                
            }while(loop && i > 0 && i < tot);
            
        }//for(int repeat = 0; repeat < tot; repeat++)
        
    }//Order()
    
    public void Add(xml_document_one add){
        
        this.list.add(add);
        
        if(!this.list.isEmpty()) this.Order();
        
    }//Add(xml_document_one add)

    public String Title(boolean txt_title) {return this.title;}

    public List<xml_document_one> List() {return list;}
    
}
