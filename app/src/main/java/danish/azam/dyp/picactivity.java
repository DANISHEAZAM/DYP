package danish.azam.dyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class picactivity extends AppCompatActivity {
Button AF,FS,G;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picactivity);
        AF=(Button)findViewById(R.id.AF);
        FS=(Button)findViewById(R.id.FS);
        G=(Button)findViewById(R.id.G);



    }
    public void feemethod(View view){
        startActivity(new Intent(picactivity.this,feestructure.class));

    }
    public void gallerymethod(View view){

        startActivity(new Intent(picactivity.this,galleryactivity.class));

    }
    public void AFmethod(View view){
        startActivity(new Intent(picactivity.this,AFactivity.class));

    }
}
