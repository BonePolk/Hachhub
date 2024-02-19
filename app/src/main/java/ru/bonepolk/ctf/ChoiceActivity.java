package ru.bonepolk.ctf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import ru.bonepolk.ctf.Utils.AccountManager;
import ru.bonepolk.ctf.Utils.PreferenceUtils;

public class ChoiceActivity extends AppCompatActivity {
    SharedPreferences prefs;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice);


        prefs = PreferenceUtils.getSharedPreference(getApplicationContext(), "App");

        ((TextView)findViewById(R.id.hello)).setText("Привет, "+ AccountManager.name+"!");

        findViewById(R.id.participant_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMain(ChoiceActivity.this, 0);
            }
        });

        findViewById(R.id.organizer_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startMain(ChoiceActivity.this, 1);
            }
        });
    }

    static void startMain(Context ctx){
        Intent i = new Intent(ctx, MainActivity.class);
        ctx.startActivity(i);
    }

    static void startMain(Context ctx, int panelType) {
        SharedPreferences prefs = PreferenceUtils.getSharedPreference(ctx, "App");
        PreferenceUtils.writePrefInt(prefs, "panelType", panelType);
        startMain(ctx);
    }
}
