/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command_xml;

import file.*;
import model.*;
import form.controller;

import java.time.LocalTime;
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
        
        char[] ex = {
            '-',
            '_',
            '>',
            '0',
            '1',
            '2',
            '3',
            '4',
            '5',
            '6',
            '7',
            '8',
            '9'
        };
        
        for(String tx : txt.text(text,true).split("\n")){
            
            var inst = "";
            var inter = true;
            
            for(String t : txt.phrase(tx, true)){
                
                var node = true;
                var c = 0;
                
                do{
                    
                    var doc = false;
                    
                    var d = 0;
                    
                    do{
                        
                        doc = t.charAt(c) != ex[d];
                        
                        d++;
                        
                    }while(d > 0 && d < ex.length && doc);
                    
                    node = !doc;
                    c++;
                    
                }while(c > 0 && c < t.length() && node);
                
                if(node){
                    
                    if(!inst.isBlank()){
                        
                        insert.add(inst);
                        inst = "";
                        
                    }//if(!inst.isBlank())
                    
                    inter = true;
                    
                } else if(inter){//if(node)
                    
                    for(int a = 0; a < t.length(); a++){
                        
                        switch(a){
                            
                            case 0 -> inst += t.toUpperCase().charAt(a);
                            
                            default -> inst += t.charAt(a);
                            
                        }
                        
                    }
                    
                    inter = false;
                    
                } else {//if(node)
                    
                    inst += " ";
                    
                    inst += t;
                    
                }//if(node)
                
            }//for(String t : txt.phrase(tx, true))
            
            insert.add(inst);
            
        }//for(String t : txt.phrase(tx, true))
        
        var tem = "";
        
        var quot_end_line = false;
        
        var amp = true;
        
        var quot = true;
        
        for(int sum = 0; sum < insert.size(); sum++){
            
            quot = true;
            
            var divide_point = Reg.Numb(sum+1, insert.size(),"-");
            divide_point += " -> ";
            
            if(quot_end_line){
                
                if(!commit) tem += "\"";
                quot_end_line = false;
                
            }//if(quot_end_line)
            
            if(commit){
                
                if(sum == 0){
                    
                    tem += "git commit -m \"";
                    tem += new Data().DataAbreviada(insert.size() > 1);
                    tem += " - ";
                    tem += new Hora(true).Timer();
                    
                    if(insert.size() == 1){
                        
                        tem += " -- Nesse COMMIT --> ";
                        
                    } else {//if(insert.size() == 1)
                        
                        tem += " -- Nesse COMMIT -- ";
                        tem += divide_point;
                        
                    }//if(insert.size() == 1)
                    
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
                        
                    }//case '"', '\''
                    
                    case '\\', '/' -> {
                        
                        tem += "/";
                        quot = true;
                        
                        amp = false;
                        
                    }//case '\\', '/'
                    
                    case ';', ',', '.', ':' -> {
                        
                        if(amp && i < insert.get(sum).length()-1){
                            
                            tem += insert.get(sum).charAt(i);
                            amp = false;
                            
                        }//if(amp && i < insert.get(sum).length()-1 &&...
                        
                        quot = true;
                        
                    }//case ';', ',', '.', ':'
                    
                    case '|', '-', '_' -> {
                        
                        if(amp){
                            
                            tem += insert.get(sum).charAt(i);
                            amp = false;
                            
                        }//if(amp)
                        
                        quot = true;
                        
                    }//case '|', '-', '_'
                    
                    case '!', '?' ->{}
                    
                    default -> {
                        
                        tem += insert.get(sum).charAt(i);
                        
                        quot = true;
                        
                        amp = true;
                        
                    }//default
                    
                }//switch(t.charAt(i))
                
            }//for(int i = 0; i < insert.get(sum).length(); i++)
            
            if(quot && !quot_end_line && (sum < insert.size() - 1 || !commit)){
                tem += "!";
            }
            
            if(commit && !quot && sum < insert.size()-1) tem += " --";
            if(commit && quot && sum < insert.size()-1) tem += " ->";
        
        }//for(int sum = 0; sum < insert.size(); sum++)
        
        if(quot && quot_end_line) tem += commit ? "'" : "\"";
        
        if(insert.size() == 1 && commit && !quot_end_line) tem += "!";
        
        if(commit) tem += "\"";
        
        return tem;
        
    }//Tem(String text)
    
    private static boolean gitCommit(){
        
        var logit = false;
        
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
        
        q.addAll(Arrays.asList(arqv));
        
        q.add(new Data().Load());
        
        for(String b : arqv){
            
            q.add(b + "_" + new Data().Load());
            q.add(b + " - " + new Data().Load());
            q.add(b.toUpperCase() + " - " + new Data().Load());
            
        }//for(String b : arqv)
        
        var ag = true;
        var dt = new Data().Load();
        
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

                var nom = dt;
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

                }//for(String g : arqv) - 1 de 2

                for(String g : arqv){

                    var dm = g.toUpperCase();
                    dm += " - ";
                    dm += nom;

                    q.add(dm);

                    if(dm.length() > tot) tot = dm.length();

                }//for(String g : arqv) - 2 de 2

                var node = dt;
                node += "-";
                node += Reg.Numb(h);
                node += "-";
                node += Reg.Numb(m);
                
                q.add(node);
                q.add(node.replace("-", "_"));

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
            
        }//if(nome.isBlank()) - 1 de 7
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var file = q.get(ss);
                file += ".txt";
                
                if(Arq.Exist(file)) nome = file;
                
                ss++;
                
            }while(ss > 0 && ss < q.size() && nome.isBlank());
            
        }//if(nome.isBlank()) - 2 de 7
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var file = "..\\";
                file += q.get(ss);
                file += ".txt";
                
                if(Arq.Exist(file)) nome = file;
                
                ss++;
                
            }while(ss > 0 && ss < q.size() && nome.isBlank());
            
        }//if(nome.isBlank()) - 3 de 7
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var file = "..\\..\\";
                file += q.get(ss);
                file += ".txt";
                
                if(Arq.Exist(file)) nome = file;
                
                ss++;
                
            }while(ss > 0 && ss < q.size() && nome.isBlank());
            
        }//if(nome.isBlank()) - 4 de 7
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var file = q.get(ss);
                file += ".TXT";
                
                if(Arq.Exist(file)) nome = file;
                
                ss++;
                
            }while(ss > 0 && ss < q.size() && nome.isBlank());
            
        }//if(nome.isBlank()) - 5 de 7
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var file = "..\\";
                file += q.get(ss);
                file += ".TXT";
                
                if(Arq.Exist(file)) nome = file;
                
                ss++;
                
            }while(ss > 0 && ss < q.size() && nome.isBlank());
            
        }//if(nome.isBlank()) - 6 de 7
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var file = "..\\..\\";
                file += q.get(ss);
                file += ".TXT";
                
                if(Arq.Exist(file)) nome = file;
                
                ss++;
                
            }while(ss > 0 && ss < q.size() && nome.isBlank());
            
        }//if(nome.isBlank()) - 7 de 7
        
        if(nome.isBlank()){
            
            logit = true;
            
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
        
        return logit;
        
    }//gitCommit()
    
    public static void Exec(){
        
        Data d = new Data();
        
        if(d.CompareTo(Reg.modify)){
            
            if(gitCommit()) controller.Init();
            
        } else {//if(d.CompareTo(Reg.modify))
            
            controller.Init();
            
        }//if(d.CompareTo(Reg.modify))
        
    }//Exec()
    
}