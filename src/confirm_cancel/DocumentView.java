/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import xml_rw.xml_document;
import xml_rw.xml_document_one;

import form.*;
import java.awt.Font;
import java.util.List;

/**
 *
 * @author joaot
 */
public class DocumentView implements Painel_2{
    
    private final String UnsupportedOperation = "Projeto em andamento!";
    
    public DocumentView(xml_document doc, xml_document_one one){
        
        /* É aquí que vai ficar **
        ** o menu de opções     **
        ** para saber o quê     **
        ** será feito com o     **
        ** conteúdo do          **
        ** arquvo XML           **
        ** podendo expostá-lo   **
        ** ou abrir um          **  
        ** documento específico **
        ** no mesmo             */
        
    }//DocumentView(xml_document doc, xml_document_one one)

    @Override
    public String Title(boolean title) {
        throw new UnsupportedOperationException(this.UnsupportedOperation); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Font FontTitle() {
        throw new UnsupportedOperationException(this.UnsupportedOperation); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Font ListFont() {
        throw new UnsupportedOperationException(this.UnsupportedOperation); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Domain> ListMode() {
        throw new UnsupportedOperationException(this.UnsupportedOperation); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean SelectionMultiple() {
        throw new UnsupportedOperationException(this.UnsupportedOperation); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void Command(pag2 op, List<Domain> value) {
        
        //code
        
    }
    
}//DocumentView