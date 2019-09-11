package velsol.in.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import velsol.in.R;
import velsol.in.models.PurposeModel;

public class PurposeListRecycleAdapter extends RecyclerView.Adapter <PurposeListRecycleAdapter.PurposeListRecycleHolder>{

    Context mCtx;
    List<PurposeModel> purposeModels;
    TextView mLabelPurposeName;
    ImageView mImagePurposeImage;

    public PurposeListRecycleAdapter(Context mCtx, List<PurposeModel> purposeModels) {
        this.mCtx = mCtx;
        this.purposeModels = purposeModels;
    }
    public class PurposeListRecycleHolder extends RecyclerView.ViewHolder
    {
        public PurposeListRecycleHolder(@NonNull View itemView) {
            super(itemView);

            mLabelPurposeName=(TextView)itemView.findViewById(R.id.purpose_text);
            mImagePurposeImage=(ImageView) itemView.findViewById(R.id.purpose_image);
        }
    }
    @NonNull
    @Override
    public PurposeListRecycleHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        return new PurposeListRecycleHolder(LayoutInflater.from(mCtx).inflate(R.layout.purpose_selection_layout,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull PurposeListRecycleHolder holder, int position)
    {
        mLabelPurposeName.setText(purposeModels.get(position).getPurposeName());
    }

    @Override
    public int getItemCount() {
        return purposeModels.size();
    }


}
