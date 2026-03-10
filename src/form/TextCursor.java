/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package form;

/**
 *
 * @author josue
 */
public class TextCursor {
    
    private boolean user;
    private int row;
    private int col;
    
    public TextCursor(){
        
        this.user = false;
        this.row = 0;
        this.col = 0;
        
    }//TextCursor()
    
    public void Cursor(int row, int col){
        
        this.user = true;
        this.row = row;
        this.col = col;
        
    }//TextCursor(int row, int col)
    
    public boolean getUser(){return this.user;}
    
    public int row_col(boolean row){return row ? this.row : this.col;}
    
}//TextCursor