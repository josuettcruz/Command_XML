/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

import model.txt;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class Order<cmd> {
    
    public final static int tab_space = 3;
    
    private List<Order_one> command;
    private int position;
    
    public Order(){
        
        this.command = new ArrayList();
        this.position = -1;
        
    }//Order()
    
    public boolean Add(cmd command, String text){
        
        var value = true;
        var i = 0;
        
        var validate = "";
        
        for(String t : txt.phrase(text)) validate += txt.arq(t);
        
        do{
            
            var valid = "";
            
            for(String t : txt.phrase(this.command.get(i).Title()))
            {valid += txt.arq(t);}
            
            value = !validate.equalsIgnoreCase(valid);
            
            i++;
            
        }while(value && i > 0 && i < this.command.size());
        
        if(value){
            
            this.command.add(new Order_one(command, text));
            
        } else {//if(value)
            
            this.position = i;
            
        }//if(value)
        
        return value;
        
    }//Add(cmd command, String text, boolean definition)
    
    public List<cmd> Return(){
        
        List<cmd> value = new ArrayList();
        
        boolean val[] = new boolean[this.command.size()];
        
        for(var i = 0; i < val.length; i++) val[i] = true;
        
        var compare = this.command.get(0).Title();
        
        var repeat = 0;
        
        do{
            
            var i = 0;
            var loop = true;
            
            do{
                
                if(val[i]){
                    
                    if(txt.min(this.command.get(i).Title(), compare)){
                        
                        value.add((cmd) this.command.get(i).Code());
                        
                        compare = this.command.get(i).Title();
                        
                        val[i] = false;
                        loop = false;
                        
                    }//if(txt.min(this.command.get(i).Title(), compare))
                    
                }//if(val[i])
                
                i++;
                
            }while(loop && i > 0 && i < this.command.size());
            
            repeat++;
            
        }while(repeat > 0 && repeat < this.command.size());
        
        return value;
        
    }//Return()
    
    public static int Proc(List<String> proc, String search){
        
        var value = -1;
        
        if(txt.phrase(search).size() > 1){
            
            var i = 0;
            var exit = false;
            
            var validate = "";
            
            for(String t : txt.phrase(search)) validate += txt.arq(t);
            
            do{
                
                var valid = "";
                
                for(String t : txt.phrase(proc.get(i))) valid += txt.arq(t);
                
                exit = validate.equals(valid);
                
                i++;
                
            }while(!exit && i > 0 && i < proc.size());
            
            if(exit) value = i;
            
        }//if(txt.phrase(search).size() > 1)
        
        return value;
        
    }//Proc(List<String> proc)

    public int Position() {return position;}
    
}//Order<cmd>