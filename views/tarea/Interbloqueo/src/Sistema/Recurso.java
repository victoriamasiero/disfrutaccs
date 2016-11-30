/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Sistema;

/**
 *
 * @author RAFA
 */
public class Recurso {
    
    
    private String nombre;
    private String id;
    private int max;
    private int x;
    private int y;
    private int apuntSolicitud;
    private boolean Marcadetec = false ;
    private boolean flag = false;
    
    public Recurso(String nombre, int max, int x) {
        this.nombre = nombre;
        this.max = max;
        this.x = x;
    }

    public Recurso(String nombre, String id, int max, int x) {
        this.nombre = nombre;
        this.id = id;
        this.max = max;
        this.x = x;
    }
    
    
    public Recurso(String nombre, int max, int x, int y, String id, boolean marcadetec) {
        this.nombre = nombre;
        this.max = max;
        this.x = x;
        this.y = y;
        this.id = id;
        this.Marcadetec = marcadetec;
        
    }

    public Recurso(String nombre, int max, int x, int y, String id) {
        this.nombre = nombre;
        this.max = max;
        this.x = x;
        this.y = y;
        this.id = id;
    }

    public Recurso() {
    }

    
    
    
    
    public boolean isMarcadetec() {
        return Marcadetec;
    }

    public void setMarcadetec(boolean Marcadetec) {
        this.Marcadetec = Marcadetec;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
    
        
    public int getApuntSolicitud() {
        return apuntSolicitud;
    }

    public void setApuntSolicitud(int apuntSolicitud) {
        this.apuntSolicitud = apuntSolicitud;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
   
    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    
        
    
    
}
