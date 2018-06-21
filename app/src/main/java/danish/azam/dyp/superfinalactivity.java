package danish.azam.dyp;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;

import javax.net.ssl.HttpsURLConnection;

public class superfinalactivity extends AppCompatActivity {
String cn,cmn,ce,cc,ccat,ca,fn,fo,fmn,by;
EditText collegename,branchfinal,signname;
    String sscp,dp,hscp,gp,phsc,mhsc,chsc,bhsc,em,b;
    String coln,bf,sn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_superfinalactivity);
        collegename=(EditText)findViewById(R.id.collegename);
        branchfinal=(EditText)findViewById(R.id.branchfinal);
        signname=(EditText)findViewById(R.id.signname);
    }

    public void pushdatatodatabase(View view){
        coln=collegename.getText().toString();
        bf=branchfinal.getText().toString();
        sn=signname.getText().toString();
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
        sscp=receive.getString("sscp");
        dp=receive.getString("dp");
        hscp=receive.getString("hscp");
        gp=receive.getString("gp");
        phsc=receive.getString("phsc");
        mhsc=receive.getString("mhsc");
        chsc=receive.getString("chsc");
        bhsc=receive.getString("bhsc");
        em=receive.getString("em");
        b=receive.getString("b");
        new SendRequest().execute();
startActivity(new Intent(superfinalactivity.this,theendactivity.class));
    }


    public class SendRequest extends AsyncTask<String, Void, String> {


        protected void onPreExecute(){}

        protected String doInBackground(String... arg0) {

            try{

                URL url = new URL("https://script.google.com/macros/s/AKfycbxiYbL-OxoIyKhevMNTPxKnCeWtUDcUR-RdOmJm0VflZy8Mq7c/exec");
                // https://script.google.com/macros/s/AKfycbxiYbL-OxoIyKhevMNTPxKnCeWtUDcUR-RdOmJm0VflZy8Mq7c/exec
                JSONObject postDataParams = new JSONObject();

                //int i;
                //for(i=1;i<=70;i++)


                //    String usn = Integer.toString(i);

                String id= "1BhuoPFLIGJNyQbZhEhOh4aXhNltnmhjAhOufWFPPY40";

                postDataParams.put("cn",cn);
                postDataParams.put("by",by);
                postDataParams.put("cmn",cmn);
                postDataParams.put("ce",ce);
                postDataParams.put("cc",cc);
                postDataParams.put("ccat",ccat);
                postDataParams.put("ca",ca);
                postDataParams.put("fn",fn);
                postDataParams.put("fmn",fmn);
                postDataParams.put("fo",fo);
                postDataParams.put("sscp",sscp);
                postDataParams.put("dp",dp);
                postDataParams.put("hscp",hscp);
                postDataParams.put("gp",gp);
                postDataParams.put("phsc",phsc);
                postDataParams.put("mhsc",mhsc);
                postDataParams.put("chsc",chsc);
                postDataParams.put("bhsc",bhsc);
                postDataParams.put("em",em);
                postDataParams.put("b",b);
                postDataParams.put("coln",coln);
                postDataParams.put("bf",bf);
                postDataParams.put("sn",sn);



                Log.e("params",postDataParams.toString());

                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setReadTimeout(15000 /* milliseconds */);
                conn.setConnectTimeout(15000 /* milliseconds */);
                conn.setRequestMethod("POST");
                conn.setDoInput(true);
                conn.setDoOutput(true);

                OutputStream os = conn.getOutputStream();
                BufferedWriter writer = new BufferedWriter(
                        new OutputStreamWriter(os, "UTF-8"));
                writer.write(getPostDataString(postDataParams));

                writer.flush();
                writer.close();
                os.close();

                int responseCode=conn.getResponseCode();

                if (responseCode == HttpsURLConnection.HTTP_OK) {

                    BufferedReader in=new BufferedReader(new InputStreamReader(conn.getInputStream()));
                    StringBuffer sb = new StringBuffer("");
                    String line="";

                    while((line = in.readLine()) != null) {

                        sb.append(line);
                        break;
                    }

                    in.close();
                    return sb.toString();

                }
                else {
                    return new String("false : "+responseCode);
                }
            }
            catch(Exception e){
                return new String("Exception: " + e.getMessage());
            }
        }

        @Override
        protected void onPostExecute(String result) {
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();

        }
    }

    public String getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder();
        boolean first = true;

        Iterator<String> itr = params.keys();

        while(itr.hasNext()){

            String key= itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }
        return result.toString();
    }


}
