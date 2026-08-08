/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

import model.Data;
import model.Hora;

import file.Arq;
import file.Read;

import static xml_rw.xml_config_file_cond.write;
import static xml_rw.xml_config_file_cond.readonly;
import static xml_rw.xml_config_file_cond.not;

/**
 *
 * @author josue
 */
public class xml_config_one {
    
    private String title;
    private String local;
    
    private xml_config_file_cond cond;
    
    private Data insert_d;
    private Hora insert_h;
    
    private Data modify_d;
    private Hora modify_h;
    
    private void InsertAdressLocal(String path){
        
        if(Arq.Dir(path)){
            
            this.local = Arq.Files(path);
            
        } else {//if(Arq.Dir(path))
            
            this.local = path;
            
        }//if(Arq.Dir(path)
        
    }//InsertAdressLocal(String path)
    
    public xml_config_one(
        String title,
        String getAbsolutePath
    )
    {
        
        this.title = title;
        this.InsertAdressLocal(getAbsolutePath);
        
        if(Arq.Dir(Arq.Files(getAbsolutePath), true)){
            
            this.cond = write;
            
        } else if(Arq.Dir(Arq.Files(getAbsolutePath), false)){//if - Arq.Dir
            
            this.cond = readonly;
            
        } else {//if - Arq.Dir
            
            this.cond = not;
            
        }//if - Arq.Dir
        
        this.insert_d = Data.code;
        this.insert_h = Hora.code;
        
        this.modify_d = Data.code;
        this.modify_h = Hora.code;
        
    }//public xml_config_one - 1 - 3
    
    public xml_config_one(
        String title,
        String getAbsolutePath,
        Data insert_d,
        Hora insert_h
    )
    {
        
        this.title = title;
        this.InsertAdressLocal(getAbsolutePath);
        
        if(Arq.Dir(Arq.Files(getAbsolutePath), true)){
            
            this.cond = write;
            
        } else if(Arq.Dir(Arq.Files(getAbsolutePath), false)){//if - Arq.Dir
            
            this.cond = readonly;
            
        } else {//if - Arq.Dir
            
            this.cond = not;
            
        }//if - Arq.Dir
        
        this.insert_d = insert_d;
        this.insert_h = insert_h;
        
        this.modify_d = insert_d;
        this.modify_h = insert_h;
        
    }//public xml_config_one - 2 - 3
    
    public xml_config_one(
        String title,
        String getAbsolutePath,
        xml_config_file_cond cond,
        Data insert_d,
        Hora insert_h,
        Data modify_d,
        Hora modify_h
    )
    {
        
        this.title = title;
        this.InsertAdressLocal(getAbsolutePath);
        this.cond = cond;
        
        this.insert_d = insert_d;
        this.insert_h = insert_h;
        
        this.modify_d = modify_d;
        this.modify_h = modify_h;
        
    }//public xml_config_one - 3 - 3
    
    public void Update(Data d, Hora h){
        
        this.modify_d = d;
        this.modify_h = h;
        
    }//Update(Data d, Hora h)
    
    public void Update(){this.Update(Data.code, Hora.code);}
    
    public void newTitle(String newtitle){this.title = newtitle;}
    
    public String Local(){return this.local;}
    
    public String Title(){return this.title;}
    
    public xml_config_file_cond Cond(){return this.cond;}
    
    //public Read File(){return this.cmd;}
    
    public Data InsertData(){return this.insert_d;}
    
    public Hora InsertHora(){return this.insert_h;}
    
    public Data ModifyData(){return this.modify_d;}
    
    public Hora ModifyHora(){return this.modify_h;}
    
}//xml_config_one