/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import model.*;
import xml_rw.*;
import form.*;

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
    
    private Font[] Font(){
        
        Font font[] = {this.font_title, this.font_text};
        
        return font;
        
    }//Font()
    
    @Override
    public String Title(boolean title) {
        
        return Action.OverrideTitle(this.document, title);
        
    }

    @Override
    public String InputText() {
        
        var t = txt.text(this.document_one.getTitle());
        
        return t.isBlank() ? "" : t;
        
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
        
        return this.document_one.getText();
        
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
        
        /* CARACTER tecla = char key_char;
        ** INTEIRO NUM = 0;
        ** Domain[] indice = Domain[menu.length];
        ** 
        ** ESCOLLHA(tecla){
        **   
        **   OPÇÃO '1' -> NUM = 1;
        **   OPÇÃO '2' -> NUM = 2;
        **   OPÇÃO '3' -> NUM = 3;
        **   OPÇÃO '4' -> NUM = 4;
        **   OPÇÃO '5' -> NUM = 5;
        **   OPÇÃO '6' -> NUM = 6;
        **   OPÇÃO '7' -> NUM = 7;
        **   OPÇÃO '8' -> NUM = 8;
        **   OPÇÃO '9' -> NUM = 9;
        **   
        ** }
        ** 
        ** INTEIRO cont = 0;
        ** LÓGICO loop = VERDADEIRO;
        **
        ** REPITA{
        ** 
        ** SE (indice.Index() == NUM){
        **   
        **   ESCREVA("Chamar a função referente ao índice: ");
        **   ESCREVA(NUM);
        **   
        **   loop = FALSO;
        **   
        ** }
        ** 
        ** cont++;
        ** 
        **}ENQUANTO(loop == VERDADEIRO E cont > 0 E con < menu.length); */
        
    }

    @Override
    public void Painel3(pag3 op, Domain[] menu, String input, List<String> text, int row, int col) {
        
        switch(op){
            
            case confirm ->{
                
                Action.session_confirm(
                    true,
                    this.document,
                    Action.Document(
                        input,
                        text
                    )
                );
                
            }//case confirm
            
            case ctrl_enter, enter ->{
                
                Action.session_confirm(false,
                    this.document,
                    Action.Document(
                        input,
                        text
                    )
                );
                
            }//case confirm
            
            case cancel ->{
                
                Action.session_cancel(
                    this.document,
                    Action.Document(
                        input,
                        text
                    )
                );
                
            }//case confirm
            
            case ComboBox ->{
                
                Action.session_combobox(
                    menu,
                    this.document,
                    this.document_one,
                    this.Font(),
                    row
                );
                
            }//case ComboBox
            
        }//switch(op)
        
    }
    
}//session