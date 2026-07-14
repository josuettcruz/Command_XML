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
    
    private void init(xml_document all, xml_document_one one, Font f[]){
        
        try{

            this.document = all;
            this.document_one = one;
            
            this.font_title = f[0];
            this.font_text = f[1];

        }catch(NullPointerException err){//throw

            Action.Err("NullPointerException", err.getMessage());
            
        }catch(Exception err){//throw

            Action.Err("Exception", err.getMessage());
            
        }//throw
        
    }//init(xml_document all, xml_document_one one, Font f[])
    
    public session(xml_document doc,xml_document_one doc_one,Font font[]){
        
        this.init(doc, doc_one, font);
        
    }//session(xml_document doc,xml_document_one doc_one,Font font[])
    
    public session(xml_document document,Font font[]){
        
        this.init(document, new xml_document_one(), font);
        
    }//session(xml_document document,Font font[])
    
    @Override
    public String Title(boolean title) {
        
        return Action.OverrideTitle(this.document, title);
                
    }

    @Override
    public String InputText() {
        
        var value = "";
        
        if(!txt.text(this.document_one.getTitle()).isBlank())
        {value += txt.InputForm(this.document_one.getTitle());}
        
        return value;
        
    }

    @Override
    public Font FontTitle() {
        return this.font_title;
    }

    @Override
    public Font TextAreaFont() {
        return this.font_text;
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
        
        switch(op){
            
            case confirm ->{
                
                Action.session(true, this.document, this.document_one, input, text);
                
            }//case confirm
            
            case ctrl_enter, enter ->{
                
                Action.session(false, this.document, this.document_one, input, text);
                
            }//ctrl_enter, enter
            
            case ComboBox ->{
                
                var i = 0;
                var loop = true;
                
                do{
                    
                    i++;
                    
                    if(menu[i].Select()){
                        
                        Font ttf[] = {this.font_title, this.font_text};
                        
                        controller.p3(
                            new session(
                                this.document,
                                Action.session_ComboBox(
                                    menu[i],
                                    this.document_one,
                                    row
                                ),
                                ttf
                            )
                        );
                        
                        loop = false;
                        
                    }//if(menu[i].Select())
                    
                }while(i > 0 && i < menu.length && loop);
                
            }//case ComboBox
            
            case cancel -> Action.cancel_mouse(true);
            
        }//switch(op)
        
    }
    
}