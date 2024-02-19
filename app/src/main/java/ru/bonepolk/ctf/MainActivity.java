package ru.bonepolk.ctf;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import com.squareup.picasso.Picasso;

import ru.bonepolk.ctf.Utils.AccountManager;
import ru.bonepolk.ctf.Utils.PreferenceUtils;
import ru.bonepolk.ctf.Fragments.ParticipantPanel;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    SharedPreferences prefs;
    FragmentTransaction fragmentTransaction;
    ParticipantPanel participantPanel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main);

        prefs = PreferenceUtils.getSharedPreference(getApplicationContext(), "App");
        drawerLayout = findViewById(R.id.drawer_layout);
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_closed);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
            switch (PreferenceUtils.readPrefInt(prefs, "panelType", -1)){
                case 0:
                    actionBar.setTitle("Участник");
                    break;
                case 1:
                    actionBar.setTitle("Организатор");
                    break;
                default:
                    Log.i(TAG, "Unsupported panelType: "+PreferenceUtils.readPrefInt(prefs, "panelType", -1));
            }
        }


        Picasso.get().load(AccountManager.picture_url).into((ImageView) findViewById(R.id.logo_img));
        ((TextView)findViewById(R.id.name)).setText(AccountManager.name);
        ((TextView)findViewById(R.id.email)).setText(AccountManager.email);

        participantPanel = new ParticipantPanel();

        initLogic();
    }

    private void initLogic(){
        findViewById(R.id.signout).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        LoginActivity.mGoogleSignInClient.signOut();
                        prefs.edit().clear().apply();
                        Intent i = new Intent(MainActivity.this, LoginActivity.class);
                        startActivity(i);
                        finishAffinity();
                    }
                }
        );

        fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.panelsContainer, participantPanel);
        fragmentTransaction.commit();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
