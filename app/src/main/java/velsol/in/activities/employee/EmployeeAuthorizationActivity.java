package velsol.in.activities.employee;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.google.android.material.textfield.TextInputEditText;
import com.tfb.fbtoast.FBToast;

import velsol.in.R;

public class EmployeeAuthorizationActivity extends AppCompatActivity
{
    TextInputEditText mInputEmployeeFullNameOrId,mInputEmployeeEmailID;
    Button mBtnEMployeeAuthorize;
    CheckBox mCheckAgreeTremsConditions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_authorization);
        getSupportActionBar().hide();
        initViews();
    }

    private void initViews(){
        mInputEmployeeEmailID=(TextInputEditText)findViewById(R.id.employee_authorization_input_email_address);
        mInputEmployeeFullNameOrId=(TextInputEditText)findViewById(R.id.employee_authorization_input_full_name);
        mBtnEMployeeAuthorize=(Button)findViewById(R.id.employee_authorization_btn_authorize);
        mCheckAgreeTremsConditions=(CheckBox)findViewById(R.id.employee_authorization_check_box_agree_terms_conditions);

        mBtnEMployeeAuthorize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!mCheckAgreeTremsConditions.isChecked())
                {
                    FBToast.errorToast(EmployeeAuthorizationActivity.this,"Please Check For Terms and Conditions",FBToast.LENGTH_SHORT);
                }
                else {
                    if (!mInputEmployeeFullNameOrId.getText().toString().trim().equals(""))
                    {
                        if (!mInputEmployeeEmailID.getText().toString().trim().equals(""))
                        {
                           FBToast.successToast(EmployeeAuthorizationActivity.this,"Success",FBToast.LENGTH_SHORT);
                           finish();
                           startActivity(new Intent(EmployeeAuthorizationActivity.this,EmployeeCreatePasswordActivity.class));
                        }
                        else
                        {
                            mInputEmployeeEmailID.setError("Required");

                        }
                    }
                    else {
                        mInputEmployeeFullNameOrId.setError("Required");
                    }
                }
            }
        });
    }
}
