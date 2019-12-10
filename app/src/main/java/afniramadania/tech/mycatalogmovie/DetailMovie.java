package afniramadania.tech.mycatalogmovie;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailMovie extends AppCompatActivity {

    public  static final String IMG_PHOTO      = "PHOTO_FILM" ;
    public static final  String NAMA_FILM      = "NAMA_FILM";
    public static final  String DESKRIPSI_FILM ="DESKRIPSI_FILM";
    public static final  String DIRECTOR_FILM  ="DIRECTOR_FILM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_movie);
        ImageView imgPhoto =findViewById(R.id.img_item_photo);
        TextView tvName   = findViewById(R.id.tv_item_name);
        TextView tvDesc   = findViewById(R.id.tv_item_deskripsi);
        TextView tvDirec   = findViewById(R.id.tv_item_director);

        Bundle bundle = getIntent().getExtras();
        String NAMA = getIntent().getStringExtra(NAMA_FILM);
        String DESKRIPSI = getIntent().getStringExtra(DESKRIPSI_FILM);
        String DIRECTOR = getIntent().getStringExtra(DIRECTOR_FILM);
        Integer IMG = getIntent().getIntExtra(IMG_PHOTO,0);




        tvName.setText(NAMA);
        tvDesc.setText(DESKRIPSI);
        imgPhoto.setImageResource(IMG);
        if (getSupportActionBar() != null ){
            getSupportActionBar().setTitle(NAMA);
        }

    }

}
