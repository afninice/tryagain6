package afniramadania.tech.mycatalogmovie;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {

    private int foto;
    private String name;
    private String deskripsi;
    private String director;


    protected Movie (Parcel in) {
        foto = in.readInt();
        name = in.readString();
        deskripsi = in.readString();
        director = in.readString();
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

    public Integer getFoto() {
        return foto;
    }

    public void setFoto(Integer foto) {this.foto = foto; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {this.deskripsi = deskripsi; }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int i) {
        dest.writeInt(this.foto);
        dest.writeString(this.name);
        dest.writeString(this.deskripsi);
        dest.writeString(this.director);

    }



}