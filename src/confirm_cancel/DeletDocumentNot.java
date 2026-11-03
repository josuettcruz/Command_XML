/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import xml_rw.xml_config;

import form.Domain;
import form.Painel_2;
import form.pag2;
import xml_mf.*;
import xml_rw.*;

import static form.pag2.confirm;
import static form.pag2.cancel;
import static form.pag2.enter;
import static form.pag2.del;
import static form.pag2.backspace;

import java.awt.Font;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class DeletDocumentNot implements Painel_2{
    
    private Font font_title;
    private Font font_text;
    private xml_config xml;
    
    public DeletDocumentNot(xml_config xml, Font[] f){
        
        try{
            
            this.font_title = f[0];
            this.font_text = f[1];
            this.xml = xml;
            
            /* Esse é o formulário          **
            ** que deverá aparecer          **
            ** quando um ou mais documentos **
            ** presentes no arquivo XML     **
            ** estiver ausente!             */

        }catch(NullPointerException err){//throw

            Action.Err("NullPointerException", err.getMessage());
            
        }catch(Exception err){//throw

            Action.Err("Exception", err.getMessage());
            
        }//throw
        
    }//DeletDocumentNot(xml_config xml, Font[] f)
    
    public Font[] Font(){
        
        java.awt.Font font[] = {
            this.font_title,
            this.font_text
        };
        
        return font;
        
    }//Font()

    @Override
    public String Title(boolean title) {
        return "Remover itens indisponíveis?";
    }

    @Override
    public Font FontTitle() {
        return this.font_title;
    }

    @Override
    public Font ListFont() {
        return this.font_text;
    }

    @Override
    public List<Domain> ListMode() {
        
        List<Domain> lts = new ArrayList();
        
        for(var i = 0; i < this.xml.learn().size(); i++){
            
            var d = this.xml.learn().get(i).Cond();
            
            if(d == xml_config_file_cond.not)
            lts.add(new Domain(i,this.xml.learn().get(i).Title()));
            
        }//for(var i = 0; i < this.xml.learn().size(); i++)
        
        return lts;
        
    }

    @Override
    public boolean SelectionMultiple() {return true;}

    @Override
    public void Command(pag2 op, List<Domain> value) {
        
        switch(op){
            
            case confirm, enter, del, backspace ->{
                
                List<Integer> cod = new ArrayList();
                
                for(Domain d : value){
                    
                    if(d.Select())
                    {cod.add(d.index());}
                
                }//for(Domain d : value)
                
                if(cod.isEmpty()){
                    
                    Action.folder_xml();
                    
                } else {//if(cod.isEmpty())
                    
                    xml_config new_xml = this.xml;
                    
                    if(cod.size() == 1){
                        
                        new_xml.Del(cod.get(0));
                        
                    } else {//if(cod.size() == 1)
                        
                        new_xml.Del(cod);
                        
                    }//if(cod.size() == 1)
                    
                    Action.folder_xml(new_xml);
                    
                }//if(cod.isEmpty())
                
            }//case confirm, enter
            
            case cancel ->{
                
                Action.folder_xml();
                
            }//case cancel
            
        }//switch(op)
        
    }
    
}//DeletDocumentNot