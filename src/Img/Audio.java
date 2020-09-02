package Img;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

public class Audio
{
    public Audio()
    {
        Clip audio;
        try {
            audio = AudioSystem.getClip();
            File ar = new File("src/Img/audio.wav");
            audio.open(AudioSystem.getAudioInputStream( ar ));
            audio.start();
            Thread.sleep( 40000 );
        } catch (LineUnavailableException | UnsupportedAudioFileException | IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
