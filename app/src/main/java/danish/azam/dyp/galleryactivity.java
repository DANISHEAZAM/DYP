package danish.azam.dyp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class galleryactivity extends AppCompatActivity {

int []images={R.drawable.a,R.drawable.b,R.drawable.c,R.drawable.d,R.drawable.d,R.drawable.e,R.drawable.f,R.drawable.g};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_galleryactivity);

    }

}
