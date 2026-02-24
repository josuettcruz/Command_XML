/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import file.Read;
import model.*;
import form.*;

import java.awt.Font;

import java.util.List;
import java.util.ArrayList;

import form.pag2;
import static form.pag2.*;

/**
 *
 * @author joaot
 */
public class GitCommit implements Painel_2{
       
    private List<Domain> lin;
    private List<String> all_text;
    
    public GitCommit(List<Read> arq){
        
        this.lin = new ArrayList();
        this.all_text = new ArrayList();
        
        int cod = 1;
        this.lin.add(new Domain(cod,".."));
        this.all_text.add("");
        
        for(Read r : arq){
            
            cod++;
            
            this.lin.add(new Domain(cod,r.Arq()));
            this.all_text.add(r.Read());
            
        }
        
    }//GitCommit(List<Read> arq)
    
    private void execute(String text){
        
        if(text.isBlank()){
            
            controller.p2(new config());
            
        } else {
            
            controller.p1s(new commit(text));
            
        }
        
    }
    
    private void Action(Domain value){
        
        
        var add = 0;
        var loop = true;
        
        do{
            
            if(value.index() == this.lin.get(add).index()){
                
                this.execute(this.all_text.get(add));
                loop = false;
                
            }//if(value.index() == this.lin.get(add).index())
            
            add++;
            
        }while(
            loop && add > 0 && add < this.lin.size()
            && add < this.all_text.size()
        );
        
        if(loop) System.exit(0);
        
    }

    @Override
    public String Title(boolean title) {
        return new Link(Reg.http).page(!title);
    }

    @Override
    public Font ListFont() {
        return new java.awt.Font("Consolas",0,16);
    }

    @Override
    public java.util.List<Domain> ListMode() {
        
        return this.lin;
        
    }

    @Override
    public void Command(pag2 op, Domain value) {
        
        switch(op){
            
            case confirm, enter -> this.Action(value);
            
            case cancel -> System.exit(0);
            
        }//switch(op)
        
    }
    
}
