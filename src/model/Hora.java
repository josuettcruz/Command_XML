/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.time.LocalTime;

/**
 *
 * @author josue
 */
public class Hora {
    
    private LocalTime hora;
    private String error;
    
    public Hora(LocalTime hora){
        
        this.hora = hora;
        this.error = "";
        
    }//Hora(LocalTime hora)
    
    public Hora(boolean second){
        
        this.error = "";
        
        if(second){
            
            this.hora = LocalTime.now();
            
        } else {//if(now)
            
            LocalTime h = LocalTime.now();
            
            this.hora = LocalTime.of(h.getHour(), h.getMinute());
            
        }//if(now)
        
    }//Hora(boolean now)
    
    public Hora(String t){
        
        this.error = "";
        
        String hour = "";
        String minute = "";
        String second = "";
        int cont = 1;
        
        for(int p = 0; p < t.length(); p++){
            
            var ds = t.charAt(p);
            
            switch(ds){
                
                case '1', 
                     '2', 
                     '3', 
                     '4', 
                     '5', 
                     '6', 
                     '7', 
                     '8', 
                     '9', 
                     '0' -> {
                    
                    switch(cont){
                        
                        case 1 -> hour += ds;
                        case 2 -> minute += ds;
                        case 3 -> second += ds;
                        
                    }//switch(cont)
                    
                }//cases
                
                case ':', '-' -> {
                    
                    if(cont <= 3){
                        
                        cont++;
                        
                    } else {//if(cont <= 3)
                        
                        if(!this.error.isBlank()){this.error += "\n";}
                        this.error += "Caracter: \'";
                        this.error += ds;
                        this.error += "\' é inválido!";
                        
                    }//if(cont <= 3)
                    
                }//case ':', '-'
                
                default -> {
                    
                    if(!this.error.isBlank()){this.error += "\n";}
                    this.error += "Caracter: \'";
                    this.error += ds;
                    this.error += "\' é inválido!";
                    
                }//default
                
            }//switch(t.charAt(p))
            
        }//for(int p = 0; p < t.length(); p++)
        
        if(this.error.isBlank()){
            
            Num hs = new Num(hour);
            Num ms = new Num(minute);
            Num s = new Num(second);
            
            boolean hv = hs.Val() && hs.Num() < 24;
            boolean mv = ms.Val() && ms.Num() < 60;
            
            if(hv && mv && s.Val() && s.Num() < 60){
                
                this.hora = LocalTime.of(hs.Num(), ms.Num(), s.Num());
                
            } else if(hv && mv && cont == 2){//if(hv && mv)
                
                this.hora = LocalTime.of(hs.Num(), ms.Num());
                
            } else {//if(hv && mv)
                
                this.hora = LocalTime.of(0, 0);
                this.error = "Hora Inválida!";
                
            }//if(hv && mv)
            
        } else {//if(this.error.isBlank())
            
            this.hora = LocalTime.of(0, 0);
            
        }//if(this.error.isBlank())
        
    }//public Hora(String t)
    
    public String Err(){
        
        return this.error;
    
    }//Err()
    
    public boolean Val(){
        
        return this.error.isBlank();
    
    }//Val()
    
    public LocalTime getHora(){
        
        return this.hora;
    
    }//getHora()
    
    public String Good(String morning, String after, String night){
        
        final String[] good = {morning, after, night};
        
        int txt;
        
        if(this.hora.getHour() == 18 && this.hora.getMinute() > 30){
            
            txt = 2;
            
        } else if(this.hora.getHour() > 18){//if
            
            txt = 2;
            
        } else if(this.hora.getHour() < 12){//if
            
            txt = 0;
            
        } else {//if
            
            txt = 1;
            
        }//if
        
        return this.error.isBlank() ? good[txt] : this.error;
        
    }//Good(String morning, String after, String night)
    
    public String Good(String morning, String after){
        
        return this.Good(morning, after, after);
        
    }//Good(String morning, String after)
    
    public String Good(){
        
        return this.Good("Bom Dia", "Boa Tarde", "Boa Noite") + "!";
        
    }//Good()
    
    private String TimerGood(boolean print, String sep, String space){
        
        String txt = "";
        
        int hs = this.hora.getHour();
        int m = this.hora.getMinute();
        int s = this.hora.getSecond();
        int h;
        
        if(hs > 12){//hs
            
            h = hs - 12;
            
        } else if(hs == 0){//hs
            
            h = 12;
            
        } else {//hs
            
            h = hs;
            
        }//hs
        
        txt += Reg.Numb(h);
        
        txt += sep;
        
        txt += Reg.Numb(m);
        
        if(s > 0){
            
            txt += sep;
        
            txt += Reg.Numb(s);
            
        }//if(s > 0)
        
        if(print){
            
            txt += space;
            
            txt += hs < 12 ? "AM" : "PM";
            
        }//if(after)
        
        return this.error.isBlank() ? txt : this.error;
        
    }//TimerGood(boolean print, String sep, String space)
    
    public String TimerGood(String sep, String space){
        
        return this.TimerGood(true, sep, space);
        
    }//TimerGood(String sep, String space)
    
    public String TimerGood(boolean print, String sep){
        
        return this.TimerGood(print, sep, " ");
        
    }//TimerGood(String sep, String space)
    
    public String TimerGood(boolean print){
        
        return this.TimerGood(print, ":", " ");
        
    }//TimerGood(boolean print)
    
    public String TimerGood(String space){
        
        return this.TimerGood(true, ":", space);
        
    }//TimerGood(String space)
    
    public String Timer(String sep){
        
        int h = this.hora.getHour();
        int m = this.hora.getMinute();
        int s = this.hora.getSecond();
        
        var txt = Reg.Numb(h);
        
        txt += sep;
        
        txt += Reg.Numb(m);
        
        if(s > 0){
            
            txt += sep;
            
            txt += Reg.Numb(s);
            
        }//if(s > 0)
        
        return this.error.isBlank() ? txt : this.error;
        
    }//Timer(String sep)
    
    public String Timer(){
        
        return this.Timer(":");
        
    }//Timer()
    
}