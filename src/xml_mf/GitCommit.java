/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import file.Read;
import model.txt;
import form.controller;

import form.Painel_1Single;
import form.pag1;
import java.awt.Font;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author joaot
 */
public class GitCommit implements Painel_1Single{
    
    private final String Unsupported = "Projeto pendente de atualização!";
    
    private List<Read> arq;
    private List<String> name;
    private String input;
    
    public GitCommit(List<Read> file){
        
        this.Git(file);
        this.input = "";
        
    }//GitCommit(List<Read> file)
    
    public GitCommit(List<Read> file, int index){
        
        this.Git(file);
        
        if(!this.arq.isEmpty() && index >= 0 && index < this.arq.size()){
            
            this.input = this.arq.get(index).Arq();
            
        } else {//if(!this.arq.isEmpty() && index >= 0 && index < this.arq...
            
            this.input = "";
            
        }//if(!this.arq.isEmpty() && index >= 0 && index < this.arq.size())
        
    }//GitCommit(List<Read> file)
    
    private void Git(List<Read> file){
        
        this.arq = new ArrayList();
        
        for(Read tem : file){
            
            var tema = txt.text(tem.Read(), true);
            
            if(tem.Val() && !tema.isBlank()) this.arq.add(tem);
            
        }//for(Read tem : file)
        
    }//public GitCommit(List<Read> file)
    
    private void Submit(int index){
        
        if(!this.arq.isEmpty() && index >= 0 && index < this.arq.size()){
            
            List<String> out = new ArrayList();
            
            for(int x = 0; x < this.arq.get(index).Max(); x++){
                
                var text = txt.text(this.arq.get(index).Read(x), true);
                
                if(!text.isBlank()) out.add(text);
                
            }//for(int x = 0; x < this.arq.get(index).Max(); x++)
            
            controller.p1m(new commit(out));
            
        } else {//if(!this.arq.isEmpty() && index >= 0 && index < this...
            
            System.exit(0);
            
        }//if(!this.arq.isEmpty() && index >= 0 && index < this.arq.size())
        
    }

    @Override
    public String Title(boolean title) {
        throw new UnsupportedOperationException(this.Unsupported);
    }

    @Override
    public String InputText() {
        return this.input;
    }

    @Override
    public java.util.List<String> List() {
        throw new UnsupportedOperationException(this.Unsupported);
    }

    @Override
    public Font ListFont() {
        throw new UnsupportedOperationException(this.Unsupported);
    }

    @Override
    public boolean ListColumn() {
        throw new UnsupportedOperationException(this.Unsupported);
    }

    @Override
    public void Button(pag1 action, int index, java.util.List<String> vol, String input) {
        
        switch(action){
            
            case backspace, remove -> controller.p1s(
                new GitCommit(
                    this.arq,
                    index
                )
            );
            
            case delet -> System.exit(0);
            
            default -> this.Submit(index);
            
        }
        
    }
    
}
