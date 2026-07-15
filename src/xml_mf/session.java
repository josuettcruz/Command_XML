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
    
    public Font[] Font(){
        
        Font font[] = {this.font_title, this.font_text};
        
        return font;
        
    }//Font()
    
    private void Document(List<String> input_text_area){
        
        List<String> tem = new ArrayList();
        List<xml_document_link> dat = new ArrayList();
        
        dat.addAll(this.document_one.getUrl());
        
        String tema = "";
        
        for(String val : input_text_area){
            
            Link lnk = new Link(val);
            
            if(tema.isBlank() && lnk.Val()){
                
                dat.add(
                    new xml_document_link(
                        txt.OutputForm(
                            lnk.page(true)),
                            lnk
                    )
                );
                
            } else if(tema.isBlank()){//if(tema.isBlank() && lnk.Val())
                
                tema = val;
                
            } else if(lnk.Val()){//if(tema.isBlank() && lnk.Val())
                
                dat.add(
                    new xml_document_link(
                        txt.OutputForm(tema),
                        lnk
                    )
                );
                
                tema = "";
                
            } else {//if(tema.isBlank() && lnk.Val())
                
                tem.add(txt.OutputForm(tema));
                
                tema = "";
                
            }//if(tema.isBlank() && lnk.Val())
            
        }//for(String val : input_text_area)
        
        if(!tema.isBlank()) tem.add(txt.OutputForm(tema));
        
        this.document_one.setText(tem);
        this.document_one.setUrl(dat);
        
    }//Document(List<String> input_text_area)
    
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
        
        switch(key_code){
            
            case 27, 127, 8 ->{
                
                this.Document(text);
                
                Action.session_cancel(false, this.document, this.document_one);
                
            }//case 27, 127, 8
            
        }//switch(key_code)
        
    }

    @Override
    public void Painel3(pag3 op, Domain[] menu, String input, List<String> text, int row, int col) {
        
        switch(op){
            
            case confirm ->{
                
                this.Document(text);
                
                Action.session(true, this.document, this.document_one, input);
                
            }//case confirm
            
            case ctrl_enter, enter ->{
                
                this.Document(text);
                
                Action.session(false, this.document, this.document_one, input);
                
            }//ctrl_enter, enter
            
            case ComboBox ->{
                
                var i = 0;
                var loop = true;
                
                do{
                    
                    i++;
                    
                    if(menu[i].Select()){
                        
                        this.document_one.setText(
                            Action.session_ComboBox(
                                menu[i],
                                this.document_one.getText(),
                                row
                            )
                        );
                        
                        controller.p3(
                            new session(
                                this.document,
                                this.document_one,
                                this.Font()
                            )
                        );
                        
                        loop = false;
                        
                    }//if(menu[i].Select())
                    
                }while(i > 0 && i < menu.length && loop);
                
            }//case ComboBox
            
            case cancel -> Action.session_cancel(true, this.document, this.document_one);
            
        }//switch(op)
        
    }
    
}