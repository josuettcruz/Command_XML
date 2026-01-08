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
        
        var end = false;
        
        for(String t : insert){
            
            if(end){
                
                tem += commit ? " - " : "\n";
                end = false;
                
            }//if(end)
            
            if(line){
                
                tem += commit ? " - " : "\n";
                
            } else {
                
                line = true;
                
            }
            
            var quot = true;
            
            for(int i = 0; i < t.length(); i++){
            
                switch(t.charAt(i)){
                    
                    case '"', '\'' -> {
                        
                        if(quot){
                            
                            tem += commit ? "'" : "\"";
                            quot = false;
                            
                            if(end){
                                
                                end = false;
                                
                            } else {
                                
                                end = true;
                                
                            }
                            
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
    
    public static void Print(){
        
        Reg.Print(new Hora(true).TimerGood(true), new Data().DataAbreviada(true));
        Reg.Print(Reg.categories, Reg.choose);
        Reg.Print(Reg.ide, Reg.http);
        
    }//Print()
    
    public static void Exec(){
        
        if(new Data().CompareTo(Reg.modify)){
            
            ExecPrimary();
            
        } else {
            
            Print();
            
        }
        
    }//Exec()
    
    private static void ExecPrimary(){
        
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
        
        
        if(!nome.isBlank()){
            
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
            
            for(String p : Tem(evt.Read().Read(),false).split("\n")) System.out.println(p);
            
        } else {//if(enter)
            
            Print();
            
        }//if(enter)
        
    }//Exec_2026_01_06()
        
    
}