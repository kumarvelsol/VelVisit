package velsol.in.activities.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import com.ebanx.swipebtn.OnActiveListener;
import com.ebanx.swipebtn.SwipeButton;
import com.google.android.material.textfield.TextInputEditText;
import com.tfb.fbtoast.FBToast;

import java.util.ArrayList;
import java.util.List;

import velsol.in.R;
import velsol.in.adapters.PurposeListRecycleAdapter;
import velsol.in.models.PurposeModel;
import velsol.in.preferences.ApplicationPreferences;

public class AddInviteeAppointmentActivity extends AppCompatActivity {
    SwipeButton mSwipeBtn;
    List<PurposeModel> purposeModels;
    RecyclerView mRecyclePurposeList;
    TextInputEditText mInputInviteeName,mInputInviteeEmail,mInputInviteeMobile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_invitee_appointment);
        getSupportActionBar().hide();
        initViews();
        getPurposes();
    }

    private void initViews()
    {
        mSwipeBtn=(SwipeButton)findViewById(R.id.swipe_btn);
        mInputInviteeName=(TextInputEditText)findViewById(R.id.add_invitee_appointment_label_invitee_name);
        mInputInviteeEmail=(TextInputEditText)findViewById(R.id.add_invitee_appointment_label_invitee_email);
        mInputInviteeMobile=(TextInputEditText)findViewById(R.id.add_invitee_appointment_label_invitee_mobile);
        purposeModels=new ArrayList<>();
        mRecyclePurposeList=(RecyclerView)findViewById(R.id.purposes_recycle_list);

        mSwipeBtn.setOnActiveListener(new OnActiveListener() {
            @Override
            public void onActive() {

                if (mInputInviteeName.getText().toString().trim().equals(""))
                {
                    mInputInviteeName.setError("Required");
                    mInputInviteeName.requestFocus();

                }
                else if (mInputInviteeEmail.getText().toString().trim().equals(""))
                {
                    mInputInviteeEmail.setError("Required");
                    mInputInviteeEmail.requestFocus();
                }
                else if (!mInputInviteeEmail.getText().toString().trim().contains("@"))
                {
                    mInputInviteeEmail.setError("Vali Email Required");
                    mInputInviteeEmail.requestFocus();
                }
                else if (mInputInviteeMobile.getText().toString().trim().equals(""))
                {
                    mInputInviteeMobile.setError("Required");
                    mInputInviteeMobile.requestFocus();
                }
                else {
                    FBToast.successToast(AddInviteeAppointmentActivity.this,"Thankyou",FBToast.LENGTH_SHORT);
                    mSwipeBtn.setHasActivationState(false);
                    finish();
                    Intent i=new Intent(AddInviteeAppointmentActivity.this,AddInviteeAppointmentActivity.class);
                    i.putExtra(ApplicationPreferences.APPOINTMENT_NAME,mInputInviteeName.getText().toString().trim());
                    i.putExtra(ApplicationPreferences.APPOINTMENT_EMAIL,mInputInviteeEmail.getText().toString().trim());
                    i.putExtra(ApplicationPreferences.APPOINTMENT_MOBILE,mInputInviteeMobile.getText().toString().trim());
                    i.putExtra(ApplicationPreferences.APPOINTMENT_PURPOSE,"Purpose");
                    startActivity(i);
                }
            }
        });
    }

    private void getPurposes()
    {
        purposeModels.add(new PurposeModel("Business"));
        purposeModels.add(new PurposeModel("Interview"));
        purposeModels.add(new PurposeModel("Sales"));
        purposeModels.add(new PurposeModel("Logistics"));
        purposeModels.add(new PurposeModel("Meeting"));
        LinearLayoutManager horizontalLayoutManager = new LinearLayoutManager(AddInviteeAppointmentActivity.this, LinearLayoutManager.HORIZONTAL, false);
        mRecyclePurposeList.setLayoutManager(horizontalLayoutManager);
        mRecyclePurposeList.setAdapter(new PurposeListRecycleAdapter(this,purposeModels));
    }
}
