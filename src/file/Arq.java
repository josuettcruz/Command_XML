/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author josue
 */
public class Arq {
    
    private String arq;
    
    private ArrayList<String> text;
    
    private boolean create;
    
    private boolean valid;
    private String type;
    private String message;
    
    public Arq(String arq){
        
        this.valid = true;
        this.type = "";
        this.message = "";
        
        this.arq = arq;
        
        this.text = new ArrayList();
        
        try{
        
            File menu = new File(this.arq);

            this.create = menu.createNewFile();

            try (Scanner reading = new Scanner(menu)) {
                
                if(this.create){
                    
                    this.text.clear();
                    
                } else {//if(create)
                    
                    while(reading.hasNextLine()){
                        
                        String data = reading.nextLine();
                        
                        this.text.add(data);
                        
                    }//while(reading.hasNextLine())
                    
                }//if(create)
                
            }//try (Scanner reading = new Scanner(menu))
        
        }catch(IOException evt){
            
            this.valid = false;
            this.type = "IOException";
            this.message = evt.getMessage();
            
        }catch(Exception evt){
            
            this.valid = false;
            this.type = "Exception";
            this.message = evt.getMessage();
            
        }
        
    }//Arq(String arq)
    
    public boolean create(){
        
        return this.create;
        
    }//create()
    
    public boolean exist(){
        
        return !this.create;
        
    }//exist()
    
    public boolean Val(){
        
        return this.valid;
        
    }//Val()
    
    public String Type(){
        
        return this.type;
        
    }//Type()
    
    public String Message(){
        
        return this.message;
        
    }//Message()
    
    public String Message(String sep){
        
        if(this.valid){
            
            return "";
            
        } else {//if(this.valid)
            
            return this.type + sep + this.message;
            
        }//if(this.valid)
        
    }//Message(String sep)
    
    private Exec Write(String txt, boolean add){
        
        Exec msg = new Exec();
        
        try{
            
            var br = false;
            
            try (FileWriter line = new FileWriter(this.arq)) {
                
                if(add){
                    
                    for(String p : this.text){
                        
                        if(br){
                            
                            line.write("\n");
                            
                        } else {//if(br)
                            
                            br = true;
                            
                        }//if(br)
                        
                        line.write(p);
                        
                    }//for(String line : this.text)
                    
                } else {//if(add)
                    
                    this.text.clear();
                    
                }//if(add)
                
                for(String in : txt.split("\n")){
                    
                    if(br){
                        
                        line.write("\n");
                        
                    } else {//if(br)
                        
                        br = true;
                        
                    }//if(br)
                    
                    line.write(in);
                    
                    this.text.add(in);
                    
                }//for(String in : txt.split("\n"))
                
            }//try (FileWriter line = new FileWriter(this.arq))
            
        }catch(IOException e){
            
            msg.com("IOException", e.getMessage(), e.hashCode());
            
        }catch(Exception e){
            
            msg.com("Exception", e.getMessage(), e.hashCode());
            
        }
        
        return msg;
        
    }//Write(String txt, boolean add)
    
    private Exec Write(List<String> txt, boolean add){
        
        Exec msg = new Exec();
        
        try{
            
            var br = false;
            
            try (FileWriter line = new FileWriter(this.arq)) {
                
                if(add){
                    
                    for(String p : this.text){
                        
                        if(br){
                            
                            line.write("\n");
                            
                        } else {//if(br)
                            
                            br = true;
                            
                        }//if(br)
                        
                        line.write(p);
                        
                    }//for(String line : this.text)
                    
                } else {//if(add)
                    
                    this.text.clear();
                    
                }//if(add)
                
                for(String in : txt){
                    
                    if(br){
                        
                        line.write("\n");
                        
                    } else {//if(br)
                        
                        br = true;
                        
                    }//if(br)
                    
                    line.write(in);
                    
                    if(in.contains("\n")){
                        
                        this.text.addAll(Arrays.asList(in.split("\n")));
                        
                    } else {//if(in.contains("\n"))
                        
                        this.text.add(in);
                        
                    }//if(in.contains("\n"))
                    
                }//for(String in : txt)
                
            }//try (FileWriter line = new FileWriter(this.arq))
            
        }catch(IOException e){
            
            msg.com("IOException", e.getMessage(), e.hashCode());
            
        }catch(Exception e){
            
            msg.com("Exception", e.getMessage(), e.hashCode());
            
        }
        
        return msg;
        
    }//Write(List<String> txt, boolean add)
    
    public Exec Save(String[] write){
        
        List<String> converter = new ArrayList();
        
        converter.addAll(Arrays.asList(write));
        
        return Write(converter, false);
        
    }//Save(String[] write)
    
    public Exec Save(List<String> write){
        
        return Write(write, false);
        
    }//Save(List<String> write)
    
    public Exec Save(String write){
        
        return Write(write, false);
        
    }//Save(String write)
    
    public Exec Insert(String[] write){
        
        List<String> converter = new ArrayList();
        
        converter.addAll(Arrays.asList(write));
        
        return Write(converter, true);
        
    }//Insert(String[] write)
    
    public Exec Insert(List<String> write){
        
        return Write(write, true);
        
    }//Insert(List<String> write)
    
    public Exec Insert(String write){
        
        return Write(write, true);
        
    }//Insert(String write)
    
    public Read Read(){
        
        if(this.valid){
            
            return new Read(this.text, this.arq);
            
        } else {//if(this.valid)
            
            return new Read(this.type, this.message);
            
        }//if(this.valid)
        
    }//Read()
    
    public boolean Dir(boolean write){
        
        try{
            
            File menu = new File(this.arq);
            
            if(write){
                
                return menu.canRead() && menu.canWrite();
                
            } else {//if(write)
                
                return menu.canRead();
                
            }//if(write)

        }catch(Exception e){
            
            return false;
            
        }
        
    }//Dir(boolean write)
    
    public long Tam(long init){
        
        long date = init;
        
        if(date < 0L){
            
            date = date - date*2L;
            
        }//if(date < 0L)
        
        File menu = new File(this.arq);
        
        if(menu.canRead()){
            
            date += menu.length();
            
        }//if(menu.exists())
        
        return date;
        
    }//Tam(long init)
    
    public static boolean Exist(String diretory){
        
        return new File(diretory).exists();
        
    }//Exist(String diretory)
    
    public static List<String> Folder(String diretory){
        
        var ds = new File(diretory).getAbsolutePath();
        
        List<String> dir = new ArrayList();
        
        var name = "";
        
        for(int d = 0;d < ds.length();d++){
            
            switch(ds.charAt(d)){
                
                case '\\', '/' -> {
                    
                    if(!name.isBlank()){
                        
                        dir.add(name);
                        name = "";
                        
                    }//if(!txt.isBlank())
                    
                }//cases
                
                default -> name += ds.charAt(d);
                
            }//switch(ds.charAt(d))
            
        }//for(int d = 0;d < ds.length();d++)
        
        if(!name.isBlank()) dir.add(name);
        
        return dir;
        
    }//Folder(String diretory)
    
    public static String Files(String diretory){
        
        return new File(diretory).getAbsolutePath();
        
    }//Files(String diretory)
    
}