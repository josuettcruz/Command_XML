/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

/**
 *
 * @author josue
 */
public class Exec {
    
    private String type;
    private String msg;
    private int code;
    
    private boolean no_error;
    
    public Exec(){
        
        this.type = "";
        this.msg = "";
        this.code = 0;
        
        this.no_error = true;
        
    }//Exec()
    
    public void com(String type, String msg, int code){
        
        this.type = type;
        this.msg = msg;
        this.code = code;
        
        this.no_error = false;
        
    }//com(String type, String msg, int code)
    
    public boolean Val(){
        
        return this.no_error;
        
    }//Val()
    
    public String Type(){
        
        return this.type;
        
    }//Type()
    
    public int Code(){
        
        return this.code;
        
    }//Code()
    
    public String Message(){
        
        return this.msg;
        
    }//Message()
    
}//Exec