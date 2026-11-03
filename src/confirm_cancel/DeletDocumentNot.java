/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import xml_rw.xml_config;

import form.Domain;
import form.Painel_2;
import form.pag2;
import java.awt.Font;
import java.util.List;
import java.util.ArrayList;
import xml_mf.Action;
import xml_rw.xml_config_file_cond;

import static form.pag2.confirm;
import static form.pag2.cancel;
import static form.pag2.enter;
import static form.pag2.del;
import static form.pag2.backspace;

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
                
                List<Integer> delet = new ArrayList();
                
                for(Domain d : value){
                    
                    if(d.Select()) delet.add(d.index());
                    
                }//for(Domain d : value)
                
                if(delet.isEmpty()){
                    
                    Action.folder_xml();
                    
                } else {//if(delet.isEmpty())
                    
                    xml_config doc = this.xml;
                    
                    if(delet.size() == 1){
                        
                        doc.Del(delet.get(0));
                        
                    } else {//if(delet.size() == 1)
                        
                        for(var x = delet.size()-1; x >= 0; x--)
                        {doc.Del(delet.get(x));}
                        
                    }//if(delet.size() == 1)
                    
                    Action.folder_xml(doc);
                    
                }//if(delet.isEmpty())
                
            }//case confirm, enter
            
            case cancel ->{
                
                Action.folder_xml();
                
            }//case cancel
            
        }//switch(op)
        
    }
    
}//DeletDocumentNot