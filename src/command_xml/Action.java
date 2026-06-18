/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package command_xml;

import form.controller;
import xml_mf.config;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class Action {
    
    public final static void Enter(){new Action();}
    
    /* 18/06/2026                 **
    ** Removido após a preparação */
    private List<String> msg(){
        
        List<String> val = new ArrayList();
        
        val.add("CLASSE: \"Action\"");
        val.add("PACOTE: \"command xml\"".toUpperCase());
        val.add("");
        val.add("Todas as novas funcionalidades do projeto,");
        val.add("deverão ficar nessa classe!");
        
        return val;
        
    }//msg()
    
    private void message(){
        
        System.out.println("-".repeat(this.msg().get(0).length()));
        
        var nol = false;
        var pol = 0;
        
        for(String p : this.msg()){
            
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
                this.msg().get(
                    this.msg().size()-1
                ).length()
            )
        );
        
        System.out.println();
        
    }/* message()                          **
    **  Essas linhas deverão ser removidas **
    **  no utilizar da classe              **
    **  18/06/2026                         */
    
    public Action(){
        
        this.message(); /* Excluir junto com a linha de cima! */
        controller.p1s(new config());
    
    }//Action()
    
}//Action