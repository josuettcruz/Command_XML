/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

import model.Data;
import model.Hora;

import file.Arq;
import file.Read;
import static xml_rw.xml_config_file_cond.*;

/**
 *
 * @author josue
 */
public class xml_config_one {
    
    private String title;
    private Read cmd;
    private xml_config_file_cond cond;
    
    private Data insert_d;
    private Hora insert_h;
    
    private Data modify_d;
    private Hora modify_h;
    
    public xml_config_one(
        String title,
        Read cmd,
        Data insert_d,
        Hora insert_h,
        Data modify_d,
        Hora modify_h
    )
    {
        
        this.title = title;
        this.cmd = cmd;
        
        this.insert_d = insert_d;
        this.insert_h = insert_h;
        
        this.modify_d = modify_d;
        this.modify_h = modify_h;
        
        if(cmd.Val() && Arq.Dir(cmd.Arq(), true)){
            
            this.cond = write;
            
        } else if(cmd.Val() && Arq.Dir(cmd.Arq(), false)){//if(cmd.Val() && Arq.Dir...
            
            this.cond = readonly;
            
        } else {//if(cmd.Val() && Arq.Dir...
            
            this.cond = not;
            
        }//if(cmd.Val() && Arq.Dir...
        
    }//xml_config_one(String title, Read cmd, Data insert_d, Hora insert_h...
    
    public String Title(){return this.title;}
    
    public xml_config_file_cond Cond(){return this.cond;}
    
    public Read Arq(){return this.cmd;}
    
    public Data InsertData(){return this.insert_d;}
    
    public Hora InsertHora(){return this.insert_h;}
    
    public Data ModifyData(){return this.modify_d;}
    
    public Hora ModifyHora(){return this.modify_h;}
    
}//xml_config_one