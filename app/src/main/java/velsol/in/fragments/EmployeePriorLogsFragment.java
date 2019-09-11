package velsol.in.fragments;


import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import velsol.in.R;
import velsol.in.adapters.EmployeePriorLogsAdapter;
import velsol.in.models.EmployeePriorLogsResponse;

/**
 * A simple {@link Fragment} subclass.
 */
public class EmployeePriorLogsFragment extends Fragment {
    RecyclerView mRecycleEmployeePriorLogsList;
    List<EmployeePriorLogsResponse> employeePriorLogsResponseList;
    EmployeePriorLogsAdapter adapter;
    ProgressDialog pd;


    public EmployeePriorLogsFragment() {
        // Required empty public constructor
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_employee_prior_logs, container, false);
        initViews(v);
        getPriorLogsList();
        return v;
    }
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void initViews(View v)
    {
        employeePriorLogsResponseList=new ArrayList<>();
        mRecycleEmployeePriorLogsList=(RecyclerView)v.findViewById(R.id.employee_prior_logs_list);
        pd=new ProgressDialog(getActivity());
        pd.setTitle("Please Wait");
        pd.setMessage("!..............!");
        pd.create();
    }
    private void getPriorLogsList()
    {
        pd.show();
        employeePriorLogsResponseList.add(new EmployeePriorLogsResponse("Kumar Reddy","23/08/2019 2:10PM","Awaiting"));
        employeePriorLogsResponseList.add(new EmployeePriorLogsResponse("Kumar Reddy","23/08/2019 2:10PM","Awaiting"));
        employeePriorLogsResponseList.add(new EmployeePriorLogsResponse("Kumar Reddy","23/08/2019 2:10PM","Awaiting"));
        employeePriorLogsResponseList.add(new EmployeePriorLogsResponse("Kumar Reddy","23/08/2019 2:10PM","Awaiting"));
        employeePriorLogsResponseList.add(new EmployeePriorLogsResponse("Kumar Reddy","23/08/2019 2:10PM","Awaiting"));
        employeePriorLogsResponseList.add(new EmployeePriorLogsResponse("Kumar Reddy","23/08/2019 2:10PM","Awaiting"));
        employeePriorLogsResponseList.add(new EmployeePriorLogsResponse("Kumar Reddy","23/08/2019 2:10PM","Awaiting"));
        employeePriorLogsResponseList.add(new EmployeePriorLogsResponse("Kumar Reddy","23/08/2019 2:10PM","Awaiting"));
        employeePriorLogsResponseList.add(new EmployeePriorLogsResponse("Kumar Reddy","23/08/2019 2:10PM","Awaiting"));
        employeePriorLogsResponseList.add(new EmployeePriorLogsResponse("Kumar Reddy","23/08/2019 2:10PM","Awaiting"));
        employeePriorLogsResponseList.add(new EmployeePriorLogsResponse("Kumar Reddy","23/08/2019 2:10PM","Awaiting"));
        adapter=new EmployeePriorLogsAdapter(getActivity(),employeePriorLogsResponseList);
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        mRecycleEmployeePriorLogsList.setLayoutManager(llm);
        mRecycleEmployeePriorLogsList.addItemDecoration(new DividerItemDecoration(mRecycleEmployeePriorLogsList.getContext(), DividerItemDecoration.VERTICAL));
        mRecycleEmployeePriorLogsList.setAdapter(adapter);
        pd.dismiss();
    }


}
