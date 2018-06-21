package danish.azam.dyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class finalactivity extends AppCompatActivity {
TextView a;
Button next;
String branchyear;
EditText candidatename,candidatemobileno,candidateemailid,candidatecast,candidatecategory,candidateaddress,fathername,fatheroccupation,fathermobileno;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finalactivity);
        Bundle bundle=getIntent().getExtras();
         branchyear=bundle.getString("branchyear");
        a=(TextView)findViewById(R.id.a);
        a.setText(branchyear);
        next=(Button)findViewById(R.id.next);
        candidatename=(EditText)findViewById(R.id.candidatename);
        candidatemobileno=(EditText)findViewById(R.id.candidatemobileno);
        candidateemailid=(EditText)findViewById(R.id.candidateemailid);
        candidatecast=(EditText)findViewById(R.id.candidatecast);
        candidatecategory=(EditText)findViewById(R.id.candidatecategory);
        candidateaddress =(EditText)findViewById(R.id.candidateaddress);
        fathername=(EditText)findViewById(R.id.fathername);
        fatheroccupation=(EditText)findViewById(R.id.fatheroccupation);
        fathermobileno=(EditText)findViewById(R.id.fathermobileno);

    }
    public void nextmethod(View view){

        Intent send=new Intent(finalactivity.this,marksactivity.class);
        send.putExtra("by",branchyear);
        send.putExtra("cn",candidatename.getText().toString());
        send.putExtra("cmn",candidatemobileno.getText().toString());
        send.putExtra("ce",candidateemailid.getText().toString());
        send.putExtra("cc",candidatecast.getText().toString());
        send.putExtra("ccat",candidatecategory.getText().toString());
        send.putExtra("ca",candidateaddress.getText().toString());
        send.putExtra("fn",fathername.getText().toString());
        send.putExtra("fmn",fathermobileno.getText().toString());
        send.putExtra("fo",fatheroccupation.getText().toString());


        startActivity(send);

    }
}
