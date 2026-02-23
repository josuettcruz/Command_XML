/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import form.*;
import model.*;

import form.pag1;
import static form.pag1.*;

import java.awt.Font;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author joaot
 */
public class commit implements Painel_1Single, Painel_1Multiple{
    
    private List<String> text;
    private String input;
    
    public commit(String text){
        
        this.text = new ArrayList();
        this.text.addAll(Arrays.asList(txt.text(text, true).split("\n")));
        
    }
    
    private commit(List<String> text, String input){
        
        this.input = input;
        this.text = text;
        
    }
    
    private void Event(String ext){
        /* 18:10 23/02/2026 ** Pendente */
    }
    
    private void Click(String run){
        
        if(txt.Local(run).equals(run)){
            
            this.Event(run);
            
        } else {//if(txt.Local(run).equals(run))
            
            controller.p1s(new commit(this.text, txt.Local(run)));
            
        }//if(txt.Local(run).equals(run))
        
    }//Click(String run)
    
    private void Submit(pag1 action, String value){
        
        switch(action){
            
            case remove, delet, backspace -> System.exit(0);
            
            default -> this.Click(value);
            
        }
        
    }

    @Override
    public String Title(boolean title) {
        return new Link(Reg.http).page(!title);
    }

    @Override
    public String InputText() {
        return this.input;
    }

    @Override
    public java.util.List<String> List() {
        
        List<String> tema = new ArrayList();
        
        for(String values : this.text){
            
            var t = txt.arq(values);
            
            if(t.length() > 100){
                
                tema.add(t.substring(0, 97) + "...");
                
            } else {//if(t.length() > 100)
                
                tema.add(t);
                
            }//if(t.length() > 100)
            
        }//for(String t : this.text)
        
        return tema;
        
    }

    @Override
    public java.util.List<Domain> ListMode() {
        
        List<Domain> d = new ArrayList();
        
        for(int add = 0; add < this.text.size(); add++){
            
            var insert = txt.arq(this.text.get(add));
            String value;
            
            if(insert.length() > 100){
                
                value = insert.substring(0, 97);
                value += "...";
                
            } else {//if(insert.length() > 100)
                
                value = insert;
                
            }//if(insert.length() > 100)
            
            d.add(new Domain(add+1, value));
            
        }//for(int add = 0; add < this.text.size(); add++)
        
        return d;
        
    }

    @Override
    public Font ListFont() {
        
        int max = 0;
        
        for(String t : this.text) if(t.length() > max) max = t.length();
        
        if(max < 10){
            
            return new java.awt.Font("Aptos Black",0,22);
            
        } else if(max < 20){
            
            return new java.awt.Font("Arial Black",0,22);
            
        } else if(max < 30){
            
            return new java.awt.Font("Arial",0,22);
            
        } else if(max < 40){
            
            return new java.awt.Font("Arial",0,18);
            
        } else if(max < 50){
            
            return new java.awt.Font("Times New Roman",1,18);
            
        } else if(max < 60){
            
            return new java.awt.Font("Times New Roman",0,18);
            
        } else if(max < 70){
            
            return new java.awt.Font("Times New Roman",0,16);
            
        } else if(max < 80){
            
            return new java.awt.Font("Times New Roman",0,14);
            
        } else if(max < 90){
            
            return new java.awt.Font("Times New Roman",0,12);
            
        } else {
            
            return new java.awt.Font("Times New Roman",0,10);
            
        }
        
    }

    @Override
    public boolean ListColumn() {
        return false;
    }

    @Override
    public void Button(pag1 action, int index, java.util.List<String> vol, String input) {
        this.Submit(action, input);
    }

    @Override
    public void Action(pag1 action, java.util.List<Domain> vol, String input) {
        this.Submit(action, input);
    }
    
}
