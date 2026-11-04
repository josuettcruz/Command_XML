/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confirm_cancel;

import xml_rw.xml_config;

import form.Domain;
import form.Painel_2;
import form.controller;
import form.pag2;
import xml_mf.*;
import xml_rw.*;

import static form.pag2.confirm;
import static form.pag2.cancel;
import static form.pag2.enter;
import static form.pag2.del;
import static form.pag2.backspace;

import java.awt.Font;

import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author josue
 */
public class DeletDocumentNot implements Painel_2{
    
    private Font font_title;
    private Font font_text;
    private xml_config xml;
    
    private boolean err;
    
    public DeletDocumentNot(xml_config xml, Font[] f){
        
        try{
            
            this.font_title = f[0];
            this.font_text = f[1];
            this.xml = xml;
            
            /* Esse é o formulário          **
            ** que deverá aparecer          **
            ** quando um ou mais documentos **
            ** presentes no arquivo XML     **
            ** estiver ausente!             */
            
            this.err = false;

        }catch(NullPointerException msg){//throw

            Action.Err("NullPointerException", msg.getMessage());
            
        }catch(Exception msg){//throw

            Action.Err("Exception", msg.getMessage());
            
        }//throw
        
    }//DeletDocumentNot(xml_config xml, Font[] f)
    
    public Font[] Font(){
        
        java.awt.Font font[] = {
            this.font_title,
            this.font_text
        };
        
        return font;
        
    }//Font()
    
    private String className(){return "DeletDocumentNot";}
    
    private List<String> ErrMessage(){
        
        List<String> tema = new ArrayList();
        
        tema.add("Erro inesperado!");
        tema.add("classe \"" + this.className() + "\"");
        tema.add("Pacote \"xml_rw.xml_document\"");
        
        return tema;
        
    }//ErrMessage()

    @Override
    public String Title(boolean title) {
        return "Remover itens indisponíveis?";
    }

    @Override
    public Font FontTitle() {
        return this.font_title;
    }

    @Override
    public Font ListFont() {
        return this.font_text;
    }

    @Override
    public List<Domain> ListMode() {
        
        List<Domain> lts = new ArrayList();
        
        for(var i = 0; i < this.xml.learn().size(); i++){
            
            var d = this.xml.learn().get(i).Cond();
            
            if(d == xml_config_file_cond.not)
            lts.add(new Domain(i,this.xml.learn().get(i).Title()));
            
        }//for(var i = 0; i < this.xml.learn().size(); i++)
        
        if(lts.isEmpty()){
            
            this.err = true;
            
            for(var i = 0; i < this.ErrMessage().size(); i++)
            {lts.add(new Domain(i, this.ErrMessage().get(i)));}
            
        }//if(lts.isEmpty())
        
        return lts;
        
    }

    @Override
    public boolean SelectionMultiple() {return true;}

    @Override
    public void Command(pag2 op, List<Domain> value) {
        
        if(this.err){
            
            controller.Msg(this.className(), this.ErrMessage(), true);
            
        } else {//if(this.err)

            switch(op){

                case confirm ->{

                    List<Integer> cod = new ArrayList();

                    for(var x = 0; x < this.xml.learn().size(); x++){

                        switch(this.xml.learn().get(x).Cond()){

                            case not -> cod.add(x);

                        }//switch(this.xml.learn().get(x).Cond())

                    }//for(var x = 0; x < this.xml.learn().size(); x++)

                    if(cod.isEmpty()){

                        Action.folder_xml();

                    } else {//if(cod.isEmpty())

                        var doc = this.xml;

                        if(cod.size() == 1){

                            doc.Del(cod.get(0));

                        } else {//if(cod.size() == 1)

                            doc.Del(cod);

                        }//if(cod.size() == 1)

                        Action.folder_xml(doc);

                    }//if(cod.isEmpty())

                }//case confirm

                case del, backspace ->{

                    List<Integer> cod = new ArrayList();

                    for(var x = 0; x < value.size(); x++){

                        if(value.get(x).Select()){

                            if(
                                this.xml.learn().get(value.get(x).index()).Cond()
                                == xml_config_file_cond.not
                            )
                            {

                                cod.add(value.get(x).index());

                            }//if(this.xml.learn().get(value.get(x).index()).Cond...

                        }//if(value.get(x).Select())

                    }//for(Domain d : value)

                    if(cod.isEmpty()){

                        Action.folder_xml();

                    } else {//if(cod.isEmpty())

                        xml_config new_xml = this.xml;

                        if(cod.size() == 1){

                            new_xml.Del(cod.get(0));

                        } else {//if(cod.size() == 1)

                            new_xml.Del(cod);

                        }//if(cod.size() == 1)

                        Action.folder_xml(new_xml);

                    }//if(cod.isEmpty())

                }//case del, backspace

                case cancel, enter -> Action.folder_xml();

            }//switch(op)

        }//if(this.err)
        
    }
    
}//DeletDocumentNot