package DAO;

import javax.swing.ImageIcon;
import DTO.*;

public class Brazos{

    private int eTotal = 19;
    private Brazo brazos[];
    int posicion;
    
//    private ArrayList <Brazo>aBrazos;
    public Brazos(){
        brazos = new Brazo[eTotal];
    }   
    
    public void agregar(){

        String ruta = "D:\\Frank\\proyectos\\sistemaEjercicios\\res\\img\\";

        brazos[0] = new Brazo(new ImageIcon(ruta+"PEC-01.png"), "Pecho", "Flexiones de brazo", 25,15);
        brazos[1] = new Brazo(new ImageIcon(ruta+"HOM-01.jpg"), "Hombros", "Elevacion frontal con mancuernas");
        brazos[2] = new Brazo(new ImageIcon(ruta+"HOM-02.png"), "Hombros", "Elevacion lateral con mancuernas");
        brazos[3] = new Brazo(new ImageIcon(ruta+"BIP-01.png"), "Biceps", "Curl alterno con mancuerna");
        brazos[4] = new Brazo(new ImageIcon(ruta+"TRI-01.png"), "Triceps", "Apoyo en banco");
        brazos[5] = new Brazo(new ImageIcon(ruta+"ESP-01.png"), "Espalda", "Remo con mancuerna");
        brazos[6] = new Brazo(new ImageIcon(ruta+"BIP-02.png"), "Biceps", "Curl con mancuerna apoyada en el muslo");
        brazos[7] = new Brazo(new ImageIcon(ruta+"HOM-03.png"), "Hombros", "Hombros con sillas");
        brazos[8] = new Brazo(new ImageIcon(ruta+"TRI-02.jpg"), "Triceps", "Patada de triceps con mancuerna");
        brazos[9] = new Brazo(new ImageIcon(ruta+"HOM-04.png"), "Hombros", "Press militar con mancuernas de pie");
        brazos[10] = new Brazo(new ImageIcon(ruta+"TRI-03.jpg"), "Triceps", "Extension de triceps con mancuerna sentado");
        brazos[11] = new Brazo(new ImageIcon(ruta+"PEC-02.jpg"), "Pecho", "Tiron pectoral hacia abajo");
        brazos[12] = new Brazo(new ImageIcon(ruta+"PEC-03.png"), "Pecho", "Tiron pectoral en medio");
        brazos[13] = new Brazo(new ImageIcon(ruta+"PEC-04.jpg"), "Pecho", "Tiron pectoral hacia arriba");
        brazos[14] = new Brazo(new ImageIcon(ruta+"ESP-03.png"), "Espalda", "Remo inclinado con banda elastica");
        brazos[15]= new Brazo(new ImageIcon(ruta+"BIP-03.jpg"), "Biceps", "Remo con banda elastica sentado en el suelo");
        brazos[16] = new Brazo(new ImageIcon(ruta+"ESP-02.png"), "Espalda", "Remo y media sentadilla");
        brazos[17] = new Brazo(new ImageIcon(ruta+"BIP-05.png"), "Biceps", "Jalon en polea alta agarre ancho prono");
        brazos[18] = new Brazo(new ImageIcon(ruta+"BIP-04.jpg"), "Biceps",  "Curl de biceps sentado con poleas altas");

/*        for (int i = 0; i<=18; i++) {
            brazos[i] = brazo[i+1];    
        }
*/
    }
   

	public void eliminar(int id){

		int ePos = id;
		
		if (!arregloVacio() && ePos > -1) {	
			brazos[ePos] = null;
				for (int eRecorre = ePos; eRecorre == eTotal; eRecorre++){
					brazos[eRecorre] = brazos[eRecorre + 1]; 	
				}
			eTotal--;
//			bEstado = true;
		}
/*        else{
				bEstado = false;
		}		
		return bEstado;
    */	
    }

    public boolean arregloVacio(){
			return eTotal == -1;
	}

	public boolean arregloLleno(){
			return eTotal == brazos.length - 1;
	}
	
    public Brazo getBrazo(int posicion){
        return brazos[posicion];
    }

    public int contar(){
		return eTotal;
	}

    public int tamano(){
        return brazos.length -1;
    }
}