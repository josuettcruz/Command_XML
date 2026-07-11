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
public class folder_xml implements Painel_1Single, Painel_1Multiple, Painel_2{
    
    private Arq save;
    private List<String> text;
    
    private Font font_title;
    private Font font_list;
    
    private String title;
    private String header;
    private String input;
    
    private boolean list_colum;
    private boolean selection_multiple;
    
    public folder_xml(
        Arq arquivo,
        Font font[],
        String[] str,
        boolean[] bool
    ){
        
        try{
            
            this.save = arquivo;
            
            this.font_title = font[0];
            this.font_list = font[1];
            
            this.title = str[0];
            this.header = str[1];
            this.input = str[2];
            
            this.list_colum = bool[0];
            this.selection_multiple = bool[1];
            
        }catch(NullPointerException err){//throw

            Action.Err("NullPointerException", err.getMessage());
            
        }catch(Exception err){//throw

            Action.Err("Exception", err.getMessage());
            
        }//throw
        
    }//folder_xml
    
    public xml_config Tema(){
        
        return new xml_config(this.save.Read());
        
    }//Tema()
    
    private List<Domain> DomainList(){
        
        var tema = this.Tema().learn();
        
        List<Domain> demo = new ArrayList();
        
        var insert = 0;
        
        if(tema.isEmpty()){
            
            demo.add(new Domain(insert,"Lisa Vazia!"));
            
        } else {//if(this.tema.learn().isEmpty())
            
            for(xml_config_one x : tema){
                
                insert++;
                
                demo.add(
                    new Domain(
                        insert,txt.title(x.Title(), true)
                    )
                );
                
            }//for(xml_config_one x : this.tema.learn())
            
        }//if(this.tema.learn().isEmpty())
        
        return demo;
        
    }//DomainList()
    
    public List<String> Text(){
        
        return this.text;
        
    }//Text()
    
    public boolean[] MyOption(){
        
        boolean[] value = {
            this.list_colum,
            this.selection_multiple
        };
        
        return value;
        
    }//MyOption()
    
    public String[] Mytext(){
        
        String[] value = {
            this.title,
            this.header,
            this.input
        };
        
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
    
    //Continue this

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
        return this.list_colum;
    }

    @Override
    public boolean SelectionMultiple() {
        return this.selection_multiple;
    }

    @Override
    public void Action(pag1 action, List<Domain> vol, String input) {
        
        //throw new UnsupportedOperationException(this.temp);
        
    }

    @Override
    public void Command(pag2 op, List<Domain> value) {
        
        //throw new UnsupportedOperationException(this.temp);
        
    }
    
}//folder_xml