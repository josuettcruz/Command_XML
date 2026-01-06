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
            
            Read evt = new Arq(nome).Read();
            
            if(evt.Max() > 0){
                
                var git = "git commit -m \"";
                git += new Data().DataAbreviada(true);
                git += " - ";
                
                if(evt.Max() == 1){
                    
                    git += txt.text(evt.Read(), true).replace("\"", "'");
                    
                } else {//if(evt.Max() == 1)
                    
                    var sum = 1;
                    var loop = true;
                    
                    do{
                        
                        var node = txt.text(evt.Read(sum), true);
                        
                        if(!node.isBlank()){
                            
                            git += node.replace("\"", "'");
                            
                            new Arq(nome).Save(node.replace("\"", "'"));
                            
                            loop = false;
                            
                        }//if(!node.isBlank())
                        
                        sum++;
                        
                    }while(sum > 1 && sum <= evt.Max() && loop);
                    
                }//if(evt.Max() == 1)
                
                git += "\"";
                
                Reg.coppy(git);
                
                System.out.println(git);
;                
                
            } else {
                
                System.err.print("Arquivo: \"" );
                System.err.print(nome.replace("..\\", ""));
                System.err.print("Arquivo: \"" );
                
            }
            
        } else {//if(enter)
            
            Print();
            
        }//if(enter)
        
    }//Exec_2026_01_06()
        
    
}