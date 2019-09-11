package velsol.in.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import velsol.in.R;

public class IntroActivity extends AppCompatActivity {
    AppCompatButton mBtnGetStarted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        getSupportActionBar().hide();

        mBtnGetStarted=(AppCompatButton)findViewById(R.id.get_started_btn_intro_screen);
        mBtnGetStarted.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(IntroActivity.this,WelcomeActivity.class));
            }
        });
    }
}
