/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import file.*;
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
public class ReadWrite implements Painel_1Single, Painel_2 {
    
    private xml_document document;
    
    private Font font_title;
    private Font font_list;
    
    private String title;
    private String header;
    private String input;
    
    private boolean multiple_selection;
    
    public ReadWrite(
        xml_document arquivo,
        Font FontTitle,
        Font FontList,
        String[] str,
        boolean selection_multiple
    )
    {
        
        try{
            
            this.document = arquivo;
            
            this.font_title = FontTitle;
            this.font_list = FontList;
            
            this.title = str[0];
            this.header = str[1];
            this.input = str[2];
            
            this.multiple_selection = selection_multiple;
            
        }catch(NullPointerException err){//throw

            Action.Err("NullPointerException", err.getMessage());
            
        }catch(Exception err){//throw

            Action.Err("Exception", err.getMessage());
            
        }//throw
        
    }//ReadWrite
    
    private List<Domain> DomainList(){
        
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
        
    }//DomainList()
    
    public String[] Mytext(){
        
        String[] value = {this.title,this.header,this.input};
        
        return value;
        
    }//Mytext()
    
    private Font FontTitleFamily(){
        
        return this.font_title == null
            ? new java.awt.Font("Impact", 0, 18)
            : this.font_title;
        
    }//FontTitleFamily()
    
    private Font FontListFamily(){
        
        return this.font_list == null
            ? new java.awt.Font("Consolas", 0, 12)
            : this.font_list;
        
    }//FontListFamily()
    
    public Font MyFont(boolean title)
    {return title ? this.FontTitleFamily() : this.FontListFamily();}

    @Override
    public Font FontTitle() {
        return this.FontTitleFamily();
    }

    @Override
    public Font ListFont() {
        return this.FontListFamily();
    }

    @Override
    public String Title(boolean title) {
        return title ? this.title : this.header;
    }

    @Override
    public String InputText() {
        return this.input;
    }

    @Override
    public List<Domain> ListMode() {
        return this.DomainList();
    }

    @Override
    public boolean ListColumn() {
        return this.DomainList().size() >= 10;
    }

    @Override
    public boolean SelectionMultiple() {
        return this.multiple_selection;
    }

    @Override
    public void Action(pag1 action, List<Domain> vol, String input) {
        
        //throw new UnsupportedOperationException(this.temp);
        
    }

    @Override
    public void Command(pag2 op, List<Domain> value) {
        
        //throw new UnsupportedOperationException(this.temp);
        
        
    }
    
}//ReadWrite