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
    
    private List<String> title;
    private List<cmd> command;
    private List<Boolean> val;
    private int position;
    
    public Order(){
        
        this.title = new ArrayList();
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
            
            for(String t : txt.phrase(this.title.get(i))) valid += txt.arq(t);
            
            value = !validate.equalsIgnoreCase(valid);
            
            i++;
            
        }while(value);
        
        if(value){
            
            this.command.add(command);
            this.title.add(text);
            
        } else {//if(value)
            
            this.position = i;
            
        }//if(value)
        
        return value;
        
    }//Add(cmd command, String text, boolean definition)
    
    public List<cmd> Return(){
        
        List<cmd> value = new ArrayList();
        
        var tot = this.command.size();
        
        boolean cod[] = new boolean[tot];
        
        for(var i = 0; i < tot; i++) cod[i] = true;
        
        var compare = this.title.get(0);
        
        for(int repeat = 0; repeat < this.command.size(); repeat++){
            
            var i = 0;
            var loop = true;
            
            do{
                
                if(this.val.get(i)){
                    
                    if(txt.min(this.title.get(i), compare)){
                        
                        value.add(this.command.get(i));
                        
                        compare = this.title.get(i);
                        
                        cod[i] = false;
                        
                        loop = false;
                        
                    }//if(txt.min(doc[i], compare))
                    
                }//if(cod[y])
                
                i++;
                
            }while(loop && i > 0 && i < tot);
            
        }//for(int repeat = 0; repeat < tot; repeat++)
        
        return value;
        
    }//Order()
    
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
    
}
