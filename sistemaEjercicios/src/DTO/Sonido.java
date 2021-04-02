package DTO;

import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sonido {
    
    public void reproducir(String ruta) throws Exception {

        File audio = new File(ruta);
        AudioInputStream ais = AudioSystem.getAudioInputStream(audio);

        Clip clip = AudioSystem.getClip();
        clip.open(ais);
        clip.start();

        do  {
            Thread.sleep(100);
        } while (clip.isRunning());

        clip.close();
        ais.close();
    }
}
