/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package xml_mf;

import model.*;
import xml_rw.*;
import form.*;

import form.pag1;
import static form.pag1.*;

import java.util.List;
import java.util.ArrayList;
import java.awt.Font;

/**
 *
 * @author josue
 */
public class folder_xml implements Painel_1Single{
    
    private xml_config document;
    private List<String> text;
    private String input;
    
    private Font font_title;
    private Font font_list;
    
    private void init(xml_config arq, Font f[], String str){
        
        try{
            
            this.document = arq;
            
            this.font_title = f[0];
            this.font_list = f[1];
            
            this.input = str;
            
        }catch(NullPointerException err){//throw

            Action.Err("NullPointerException", err.getMessage());
            
        }catch(Exception err){//throw

            Action.Err("Exception", err.getMessage());
            
        }//throw
        
    }//folder_xml(Arq arq, Font f[], String[] str, boolean[] bool)
    
    public folder_xml(xml_config arq, Font f[], String str)
    {this.init(arq, f, str);};
    
    public folder_xml(xml_config arq, Font f[])
    {this.init(arq, f, "");};

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
        
        var val = Hora.Good();
        
        if(title){
            
            val += ": ";
            
            if(this.document.Windows()){
                
                val += this.document.UserWindows();
                
            } else {//if(this.document.Windows())
                
                val += d.DataAbreviada(true);
                
            }//if(this.document.Windows())
            
        } else {//if(title)
            
            val += ", hoje é ";
            val += d.DataCompleta(true);
            
        }//if(title)
        
        return val;
        
    }

    @Override
    public String InputText() {
        return this.input;
    }

    @Override
    public List<Domain> ListMode() {
        
        List<Domain> demo = new ArrayList();
        
        if(this.document.learn().isEmpty()){
            
            demo.add(new Domain(0,"Lisa Vazia!"));
            
        } else {//if(this.tema.learn().isEmpty())
            
            for(var id = 0; id < this.document.learn().size(); id++){
                
                var t = txt.text(this.document.learn().get(id).Title());
                
                demo.add(new Domain(id,txt.title(t, true)));
                
            }//for(var id = 0; id < this.document.learn().size(); id++)
            
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
                        
                        Action.folder_xml(this.document, vol.get(cont), input);
                        
                        loop = false;
                        
                    }//if(vol.get(cont).Select())
                    
                    cont++;
                    
                }while(loop && cont > 0 && cont < vol.size());
                
                if(loop) Action.folder_xml(this.document, input);
                
            }//case add, open, key, enter
            
            case remove -> Action.Exit();
            
        }//switch(action)
        
    }
    
}//folder_xml