package danish.azam.dyp;

import android.content.Intent;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
RelativeLayout relativeLayout,relativeLayout2,pr,mainactivity;
EditText email,password;
TextView azam;
Button signin;

    private FirebaseAuth mAuth;
Handler handler=new Handler();
Runnable runnable= new Runnable() {
    @Override
    public void run() {
        relativeLayout.setVisibility(View.VISIBLE);
        relativeLayout2.setVisibility(View.GONE);
        mainactivity.setBackgroundResource(R.drawable.background);
        azam.setTextColor(getResources().getColor(R.color.white));
        signin.setBackgroundResource(R.drawable.buttunbg);
    }
};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout= (RelativeLayout)findViewById(R.id.layout1);
        relativeLayout2=(RelativeLayout)findViewById(R.id.logolayout);
        handler.postDelayed(runnable,2000);
        mAuth = FirebaseAuth.getInstance();
        email=(EditText)findViewById(R.id.emailsignin);
        password=(EditText)findViewById(R.id.passwordsignin);
        pr=(RelativeLayout)findViewById(R.id.pr);
        mainactivity=(RelativeLayout)findViewById(R.id.mainlayout);
        azam=(TextView)findViewById(R.id.azam);
        signin=(Button)findViewById(R.id.signin);
    }
    public void signupmethod(View view){
        startActivity(new Intent(MainActivity.this,signupactivity.class));
    }
    public  void signinmethod(View view){

        String emailstring,passwordstring;
        emailstring=email.getText().toString().trim();
        passwordstring=password.getText().toString().trim();
        if (emailstring.isEmpty()){
            email.setError("E-mail is required");
            email.requestFocus();
            return;
        }
        if(passwordstring.isEmpty()){
            password.setError("Password Required");
            password.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(emailstring).matches()){
            email.setError("Enter a valid Email");
            email.requestFocus();
            return;

        }
        if (passwordstring.length()<6){
            password.setError("Wrong password ");
            password.requestFocus();
            return;
        }
        pr.setVisibility(View.VISIBLE);
        mAuth.signInWithEmailAndPassword(emailstring, passwordstring)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        pr.setVisibility(View.GONE);
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            startActivity(new Intent(MainActivity.this,picactivity.class));


                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(getApplicationContext(), "Authentication failed. TRY AGAIN",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });

    }
    public void resetpassword(View view){
        startActivity(new Intent(MainActivity.this,resetactivity.class));

    }
    public void contactus(View view){
startActivity(new Intent(MainActivity.this,contactus.class));
    }
}
