package com.dean.movieyou;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_PERSON = "extra_person";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView judul = findViewById(R.id.judul);
        TextView keterangan = findViewById(R.id.isi_sinopsis);
        ImageView image_act_baru = findViewById(R.id.img_photo);
        TextView genre = findViewById(R.id.genre);
        TextView date = findViewById(R.id.tanggal);
        TextView direc = findViewById(R.id.sutradara);

        Movie movies = getIntent().getParcelableExtra(EXTRA_PERSON);

        judul.setText(movies.getJudul());
        keterangan.setText(movies.getIsi_sinopsis());
        image_act_baru.setImageResource(movies.getPhoto());
        genre.setText(movies.getGenre());
        direc.setText(movies.getSutradara());
        date.setText(movies.getTanggal());
    }
}
