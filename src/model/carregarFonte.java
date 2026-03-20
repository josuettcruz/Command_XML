/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *
 * Help https://pt.stackoverflow.com/questions/77337/como-definir-uma-fonte-nova-fonteexterna-para-um-jtextpane Stack Overflow em Português
 */

package model;

import java.awt.Font;

import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;

import java.io.IOException;
import java.io.InputStream;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class carregarFonte {
    
    private Font minhaFonte;
    private List<String> msg;
    
    public void carregarFonte(String caminho_da_font) {
        
        this.msg = new ArrayList();
        
        try {
            
            this.msg.add(caminho_da_font);
            
            // Localize o caminho do arquivo dentro do seu pacote
            InputStream is = getClass().getResourceAsStream(caminho_da_font);
            
            // Cria a fonte a partir do stream
            this.minhaFonte = Font.createFont(Font.TRUETYPE_FONT, is);
            
            // Registra a fonte no sistema para que ela possa ser usada pelo nome
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(this.minhaFonte);
            
        } catch (FontFormatException e) {
            
            this.msg.add("\"" + e.hashCode() + "\"");
            this.msg.add("FontFormatException");
            this.msg.add(e.getMessage());
            
            if(!e.getMessage().equalsIgnoreCase(e.getLocalizedMessage()))
            {this.msg.add(e.getLocalizedMessage());}
            
        } catch (IOException e) {
            
            this.msg.add("\"" + e.hashCode() + "\"");
            this.msg.add("IOException");
            this.msg.add(e.getMessage());
            
            if(!e.getMessage().equalsIgnoreCase(e.getLocalizedMessage()))
            {this.msg.add(e.getLocalizedMessage());}
            
        } catch (Exception e) {
            
            this.msg.add("\"" + e.hashCode() + "\"");
            this.msg.add("Exception");
            this.msg.add(e.getMessage());
            
            if(!e.getMessage().equalsIgnoreCase(e.getLocalizedMessage()))
            {this.msg.add(e.getLocalizedMessage());}
            
        }
        
    }
    
}//carregarFonte