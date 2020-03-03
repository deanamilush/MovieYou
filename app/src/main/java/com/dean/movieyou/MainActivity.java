package com.dean.movieyou;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.os.Looper.prepare;

public class MainActivity extends AppCompatActivity {

    private MvAdapter adapter;
    private String[] dataName;
    private String[] dataDescription, dataGenre, dataDirec, dataDate;
    private TypedArray dataPhoto;
    private ArrayList<Movie> heroes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView listView = findViewById(R.id.mv_list);
        adapter = new MvAdapter(this);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie movies = new Movie();
                movies.setPhoto(dataPhoto.getResourceId(i,-1));
                movies.setJudul(dataName[i]);
                movies.setIsi_sinopsis(dataDescription[i]);
                movies.setGenre(dataGenre[i]);
                movies.setSutradara(dataDirec[i]);
                movies.setTanggal(dataDate[i]);
                Intent gotodetail = new Intent(MainActivity.this, DetailActivity.class);
                gotodetail.putExtra(DetailActivity.EXTRA_PERSON, movies);
                startActivity(gotodetail);
            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.data_name);
        dataDescription = getResources().getStringArray(R.array.data_description);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataDate = getResources().getStringArray(R.array.data_tanggal);
        dataDirec = getResources().getStringArray(R.array.data_sutradara);
        dataPhoto = getResources().obtainTypedArray(R.array.data_photo);
    }
    private void addItem() {
        heroes = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Movie hero = new Movie();
            hero.setPhoto(dataPhoto.getResourceId(i, -1));
            hero.setJudul(dataName[i]);
            hero.setIsi_sinopsis(dataDescription[i]);
            heroes.add(hero);
        }
        adapter.setMovies(heroes);
    }

}
