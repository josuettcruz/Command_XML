/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command_xml;

import file.*;
import model.*;

import java.util.ArrayList;
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
            
            if(ins.contains(" -- ")){
                
                for(String hif : ins.split(" -- ")){
                    
                    if(!hif.isBlank()) insert.add(hif);
                    
                }//for(String hif : ins.split(" - "))
                
            } else if(ins.contains(" - ")){//if(ins.contains...
                
                for(String hif : ins.split(" - ")){
                    
                    if(!hif.isBlank()) insert.add(hif);
                    
                }//for(String hif : ins.split(" -- "))
                
            } else {//if(ins.contains...
                
                insert.add(ins);
                
            }//if(ins.contains...
            
        }//for(String ins : txt.text(text))
        
        var tem = "";
        
        if(commit){
            
            tem += "git commit -m \"-- ";
            tem += new Data().DataAbreviada(true);
            tem += " -- ";
            tem += new Hora(false).TimerGood(true);
            
        }//if(commit)
        
        var quot_end_line = false;
        
        for(int sum = 0; sum < insert.size(); sum++){
            
            if(quot_end_line){
                
                tem += commit ? "'" : "\"";
                quot_end_line = false;
                
            }//if(quot_end_line)
            
            if(commit && insert.size() > 1){
                
                tem += " --\\n-- Linha ";
                tem += Reg.Numb(sum+1, insert.size());
                tem += " de ";
                tem += insert.size();
                tem += " -- ";
                
            } else if(commit){
                
                tem += " -- ";
                
            } else {//if(commit && insert.size() > 1)
                
                if(sum > 0) tem += "\n";
                
            }//if(commit && insert.size() > 1)
            
            var quot = true;
            
            for(int i = 0; i < insert.get(sum).length(); i++){
            
                switch(insert.get(sum).charAt(i)){
                    
                    case '"', '\'' -> {
                        
                        if(quot){
                            
                            quot_end_line = !quot_end_line;
                            
                            tem += commit ? "'" : "\"";
                            quot = false;
                            
                        }//if(val)
                        
                    }//cases
                    
                    case '\\', '/' -> {
                        
                        tem += "/";
                        quot = true;
                        
                    }//case '\\', '/'
                    
                    case ' ' -> tem += " ";
                    
                    default -> {
                        
                        tem += insert.get(sum).charAt(i);
                        
                        quot = true;
                        
                    }//default
                    
                }//switch(t.charAt(i))
                
            }//for(int i = 0; i < insert.get(sum).length(); i++)
        
        }//for(int sum = 0; sum < insert.size(); sum++)
        
        if(quot_end_line) tem += commit ? "'" : "\"";
        
        if(commit) tem += " --\"";
        
        return tem;
        
    }//Tem(String text)
    
    private static void gitCommit(){
        
        final String[] arqv = {
            "info",
            "title",
            "code",
            "name"
        };
        
        List<String> q = new ArrayList();
        
        for(String a : arqv){
            
            q.add("..\\" + a + ".txt");
            
        }//for(String a : arqv)
        
        for(String b : arqv){
            
            q.add("..\\..\\" + b + ".txt");
            
        }//for(String b : arqv)
        
        for(String b : arqv){
            
            q.add("..\\..\\..\\" + b + ".txt");
            
        }//for(String b : arqv)
        
        for(int h = 23; h >= 0; h--){
            
            for(int m = 59; m >= 0; m--){
                
                for(int s = 59; s >= 0; s--){
                    
                    var nom = new Data().Load();
                    nom += "_";
                    nom += Reg.Numb(h);
                    nom += "-";
                    nom += Reg.Numb(m);
                    nom += "-";
                    nom += Reg.Numb(s);
                    nom += ".txt";
                    
                    q.add(nom);
                    
                }//for(int s = 59; s >= 0; s--)
                
                var nom = new Data().Load();
                nom += "_";
                nom += Reg.Numb(h);
                nom += "-";
                nom += Reg.Numb(m);
                nom += ".txt";
                
                q.add(nom);
                
            }//for(int m = 59; m >= 0; m--)
            
        }//for(int h = 23; h >= 0; h--)
        
        var nome = "";
        var ss = 0;
        
        do{
            
            if(Arq.Exist(q.get(ss))) nome = q.get(ss);
            
            ss++;
            
        }while(ss > 0 && ss < q.size() && nome.isBlank());
        
        if(nome.isBlank()){
            
            for(int e = q.size()-1; e >= 0;e--){
                
                System.err.print("-- ");
                System.err.print(Reg.Numb(q.size() - e, q.size()));
                System.err.print(" -- \"");
                System.err.print(q.get(e));
                System.err.println("\"");
                
            }//for(int e = q.size()-1; e >= 0;e--)
            
        } else {//if(nome.isBlank())
            
            Arq evt = new Arq(nome);
            evt.Save(Tem(evt.Read().Read(),false));
            Reg.coppy(Tem(evt.Read().Read(),true));
            
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
            System.out.println(nome);
            
            for(int n = 0; n < p.length; n++)
                Reg.Print("Linha " + Reg.Numb(n+1, p.length, " de "), p[n]);
            
        }//if(enter)if(nome.isBlank())
        
    }//gitCommit()
    
}