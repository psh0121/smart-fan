package com.example.smartfan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Settings_Advice_VersionsAdapter extends RecyclerView.Adapter<Settings_Advice_VersionsAdapter.VersionVH> {
    //VersionVH = Version Holder class name

    List<Settings_Advice_Versions> versionsList;

    public Settings_Advice_VersionsAdapter(List<Settings_Advice_Versions> versionsList) {
        this.versionsList = versionsList;
    }

    @NonNull
    @Override
    public VersionVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.settings_advice_row, parent, false);
        return new VersionVH(view);

    }

    @Override
    public void onBindViewHolder(@NonNull VersionVH holder, int position) {

        Settings_Advice_Versions versions = versionsList.get(position);
        holder.codeNameTxt.setText(versions.getCodeName());
        holder.versionTxt.setText(versions.getVersion());
        holder.descriptionTxt.setText(versions.getDescription());

        boolean isExpandable = versionsList.get(position).isExpandable();
        holder.expandableLayout.setVisibility(isExpandable ? View.VISIBLE : View.GONE);

    }

    @Override
    public int getItemCount() {
        return versionsList.size();
    }

    public class VersionVH extends RecyclerView.ViewHolder {

        TextView codeNameTxt, versionTxt, descriptionTxt;
        LinearLayout linearLayout;
        RelativeLayout expandableLayout;

        public VersionVH(@NonNull View itemView) {
            super(itemView);

            codeNameTxt = itemView.findViewById(R.id.settings_codename);
            versionTxt = itemView.findViewById(R.id.settings_version);
            descriptionTxt = itemView.findViewById(R.id.settings_description);

            linearLayout = itemView.findViewById(R.id.settings_linearlayout);
            expandableLayout = itemView.findViewById(R.id.settings_expandablelayout);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Settings_Advice_Versions versions = versionsList.get(getAdapterPosition());
                    versions.setExpandable(!versions.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });

        }
    }



}
