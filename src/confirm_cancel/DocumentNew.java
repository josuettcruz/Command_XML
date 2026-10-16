/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import xml_mf.Action;
import xml_rw.xml_document;

import form.Domain;
import form.Painel_2;
import form.pag2;
import static form.pag2.enter;
import static form.pag2.confirm;
import static form.pag2.cancel;

import java.awt.Font;
import java.util.List;
import java.util.ArrayList;

import form.pag2;

/**
 *
 * @author josue
 */
public class DocumentNew implements Painel_2{
    
    private xml_document doc;
    
    private Font font_title;
    private Font font_text;
    
    public DocumentNew(xml_document doc, Font f[]){
        
        try{
            
            this.doc = doc;
            this.font_title = f[0];
            this.font_text = f[1];

        }catch(NullPointerException err){//throw

            Action.Err("NullPointerException", err.getMessage());
            
        }catch(Exception err){//throw

            Action.Err("Exception", err.getMessage());
            
        }//throw
        
    }//DocumentNew(xml_document doc, String title, Font f[])
    
    public Font[] Font(){
        
        java.awt.Font[] f = {this.font_title, this.font_text};
        
        return f;
        
    }//Font()

    @Override
    public String Title(boolean title) {
        return title ? doc.ModifyDate().DataAbreviada(true) : doc.getTitle();
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
        
        List<Domain> dom = new ArrayList();
        
        if(this.doc.Write()) dom.add(new Domain(0, "Abrir"));
        
        dom.add(new Domain(1, "Exportar HTML/CSS/JavaScript"));
        
        dom.add(new Domain(2, "Apagar"));
        
        dom.add(new Domain(3, "Voltar"));
        
        return dom;
        
    }

    @Override
    public boolean SelectionMultiple() {
        return false;
    }

    @Override
    public void Command(pag2 op, List<Domain> value) {
        
        switch(op){
            
            case confirm, enter ->{
                
                var proc = 0;
                var loop = true;
                
                do{
                    
                    if(value.get(proc).Select()){
                        
                        /* Executar ação correspondente **
                        ** à opção selecionada!         */
                        
                        loop = false;
                        
                    }//if(value.get(proc).Select())
                    
                    proc++;
                    
                }while(loop && proc > 0 && proc < value.size());
                
            }//case confirm, enter
            
            case cancel ->{
                
                /* Executar a ação correspondente:   **
                ** dom.add(new Domain(3, "Voltar")); */
                
            }//case cancel
            
        }//switch(op)
        
    }
    
}
