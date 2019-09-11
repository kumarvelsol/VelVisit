package velsol.in.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import velsol.in.R;
import velsol.in.models.EmployeePriorLogsResponse;

public class EmployeePriorLogsAdapter extends RecyclerView.Adapter<EmployeePriorLogsAdapter.EmployeePriorLogsHolder>
{
    Context mCtx;
    List<EmployeePriorLogsResponse> employeePriorLogsResponseList;

    TextView mLabelInviteeName,mLabelInviteScheduledOn,mLabelInviteStatus,mLabelReschedule,mLabelCancel;

    public EmployeePriorLogsAdapter(Context mCtx, List<EmployeePriorLogsResponse> employeePriorLogsResponseList)
    {
        this.mCtx = mCtx;
        this.employeePriorLogsResponseList = employeePriorLogsResponseList;
    }

    public class EmployeePriorLogsHolder extends RecyclerView.ViewHolder
    {

        public EmployeePriorLogsHolder(@NonNull View itemView) {
            super(itemView);
            mLabelInviteeName=(TextView)itemView.findViewById(R.id.employee_prio_logs_item_layout_label_invitee_name);
            mLabelInviteScheduledOn=(TextView)itemView.findViewById(R.id.employee_prio_logs_item_layout_label_scheduled_on);
            mLabelInviteStatus=(TextView)itemView.findViewById(R.id.employee_prio_logs_item_layout_label_status);
            mLabelReschedule=(TextView)itemView.findViewById(R.id.employee_prio_logs_item_layout_label_reschedule);
            mLabelCancel=(TextView)itemView.findViewById(R.id.employee_prio_logs_item_layout_label_cancel);
        }
    }
    @NonNull
    @Override
    public EmployeePriorLogsHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new EmployeePriorLogsHolder(LayoutInflater.from(mCtx).inflate(R.layout.employee_prior_logs_recycle_item,null));
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeePriorLogsHolder holder, int position) {
        mLabelInviteeName.setText(employeePriorLogsResponseList.get(position).getInviteeName());
        mLabelInviteScheduledOn.setText(employeePriorLogsResponseList.get(position).getInviteeShceduledOn());
        mLabelInviteStatus.setText(employeePriorLogsResponseList.get(position).getInviteStatus());
    }

    @Override
    public int getItemCount() {
        return employeePriorLogsResponseList.size();
    }


}
