/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command_xml;

import file.*;
import model.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class init {
    
    public static List<String> Print(String run, int tab){
        
        Data d = new Data();
        Hora h = new Hora(true);
        
        if(tab < 0) tab = tab - tab*2;
        
        if(tab == 0) tab = 39;
        
        var t = "";
        
        if(run.length() > 2){
            
            var len = run.charAt(run.length()-1);
            
            switch(len){
                
                case ' ' -> t = run;
                
                default -> t = run + " ";
                
            }//switch(len)
            
        }//if(run.length() > 2)
        
        var addition = 2;
        addition += Reg.ide.length();
        addition += run.length();
        
        if(tab < addition) tab = addition;
        
        
        List<String> println = new ArrayList();
        
        println.add(Reg.Tab(t + Reg.ide, Reg.http,tab));
        println.add(Reg.Tab(t + Reg.categories, Reg.choose,tab));
        
        println.add(
            Reg.Tab(
                t + "Início do PROJETO",
                Reg.create.DataCompleta(true),
                tab
            )
        );
        
        println.add(
            Reg.Tab(
                t + "Última atualização",
                Reg.modify.DataCompleta(true),
                tab
            )
        );
        
        println.add(Reg.Tab(t + h.TimerGood(true), d.DataCompleta(true), tab));
        
        return println;
        
    }//Print()
    
    private static String Tem(String text, boolean commit){
        
        List<String> insert = new ArrayList();
        
        for(String tx : txt.text(text,true).split("\n")){
            
            var inst = "";
            var inter = true;
            
            for(String t : txt.phrase(tx, true)){
                
                var node = true;
                var c = 0;
                
                do{
                    
                    node = t.charAt(c) == '-' || t.charAt(c) == '>';
                    c++;
                    
                }while(c > 0 && c < t.length() && node);
                
                if(node){
                    
                    if(!inst.isBlank()){
                        
                        insert.add(inst);
                        inst = "";
                        
                    }//if(!inst.isBlank())
                    
                    inter = true;
                    
                } else if(inter){//if(node)
                    
                    inst += txt.capitalize(t);
                    inter = false;
                    
                } else {//if(node)
                    
                    inst += " ";
                    
                    inst += t.toLowerCase();
                    
                }//if(node)
                
            }//for(String t : txt.phrase(tx, true))
            
            insert.add(inst);
            
        }//for(String t : txt.phrase(tx, true))
        
        var tem = "";
        
        var quot_end_line = false;
        
        var amp = true;
        
        for(int sum = 0; sum < insert.size(); sum++){
            
            var quot = true;
            
            var divide_point = Reg.Numb(sum+1, insert.size(),"-");
            divide_point += " -> ";
            
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
                    tem += " --";
                    tem += insert.size() > 1 ? " " : "> ";
                    tem += "Nesse COMMIT --";
                    tem += insert.size() > 1 ? " " : "> ";
                    
                    if(insert.size() > 1){
                        
                        tem += divide_point;
                        
                    }//if(insert.size() == 1){
                    
                } else {//if(sum == 0)
                    
                    tem += " ";
                    tem += divide_point;
                    
                }//if(sum == 0)
                
            } else {//if(commit && insert.size() > 1)
                
                if(sum > 0) tem += "\n";
                
            }//if(commit && insert.size() > 1)
            
            for(int i = 0; i < insert.get(sum).length(); i++){
            
                switch(insert.get(sum).charAt(i)){
                    
                    case '"', '\'' -> {
                        
                        if(quot){
                            
                            quot_end_line = !quot_end_line;
                            
                            tem += commit ? "'" : "\"";
                            quot = false;
                            
                        }//if(val)
                        
                        amp = true;
                        
                    }//cases
                    
                    case '\\', '/' -> {
                        
                        tem += "/";
                        quot = true;
                        
                        amp = false;
                        
                    }//case '\\', '/'
                    
                    case '.', '!' ->{}
                    
                    case ';', ',', ':' -> {
                        
                        if(amp && i < insert.get(sum).length()-1 && !quot_end_line){
                            
                            tem += insert.get(sum).charAt(i);
                            amp = false;
                            
                        }//if(i < insert.get(sum).length()-1 && !quot_end_line)
                        
                        quot = true;
                        
                    }//default
                    
                    default -> {
                        
                        tem += quot_end_line
                            ? insert.get(sum).toUpperCase().charAt(i)
                            : insert.get(sum).charAt(i);
                        
                        quot = true;
                        
                        amp = true;
                        
                    }//default
                    
                }//switch(t.charAt(i))
                
            }//for(int i = 0; i < insert.get(sum).length(); i++)
            
            if(quot && !quot_end_line) tem += commit ? "!" : ".";
            
            if(commit && !quot && sum < insert.size()-1) tem += " --";
        
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
            "nome",
            "run"
        };
        
        List<String> q = new ArrayList();
        
        var tot = 0;
        
        for(String a : arqv){
            
            q.add("..\\" + a);
            q.add("..\\..\\" + a);
            
        }//for(String a : arqv)
        
        q.add(new Data().Load());
        
        for(String b : arqv){
            
            q.add(b + "_" + new Data().Load());
            
        }//for(String b : arqv)
        
        var ag = true;
        
        for(
            int h = LocalTime.now().getHour();
            h >= 0;
            h--
        )
        {
                
            for(
                int m = ag ? LocalTime.now().getMinute() : 59;
                m >= 0;
                m--
            )
            {

                var nom = new Data().Load();
                nom += "_";
                nom += Reg.Numb(h);
                nom += "-";
                nom += Reg.Numb(m);

                q.add(nom);

                for(String g : arqv){

                    var dm = g;
                    dm += "_";
                    dm += nom;

                    q.add(dm);

                    if(dm.length() > tot) tot = dm.length();

                }//for(String g : arqv)

            }//for(int m = ag ? LocalTime.now().getMinute() : 59;m >= 0;m--)
            
            ag = false;
            
        }//for(int h = LocalTime.now().getHour();h >= 0;h--)
        
        var nome = "";
        var ss = 0;
        
        do{
            
            if(Arq.Exist(q.get(ss))) nome = q.get(ss);
            
            ss++;
            
        }while(ss > 0 && ss < q.size() && nome.isBlank());
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var file = q.get(ss);
                file += ".ini";
                
                if(Arq.Exist(file)) nome = file;
                
                ss++;
                
            }while(ss > 0 && ss < q.size() && nome.isBlank());
            
        }//if(nome.isBlank()) - 1 - 3
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var file = q.get(ss);
                file += ".txt";
                
                if(Arq.Exist(file)) nome = file;
                
                ss++;
                
            }while(ss > 0 && ss < q.size() && nome.isBlank());
            
        }//if(nome.isBlank()) - 2 - 3
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var file = q.get(ss);
                file += ".TXT";
                
                if(Arq.Exist(file)) nome = file;
                
            }while(ss > 0 && ss < q.size() && nome.isBlank());
            
        }//if(nome.isBlank()) - 3 - 3
        
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
            
            Arq evt = new Arq(nome);
            evt.Save(Tem(evt.Read().Read(),false));
            Reg.coppy(Tem(evt.Read().Read(),true));
            
            Reg.Print(new Hora(true).TimerGood(false), nome);
            
            var p = Tem(evt.Read().Read(),false).split("\n");
            
            for(int n = 0; n < p.length; n++){
                
                Reg.Print("Linha " + Reg.Numb(n+1, p.length, " de "), p[n]);
                
            }//for(int n = 0; n < p.length; n++)
            
        }//if(enter)if(nome.isBlank())
        
    }//gitCommit()
    
    public static void Exec(){
        
        if(new Data().CompareTo(Reg.modify)){
            
            gitCommit();
            
        } else {//if(new Data().CompareTo(Reg.modify))
            
            for(String p : Print("run:",0)) System.out.println(p);
            
        }//if(new Data().CompareTo(Reg.modify))
        
    }//Exec()
    
}