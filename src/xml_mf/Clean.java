/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import form.Domain;
import form.Painel_1Single;
import form.Painel_1Multiple;
import form.Painel_2;
import form.pag1;
import form.pag2;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

import model.Reg;
import model.Link;

/**
 *
 * @author josue
 */
public class Clean implements Painel_1Single, Painel_1Multiple, Painel_2{

    @Override
    public String Title(boolean title) {
        return new Link(Reg.http).page(!title);
    }

    @Override
    public String InputText() {
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
    public void Adicionar(boolean button, String input, List<String> lt) {
        System.exit(0);
    }

    @Override
    public void Abrir(
        boolean button,
        int index,
        List<String> lt,
        String input
    )
    {
        
        System.exit(0);
        
    }

    @Override
    public void Apagar(
        boolean button,
        int index,
        List<String> lt,
        String input
    )
    {
        
        System.exit(0);
        
    }

    @Override
    public java.util.List<Domain> ListMode() {
        
        List<Domain> rm = new ArrayList();
        rm.add(new Domain(0,""));
        return rm;
        
    }

    @Override
    public void Action(
        pag1 action,
        java.util.List<Domain> vol,
        String input
    )
    {
        
        System.exit(0);
        
    }

    @Override
    public void Command(pag2 op, Domain value) {
        System.exit(0);
    }
    
}//Clean