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
            
        }//for(String date : arqv) - 1 - 3
        
        for(String date : arqv){
            
            var t = folder + date + "_" + Reg.modify.Load() + ext;
            
            if(Arq.Exist(t) && Arq.Dir(t, false)) learn.add(new Arq(t).Read());
            
        }//for(String date : arqv) - 2 - 3
        
        for(String date : arqv){
            
            var t = folder + date + " - " + Reg.modify.Load() + ext;
            
            if(Arq.Exist(t) && Arq.Dir(t, false)) learn.add(new Arq(t).Read());
            
        }//for(String date : arqv) - 3 - 3
        
        var min = true;
        
        for(int x = h.Hour(); x >= 0; x--){
            
            for(int y = min ? h.Min() : 59; y >= 0; y--){
                
                var ms = folder;
                ms += Reg.Numb(x);
                ms += "-";
                ms += Reg.Numb(y);
                ms += ext;
                
                if(Arq.Exist(ms) && Arq.Dir(ms, false)){
                    learn.add(new Arq(ms).Read());
                }
                
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
            
            for(String date : arqv){
                
                var t = date + "_" + hs;
                
                if(Arq.Exist(t) && Arq.Dir(date, false)){
                    learn.add(new Arq(t).Read());
                }
                
            }//for(String date : arqv) - 1 - 2
            
            for(String date : arqv){
                
                var t = folder + date + " - " + hs;
                
                if(Arq.Exist(t) && Arq.Dir(date, false)){
                    learn.add(new Arq(t).Read());
                }
                
            }//for(String date : arqv) - 2 - 2
            
            for(int y = min ? h.Min() : 59; y >= 0; y--){
                
                var m1 = folder;
                m1 += Reg.modify.Load();
                m1 += "_";
                m1 += Reg.Numb(x);
                m1 += "-";
                m1 += Reg.Numb(y);
                m1 += ext;
                
                if(Arq.Exist(m1) && Arq.Dir(m1, false)){
                    
                    learn.add(new Arq(m1).Read());
                    
                }//if(Arq.Exist(m1) && Arq.Dir(m1, false)) - 1
                
                var m2 = folder;
                m2 += Reg.modify.Load();
                m2 += "-";
                m2 += Reg.Numb(x);
                m2 += Reg.Numb(y);
                m2 += ext;
                
                if(Arq.Exist(m2) && Arq.Dir(m2, false)){
                    
                    learn.add(new Arq(m2).Read());
                    
                }//if(Arq.Exist(m1) && Arq.Dir(m1, false)) - 2
                
                var m3 = folder;
                m3 += Reg.modify.Load();
                m3 += " - ";
                m3 += Reg.Numb(x);
                m3 += "h";
                m3 += Reg.Numb(y);
                m3 += ext;
                
                if(Arq.Exist(m3) && Arq.Dir(m3, false)){
                    
                    learn.add(new Arq(m3).Read());
                    
                }//if(Arq.Exist(m1) && Arq.Dir(m1, false)) - 3
                
            }//for(int y = min ? h.Min() : 59; y >= 0; y--)
            
            min = false;
            
        }//for(int x = h.Hour(); x >= 0; x--) - 2 - 2
        
        return learn;
        
    }//Commit(String folder)
    
    private static void Execute(){
        
        List<Read> tem = new ArrayList();
        
        for(Read r : Commit("")){
            if(r.Val() && !r.Read().trim().isBlank()) tem.add(r);
        }
        
        for(Read r : Commit("..\\")){
            if(r.Val() && !r.Read().trim().isBlank()) tem.add(r);
        }
        
        for(Read r : Commit("..\\..\\")){
            if(r.Val() && !r.Read().trim().isBlank()) tem.add(r);
        }
        
        if(tem.isEmpty()){
            
            controller.p2(new config());
            
        } else {
            
            controller.p2(new GitCommit(tem));
            
        }
        
    }//Execute()
    
    public static void Exec(){
        
        Data d = new Data();
        
        if(Reg.modify.Val() && d.CompareTo(Reg.modify) && Reg.java){
            
            Execute();
            
        } else if(
            Reg.modify.Val() && d.CompareTo(
                Reg.modify,
                true
            ) && Reg.java
        )
        {
            
            controller.p1m(new config());
            
        } else if(Reg.modify.Val()){
            
            controller.p1s(new config());
            
        } else {
            
            controller.Msg(
                "Exception",
                Arrays.asList(Reg.modify.Error().split("\n")),
                true
            );
            
        }
        
    }//Exec()
    
}//init