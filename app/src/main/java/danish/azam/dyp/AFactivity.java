package danish.azam.dyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AFactivity extends AppCompatActivity {
Button FEE,DSEE,MEE,FED,DSED,MCA,MBA,FYarchitecture,FYagriculture;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_afactivity);
        FEE=(Button)findViewById(R.id.FEE);
        DSEE=(Button)findViewById(R.id.DSEE);
        MEE=(Button)findViewById(R.id.MEE);
        FED=(Button)findViewById(R.id.FED);
        DSED=(Button)findViewById(R.id.DSED);
        MCA=(Button)findViewById(R.id.MCA);
        MBA=(Button)findViewById(R.id.MBA);
        FYarchitecture=(Button)findViewById(R.id.FYarchitecture);
        FYagriculture=(Button)findViewById(R.id.FYagriculture);
    }

    public void finalmethod(View view){
      String branchyear=view.getTag().toString();
      Intent intent=new Intent(AFactivity.this,finalactivity.class);
      intent.putExtra("branchyear",branchyear);

      startActivity(intent);


    }

}
