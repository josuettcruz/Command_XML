/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import xml_mf.Action;
import xml_rw.*;

import model.carregarFonte;
import model.Reg;
import model.Hora;
import form.Domain;
import form.Painel_2;
import form.pag2;
import static form.pag2.*;
import static confirm_cancel.form_selected.*;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class newFont implements Painel_2{
    
    private form_selected form_selection;
    
    public newFont(xml_config con, Font[] font){
        
        this.form_selection = folder_xml;
        
    }//newFont(xml_config con, Font[] font)
    
    public newFont(xml_document doc, Font[] font){
        
        this.form_selection = ReadWrite;
        
    }//public newFont(xml_config con, Font[] font)
    
    public newFont(xml_document doc, xml_document_one one, Font[] font){
        
        this.form_selection = session;
        
    }//newFont(xml_document doc, xml_document_one one, Font[] font)

    @Override
    public String Title(boolean title) {
        
        var doc = Hora.Good();
        doc += "! ";
        
        if(title){
            
            doc += Reg.categories;
            
        } else {//if(title)
            
            doc += Reg.categories;
            doc += " - Escolha o tamanho da fonte:";
            
        }//if(title)
        
        return doc;
        
    }

    @Override
    public Font FontTitle() {
        return new java.awt.Font("Verdana", 20, 0);
    }

    @Override
    public Font ListFont() {
        return new java.awt.Font("Consolas", 20, 0);
    }

    @Override
    public List<Domain> ListMode() {
        
        List<Domain> dom = new ArrayList();
        
        Integer size[] = {8, 10, 12, 14, 18, 20, 22};
        
        for(Integer val : size){
            
            var string = "Tamanho: ";
            string += Reg.Numb(val);
            
            dom.add(new Domain(val,string));
            
        }//for(Integer val : size)
        
        return dom;
        
    }

    @Override
    public boolean SelectionMultiple() {
        return false;
    }

    @Override
    public void Command(pag2 op, List<Domain> value) {
        throw new UnsupportedOperationException("Quinta-feira,\n30/07/2026\n10:21\nAção pendente!"); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}//newFont