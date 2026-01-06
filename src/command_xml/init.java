/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command_xml;

import file.*;
import model.*;

/**
 *
 * @author josue
 */
public class init {
    
    private static String Tem(String text, boolean commit){
        
        final var cod = commit ? "'" : "\"";
        
        final var t = txt.text(text, true);
        
        var tem = "";
        
        var val_quot = true;
        var val_bar = true;
        var val_line = true;
        
        for(int i = 0; i < t.length(); i++){
            
            switch(t.charAt(i)){
                
                case '"', '\'' -> {
                    
                    if(val_quot){
                        
                        tem += commit ? "'" : "\"";
                        val_quot = false;
                        
                    }//if(val)
                    
                    val_bar = true;
                    val_line = true;
                    
                }//cases
                
                case '\\', '/' -> {
                    
                    if(val_bar){
                        
                        tem += "/";
                        val_bar = false;
                        
                    }//if(val)
                    
                    val_quot = true;
                    val_line = true;
                    
                }//case '\\', '/'
                
                case '\n' -> {
                    
                    if(val_line){
                        
                        tem += commit ? " - " : "\n";
                        val_line = false;
                        
                    }//if(val)
                    
                    val_quot = true;
                    val_bar = true;
                    
                }//case '\\', '/'
                
                default -> {
                    
                    tem += t.charAt(i);
                    
                    val_quot = true;
                    val_bar = true;
                    val_line = true;
                    
                }//default
                
            }
            
        }
        
        return tem;
        
    }//Tem(String text)
    
    public static void Print(){
        
        Reg.Print(new Hora(true).TimerGood(true), new Data().DataAbreviada(true));
        Reg.Print(Reg.categories, Reg.choose);
        Reg.Print(Reg.ide, Reg.http);
        
    }//Print()
    
    public static void Exec(){
        
        if(new Data().CompareTo(new Data(2026,1,6))){
            
            Exec_2026_01_06();
            
        } else {
            
            Print();
            
        }
        
    }//Exec()
    
    private static void Exec_2026_01_06(){
        
        var nome = "";
        var enter = true;
        
        if(Arq.Exist("..\\info.txt")){
            
            nome = "..\\info.txt";
            
        } else if(Arq.Exist("..\\title.txt")){
            
            nome = "..\\title.txt";
            
        } else if(Arq.Exist("..\\code.txt")){
            
            nome = "..\\code.txt";
            
        } else if(Arq.Exist("..\\..\\info.txt")){
            
            nome = "..\\..\\info.txt";
            
        } else if(Arq.Exist("..\\..\\title.txt")){
            
            nome = "..\\..\\title.txt";
            
        } else if(Arq.Exist("..\\..\\code.txt")){
            
            nome = "..\\..\\code.txt";
            
        } else {
            
            enter = false;
            
        }
        
        if(enter){
            
            Arq event = new Arq(nome);
            
            Read evt = event.Read();
            
            if(evt.Max() > 0){
                
                var git = "git commit -m \"";
                git += new Data().DataAbreviada(true);
                git += " - ";
                git += new Hora(false).TimerGood(true);
                git += " - ";
                
                git += Tem(evt.Read(),true);
                event.Save(Tem(evt.Read(),false));
                
                git += "\"";
                
                Reg.coppy(git);
                
                System.out.println(git);   
                
            } else {//if(evt.Max() > 0)
                
                System.err.print("Arquivo: \"" );
                System.err.print(nome.replace("..\\", ""));
                System.err.print("Arquivo: \"" );
                
            }//if(evt.Max() > 0)
            
        } else {//if(enter)
            
            Print();
            
        }//if(enter)
        
    }//Exec_2026_01_06()
        
    
}