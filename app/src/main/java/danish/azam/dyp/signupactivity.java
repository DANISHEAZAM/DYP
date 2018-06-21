package danish.azam.dyp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signupactivity extends AppCompatActivity {
EditText email,password;
ProgressBar progressBar;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signupactivity);
        email=(EditText)findViewById(R.id.emailsignup);
        password=(EditText)findViewById(R.id.passwordsignup);
        progressBar=(ProgressBar)findViewById(R.id.progressbar);
        mAuth = FirebaseAuth.getInstance();

    }

    public void registeruser(View view){

        String emailstring=email.getText().toString().trim();
        String passwordstring=password.getText().toString().trim();
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
            password.setError("Password too short");
            password.requestFocus();
            return;
        }
progressBar.setVisibility(View.VISIBLE);
        mAuth.createUserWithEmailAndPassword(emailstring, passwordstring)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressBar.setVisibility(View.GONE);
                        if (task.isSuccessful()) {

                            // Sign in success, update UI with the signed-in user's information
                           Toast.makeText(getApplicationContext(),"User successfully registered",Toast.LENGTH_SHORT).show();
                                  startActivity(new Intent(signupactivity.this,MainActivity.class));

                        } else {
                            // If sign in fails, display a message to the user.

                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();

                        }

                        // ...
                    }
                });


    }
}
