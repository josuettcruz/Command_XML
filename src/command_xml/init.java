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
    
    private static void Form(){
        
        controller.Msg();
        
    }//Form()
    
    /*public static List<String> Print(int tab){
        
        if(tab < 0) tab = tab - tab*2;
        
        if(tab == 0 || tab > 40) tab = 40;
        
        var t = "run: ";
        
        var addition = 1;
        addition += t.length();
        addition += Reg.ide.length();
        
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
                t + "Última ATUALIZAÇÃO",
                Reg.modify.DataCompleta(true),
                tab
            )
        );
        
        println.add(
            Reg.Tab(
                t + "RESOLUÇÃO DE TELA",
                Toolkit.getDefaultToolkit().getScreenSize().width
                + "x"
                + Toolkit.getDefaultToolkit().getScreenSize().height
                + "p",
                tab
            )
        );
        
        return println;
        
    }*/
    
    private static String Tem(String text, boolean commit){
        
        List<String> insert = new ArrayList();
        
        char[] ex = {
            '-',
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
            '9',
            '!',
            '?',
            '.',
            ':',
            ';',
            ','
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
            
            var dol = false;
            
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
                    tem += new Data().DataAbreviada(true);
                    tem += " - ";
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
                        
                        dol = false;
                        
                    }//case '"', '\''
                    
                    case '\\', '/' -> {
                        
                        tem += "/";
                        quot = true;
                        
                        amp = false;
                        
                        dol = false;
                        
                    }//case '\\', '/'
                    
                    case '.', ':' -> {
                        
                        if(amp && i < insert.get(sum).length()-1){
                            
                            tem += ":";
                            amp = false;
                            
                            dol = true;
                            
                        }//if(amp && i < insert.get(sum).length()-1)
                        
                        quot = true;
                        
                    }//case '.', ':'
                    
                    case '!', '?' ->{}
                    
                    case ';', ',' -> {
                        
                        if(amp && i < insert.get(sum).length()-1 && !quot_end_line){
                            
                            tem += ",";
                            amp = false;
                            
                        }//if(amp && i < insert.get(sum).length()-1 && !quot_end_line)
                        
                        quot = true;
                        
                        dol = false;
                        
                    }//case ';', ','
                    
                    case '|',
                        '_',
                        '[',
                        ']',
                        '{',
                        '}',
                        '(',
                        ')',
                        '<',
                        '>',
                        '=',
                        '+',
                        '-',
                        'º',
                        'ª',
                        '§' -> {
                        
                        if(amp){
                            
                            tem += insert.get(sum).charAt(i);
                            amp = false;
                            
                        }//if(amp)
                        
                        quot = true;
                        
                        dol = false;
                        
                    }//cases
                    
                    default -> {
                        
                        tem += dol
                            ? insert.get(sum).toUpperCase().charAt(i)
                            : insert.get(sum).charAt(i);
                        
                        quot = true;
                        
                        amp = true;
                        
                        dol = false;
                        
                    }//default
                    
                }//switch(t.charAt(i))
                
            }//for(int i = 0; i < insert.get(sum).length(); i++)
            
            if(quot && !quot_end_line) tem += "!";
            
            if(commit && !quot && sum < insert.size()-1) tem += " --";
        
        }//for(int sum = 0; sum < insert.size(); sum++)
        
        if(quot && quot_end_line) tem += commit ? "'" : "\"";
        
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
                file += ".txt";
                
                if(Arq.Exist(file)) nome = file;
                
                ss++;
                
            }while(ss > 0 && ss < q.size() && nome.isBlank());
            
        }//if(nome.isBlank()) - 1
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var file = "..\\";
                file += q.get(ss);
                file += ".txt";
                
                if(Arq.Exist(file)) nome = file;
                
                ss++;
                
            }while(ss > 0 && ss < q.size() && nome.isBlank());
            
        }//if(nome.isBlank()) - 2
        
        if(nome.isBlank()){
            
            ss = 0;
            
            do{
                
                var file = "..\\..\\";
                file += q.get(ss);
                file += ".txt";
                
                if(Arq.Exist(file)) nome = file;
                
                ss++;
                
            }while(ss > 0 && ss < q.size() && nome.isBlank());
            
        }//if(nome.isBlank()) - 3
        
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
            
            if(gitCommit()) Form();
            
        } else {//if(d.CompareTo(Reg.modify))
            
            Form();
            
        }//if(d.CompareTo(Reg.modify))
        
    }//Exec()
    
}