/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command_xml;

import file.Arq;
import file.Read;

import model.*;

import xml_mf.config;
import xml_mf.GitCommit;

import form.controller;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class init {
    
    public static void Play(){
        
        controller.p1s(new config());
        
    }//Play()
    
    private static String dat(String text, boolean into){
        
        var val = into ? "\"" : "";
        
        var sum = 0;
        var loop = true;
        var tem = false;
        
        do{
            
            switch(text.charAt(sum)){
                
                case '.' ->{
                    
                    if(tem){
                        
                        loop = false;
                        
                    } else {//if(tem)
                        
                        tem = true;
                        
                    }//if(tem)
                    
                }//case '.'
                
                default -> {
                    
                    if(tem) val += text.toUpperCase().charAt(sum);
                
                }//default
                
            }//switch(ds)
            
            sum++;
            
        }while(loop && sum > 0 && sum < text.length());
        
        if(into) val += "\"";
        
        return val;
        
    }//dat(String text, boolean into)
    
    private static void Println(boolean into){
        
        var d = new Data();
        
        var max = Reg.ide.length();
        max += 1;
        
        if(into){
            
            var dm = d.DataCompleta("#");
            var dn = dm.indexOf("#");
            
            Reg.Print(dm.substring(0, dn) + ",", dm.substring(dn+1) + "!", max);
            
        }//if(into)
        
        System.out.println(
            new Hora(true).TimerGood(
                false,
                Reg.Tab("--", max)
            )
        );
        
        if(into){
            
            var note = !d.CompareTo(Reg.modify);
            
            if(note) Reg.Print("", "", max);
            
            Reg.Print(Reg.categories, Reg.choose, max);
            
            var Reg_create = "Esse projeto começou ";
            Reg_create += Reg.create.DataCompleta(true);
            
            Reg.Print(Reg.ide, Reg_create, max);
            
            Reg.Print("", "", max);
            
            if(note){
                
                var Reg_modify = "A última atualização desse projeto foi ";
                Reg_modify += Reg.modify.DataCompleta(true);
                
                Reg.Print(
                    new Link(Reg.http).page(true),
                    Reg_modify,
                    max
                );
                
                Reg.Print("", "", max);
                
            }//if(!d.CompareTo(Reg.modify))
            
        }//if(into)
        
        Reg.Print("class", "carregarFonte", max);
        Reg.Print("package", "model", max);
        
        if(into) Reg.Print("", "", max);
        
        Reg.Print(
            dat(carregarFonte.StackOverflow().page(true), into),
            carregarFonte.StackOverflow().getLink(),
            max
        );
        
        if(into) Reg.Print("", "", max);
        
        Reg.Print(
            dat(carregarFonte.Reddit().page(true), into),
            carregarFonte.Reddit().getLink(),
            max
        );
        
        System.out.println();
        
    }//Println(boolean into)
    
    public static void Println(){init.Println(false);}
    
    private static List<Read> Commit(String folder){
        
        final String[] arqv = {
            "run",
            "code"
        };
        
        final String ext = ".txt";
        
        Hora h = new Hora(true);
        
        List<Read> learn = new ArrayList();
        
        for(String date : arqv){
            
            var t = folder + date + ext;
            
            if(Arq.Exist(t) && Arq.Dir(t, false)) learn.add(new Arq(t).Read());
            
        }//for(String date : arqv)
        
        var min = true;
        
        for(int x = h.Hour(); x >= 0; x--){
            
            for(int y = min ? h.Min() : 59; y >= 0; y--){
                
                var ms = folder;
                ms += Reg.Numb(x);
                ms += "-";
                ms += Reg.Numb(y);
                ms += ext;
                
                if(Arq.Exist(ms) && Arq.Dir(ms, false))
                {learn.add(new Arq(ms).Read());}
                
            }//for(int y = min ? h.Min() : 59; y >= 0; y--)
            
            min = false;
            
        }//for(int x = h.Hour(); x >= 0; x--) - 1 - 2
        
        min = true;
        
        for(int x = h.Hour(); x >= 0; x--){
            
            var hs = folder;
            hs += Reg.modify.Load();
            hs += ext;
            
            if(Arq.Exist(hs) && Arq.Dir(hs, false))
            {learn.add(new Arq(hs).Read());}
            
            for(int y = min ? h.Min() : 59; y >= 0; y--){
                
                var m1 = folder;
                m1 += Reg.modify.Load();
                m1 += "_";
                m1 += Reg.Numb(x);
                m1 += "-";
                m1 += Reg.Numb(y);
                m1 += ext;
                
                if(Arq.Exist(m1) && Arq.Dir(m1, false))
                {learn.add(new Arq(m1).Read());}
                
                var m2 = folder;
                m2 += Reg.modify.Load();
                m2 += "-";
                m2 += Reg.Numb(x);
                m2 += "-";
                m2 += Reg.Numb(y);
                m2 += ext;
                
                if(Arq.Exist(m2) && Arq.Dir(m2, false)){
                    
                    learn.add(new Arq(m2).Read());
                    
                }//if(Arq.Exist(m2) && Arq.Dir(m2, false))
                
                for(String ms : arqv){
                    
                    var m3 = folder;
                    m3 += "jar - ";
                    m3 += Reg.modify.Load();
                    m3 += " - ";
                    m3 += Reg.Numb(x);
                    m3 += "h";
                    m3 += Reg.Numb(y);
                    m3 += "m - ";
                    m3 += ms;
                    m3 += ext;
                    
                    if(Arq.Exist(m3) && Arq.Dir(m3, false))
                    {learn.add(new Arq(m3).Read());}
                    
                }//for(String ms : arqv)
                
            }//for(int y = min ? h.Min() : 59; y >= 0; y--)
            
            min = false;
            
        }//for(int x = h.Hour(); x >= 0; x--)
        
        return learn;
        
    }//Commit(String folder)
    
    private static boolean exe(Read t){
        
        final char[] exclude = {
            '_',
            '-',
            '[',
            ']',
            '{',
            '}',
            '(',
            ')',
            '|',
            '/',
            '\\',
            '\'',
            '"'
        };
        
        var sum = 0;
        
        for(String p : txt.phrase(t.Read(), exclude)) sum += p.length();
        
        return sum >= 5 && t.Val();
        
    }//exe(Read t)
    
    private static void Execute(){
        
        String[] folder = {
            "_" + Reg.modify.Load(),
            "git_commit_" + Reg.modify.Load(),
            "git_commit"
        };
        
        List<Read> tem = new ArrayList();
        
        for(Read r : Commit(""))
        {if(exe(r)) tem.add(r);}
        
        for(String j : folder){
            
            for(Read r : Commit("\\" + j + "\\")) if(exe(r)) tem.add(r);
            
        }//for(String j : folder)
        
        for(String j : folder){
            
            for(Read r : Commit("..\\" + j + "\\")) if(exe(r)) tem.add(r);
            
        }//for(String j : folder)
        
        for(Read r : Commit("..\\")) if(exe(r)) tem.add(r);
        
        for(String j : folder){
            
            for(Read r : Commit("..\\..\\" + j + "\\")) if(exe(r)) tem.add(r);
            
        }//for(String j : folder)
        
        for(Read r : Commit("..\\..\\")) if(exe(r)) tem.add(r);
        
        if(tem.isEmpty()){
            
            Play();
        
        } else {//if(tem.isEmpty())
            
            controller.p2(new GitCommit(tem));
        
        }//if(tem.isEmpty())
        
    }//Execute()
    
    public static void Exec(){
        
        if(Reg.java) Println(true);
        
        controller.Position(256, 72, 600, 600);
        
        Data d = new Data();
        
        if(Reg.modify.Val() && d.CompareTo(Reg.modify) && Reg.java){
            
            Execute();
            
        } else {//if(Reg.modify.Val() && d.CompareTo(Reg.modify) && Reg.java)
            
            Play();
            
        }//if(Reg.modify.Val() && d.CompareTo(Reg.modify) && Reg.java)
        
    }//Exec()
    
}//init