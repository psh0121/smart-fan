package com.example.smartfan;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class SettingsFragment extends Fragment {


    ArrayList<Actor> actors;
    ListView customListView;
    private static CustomAdapter customAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_settings, container, false);

        //data를 가져와서 어답터와 연결해 준다. 서버에서 가져오는게 대부분 이다.
        actors = new ArrayList<>();
        actors.add(new Actor("Number One", R.drawable.android, "number 1"));
        actors.add(new Actor("Number Two", R.drawable.android, "number 2"));
        actors.add(new Actor("Number Three", R.drawable.android, "number 3"));
        actors.add(new Actor("Number Four", R.drawable.android, "number 4"));
        actors.add(new Actor("Number Five", R.drawable.android, "number 5"));

        customListView = (ListView) rootView.findViewById(R.id.listView_custom);
        customAdapter = new CustomAdapter(getContext(),actors);
        customListView.setAdapter(customAdapter);
        customListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long l) {
                //각 아이템을 분간 할 수 있는 position과 뷰
                String selectedItem = (String) view.findViewById(R.id.textView_name).getTag().toString();
                Toast.makeText(getContext(), "Clicked: " + position +" " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }
}


//data class
class Actor {
    private String name;
    private String summary;
    private Integer thumb_url;

    public Actor(String name, Integer thumb_url, String summary) {
        this.name = name;
        this.summary = summary;
        this.thumb_url = thumb_url;
    }

    public String getName() {
        return name;
    }

    public String getSummary() {
        return summary;
    }

    public Integer getThumb_url() {
        return thumb_url;
    }
}
