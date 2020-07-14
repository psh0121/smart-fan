package com.example.smartfan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

class SettingsAdapter extends ArrayAdapter implements AdapterView.OnItemClickListener {

    private Context context;
    private List list;

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(context, "clicked", Toast.LENGTH_SHORT).show();
    }

    class ViewHolder {
        public TextView tv_title;
        public TextView tv_description;
        public ImageView iv_icon;
    }

    public SettingsAdapter(Context context, ArrayList list){
        super(context, 0, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null){
            LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
            convertView = layoutInflater.inflate(R.layout.row_item, parent, false);
        }

        viewHolder = new ViewHolder();
        viewHolder.tv_title = (TextView) convertView.findViewById(R.id.textView_title);
        viewHolder.tv_description = (TextView) convertView.findViewById(R.id.textView_description);
        viewHolder.iv_icon = (ImageView) convertView.findViewById(R.id.imageView_icon);

        final Setting setting = (Setting) list.get(position);
        viewHolder.tv_title.setText(setting.getTitle());
        viewHolder.tv_description.setText(setting.getDescription());
        Glide
                .with(context)
                .load(setting.getIcon())
                .centerCrop()
                .apply(new RequestOptions().override(100, 100))
                .into(viewHolder.iv_icon);
        viewHolder.tv_title.setTag(setting.getTitle());


//        //아이템 클릭 방법2 - 클릭시 아이템 반전 효과가 안 먹힘
//        convertView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(context, " " + actor.getName(), Toast.LENGTH_SHORT).show();
//            }
//        });

        //Return the completed view to render on screen
        return convertView;
    }
}

