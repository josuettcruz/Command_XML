/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import form.Painel_1;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class Clean_Painel_1 implements Painel_1{
    
    private java.awt.Font font_null;
    
    public Clean_Painel_1(){
        
        this.font_null = new java.awt.Font("Times New Roman",1,72);
        
    }//Clean_Painel_1()
        

    @Override
    public String Title(boolean title) {
        
        return "null";
        
    }

    @Override
    public String InputText(boolean user) {
        return "null";
    }

    @Override
    public java.util.List<String> List() {
        
        List<String> d = new ArrayList();
        
        d.add("");
        
        return d;
        
    }

    @Override
    public Font ListFont() {
        return new java.awt.Font("Times New Roman",1,72);
    }

    @Override
    public boolean ListColumn() {
        return false;
    }

    @Override
    public Painel_1 Adicionar(boolean button, String input) {
        System.exit(0);
        return this;
    }

    @Override
    public Painel_1 Abrir(boolean button, int index, String name, String input) {
        System.exit(0);
        return this;
    }

    @Override
    public Painel_1 Apagar(boolean button, int index, String name, String input) {
        System.exit(0);
        return this;
    }
    
}