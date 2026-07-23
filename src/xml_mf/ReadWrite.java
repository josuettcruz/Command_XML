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
public class ReadWrite implements Painel_1Single {
    
    private xml_document document;
    
    private Font font_title;
    private Font font_list;
    
    private String input;
    private boolean multiple_selection;
    
    public ReadWrite(xml_document arq, Font f[], String str, boolean mul){
        
        try{
            
            this.document = arq;
            
            this.font_title = f[0];
            this.font_list = f[1];
            
            this.input = str;
            this.multiple_selection = mul;
            
        }catch(NullPointerException err){//throw

            Action.Err("NullPointerException", err.getMessage());
            
        }catch(Exception err){//throw

            Action.Err("Exception", err.getMessage());
            
        }//throw
        
    }//ReadWrite(xml_document arq, Font f[], String str, boolean mul)

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
        
        var tema = this.document.List();
        
        var insert = 0;
        
        if(tema.isEmpty()){
            
            demo.add(new Domain(insert, "Lista Vazia!"));
            
        } else {//if(this.tema.List().isEmpty())
            
            for(xml_document_one x : tema){
                
                insert++;
                
                demo.add(
                    new Domain(
                        insert, txt.title(x.getTitle(), true)
                    )
                );
                
            }//for(xml_document_one x : this.tema.List())
            
        }//if(this.tema.List().isEmpty())
        
        return demo;
        
    }

    @Override
    public boolean ListColumn() {
        return this.document.List().size() >= 50;
    }

    @Override
    public void Action(pag1 action, List<Domain> vol, String input) {
        
        switch(action){
            
            case open, enter -> Action.ReadWrite(this.document, input);
            
            case add, key -> Action.ReadWrite(vol, this.document);
            
        }
        
    }
    
}//ReadWrite