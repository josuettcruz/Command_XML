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

import static form.pag1.remove;
import static form.pag1.open;
import static form.pag1.key;
import static form.pag1.enter;
import static form.pag1.delet;
import static form.pag1.backspace;
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
    
    private final int mode = 10;
    
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
            form = value.get(value.size()-1);
        }
        
        this.input = form;
        
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
    public Font ListFont() {
        
        var max = 0;
        
        for(String t : this.list) if(t.length() > max) max = t.length();
        
        if(max <= 10){
            
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
            
        } else {
            
            return new java.awt.Font("Times New Roman", 0, 10);
            
        }
        
    }

    @Override
    public boolean ListColumn() {
        return this.list.size() > this.mode;
    }

    @Override
    public void Adicionar(boolean button, String input, List<String> lt) {
        
        List<String> value = new ArrayList();
        
        value.addAll(lt);
        
        var m = txt.phrase(input, true).size();
        
        if(input.equalsIgnoreCase("exit") || input.trim().isBlank()){
            
            this.Exit();
            
        } else if(m == 1 && input.trim().length() > 10){
            
            value.add(
                "\""
                + Reg.Numb(txt.arq(input).length(), 100000)
                + "\" - "
                + txt.arq(input)
            );
            
        } else if(m == 1){
            
            value.add(txt.arq(input));
            
        } else if(input.length() > 100){
            
            value.add(
                "\""
                + Reg.Numb(txt.arq(input).length(), 100000)
                + "\" - "
                + txt.arq(input)
            );
            
        } else if(m <= 5){
            
            value.add(txt.title(input.replace("'", "\""), true));
            
        } else {
            
            value.add(txt.arq(input));
            
        }
        
        controller.p1s(new config(value));
        
    }

    @Override
    public void Abrir(
        boolean button,
        int index,
        List<String> lt,
        String input
    )
    {
        
        this.Exit();
        
    }

    @Override
    public void Apagar(
        boolean button,
        int index,
        List<String> lt,
        String input
    )
    {
        
        List<String> value = new ArrayList();
        
        value.addAll(lt);
        
        for(int i = 0; i < lt.size(); i++){
            
            if(i != index) value.add(lt.get(i));
            
        }
        
        controller.p1s(new config(value));
        
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
    public void Action(
        pag1 action,
        java.util.List<Domain> vol,
        String input
    )
    {
        
        switch(action){
            
            case add, enter, open, key ->{
                
                List<String> value = new ArrayList();
                
                for(Domain d : vol) value.add(d.Text(true));
                
                if(!input.trim().isBlank()) value.add(input.trim());
                
                controller.p1m(new config(value));
                
            }//case
            
            case remove, delet, backspace ->{
                
                String[] cod = {"sair", "exit", "end"};
                boolean doc = true;
                int e = 0;
                
                do{
                    
                    doc = cod[e].equalsIgnoreCase(input);
                    
                }while(doc && e > 0 && e < cod.length);
                
                if(doc){
                    
                    List<String> v = new ArrayList();
                    
                    for(Domain d : vol){
                        
                        if(!d.Select()) v.add(d.Text(true));
                        
                    }
                    
                    controller.p1m(new config(v));
                    
                } else {
                    
                    this.Exit();
                    
                }
                
            }//case
            
        }//switch(action)
        
    }

    @Override
    public void Command(pag2 op, Domain value) {
        
        switch(op){
            
            case confirm, enter -> controller.p1m(new config());
            
            case cancel, del, backspace -> controller.p1m(new config());
            
        }//switch(op)
        
    }
    
}//config