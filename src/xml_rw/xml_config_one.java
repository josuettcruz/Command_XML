/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

import file.Read;
import model.Data;
import model.Hora;

/**
 *
 * @author josue
 */
public class xml_config_one {
    
    private String title;
    private Read cmd;
    private Data insert_d;
    private Hora insert_h;
    
    private void xml_config(
        String title,
        Read cmd,
        Data insert_d,
        Hora insert_h
    )
    {
        
        this.title = title;
        this.cmd = cmd;
        this.insert_d = insert_d;
        this.insert_h = insert_h;
        
    }//xml_config(String title, Read cmd, Data insert_d, Hora insert_h)
    
    public xml_config_one(
        String title,
        Read cmd,
        int a,
        int m,
        int d,
        int hs,
        int ms,
        int s
    ){
        
        this.xml_config(title, cmd, new Data(d,m,s), new Hora(hs,ms,s));
        
    }//xml_config_one(String title, Read cmd, int a, int m, int d, int hs...
    
    public xml_config_one(String title, Read cmd, Data insert_d, Hora insert_h){
        
        this.xml_config(title, cmd, insert_d, insert_h);
        
    }//xml_config_one(String title, Read cmd, Data insert_d, Hora insert_h)
    
    public xml_config_one(String title, Read cmd, Data insert_d){
        
        this.xml_config(title, cmd, insert_d, new Hora(0,0,0));
        
    }//xml_config_one(String title, Read cmd, Data insert_d)
    
    public String title(){return this.title;}
    
    public Read Arquivo(){return this.cmd;}
    
    public Data Data(){return this.insert_d;}
    
    public Hora Hora(){return this.insert_h;}
    
}//xml_config_one