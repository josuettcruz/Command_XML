/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

import file.Read;
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
    
    public xml_config(Read arq){
        
        this.list = new ArrayList();
        
        //11:52 22/05/2026 -- Continua
        
    }//xml_config()
    
    public void Add(xml_config_one insert){
        
        this.list.add(insert);
        
    }//Add(xml_config_one insert)
    
    public List<xml_config_one> learn(){
        
        return this.list;
        
    }//learn()
    
}//xml_config