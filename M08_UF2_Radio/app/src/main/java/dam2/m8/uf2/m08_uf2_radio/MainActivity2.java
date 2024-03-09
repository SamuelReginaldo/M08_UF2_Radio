package dam2.m8.uf2.m08_uf2_radio;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioAttributes;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {
    MediaPlayer mediaPlayer;
    ImageButton botonPlay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        configuracionInicial();

    }

    public void configuracionInicial(){
        botonPlay = findViewById(R.id.imageButton);
        botonPlay.setVisibility(View.INVISIBLE);
        //String url = "https://shoutcast.ccma.cat/ccma/catalunyaradioHD.mp3"; // your URL here
        String url = "https://libertaddigital-radio-live1.flumotion.com/libertaddigital/ld-live1-med.aac"; // your URL here

        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioAttributes(
                new AudioAttributes.Builder()
                        .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                        .setUsage(AudioAttributes.USAGE_MEDIA)
                        .build()
        );
        try {
            mediaPlayer.setDataSource(url);
            mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    botonPlay.setVisibility(View.VISIBLE);
                }
            });
            mediaPlayer.prepareAsync(); // might take long! (for buffering, etc)
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }
    }
    public void onClickPlay(View view){
        mediaPlayer.start();
    }

    public void onClickStop(View view){

    }
}