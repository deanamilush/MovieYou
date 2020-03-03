package com.dean.movieyou;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MvAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<Movie> movies = new ArrayList<>();

    public MvAdapter(Context context) {
        this.context = context;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    @Override
    public int getCount() {
        return movies.size();
    }

    @Override
    public Object getItem(int position) {
        return movies.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(context).inflate(R.layout.item_mv, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(itemView);
        Movie hero = (Movie) getItem(i);
        viewHolder.bind(hero);
        return itemView;
    }

    private class ViewHolder {
        private TextView judul;
        private TextView isi_sinopsis;
        private ImageView imgPhoto;

        ViewHolder(View view) {
            judul = view.findViewById(R.id.judul);
            isi_sinopsis = view.findViewById(R.id.isi_sinopsis);
            imgPhoto = view.findViewById(R.id.img_photo);
        }

        void bind(Movie hero) {
            judul.setText(hero.getJudul());
            isi_sinopsis.setText(hero.getIsi_sinopsis());
            imgPhoto.setImageResource(hero.getPhoto());
        }
    }
}
