/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import xml_rw.xml_document;

import form.Domain;
import form.Painel_2;
import form.pag2;
import java.awt.Font;
import java.util.List;
import java.util.ArrayList;
import xml_mf.Action;

/**
 *
 * @author josue
 */
public class DeleteSaveTemp implements Painel_2{
    
    private final String not = "Ação indisponpivel!";
    
    private Font font_title;
    private Font font_text;
    private xml_document doc;
    
    public DeleteSaveTemp(xml_document doc, Font[] f){
        
        try{
            
            this.font_title = f[0];
            this.font_text = f[1];
            this.doc = doc;
            
            /* Esse painel vai exibir:           **
            ** todos os itens marcados com "~"   **
            ** e só irá aparecer,                **
            ** quando um ou mais itens dentro do **
            ** documento DOC tiver essa marcação */
            
        }catch(NullPointerException err){//throw

            Action.Err("NullPointerException", err.getMessage());
            
        }catch(Exception err){//throw

            Action.Err("Exception", err.getMessage());
            
        }//throw
        
    }//DeleteSaveTemp(xml_document doc)
    
    public Font[] Font(){
        
        java.awt.Font font[] = {
            this.font_title,
            this.font_text
        };
        
        return font;
        
    }//Font()

    @Override
    public String Title(boolean title) {
        return "ESCLUIR ou RESTAURAR";
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
        
        for(var i = 0; i < this.doc.List().size(); i++){
            
            var t = this.doc.List().get(i).getTitle();
            
            if(t.charAt(0) == '~' && t.length() > 1)
            lts.add(new Domain(i,t.substring(1)));
            
        }//for(var i = 0; i < this.doc.List().size(); i++)
        
        return lts;
        
    }

    @Override
    public boolean SelectionMultiple() {return true;}

    @Override
    public void Command(pag2 op, List<Domain> value) {
        
        // void
        
    }
    
}//DeleteSaveTemp