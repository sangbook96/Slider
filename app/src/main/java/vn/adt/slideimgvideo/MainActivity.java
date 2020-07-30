package vn.adt.slideimgvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import vn.adt.slider.posters.DrawableImage;
import vn.adt.slider.posters.Poster;
import vn.adt.slider.posters.RemoteVideo;
import vn.adt.slider.views.PosterSlider;


public class MainActivity extends AppCompatActivity {
    private PosterSlider posterSlider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        posterSlider = (PosterSlider) findViewById(R.id.poster_slider);
        List<Poster> posters = new ArrayList<>();
        posters.add(new DrawableImage(R.drawable.img_5126));
        posters.add(new DrawableImage(R.drawable.art_category));
        posters.add(new RemoteVideo(Uri.parse("https://api-display.smart-one.io/files/company_1/1583744488-brand_new_adt.mp4")));
        posterSlider.setLoopSlides(true);
        posterSlider.setPosters(posters);
    }
}