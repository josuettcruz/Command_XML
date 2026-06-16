/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import file.Arq;

import form.*;
import model.*;
import xml_rw.*;

import java.awt.Font;
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class ReadWrite implements Painel_1Single, Painel_2, Painel_3 {
    
    private Font font;
    
    private xml_document tema;
    private List<String> text;
    
    public void Init(Arq r){
        
        this.tema = new xml_document(r.Read());
        
        this.text = new ArrayList();
        
        for(int i = 0; i < 100; i++){
            
            this.text.add(Reg.Numb(i+1, 100));
            
        }//for(int i = 0; i < dom.length; i++)
        
    }//Init(Arq r)
    
    public ReadWrite(Arq arquivo_xml){
        
        this.font = new java.awt.Font("Consolas", 0, 18);
        
        this.Init(arquivo_xml);
        
    }//ReadWrite(Arq arquivo_xml)
    
    public ReadWrite(Arq arquivo_xml, Font font){
        
        this.font = font;
        
        this.Init(arquivo_xml);
        
    }//ReadWrite(Arq arquivo_xml, Font font)
    
    private Domain[] DomainMode(){
        
        Domain demo[] = new Domain[10];
        
        //16/06/2026
        //Instrução temporária!
        for(int pos = 0; pos < 10; pos++)
        {demo[pos] = new Domain(pos,Reg.Numb(pos+1, 10));}
        
        return demo;
        
    }//DomainMode()
    
    private List<Domain> DomainList(){
        
        List<Domain> demo = new ArrayList();
        
        //16/06/2026
        //Instrução temporária!
        for(int pos = 0; pos < 100; pos++)
        {demo.add(new Domain(pos,Reg.Numb(pos+1, 10)));}
        
        return demo;
        
    }//DomainList()

    @Override
    public String Title(boolean title) {
        return "No Definition";
    }

    @Override
    public Font FontTitle() {
        return this.font;
    }

    @Override
    public String InputText() {
        return "";
    }

    @Override
    public Font ListFont() {
        return this.font;
    }

    @Override
    public boolean ListColumn() {
        return true;
    }

    @Override
    public List<Domain> ListMode() {
        return this.DomainList();
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
        return this.font;
    }

    @Override
    public boolean JComboBox() {
        return true;
    }

    @Override
    public Domain[] Mode() {
        return this.DomainMode();
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
    
}//ReadWrite