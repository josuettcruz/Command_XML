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
public class Clean implements Painel_1Single{

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
    public Painel_1Single Adicionar(boolean button, String input) {
        System.exit(0);
        return this;
    }

    @Override
    public Painel_1Single Abrir(boolean button, int index, String name, String input) {
        System.exit(0);
        return this;
    }

    @Override
    public Painel_1Single Apagar(boolean button, int index, String name, String input) {
        System.exit(0);
        return this;
    }
    
}
