/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import model.Reg;
import model.Link;

/**
 *
 * @author josue
 */
public class Clean implements Painel_1, Painel_2 {

    @Override
    public String Title(boolean title) {
        return new Link(Reg.http).page(!title);
    }

    @Override
    public String InputText(boolean user) {
        return "";
    }

    @Override
    public java.util.List<String> List() {
        List<String> rm = new ArrayList();
        rm.add("");
        return rm;
    }

    @Override
    public Font ListFont() {
        return new java.awt.Font("Times New Roman",0,72);
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

    @Override
    public String Input() {
        return "";
    }

    @Override
    public java.util.List<Domain> TableModel() {
        
        List<Domain> tema = new ArrayList();
        
        for(int i = 1; i <= 5; i++) tema.add(new Domain(i,"Linha " + i));
        
        return tema;
        
    }

    @Override
    public String TableTitle() {
        return "void";
    }

    @Override
    public String ButtonText() {
        return "null";
    }

    @Override
    public Painel_2 Action(form.Action act, java.util.List<Domain> tema, String input) {
        System.exit(0);
        return this;
    }
    
}
