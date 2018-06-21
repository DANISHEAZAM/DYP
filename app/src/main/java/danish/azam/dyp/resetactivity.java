package danish.azam.dyp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class resetactivity extends AppCompatActivity {
private EditText resetemail;
Button resetbutton;
ProgressBar pbar;
FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resetactivity);

        resetemail=(EditText)findViewById(R.id.resetemail);
        resetbutton=(Button)findViewById(R.id.resetbutton);
        pbar=(ProgressBar)findViewById(R.id.pbar);
        firebaseAuth=FirebaseAuth.getInstance();
    }
    public void resetmethod(View view){
        String resetemailstring=resetemail.getText().toString().trim();
        if(resetemailstring.isEmpty()){
            resetemail.setError("Email Required");
            resetemail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(resetemailstring).matches()){
            resetemail.setError("Enter a valid E-mail");
            resetemail.requestFocus();
            return;
        }
        pbar.setVisibility(View.VISIBLE);
     firebaseAuth.sendPasswordResetEmail(resetemailstring).addOnCompleteListener(new OnCompleteListener<Void>() {
         @Override
         public void onComplete(@NonNull Task<Void> task) {
             pbar.setVisibility(View.GONE);
             if (task.isSuccessful()){
                 Toast.makeText(getApplicationContext(),"Password reset E-mail sent",Toast.LENGTH_SHORT).show();
             }
             else{
                 Toast.makeText(getApplicationContext(),"Some error ocurred try again",Toast.LENGTH_SHORT).show();
             }
         }
     })  ;
    }
}
