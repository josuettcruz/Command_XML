/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command_xml;

import file.*;
import java.time.LocalTime;
import model.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class init {
    
    public static List<String> Print(){
        
        Data d = new Data();
        Hora h = new Hora(true);
        
        final var tab = 39;
        final var t = "run: ";
        
        List<String> println = new ArrayList();
        
        println.add(
            Reg.Tab(
                t + "Criado " + Reg.create.DataLinha(false) + "!",
                Reg.create.DataCompleta(true),
                tab
            )
        );
        
        println.add(
            Reg.Tab(
                t + "Atualizado " + Reg.modify.DataLinha(false) + "!",
                Reg.modify.DataCompleta(true),
                tab
            )
        );
        
        println.add(Reg.Tab(t + h.Good(), "Hoje é dia " + d.DataCompleta(false), tab));
        
        println.add(Reg.Tab(t + Reg.categories, Reg.choose,tab));
        println.add(Reg.Tab(t + Reg.ide, Reg.http,tab));
        
        return println;
        
    }//Print()
    
    private static String Tem(String text, boolean commit){
        
        List<String> insert = new ArrayList();
        
        for(String tx : txt.text(text.replace(" -- ", "\n").replace(" - ", "\n"))){
            
            var inter = true;
            var inst = "";
            
            for(String t : txt.phrase(tx, true)){
                
                if(inter){
                    
                    inst += txt.capitalize(t);
                    inter = false;
                    
                } else {//if(inter)
                    
                    inst += " ";
                    inst += t;
                    
                }//if(inter)
                
            }//for(String t : txt.phrase(tx, true))
            
            insert.add(inst);
            
        }//for(String q : txt.text(text.replace(" -- ", "\n").replace(" - ", "\n")))
        
        var tem = "";
        
        var quot_end_line = false;
        final var divide_point = " -> ";
        
        for(int sum = 0; sum < insert.size(); sum++){
            
            if(quot_end_line){
                
                tem += commit ? "'" : "\"";
                quot_end_line = false;
                
            }//if(quot_end_line)
            
            if(commit){
                
                if(sum == 0){
                    
                    tem += "git commit -m \"";
                    tem += new Data().DataAbreviada(true);
                    tem += " -- ";
                    tem += new Hora(false).TimerGood(true);
                    tem += " --> Nesse COMMIT --> ";
                    
                    if(insert.size() > 1){
                        
                        tem += Reg.Numb(sum+1, insert.size(),"-");
                        tem += divide_point;
                        
                    }//if(insert.size() == 1){
                    
                } else {//if(sum == 0)
                    
                    tem += " -- ";
                    tem += Reg.Numb(sum+1, insert.size(),"-");
                    tem += divide_point;
                    
                }//if(sum == 0)
                
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
                    
                    case '.', '!', ':' ->{}
                    
                    default -> {
                        
                        tem += insert.get(sum).charAt(i);
                        
                        quot = true;
                        
                    }//default
                    
                }//switch(t.charAt(i))
                
            }//for(int i = 0; i < insert.get(sum).length(); i++)
            
            if(quot && !quot_end_line) tem += commit ? "." : "!";
        
        }//for(int sum = 0; sum < insert.size(); sum++)
        
        if(quot_end_line) tem += commit ? "'" : "\"";
        
        if(commit) tem += "\"";
        
        return tem;
        
    }//Tem(String text)
    
    private static void gitCommit(){
        
        final String[] arqv = {
            "info",
            "title",
            "code",
            "name",
            "run"
        };
        
        List<String> q = new ArrayList();
        
        var tot = 0;
        
        for(String a : arqv){
            
            q.add("..\\" + a + ".txt");
            q.add("..\\..\\" + a + ".txt");
            q.add("..\\..\\..\\" + a + ".txt");
            
        }//for(String a : arqv)
        
        var dat = new Data().Load();
        dat += ".txt";
        
        q.add(dat);
        
        for(String b : arqv){
            
            q.add(b + "_" + dat);
            
        }//for(String b : arqv)
        
        var ag = true;
        
        for(
            int h = LocalTime.now().getHour();
            h >= 0;
            h--
        )
        {
            
            if(ag){
                
                for(
                    int m = LocalTime.now().getMinute();
                    m >= 0;
                    m--
                )
                {
                    
                    var nom = new Data().Load();
                    nom += "_";
                    nom += Reg.Numb(h);
                    nom += "-";
                    nom += Reg.Numb(m);
                    
                    q.add(nom + ".txt");
                    
                    for(String g : arqv){
                        
                        var dm = g;
                        dm += "_";
                        dm += nom;
                        dm += ".txt";
                        
                        q.add(dm);
                        
                        if(dm.length() > tot) tot = dm.length();
                        
                    }//for(String g : arqv)
                    
                }//for(int m = 59; m >= 0; m--)
                
                ag = false;
                
            } else {//if(ag)
                
                for(int m = 59; m >= 0; m--){
                    
                    var nom = new Data().Load();
                    nom += "_";
                    nom += Reg.Numb(h);
                    nom += "-";
                    nom += Reg.Numb(m);
                    
                    q.add(nom + ".txt");
                    
                    for(String g : arqv){
                        
                        var dm = g;
                        dm += "_";
                        dm += nom;
                        dm += ".txt";
                        
                        q.add(dm);
                        
                        if(dm.length() > tot) tot = dm.length();
                        
                    }//for(String g : arqv)
                    
                }//for(int m = 59; m >= 0; m--)
                
            }//if(ag)
            
        }//for(int h = 23; h >= 0; h--)
        
        var nome = "";
        var ss = 0;
        
        do{
            
            if(Arq.Exist(q.get(ss))){
                
                nome = q.get(ss);
                System.out.println(Arq.Files(q.get(ss)));
                
            }
            
            ss++;
            
        }while(ss > 0 && ss < q.size() && nome.isBlank());
        
        if(nome.isBlank()){
            
            for(int e = q.size()-1; e >= 0;e--){
                
                var pr = "-- ";
                pr += Reg.Numb(q.size() - e, q.size());
                pr += " -- \"";
                pr += q.get(e);
                pr += "\"";
                
                Reg.Print(pr, "--", Reg.Numb(q.size()).length() + tot + 10);
                
            }//for(int e = q.size()-1; e >= 0;e--)
            
        } else {//if(nome.isBlank())
            
            Hora h = new Hora(true);
            
            var view = "Agora são ";
            view += h.TimerGood(false);
            view += " da ";
            view += h.Good("manhã", "tarde", "noite");
            view += "!";
            
            Arq evt = new Arq(nome);
            evt.Save(Tem(evt.Read().Read(),false));
            Reg.coppy(Tem(evt.Read().Read(),true));
            
            var p = Tem(evt.Read().Read(),false).split("\n");
            
            System.out.println(
                "Hoje é "
                + new Data().DataCompleta(true)
            );
            
            System.out.println(view);
            
            System.out.println();
            System.out.println(nome);
            
            for(int n = 0; n < p.length; n++){
                
                Reg.Print("Linha " + Reg.Numb(n+1, p.length, " de "), p[n]);
                
            }//for(int n = 0; n < p.length; n++)
            
        }//if(enter)if(nome.isBlank())
        
    }//gitCommit()
    
    public static void Exec(){
        
        if(new Data().CompareTo(Reg.modify)){
            
            gitCommit();
            
        } else {//if(new Data().CompareTo(Reg.modify))
            
            for(String p : Print()) System.out.println(p);
            
        }//if(new Data().CompareTo(Reg.modify))
        
    }//Exec()
    
}