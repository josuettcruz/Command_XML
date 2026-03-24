/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import java.util.List;
import java.util.ArrayList;
import java.awt.Font;

import model.Reg;
import form.*;

import form.pag1;
import static form.pag1.*;

import form.pag2;
import static form.pag2.*;

import form.pag3;
import static form.pag3.*;

/**
 *
 * @author josue
 */
public class folder_xml implements
        Painel_1Single,
        Painel_1Multiple,
        Painel_2,
        Painel_3
    {
    
    private List<Domain> tema;
    
    public folder_xml(){
        
        var max = 10;
        
        this.tema = new ArrayList();
        
        for(int a = 1; a <= max; a++){
            
            var par = "Item ";
            par += Reg.Numb(a+1, max, " de ");
            par += "!";
            
            this.tema.add(new Domain(a+1, par));
            
        }//for(int a = 1; a <= max; a++)
        
    }//folder_xml()

    @Override
    public Font ListFont() {
        return new java.awt.Font("Times New Roman",0,18);
    }

    @Override
    public Font FontTitle() {
        return new java.awt.Font("Times New Roman",0,18);
    }

    @Override
    public Font TextAreaFont() {
        return new java.awt.Font("Times New Roman",0,18);
    }

    @Override
    public String Title(boolean title) {
        return "Sem Título";
    }

    @Override
    public String InputText() {
        return "";
    }

    @Override
    public boolean ListColumn() {
        return false;
    }

    @Override
    public List<Domain> ListMode() {
        
        return this.tema;
        
    }

    @Override
    public List<String> TextArea() {
        
        List<String> tem = new ArrayList();
        
        for(Domain d : this.tema) tem.add(d.Text(false));
        
        return tem;
        
    }

    @Override
    public Domain[] Mode() {
        
        Domain[] tem = new Domain[10];
        
        for(int a = 0; a < tem.length; a++){
            
            var par = "Item ";
            par += Reg.Numb(a+1,tem.length," de ");
            par += "!";
            
            tem[a] = new Domain(a+1,par);
            
        }//for(int a = 0; a < tem.length; a++)
        
        return tem;
        
    }

    @Override
    public void Action(pag1 action, List<Domain> vol, String input) {
        controller.p1m(new folder_xml());
    }

    @Override
    public boolean SelectionMultiple() {return false;}

    @Override
    public void Command(pag2 op, List<Domain> value) {
        controller.p2(new folder_xml());
    }

    @Override
    public void Painel3(int key_code, char key_char, Domain[] menu, String input, List<String> text, int row, int col) {
        if(key_code == 10) controller.p3(new folder_xml());
    }

    @Override
    public void Painel3(pag3 op, Domain[] menu, String input, List<String> text, int row, int col) {
        if(op != ComboBox) controller.p3(new folder_xml());
    }

    @Override
    public boolean JComboBox() {return false;}
    
}//folder_xml