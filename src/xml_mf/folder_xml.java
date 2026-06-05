/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

//not currently used
package xml_mf;

import java.util.List;
import java.util.ArrayList;
import java.awt.Font;

import model.Reg;
import form.controller;
import form.Painel_1Single;
import form.Painel_1Multiple;
import form.Painel_2;
import form.Domain;

import form.pag1;
import static form.pag1.*;

import form.pag2;
import static form.pag2.*;

import form.pag3;
import static form.pag3.*;

/**
 *
 * @author josue
 */
public class folder_xml implements Painel_1Single, Painel_1Multiple, Painel_2{
    
    private final String temp = "A função ainda não está pronta!";
    
    public folder_xml(){
        
        throw new UnsupportedOperationException(this.temp);
        
    }//folder_xml()

    @Override
    public Font FontTitle() {
        throw new UnsupportedOperationException(this.temp);
    }

    @Override
    public Font ListFont() {
        throw new UnsupportedOperationException(this.temp);
    }

    @Override
    public String Title(boolean title) {
        throw new UnsupportedOperationException(this.temp);
    }

    @Override
    public String InputText() {
        throw new UnsupportedOperationException(this.temp);
    }

    @Override
    public List<Domain> ListMode() {
        throw new UnsupportedOperationException(this.temp);
    }

    @Override
    public boolean ListColumn() {
        throw new UnsupportedOperationException(this.temp);
    }

    @Override
    public boolean SelectionMultiple() {
        throw new UnsupportedOperationException(this.temp);
    }

    @Override
    public void Action(pag1 action, List<Domain> vol, String input) {
        throw new UnsupportedOperationException(this.temp);
    }

    @Override
    public void Command(pag2 op, List<Domain> value) {
        throw new UnsupportedOperationException(this.temp);
    }
    
}//folder_xml