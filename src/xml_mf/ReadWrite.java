/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import form.*;
import model.*;

import java.awt.Font;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class ReadWrite implements Painel_1Single, Painel_2, Painel_3 {
    
    private Font temp;
    
    private List<String> text;
    private List<Domain> domain;
    private Domain[] dom;
    
    public ReadWrite(){
        
        this.temp = new java.awt.Font("Consolas", 0, 18);
        
        this.text = new ArrayList();
        this.domain = new ArrayList();
        this.dom = new Domain[10];
        
        for(int i = 0; i < dom.length; i++){
            
            var value = Reg.Numb(i+1, dom.length);
            
            Domain d = new Domain(i,value);
            
            this.text.add(value);
            this.domain.add(d);
            this.dom[i] = d;
            
        }//for(int i = 0; i < dom.length; i++)
        
    }//ReadWrite()

    @Override
    public String Title(boolean title) {
        return "No Definition";
    }

    @Override
    public Font FontTitle() {
        return this.temp;
    }

    @Override
    public String InputText() {
        return "";
    }

    @Override
    public Font ListFont() {
        return this.temp;
    }

    @Override
    public boolean ListColumn() {
        return true;
    }

    @Override
    public List<Domain> ListMode() {
        return this.domain;
    }

    @Override
    public boolean SelectionMultiple() {
        return true;
    }

    @Override
    public List<String> TextArea() {
        return this.text;
    }

    @Override
    public Font TextAreaFont() {
        return this.temp;
    }

    @Override
    public boolean JComboBox() {
        return true;
    }

    @Override
    public Domain[] Mode() {
        return this.dom;
    }

    @Override
    public void Action(pag1 action, List<Domain> vol, String input) {
        System.exit(0);
    }

    @Override
    public void Command(pag2 op, List<Domain> value) {
        System.exit(0);
    }

    @Override
    public void Painel3(int key_code, char key_char, Domain[] menu, String input, List<String> text, int row, int col) {
        System.exit(0);
    }

    @Override
    public void Painel3(pag3 op, Domain[] menu, String input, List<String> text, int row, int col) {
        System.exit(0);
    }
    
}
