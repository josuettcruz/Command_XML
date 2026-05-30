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
    private List<String> textarea;
    
    public xml_document_one(
        String title,
        List<xml_document_link> url,
        List<String> textarea
    )
    {
        
        this.title = title;
        this.url = url;
        this.textarea = textarea;
        
    }//public xml document one

    public String getTitle() {return title;}

    public void setTitle(String title) {this.title = title;}

    public List<xml_document_link> getUrl() {return url;}

    public void setUrl(List<xml_document_link> url) {this.url = url;}

    public List<String> getText() {return textarea;}

    public void setText(List<String> textarea) {this.textarea = textarea;}
    
}
