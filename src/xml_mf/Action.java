/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import form.controller;
import model.Reg;
import model.Data;
import model.Hora;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class Action {
    
    /* 22/06/2026                 **
    ** Remover após a preparação  */
    private final static List<String> msg(){
        
        final int tab = 10;
        
        var c1 = new Hora(true).Compare(new Hora(8,39,15));
        var c2 = new Hora(18,0,30).Compare(new Hora(true));
        var c = c1 && c2;
        
        List<String> val = new ArrayList();
        
        if(c) val.add(Reg.Tab("Data:", new Data().DataAbreviada(true), tab));
        val.add(Reg.Tab("CLASSE:", "Action", tab));
        val.add(Reg.Tab("PACOTE:", "xml mf".toUpperCase(), tab));
        if(!c) val.add(Reg.Tab("Data:", new Data().DataAbreviada(true), tab));
        
        val.add("");
        val.add("Todas as novas funcionalidades do projeto,");
        val.add("deverão ficar nessa classe!");
        
        return val;
        
    }//msg()
    
    private static void message(){
        
        System.out.println("-".repeat(msg().get(0).length()));
        
        var nol = false;
        var pol = 0;
        
        for(String p : msg()){
            
            if(p.isBlank()){
                
                nol = true;
            
            } else {//if(p.isBlank())
                
                if(nol){
                    
                    if(pol > 0)System.out.println("-".repeat(pol));
                    System.out.println();
                    System.out.println("-".repeat(p.length()));
                    
                    nol = false;
                    pol = 0;
                    
                } else {
                    
                    pol = p.length();
                    
                }
                
                System.out.println(p);
                
            }//if(p.isBlank())
            
        }//for(String p : this.msg())
        
        System.out.println(
            "-".repeat(
                msg().get(
                    msg().size()-1
                ).length()
            )
        );
        
        System.out.println();
        
    }/* message()                          **
    **  Essas linhas deverão ser removidas **
    **  no utilizar da classe              **
    **  22/06/2026                         */
    
    public static void Init(){
        
        /* Excluir junto com a linha de cima! */
        message(); /*22/06/2026*/
        
        controller.p1s(new config());
    
    }//Action()
    
}//Action