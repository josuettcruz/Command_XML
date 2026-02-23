/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import form.Domain;
import java.util.List;

import form.Painel_1Multiple;
import form.pag1;
import java.awt.Font;

/**
 *
 * @author joaot
 */
public class commit implements Painel_1Multiple{
    
    private final String Unsupported = "Projeto pendente de atualização!";
    
    private List<String> text;
    
    public commit(List<String> text){
        
        this.text = text;
        
    }//commit(List<String> text)

    @Override
    public String Title(boolean title) {
        throw new UnsupportedOperationException(this.Unsupported);
    }

    @Override
    public String InputText() {
        throw new UnsupportedOperationException(this.Unsupported);
    }

    @Override
    public List<Domain> ListMode() {
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
    public void Action(pag1 action, List<Domain> vol, String input) {
        throw new UnsupportedOperationException(this.Unsupported);
    }
    
}
