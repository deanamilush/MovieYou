package com.dean.movieyou;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private int photo;
    private String judul;
    private String genre;
    private String isi_sinopsis;
    private String sutradara;
    private String tanggal;

    protected Movie(Parcel in) {
        photo = in.readInt();
        judul = in.readString();
        genre = in.readString();
        isi_sinopsis = in.readString();
        sutradara = in.readString();
        tanggal = in.readString();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie() {

    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsi_sinopsis() {
        return isi_sinopsis;
    }

    public void setIsi_sinopsis(String isi_sinopsis) {
        this.isi_sinopsis = isi_sinopsis;
    }

    public String getSutradara() {
        return sutradara;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(photo);
        dest.writeString(judul);
        dest.writeString(genre);
        dest.writeString(isi_sinopsis);
        dest.writeString(sutradara);
        dest.writeString(tanggal);
    }
}
