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
    
    private List<String> msg(){
        
        List<String> val = new ArrayList();
        
        val.add("CLASSE: \"Action\"");
        val.add("PACOTE: \"command_xml\"");
        val.add("");
        val.add("Todas as novas funcionalidades do projeto,");
        val.add("deverão ficar nessa classe!");
        
        return val;
        
    }// msg()
    
    public Action(){
        
        controller.p1s(new config());
        System.out.println("_".repeat(this.msg().get(0).length()));
        
        var nol = false;
        
        for(String p : this.msg()){
            
            if(p.isBlank()){
                
                nol = true;
            
            } else {//if(p.isBlank())
                
                if(nol){
                    
                    System.out.println();
                    System.out.println("_".repeat(p.length()));
                    
                    nol = false;
                    
                }//if(nol)
                
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
        
    }//Action()
    
}//Action