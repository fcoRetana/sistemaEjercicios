package IGU;

import DTO.*;
import DAO.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;

public class IGUBrazo extends JFrame {

    /**
     *v1
     */
    private static final long serialVersionUID = 1L;
    //contador utilizado en la clase
    static int posicion = 0;
    static int segundos = 0;

    public IGUBrazo(){

        //llama al arreglo de ejercicios de brazo y luego llena el arreglo
        Brazos aBrazos = new Brazos();
        aBrazos.agregar();
  
        //Ruta para obtener las img, se puede cambiar
        String ruta = "D:\\Frank\\proyectos\\sistemaEjercicios\\res\\img\\";
        
        //Inicializacion de los paneles que organizaran los elementos
        JFrame jfPrincipal = new JFrame("Ejercicios");
        JPanel jpEjercicio = new JPanel();
        JPanel jpImagen = new JPanel();
        JPanel jpTemporizador = new JPanel();
        JPanel jpBotones = new JPanel();

        //Etiquetas con datos de cada ejercicio
        JLabel jlArea = new JLabel(aBrazos.getBrazo(posicion).getArea());
        JLabel jlEjercicio = new JLabel(aBrazos.getBrazo(posicion).getEjercicio());        
        JLabel jlImagen = new JLabel(aBrazos.getBrazo(posicion).getImagen());
        JLabel jlCuenta = new JLabel((posicion + 1)+" de " + aBrazos.contar());
        JLabel jlTimer = new JLabel("00:00");

        //Formato de etiquetas
        jlArea.setFont(new Font("Tahoma", Font.BOLD, 18));
        jlArea.setHorizontalAlignment(JLabel.CENTER);
        jlEjercicio.setFont(new Font("Tahoma", Font.BOLD, 16));
        jlEjercicio.setHorizontalAlignment(JLabel.CENTER);
        jlCuenta.setFont(new Font("Tahoma", Font.BOLD, 18));
        jlCuenta.setHorizontalAlignment(JLabel.CENTER);
        jlTimer.setFont(new Font("Tahoma", Font.BOLD, 28));
        jlTimer.setHorizontalAlignment(JLabel.CENTER);

        //Formato a los contenedores
        jfPrincipal.setLayout(new BorderLayout());
        jpEjercicio.setLayout(new GridLayout(2,1,2,0));
        jpTemporizador.setLayout(new GridLayout(2,1,2,0));

        //Botones con su action performed
        JButton jbInicio = new JButton(new ImageIcon(ruta+"inicio.png"));
        jbInicio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev1){
                posicion = 0;
                jlArea.setText(aBrazos.getBrazo(posicion).getArea()+"\n");
                jlEjercicio.setText(aBrazos.getBrazo(posicion).getEjercicio());  
                jlImagen.setIcon(aBrazos.getBrazo(posicion).getImagen());
                jlCuenta.setText((posicion + 1)+" de " + aBrazos.contar());    
                SwingUtilities.updateComponentTreeUI(jpImagen);            }
  
            });

                
        JButton jbAnterior = new JButton(new ImageIcon(ruta+"anterior.png"));
        jbAnterior.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev2){
                if (posicion > 0) { 
                    posicion --;
                }
         //       jlArea.setText(aBrazos.getBrazo(posicion).getArea());
                jlEjercicio.setText(aBrazos.getBrazo(posicion).getEjercicio());  
                jlImagen.setIcon(aBrazos.getBrazo(posicion).getImagen());
                jlCuenta.setText((posicion + 1)+" de " + aBrazos.contar());    
                SwingUtilities.updateComponentTreeUI(jpImagen);
            }
        });

        JButton jbTerminado = new JButton(new ImageIcon(ruta+"terminado.png"));
        jbTerminado.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev5){
                if (posicion >= 0 && posicion <= aBrazos.tamano()) { 
                    aBrazos.eliminar(posicion);
                    posicion ++;
                }
         //       jlArea.setText(aBrazos.getBrazo(posicion).getArea());
                jlEjercicio.setText(aBrazos.getBrazo(posicion).getEjercicio());  
                jlImagen.setIcon(aBrazos.getBrazo(posicion).getImagen());
                jlCuenta.setText((posicion + 1)+" de " + aBrazos.contar());    
                SwingUtilities.updateComponentTreeUI(jpImagen);
            }
        });



        JButton jbSiguiente = new JButton(new ImageIcon(ruta+"siguiente.png"));
        jbSiguiente.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev3){
                if (posicion < aBrazos.tamano()) {
                    posicion ++;
                }
        //        jlArea.setText(aBrazos.getBrazo(posicion).getArea());
                jlEjercicio.setText(aBrazos.getBrazo(posicion).getEjercicio());  
                jlImagen.setIcon(aBrazos.getBrazo(posicion).getImagen());
                jlCuenta.setText((posicion + 1)+" de " + aBrazos.contar());    
                SwingUtilities.updateComponentTreeUI(jpImagen);
            }
        });

        JButton jbFinal = new JButton(new ImageIcon(ruta+"final.png"));
        jbFinal.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ev4){
                posicion = aBrazos.tamano();
        //        jlArea.setText(aBrazos.getBrazo(posicion).getArea());
                jlEjercicio.setText(aBrazos.getBrazo(posicion).getEjercicio());  
                jlImagen.setIcon(aBrazos.getBrazo(posicion).getImagen());
                jlCuenta.setText((posicion + 1)+" de " + aBrazos.contar());    
                SwingUtilities.updateComponentTreeUI(jpImagen);
            }
        });

        JButton jbTimer = new JButton(new ImageIcon(ruta+"timer.png"));
            jbTimer.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ev6){
                    
                    Timer timer = new Timer();
                    segundos = aBrazos.getBrazo(posicion).getTrabajo();
                    
                    TimerTask task = new TimerTask(){
                        public void run(){
                            String tiempo;
                            Sonido sonido = new Sonido();
                            tiempo = (segundos > 9) ? "00:" + segundos : "00:0" + segundos;
                            jlTimer.setText(tiempo);    
                            SwingUtilities.updateComponentTreeUI(jpImagen);            
                            segundos --;

                            if (segundos == -1) {
                                timer.cancel();
                                try {
                                    sonido.reproducir("D:\\Frank\\proyectos\\sistemaEjercicios\\res\\sound\\beep1.wav");
                                } catch(Exception e){
                                    System.out.println("No entra el audio");
                                }    
                            }
                        }
                    };
                    timer.scheduleAtFixedRate(task, 1000, 1000); 
                }
        });

        //Configuracion de botones para el panel,  se pone opaco, se quita el borde y se añade un efecto de presionado
        jbInicio.setOpaque(true);
        jbInicio.setBorder(null);
        jbInicio.setPressedIcon(new ImageIcon(ruta+"inicio45.png"));

        jbAnterior.setOpaque(true);
        jbAnterior.setBorder(null);
        jbAnterior.setPressedIcon(new ImageIcon(ruta+"anterior45.png"));

        jbTerminado.setOpaque(true);
        jbTerminado.setBorder(null);
        jbTerminado.setPressedIcon(new ImageIcon(ruta+"terminado45.png"));

        jbSiguiente.setOpaque(true);
        jbSiguiente.setBorder(null);
        jbSiguiente.setPressedIcon(new ImageIcon(ruta+"siguiente45.png"));

        jbFinal.setOpaque(true);
        jbFinal.setBorder(null);
        jbFinal.setPressedIcon(new ImageIcon(ruta+"final45.png"));

        jbTimer.setOpaque(true);
        jbTimer.setBorder(null);
        jbTimer.setPressedIcon(new ImageIcon(ruta+"timer45.png"));

        //se añaden las etiquetas a su respectivo panel
        jpEjercicio.add(jlArea);            
        jpEjercicio.add(jlEjercicio);
        jpImagen.add(jlImagen);
        jpTemporizador.add(jlCuenta);
        jpTemporizador.add(jlTimer);
        jpImagen.add(jpTemporizador);

        //los botones se añaden al panel de botones
        jpBotones.add(jbInicio);
        jpBotones.add(jbAnterior);
        jpBotones.add(jbTerminado);
        jpBotones.add(jbSiguiente);
        jpBotones.add(jbFinal);
        jpBotones.add(jbTimer);

        //Color a los paneles
        jpEjercicio.setBackground(Color.white);
        jpImagen.setBackground(Color.white);
        jpTemporizador.setBackground(Color.white);
        jpBotones.setBackground(Color.white);

        //Se organizan elementos en paneles y se añaden al frame principal
        jfPrincipal.add(jpEjercicio, BorderLayout.NORTH);
        jfPrincipal.add(jpImagen, BorderLayout.CENTER);
        jfPrincipal.add(jpBotones, BorderLayout.SOUTH);

        //Configuracion del frame principal
        jfPrincipal.setSize(410, 482);
        jfPrincipal.setLocation (400, 150);
        jfPrincipal.setResizable(true);
        jfPrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jfPrincipal.setVisible(true);


    }//IGUBrazo

}//IGUBrazo

