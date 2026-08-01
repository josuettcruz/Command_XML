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
    
    private Domain option;
    private boolean option_selected;
    
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
        
    }//session(xml_document all, xml_document_one one, Font f[])
    
    public session(xml_document all, xml_document_one one, Font f[]){
        
        this.init(all, one, f);
        
        this.option = new Domain(0,"");
        this.option_selected = false;
        
    }//session(xml_document all, xml_document_one one, Font f[])
    
    private session(xml_document all, xml_document_one one, Font f[], Domain op){
        
        this.init(all, one, f);
        
        this.option = op;
        this.option_selected = op.index() > 0;
        
    }//session(xml_document all, xml_document_one one, Font f[], Domain op)
    
    private Font[] Font(){
        
        Font font[] = {this.font_title, this.font_text};
        
        return font;
        
    }//Font()
    
    @Override
    public String Title(boolean title) {
        
        if(this.option_selected && title){
            
            var value = "-- ";
            value += Hora.Good();
            value += "! Opção ";
            value += this.option.index();
            value += " selecionada!";
            
            return value;
            
        } else if(this.option_selected){//if(this.option_selected && title)
            
            return this.option.Text();
            
        } else {//if(this.option_selected && title)
            
            return Action.OverrideTitle(this.document, title);
            
        }//if(this.option_selected && title)
        
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
        
        return Action.session_Document(this.document_one);
        
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
        
        var num = -1;
        
        switch(key_code){
            
            case 49 -> num = 1;
            case 50 -> num = 2;
            case 51 -> num = 3;
            case 52 -> num = 4;
            case 53 -> num = 5;
            case 54 -> num = 6;
            case 55 -> num = 7;
            case 56 -> num = 8;
            case 57 -> num = 9;
            case 48 -> num = 10;
            
            case 10 ->{
                
                Link lnk = new Link(text.get(row));
                
                if(lnk.Val()){
                    
                    lnk.Open();
                    Action.Exit();
                    
                }//if(lnk.Val())
                
            }//case 10
            
        }//switch(key_char)
        
        if(num >= 1 && num <= Action.max_session_option){
            
            var cont = 0;
            var loop = true;
            
            do{
                
                if(num == menu[cont].index()){
                    
                    Action.session_combobox(
                        menu[cont],
                        this.document,
                        this.document_one,
                        this.Font(),
                        row
                    );
                    
                    loop = false;
                    
                }//if(num ==menu[cont].index())
                
                cont++;
                
            }while(loop && cont > 0 && cont < menu.length);
            
        }//if(num >= 1 && num <= Action.max_session_option)
        
    }

    @Override
    public void Painel3(pag3 op, Domain[] menu, String input, List<String> text, int row, int col) {
        
        switch(op){
            
            case confirm, ctrl_enter, enter ->{
                
                if(this.option.index() == 0){
                    
                    Action.session_confirm(
                        this.document,
                        this.document_one,
                        input
                    );
                    
                } else {//if(this.option.index() == 0)
                    
                    Action.session_combobox(
                        this.option,
                        this.document,
                        this.document_one,
                        this.Font(),
                        row
                    );
                    
                }//if(this.option.index() == 0)
                
            }//case confirm, ctrl_enter, enter
            
            case cancel ->{
                
                Action.session_cancel(
                    this.document,
                    this.document_one,
                    input
                );
                
            }//case confirm
            
            case ComboBox ->{
                
                var cont = 0;
                var loop = true;
                
                do{
                    
                    if(menu[cont].Select()){
                        
                        controller.p3(
                            new session(
                                this.document,
                                this.document_one,
                                this.Font(),
                                menu[cont]
                            )
                        );
                        
                        loop = false;
                        
                    }//if(menu[cont].Select())
                    
                    cont++;
                    
                }while(loop && cont > 0 && cont < menu.length);
                
            }//case ComboBox
            
        }//switch(op)
        
    }
    
}//session