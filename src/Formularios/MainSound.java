package Formularios;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javazoom.jl.decoder.Bitstream;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.decoder.SampleBuffer;
import javazoom.jl.player.Player;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackListener;

public class MainSound {
    private SourceDataLine line;
    public FloatControl fc;
    public Clip clip;
    int cancion; boolean repetir=false;
    public AdvancedPlayer player;
    public int volumen = 50; 
    private Thread playThread;
    public boolean isPlaying;
    
    public void setfile(String file){
        try {
            // Obtener la URL del archivo de audio en los recursos
            InputStream audioStream = MainSound.class.getResourceAsStream(file);
            if (audioStream == null) {
                throw new IllegalArgumentException("Archivo de audio no encontrado: " + file);
            }
            // Abrir el flujo de audio
            AudioInputStream aIS = AudioSystem.getAudioInputStream(audioStream);

            // Obtener un Clip para reproducir el audio
            clip = AudioSystem.getClip();
            clip.open(aIS);

            // Obtener el control de volumen
            fc = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            repetir = false;

            System.out.println("Audio cargado correctamente.");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }
    }
    /*
    public void play(File file){
        //clip.start();
    }*/
    public void loopon(/*File file*/boolean loop){
        if (clip != null && !repetir) {
            if (loop) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            } else {
                clip.start();
            }
            repetir = true;
            System.out.println("Reproduciendo audio" + (loop ? " en bucle..." : "..."));
        }
    }
    
    public void stop(){
         /*if (clip != null && repetir) {
            clip.stop();
            clip.setFramePosition(0); // Reiniciar el clip para la próxima reproducción
            repetir = false;
            System.out.println("Audio detenido.");
        } */
         player.stop();
         close();
    }
    public void close(){
        //clip.close();
        player.close();
    }
    public void setVolumen(float vol) {
        try{
            /*if(clip !=null){
                if (volumen < fc.getMinimum()) {
                volumen = fc.getMinimum();
                } else if (volumen > fc.getMaximum()) {
                    volumen = fc.getMaximum();
                }
                fc.setValue(volumen);
                System.out.println("Volumen ajustado a: " + volumen);
            }  
            volumen =(int) vol*100;
            if (fc != null) {
                float min = fc.getMinimum();
                float max = fc.getMaximum();
                float dB = min + (max - min) * vol;
                fc.setValue(dB);
                System.out.println(dB); 
                System.out.println(fc.getValue());
            }*/
            if((vol*100)>0){
                player.stop();
                System.out.println("mute");
            }else{
                player.play();
                System.out.println("volumen ajustado");
            }
            //System.out.println("Volumen ajustado a: " + (vol*100)+"%");
            
        }catch(Exception e){
            System.out.println("Error al cambiar volumen");
        }
        
    }
    
    public void identificarCancion(int id){
        switch (id){
            case 1:
                System.out.println("cancion 1");
                String file="/Audios/Menu Principal-Soundtrack.wav";
                setfile(file);
                //reproducir_mp3("src/Audios/Menu_Principal-Soundtrack.mp3");
                break;
            case 2:
                System.out.println("cancion 2");
                //File file=new File("/Audios/nombre.wav");
                break;
            case 3:
                System.out.println("cancion 3");
                //File file=new File("/Audios/nombre.wav");
                break;
            case 4:
                System.out.println("cancion 4");
                //File file=new File("/Audios/nombre.wav");
                break;
            default:
                System.out.println("Error al identificar la cancion");
                break;
        }
    }
    public void reproducir_mp3(String file){
        do{
            if (!repetir) {
            isPlaying = true;

            playThread = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        while (isPlaying) {
                            InputStream inputStream = new FileInputStream(file);
                            player = new AdvancedPlayer(inputStream);
                            player.play();
                        }
                    } catch (Exception e) {
                        System.out.println("Error al reproducir el archivo MP3: " + e.getMessage());
                    }
                }
            });

            playThread.start();
        }
        }while(repetir);
    }
}