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
import xml_mf.Action;

/**
 *
 * @author josue
 */
public class DeleteSaveTemp implements Painel_2{
    
    private final String not = "Ação indisponpivel!";
    
    private Font font_title;
    private Font font_text;
    
    public DeleteSaveTemp(xml_document doc, Font[] f){
        
        try{
            
            this.font_title = f[0];
            this.font_text = f[1];
            
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
        throw new UnsupportedOperationException(this.not); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Font FontTitle() {
        throw new UnsupportedOperationException(this.not); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Font ListFont() {
        throw new UnsupportedOperationException(this.not); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Domain> ListMode() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean SelectionMultiple() {
        throw new UnsupportedOperationException(this.not); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Command(pag2 op, List<Domain> value) {
        // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}