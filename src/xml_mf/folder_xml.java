/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package xml_mf;

import model.*;
import xml_rw.*;
import form.*;
import xml_rw.xml_config;


import form.pag1;
import static form.pag1.*;

import java.util.List;
import java.util.ArrayList;
import java.awt.Font;

/**
 *
 * @author josue
 */
public class folder_xml implements Painel_1Single, Painel_1Multiple{
    
    private xml_config document;
    private List<String> text;
    
    private Font font_title;
    private Font font_list;
    
    public folder_xml(xml_config arq, Font f[]){
        
        try{
            
            this.document = arq;
            
            this.font_title = f[0];
            this.font_list = f[1];
            
        }catch(NullPointerException err){//throw

            Action.Err("NullPointerException", err.getMessage());
            
        }catch(Exception err){//throw

            Action.Err("Exception", err.getMessage());
            
        }//throw
        
    }//folder_xml(Arq arq, Font f[], String[] str, boolean[] bool)

    @Override
    public Font FontTitle() {
        return this.font_title;
    }

    @Override
    public Font ListFont() {
        return this.font_list;
    }

    @Override
    public String Title(boolean title) {
        
        var d = new Data();
        
        if(title){
            
            var value = Hora.Good();
            
            if(this.document.Windows()){
                
                value += ": ";
                value += this.document.UserWindows();
                
            }//if(this.document.Windows())
            
            value += " - ";
            value += d.DataAbreviada(true);
            
            return value;
            
        } else if(this.document.Windows()){//if(title)
            
            var val = "[";
            val += this.document.UserWindows().toUpperCase();
            val += "] ";
            val += d.DataCompleta(false);
            
            return val;
            
        } else {//if(title)
            
            return d.DataCompleta(true);
            
        }//if(title)
        
    }

    @Override
    public String InputText() {
        return "";
    }

    @Override
    public List<Domain> ListMode() {
        
        List<Domain> demo = new ArrayList();
        
        if(this.document.learn().isEmpty()){
            
            demo.add(new Domain(0,"Lisa Vazia!"));
            
        } else {//if(this.tema.learn().isEmpty())
            
            for(var i = 0; i < this.document.learn().size(); i++){
                
                var t = txt.text(this.document.learn().get(i).Title());
                
                demo.add(new Domain(i,txt.title(t, true)));
                
            }//for(var i = 0; i < this.document.learn().size(); i++)
            
        }//if(this.tema.learn().isEmpty())
        
        return demo;
        
    }

    @Override
    public boolean ListColumn() {
        return this.document.learn().size() >= 50;
    }

    @Override
    public void Action(pag1 action, List<Domain> vol, String input) {
        
        switch(action){
            
            case add, open, key, enter ->{
                
                var cont = 0;
                var loop = true;
                
                do{
                    
                    if(vol.get(cont).Select()){
                        
                        Action.folder_xml(vol.get(cont), input);
                        
                        loop = false;
                        
                    }//if(vol.get(cont).Select())
                    
                    cont++;
                    
                }while(loop && cont > 0 && cont < vol.size());
                
                if(loop) Action.folder_xml(input);
                
            }//case add, open, key, enter
            
            case remove, delet, backspace ->{
                
                var proc = 0;
                var valid = false;
                
                do{
                    
                    valid = vol.get(proc).Select();
                    
                    proc++;
                    
                }while(!valid && proc > 0 && proc < vol.size());
                
                if(valid){
                    
                    List<Domain> select_del = new ArrayList();
                    
                    for(Domain v : vol)
                    {if(v.Select()) select_del.add(v);}
                    
                    Action.folder_xml(select_del);
                    
                }//if(valid)
                
            }
            
        }
        
    }
    
}//folder_xml