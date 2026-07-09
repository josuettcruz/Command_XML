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
    
    public static void Err(String message){

        if(Reg.java){

            System.err.println(new Hora(true).TimerGood(false));
            System.err.println(Hora.Good());
            System.err.println("Houve um erro inesperado!");
            System.err.println(message);

        }//if(Reg.java)

        System.exit(0);
        
    }//Err(String message)
    
    public static void Init(){
        
        controller.p1s(new config());
    
    }//Action()
    
}//Action