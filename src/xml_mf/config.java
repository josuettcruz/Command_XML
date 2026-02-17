/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import form.Clean;
import form.Domain;
import model.*;
import form.Painel_1Single;

import java.awt.Font;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class config implements Painel_1Single{
    
    private List<String> list;
    private String input;
    
    private List<String> dom;
    
    boolean recent;
    
    public config(){
        
        this.input = "";
        this.recent = true;
        
        this.dom = new ArrayList();
        
        this.list = new ArrayList();
        this.list.add(new Data().DataAbreviada(true));
        this.list.add(new Hora(true).TimerGood(false));
        this.list.add("Nenhum item ainda!");
        
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
        
        return title
            ? Reg.modify.DataAbreviada(true)
            : new Data().DataCompleta(this.recent);
        
    }

    @Override
    public String InputText(boolean user) {
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
        
        if(this.recent){
            
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
        return this.list.size() > 10 && !this.recent;
    }

    @Override
    public Painel_1Single Adicionar(boolean button, String input) {
        
        var m = txt.phrase(input, true).size();
        
        if(input.equalsIgnoreCase("exit") || input.trim().isBlank()){
            
            this.Exit();
            
        } else if(m == 1 && input.trim().length() > 10){
            
            if(this.recent){
                
                this.list.clear();
                this.recent = false;
                
            }//if(this.recent)
            
            this.list.add(
                "\""
                + Reg.Numb(txt.arq(input).length(), 100000)
                + "\" - "
                + txt.arq(input)
            );
            
        } else if(m == 1){
            
            if(this.recent){
                
                this.list.clear();
                this.recent = false;
                
            }//if(this.recent)
            
            this.list.add(txt.arq(input));
            
        } else if(input.length() > 100){
            
            if(this.recent){
                
                this.list.clear();
                this.recent = false;
                
            }//if(this.recent)
            
            this.list.add(
                "\""
                + Reg.Numb(txt.arq(input).length(), 100000)
                + "\" - "
                + txt.arq(input)
            );
            
        } else if(m <= 5){
            
            if(this.recent){
                
                this.list.clear();
                this.recent = false;
                
            }//if(this.recent)
            
            this.list.add(txt.title(input.replace("'", "\""), true));
            
        } else {
            
            if(this.recent){
                
                this.list.clear();
                this.recent = false;
                
            }//if(this.recent)
            
            this.list.add(txt.arq(input));
            
        }
        
        return this;
        
    }

    @Override
    public Painel_1Single Abrir(boolean button, int index, String name, String input) {
        
        this.Exit();
        return new Clean();
        
    }

    @Override
    public Painel_1Single Apagar(boolean button, int index, String name, String input) {
        
        if(this.list.size() > 1 && index >= 0){
            
            this.list.remove(index);
            return this;
            
        } else {//if(this.list.size() > 1 && index >= 0)
            
            this.Exit();
            return new Clean();
            
        }//if(this.list.size() > 1 && index >= 0)
        
    }
    
}//config