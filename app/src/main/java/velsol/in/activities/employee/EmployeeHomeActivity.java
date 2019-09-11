package velsol.in.activities.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import velsol.in.R;
import velsol.in.adapters.CustomViewPagerAdapter;
import velsol.in.fragments.EmployeeCancelledLogsFragment;
import velsol.in.fragments.EmployeePriorLogsFragment;
import velsol.in.fragments.EmployeeRescheduleLogsFragment;

public class EmployeeHomeActivity extends AppCompatActivity {
    FloatingActionButton mFABAdInvtieeDeatils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employee_home);
        getSupportActionBar().hide();
        mFABAdInvtieeDeatils=(FloatingActionButton)findViewById(R.id.add_invitee_details);

        mFABAdInvtieeDeatils.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                startActivity(new Intent(EmployeeHomeActivity.this,AddInviteeAppointmentActivity.class));
            }
        });
        ViewPager viewPager = (ViewPager) findViewById(R.id.naming_screen_viewpager);
        CustomViewPagerAdapter adapter=new CustomViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new EmployeePriorLogsFragment(),"PRIOR LOGS ( 35 )");
        adapter.addFragment(new EmployeeCancelledLogsFragment(),"CANCELLED (9)");
        adapter.addFragment(new EmployeeRescheduleLogsFragment(),"Reschedule ( 1 )");
        viewPager.setAdapter(adapter);
        TabLayout  tabLayout = (TabLayout) findViewById(R.id.naming_tabs_home_layout);
        tabLayout.setupWithViewPager(viewPager);
        getFragmentManager().beginTransaction();

    }

}
