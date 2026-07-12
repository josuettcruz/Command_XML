/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package xml_mf;

import file.*;
import model.*;
import xml_rw.*;
import form.*;
import xml_rw.xml_config;


import form.pag1;
import static form.pag1.*;

import form.pag2;
import static form.pag2.*;

import form.pag3;
import static form.pag3.*;

import java.util.List;
import java.util.ArrayList;
import java.awt.Font;

/**
 *
 * @author josue
 */
public class folder_xml implements Painel_1Single, Painel_1Multiple, Painel_2{
    
    private xml_config document;
    private List<String> text;
    
    private Font font_title;
    private Font font_list;
    
    private boolean selection_multiple;
    
    public folder_xml(xml_config arq, Font f[], boolean multiple){
        
        try{
            
            this.document = arq;
            
            this.font_title = f[0];
            this.font_list = f[1];
            
            this.selection_multiple = multiple;
            
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
        
        var val = "";
        
        if(title){
            
            if(this.document.Windows()){
                
                val += "\"";
                val += this.document.UserWindows();
                val += "\" -- ";
            
            }//if(this.document.Windows())
            
            val += d.DataAbreviada(!this.document.Windows());
            
        } else {//if(title)
            
            val += d.DataCompleta(this.document.Windows());
            
        }//if(title)
        
        return val;
        
    }

    @Override
    public String InputText() {
        return "";
    }

    @Override
    public List<Domain> ListMode() {
        
        var tema = this.document.learn();
        
        List<Domain> demo = new ArrayList();
        
        var insert = 0;
        
        if(tema.isEmpty()){
            
            demo.add(new Domain(insert,"Lisa Vazia!"));
            
        } else {//if(this.tema.learn().isEmpty())
            
            for(xml_config_one x : tema){
                
                insert++;
                
                demo.add(
                    new Domain(
                        insert,txt.title(x.Title(), true)
                    )
                );
                
            }//for(xml_config_one x : this.tema.learn())
            
        }//if(this.tema.learn().isEmpty())
        
        return demo;
        
    }

    @Override
    public boolean ListColumn() {
        return this.document.learn().size() >= 50;
    }

    @Override
    public boolean SelectionMultiple() {
        return this.selection_multiple;
    }

    @Override
    public void Action(pag1 action, List<Domain> vol, String input) {
        
        //throw new UnsupportedOperationException(this.temp);
        
    }

    @Override
    public void Command(pag2 op, List<Domain> value) {
        
        //throw new UnsupportedOperationException(this.temp);
        
    }
    
}//folder_xml