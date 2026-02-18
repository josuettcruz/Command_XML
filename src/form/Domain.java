/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

import model.txt;

/**
 *
 * @author josue
 */
public class Domain {
    
    private boolean selected;
    private String text;
    private int index;
    
    public Domain(int index, String text){
        
        this.selected = false;
        this.index = index;
        this.text = text;
        
    }//Domain(int index, String text)
    
    public void Select(boolean select){this.selected = select;}
    
    public boolean Select(){return this.selected;}
    
    public int index(){return this.index;}
    
    public String Text(boolean sample){
        
        return sample ? txt.text(text, true) : this.text;
        
    }//Text(boolean sample)
    
    public int index(int min){
        
        return this.index >= 0 ? this.index : min;
    
    }
    
}//Domain