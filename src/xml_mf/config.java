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
 * @author joaot
 */
public class config implements Painel_1{
    
    List<String> list;
    
    public config(){
        
        this.list = new ArrayList();
        this.list.add("09/02/2026");
        this.list.add("17:50");
        this.list.add("Nenhum item ainda!");
        
    }//config()

    @Override
    public String Title(boolean title) {
        return "";
    }

    @Override
    public String InputText(boolean user) {
        return "";
    }

    @Override
    public java.util.List<String> List() {
        return this.list;
    }

    @Override
    public Font ListFont() {
        return new java.awt.Font("Impact", 0, 16);
    }

    @Override
    public boolean ListColumn() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Painel_1 Adicionar(boolean button, String input) {
        return this;
    }

    @Override
    public void Abrir(boolean button, int index, String name, String input) {
        //null
    }

    @Override
    public Painel_1 Apagar(boolean button, int index, String name, String input) {
        return this;
    }
    
}
