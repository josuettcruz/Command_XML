/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_mf;

import form.Painel_1Single;
import form.pag1;
import java.awt.Font;

import java.util.List;

/**
 *
 * @author joaot
 */
public class commit implements Painel_1Single{
    
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
