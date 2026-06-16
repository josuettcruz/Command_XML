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
    
    private xml_config tema;
    private List<String> text;
    
    private Font font_title;
    private Font font_list;
    
    private String title;
    private String header;
    private String input;
    
    private boolean list_colum;
    private boolean selection_multiple;
    
    public void Init(Arq r){
        
        this.title = new Data().DataAbreviada(true);
        this.header = new Data().DataCompleta(true);
        this.input = "";
        
        this.list_colum = true;
        this.selection_multiple = false;
        
        this.tema = new xml_config(r.Read());
        
        this.text = new ArrayList();
        
        for(int i = 0; i < 100; i++){
            
            this.text.add(Reg.Numb(i+1, 100));
            
        }//for(int i = 0; i < dom.length; i++)
        
    }//Init(Arq r)
    
    public folder_xml(Arq arquivo_xml){
        
        this.Init(arquivo_xml);
        
    }//folder_xml
    
    public folder_xml(Arq arquivo_xml, Font FontFamily){
        
        this.Init(arquivo_xml);
        
        this.font_title = FontFamily;
        this.font_list = FontFamily;
        
    }//folder_xml
    
    public folder_xml(Arq arquivo_xml, Font FontTitle, Font FontList){
        
        this.Init(arquivo_xml);
        
        this.font_title = FontTitle;
        this.font_list = FontList;
        
    }//folder_xml
    
    public folder_xml(
        Arq arquivo_xml,
        Font FontTitle,
        Font FontList,
        String title
    )
    {
        
        this.Init(arquivo_xml);
        
        this.font_title = FontTitle;
        this.font_list = FontList;
        
        this.title = title;
        
    }//folder_xml
    
    public folder_xml(
        Arq arquivo_xml,
        Font FontTitle,
        Font FontList,
        String title,
        String header
    )
    {
        
        this.Init(arquivo_xml);
        
        this.font_title = FontTitle;
        this.font_list = FontList;
        
        this.title = title;
        this.header = header;
        
    }//folder_xml
    
    public folder_xml(
        Arq arquivo_xml,
        Font FontTitle,
        Font FontList,
        String title,
        String header,
        String input
    )
    {
        
        this.Init(arquivo_xml);
        
        this.font_title = FontTitle;
        this.font_list = FontList;
        
        this.title = title;
        this.header = header;
        this.input = input;
        
    }//folder_xml
    
    public folder_xml(
        Arq arquivo_xml,
        Font FontTitle,
        Font FontList,
        String title,
        String header,
        String input,
        boolean list_colum,
        boolean selection_multiple
    )
    {
        
        this.Init(arquivo_xml);
        
        this.font_title = FontTitle;
        this.font_list = FontList;
        
        this.title = title;
        this.header = header;
        this.input = input;
        
        this.list_colum = list_colum;
        this.selection_multiple = selection_multiple;
        
    }//folder_xml
    
    public folder_xml(
        Arq arquivo_xml,
        Font FontTitle,
        Font FontList,
        String[] str,
        boolean[] bool
    ){
        
        try{
            
            this.Init(arquivo_xml);
            
            this.font_title = FontTitle;
            this.font_list = FontList;
            
            if(str.length > 0) this.title = str[0];
            if(str.length > 1) this.header = str[1];
            if(str.length > 2) this.input = str[2];
            
            if(bool.length > 0) this.list_colum = bool[0];
            if(bool.length > 1) this.selection_multiple = bool[1];
            
        }catch(Exception err){//throw
            
            System.exit(0);
            
        }//throw
        
    }////folder_xml
    
    private List<Domain> DomainList(){
        
        List<Domain> demo = new ArrayList();
        
        //16/06/2026
        //Instrução temporária!
        for(int pos = 0; pos < 100; pos++)
        {demo.add(new Domain(pos,Reg.Numb(pos+1, 10)));}
        
        return demo;
        
    }//DomainList()
    
    public List<String> Text(){
        
        return this.text;
        
    }//Text()
    
    public xml_config Tema(){
        
        return this.tema;
        
    }//Tema()
    
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