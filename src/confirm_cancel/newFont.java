/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import xml_mf.Action;
import xml_rw.*;

import model.carregarFonte;
import model.Reg;
import model.Hora;
import form.Domain;
import form.Painel_2;
import form.pag2;
import static form.pag2.confirm;
import static form.pag2.cancel;
import static form.pag2.enter;
import static confirm_cancel.form_selected.*;

import java.awt.Font;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author josue
 */
public class newFont implements Painel_2{
    
    private form_selected form_selection;
    private String local_font;
    
    public newFont(xml_config con, String local){
        
        this.form_selection = folder_xml;
        this.local_font = local;
        
    }//newFont(xml_config con, Font[] font, String local)
    
    public newFont(xml_document doc, String local){
        
        this.form_selection = ReadWrite;
        this.local_font = local;
        
    }//public newFont(xml_config con, String local)
    
    public newFont(xml_document doc, xml_document_one one, String local){
        
        this.form_selection = session;
        this.local_font = local;
        
    }//newFont(xml_document doc, xml_document_one one, String local)
    
    private void addFont(carregarFonte cod){
        
        //code
        
    }//addFont(carregarFonte cod)
    
    private void cancel(){
        
        //code
        
    }//cancel()
    
    private void confirm(Domain dom){
        
        if(dom.index() == 0){
            
            this.cancel();
            
        } else {//if(dom.index() == 0)
            
            this.addFont(
                new carregarFonte(
                    this.local_font,
                    0,
                    dom.index()
                )
            );
            
        }//if(dom.index() == 0)
        
    }//confirm(Domain dom)

    @Override
    public String Title(boolean title) {
        
        var doc = Hora.Good();
        doc += "! ";
        
        if(title){
            
            doc += Reg.categories;
            
        } else {//if(title)
            
            doc += Reg.categories;
            doc += " - Escolha o tamanho da fonte:";
            
        }//if(title)
        
        return doc;
        
    }

    @Override
    public Font FontTitle() {
        return new java.awt.Font("Verdana", 20, 0);
    }

    @Override
    public Font ListFont() {
        return new java.awt.Font("Consolas", 20, 0);
    }

    @Override
    public List<Domain> ListMode() {
        
        List<Domain> dom = new ArrayList();
        
        Integer size[] = {8, 10, 12, 14, 18, 20, 22};
        dom.add(new Domain(0, "Cancelar"));
        
        for(Integer val : size){
            
            var string = "Tamanho: ";
            string += Reg.Numb(val);
            
            dom.add(new Domain(val,string));
            
        }//for(Integer val : size)
        
        return dom;
        
    }

    @Override
    public boolean SelectionMultiple() {
        return false;
    }

    @Override
    public void Command(pag2 op, List<Domain> value) {
        
        switch(op){
            
            case confirm, enter ->{
                
                var proc = 0;
                var loop = true;
                
                do{
                    
                    if(value.get(proc).Select()){
                        
                        this.confirm(value.get(proc));
                        
                        loop = false;
                        
                    }//if(value.get(proc).Select())
                    
                    proc++;
                    
                }while(loop && proc > 0 && proc < value.size());
                
            }//case confirm, enter
            
            case cancel -> this.cancel();
            
        }//switch(op)
        
    }
    
}//newFont