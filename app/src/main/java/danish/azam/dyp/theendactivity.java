package danish.azam.dyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class theendactivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_theendactivity);
    }
    public void gotohome(View view){
        startActivity(new Intent(theendactivity.this,picactivity.class));
    }
}
