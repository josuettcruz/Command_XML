/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package xml_rw;

import java.util.List;

/**
 *
 * @author josue
 */
public class xml_document_one {
    
    private String title;
    private List<xml_document_link> url;
    private xml_document_input_text form;
    
    public xml_document_one(
        String title,
        List<xml_document_link> url,
        xml_document_input_text form
    )
    {
        
        this.title = title;
        this.url = url;
        this.form = form;
        
    }//public xml document one

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public List<xml_document_link> getUrl() {return url;}

    public void setUrl(List<xml_document_link> links){
        
        this.url.clear();
        this.url.addAll(links);
    
    }//setUrl(List<xml_document_link> links)

    public xml_document_input_text getForm() {return form;}

    public void setForm(xml_document_input_text form) {this.form = form;}
    
}
