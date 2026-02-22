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
import form.controller;
import form.pag1;
import static form.pag1.add;
import static form.pag1.backspace;

import static form.pag1.remove;
import static form.pag1.open;
import static form.pag1.key;
import static form.pag1.enter;
import static form.pag1.delet;
import static form.pag1.delet;
import static form.pag1.enter;
import static form.pag1.key;
import static form.pag1.open;
import static form.pag1.remove;

import form.pag2;
import static form.pag2.backspace;
import static form.pag2.cancel;
import static form.pag2.confirm;
import static form.pag2.del;
import static form.pag2.enter;

import java.awt.Font;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class config implements Painel_1Single, Painel_1Multiple, Painel_2{
    
    private final int mode = 15;
    
    private List<String> list;
    private String input;
    private boolean week;
    
    public config(){
        
        this.input = "";
        
        this.week = true;
        
        this.list = new ArrayList();
        this.list.add(new Data().DataAbreviada(true));
        
    }//Enter()
    
    public config(List<String> value){
        
        var form = "";
        
        this.week = false;
        
        if(value.size() > 1 && value.size() <= this.mode){
            form = this.Submit(value.get(value.size()-1));
        }
        
        this.input = form;
        
        this.list = new ArrayList();
        this.list.addAll(value);
        
    }//Enter()
    
    public config(List<String> value, String input){
        
        this.input = input;
        
        this.week = false;
        
        this.list = new ArrayList();
        this.list.addAll(value);
        
    }//Enter()
    
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
        
        var val = input.replace("_", " ").replace("-", " ");
        
        var m = txt.phrase(val, true).size();
        
        if(val.length() > 100 && m == 1){
            
            return Reg.Numb(m) + " letras --> " + val;
            
        } else if(val.length() > 100){
            
            return Reg.Numb(m, input.length(), " palavras e ") + " letras!";
            
        } else if(m == 1){
            
            return txt.capitalize(val);
            
        } else if(m < 5){
            
            return txt.title(val, true);
            
        } else if(m == 5){
            
            return txt.text(val, true);
            
        } else {
            
            return txt.arq(val);
            
        }
        
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
    public java.util.List<String> List() {
        return this.list;
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
            
        } else if(max < 20){
            
            return new java.awt.Font("Tahoma", 0, 18);
            
        } else if(max < 40){
            
            return new java.awt.Font("Times New Roman", 0, 18);
            
        } else if(max < 60){
            
            return new java.awt.Font("Times New Roman", 0, 16);
            
        } else if(max < 80){
            
            return new java.awt.Font("Times New Roman", 0, 14);
            
        } else if(max < 100){
            
            return new java.awt.Font("Times New Roman", 0, 12);
            
        } else if(max < 150){
            
            return new java.awt.Font("Times New Roman", 0, 10);
            
        } else {
            
            return new java.awt.Font("Times New Roman", 0, 8);
            
        }
        
    }

    @Override
    public boolean ListColumn() {return this.list.size() > this.mode;}

    @Override
    public void Button(
        pag1 action, 
        int index,
        java.util.List<String> vol,
        String input
    )
    {
        
        switch(action){
            
            case add, enter, open, key ->{
                
                String[] cod = {"sair", "exit", "end", "fim"};
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
                    
                    v.addAll(vol);
                    
                    v.add(this.Submit(input));
                    
                    controller.p1s(new config(v));
                    
                } else {
                    
                    this.Exit();
                    
                }
                
            }//case
            
            case remove, delet, backspace ->{
                
                List<String> v = new ArrayList();
                
                for(int i = 0; i < vol.size(); i++){
                    
                    if(i != index) v.add(vol.get(i));
                    
                }
                
                controller.p1s(new config(v, txt.title(vol.get(index), true)));
                
            }//case
            
        }//switch(action)
        
    }

    @Override
    public void Action(
        pag1 action,
        java.util.List<Domain> vol,
        String input
    )
    {
        
        switch(action){
            
            case add, enter, open, key ->{
                
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
                    
                } else {
                    
                    this.Exit();
                    
                }
                
            }//case
            
            case remove, delet, backspace ->{
                
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
                
                if(!input.trim().isBlank()) v.add(input);
                
                controller.p1m(new config(v, t));
                
            }//case
            
        }//switch(action)
        
    }

    @Override
    public void Command(pag2 op, Domain value) {
        
        switch(op){
            
            case confirm, enter -> controller.p1m(new config());
            
            case cancel, del, backspace -> controller.p1s(new config());
            
        }//switch(op)
        
    }
    
}//config