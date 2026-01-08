/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command_xml;

import file.*;
import model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author josue
 */
public class init {
    
    public static void Exec(){
        
        if(new Data().CompareTo(Reg.modify)){
            
            gitCommit();
            
        } else {//if(new Data().CompareTo(Reg.modify))
            
            for(String p : Print()) System.out.println(p);
            
        }//if(new Data().CompareTo(Reg.modify))
        
    }//Exec()
    
    public static List<String> Print(){
        
        final var tab = 39;
        
        List<String> println = new ArrayList();
        
        println.add(Reg.Tab("run: " + new Hora(true).TimerGood(true), new Data().DataAbreviada(true),tab));
        println.add(Reg.Tab("run: " + Reg.categories, Reg.choose,tab));
        println.add(Reg.Tab("run: " + Reg.ide, Reg.http,tab));
        
        return println;
        
    }//Print()
    
    private static String Tem(String text, boolean commit){
        
        List<String> insert = new ArrayList();
        
        for(String ins : txt.text(text)){
            
            if(ins.contains(" - ")){
                
                insert.addAll(Arrays.asList(ins.split(" - ")));
                
            } else {//if(ins.contains(" - "))
                
                insert.add(ins);
                
            }//if(ins.contains(" - "))
            
        }//for(String ins : txt.text(text))
        
        var tem = "";
        
        var line = false;
        
        var quot_end_line = false;
        
        for(String t : insert){
            
            if(quot_end_line){
                
                tem += commit ? "'" : "\"";
                quot_end_line = false;
                
            }//if(end)
            
            if(line){
                
                tem += commit ? " - " : "\n";
                
            } else {//if(line)
                
                line = true;
                
            }//if(line)
            
            var quot = true;
            
            for(int i = 0; i < t.length(); i++){
            
                switch(t.charAt(i)){
                    
                    case '"', '\'' -> {
                        
                        if(quot){
                            
                            quot_end_line = !quot_end_line;
                            
                            tem += commit ? "'" : "\"";
                            quot = false;
                            
                        }//if(val)
                        
                    }//cases
                    
                    case '\\', '/' -> tem += "/";
                    
                    default -> {
                        
                        tem += t.charAt(i);
                        
                        quot = true;
                        
                    }//default
                    
                }//switch(t.charAt(i))
                
            }//for(int i = 0; i < t.length(); i++)
        
        }//for(String t : txt.text(text))
        
        return tem;
        
    }//Tem(String text)
    
    private static void gitCommit(){
        
        final String[] arqv = {
            "info",
            "title",
            "code"
        };
        
        var nome = "";
        var ss = 0;
        
        do{
            
            var ini = "..\\";
            ini += arqv[ss];
            ini += ".txt";
            
            if(Arq.Exist(ini)) nome = ini;
            
            var ine = "..\\";
            ine += ini;
            
            if(Arq.Exist(ine)) nome = ine;
            
            ss++;
            
        }while(ss > 0 && ss < arqv.length && nome.isBlank());
        
        if(nome.isBlank()){
            
            for(String err : Print()) System.err.println(err);
            
        } else {//if(nome.isBlank())
            
            Arq evt = new Arq(nome);
            
            var git = "git commit -m \"";
            git += new Data().DataAbreviada(true);
            git += " - ";
            git += new Hora(false).TimerGood(true);
            git += " - ";
            
            git += Tem(evt.Read().Read(),true);
            evt.Save(Tem(evt.Read().Read(),false));
            
            git += "\"";
            
            Reg.coppy(git);
            
            var page = Tem(evt.Read().Read(),false).split("\n")[0];
            var page_char = page.charAt(page.length()-1);
            
            var page_int = page.length();
            
            if(page_char == '"') page_int--;
            
            Reg.Print(
                    new Data().DataAbreviada(true),
                    new Hora(true).TimerGood(true),
                    page_int
            );
            
            for(String p : Tem(evt.Read().Read(),false).split("\n")) System.out.println(p);
            
        }//if(enter)if(nome.isBlank())
        
    }//gitCommit()
    
}