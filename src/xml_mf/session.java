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

import java.awt.Font;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class session implements Painel_3 {
    
    private xml_document document;
    
    private int position;
    
    private Font[] myfont;
    
    private final String[] option = {
        "Ação 01",
        "Ação 02",
        "Ação 03",
        "Ação 04",
        "Ação 05",
        "Ação 06",
        "Ação 07",
        "Ação 08",
        "Ação 09",
        "Ação 10",
    };
    
    public session(int pos, xml_document d, Font ftitle, Font ftext){
        
        try{

            this.document = d;
            
            if(pos >= 0 && pos < d.List().size() && !d.List().isEmpty()){
                
                this.position = pos;
                
            } else {//if(pos >= 0 && pos < d.List().size() && !d.List().isEmp...
                
                this.position = -1;
                
            }//if(pos >= 0 && pos < d.List().size() && !d.List().isEmpty())

            this.myfont = new Font[2];
            
            this.myfont[0] = ftitle;
            this.myfont[1] = ftext;

        } catch(Exception err){//throw

            Action.Err(err.getMessage());

        }//throw
        
    }//session(int pos, xml_document d, Font ftitle, Font ftext)
    
    public xml_document_one Tema(){
        
        var d = this.document.List();
        
        if(this.position >= 0 && !d.isEmpty()){
            
            return d.get(this.position);
            
        } else {//if(this.position >= 0 && !d.isEmpty())
            
            if(this.position != -1 || this.position > d.size()) System.exit(0);
            
            return new xml_document_one();
            
        }//if(this.position >= 0 && !d.isEmpty())
        
    }//Tema()
    
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
        
        if(txt.text(this.Tema().getTitle()).isBlank()){
            
            return "";
            
        } else {//if(txt.text(this.Tema().getTitle()).isBlank())
            
            return txt.InputForm(this.Tema().getTitle());
            
        }//if(txt.text(this.Tema().getTitle()).isBlank())
        
    }

    @Override
    public Font FontTitle() {
        return this.myfont[0];
    }

    @Override
    public List<String> TextArea() {
        
        List<String> tema = new ArrayList();
        
        if(!this.Tema().getText().isEmpty()){
            
            for(String text : this.Tema().getText()){
                
                tema.add(txt.InputForm(text));
                
            }//for(String text : this.Tema().getText())
            
        }//if(!this.Tema().getText().isEmpty())
        
        return tema;
        
    }

    @Override
    public Font TextAreaFont() {
        return this.myfont[1];
    }

    @Override
    public boolean JComboBox() {
        return true;
    }

    @Override
    public Domain[] Mode() {
        
        Domain[] demo = new Domain[this.option.length];
        
        for(int i = 0; i < demo.length && i < this.option.length; i++){
            
            var cod = i+1;
            
            var tematico = "[";
            tematico += Reg.Numb(cod, demo.length);
            tematico += "] ";
            tematico += this.option[i];
            
            demo[i] = new Domain(cod, tematico);
            
        }//for(int i = 0; i < dem.length && i < text.length; i++)
        
        return demo;
        
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
