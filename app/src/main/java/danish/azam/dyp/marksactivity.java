package danish.azam.dyp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class marksactivity extends AppCompatActivity {
    String cn,cmn,ce,cc,ccat,ca,fn,fo,fmn,by;
    EditText sscp,dp,hscp,gp,phsc,mhsc,chsc,bhsc,em,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_marksactivity);
       sscp=(EditText)findViewById(R.id.sscpercent);
        dp=(EditText)findViewById(R.id.diplomapercent);
        hscp=(EditText)findViewById(R.id.hscpercent);
        gp=(EditText)findViewById(R.id.graduationpercent);
        phsc=(EditText)findViewById(R.id.phyhsc);
        mhsc=(EditText)findViewById(R.id.mathshsc);
        chsc=(EditText)findViewById(R.id.chemistryhsc);
        bhsc=(EditText)findViewById(R.id.biologyhsc);
        em=(EditText)findViewById(R.id.entrancemarks);
        b=(EditText)findViewById(R.id.branch);
    }
    public  void sendmarks(View view){
        Bundle receive=getIntent().getExtras();
        by=receive.getString("by");
        cn=receive.getString("cn");
        cmn=receive.getString("cmn");
        ce=receive.getString("ce");
        cc=receive.getString("cc");
        ccat=receive.getString("ccat");
        ca=receive.getString("ca");
        fn=receive.getString("fn");
        fo=receive.getString("fo");
        fmn=receive.getString("fmn");



Intent send =new Intent(marksactivity.this,superfinalactivity.class);
        send.putExtra("by",by);
        send.putExtra("cn",cn);
        send.putExtra("cmn",cmn);
        send.putExtra("ce",ce);
        send.putExtra("cc",cc);
        send.putExtra("ccat",ccat);
        send.putExtra("ca",ca);
        send.putExtra("fn",fn);
        send.putExtra("fo",fo);
        send.putExtra("fmn",fmn);
        send.putExtra("sscp",sscp.getText().toString());
        send.putExtra("dp",dp.getText().toString());
        send.putExtra("hscp",hscp.getText().toString());
        send.putExtra("gp",gp.getText().toString());
        send.putExtra("phsc",phsc.getText().toString());
        send.putExtra("mhsc",mhsc.getText().toString());
        send.putExtra("chsc",chsc.getText().toString());
        send.putExtra("bhsc",bhsc.getText().toString());
        send.putExtra("em",em.getText().toString());
        send.putExtra("b",b.getText().toString());
        startActivity(send);

    }

}
