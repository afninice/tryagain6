package afniramadania.tech.mycatalogmovie;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private  MovieAdapter adapter;
    private String[] dataName;
    private String[] dataDescription;
    private String[] dataDirector;
    private TypedArray dataPhoto;
    private  ArrayList<Movie> movies;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);

        final ListView list = findViewById(R.id.lv_list);
        list.setAdapter(adapter);

        prepare();
        addItem();

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                final Movie movie = movies.get(position);
                Bundle bundle = new Bundle();
                bundle.putInt(DetailMovie.IMG_PHOTO, movie.getFoto());
                Intent moveWithDataIntent = new Intent(view.getContext(), DetailMovie.class);
                moveWithDataIntent.putExtra(DetailMovie.NAMA_FILM, movie.getName());
                moveWithDataIntent.putExtras(bundle);
                moveWithDataIntent.putExtra(DetailMovie.DESKRIPSI_FILM, movie.getDeskripsi());
                moveWithDataIntent.putExtras(bundle);
                moveWithDataIntent.putExtra(DetailMovie.DIRECTOR_FILM, movie.getDirector());
                view.getContext().startActivity(moveWithDataIntent);

            }
        });
    }

    private void prepare() {
        dataName = getResources().getStringArray(R.array.name);
        dataDescription = getResources().getStringArray(R.array.deskripsi);
        dataDirector = getResources().getStringArray(R.array.director);
        dataPhoto = getResources().obtainTypedArray(R.array.foto);

    }

    private void addItem() {
        movies = new ArrayList<>();
        for (int i = 0; i < dataName.length; i++) {
            Movie movie = new Movie();
            movie.setFoto(dataPhoto.getResourceId(i, -1));
            movie.setName(dataName[i]);
            movie.setDeskripsi(dataDescription[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);

    }



}
