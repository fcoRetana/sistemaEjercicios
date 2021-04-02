package DTO;

import javax.swing.ImageIcon;

public class Brazo{

    private ImageIcon imagen;
    private String area;
    private String ejercicio;
    private int trabajo;
    private int descanso;
    
    public Brazo(){
    }						

    public Brazo(ImageIcon imagen, String area, String ejercicio){
        this.imagen = imagen;
        this.area = area;
        this.ejercicio = ejercicio;
    }

    public Brazo(ImageIcon imagen, String area, String ejercicio, int trabajo, int descanso){
        this.imagen = imagen;
        this.area = area;
        this.ejercicio = ejercicio;
        this.trabajo = trabajo;
        this.descanso = descanso;
    }
    public ImageIcon getImagen(){
        return imagen;
    }

    public String getArea(){
        return area;
    }
    public String getEjercicio(){
        return ejercicio;
    }

    public int getTrabajo(){
        return trabajo;
    }

    public int getDescanso(){
        return descanso;
    }

    public void setImagen(ImageIcon imagen){
        this.imagen = imagen;    
    }

    public void setArea(String area){
        this.area = area;
    }
    
    public void setEjercicio(String ejercicio){
        this.ejercicio = ejercicio;
    }

    public void setTrabajo(int trabajo){
        this.trabajo = trabajo;
    }

    public void setDescanso(int descanso){
        this.descanso = descanso;
    }

}

