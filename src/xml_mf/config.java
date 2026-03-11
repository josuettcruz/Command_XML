/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import model.*;
import form.Domain;
import form.Painel_1Single;
import form.Painel_1Multiple;
import form.Painel_2;
import form.Painel_3;
import form.controller;

import form.pag1;
import static form.pag1.*;

import form.pag2;
import static form.pag2.*;

import form.pag3;
import static form.pag3.*;

import java.awt.Font;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author josue
 */
public class config implements
        Painel_1Single,
        Painel_1Multiple,
        Painel_2,
        Painel_3
    {
    
    private final int mode = 15;
    
    private List<String> list;
    private String input;
    private boolean week;
    
    private int key_code_count;
    private int user_area;
    
    public config(){
        
        this.key_code_count = 1;
        this.user_area = 0;
        
        this.input = "";
        
        this.week = true;
        
        this.list = new ArrayList();
        
        this.list.addAll(
            Arrays.asList(
                new Data().DataCompleta("#", "#Ano de ").split("#")
            )
        );
        
    }//config()
    
    private config(List<String> value){
        
        this.key_code_count = 1;
        this.user_area = 0;
        
        var form = "";
        
        this.week = false;
        
        if(value.size() > 1 && value.size() <= this.mode){
            form = this.Submit(value.get(value.size()-1));
        }
        
        this.input = form;
        
        this.list = new ArrayList();
        this.list.addAll(value);
        
    }//config(List<String> value)
    
    private config(List<String> value, String input){
        
        this.key_code_count = 1;
        this.user_area = 0;
        
        this.input = input;
        
        this.week = false;
        
        this.list = new ArrayList();
        this.list.addAll(value);
        
    }//config(List<String> value, String input)
    
    private config(List<String> value, int area){
        
        this.key_code_count = 1;
        this.user_area = area+1;
        
        this.input = "";
        
        this.week = true;
        
        this.list = new ArrayList();
        this.list.addAll(value);
        
    }//config(List<String> value, TextCursor cur)
    
    private void Exit(){
        
        if(this.list.isEmpty()){
            
            System.err.println("Lista vazia!");
            
        } else if(this.list.size() == 1){//if(this.list.isEmpty())
            
            var d = new Data().DataCompleta(true);
            var h = new Hora(true).TimerGood(true, " - ");
            var p = this.list.get(0);
            
            if(p.length() < h.length()+1){
                
                System.out.print(h);
                System.out.print(" -- ");
                System.out.println(d);
                
            } else {//if(p.length() + 2 < h.length())
                
                var max = 0;
                
                for(String t : this.list){
                    
                    if(t.length() > max) max = t.length();
                    
                }//for(String t : this.list)
            
                if(p.length() > 1) if(p.charAt(0) == '"') max--;
            
                if(p.length() > 1) if(p.charAt(p.length()-1) != '"') max++;
                
                Reg.Print(
                    "\"" + new Data().DataAbreviada(true) + "\"",
                    "\"" + new Hora(true).TimerGood(true) + "\"",
                    max
                );
                
            }//if(p.length() + 2 < h.length())
            
            if(p.length() > 1) if(p.charAt(0) != '"') System.out.print("\"");
            
            System.out.print(p);
            
            if(p.length() > 1){
                
                if(p.charAt(p.length()-1) == '"'){
                    
                    System.out.println();
                    
                } else {//if(p.charAt(p.length()-1) == '"')
                    
                    System.out.println("\"");
                    
                }//if(p.charAt(p.length()-1) == '"')
                
            } else {//if(p.length() > 1)
                
                System.err.println("Length 0");
                
            }//if(p.length() > 1)
            
            
        } else {//if(this.list.isEmpty())
            
            int max = 0;
            
            for(String g : this.list){
                
                if(g.length() > max){
                    
                    max = g.length();
                    
                }//if(g.length() > max)
                
            }//for(String g : this.list)
            
            for(int g = 0; g < this.list.size(); g++){
                
                Reg.Print(
                    this.list.get(g),
                    "-- " + Reg.Numb(g+1,this.list.size()," de "),
                    max+1
                );
                
            }//for(int g = 0; g < this.list.size(); g++)
            
        }//if(this.list.isEmpty())
        
        System.exit(0);
        
    }//Exit()
    
    private String Submit(String input){
        
        var val = txt.text(input);
        
        var m = txt.phrase(val, true).size();
        
        if(val.length() > 100 && m == 1){
            
            return Reg.Numb(val.length()) + " letras!";
            
        } else if(val.length() > 100){//if(val.length() > 100 && m == 1)
            
            return Reg.Numb(m, input.length(), " palavras e ") + " letras!";
            
        } else if(m == 1){//if(val.length() > 100 && m == 1)
            
            return val.toUpperCase();
            
        } else if(m < 8){//if(val.length() > 100 && m == 1)
            
            return txt.title(val, true);
            
        } else {//if(val.length() > 100 && m == 1)
            
            return txt.arq(val);
            
        }//if(val.length() > 100 && m == 1)
        
    }//Submit(String input)

    @Override
    public String Title(boolean title) {
        
        Data d = new Data();
        
        return title ? d.DataAbreviada(this.week) : d.DataCompleta(this.week);
        
    }

    @Override
    public String InputText() {
        return this.input;
    }

    @Override
    public java.util.List<Domain> ListMode() {
        
        List<Domain> node = new ArrayList();
        
        for(int x = 0; x < this.list.size(); x++){
            
            node.add(new Domain(x+1,this.list.get(x)));
            
        }//for(int x = 0; x < this.list.size(); x++)
        
        return node;
        
    }

    @Override
    public Font ListFont() {
        
        var max = 0;
        
        for(String t : this.list) if(t.length() > max) max = t.length();
        
        if(this.week){
            
            return new java.awt.Font("Arial Black", 0, 18);
            
        } else if(max < 50){
            
            return new java.awt.Font("Tahoma", 0, 18);
            
        } else if(max < 60){
            
            return new java.awt.Font("Times New Roman", 0, 18);
            
        } else if(max < 70){
            
            return new java.awt.Font("Times New Roman", 0, 16);
            
        } else if(max < 80){
            
            return new java.awt.Font("Times New Roman", 0, 14);
            
        } else if(max < 90){
            
            return new java.awt.Font("Times New Roman", 0, 14);
            
        } else {
            
            return new java.awt.Font("Times New Roman", 0, 12);
            
        }
        
    }

    @Override
    public boolean ListColumn() {return this.list.size() > this.mode;}

    @Override
    public void Action(
        pag1 action,
        java.util.List<Domain> vol,
        String input
    )
    {
        
        switch(action){
            
            case add, open, key, enter ->{
                
                String[] cod = {"sair", "exit", "end","fim"};
                boolean[] doc = new boolean[cod.length+1];
                
                for(int i = 0; i < cod.length; i++){
                    
                    doc[i] = input.trim().equalsIgnoreCase(cod[i]);
                    
                }
                
                doc[cod.length] = input.trim().isBlank();
                
                var type = true;
                
                for(boolean t : doc){
                    
                    if(t){
                        
                        type = false;
                        break;
                        
                    }//if(t)
                    
                }//for(boolean t : doc)
                
                if(type){
                    
                    List<String> v = new ArrayList();
                    
                    for(Domain d : vol) v.add(this.Submit(d.Text(true)));
                    
                    v.add(this.Submit(input));
                    
                    controller.p1m(new config(v));
                    
                } else {//if(type)
                    
                    //this.Exit();
                    controller.p3(new config(this.list));
                    
                }//if(type)
                
            }//case
            
            case remove, delet, backspace ->{
                
                var page = false;
                var out = 0;
                
                do{
                    
                    page = !vol.get(out).Select();
                    
                    out++;
                    
                }while(!page && out > 0 && out < vol.size());
                
                if(vol.size() > 1 && page){
                    
                    List<String> v = new ArrayList();
                    
                    var value = true;
                    var t = "";
                    
                    for(Domain d : vol){
                        
                        if(d.Select() && value){
                            
                            t = d.Text(true);
                            value = false;
                            
                        }//if(value && d.Select())
                        
                        if(!d.Select()) v.add(d.Text(true));
                        
                    }//for(Domain d : vol)
                    
                    if(!input.trim().isBlank()) v.add(this.Submit(input));
                    
                    controller.p1m(new config(v, t));
                    
                } else {//if(vol.size() > 1 && page)
                    
                    this.Exit();
                    
                }//if(vol.size() > 1 && page)
                
            }//case
            
        }//switch(action)
        
    }

    @Override
    public void Command(pag2 op, Domain value) {
        
        switch(op){
            
            case cancel, del, backspace -> this.Exit();
            
            case confirm, enter -> controller.p1m(new config());
            
        }//switch(op)
        
    }

    @Override
    public Font FontTitle() {
        return new java.awt.Font("Arial Black", 0, 18);
    }

    @Override
    public Font TextAreaFont() {
        return new java.awt.Font("Arial", 0, 16);
    }

    @Override
    public List<String> TextArea() {
        return this.list;
    }

    @Override
    public Domain[] Mode() {
        
        Domain[] demo = new Domain[10];
        
        for(int d = 0; d < demo.length; d++){
            
            Domain dem = new Domain(d+1,Reg.Numb(d+1, demo.length, " --- "));
            
            demo[d] = dem;
            
        }//for(int d = 0; d < demo.length; d++)
        
        return demo;
        
    }

    @Override
    public void Painel3(
        int key_code,
        char key_char,
        Domain[] menu,
        List<String> text,
        int row,
        int col
    )
    {
        
        final int max = 10;
        
        if(key_code == 10){
            
            if(this.key_code_count > 1) System.out.println();
            
            this.Exit();
        
        } else if(this.key_code_count <= max && key_code != 10){//if(key_code...
            
            var println = "Impressão ";
            println += Reg.Numb(this.key_code_count, max, " de ");
            println += ": \"";
            println += Reg.Numb(key_code, 100);
            println += "\"";
            
            if(key_char != '￿' && key_char != ''){
                
                println += "\" -- '";
                println += key_char;
                println += "'";
                
            }//if(evt.getKeyChar() != '￿' && key_char != '')
            
            System.out.println(println);
            
            this.key_code_count++;
            
        }//if(key_code == 10)
        
    }

    @Override
    public void Painel3(
        pag3 op,
        Domain[] menu,
        List<String> text,
        int row,
        int col
    )
    {
        
        switch(op){
            
            case confirm, button_list, list_closer, enter -> {
                
                List<String> none = new ArrayList();
                
                for(int add = 0; add < text.size(); add++){
                    
                    var insert = text.get(add);
                    
                    if(add == row) insert = txt.arq(insert);
                    
                    none.add(insert);
                    
                }//for(int add = 0; add < text.size(); add++)
                
                var sum = 0;
                
                for(String t : text) sum += t.length();
                
                if(this.user_area <= 100 && sum < 1000){
                    
                    controller.p3(new config(none,this.user_area));
                    
                } else {//if(this.user_area < 10 && sum < 1000)
                    
                    this.Exit();
                    
                }//if(this.user_area < 10 && sum < 1000)
                
            }//case confirm, button_list, ctrl_enter 
            
            case cancel, ctrl_enter -> this.Exit();
            
        }//switch(op)
        
    }
    
}//config