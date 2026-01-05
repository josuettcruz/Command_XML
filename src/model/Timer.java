/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import static java.lang.Math.round;

/**
 *
 * @author josue
 */
public class Timer {
    
    private long hours;
    private int min;
    private int sec;
    private String error;
    
    public Timer(long seconds){
        
        if(seconds < 0L){
            
            seconds = seconds - seconds*2L;
            
        }//if(seconds < 0)
        
        this.hours = round(seconds/3600);
        this.min = round(seconds/60) % 60;
        this.sec = (int)seconds % 60;
        this.error = "";
        
    }//Timer(int seconds)
    
    public Timer(String text){
        
        this.hours = 0;
        this.min = 0;
        this.sec = 0;
        this.error = "";
        
        String[] time = {"","",""};
        int arr = 0;
        
        for(int t = 0; t < text.length(); t++){
            
            char ds = text.charAt(t);
            
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
                    
                    time[arr] += ds;
                    
                }//cases
                
                case ':','-' -> {
                    
                    if(arr < time.length){
                        
                        arr++;
                        
                    } else {//if(arr < time.length)
                        
                        this.error = "Têm caracter extra!";
                        
                    }//if(arr < time.length)
                    
                }//case ':','-'
                
                default ->{
                    
                    this.error += "Caracter: \'";
                    this.error += ds;
                    this.error += "\' não aceito!\n";
                    
                }//default
                
            }//switch(ds)
            
        }//for(int t = 0; t < text.length(); t++)
        
        if(this.error.isBlank()){
            
            String[] temp = {"","",""};
            
            switch(arr){
                
                case 1 ->{
                    
                    temp[0] = "0";
                    temp[1] = time[0];
                    temp[2] = time[1];
                    
                }//case 2
                
                case 2 ->{
                    
                    temp[0] = time[0];
                    temp[1] = time[1];
                    temp[2] = time[2];
                    
                }//case 3
                
                default -> this.error = "Têm algo de errado!";
                
            }//switch(arr)
            
            Long hs = new Long(temp[0]);
            Num ms = new Num(temp[1]);
            Num ss = new Num(temp[2]);
            
            boolean hv = hs.Val() && !time[0].isBlank();
            boolean mv = ms.Val() && ms.Num() < 60 && temp[1].length() == 2;
            boolean sv = ss.Val() && ss.Num() < 60 && temp[2].length() == 2;
            
            if(hv && mv && sv){
                
                this.hours = hs.Num();
                this.min = ms.Num();
                this.sec = ss.Num();
                
            } else {//if(hv && mv && sv)
                
                this.error = "Formato de tempo inválido!";
                
            }//if(hv && mv && sv)
            
        }//if(this.error.isBlank())
        
    }//Timer(String text)
    
    public String Duraction(String sep){
        
        String txt = "";
        
        if(this.hours > 0){
            
            txt += this.hours;
            
            txt += sep;
            
        }//if(this.hours > 0)
            
        txt += Reg.Numb(this.min);
        
        txt += sep;
        
        txt += Reg.Numb(this.sec);
        
        return this.error.isBlank() ? txt : this.error;
        
    }//Duraction(String sep)
    
    public long Duraction(long sum){
        
        long init = sum;
        
        if(init < 0L){
            
            init = init - init*2;
            
        }//if(init < 0)
        
        long hour = this.hours * 3600L;
        
        long minute = this.min * 60L;
        
        return this.error.isBlank() ? init + hour + minute + this.sec : 0L;
        
    }//Duraction(long init)
    
    public long Duraction(){
        return this.Duraction(0l);
    }
    
    public int Day(){
        return round(this.hours / 24);
    }
    
    public int HourDay(){
        return round(this.hours % 24);
    }
    
    public long Hour(){
        return this.hours;
    }
    
    public int Min(){
        return this.min;
    }
    
    public int Sec(){
        return this.sec;
    }
    
    public boolean Val(){
        return this.error.isBlank();
    }
    
}