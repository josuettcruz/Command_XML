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
 * @author josue
 */
public class commit implements Painel_1Single, Painel_1Multiple{
    
    private final String base = "info";
    
    private List<String> text;
    private String input;
    
    private final char[] points = {'?','!',':',';',',','.', ')', ']', '}'};
    
    public commit(String text){
        
        this.input = "";
        
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
        
        val += h.Compare(new Hora(7,30)) ? " - " : " -- ";
        
        if(h.Compare(new Hora(20,30))){
            
            val += h.TimerGood(true);
            
        } else if(h.Compare(new Hora(18,59))){//h.Compare
            
            val += h.TimerGood(false);
            
        } else if(h.Compare(new Hora(7,30))){//h.Compare
            
            val += h.Timer();
            
        } else {//h.Compare
            
            val += h.TimerGood(false, " - ");
            
        }//h.Compare
        
        val += " -- Nesse COMMIT";
        
        if(this.text.size() == 1){
            
            val += " --> ";
            val += this.text.get(0);
            
        } else {//if(this.text.size() == 1)
            
            var point = false;
            
            for(int d = 0; d < this.text.size(); d++){
                
                var quot_end_line = false;
                
                val += d == 0 ? " --> " : " -- ";
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
                        
                        point = true;
                        
                        quot_end_line = !quot_end_line;
                        
                        if(quot_end_line) val += "'";
                        
                        g = 0;
                        
                        while(g < t.length()){
                            
                            switch(t.charAt(g)){
                                
                                case '\'', '"' ->{}
                                
                                default -> val += t.charAt(g);
                                
                            }//switch(t.charAt(g))
                            
                            g++; //!important
                            
                        }//while(g < t.length())
                        
                        if(!quot_end_line) val += "'";
                        
                    } else if(t.equals("\"") || t.equals("'")){//if(quot &&...
                        
                        space = false;
                        
                    } else {//if(quot && t.length() > 1)
                        
                        val += t;
                        point = true;
                        
                    }//if(quot && t.length() > 1)
                    
                }//for(String t : txt.phrase(this.text.get(d), space))
                
                if(point && this.text.get(d).length() > 1){
                    
                    var view = 0;
                    
                    do{
                        
                        var y = this.text.get(d);
                        
                        point = y.charAt(y.length()-1) != this.points[view];
                        
                        view++;
                        
                    }while(point && view > 0 && view < this.points.length);
                    
                }//if(point)
                
                if(point) point = this.text.get(d).length() > 1;
                
                if(point) val += ".";
                
                if(quot_end_line) val += "'";
                
            }//for(int d = 0; d < this.text.size(); d++)
            
        }//if(this.text.size() == 1)
        
        val += "\"";
        
        return val;
        
    }//Commit(String text)
    
    private String Saving(){
        
        var val = "";
        var line = false;
        var point = true;
        
        for(String x : this.text){
            
            if(line){
                
                val += "\n";
                
            } else {//if(line)
                
                line = true;
                
            }//if(line)
            
            var quot_end_line = false;
            
            var space = false;
            
            for(String y : txt.phrase(x, true)){
                
                if(space){
                    
                    val += " ";
                    
                } else {//if(space)
                    
                    space = true;
                    
                }//if(space)
                
                var quot = false;
                var proc = 0;
                
                do{
                    
                    var charAt = y.charAt(proc);
                    
                    var tema_1 = charAt == '"';
                    var tema_2 = charAt == '\'';
                    quot = tema_1 || tema_2;
                    
                    proc++;
                    
                }while(!quot && proc > 0 && proc < y.length());
                
                if(quot && y.length() > 1){
                    
                    point = false;
                    
                    quot_end_line = !quot_end_line;
                    
                    if(quot_end_line) val += "\"";
                    
                    for(int add = 0; add < y.length(); add++){
                        
                        var tema_1 = y.charAt(add) == '"';
                        var tema_2 = y.charAt(add) == '\'';
                        var tema_0 = tema_1 || tema_2;
                        
                        if(!tema_0) val += y.charAt(add);
                        
                    }//for(int add = 0; add < y.length(); add++)
                    
                    if(!quot_end_line) val += "\"";
                    
                } else if(y.equals("\"") || y.equals("'")){
                    
                    space = false;
                    
                } else {
                    
                    point = true;
                    val += y;
                    
                }
                
            }//for(String y : txt.phrase(x, true))
                
            if(point && x.length() > 1){

                var view = 0;

                do{

                    point = x.charAt(x.length()-1) != this.points[view];

                    view++;

                }while(point && view > 0 && view < this.points.length);

            }//if(point && y.length() > 1)

            if(point) point = x.length() > 1;

            if(point) val += "!";

            if(quot_end_line) val += "\"";
            
        }//for(String demo : this.text)
        
        return val;
        
    }//Saving()
    
    private String Export(String ext){
            
        Hora h = new Hora(true);
        
        var run = txt.arq(ext.toLowerCase());
        
        var arqv = Reg.java ? "..\\" : "";

        arqv += new Data().Load();
        arqv += "_";
        arqv += Reg.Numb(h.Hour());
        arqv += "-";
        arqv += Reg.Numb(h.Min());
        arqv += "-";
        arqv += Reg.Numb(h.Sec());
        arqv += "_";
        arqv += run;
        arqv += ".txt";
        
        return arqv;
        
    }//Export(String ext)
    
    private boolean line(String phrase){
        
        var ok = false;
        var invalid = false;
        var novalid = 0;
        
        var letter = false;
        
        for(int x = 0; x < phrase.length(); x++){
            
            switch(phrase.charAt(x)){
                
                case '1',
                     '2',
                     '3',
                     '4',
                     '5',
                     '6',
                     '7',
                     '8',
                     '9',
                     '0' -> {letter = true;}
                     
                case '-' -> {if(letter) ok = true; novalid++;}
                
                default -> {invalid = true;}
                
            }//switch(phease.charAt(x))
            
        }//for(int x = 0; x < phease.length(); x++)
        
        if(invalid) ok = false;
        
        var cod1 = phrase.equals("--");
        var cod2 = phrase.equals("-->");
        var cod3 = phrase.equals("->");
        var cod = cod1 || cod2 || cod3;
        
        var valid = ok && novalid == 1;
        
        return cod ? true : valid;
        
    }//line(String phrase)
    
    private void Event(String ext){
        
        List<String> tem = new ArrayList();
        tem.addAll(this.text);
        
        this.text.clear();
        
        var point = true;
        
        for(String x : tem){
            
            var t = "";
            
            for(String y : txt.phrase(x, true)){
                
                if(this.line(y)){
                    
                    if(!t.isBlank()) this.text.add(t);
                    
                    t = "";
                    
                } else {//if(this.line(y))
                    
                    if(t.isBlank()){
                        
                        t += point ? txt.capitalize(y) : y;
                        
                    } else {
                        
                        t += " ";
                        t += y;
                        
                    }
                    
                }//if(this.line(y))

                if(y.length() > 1){
                    
                    switch(y.charAt(y.length()-1)){
                        
                        case '!', '?', '.' -> {
                            
                            point = true;
                            if(!t.isBlank()) this.text.add(t);
                            t = "";
                            
                        }//case '!', '?', '.'
                        
                        case ':', ';', ',' ->{
                            
                            point = false;
                            if(!t.isBlank()) this.text.add(t);
                            t = "";
                            
                        }
                        
                        default -> {
                            
                            point = true;
                            //points = true;
                            
                        }
                        
                    }//switch(t.charAt(t.length()-1))
                    
                }//if(t.length() > 1)
                
            }//for(String t : txt.phrase(tema, true))
            
            //if(points) t += "!";
            
            if(!t.isBlank()) this.text.add(t);
            
        }//for(String t : tem)
        
        var test1 = ext.equalsIgnoreCase(this.base);
        var test2 = Arq.Exist(this.Export(ext));
        var test3 = Arq.Dir(this.Export(ext), true);
        var test0 = test1 && test2 && test3;
        
        var coppy = "";
        
        if(test0 || !ext.equalsIgnoreCase(this.base)){
        coppy = new Arq(this.Export(ext)).Save(this.Saving()).Message();
        }
        
        if(coppy.isBlank()){
            
            Reg.coppy(this.Commit());
            System.exit(0);
            
        } else {//if(coppy.isBlank())
            
            List<String> value = new ArrayList();
            value.addAll(Arrays.asList(coppy.split("\n")));
            
            controller.Msg(ext, value, true);
            
        }//if(coppy.isBlank())
        
    }//Event(String ext)
    
    private void Click(String run){
        
        if(run.trim().isBlank()){
            
            controller.p1m(new commit(this.text, this.base));
            
        } else if(txt.Local(run).equals(run)){//if(run.trim().isBlank())
            
            this.Event(run);
            
        } else {//if(run.trim().isBlank())
            
            controller.p1m(new commit(this.text, txt.Local(run)));
            
        }//if(run.trim().isBlank())
        
    }//Click(String run)
    
    private void Submit(pag1 action, String value){
        
        switch(action){
            
            case remove -> System.exit(0);
            
            case open, add, key, enter -> this.Click(value);
            
        }//switch(action)
        
    }//Submit(pag1 action, String value)

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
    
}//commit