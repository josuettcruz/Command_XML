/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import form.*;
import model.*;
import file.Arq;

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
        
    }//commit(String text)
    
    private commit(List<String> text, String input){
        
        this.input = input;
        this.text = text;
        
    }//commit(List<String> text, String input)
    
    private String Commit(){
        
        Hora h = new Hora(true);
        
        var val = "git commit -m \"";
        val += new Data().DataAbreviada(!h.Compare(new Hora(20,30)));
        
        val += h.Compare(new Hora(6,30)) ? " - " : " -- ";
        
        if(h.Compare(new Hora(20,30))){
            
            val += h.TimerGood(true);
            
        } else if(h.Compare(new Hora(19,30))){//h.Compare
            
            val += h.TimerGood(false);
            
        } else if(h.Compare(new Hora(6,30))){//h.Compare
            
            val += h.Timer();
            
        } else {//h.Compare
            
            val += h.TimerGood(false, " - ");
            
        }//h.Compare
        
        val += " -- Nesse COMMIT -> ";
        
        if(this.text.size() == 1){
            
            val += this.text.get(0);
            
        } else {//if(this.text.size() == 1)
            
            for(int d = 0; d < this.text.size(); d++){
                
                var quot_end_line = false;
                
                val += " -- ";
                val += Reg.Numb(d+1, this.text.size(), "-");
                val += " --> ";
                
                var space = false;
                
                for(String t : txt.phrase(this.text.get(d), space)){
                    
                    if(space){
                        
                        val += " ";
                        
                    } else {//if(space)
                        
                        space = true;
                        
                    }//if(space)
                    
                    var quot = false;
                    var g = 0;
                    
                    do{
                        
                        quot = t.charAt(g) == '"' || t.charAt(g) == '\'';
                        g++;
                        
                    }while(!quot && g > 0 && g < t.length());
                    
                    if(quot && t.length() > 1){
                        
                        if(quot_end_line){
                            
                            val += "'";
                            
                            quot_end_line = false;
                            
                        }//if(quot_end_line)
                        
                        g = 0;
                        
                        while(g < t.length()){
                            
                            switch(t.charAt(g)){
                                
                                case '\'', '"' ->{}
                                
                                default -> val += t.charAt(g);
                                
                            }//switch(t.charAt(g))
                            
                            g++; //!important
                            
                        }//while(g < t.length())
                        
                        if(!quot_end_line){//if(quot && t.length() > 1)
                            
                            val += "'";
                            
                            quot_end_line = true;
                            
                        }//if(!quot_end_line)
                        
                    } else if(t.equals("\"") || t.equals("'")){//if(quot &&...
                        
                        val += "\"null\"";
                        
                    } else {//if(quot && t.length() > 1)
                        
                        val += t;
                        
                    }//if(quot && t.length() > 1)
                    
                }//for(String t : txt.phrase(this.text.get(d), space))
                
                if(quot_end_line) val += "'";
                
            }//for(int d = 0; d < this.text.size(); d++)
            
        }//if(this.text.size() == 1)
        
        return val;
        
    }//Commit(String text)
    
    private String Export(String ext){
        
        Hora h = new Hora(true);
        
        var arqv = Reg.java ? "..\\" : "";
        
        arqv += ext;
        
        if(!ext.equals("info")){
            
            arqv += " - ";
            arqv += new Data().Load();
            arqv += " - ";
            arqv += Reg.Numb(h.Hour());
            arqv += "h";
            arqv += Reg.Numb(h.Min());
            arqv += "m";
            
            if(h.Sec() > 5){
                
                arqv += Reg.Numb(h.Sec());
                arqv += "s";
                
            }//if(h.Sec() > 5)
            
        }//if(!ext.equals("info"))
        

        
        arqv += ".txt";
        
        Arq fill = new Arq(arqv);
        
        return arqv;
        
    }//Export(String ext)
    
    private void Event(String ext){
        
        List<String> tem = new ArrayList();
        tem.addAll(this.text);
        
        this.text.clear();
        
        for(String t : tem){
            
            //code
            
        }//for(String t : tem)
        
        Arq save = new Arq(this.Export(ext));
        
        if(save.create()) save.Save(this.text);
        
        Reg.coppy(this.Commit());
        System.exit(0);
        
    }//Event(String ext)
    
    private void Click(String run){
        
        if(txt.Local(run).equals(run)){
            
            this.Event(run);
            
        } else if(run.trim().isBlank()){//if(txt.Local(run).equals(run))
            
            controller.p1s(new commit(this.text, "info"));
            
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
