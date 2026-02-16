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
        
        try{
            
            this.hora = hora;
            this.error = "";
            
        }catch(Exception err){
            
            this.hora = LocalTime.of(0, 0);
            this.error = err.getMessage();
            
        }
        
    }//Hora(LocalTime hora)
    
    public Hora(int h, int m, int s){
        
        try{
            
            this.hora = LocalTime.of(h, m, s);
            this.error = "";
            
        }catch(Exception err){
            
            this.hora = LocalTime.of(0, 0);
            this.error = err.getMessage();
            
        }
        
    }//Hora(int h, int m, int s)
    
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
                        
                        if(!this.error.isBlank()) this.error += "\n";
                        this.error += "Caracter: \'";
                        this.error += ds;
                        this.error += "\' é inválido!";
                        
                    }//if(cont <= 3)
                    
                }//case ':', '-'
                
                default -> {
                    
                    if(!this.error.isBlank()) this.error += "\n";
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
    
    public LocalTime getHora(){return this.hora;}
    
    public int Hour(){return this.hora.getHour();}
    
    public int Min(){return this.hora.getMinute();}
    
    public int Sec(){return this.hora.getSecond();}
    
    public String Err(){return this.error;}
    
    public boolean Val(){return this.error.isBlank();}
    
    public String Timer(){
        
        int h = this.hora.getHour();
        int m = this.hora.getMinute();
        int s = this.hora.getSecond();
        
        var txt = Reg.Numb(h);
        
        txt += ":";
        
        txt += Reg.Numb(m);
        
        if(s > 0){
            
            txt += ":";
            
            txt += Reg.Numb(s);
            
        }//if(s > 0)
        
        return this.error.isBlank() ? txt : this.error;
        
    }//Timer(String sep)
    
    public String TimerGood(boolean after, String space, String sep){
        
        String txt = "";
        
        var hs = this.hora.getHour();
        var m = this.hora.getMinute();
        var s = this.hora.getSecond();
        var g = hs < 12 ? "AM" : "PM";
        int h;
        
        if(hs > 12){//hs
            
            h = hs - 12;
            
        } else if(hs == 0){//hs
            
            h = 12;
            
        } else {//hs
            
            h = hs;
            
        }//hs
        
        if(!after){
            
            txt += g;
            txt += space;
            
        }//if(!after)
        
        txt += Reg.Numb(h);
        
        txt += sep;
        
        txt += Reg.Numb(m);
        
        if(s > 0){
            
            txt += sep;
        
            txt += Reg.Numb(s);
            
        }//if(s > 0)
        
        if(after){
            
            txt += space;
            txt += g;
            
        }//if(after)
        
        return this.error.isBlank() ? txt : this.error;
        
    }//TimerGood(boolean print, String sep, String space)
    
    public String TimerGood(boolean after, String space){
        
        return this.TimerGood(after, space, ":");
        
    }//public String TimerGood(boolean after, String sep)
    
    public String TimerGood(boolean after){
        
        return this.TimerGood(after, " ", ":");
        
    }//public String TimerGood(boolean after)
    
    public boolean Compare(Hora h){
        
        boolean act = false;
        
        if(this.Hour() > h.Hour()) act = true;
        
        if(this.Hour() == h.Hour()){
            
            if(this.Min() > h.Min()) act = true;
            
            if(this.Min() == h.Min()) act = this.Sec() >= h.Sec();
            
        }//if(h.Hour() == this.Hour())
        
        return act;
        
    }//Compare(Hora h)
    
    public static String Good(){
        
        LocalTime t = LocalTime.now();
        
        final String[] good = {"m Dia", "a Tarde", "a Noite"};
        
        int txt;
        
        if(t.getHour() == 18 && t.getMinute() > 30){
            
            txt = 2;
            
        } else if(t.getHour() > 18){//if
            
            txt = 2;
            
        } else if(t.getHour() >= 12){//if
            
            txt = 1;
            
        } else {//if
            
            txt = 0;
            
        }//if
        
        return "Bo" + good[txt] + "!";
        
    }//Good()
    
}//Hora