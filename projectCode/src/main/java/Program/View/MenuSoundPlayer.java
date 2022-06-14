package Program.View;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class MenuSoundPlayer {
    private static AudioClip buttonSound;
    private static AudioClip clickSound;





    ////methods////
    public MenuSoundPlayer()
    {
        initializeButtonSound();
    }



    private void initializeButtonSound()
    {
        buttonSound = new AudioClip(String.valueOf(getClass().getResource("/Sounds/whoosh.mp3")));
        buttonSound.setVolume(0.2);

        clickSound = new AudioClip(String.valueOf(getClass().getResource("/Sounds/click.mp3")));
        clickSound.setVolume(0.2);
        clickSound.setRate(1.35);
    }



    public static void playButtonSound()
    {
        buttonSound.play();
    }



    public static void playClickSound()
    {
        clickSound.play();
    }
}
