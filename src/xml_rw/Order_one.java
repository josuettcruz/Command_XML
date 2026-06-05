/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

/**
 *
 * @author josue
 */
public class Order_one<cmd> {
    
    private cmd code;
    private String title;
    
    public Order_one(cmd code, String title){
        
        this.code = code;
        this.title = title;
        
    }//public Order_one

    public cmd Code() {return code;}

    public String Title() {return title;}
    
}//Order_one<cmd>