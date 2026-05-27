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

    public String title() {return title;}

    public List<xml_document_link> url() {return url;}

    public xml_document_input_text text() {return form;}
    
}
