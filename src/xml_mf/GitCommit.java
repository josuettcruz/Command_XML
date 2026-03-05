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
 * @author josue
 */
public class GitCommit implements Painel_2{
       
    private List<Domain> lin;
    private List<String> all_text;
    
    public GitCommit(List<Read> arq){
        
        final char[] c = {'\\','_', '.', ','};
        
        final String asept = "txt";
        
        final String[] sept = {"command","xml",""};
        
        final var g = 10;
        
        this.lin = new ArrayList();
        this.all_text = new ArrayList();
        
        int cod = 1;
        this.lin.add(new Domain(cod," ".repeat(g) + Hora.Good()));
        this.all_text.add("");
        
        for(Read r : arq){
            
            cod++;
            
            int a = 0;
            
            var nom = "";
            
            for(String t : txt.phrase(r.Arq(), c)){
                
                if(t.equalsIgnoreCase(sept[a]) && a < sept.length){
                    
                    a++;
                    
                } else {//if(t.equalsIgnoreCase(sept[a]) && a < sept.length)
                    
                    if(!t.equalsIgnoreCase(asept)){
                        
                        if(!nom.isBlank()) nom += " ";
                        
                        nom += t;
                        
                    }//if(!t.equalsIgnoreCase(asept))
                    
                }//if(t.equalsIgnoreCase(sept[a]) && a < sept.length)
                
            }//for(String t : txt.phrase(r.Arq(), c))
            
            this.lin.add(
                new Domain(
                    cod,Reg.Tab(
                        " --" + Reg.Numb(cod-1, arq.size(), "-") + "--",
                        nom,
                        g
                    )
                )
            );
            
            this.all_text.add(r.Read());
            
        }
        
    }//GitCommit(List<Read> arq)
    
    private void execute(String text){
        
        if(text.isBlank()){
            
            controller.p1m(new config());
            
        } else {//if(text.isBlank())
            
            controller.p1m(new commit(text));
            
        }//if(text.isBlank())
        
    }//execute(String text)
    
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
            loop
            && add > 0
            && add < this.lin.size()
            && add < this.all_text.size()
        );
        
        if(loop) System.exit(0);
        
    }//Action(Domain value)

    @Override
    public String Title(boolean title) {
        return new Link(Reg.http).page(!title);
    }

    @Override
    public Font ListFont() {
        
        var tot = this.lin.size();
        
        int tam;
        
        if(tot < 10){
            
            tam = 22;
            
        } else if(tot == 10){
            
            tam = 20;
            
        } else if(tot <= 12){
            
            tam = 18;
            
        } else if(tot < 14){
            
            tam = 16;
            
        } else if(tot < 20){
            
            tam = 14;
            
        } else {
            
            tam = 12;
            
        }
        
        return new java.awt.Font("Consolas", 0, tam);
    }

    @Override
    public java.util.List<Domain> ListMode() {
        
        return this.lin;
        
    }

    @Override
    public void Command(pag2 op, Domain value) {
        
        switch(op){
            
            case confirm, enter -> this.Action(value);
            
            case cancel, del, backspace -> System.exit(0);
            
        }//switch(op)
        
    }
    
}//GitCommit