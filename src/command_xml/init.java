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
        final var t = "run: ";
        
        List<String> println = new ArrayList();
        
        println.add(Reg.Tab(t + new Hora(true).TimerGood(true), new Data().DataCompleta(true),tab));
        println.add(Reg.Tab(t + Reg.categories, Reg.choose,tab));
        println.add(Reg.Tab(t + Reg.ide, Reg.http,tab));
        
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
        
        var println = "";
        
        do{
            
            var ini = "..\\";
            ini += arqv[ss];
            ini += ".txt";
            
            if(Arq.Exist(ini)){
                
                nome = ini;
                println = "Arquivo: ";
                println += arqv[ss].toUpperCase();
                
            }//if(Arq.Exist(ini))
            
            ss++;
            
        }while(ss > 0 && ss < arqv.length && nome.isBlank());
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var ini = "..\\..\\";
                ini += arqv[ss];
                ini += ".txt";
            
                if(Arq.Exist(ini)){
                    
                    nome = ini;
                    println = "Arquivo: ";
                    println += arqv[ss].toUpperCase();
                    println += ".TXT";
                    
                }//if(Arq.Exist(ini))
                
                ss++;
                
            }while(ss > 0 && ss < arqv.length && nome.isBlank());
            
        }//if(nome.isBlank()) - 1 - 5
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var ini = "..\\";
                ini += arqv[ss];
                ini += ".ini";
            
                if(Arq.Exist(ini)){
                    
                    nome = ini;
                    println = "Arquivo: ";
                    println += arqv[ss].toUpperCase();
                    println += ".INI";
                    
                }//if(Arq.Exist(ini))
                
                ss++;
                
            }while(ss > 0 && ss < arqv.length && nome.isBlank());
            
        }//if(nome.isBlank()) - 2 - 5
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var ini = "..\\..\\";
                ini += arqv[ss];
                ini += ".ini";
            
                if(Arq.Exist(ini)){
                    
                    nome = ini;
                    println = "Arquivo: ";
                    println += arqv[ss].toUpperCase();
                    println += ".INI";
                    
                }//if(Arq.Exist(ini))
                
                ss++;
                
            }while(ss > 0 && ss < arqv.length && nome.isBlank());
            
        }//if(nome.isBlank()) - 3 - 5
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var ini = arqv[ss];
                ini += ".ini";
            
                if(Arq.Exist(ini)){
                    
                    nome = ini;
                    println = "Arquivo: ";
                    println += arqv[ss].toUpperCase();
                    println += ".INI";
                    
                }//if(Arq.Exist(ini))
                
                ss++;
                
            }while(ss > 0 && ss < arqv.length && nome.isBlank());
            
        }//if(nome.isBlank()) - 4 - 5
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var ini = arqv[ss];
                ini += ".txt";
            
                if(Arq.Exist(ini)){
                    
                    nome = ini;
                    println = "Arquivo: ";
                    println += arqv[ss].toUpperCase();
                    println += ".txt";
                    
                }//if(Arq.Exist(ini))
                
                ss++;
                
            }while(ss > 0 && ss < arqv.length && nome.isBlank());
            
        }//if(nome.isBlank()) - 5 - 5
        
        if(nome.isBlank()){
            
            for(String err : Print()) System.err.println(err);
            
        } else {//if(nome.isBlank())
            
            Arq evt = new Arq(nome);
            
            var git = "git commit -m \"";
            git += new Data().DataAbreviada(true);
            git += " - ";
            git += new Hora(false).TimerGood(true);
            git += " - Nesse commit: ";
            
            git += Tem(evt.Read().Read(),true);
            evt.Save(Tem(evt.Read().Read(),false));
            
            git += "\"";
            
            Reg.coppy(git);
            
            var p = Tem(evt.Read().Read(),false).split("\n");
            
            System.out.println(
                "Hoje é "
                + new Data().DataCompleta(true)
            );
            
            System.out.println(
                "Agora são "
                + new Hora(true).TimerGood(false)
                + " da "
                + new Hora(true).Good("manhã", "tarde", "noite")
                + "!"
            );
            
            System.out.println();
            
            System.out.println(println);
            
            for(int n = 0; n < p.length; n++)
                Reg.Print("Linha " + Reg.Numb(n+1, p.length, " de "), p[n]);
            
        }//if(enter)if(nome.isBlank())
        
    }//gitCommit()
    
}