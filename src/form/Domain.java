/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

/**
 *
 * @author josue
 */
public class Domain {
    
    private String text;
    private int index;
    private boolean selected;
    
    public Domain(int index, String text){
        
        this.index = index;
        this.text = text;
        this.selected = false;
        
    }//Domain(int index, String text)
    
    public Domain(int index, String text, boolean selected){
        
        this.index = index;
        this.text = text;
        this.selected = selected;
        
    }//Domain(int index, String text, boolean selected)
    
    public boolean Select(){return this.selected;}
    
    public int index(){return this.index;}
    
    public String Text(){return this.text;}
    
}//Domain