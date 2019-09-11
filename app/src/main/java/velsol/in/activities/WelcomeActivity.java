package velsol.in.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;

import com.tfb.fbtoast.FBToast;

import velsol.in.R;
import velsol.in.activities.employee.EmployeeHomeActivity;
import velsol.in.activities.employee.EmployeeLoginActivity;

public class WelcomeActivity extends AppCompatActivity {
    RadioButton mRadioEmployeeLogin,mRadioVmsAdminLogin;
    AppCompatButton mBtnWelcomeNext;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        getSupportActionBar().hide();
        initViews();
    }
    private void initViews()
    {
        mRadioEmployeeLogin=(RadioButton)findViewById(R.id.radio_employees);
        mRadioVmsAdminLogin=(RadioButton)findViewById(R.id.radio_vms_admin);
        mBtnWelcomeNext=(AppCompatButton)findViewById(R.id.welcome_screen_next_btn);

        mRadioEmployeeLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    mRadioEmployeeLogin.setTextColor(Color.WHITE);
                    i=1;
                }
                else {
                    mRadioEmployeeLogin.setTextColor(Color.BLACK);
                }
            }
        });

        mRadioVmsAdminLogin.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b)
                {
                    mRadioVmsAdminLogin.setTextColor(Color.WHITE);
                    i=2;
                }
                else {
                    mRadioVmsAdminLogin.setTextColor(Color.BLACK);
                }
            }
        });

        mBtnWelcomeNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (i==1)
                {
                        FBToast.successToast(WelcomeActivity.this, "Employee Login Selected", FBToast.LENGTH_SHORT);
                        startActivity(new Intent(WelcomeActivity.this, EmployeeLoginActivity.class));
                }
                else if (i==2)
                {
                    FBToast.successToast(WelcomeActivity.this, "VMS Admin Login Selected", FBToast.LENGTH_SHORT);
                }
                else {
                    FBToast.errorToast(WelcomeActivity.this,"Please Select Your Login Type",FBToast.LENGTH_SHORT);
                }
            }
        });
    }

}
