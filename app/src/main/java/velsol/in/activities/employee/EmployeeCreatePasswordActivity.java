package velsol.in.activities.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.tfb.fbtoast.FBToast;

import velsol.in.R;

public class EmployeeCreatePasswordActivity extends AppCompatActivity {
    TextInputEditText mInputPassword,mInputConfirmPassword;
    Button mBtnCreate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_create_password);
        initViews();
    }
    private void initViews(){
        mInputPassword=(TextInputEditText)findViewById(R.id.employee_create_password_input_password);
        mInputConfirmPassword=(TextInputEditText)findViewById(R.id.employee_create_password_input_confirmPassword);
        mBtnCreate=(Button)findViewById(R.id.employee_create_password_btn);

        mBtnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mInputPassword.getText().toString().trim().equals(""))
                {
                    if (!mInputConfirmPassword.getText().toString().trim().equals(""))
                    {
                        if (mInputPassword.getText().toString().trim().equals(mInputConfirmPassword.getText().toString().trim()))
                        {
                            FBToast.successToast(EmployeeCreatePasswordActivity.this,"Success Created Employee",FBToast.LENGTH_SHORT);
                            finish();
                            startActivity(new Intent(EmployeeCreatePasswordActivity.this,EmployeeLoginActivity.class));
                        }
                        else {
                            mInputPassword.setError("Password Mismatched");
                            mInputPassword.requestFocus();
                            mInputConfirmPassword.setError("Password Mismatched");
                            mInputConfirmPassword.requestFocus();
                        }
                    }
                    else {
                        mInputConfirmPassword.setError("Password Required");
                        mInputConfirmPassword.requestFocus();
                    }
                }
                else {
                    mInputPassword.setError("Password Required");
                    mInputPassword.requestFocus();
                }
            }
        });
    }
}
