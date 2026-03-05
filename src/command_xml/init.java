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
import java.util.Arrays;

/**
 *
 * @author josue
 */
public class init {
    
    private static List<Read> Commit(String folder){
        
        final String[] arqv = {"code", "title", "info", "run"};
        final String ext = ".txt";
        
        Hora h = new Hora(false);
        
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
                
                if(
                    Arq.Exist(ms) && Arq.Dir(ms, false)
                ) learn.add(
                    new Arq(ms).Read()
                );
                
            }//for(int y = min ? h.Min() : 59; y >= 0; y--)
            
            min = false;
            
        }//for(int x = h.Hour(); x >= 0; x--) - 1 - 2
        
        min = true;
        
        for(int x = h.Hour(); x >= 0; x--){
            
            var hs = folder;
            hs += Reg.modify.Load();
            hs += ext;
            
            if(Arq.Exist(hs) && Arq.Dir(hs, false)){
                
                learn.add(new Arq(hs).Read());
                
            }//if(Arq.Exist(hs) && Arq.Dir(hs, false))
            
            for(int y = min ? h.Min() : 59; y >= 0; y--){
                
                var md = folder;
                md += Reg.modify.Load();
                md += "_";
                md += Reg.Numb(x);
                md += "-";
                md += Reg.Numb(y);
                md += ext;
                
                if(Arq.Exist(md) && Arq.Dir(md, false)){
                    
                    learn.add(new Arq(md).Read());
                    
                }//if(Arq.Exist(m1) && Arq.Dir(m1, false))
                
            }//for(int y = min ? h.Min() : 59; y >= 0; y--)
            
            min = false;
            
        }//for(int x = h.Hour(); x >= 0; x--)
        
        return learn;
        
    }//Commit(String folder)
    
    private static void Execute(){
        
        String[] folder = {
            "_command_xml_" + new Data().Load(),
            "command_xml_" + new Data().Load(),
            "commit_" + new Data().Load(),
            "commit-" + new Data().Load(),
            new Data().Load(),
            "_" + new Data().Load(),
            "_command_xml",
            "_commit",
            "_git_commit",
            "commit",
            "git_commit",
            "git_commit_m"
        };
        
        List<Read> tem = new ArrayList();
        
        for(String j : folder){
            
            for(Read r : Commit("\\" + j + "\\"))
            {if(r.Val() && !r.Read().trim().isBlank()) tem.add(r);}
            
        }//for(String j : folder)
        
        for(Read r : Commit(""))
        {if(r.Val() && !r.Read().trim().isBlank()) tem.add(r);}
        
        for(String j : folder){
            
            for(Read r : Commit("..\\" + j + "\\"))
            {if(r.Val() && !r.Read().trim().isBlank()) tem.add(r);}
            
        }//for(String j : folder)
        
        for(Read r : Commit("..\\"))
        {if(r.Val() && !r.Read().trim().isBlank()) tem.add(r);}
        
        for(String j : folder){
            
            for(Read r : Commit("..\\..\\" + j + "\\"))
            {if(r.Val() && !r.Read().trim().isBlank()) tem.add(r);}
            
        }//for(String j : folder)
        
        for(Read r : Commit("..\\..\\"))
        {if(r.Val() && !r.Read().trim().isBlank()) tem.add(r);}
        
        if(tem.isEmpty()){
            
            controller.p2(new config());
            
        } else {
            
            controller.p2(new GitCommit(tem));
            
        }
        
    }//Execute()
    
    public static void Exec(){
        
        Data d = new Data();
        
        controller.Position(240, 35, 585, 650);
        
        if(Reg.modify.Val() && d.CompareTo(Reg.modify) && Reg.java){
            
            Execute();
            
        } else if(Reg.modify.Val() && d.CompareTo(Reg.modify,true)){//if(Reg...
            
            controller.p1m(new config());
            
        } else if(Reg.modify.Val()){//if(Reg.modify.Val()...
            
            controller.p1s(new config());
            
        } else {//if(Reg.modify.Val()...
            
            List<String> print = new ArrayList();
            print.addAll(Arrays.asList(Reg.modify.Error().split("\n")));
            
            var note = controller.Msg(d.DataAbreviada(true),print, true);
            
            if(Reg.java) for(String t : print) System.err.println(t);
            
            if(!note) System.exit(0);
            
        }//if(Reg.modify.Val()...
        
    }//Exec()
    
}//init