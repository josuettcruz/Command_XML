/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import file.*;
import model.*;
import xml_rw.*;
import form.*;
import model.Reg;


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
public class session implements Painel_3 {
    
    private xml_document document;
    
    private xml_document_one document_one;
    
    private Font font_title;
    private Font font_text;
    
    private void init(
        xml_document document,
        xml_document_one document_one,
        Font font[]
    )
    {
        
        try{

            this.document = document;
            this.document_one = document_one;
            
            this.font_title = font[0];
            this.font_text = font[1];

        }catch(NullPointerException err){//throw

            Action.Err("NullPointerException", err.getMessage());
            
        }catch(Exception err){//throw

            Action.Err("Exception", err.getMessage());
            
        }//throw
        
    }//init(xml_document d, xml_document_one o, Font ftitle, Font ftext)
    
    public session(xml_document doc,xml_document_one doc_one,Font font[]){
        
        this.init(doc, doc_one, font);
        
    }//session(xml_document doc,xml_document_one doc_one,Font font[])
    
    public session(xml_document document,Font font[]){
        
        this.init(document, new xml_document_one(), font);
        
    }//session(xml_document document,Font font[])
    
    @Override
    public String Title(boolean title) {
        
        final var max_str = 15;
        
        final var max = this.document.getTitle();
        
        if(title){
            
            return this.document.ModifyDate().DataAbreviada(true);
            
        } else if(max.length() > max_str){//if(title)
            
            var mytext = "";
            
            var dem = txt.phrase(max);
            
            int cont = 0;
            
            var i = 0;
            var loop = true;
            
            do{
                
                if(i > 0) mytext += " ";
                
                mytext += dem.get(i);
                
                cont += dem.get(i).length();
                
                loop = cont < max_str;
                
                i++;
                
            }while(i > 0 && i < dem.size() && loop);
            
            if(mytext.length() > max_str){
                
                var temp = mytext;
                
                mytext = temp.substring(0, max_str);
                
            }//if(mytext.length() > max_str)
            
            return mytext;
            
        } else {//if(title)
            
            return txt.text(max);
            
        }//if(title)
                
    }

    @Override
    public String InputText() {
        
        if(txt.text(this.document_one.getTitle()).isBlank()){
            
            return "";
            
        } else {//if(txt.text(this.Tema().getTitle()).isBlank())
            
            return txt.InputForm(this.document_one.getTitle());
            
        }//if(txt.text(this.Tema().getTitle()).isBlank())
        
    }

    @Override
    public Font FontTitle() {
        return this.font_title;
    }

    @Override
    public List<String> TextArea() {
        
        List<String> tema = new ArrayList();
        
        if(!this.document_one.getText().isEmpty()){
            
            for(String text : this.document_one.getText()){
                
                tema.add(txt.InputForm(text));
                
            }//for(String text : this.Tema().getText())
            
        }//if(!this.Tema().getText().isEmpty())
        
        return tema;
        
    }

    @Override
    public Font TextAreaFont() {
        return this.font_text;
    }

    @Override
    public boolean JComboBox() {
        return true;
    }

    @Override
    public Domain[] Mode() {
        
        return Action.session_option;
        
    }

    @Override
    public void Painel3(int key_code, char key_char, Domain[] menu, String input, List<String> text, int row, int col) {
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }

    @Override
    public void Painel3(pag3 op, Domain[] menu, String input, List<String> text, int row, int col) {
        
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
        
    }
    
}
