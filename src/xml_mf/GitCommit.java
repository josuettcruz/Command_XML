/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import file.Read;
import model.txt;
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
    
    List<Read> arq;
    
    public GitCommit(List<Read> file){
        
        this.arq = new ArrayList();
        
        for(Read tem : file){
            
            var tema = txt.text(tem.Read(), true);
            
            if(tem.Val() && !tema.isBlank()) this.arq.add(tem);
            
        }//for(Read tem : file)
        
    }//public GitCommit(List<Read> file)

    @Override
    public String Title(boolean title) {
        throw new UnsupportedOperationException(this.Unsupported);
    }

    @Override
    public String InputText() {
        throw new UnsupportedOperationException(this.Unsupported);
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
        throw new UnsupportedOperationException(this.Unsupported);
    }
    
}
