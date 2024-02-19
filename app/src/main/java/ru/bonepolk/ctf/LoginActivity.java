package ru.bonepolk.ctf;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.Task;

import ru.bonepolk.ctf.Utils.AccountManager;
import ru.bonepolk.ctf.Utils.PreferenceUtils;

public class LoginActivity extends AppCompatActivity {
    private static final int SIGN_IN = 10293;
    private static final String TAG = LoginActivity.class.getSimpleName();
    public static GoogleSignInClient mGoogleSignInClient;
    SharedPreferences prefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);


        prefs = PreferenceUtils.getSharedPreference(getApplicationContext(), "App");
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken("154112459402-v9suu3dge9353kf4meqn8rrqh1c2v39s.apps.googleusercontent.com")
                .requestEmail()
                .build();
        mGoogleSignInClient = GoogleSignIn.getClient(getApplicationContext(), gso);

        Button sign_in = findViewById(R.id.sign_in);
        sign_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });
        signIn();

    }

    private void signIn(){
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, SIGN_IN);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SIGN_IN ) {

            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                GoogleSignInAccount account = task.getResult(ApiException.class);
                AccountManager.name = account.getDisplayName();
                AccountManager.email = account.getEmail();
                AccountManager.picture_url = account.getPhotoUrl();
                if (PreferenceUtils.readPrefInt(prefs, "panelType", -1) != -1){
                    ChoiceActivity.startMain(this);
                } else {
                    Intent i = new Intent(this, ChoiceActivity.class);
                    startActivity(i);
                    finishAffinity();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
