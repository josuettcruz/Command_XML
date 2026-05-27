/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

import file.Read;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author josue
 */
public class xml_document_input_text {
    
    private List<String> text;
    
    public xml_document_input_text(List<String> input_text){
        
        this.text = new ArrayList();
        
        for(String t : input_text){
            
            if(t.contains("\n")){
                
                this.text.addAll(Arrays.asList(t.split("\n")));
                
            } else {//if(t.contains("\n"))
                
                this.text.add(t);
                
            }//if(t.contains("\n"))
            
        }//for(String t : read_form)
        
    }//input_text(List<String> input_text)
    
    public xml_document_input_text(Read input_text){
        
        this.text = new ArrayList();
        
        for(int cursor = 0; cursor < input_text.Max(); cursor++)
        {this.text.add(input_text.Read(cursor));}
        
    }//text(Read input_text)

    public List<String> input() {return text;}
    
}
