/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command_xml;

import file.Arq;
import file.Read;

import model.Data;
import model.Hora;
import model.Reg;

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
    
    private static void Play(){
        
        controller.p1m(new config());
        
    }//Play()
    
    private static List<Read> Commit(String folder){
        
        final String[] arqv = {
            "run",
            "code",
            "title",
            "info",
            "doc",
            "arq",
            "arquivo",
            "projeto",
            "documento",
            "document"
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
    
    private static void Execute(){
        
        String[] folder = {
            "_" + Reg.modify.Load(),
            Reg.modify.Load(),
            "commit_" + Reg.modify.Load(),
            "git_commit",
            "git-commit"
        };
        
        List<Read> tem = new ArrayList();
        
        for(String j : folder){
            
            for(Read r : Commit("\\" + j + "\\"))
            {if(r.Val() && !r.Read().trim().isBlank()) {tem.add(r);}}
            
        }//for(String j : folder)
        
        for(Read r : Commit(""))
        {if(r.Val() && !r.Read().trim().isBlank()) {tem.add(r);}}
        
        for(String j : folder){
            
            for(Read r : Commit("..\\" + j + "\\"))
            {if(r.Val() && !r.Read().trim().isBlank()) {tem.add(r);}}
            
        }//for(String j : folder)
        
        for(Read r : Commit("..\\"))
        {if(r.Val() && !r.Read().trim().isBlank()) {tem.add(r);}}
        
        for(String j : folder){
            
            for(Read r : Commit("..\\..\\" + j + "\\"))
            {if(r.Val() && !r.Read().trim().isBlank()) {tem.add(r);}}
            
        }//for(String j : folder)
        
        for(Read r : Commit("..\\..\\"))
        {if(r.Val() && !r.Read().trim().isBlank()) {tem.add(r);}}
        
        if(tem.isEmpty()) {Play();} else {controller.p2(new GitCommit(tem));}
        
    }//Execute()
    
    public static void Exec(){
        
        Data d = new Data();
        
        controller.Position(240, 35, 585, 650);
        
        if(Reg.modify.Val() && d.CompareTo(Reg.modify) && Reg.java){
            
            Execute();
            
        } else {
            
            Play();
            
        }
        
    }//Exec()
    
}//init