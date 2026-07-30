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
public class ReadWrite implements Painel_1Single, Painel_1Multiple {
    
    private xml_document document;
    
    private Font font_title;
    private Font font_list;
    
    private String input;
    
    private void init(xml_document arq, Font f[], String str){
        
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
        
    }//ReadWrite(xml_document arq, Font f[], String str, boolean mul)
    
    public ReadWrite(xml_document arq, Font f[], String str)
    {this.init(arq, f, str);}
    
    public ReadWrite(xml_document arq, Font f[])
    {this.init(arq, f, "");}

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
        
        return Action.OverrideTitle(this.document, title);
        
    }

    @Override
    public String InputText() {
        return this.input;
    }

    @Override
    public List<Domain> ListMode() {
        
        List<Domain> demo = new ArrayList();
        
        if(this.document.List().isEmpty()){
            
            demo.add(new Domain(0, "Lista Vazia!"));
            
        } else {//if(this.document.List().isEmpty())
            
            for(int id = 0; id < this.document.List().size(); id++){
                
                var tema = txt.text(this.document.List().get(id).getTitle());
                
                demo.add(new Domain(id,txt.title(tema, true)));
                
            }//for(int cont = 0; cont < this.document.List().size(); cont++)
            
        }//if(this.document.List().isEmpty())
        
        return demo;
        
    }

    @Override
    public boolean ListColumn() {
        return this.document.List().size() >= 50;
    }

    @Override
    public void Action(pag1 action, List<Domain> vol, String input) {
        
        switch(action){
            
            case open, add, enter, key -> {
                
                var proc = 0;
                var void_selected = true;
                
                do{
                    
                    if(vol.get(proc).Select()){
                        
                        Action.ReadWrite(
                            this.document,
                            this.document.List().get(
                                vol.get(proc).index()
                            ),
                            input
                        );
                        
                        void_selected = false;
                        
                    }//if(vol.get(proc).Select())
                    
                    proc++;
                    
                }while(void_selected && proc > 0 && proc < vol.size());
                
                if(void_selected) Action.ReadWrite(this.document,input);
                
            }//case open, add, enter, key 
            
            case remove -> {
                
                var proc_list = 0;
                var selected = false;
                
                do{
                    
                    selected = vol.get(proc_list).Select();
                    
                    proc_list++;
                    
                }while(!selected && proc_list > 0 && proc_list < vol.size());
                
                if(selected){
                    
                    /* Abrir um formulário   **
                    ** que ainda será criado **
                    ** com as opções de      **
                    ** confirmar exclusão!   */
                    
                } else {//if(selected)
                    
                    Action.Exit();
                    
                }//if(selected)
                
            }//case remove 
            
        }//switch(action)
        
    }
    
}//ReadWrite