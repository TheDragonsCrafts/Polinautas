package Formularios;
import java.io.File;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class MainSound {
    public FloatControl fc;
    public Clip clip;
    public int volumen = 50; 
    public boolean mut;
    
    public void setfile(File file){
        try {
            AudioInputStream AIS= AudioSystem.getAudioInputStream(file);
            clip=AudioSystem.getClip();
            clip.open(AIS);
            fc=(FloatControl)clip.getControl(FloatControl.Type.MASTER_GAIN);
            play();
            System.out.println("Audio cargado correctamente.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public void play(){
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
    }
    public void stop(){
        try{
            clip.stop();
            System.out.println("Audio detenido.");
        }catch(Exception e){
            System.out.println("error al pausar audio");
        }
    }
    public void close(){
        clip.close();
    }
    public void setVolumen(float vol){
        try{
            fc.setValue(vol);
            System.out.println("Volumen ajustado a: " + (vol)+" / -80 a 6");            
        }catch(Exception e){
            System.out.println("Error al cambiar volumen");
        }
        
    }
    public void mute(float vol) {
        if (fc != null) {
            if (mut) {
                fc.setValue(vol);
                mut = false;
            } else {
                fc.setValue(fc.getMinimum());
                mut = true;
            }
        }
    }
    
    
    public void identificarCancion(int id){
        switch (id){
            case 1:
                System.out.println("cancion 1");
                File file=new File("src/Audios/Menu Principal.wav");
                setfile(file);
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
}