package velsol.in.activities.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.tfb.fbtoast.FBCustomToast;
import com.tfb.fbtoast.FBToast;

import velsol.in.R;

public class EmployeeLoginActivity extends AppCompatActivity {
    TextInputEditText mInputUSerName,mInputPassword;
    Button mBtnEmployeeLogin;
    TextView mLabelForgotPassword,mLabelCreateEmplopyee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_login);
        getSupportActionBar().hide();
        initViews();
    }
    private void initViews(){
        mInputUSerName=(TextInputEditText)findViewById(R.id.employee_login_input_user_name);
        mInputPassword=(TextInputEditText)findViewById(R.id.employee_login_input_password);
        mLabelCreateEmplopyee=(TextView)findViewById(R.id.employee_login_label_create_user);
        mLabelForgotPassword=(TextView)findViewById(R.id.employee_login_label_foegot_password);
        mBtnEmployeeLogin=(Button)findViewById(R.id.employee_login_btn_login);

        mBtnEmployeeLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mInputUSerName.getText().toString().trim().equals(""))
                {
                 mInputUSerName.setError("Required");
                 mInputUSerName.requestFocus();
                }
               else if (mInputPassword.getText().toString().trim().equals(""))
                {
                    mInputPassword.setError("Required");
                    mInputPassword.requestFocus();
                }
               else {
                   if (mInputUSerName.getText().toString().trim().equals("emp"))
                   {
                       if (mInputPassword.getText().toString().trim().equals("emp"))
                       {
                           FBToast.successToast(EmployeeLoginActivity.this,"Valid Employee",FBToast.LENGTH_SHORT);
                           finish();
                           startActivity(new Intent(EmployeeLoginActivity.this,EmployeeHomeActivity.class));
                       }
                       else {
                           FBToast.errorToast(EmployeeLoginActivity.this,"Invalid Password",FBToast.LENGTH_SHORT);
                       }
                   }
                   else {
                       FBToast.errorToast(EmployeeLoginActivity.this,"Invalid USer Name",FBToast.LENGTH_SHORT);
                   }
                }
            }
        });
        mLabelForgotPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FBToast.successToast(EmployeeLoginActivity.this,"Forgot Password",FBToast.LENGTH_SHORT);
            }
        });
        mLabelCreateEmplopyee.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FBToast.successToast(EmployeeLoginActivity.this,"Create Employee",FBToast.LENGTH_SHORT);
                startActivity(new Intent(EmployeeLoginActivity.this,EmployeeAuthorizationActivity.class));
            }
        });
    }
}
