package DTO;

import javax.swing.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

public class Temporizador {

    private int secondWork = 0;
    private int series = 0;
    private JLabel temporizador = new JLabel("INICIAR");
    private Boolean estado = false;
    private String timeRest = "";

    public Temporizador(){

    }

    public Temporizador(int trabajo, int descanso ) {
        //Se establece el numero de repeticiones que hara el temporizador
        series = 4;

        //segundos de trabajo + descanso + 4 seg de intervalos multiplicados para convertirlos a milisegundos
        int tiempo = (trabajo + descanso + 4) * 1000;    
        
        Timer timer = new Timer();        
        TimerTask mainTask = new TimerTask(){
                
            public void run(){
                series --;

                if (series <= -1) {
                    timer.cancel();
                    estado = false;
                    temporizador.setText("FIN");
                    System.exit(0);    

                } else {
                    estado = true;
                    iniciar(trabajo, 1); 
                    try {
                        TimeUnit.SECONDS.sleep(trabajo+2);
                        iniciar(descanso, 0); 
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }    
                }
            }
        };
        timer.scheduleAtFixedRate(mainTask, 1000, tiempo);       
    }

    public void iniciar(int segundos, int td) {

        this.secondWork = segundos;
        Timer timer = new Timer();
        
        TimerTask task = new TimerTask(){
            public void run(){
                
                Sonido sonido = new Sonido();
                String ruta = "D:\\Frank\\proyectos\\sistemaEjercicios\\res\\sound\\";
                timeRest = (secondWork > 9) ? "00:" + secondWork : "00:0" + secondWork;
                secondWork --;

                if (secondWork <= -2) {
                    timer.cancel();
                    estado = false;
                    try {
                        if (td == 1){           //td trabajo descanso, si es tiempo de trabajo se termina  pone 1, si es desncaso se termina 0
                            sonido.reproducir(ruta+"beep1.wav");
                        }else {
                            sonido.reproducir(ruta+"beep2.wav") ;
                        } 
                    } catch(Exception e){
                        System.out.println(e.getMessage());
                    }   
                } else {
                    temporizador.setText(timeRest);
                    estado = true;
                }
            }
        };
    timer.scheduleAtFixedRate(task, 0, 1000);     
    }   

    public void setTemporizador(String tiempo){
        temporizador.setText(tiempo);
    }

    public JLabel getTemporizador(){
        return temporizador;
    }

    public Boolean getEstado(){
        return estado;
    }

    public static void main (String args []) {

        Temporizador tempo = new Temporizador(5, 5);
        JFrame frame = new JFrame();

        frame.add(tempo.getTemporizador());

        frame.setSize(410, 482);
        frame.setLocation (400, 150);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);    
    }

}
