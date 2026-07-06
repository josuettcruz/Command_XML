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
 * @author joaot
 */
public class session implements Painel_3 {
    
    private xml_document document;
    
    private xml_document_one doc;
    
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
    
    private void Error(String err){
        
        if(Reg.java) System.err.println(err);
        System.exit(0);
        
    }//Error(String err)
    
    public session(int pos, xml_document d, Font ftitle, Font ftext){
        
        if(pos >= 0 && pos < d.List().size() && !d.List().isEmpty()){
            
            try{
                
                this.document = d;
                
                this.doc = d.List().get(pos);
                
                Font[] font = {ftitle, ftext};
                
                this.myfont = font;
                
            } catch(Exception e){//throw
                
                this.Error(e.getMessage());
                
            }//throw
            
        } else {//if(pos >= 0 && pos < d.List().size() && !d.List().isEmpty())
            
            this.Error("Algo deu errado com o código do projto!");
            
        }//if(pos >= 0 && pos < d.List().size() && !d.List().isEmpty())
        
    }//session(int pos, xml_document d, Font ftitle, Font ftext)

    @Override
    public String Title(boolean title) {
        
        final var max = this.document.getTitle();
        
        if(title){
            
            return this.document.ModifyDate().DataAbreviada(true);
            
        } else if(max.length() > 15){//if(title)
            
            return txt.Local(max);
            
        } else {//if(title)
            
            return txt.text(max);
            
        }//if(title)
                
    }

    @Override
    public String InputText() {
        return this.doc.getTitle();
    }

    @Override
    public Font FontTitle() {
        return this.myfont[0];
    }

    @Override
    public List<String> TextArea() {
        
        List<String> tema = new ArrayList();
        
        for(String t : this.doc.getText()) tema.add(txt.InputForm(t));
        
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
