/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import form.Painel_1;
import model.Reg;
import model.Link;
import model.txt;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class Clean_Painel_1 implements Painel_1{
    
    private java.awt.Font font_null;
    private String node;
    
    public Clean_Painel_1(){
        
        this.font_null = new java.awt.Font("Times New Roman",1,72);
        this.node = "";
        
    }//Clean_Painel_1()
    
    public Clean_Painel_1(String font){
        
        this.font_null = new java.awt.Font(font,1,32);
        this.node = font;
        
    }//Clean_Painel_1(String font)
    
    public Clean_Painel_1(java.awt.Font font){
        
        this.font_null = font;
        this.node = font.getFontName();
        
    }//Clean_Painel_1(java.awt.Font font)
    
    public void Exit(String input){
        
        if(!input.trim().isBlank() && Reg.java){
            
            if(txt.text(input, true).equalsIgnoreCase(input)){
                
                System.out.println(input);
                
            } else {//if(txt.text(input, true).equalsIgnoreCase(input))
                
                System.out.println("\"" + input + "\"");
                System.out.println(txt.text(input, true));
                
            }//if(txt.text(input, true).equalsIgnoreCase(input))
            
        }//if(!input.trim().isBlank() && Reg.java)
        
        System.exit(0);
        
    }//Exit(String input)
        

    @Override
    public String Title(boolean title) {
        
        return new Link(Reg.http).page(!title);
        
    }

    @Override
    public String InputText(boolean user) {
        return Reg.http;
    }

    @Override
    public java.util.List<String> List() {
        
        var event = this.font_null.getSize() <= 28;
        
        List<String> d = new ArrayList();
        
        d.add(event ? this.node : "");
        
        if(!this.node.isBlank() && event){
            
            d.add("\"" + Reg.Numb(this.font_null.getStyle(), 100000) + "\"");
            
            d.add("\"" + Reg.Numb(this.font_null.getSize(), 100000) + "\"");
            
        }//if(!this.node.isBlank() && event)
        
        return d;
        
    }

    @Override
    public Font ListFont() {
        return this.font_null;
    }

    @Override
    public boolean ListColumn() {
        return false;
    }

    @Override
    public Painel_1 Adicionar(boolean button, String input) {
        this.Exit(input);
        return this;
    }

    @Override
    public Painel_1 Abrir(boolean button, int index, String name, String input) {
        this.Exit(input);
        return this;
    }

    @Override
    public Painel_1 Apagar(boolean button, int index, String name, String input) {
        this.Exit(input);
        return this;
    }
    
}