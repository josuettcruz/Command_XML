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
    
    private final char[] points = {
        '?',
        '!',
        ':',
        ';',
        ',',
        '.',
        ')',
        ']',
        '}',
        '/',
        '"',
        '\''
    };
    
    public commit(String text){
        
        this.input = "";
        
        this.text = new ArrayList();
        this.text.addAll(Arrays.asList(txt.text(text, true).split("\n")));
        
    }//commit(String text)
    
    private commit(List<String> receive, String input){
        
        this.input = input;
        this.text = receive;
        
    }//commit(List<String> receive, String input)
    
    private String Commit(){
        
        Hora h = new Hora(true);
        
        final var cond1 = h.Compare(new Hora(5,30));
        final var cond2 = !h.Compare(new Hora(22,30));
        final var cond = cond1 && cond2;
        
        var val = "git commit -m \"";
        val += new Data().DataAbreviada(cond);
        
        if(cond){
            
            val += " -- ";
            
            if(h.Compare(new Hora(19,1))){
                
                val += h.TimerGood(false);
                
            } else if(h.Compare(new Hora(12,30))){//if(h.Compare(new Hora(...
                
                val += h.Timer();
                
            } else {//if(h.Compare(new Hora(19,1)))
                
                val += h.TimerGood(true);
                
            }//if(h.Compare(new Hora(19,1,30)))
            
        }//if(cond)
        
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
                        
                        point = false;
                        
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
                        point = t.length() > 1;
                        
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
                    
                    point = y.length() > 1;
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

            //if(point) val += "!";

            if(quot_end_line) val += "\"";
            
        }//for(String demo : this.text)
        
        return val;
        
    }//Saving()
    
    private String Export(String ext){
            
        Hora h = new Hora(true);
        
        var run = txt.Local(ext);
        
        var arqv = Reg.java ? "..\\" : "";
        arqv += "jar - ";
        arqv += new Data().Load();
        arqv += " - ";
        arqv += Reg.Numb(h.Hour());
        arqv += "h";
        arqv += Reg.Numb(h.Min());
        arqv += "m - ";
        arqv += run;
        arqv += ".txt";
        
        if(Arq.Exist(arqv) && Arq.Dir(arqv, false)){
            
            var arqa = Reg.java ? "..\\" : "";
            arqa += "jar - ";
            arqa += new Data().Load();
            arqa += " - ";
            arqa += Reg.Numb(h.Hour());
            arqa += "h";
            arqa += Reg.Numb(h.Min());
            arqa += "m";
            arqa += Reg.Numb(h.Sec());
            arqa += "s - ";
            arqa += run;
            arqa += ".txt";
            
            return arqa;
            
        } else {//if(Arq.Exist(arqv) && Arq.Dir(arqv, false))
            
            return arqv;
            
        }//if(Arq.Exist(arqv) && Arq.Dir(arqv, false))
        
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
    
    private String Tem(String txt){
        
        var val = "";
        
        var bar = 0;
        
        for(int i = 0; i < txt.length(); i++){
            
            switch(txt.charAt(i)){
                
                case '/', '\\' ->{
                    
                    if(bar < 2) val += "/";
                    
                    bar++;
                    
                }//case '/', '\\'
                
                default ->{
                    
                    val += txt.charAt(i);
                    bar = 0;
                    
                }//default
                
            }//switch(txt.charAt(i))
            
        }//for(int i = 0; i < txt.length(); i++)
        
        return val;
        
    }//Tem(String text)
    
    private void Event(String ext, boolean act){
        
        List<String> tem = new ArrayList();
        tem.addAll(this.text);
        
        this.text.clear();
        
        var point = true;
        
        for(String x : tem){
            
            var t = "";
            
            for(String tema : txt.phrase(x, true)){
                
                var y = Tem(tema);
                
                if(this.line(y)){
                    
                    if(!t.isBlank()) this.text.add(t);
                    
                    t = "";
                    
                } else {//if(this.line(y))
                    
                    var velod = true;
                    
                    if(!tema.isBlank())
                    {velod = tema.charAt(0) != '"' && tema.charAt(0) != '\'';}
                    
                    if(t.isBlank()){
                        
                        t += point && velod ? txt.capitalize(y) : y;
                        
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
                        
                        case ';', '"', '\'' ->{
                            
                            point = false;
                            if(!t.isBlank()) this.text.add(t);
                            t = "";
                            
                        }//case ';', '"', '\''
                        
                        default -> point = true;
                        
                    }//switch(t.charAt(t.length()-1))
                    
                }//if(t.length() > 1)
                
            }//for(String t : txt.phrase(tema, true))
            
            //if(points) t += "!";
            
            if(!t.isBlank()) this.text.add(t);
            
        }//for(String t : tem)
        
        if(act){
            
            var test1 = ext.equalsIgnoreCase(this.base);
            var test2 = Arq.Exist(this.Export(ext));
            var test3 = Arq.Dir(this.Export(ext), true);
            var test0 = test1 && test2 && test3;
            
            var err = "";
            var coppy = !ext.equalsIgnoreCase("exit");
            
            if(test0 || !ext.equalsIgnoreCase(this.base)){
                
                if(!ext.equalsIgnoreCase("exit"))
                {err = new Arq(this.Export(ext)).Save(this.Saving()).Message();}
                
                coppy = false;
                
            }//if(test0 || !ext.equalsIgnoreCase(this.base))
            
            if(err.isBlank()){
                
                var acept = false;
                
                if(coppy) acept = Reg.coppy(this.Commit());
                
                String[] col = coppy
                    ? this.Commit().split("--")
                    : this.Saving().split("\n");
                
                if(Reg.java && acept){
                    
                    final int max = 120;
                    
                    for(String t : col){
                        
                        final char[] dem = {'"', '>'};
                        
                        var p = txt.text(t, dem);
                        
                        if(p.length() > 2 && p.length() < max){
                            
                            System.out.println(p);
                            
                        } else {//if(p.length() > 2 && p.length() < max)
                            
                            System.out.println(p.substring(0,max-3) + "...");
                            
                        }//if(p.length() > 2 && p.length() < max)
                        
                    }//for(String t : col)
                    
                }//if(Reg.java && acept)
                
                System.exit(0);
                
            } else {//if(coppy.isBlank())
                
                List<String> value = new ArrayList();
                value.addAll(Arrays.asList(err.split("\n")));
                controller.Msg(ext, value, true);
                
            }//if(coppy.isBlank())
            
        }//if(act)
        
    }//Event(String ext)
    
    private void Click(String run){
        
        if(run.trim().isBlank()){
            
            controller.p1s(new commit(this.text, this.base));
            
        } else if(txt.Local(run).equals(run)){//if(run.trim().isBlank())
            
            this.Event(run, true);
            
        } else {//if(run.trim().isBlank())
            
            controller.p1m(new commit(this.text, txt.Local(run)));
            
        }//if(run.trim().isBlank())
        
    }//Click(String run)
    
    private void Submit(pag1 action, String value){
        
        switch(action){
            
            case key, open, add -> this.Click(value);
            
            case remove, delet, backspace -> {
                
                if(Reg.java){
                    
                    final int max = 100;
                    
                    boolean e = false;
                    boolean event = false;
                    
                    this.Event("run", false);
                    
                    final int tot = this.Saving().split("\n").length;
                    int line = 1;
                    
                    int par = 0;
                    
                    for(String tema : this.Saving().split("\n")){
                        
                        var t = tema.length();
                        
                        if(t > par && t < max) par = t;
                        
                    }//for(String t : this.Saving().split("\n")) - 1 - 2
                    
                    par++;
                    
                    for(String t : this.Saving().split("\n")){
                        
                        if(t.length() > max){
                            
                            if(e) System.out.println();
                            
                            System.out.println(
                                "\f Linha "
                                + Reg.Numb(line, tot, " de ")
                            );
                            
                            System.out.println(
                                "\f "
                                + t.substring(0, max)
                                + " \f"
                            );
                            
                            System.out.println(
                                "\f "
                                + t.substring(max)
                            );
                            
                            event = true;
                            
                        } else {//if(t.length() > max)
                            
                            var view = "\"Linha: ";
                            view += Reg.Numb(line, tot, " de ");
                            view += "\"";
                            
                            if(event){
                                
                                System.out.println();
                                event = false;
                                
                            }//if(evt)
                            
                            Reg.Print(t, view, par);
                            
                        }//if(t.length() > max)
                        
                        e = true;
                        
                        line++;
                        
                    }//for(String t : this.Saving().split("\n")) - 2 - 2
                    
                }//if(Reg.java)
                
                System.exit(0);
                
            }
            
        }//switch(action)
        
    }//Submit(pag1 action, String value)

    @Override
    public String Title(boolean title)
    {return new Link(Reg.http).page(!title);}

    @Override
    public String InputText()
    {return this.input;}

    @Override
    public java.util.List<Domain> ListMode() {
        
        this.Event("", false);
        
        List<String> receive = new ArrayList();
        receive.addAll(Arrays.asList(this.Saving().split("\n")));
        
        List<Domain> d = new ArrayList();
        
        for(int add = 0; add < receive.size(); add++){
            
            var value = "";
            
            if(this.input.isBlank()){
                
                value += "Linha: ";
                value += Reg.Numb(add+1, receive.size(), " de ");
                value += ": ";
                
            }//if(this.input.isBlank())
            
            value += txt.text(receive.get(add));
            
            d.add(new Domain(add+1, value));
            
        }//for(int add = 0; add < this.text.size(); add++)
        
        return d;
        
    }

    @Override
    public Font ListFont() {
        
        int max = 0;
        
        for(String t : this.text) if(t.length() > max) max = t.length();
        
        if(!this.input.isBlank() && max < 20){
            
            return new java.awt.Font("Times New Roman",0,18);
            
        } else if(!this.input.isBlank() && max < 30){
            
            return new java.awt.Font("Times New Roman",0,16);
            
        } else if(!this.input.isBlank() && max < 40){
            
            return new java.awt.Font("Times New Roman",0,14);
            
        } else if(!this.input.isBlank()){
            
            return new java.awt.Font("Times New Roman",0,12);
            
        } else if(max < 10){
            
            return new java.awt.Font("Aptos Black",0,22);
            
        } else if(max < 20){
            
            return new java.awt.Font("Arial Black",0,22);
            
        } else if(max < 30){
            
            return new java.awt.Font("Arial",0,20);
            
        } else if(max < 40){
            
            return new java.awt.Font("Arial",0,18);
            
        } else if(max < 90){
            
            return new java.awt.Font("Arial",0,16);
            
        } else {
            
            return new java.awt.Font("Times New Roman",0,16);
            
        }
        
    }

    @Override
    public boolean ListColumn()
    {return !this.input.isBlank();}

    @Override
    public void Action(pag1 action, java.util.List<Domain> vol, String input)
    {this.Submit(action, input);}
    
}//commit